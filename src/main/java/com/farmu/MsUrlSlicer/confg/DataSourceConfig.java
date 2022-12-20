package com.farmu.MsUrlSlicer.confg;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class DataSourceConfig {
    
    @Bean(name = "dsUrlSlicer")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSourceOne() {
        return DataSourceBuilder.create().build();
    }
    
    @Primary
    @Bean(name = "JdbcTemplateUrlSlicer")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier("dsUrlSlicer") DataSource ds) {
        return new NamedParameterJdbcTemplate(ds);
    }
    
}