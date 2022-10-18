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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "campanha")
public class Campanha {

	//Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "titulo")
	private String titulo;
	
	@Column(name = "resumen")
	private String resumen;
	
	@Column(name = "informacion")
	private String informacion;
	
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
	      })
	  @JoinTable(name = "personaje_campanha",
	        joinColumns = { @JoinColumn(name = "campanha") },
	        inverseJoinColumns = { @JoinColumn(name = "personaje") })
	  private Set<Personaje> personajes = new HashSet<>();
	

	//Constructores
	
	public Campanha() {}
	
	public Campanha(Long id, String titulo, String resumen, String informacion, LocalDate creacion,
			LocalDate modificacion, Usuario usuario) {
		this.id = id;
		this.titulo = titulo;
		this.resumen = resumen;
		this.informacion = informacion;
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

	public Set<Personaje> getPersonajes() {
		return personajes;
	}

	public void setPersonajes(Set<Personaje> personajes) {
		this.personajes = personajes;
	}
	
	
	//toString
	
	@Override
	public String toString() {
		return "Campanha [id=" + id + ", titulo=" + titulo + ", resumen=" + resumen + ", informacion=" + informacion
				+ ", creacion=" + creacion + ", modificacion=" + modificacion + ", usuario=" + usuario + ", personajes="
				+ personajes + "]";
	}

	
	//Métodos
	
	/**
	 * Recibe un personaje, lo añade al conjunto de personajes
	 * de la campaña y añade la campaña a las campañas del personaje
	 * @param personaje
	 */
	public void addPersonaje(Personaje personaje) {
	    this.personajes.add(personaje);
	    personaje.getCampanhas().add(this);
	  }
	
	/**
	 * Recibe un personaje, lo elimina del conjunto de personajes
	 * de la campaña y elimina la campaña de las campañas del personaje
	 * @param personaje
	 */
	public void removePersonaje(Personaje personaje) {
	    if (personaje != null) {
	      this.personajes.remove(personaje);
	      personaje.getCampanhas().remove(this);
	    }
	  }

}