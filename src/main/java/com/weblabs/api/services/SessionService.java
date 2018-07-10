package com.weblabs.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.ExpiringSession;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Service;

@Service
public class SessionService <S extends ExpiringSession> {
	
	/**
	 * Using session respository, please refer to Spring Session docs 1.3.3
	 * @url https://docs.spring.io/spring-session/docs/1.3.3.RELEASE/reference/html5/#api-expiringsession
	 */
	@Autowired
	private SessionRepository<S> sessionRepository;
	
	
	
	/**
	 * Used to delete one session from the x-auth-token
	 * @param token
	 */
	public void delete(String token) {
		this.sessionRepository.delete(token);
	}

}
