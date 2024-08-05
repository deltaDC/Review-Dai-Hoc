package com.reviewdh.deltadc.service;

import com.reviewdh.deltadc.model.entities.BaseEntity;
import com.reviewdh.deltadc.repository.BaseRepository;
import com.reviewdh.deltadc.specification.BaseSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity> {
    BaseRepository<T> getRepository();

    default T save(T t) {
        return getRepository().save(t);
    }

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

    default Optional<T> findById(Long id) {
        return getRepository().findById(id);
    }

    default Optional<T> findByUUID(String uuid) {
        return getRepository().findByUuid(uuid);
    }

    default List<T> findAll() {
        return getRepository().findAll();
    }

    default Page<T> page(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return getRepository().findAll(pageable);
    }

    default void deleteById(Long id) {
        getRepository().deleteById(id);
    }

    default Page<T> list(int page, int size, String... params) {
        Specification<T> specification = BaseSpecification.withDynamicQuery(params);
        Pageable pageable = PageRequest.of(page, size);
        return getRepository().findAll(specification, pageable);
    }
}

