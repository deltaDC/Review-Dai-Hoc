package com.reviewdh.deltadc.controller;

import com.reviewdh.deltadc.model.entities.Major;
import com.reviewdh.deltadc.service.BaseService;
import com.reviewdh.deltadc.service.MajorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/major")
public class MajorController extends BaseController<Major>{

    public MajorController(BaseService<Major> service, MajorService majorService) {
        super(service);
    }

}
