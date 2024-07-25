package com.reviewdh.deltadc.controller.reviews;

import com.reviewdh.deltadc.controller.BaseController;
import com.reviewdh.deltadc.model.entities.reviews.MajorReview;
import com.reviewdh.deltadc.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/major-review")
public class MajorReviewController extends BaseController<MajorReview> {

    public MajorReviewController(BaseService<MajorReview> service) {
        super(service);
    }

}
