package com.reviewdh.deltadc.mapper;


import com.reviewdh.deltadc.model.dtos.UserDto;
import com.reviewdh.deltadc.model.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto fromUserToUserDto(User user) {
        if (user == null) {
            return null;
        }
        return UserDto.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .build();
    }

    public Page<UserDto> fromUserPageToUserDtoPage(Page<User> userPage) {
        List<UserDto> userDtos = userPage.getContent().stream()
                .map(this::fromUserToUserDto)
                .collect(Collectors.toList());
        return new PageImpl<>(userDtos, userPage.getPageable(), userPage.getTotalElements());
    }

}
