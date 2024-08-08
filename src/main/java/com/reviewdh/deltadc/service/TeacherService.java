package com.reviewdh.deltadc.service;

import com.reviewdh.deltadc.model.entities.Teacher;
import com.reviewdh.deltadc.repository.BaseRepository;
import com.reviewdh.deltadc.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherService implements BaseService<Teacher> {

    private final TeacherRepository teacherRepository;

    @Override
    public BaseRepository<Teacher> getRepository() {
        return teacherRepository;
    }

    @Override
    public Class<Teacher> getEntityClass() {
        return Teacher.class;
    }
}
