package com.reviewdh.deltadc.controller;

import com.reviewdh.deltadc.model.entities.University;
import com.reviewdh.deltadc.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/university")
public class UniversityController extends BaseController<University> {

    public UniversityController(BaseService<University> service) {
        super(service);
    }

}
