package com.daw.proyecto.dto;

import java.io.Serializable;

/**
 * DTO de personaje
 *
 * @author Sara Vidal García
 */
@SuppressWarnings("serial")
public class PersonajeDTO implements Serializable{

	//Atributos
	
	private Long id;
	private String nombre;
	private RazaDTO raza;
	private String jugador;
	private String informacion;
	private String imagen;
	private String creacion;
	private String modificacion;
	
	
	//Constructores
	
	public PersonajeDTO() {}

	public PersonajeDTO(Long id, String nombre, RazaDTO raza, String jugador, String informacion, String imagen,
			String creacion, String modificacion) {
		this.id = id;
		this.nombre = nombre;
		this.raza = raza;
		this.jugador = jugador;
		this.informacion = informacion;
		this.imagen = imagen;
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

	public RazaDTO getRaza() {
		return raza;
	}

	public void setRaza(RazaDTO raza) {
		this.raza = raza;
	}

	public String getJugador() {
		return jugador;
	}

	public void setJugador(String jugador) {
		this.jugador = jugador;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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
		return "PersonajeDTO [id=" + id + ", nombre=" + nombre + ", raza=" + raza + ", jugador=" + jugador
				+ ", informacion=" + informacion + ", imagen=" + imagen + ", creacion=" + creacion + ", modificacion="
				+ modificacion + "]";
	}

}
