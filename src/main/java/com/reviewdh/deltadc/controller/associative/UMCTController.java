package com.reviewdh.deltadc.controller.associative;

import com.reviewdh.deltadc.controller.BaseController;
import com.reviewdh.deltadc.model.entities.associative.UMCT;
import com.reviewdh.deltadc.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/umct")
public class UMCTController extends BaseController<UMCT> {

    public UMCTController(BaseService<UMCT> service) {
        super(service);
    }

}
