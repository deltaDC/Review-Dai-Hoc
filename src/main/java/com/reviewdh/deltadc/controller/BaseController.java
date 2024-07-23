package com.reviewdh.deltadc.controller;

import com.reviewdh.deltadc.model.entities.BaseEntity;
import com.reviewdh.deltadc.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class BaseController<T extends BaseEntity> {

    private final BaseService<T> service;

    @GetMapping
    public List<T> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<T> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public T save(@RequestBody T entity) {
        System.out.println(entity);
        return service.save(entity);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
