package com.reviewdh.deltadc.service;

import com.reviewdh.deltadc.model.entities.BaseEntity;
import com.reviewdh.deltadc.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity> {
    BaseRepository<T> getRepository();

    default T save(T t) {
        return getRepository().save(t);
    }

    default Optional<T> update(Long id, T t) {
        if (getRepository().existsById(t.getId())) {
            return Optional.of(getRepository().save(t));
        }
        return Optional.empty();
    }

    default Optional<T> findById(Long id) {
        return getRepository().findById(id);
    }

    default List<T> findAll() {
        return getRepository().findAll();
    }

    default void deleteById(Long id) {
        getRepository().deleteById(id);
    }
}

