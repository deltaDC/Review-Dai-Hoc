package com.reviewdh.deltadc.service;

import com.reviewdh.deltadc.model.criteria.UniversityCriteria;
import com.reviewdh.deltadc.model.entities.University;
import com.reviewdh.deltadc.repository.BaseRepository;
import com.reviewdh.deltadc.repository.UniversityRepository;
import com.reviewdh.deltadc.specification.BaseSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UniversityService implements BaseService<University> {

    private final UniversityRepository universityRepository;

    @Override
    public BaseRepository<University> getRepository() {
        return universityRepository;
    }

//    public Page<University> list(String name, String abbreviation, String location, int page, int size) {
//        Pageable pageable = PageRequest.of(page, size);
//
//        UniversityCriteria universityCriteria = UniversityCriteria.builder()
//                .name(name)
//                .abbreviation(abbreviation)
//                .location(location)
//                .build();
//
//        Specification<University> specification = BaseSpecification.withDynamicQuery(universityCriteria);
//
//        return universityRepository.findAll(specification, pageable);
//    }
}
