package com.daw.proyecto.utils;

import java.util.ArrayList;
import java.util.List;

import com.daw.proyecto.dto.CampanhaDTO;
import com.daw.proyecto.dto.PersonajeDTO;
import com.daw.proyecto.dto.RazaDTO;
import com.daw.proyecto.dto.SesionDTO;
import com.daw.proyecto.dto.UsuarioDTO;
import com.daw.proyecto.entity.Campanha;
import com.daw.proyecto.entity.Personaje;
import com.daw.proyecto.entity.Raza;
import com.daw.proyecto.entity.Sesion;
import com.daw.proyecto.entity.Usuario;

/**
 * Clase que transforma las entidades en DTOs
 *
 * @author Sara Vidal García
 */
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
	
	/**
	 * Recibe un personaje (entidad) y devuelve un objeto de la clase PersonajeDTO
	 * @param e
	 * @return
	 */
	public static PersonajeDTO toPersonajeDTO(Personaje e) {
		PersonajeDTO dto = new PersonajeDTO();
		dto.setCreacion(e.getCreacion() != null ? e.getCreacion().toString(): null);
		dto.setId(e.getId());
		dto.setImagen(e.getImagen());
		dto.setInformacion(e.getInformacion());
		dto.setJugador(e.getJugador());
		dto.setModificacion(e.getModificacion() != null ? e.getModificacion().toString(): null);
		dto.setNombre(e.getNombre());
		dto.setRaza(EntityToDTO.toRazaDTO(e.getRaza()));
		return dto;
	}
	
	/**
	 * Recibe una sesión (entidad) y devuelve un objeto de la clase SesionDTO
	 * @param e
	 * @return
	 */
	public static SesionDTO toSesionDTO(Sesion e) {
		SesionDTO dto = new SesionDTO();
		dto.setCampanha(EntityToDTO.toCampanhaDTO(e.getCampanha(),null));
		dto.setCreacion(e.getCreacion() != null ? e.getCreacion().toString(): null);
		dto.setEstado(e.getEstado());
		dto.setFecha(e.getFecha() != null ? e.getFecha().toString() : null);
		dto.setId(e.getId());
		dto.setModificacion(e.getModificacion() != null ? e.getModificacion().toString(): null);
		dto.setNombre(e.getNombre());
		dto.setPlanificacion(e.getPlanificacion());
		dto.setResultados(e.getResultados());
		return dto;
	}
	
	/**
	 * Recibe una campaña (entidad) y una lista de sesiones, y devuelve un objeto de la clase CampanhaDTO
	 * @param e
	 * @param ss
	 * @return
	 */
	public static CampanhaDTO toCampanhaDTO(Campanha e, List<Sesion> ss) {
		CampanhaDTO dto = new CampanhaDTO();
		dto.setCreacion(e.getCreacion() != null ? e.getCreacion().toString(): null);
		dto.setId(e.getId());
		dto.setModificacion(e.getModificacion() != null ? e.getModificacion().toString(): null);
		dto.setResumen(e.getResumen());
		dto.setInformacion(e.getInformacion());
		dto.setTitulo(e.getTitulo());
		List<Personaje> pp = new ArrayList<>(e.getPersonajes());
		if (pp != null) {
			List<PersonajeDTO> personajes = new ArrayList<>();
			for(Personaje p: pp) {
				PersonajeDTO pdto = EntityToDTO.toPersonajeDTO(p);
				personajes.add(pdto);
			}
			dto.setPersonajes(personajes);
		}
		if (ss != null) {
			List<SesionDTO> sesiones = new ArrayList<>();
			for(Sesion s : ss) {
				SesionDTO sdto = EntityToDTO.toSesionDTO(s);
				sesiones.add(sdto);
			}
			dto.setSesiones(sesiones);
		}
		return dto;
	}
	
}
