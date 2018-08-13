package com.weblabs.api.mmsql.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.weblabs.api.mmsql.models.ClientModel;

public interface ClientsRepository extends CrudRepository<ClientModel, String> {
	
	@Query(value="SELECT * FROM weblabs_clientes ORDER BY CLIENTE OFFSET :start ROWS FETCH NEXT :end ROWS ONLY", nativeQuery = true)
	Iterable<ClientModel> getClients(@Param("start") int start, @Param("end")int end);
}
