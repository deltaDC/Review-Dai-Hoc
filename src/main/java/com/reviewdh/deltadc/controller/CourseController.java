package com.reviewdh.deltadc.controller;

import com.reviewdh.deltadc.model.entities.Course;
import com.reviewdh.deltadc.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/course")
public class CourseController extends BaseController<Course>{

    public CourseController(BaseService<Course> service) {
        super(service);
    }

}
