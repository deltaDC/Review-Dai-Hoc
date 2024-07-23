package com.reviewdh.deltadc.service;

import com.reviewdh.deltadc.model.entities.User;
import com.reviewdh.deltadc.repository.BaseRepository;
import com.reviewdh.deltadc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements BaseService<User> {

    private final UserRepository userRepository;

    @Override
    public BaseRepository<User> getRepository() {
        return userRepository;
    }
}
