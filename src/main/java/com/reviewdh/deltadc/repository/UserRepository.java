package com.reviewdh.deltadc.repository;

import com.reviewdh.deltadc.model.entities.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {
    Optional<User> findByEmail(String username);
}
