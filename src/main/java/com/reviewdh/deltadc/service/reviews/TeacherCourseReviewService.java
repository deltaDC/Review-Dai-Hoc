package com.reviewdh.deltadc.service.reviews;

import com.reviewdh.deltadc.model.entities.reviews.TeacherCourseReview;
import com.reviewdh.deltadc.repository.BaseRepository;
import com.reviewdh.deltadc.repository.reviews.TeacherCourseReviewRepository;
import com.reviewdh.deltadc.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherCourseReviewService implements BaseService<TeacherCourseReview> {

    private final TeacherCourseReviewRepository teacherCourseReviewRepository;

    @Override
    public BaseRepository<TeacherCourseReview> getRepository() {
        return teacherCourseReviewRepository;
    }
}
