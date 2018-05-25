package com.weblabs.api.mmsql.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="weblabs_cliente")
public class ClientModel {

	@Id
	@Column(name="ClienteCodigo")
	public String codigo_cliente;
	
	
	@Column(name="ClientePersona")
	public String persona;
	
	@Column(name="ClienteRucCed")
	public String cip_ruc;
	
	@Column(name="ClienteSexo")
	public String sexo;
	
	@Column(name="ClienteEstadoCivil")
	public String estado_civil;
	
	@Column(name="ClienteNombreCompleto")
	public String nombre_completo;
	
	@Column(name="ClienteStatus")
	public String status;
	
	@Column(name="ClienteProfesion")
	public String profesion;
}
