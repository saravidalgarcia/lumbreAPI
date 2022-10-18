package com.daw.proyecto.dao;

import java.util.List;

import com.daw.proyecto.entity.Usuario;

public interface UsuarioDAO {
	
	public List<Usuario> getUsuarios();
	
	public String crearUsuario(Usuario usuario);
	
	public Usuario getUsuario(String username);
	
	public String updateUsuario(Usuario usuario);
	
	public Usuario login(Usuario usuario);

}
