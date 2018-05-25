package com.weblabs.api.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;



/**
 * JPA wont detect repositories:
 * If you don't put @EnableRepositories on root package, for example com.weblabs.api, then you repositories wont be found by container scanner
 * so to get this work you need specify the package where yours repositories are...
 * @author Javier
 *
 */
@EnableJpaRepositories("com.weblabs.api.repositories") 
@Configuration
public class PostgresqlConfig {
	
	@Bean
	@Primary
	@FlywayDataSource
	@ConfigurationProperties(prefix="postgresql.datasource")
	public DataSourceProperties postgresqlDataSourceProperties() {
		return new DataSourceProperties();
	}

	
	@Bean
	@Primary
	@ConfigurationProperties(prefix="postgresql.datasource")
	public DataSource postgresqlDatasource() {
		return postgresqlDataSourceProperties().initializeDataSourceBuilder().build();
	}
	
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(postgresqlDatasource())
				.packages("com.weblabs.api.models")
				.build();
	}
}
