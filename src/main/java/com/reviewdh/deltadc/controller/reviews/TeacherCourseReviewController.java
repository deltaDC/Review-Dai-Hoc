package com.reviewdh.deltadc.controller.reviews;

import com.reviewdh.deltadc.controller.BaseController;
import com.reviewdh.deltadc.model.entities.reviews.TeacherCourseReview;
import com.reviewdh.deltadc.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teacher-course-review")
public class TeacherCourseReviewController extends BaseController<TeacherCourseReview> {

    public TeacherCourseReviewController(BaseService<TeacherCourseReview> service) {
        super(service);
    }

}
