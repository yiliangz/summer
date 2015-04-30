package com.summer.common.persistence;


import com.summer.common.page.PageRequest;
import com.summer.common.page.Sort;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
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

    public static DetachedCriteria parse(List<SearchFilter> filters, Class entityClass) {
        DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
        for (SearchFilter filter : filters) {

            String field = filter.getField();
            Object value = filter.getValue();
            SearchFilter.Operator op = filter.getOperator();

            String[] names = StringUtils.split(field, ".");

            DetachedCriteria target = criteria;
            for (int i = 0; names != null && names.length > 1 && i < names.length - 1; i++) {
                target = target.createCriteria(names[i]);
            }

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

    public static DetachedCriteria parse(Map<String, String> searchParams, Class entityClass) {
        return parse(SearchFilter.parse(searchParams), entityClass);
    }

    public static DetachedCriteria parse(PageRequest request, Class entityClass) {
        return parse(request.getSearchParams(), entityClass);
    }

    /**
     * 支持关联查询的排序,example: player.team.name(按 队员的球队的名字 排序)
     * 1、首先在criteria的subcriteria里查找
     * 2、如果找到则用该criteria设置排序
     * 3、若在subcriteria找不到的话则创建subcriteria用以设置
     * */
    public static Criteria parsePageParams(Criteria criteria, PageRequest page) {
        criteria.setProjection(null);
        criteria.setFirstResult((int) (page.getPage() * page.getSize()));
        criteria.setMaxResults((int) page.getSize());

        for (Sort sort : (List<Sort>) page.getSorts()) {
            String field = sort.getField();
            String[] names = StringUtils.split(field, ".");
            Criteria target = criteria;
            if (names != null && names.length > 1) {
                String subcriteriaName = names[names.length - 2];
                Iterator<CriteriaImpl.Subcriteria> iterator = ((CriteriaImpl)target).iterateSubcriteria();
                while (iterator.hasNext()) {
                    CriteriaImpl.Subcriteria subcriteria = iterator.next();
                    if (subcriteria.getPath().equals(subcriteriaName)) {
                        target = subcriteria;
                        break;
                    }
                }
                if (!(target instanceof CriteriaImpl.Subcriteria)) {
                    for (int i = 0; names != null && names.length > 1 && i < names.length - 1; i++) {
                        target = target.createCriteria(names[i]);
                    }
                }
            }

            if (names != null) {
                field = names[names.length - 1];
            }
            target.addOrder(new Sort(field, sort.getOrder()).getHibernateOrder());
        }

        return criteria;
    }

}
