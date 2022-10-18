package com.daw.proyecto.service;

import java.util.List;

import com.daw.proyecto.dto.UsuarioDTO;
import com.daw.proyecto.entity.Usuario;

public interface UsuarioService {

	public List<UsuarioDTO> getUsuarios();
	
	public String crearUsuario(Usuario usuario);
	
	public Usuario getUsuario(String username);
	
	public String updateUsuario(Usuario usuario);
	
	public Usuario login(Usuario usuario);
	
}