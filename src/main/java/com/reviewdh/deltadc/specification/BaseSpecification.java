package com.reviewdh.deltadc.specification;

import com.reviewdh.deltadc.model.entities.User;
import jakarta.persistence.criteria.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BaseSpecification {

    public static <T> Specification<T> withDynamicQuery(Object criteria) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (criteria != null) {
                Field[] fields = criteria.getClass().getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    try {
                        Object value = field.get(criteria);
                        if (value != null) {
                            predicates.add(criteriaBuilder.like(root.get(field.getName()), "%" + value + "%"));
                        }
                    } catch (IllegalAccessException e) {
                        // Handle exception appropriately
                    }
                }
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }


}