package com.reviewdh.deltadc.service;

import com.reviewdh.deltadc.model.criteria.MajorCriteria;
import com.reviewdh.deltadc.model.entities.Major;
import com.reviewdh.deltadc.model.entities.Teacher;
import com.reviewdh.deltadc.model.enums.DegreeType;
import com.reviewdh.deltadc.repository.BaseRepository;
import com.reviewdh.deltadc.repository.MajorRepository;
import com.reviewdh.deltadc.specification.BaseSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MajorService implements BaseService<Major> {

    private final MajorRepository majorRepository;

    @Override
    public BaseRepository<Major> getRepository() {
        return majorRepository;
    }

//    public Page<Major> list(String majorName, String majorCode, DegreeType degreeType, int page, int size) {
//        Pageable pageable = PageRequest.of(page, size);
//
//        MajorCriteria majorCriteria = MajorCriteria.builder()
//                .majorName(majorName)
//                .majorCode(majorCode)
//                .degreeType(degreeType)
//                .build();
//
//        Specification<Major> specification = BaseSpecification.withDynamicQuery(majorCriteria);
//
//        return majorRepository.findAll(specification, pageable);
//    }
}
