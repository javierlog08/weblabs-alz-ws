package com.weblabs.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weblabs.api.mmsql.models.ClientModel;
import com.weblabs.api.mmsql.repositories.ClientsRepository;

@Service
public class ClientService {

	@Autowired
	ClientsRepository clients_repo;
	
	public Iterable<ClientModel> all() {
		return clients_repo.findAll();
	}
}
