package com.reviewdh.deltadc.service;

import com.reviewdh.deltadc.model.entities.BaseEntity;
import com.reviewdh.deltadc.model.entities.reviews.BaseReview;
import com.reviewdh.deltadc.repository.BaseRepository;
import com.reviewdh.deltadc.specification.BaseSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BaseService<T extends BaseEntity> {
    BaseRepository<T> getRepository();
    Class<T> getEntityClass();

    @Transactional
    default T save(T t) {
        return getRepository().save(t);
    }

    @Transactional
    @PreAuthorize(
            "hasRole('ROLE_ADMIN') " +
            "or hasRole('ROLE_DEVELOPER') " +
            "or @authorizeService.isOwner(#id, updatedEntity.getClass().getSimpleName())"
    )
    default Optional<T> update(Long id, T updatedEntity) {
        Optional<T> existingEntityOpt = getRepository().findById(id);
        if(existingEntityOpt.isEmpty()) return Optional.empty();

        // patch update the entity
        T existingEntity = existingEntityOpt.get();
        for (Field field : updatedEntity.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(updatedEntity);
                if (value != null) {
                    field.set(existingEntity, value);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Failed to update field: " + field.getName(), e);
            }
        }
        return Optional.of(getRepository().save(existingEntity));
    }

    @Transactional(readOnly = true)
    default Optional<T> findById(Long id) {
        return getRepository().findById(id);
    }

    @Transactional(readOnly = true)
    default Optional<T> findByUUID(String uuid) {
        return getRepository().findByUuid(uuid);
    }

    @Transactional(readOnly = true)
    default List<T> findAll() {
        return getRepository().findAll();
    }

    @Transactional
    default void deleteById(Long id) {
        getRepository().deleteById(id);
    }

    @Transactional(readOnly = true)
    default Page<T> list(int page, int size, Map<String, String> params) {
        Specification<T> specification = BaseSpecification.withDynamicQuery(params, getEntityClass());
        Pageable pageable = PageRequest.of(page, size);
        return getRepository().findAll(specification, pageable);
    }
}

