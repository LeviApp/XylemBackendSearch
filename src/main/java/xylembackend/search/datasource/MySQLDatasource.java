package xylembackend.search.datasource;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySQLDatasource {

    @Bean
    @ConfigurationProperties("search.datasource")
    public HikariDataSource hikariDataSource() {
        return DataSourceBuilder
        .create()
        .type(HikariDataSource.class)
        .build();
    }
}