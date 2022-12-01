package com.daw.proyecto.dto;

import java.io.Serializable;

/**
 * DTO de raza
 *
 * @author Sara Vidal García
 */
@SuppressWarnings("serial")
public class RazaDTO implements Serializable{

	//Atributos
	
	private Long id;
	private String denominacion;
	private String tipo;
	private String descripcion;
	private String creacion;
	private String modificacion;
	
	
	//Constructores
	
	public RazaDTO() {}

	public RazaDTO(Long id, String denominacion, String tipo, String descripcion, String creacion, String modificacion) {
		this.id = id;
		this.denominacion = denominacion;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.creacion = creacion;
		this.modificacion = modificacion;
	}

	
	//Getters y setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getCreacion() {
		return creacion;
	}

	public void setCreacion(String creacion) {
		this.creacion = creacion;
	}

	public String getModificacion() {
		return modificacion;
	}

	public void setModificacion(String modificacion) {
		this.modificacion = modificacion;
	}

	
	//toString
	
	@Override
	public String toString() {
		return "RazaDTO [id=" + id + ", denominacion=" + denominacion + ", tipo=" + tipo + ", descripcion="
				+ descripcion + ", creacion=" + creacion + ", modificacion=" + modificacion + "]";
	}

}