package com.daw.proyecto.utils;

import com.daw.proyecto.dto.UsuarioDTO;
import com.daw.proyecto.entity.Usuario;

public class EntityToDTO {

	/**
	 * Recibe un usuario (entidad) y devuelve un objeto de la clase UsuarioDTO
	 * @param e
	 * @return
	 */
	public static UsuarioDTO toUsuarioDTO(Usuario e) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(e.getId());
		dto.setEmail(e.getEmail());
		dto.setUsername(e.getUsername());
		return dto;
	}
	
}
