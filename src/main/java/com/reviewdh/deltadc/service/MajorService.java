package com.reviewdh.deltadc.service;

import com.reviewdh.deltadc.model.entities.Major;
import com.reviewdh.deltadc.repository.BaseRepository;
import com.reviewdh.deltadc.repository.MajorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MajorService implements BaseService<Major> {

    private final MajorRepository majorRepository;

    @Override
    public BaseRepository<Major> getRepository() {
        return majorRepository;
    }

    @Override
    public Class<Major> getEntityClass() {
        return Major.class;
    }
}
