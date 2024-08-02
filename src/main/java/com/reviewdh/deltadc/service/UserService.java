package com.reviewdh.deltadc.service;

import com.reviewdh.deltadc.mapper.UserMapper;
import com.reviewdh.deltadc.model.criteria.UserCriteria;
import com.reviewdh.deltadc.model.dtos.UserDto;
import com.reviewdh.deltadc.model.entities.User;
import com.reviewdh.deltadc.repository.BaseRepository;
import com.reviewdh.deltadc.repository.UserRepository;
import com.reviewdh.deltadc.specification.BaseSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements BaseService<User> {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public BaseRepository<User> getRepository() {
        return userRepository;
    }

    public Page<UserDto> list(@Nullable String username,
                              @Nullable String email,
                              @Nullable String firstName,
                              @Nullable String lastName,
                              @Nullable String phone,
                              @Nullable int page,
                              @Nullable int size) {
        Pageable pageable = PageRequest.of(page, size);

        UserCriteria userCriteria = UserCriteria.builder()
                .username(username)
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .phone(phone)
                .build();

        Specification<User> specification = BaseSpecification.withDynamicQuery(userCriteria);
        Page<User> userPage = userRepository.findAll(specification, pageable);

        return userMapper.fromUserPageToUserDtoPage(userPage);
    }
}
