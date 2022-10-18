package com.daw.proyecto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.proyecto.dao.UsuarioDAO;
import com.daw.proyecto.dto.UsuarioDTO;
import com.daw.proyecto.entity.Usuario;
import com.daw.proyecto.utils.EntityToDTO;

@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;

	/**
	 * Recupera la lista de usuarios y devuelve una lista de
	 * UsuarioDTO
	 */
	@Override
	public List<UsuarioDTO> getUsuarios() {
		List<Usuario> usuarios = usuarioDAO.getUsuarios();
		if (usuarios == null) return null;
		List<UsuarioDTO> lista = new ArrayList<>();
		for(Usuario u : usuarios) {
			UsuarioDTO udto = EntityToDTO.toUsuarioDTO(u);
			lista.add(udto);
		}
		return lista;
	}

	/**
	 * Recibe un usuario y llama al DAO para crearlo
	 * @param usuario
	 */
	@Override
	public String crearUsuario(Usuario usuario) {
		return usuarioDAO.crearUsuario(usuario);
	}

	/**
	 * Recibe un nombre de usuario y llama al DAO para recuperar el usuario
	 * @param username
	 */
	@Override
	public Usuario getUsuario(String username) {
		return usuarioDAO.getUsuario(username);
	}

	/**
	 * Recibe un usuario y llama al DAO para actualizarlo
	 * @param usuario
	 */
	@Override
	public String updateUsuario(Usuario usuario) {
		return usuarioDAO.updateUsuario(usuario);
	}

	/**
	 * Recibe un usuario y llama al DAO para comprobar que
	 * el login es correcto, y devuelve el usuario
	 * @param usuario
	 */
	@Override
	public Usuario login(Usuario usuario) {
		return usuarioDAO.login(usuario);
	}

}
