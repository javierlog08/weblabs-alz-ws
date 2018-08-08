package com.weblabs.api.mmsql.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="weblabs_clientes")
public class ClientModel {

	@Id
	@Column(name="CLCOD")
	public String codigo_cliente;
	
	
	@Column(name="TIPO")
	public String persona;
	
	@Column(name="ID")
	public String cip_ruc;
	
	@Column(name="GENERO")
	public String sexo;
	
	@Column(name="ESTCIVIL")
	public String estado_civil;
	
	@Column(name="CLIENTE")
	public String nombre_completo;
	
	@Column(name="ESTATUS")
	public String status;
	
	@Column(name="PROFESION")
	public String profesion;
}
