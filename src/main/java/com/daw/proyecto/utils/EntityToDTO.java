package com.daw.proyecto.utils;

import com.daw.proyecto.dto.RazaDTO;
import com.daw.proyecto.dto.UsuarioDTO;
import com.daw.proyecto.entity.Raza;
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
	
	/**
	 * Recibe una raza (entidad) y devuelve un objeto de la clase RazaDTO
	 * @param e
	 * @return
	 */
	public static RazaDTO toRazaDTO(Raza e) {
		RazaDTO dto = new RazaDTO();
		dto.setCreacion(e.getCreacion() != null ? e.getCreacion().toString(): null);
		dto.setDenominacion(e.getDenominacion());
		dto.setDescripcion(e.getDescripcion());
		dto.setId(e.getId());
		dto.setModificacion(e.getModificacion() != null ? e.getModificacion().toString(): null);
		dto.setTipo(e.getTipo());
		return dto;
	}
	
}
