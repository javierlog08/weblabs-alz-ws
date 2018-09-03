package com.weblabs.api.mmsql.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="weblabs_clientedireccion")
public class AddressModel {
	
	@Column(name="CLCOD")
	public String codigo_cliente;
	
	@Column(name="DIRECCION")
	@Id
	public String direccion;
}
