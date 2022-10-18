package com.daw.proyecto.entity;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "personaje")
public class Personaje {
	
	//Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "raza")
	private Raza raza;
	
	@Column(name = "jugador")
	private String jugador;
	
	@Column(name = "informacion")
	private String informacion;
	
	@Lob
	@Column(name="imagen")
	private String imagen;
	
	@Column(name = "creacion")
	private LocalDate creacion;
	
	@Column(name = "modificacion")
	private LocalDate modificacion;
	
	@ManyToOne
	@JoinColumn(name = "usuario")
	private Usuario usuario;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
				CascadeType.PERSIST,
				CascadeType.MERGE
			},
	      mappedBy = "personajes")
	@JsonIgnore
	private Set<Campanha> campanhas = new HashSet<>();

	
	//Constructores
	
	public Personaje() {}
	
	public Personaje(Long id, String nombre, Raza raza, String jugador, String informacion, String imagen, 
			LocalDate creacion, LocalDate modificacion, Usuario usuario) {
		this.id = id;
		this.nombre = nombre;
		this.raza = raza;
		this.jugador = jugador;
		this.informacion = informacion;
		this.imagen = imagen;
		this.creacion = creacion;
		this.modificacion = modificacion;
		this.usuario = usuario;
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

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
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
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Set<Campanha> getCampanhas() {
		return campanhas;
	}

	public void setCampanhas(Set<Campanha> campanhas) {
		this.campanhas = campanhas;
	}

	
	//toString
	
	@Override
	public String toString() {
		return "Personaje [id=" + id + ", nombre=" + nombre + ", raza=" + raza + ", jugador=" + jugador
				+ ", informacion=" + informacion + ", imagen=" + imagen + ", creacion=" + creacion + ", modificacion="
				+ modificacion + ", usuario=" + usuario + ", campanhas=" + campanhas + "]";
	}

}
