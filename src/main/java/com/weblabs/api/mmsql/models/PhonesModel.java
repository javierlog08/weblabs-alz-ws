package com.weblabs.api.mmsql.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity(name="weblabs_clientetelefonos")
public class PhonesModel {
	
	@Column(name="TEL1")
	@Id
	public String numero;
	
	@Column(name="CLCOD")
	public String codigo_cliente;
	
}
