package com.reviewdh.deltadc.config;

import com.reviewdh.deltadc.repository.BaseRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.reviewdh.deltadc.repository")
public class JpaConfig {
}
