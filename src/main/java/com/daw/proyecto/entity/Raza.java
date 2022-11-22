package com.daw.proyecto.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que representa una raza
 *
 * @author Sara Vidal García
 */
@Entity
@Table(name = "raza")
public class Raza {

	//Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "denominacion")
	private String denominacion;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "descripcion")
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "usuario")
	private Usuario usuario;
	
	@Column(name = "creacion")
	private LocalDate creacion;
	
	@Column(name = "modificacion")
	private LocalDate modificacion;

	
	//Constructores
	
	public Raza() {}

	public Raza(Long id, String denominacion, String tipo, String descripcion, Usuario usuario, LocalDate creacion,
			LocalDate modificacion) {
		this.id = id;
		this.denominacion = denominacion;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.usuario = usuario;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDate getCreacion() {
		return creacion;
	}

	public void setCreacion(LocalDate creacion) {
		this.creacion = creacion;
	}

	public LocalDate getModificacion() {
		return modificacion;
	}

	public void setModificacion(LocalDate modificacion) {
		this.modificacion = modificacion;
	}

	
	//toString
	
	@Override
	public String toString() {
		return "Raza [id=" + id + ", denominacion=" + denominacion + ", tipo=" + tipo + ", descripcion=" + descripcion
				+ ", usuario=" + usuario + ", creacion=" + creacion + ", modificacion=" + modificacion + "]";
	}
	
}
