package com.reviewdh.deltadc.controller.associative;

import com.reviewdh.deltadc.controller.BaseController;
import com.reviewdh.deltadc.model.entities.associative.TeacherContract;
import com.reviewdh.deltadc.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teacher-contract")
public class TeacherContractController extends BaseController<TeacherContract> {

    public TeacherContractController(BaseService<TeacherContract> service) {
        super(service);
    }

}
