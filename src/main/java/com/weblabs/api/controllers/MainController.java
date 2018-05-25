package com.weblabs.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weblabs.api.mmsql.models.ClientModel;
import com.weblabs.api.models.BookModel;
import com.weblabs.api.models.FooModel;
import com.weblabs.api.repositories.FooRepository;
import com.weblabs.api.services.BookService;
import com.weblabs.api.services.ClientService;

@RestController
public class MainController {
	
	@Autowired
	private FooRepository fooRepository;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	ClientService clientService;
	
	@RequestMapping("/")
	String index() {
		return "Welcome to API Base project.";
	}
	
	@RequestMapping("/foo")
	Iterable<FooModel> foo() {
		Iterable<FooModel> i = fooRepository.findAll();
		
		return i;
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
