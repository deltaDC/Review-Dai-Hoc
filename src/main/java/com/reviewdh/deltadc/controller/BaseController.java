package com.reviewdh.deltadc.controller;

import com.reviewdh.deltadc.model.entities.BaseEntity;
import com.reviewdh.deltadc.response.BaseResponse;
import com.reviewdh.deltadc.service.BaseService;
import com.reviewdh.deltadc.validation.CreateGroup;
import com.reviewdh.deltadc.validation.UpdateGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class BaseController<T extends BaseEntity> {

    private final BaseService<T> service;

    @GetMapping
    public ResponseEntity<BaseResponse> findAll() {
        List<T> entities = service.findAll();

        return ResponseEntity.ok(
                BaseResponse.builder()
                        .status(HttpStatus.OK)
                        .message("Success")
                        .data(entities)
                        .build()
        );
    }

    @GetMapping("/page")
    public ResponseEntity<BaseResponse> page(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "10") int size) {
        Page<T> entities = service.page(page, size);

        return ResponseEntity.ok(
                BaseResponse.builder()
                        .status(HttpStatus.OK)
                        .message("Success")
                        .data(entities)
                        .build()
        );
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<BaseResponse> findByUUId(@PathVariable String uuid) {
        Optional<T> entity = service.findByUUID(uuid);

        return entity.map(ent -> ResponseEntity.ok(
                BaseResponse.builder()
                        .status(HttpStatus.OK)
                        .message("Success")
                        .data(ent)
                        .build()
        )).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<BaseResponse> findById(@PathVariable Long id) {
        Optional<T> entity = service.findById(id);

        return entity.map(ent -> ResponseEntity.ok(
                BaseResponse.builder()
                        .status(HttpStatus.OK)
                        .message("Success")
                        .data(ent)
                        .build()
        )).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BaseResponse> save(@Validated(CreateGroup.class) @RequestBody T entity) {
        T savedEntity = service.save(entity);

        return ResponseEntity.ok(
                BaseResponse.builder()
                        .status(HttpStatus.CREATED)
                        .message("Success")
                        .data(savedEntity)
                        .build()
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BaseResponse> update(@PathVariable Long id,
                              @Validated(UpdateGroup.class) @RequestBody T updatedEntity) {
        Optional<T> updatedOpt = service.update(id, updatedEntity);

        return updatedOpt.map(updated -> ResponseEntity.ok(
                BaseResponse.builder()
                        .status(HttpStatus.OK)
                        .message("Success")
                        .data(updated)
                        .build()
        )).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> deleteById(@PathVariable Long id) {
        service.deleteById(id);

        return ResponseEntity.ok(
                BaseResponse.builder()
                        .status(HttpStatus.OK)
                        .message("Success")
                        .build()
        );
    }
}
