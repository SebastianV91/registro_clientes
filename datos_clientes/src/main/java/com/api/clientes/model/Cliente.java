package com.api.clientes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")

public class Cliente implements Serializable{
	
	@Id
	private Long num_identificacion;
	@Column(nullable = false)
	private String tipo_identificacion;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private Long telefono;
	@Column(nullable = false)
	private String direccion;
	
	public Cliente(Long num_identificacion, String tipo_identificacion, String nombre, String email, Long telefono,
			String direccion) {
		super();
		this.num_identificacion = num_identificacion;
		this.tipo_identificacion = tipo_identificacion;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public Cliente() {
		super();
	}

	public Long getNum_identificacion() {
		return num_identificacion;
	}

	public void setNum_identificacion(Long num_identificacion) {
		this.num_identificacion = num_identificacion;
	}

	public String getTipo_identificacion() {
		return tipo_identificacion;
	}

	public void setTipo_identificacion(String tipo_identificacion) {
		this.tipo_identificacion = tipo_identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	private static final long serialVersionUID = 1L;
	
}
