package com.summer.common.persistence;


import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

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

            field = names[names.length - 1];

            switch (op) {
                case EQ:
                    target.add(Restrictions.eq(field, value));
                    break;
                case LIKE:
                    target.add(Restrictions.like(field, "%" + value + "%"));
                    break;
                case GT:
                    target.add(Restrictions.gt(field, value));
                    break;
                case LT:
                    target.add(Restrictions.lt(field, value));
                    break;
            }
        }

        return criteria;
    }

}
