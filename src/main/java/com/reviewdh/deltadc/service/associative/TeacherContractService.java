package com.reviewdh.deltadc.service.associative;

import com.reviewdh.deltadc.model.entities.associative.TeacherContract;
import com.reviewdh.deltadc.repository.BaseRepository;
import com.reviewdh.deltadc.repository.associative.TeacherContractRepository;
import com.reviewdh.deltadc.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherContractService implements BaseService<TeacherContract> {

    private final TeacherContractRepository teacherContractRepository;

    @Override
    public BaseRepository<TeacherContract> getRepository() {
        return teacherContractRepository;
    }
}
