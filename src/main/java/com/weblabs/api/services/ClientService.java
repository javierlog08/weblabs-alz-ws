package com.weblabs.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.weblabs.api.mmsql.models.ClientModel;
import com.weblabs.api.mmsql.repositories.ClientsRepository;

@Service
public class ClientService {

	@Autowired
	ClientsRepository clients_repo;
	
	public Iterable<ClientModel> all(int start_page, int end_page) {
		
		return clients_repo.getClients(start_page, end_page);
	}

	public Iterable<ClientModel> findByTerm(String term) {
		return clients_repo.findByNombreCompletoContaining(term);
	}
}
