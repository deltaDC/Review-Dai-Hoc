package com.reviewdh.deltadc.controller;

import com.reviewdh.deltadc.model.entities.Teacher;
import com.reviewdh.deltadc.service.BaseService;
import com.reviewdh.deltadc.service.TeacherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController extends BaseController<Teacher>{

    public TeacherController(BaseService<Teacher> service, TeacherService teacherService) {
        super(service);
    }

}
