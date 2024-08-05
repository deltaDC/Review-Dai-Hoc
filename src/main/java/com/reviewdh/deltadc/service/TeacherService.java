package com.reviewdh.deltadc.service;

import com.reviewdh.deltadc.model.criteria.TeacherCriteria;
import com.reviewdh.deltadc.model.entities.Teacher;
import com.reviewdh.deltadc.repository.BaseRepository;
import com.reviewdh.deltadc.repository.TeacherRepository;
import com.reviewdh.deltadc.specification.BaseSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherService implements BaseService<Teacher> {

    private final TeacherRepository teacherRepository;

    @Override
    public BaseRepository<Teacher> getRepository() {
        return teacherRepository;
    }

//    public Page<Teacher> list(String fullName, String email, String phoneNumber, int page, int size) {
//        Pageable pageable = PageRequest.of(page, size);
//
//        TeacherCriteria teacherCriteria = TeacherCriteria.builder()
//                .fullName(fullName)
//                .email(email)
//                .phoneNumber(phoneNumber)
//                .build();
//
//        Specification<Teacher> specification = BaseSpecification.withDynamicQuery(teacherCriteria);
//
//        return teacherRepository.findAll(specification, pageable);
//    }
}
