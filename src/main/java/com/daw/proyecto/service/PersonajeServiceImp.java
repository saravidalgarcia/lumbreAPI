package com.daw.proyecto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.proyecto.dao.PersonajeDAO;
import com.daw.proyecto.dto.PersonajeDTO;
import com.daw.proyecto.entity.Campanha;
import com.daw.proyecto.entity.Personaje;
import com.daw.proyecto.entity.Usuario;
import com.daw.proyecto.utils.EntityToDTO;

@Service
public class PersonajeServiceImp implements PersonajeService{

	@Autowired
	private PersonajeDAO personajeDAO;

	/**
	 * Recupera la lista de personajes y devuelve una lista de
	 * PersonajeDTO
	 */
	@Override
	public List<PersonajeDTO> getPersonajes(Usuario usuario) {
		List<Personaje> pp = personajeDAO.getPersonajes(usuario);
		if (pp == null) return null;
		List<PersonajeDTO> lista = new ArrayList<>();
		for (Personaje p : pp) {
			PersonajeDTO pdto = EntityToDTO.toPersonajeDTO(p);
			lista.add(pdto);
		}
		return lista;
	}

	/**
	 * Recupera la lista de personajes de una campaña concreta y 
	 * devuelve una lista de PersonajeDTO
	 */
	@Override
	public List<PersonajeDTO> getPersonajes(Usuario usuario, Campanha campanha) {
		List<Personaje> pp = personajeDAO.getPersonajes(usuario, campanha);
		if (pp == null) return null;
		List<PersonajeDTO> lista = new ArrayList<>();
		for (Personaje p : pp) {
			PersonajeDTO pdto = EntityToDTO.toPersonajeDTO(p);
			lista.add(pdto);
		}
		return lista;
	}

	/**
	 * Recibe un personaje y llama al DAO para crearlo
	 * @param raza
	 */
	@Override
	public String crearPersonaje(Personaje personaje) {
		return personajeDAO.crearPersonaje(personaje);
	}

	/**
	 * Recibe el id de un personaje y llama al DAO para recuperar el personaje
	 * y devolver el DTO
	 * @param id
	 */
	@Override
	public PersonajeDTO getPersonajeDTO(Long id) {
		Personaje p = personajeDAO.getPersonaje(id);
		return EntityToDTO.toPersonajeDTO(p);
	}
	
	/**
	 * Recibe el id de un personaje y llama al DAO para recuperar el personaje
	 * @param id
	 */
	@Override
	public Personaje getPersonaje(Long id) {
		return personajeDAO.getPersonaje(id);
	}

	/**
	 * Recibe un personaje y llama al DAO para actualizarlo
	 * @param raza
	 */
	@Override
	public String updatePersonaje(Personaje personaje) {
		return personajeDAO.updatePersonaje(personaje);
	}

	/**
	 * Recibe el id de un personaje y llama al DAO para borrarlo
	 * @param id
	 */
	@Override
	public String deletePersonaje(Long id) {
		return personajeDAO.deletePersonaje(id);
	}

}