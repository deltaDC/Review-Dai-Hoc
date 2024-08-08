package com.reviewdh.deltadc.service.reviews;

import com.reviewdh.deltadc.model.entities.reviews.UniversityReview;
import com.reviewdh.deltadc.repository.BaseRepository;
import com.reviewdh.deltadc.repository.reviews.UniversityReviewRepository;
import com.reviewdh.deltadc.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UniversityReviewService implements BaseService<UniversityReview> {

    private final UniversityReviewRepository universityReviewRepository;

    @Override
    public BaseRepository<UniversityReview> getRepository() {
        return universityReviewRepository;
    }

    @Override
    public Class<UniversityReview> getEntityClass() {
        return UniversityReview.class;
    }
}
