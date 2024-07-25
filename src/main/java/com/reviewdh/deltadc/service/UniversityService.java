package com.reviewdh.deltadc.service;

import com.reviewdh.deltadc.model.entities.University;
import com.reviewdh.deltadc.repository.BaseRepository;
import com.reviewdh.deltadc.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UniversityService implements BaseService<University> {

    private final UniversityRepository universityRepository;

    @Override
    public BaseRepository<University> getRepository() {
        return universityRepository;
    }
}
