package com.weblabs.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

/**
 * Followed this tutorial ->https://docs.spring.io/spring-session/docs/1.3.2.RELEASE/reference/html5/guides/rest.html
 * We are using httpSession strategy on this project to token based authentication, see Spring Session project.
 * @author Javier
 *
 */
@Configuration
@EnableJdbcHttpSession 
public class HttpSessionConfig {
	
	@Bean
    public HttpSessionStrategy httpSessionStrategy() {
            return new HeaderHttpSessionStrategy(); 
    }
	
}
