package com.reviewdh.deltadc.service.reviews;

import com.reviewdh.deltadc.model.entities.reviews.MajorReview;
import com.reviewdh.deltadc.repository.BaseRepository;
import com.reviewdh.deltadc.repository.reviews.MajorReviewRepository;
import com.reviewdh.deltadc.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MajorReviewService implements BaseService<MajorReview> {

    private final MajorReviewRepository majorReviewRepository;

    @Override
    public BaseRepository<MajorReview> getRepository() {
        return majorReviewRepository;
    }

    @Override
    public Class<MajorReview> getEntityClass() {
        return MajorReview.class;
    }
}
