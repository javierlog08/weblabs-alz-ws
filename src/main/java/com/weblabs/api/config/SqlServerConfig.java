package com.weblabs.api.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@EnableJpaRepositories(basePackages="com.weblabs.api.mmsql.repositories", entityManagerFactoryRef = "mmsqlEntityManagerFactory") 
@Configuration
public class SqlServerConfig {
	
	@Bean
	@ConfigurationProperties(prefix="mmsql.datasource")
	public DataSourceProperties mmsqlDataSourceProperties() {
		return new DataSourceProperties();
	}

	
	@Bean
	@ConfigurationProperties(prefix="mmsql.datasource")
	public DataSource mmsqlDatasource() {
		return mmsqlDataSourceProperties().initializeDataSourceBuilder().build();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean mmsqlEntityManagerFactory(
			EntityManagerFactoryBuilder builder) {
		return builder
				.dataSource(mmsqlDatasource())
				.packages("com.weblabs.api.mmsql.models")
				.build();
	}


}
