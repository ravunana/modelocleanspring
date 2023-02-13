package com.ravunana.modelo.infrastructure.configuration;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = PostgresSQLConfiguration.class)
public class PostgresSQLConfiguration {
}
