package com.reviewdh.deltadc.service;

import com.reviewdh.deltadc.model.entities.Course;
import com.reviewdh.deltadc.repository.BaseRepository;
import com.reviewdh.deltadc.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService implements BaseService<Course> {

    private final CourseRepository courseRepository;

    @Override
    public BaseRepository<Course> getRepository() {
        return courseRepository;
    }
}
