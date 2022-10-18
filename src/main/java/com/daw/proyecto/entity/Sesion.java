package com.daw.proyecto.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="sesion")
public class Sesion {
	
	//Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="planificacion")
	private String planificacion;
	
	@Column(name="resultados")
	private String resultados;
	
	@Column(name = "fecha")
	private LocalDateTime fecha;

    @ManyToOne
    @PrimaryKeyJoinColumn(name="campanha", referencedColumnName="id")
    private Campanha campanha;
	
	@ManyToOne
	@JoinColumn(name = "usuario")
	private Usuario usuario;
	
	@Column(name = "creacion")
	private LocalDate creacion;
	
	@Column(name = "modificacion")
	private LocalDate modificacion;
	
	
	//Constructores
	
	public Sesion() {}

	public Sesion(Long id, String nombre, String estado, String planificacion, String resultados, LocalDateTime fecha,
			Campanha campanha, Usuario usuario, LocalDate creacion, LocalDate modificacion) {
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
		this.planificacion = planificacion;
		this.resultados = resultados;
		this.fecha = fecha;
		this.campanha = campanha;
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

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Campanha getCampanha() {
		return campanha;
	}

	public void setCampanha(Campanha campanha) {
		this.campanha = campanha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		return "Sesion [id=" + id + ", nombre=" + nombre + ", estado=" + estado + ", planificacion=" + planificacion
				+ ", resultados=" + resultados + ", fecha=" + fecha + ", campanha=" + campanha + ", usuario=" + usuario
				+ ", creacion=" + creacion + ", modificacion=" + modificacion + "]";
	}

}
