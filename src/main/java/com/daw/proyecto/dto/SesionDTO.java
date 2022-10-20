package com.daw.proyecto.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SesionDTO implements Serializable{

	//Atributos 
	
	private Long id;
	private String nombre;
	private String estado;
	private String planificacion;
	private String resultados;
	private String fecha;
	private CampanhaDTO campanha;
	private String creacion;
	private String modificacion;
	
	
	//Constructores
	
	public SesionDTO() {}

	public SesionDTO(Long id, String nombre, String estado, String planificacion, String resultados, String fecha,
			CampanhaDTO campanha, String creacion, String modificacion) {
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
		this.planificacion = planificacion;
		this.resultados = resultados;
		this.fecha = fecha;
		this.campanha = campanha;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPlanificacion() {
		return planificacion;
	}

	public void setPlanificacion(String planificacion) {
		this.planificacion = planificacion;
	}

	public String getResultados() {
		return resultados;
	}

	public void setResultados(String resultados) {
		this.resultados = resultados;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public CampanhaDTO getCampanha() {
		return campanha;
	}

	public void setCampanha(CampanhaDTO campanha) {
		this.campanha = campanha;
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
		return "SesionDTO [id=" + id + ", nombre=" + nombre + ", estado=" + estado + ", planificacion=" + planificacion
				+ ", resultados=" + resultados + ", fecha=" + fecha + ", campanha=" + campanha + ", creacion="
				+ creacion + ", modificacion=" + modificacion + "]";
	}
	
}
