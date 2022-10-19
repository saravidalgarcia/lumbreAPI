package com.daw.proyecto.dao;

import java.util.List;

import com.daw.proyecto.entity.Campanha;
import com.daw.proyecto.entity.Personaje;
import com.daw.proyecto.entity.Usuario;

public interface PersonajeDAO {

	public List<Personaje> getPersonajes(Usuario usuario);
	
	public List<Personaje> getPersonajes(Usuario usuario, Campanha campanha);
	
	public String crearPersonaje(Personaje personaje);
	
	public Personaje getPersonaje(Long id);
	
	public String updatePersonaje(Personaje personaje);
	
	public String deletePersonaje(Long id);
	
}