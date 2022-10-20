package com.daw.proyecto.service;

import java.util.List;

import com.daw.proyecto.dto.PersonajeDTO;
import com.daw.proyecto.entity.Campanha;
import com.daw.proyecto.entity.Personaje;
import com.daw.proyecto.entity.Usuario;

public interface PersonajeService {
	
	public List<PersonajeDTO> getPersonajes(Usuario usuario);
	
	public List<PersonajeDTO> getPersonajes(Usuario usuario, Campanha campanha);
	
	public String crearPersonaje(Personaje personaje);
	
	public PersonajeDTO getPersonajeDTO(Long id);
	
	public Personaje getPersonaje(Long id);
	
	public String updatePersonaje(Personaje personaje);
	
	public String deletePersonaje(Long id);

}