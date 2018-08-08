package com.weblabs.api.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
@EnableJpaRepositories(basePackages="com.weblabs.api.repositories", entityManagerFactoryRef = "entityManagerFactory") 
@Configuration
public class PostgresqlConfig {
	
	@Bean
	@Primary
	@ConfigurationProperties("postgresql.datasource")
	public DataSourceProperties postgresqlDataSourceProperties()  {
		return new DataSourceProperties();
	}
	
	/***
	 * we are setting postgres datasource as primary database engine, if you want to add another one you must to create a new configuration file.
	 * @link https://docs.spring.io/spring-boot/docs/2.0.2.RELEASE/reference/htmlsingle/#howto-two-datasources
	 * @return
	 */
	@Bean
	@Primary
	public DataSource postgresqlDataSource() {
		return postgresqlDataSourceProperties().initializeDataSourceBuilder().build();
	}
	
	
	/**
	 * If you are goint to use multiple datasources you need also specify entityManagerFactory , just to say the package of the models this datasource affect.
	 * @link https://docs.spring.io/spring-boot/docs/2.0.2.RELEASE/reference/htmlsingle/#howto-use-custom-entity-manager
	 * @param builder
	 * @return
	 */
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(postgresqlDataSource())
				.packages("com.weblabs.api.models")
				.build();
	}
}
