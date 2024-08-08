package com.reviewdh.deltadc.specification;

import jakarta.persistence.criteria.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class BaseSpecification {

    public static <T> Specification<T> withDynamicQuery(Map<String, String> criteria, Class<T> entityClass) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (criteria != null) {
                criteria.forEach((key, value) -> {
                    try {
                        Field field = entityClass.getDeclaredField(key);
                        field.setAccessible(true);
                        predicates.add(criteriaBuilder.like(root.get(field.getName()), "%" + value + "%"));
                    } catch (NoSuchFieldException e) {
                        log.error("Field not found: {}", key);
                    }
                });
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }


}