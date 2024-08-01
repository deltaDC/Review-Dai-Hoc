package com.reviewdh.deltadc.specification;

import jakarta.persistence.criteria.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BaseSpecification<T> {

    @SafeVarargs
    public static <T> Specification<T> withDynamicQuery(T... criteriaFilters) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            for (T filter : criteriaFilters) {
                if (filter != null) {
                    Field[] fields = filter.getClass().getDeclaredFields();
                    for (Field field : fields) {
                        field.setAccessible(true);
                        try {
                            Object value = field.get(filter);
                            if (value != null) {
                                predicates.add(criteriaBuilder.like(root.get(field.getName()), "%" + value + "%"));
                            }
                        } catch (IllegalAccessException e) {
                            log.error(e.getLocalizedMessage());
                        }
                    }
                }
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}