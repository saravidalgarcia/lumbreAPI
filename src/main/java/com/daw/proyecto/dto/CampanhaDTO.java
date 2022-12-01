package com.daw.proyecto.dto;

import java.io.Serializable;
import java.util.List;

/**
 * DTO de campaña
 *
 * @author Sara Vidal García
 */
@SuppressWarnings("serial")
public class CampanhaDTO implements Serializable{

	//Atributos
	
	private Long id;
	private String titulo;	
	private String resumen;
	private String informacion;
	private String creacion;
	private String modificacion;
	private List<SesionDTO> sesiones;
	private List<PersonajeDTO> personajes;
	
	
	//Constructores
	
	public CampanhaDTO() {}

	public CampanhaDTO(Long id, String titulo, String resumen, String informacion, String creacion, String modificacion,
			List<SesionDTO> sesiones, List<PersonajeDTO> personajes) {
		this.id = id;
		this.titulo = titulo;
		this.resumen = resumen;
		this.informacion = informacion;
		this.creacion = creacion;
		this.modificacion = modificacion;
		this.sesiones = sesiones;
		this.personajes = personajes;
	}


	//Getters y setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	
	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
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

	public List<SesionDTO> getSesiones() {
		return sesiones;
	}

	public void setSesiones(List<SesionDTO> sesiones) {
		this.sesiones = sesiones;
	}

	public List<PersonajeDTO> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(List<PersonajeDTO> personajes) {
		this.personajes = personajes;
	}

	
	//toString
	
	@Override
	public String toString() {
		return "CampanhaDTO [id=" + id + ", titulo=" + titulo + ", resumen=" + resumen + ", informacion=" + informacion
				+ ", creacion=" + creacion + ", modificacion=" + modificacion + ", sesiones=" + sesiones
				+ ", personajes=" + personajes + "]";
	}

}