package com.weblabs.api.mmsql.repositories;

import org.springframework.data.repository.CrudRepository;

import com.weblabs.api.mmsql.models.ClientModel;

public interface ClientsRepository extends CrudRepository<ClientModel, String> {

}
