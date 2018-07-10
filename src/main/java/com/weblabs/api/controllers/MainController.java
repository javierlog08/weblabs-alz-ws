package com.weblabs.api.controllers;


import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weblabs.api.mmsql.models.ClientModel;
import com.weblabs.api.models.BookModel;
import com.weblabs.api.models.FooModel;
import com.weblabs.api.repositories.FooRepository;
import com.weblabs.api.services.BookService;
import com.weblabs.api.services.ClientService;
import com.weblabs.api.services.SessionService;

@RestController
public class MainController {
	
	@Autowired
	private FooRepository fooRepository;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	SessionService sessionService;

	@RequestMapping("/")
	@CrossOrigin
	String index() {
		return "Welcome to API Base project.";
	}
	
	
	@RequestMapping("/foo")
	@CrossOrigin
	Iterable<FooModel> foo() {
		Iterable<FooModel> i = fooRepository.findAll();
		
		return i;
	}
	
	/**
	 * Login method created to share auth token generated by Spring Session 1.3.3, Is necesary use CrossOrigin anotation with exposeHeaders in CORS requests.
	 * @param response
	 * @return
	 */
	@RequestMapping("/login")
	@CrossOrigin(maxAge = 3600,exposedHeaders="x-auth-token")
	String login(HttpServletRequest request) {
		request.getSession().setMaxInactiveInterval(900); // 15 minutes default session expiration
		return "Success Login.";
	}
	
	
	/**
	 * Method used to logout and destroy current session using the token in the requet header
	 * @param request
	 * @return
	 */
	@RequestMapping("/logout")
	@CrossOrigin(maxAge = 3600,exposedHeaders="x-auth-token")
	String logout(HttpServletRequest request) {
		String token = request.getHeader("x-auth-token");
		sessionService.delete(token);
		return "Success Logout.";
	}
	
	@RequestMapping("/books")
	Iterable<BookModel> books() {
		return bookService.list();
	}
	
	@RequestMapping("/clients")
	Iterable<ClientModel> clients() {
		return clientService.all();
	}
}
