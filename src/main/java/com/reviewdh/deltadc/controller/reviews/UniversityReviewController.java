package com.reviewdh.deltadc.controller.reviews;

import com.reviewdh.deltadc.controller.BaseController;
import com.reviewdh.deltadc.model.entities.reviews.UniversityReview;
import com.reviewdh.deltadc.service.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/university-review")
public class UniversityReviewController extends BaseController<UniversityReview> {

    public UniversityReviewController(BaseService<UniversityReview> service) {
        super(service);
    }

}
