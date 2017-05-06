package com.drartisan.util;

import com.drartisan.repository.jpaUtils.Criteria;
import com.drartisan.repository.jpaUtils.Restrictions;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created by summer on 2017/5/2.
 */
public class ConditionUtil<T> {
    public Criteria<T> parseCondition(Criteria<T> criteria, HashMap<String, String> conditions){

        for(String key: conditions.keySet()){
            String[] condition = key.split("-");
            String field = condition[0];
            String compare = condition[1];
            String value = conditions.get(key);

            switch (compare){
                case "like":
                    criteria.add(Restrictions.like(field,value,true));
                    break;
                case "eq":
                    criteria.add(Restrictions.eq(field,value,true));
                    break;
                case "lt":
                    criteria.add(Restrictions.lt(field,value,true));
                    break;
                case "lte":
                    criteria.add(Restrictions.lte(field,value,true));
                    break;
                case "gt":
                    criteria.add(Restrictions.gt(field,value,true));
                    break;
                case "gte":
                    criteria.add(Restrictions.gte(field,value,true));
                    break;
                case "ne":
                    criteria.add(Restrictions.ne(field,value,true));
                    break;
                default:
                    break;
            }

        }
        return criteria;
    }

    public static Sort.Order getSortOrder(String order,String key){
        if("desc".equalsIgnoreCase(order)){
            return new Sort.Order(Sort.Direction.DESC,key);
        }else if("asc".equalsIgnoreCase(order)){
            return new Sort.Order(Sort.Direction.ASC,key);
        }else {
            return null;
        }
    }

}
