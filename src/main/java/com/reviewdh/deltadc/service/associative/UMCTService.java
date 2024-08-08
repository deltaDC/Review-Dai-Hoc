package com.reviewdh.deltadc.service.associative;

import com.reviewdh.deltadc.model.entities.associative.UMCT;
import com.reviewdh.deltadc.repository.BaseRepository;
import com.reviewdh.deltadc.repository.associative.UMCTRepository;
import com.reviewdh.deltadc.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UMCTService implements BaseService<UMCT> {

    private final UMCTRepository umctRepository;

    @Override
    public BaseRepository<UMCT> getRepository() {
        return umctRepository;
    }

    @Override
    public Class<UMCT> getEntityClass() {
        return UMCT.class;
    }
}
