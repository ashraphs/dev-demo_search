package com.example.search.exampledemosearch.configs;

import com.example.search.exampledemosearch.repositories.impl.MasterEntityRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(basePackages = {"com.example.search.exampledemosearch.repositories"}, repositoryBaseClass = MasterEntityRepositoryImpl.class)
public class AppConfig {

}
