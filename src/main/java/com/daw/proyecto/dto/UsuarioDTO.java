package com.daw.proyecto.dto;

import java.io.Serializable;

/**
 * DTO de usuario
 *
 * @author Sara Vidal García
 */
@SuppressWarnings("serial")
public class UsuarioDTO implements Serializable{
	
	//Atributos
	
	private Long id;
	private String username;
	private String email;
	
	//Constructores
	
	public UsuarioDTO() {}

	public UsuarioDTO(Long id, String username, String email) {
		this.id = id;
		this.username = username;
		this.email = email;
	}

	
	//Getters y setters
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	//toString
	
	@Override
	public String toString() {
		return "UsuarioDTO [id=" + id + ", username=" + username + ", email=" + email + "]";
	}
	
}