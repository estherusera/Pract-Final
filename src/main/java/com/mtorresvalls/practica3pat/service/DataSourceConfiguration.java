package com.mtorresvalls.practica3pat.service;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfiguration {

    @Bean
    public DataSource getDataSource(){
        return DataSourceBuilder.create().driverClassName("org.h2.Driver").url("jdbc:h2:mem:testdb").username("miguel").password("Miguel").build();
    }
}
