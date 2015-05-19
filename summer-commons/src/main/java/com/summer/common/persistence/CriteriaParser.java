package com.summer.common.persistence;


import com.summer.common.page.PageRequest;
import com.summer.common.page.Sort;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Allen on 2015/4/28.
 */
public class CriteriaParser {

    /**
     * 支持关联查询和排序,example: player.team.name(按 队员的球队的名字)
     * 1、首先在criteria的subcriteria里查找
     * 2、如果找到则用该subcriteria
     * 3、若在subcriteria找不到的话则创建subcriteria用以设置排序
     * @param filters      传进来的List<SearchFilter>,用以筛选结果集
     * @param entityClass  要查找的实体类
     * @return
     */
    public static Criteria parse(List<SearchFilter> filters, Class entityClass, Session session) {
        Criteria criteria = session.createCriteria(entityClass);

        for (SearchFilter filter : filters) {

            String field = filter.getField();
            Object value = filter.getValue();
            SearchFilter.Operator op = filter.getOperator();

            String[] names = StringUtils.split(field, ".");

            Criteria target = findOrCreateSubcriteria(criteria,names);

            if (names != null) {
                field = names[names.length - 1];
            }

            switch (op) {
                case LIKE:
                    target.add(Restrictions.like(field, "%" + value + "%"));
                    break;
                case GT:
                    target.add(Restrictions.gt(field, value));
                    break;
                case LT:
                    target.add(Restrictions.lt(field, value));
                    break;
                case GTE:
                    target.add(Restrictions.ge(field, value));
                    break;
                case LTE:
                    target.add(Restrictions.le(field, value));
                    break;
                default:
                    target.add(Restrictions.eq(field, value));
                    break;
            }
        }

        return criteria;
    }

    /**
     * @param searchParams  传进来的Map<String, String>,用以筛选结果集
     * @param entityClass   要查找的实体类
     * @param session       hibernate的session
     * @return
     */
    public static Criteria parse(Map<String, String> searchParams, Class entityClass, Session session) {
        return parse(SearchFilter.parse(searchParams), entityClass, session);
    }

    /**
     * @param request  传进来的PageRequest,用以筛选结果集
     * @param entityClass   要查找的实体类
     * @param session       hibernate的session
     * @return
     */
    public static Criteria parse(PageRequest request, Class entityClass, Session session) {
        return parse(request.getSearchParams(), entityClass, session);
    }

    /**
     * 给criteria设置页码和排序
     * @param criteria    criteria对象
     * @param page        PageRequest分页请求
     * @return
     */
    public static Criteria parsePageParams(Criteria criteria, PageRequest page) {
        criteria.setProjection(null);
        int firstResult = (int) (page.getPage() * page.getSize());
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(firstResult + (int) page.getSize() - 1);
        for (Sort sort : (List<Sort>) page.getSorts()) {
            String field = sort.getField();
            String[] names = StringUtils.split(field, ".");
            Criteria target = findOrCreateSubcriteria(criteria,names);
            if (names != null) {
                field = names[names.length - 1];
            }
            target.addOrder(new Sort(field, sort.getOrder()).getHibernateOrder());
        }

        return criteria;
    }

    /**
     * 从criteria的subcriteria查找
     * 1、若存在则返回对应的subcriteria
     * 2、若不存在则查找最接近它的父辈subcriteria并使用父辈创建对应的subcriteria
     * @param criteria
     * @param names
     * @return
     */
    public static Criteria findOrCreateSubcriteria(Criteria criteria, String[] names) {
        if (names != null && names.length > 1) {
            int index = names.length - 2;
            criteria = findSubcriteria(criteria, names, index);
            String path = getPath(criteria);
            if (path == null || !path.equals(names[index])) {
                // begin用以标识是否开始
                boolean begin = false;
                for (int i = 0; i < names.length - 1; i++) {
                    if (begin || path == null) {
                        criteria = criteria.createCriteria(names[i]);
                    }else if (path.equals(names[i])) {
                        begin = true;
                    }
                }
            }
        }
        return criteria;
    }

    /**
    * 查找subcriteria,找不到时则递归查找最接近它的父辈
    * @param criteria
    * @param names
    * @param index
    * @return Criteria
    */
    public static Criteria findSubcriteria(Criteria criteria, String[] names, int index) {
        String subcriteriaName = names[index];
        boolean isExists = false;
        Iterator<CriteriaImpl.Subcriteria> iterator = ((CriteriaImpl) criteria).iterateSubcriteria();
        while (iterator.hasNext()) {
            CriteriaImpl.Subcriteria subcriteria = iterator.next();
            if (subcriteria.getPath().equals(subcriteriaName)) {
                criteria = subcriteria;
                isExists = true;
                break;
            }
        }
        if (!isExists && index > 0) {
            return findSubcriteria(criteria, names, index - 1);
        } else {
            return criteria;
        }
    }

    /**
     * 若是subcriteria类型则返回它的path,否则返回null
     * @param criteria
     * @return Criteria
     */
    public static String getPath(Criteria criteria) {
        if (criteria instanceof CriteriaImpl) {
            return null;
        } else {
            return ((CriteriaImpl.Subcriteria) criteria).getPath();
        }
    }

}
