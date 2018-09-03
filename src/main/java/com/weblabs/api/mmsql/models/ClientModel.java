package com.weblabs.api.mmsql.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	public String nombreCompleto;
	
	@Column(name="ESTATUS")
	public String status;
	
	@Column(name="PROFESION")
	public String profesion;
	
	@OneToMany(
		mappedBy="codigo_cliente",
		fetch = FetchType.EAGER,
		cascade = CascadeType.ALL
	)
	public List<PhonesModel> phones;
	
	@OneToMany(
		mappedBy="codigo_cliente",
		fetch = FetchType.EAGER,
		cascade = CascadeType.ALL
	)
	@Fetch(value = FetchMode.SUBSELECT)
	public List<AddressModel> addresses;
}
