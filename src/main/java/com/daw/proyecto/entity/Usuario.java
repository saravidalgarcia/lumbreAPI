package com.daw.proyecto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	//Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "passwd")
	private String passwd;

	
	//Constructores
	
	public Usuario() {}
	
	public Usuario(Long id, String username, String email, String passwd) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.passwd = passwd;
	}
	
	
	//Getters y setters 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	
	//toString
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", username=" + username + ", passwd=" + passwd + "]";
	}

}