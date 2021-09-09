package com.library.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringJdbcConfig {

    @Value("${spring.db.username}")
    String username;

    @Value("${spring.db.password}")
    String password;

    @Value("${spring.db.name}")
    String dbName;

    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/" + dbName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}