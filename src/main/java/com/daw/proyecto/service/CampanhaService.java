package com.daw.proyecto.service;

import java.util.List;

import com.daw.proyecto.dto.CampanhaDTO;
import com.daw.proyecto.entity.Campanha;
import com.daw.proyecto.entity.Personaje;
import com.daw.proyecto.entity.Usuario;

public interface CampanhaService {

	public List<CampanhaDTO> getCampanhas(Usuario usuario);
	
	public String crearCampanha(Campanha campanha);
	
	public CampanhaDTO getCampanhaDTO(Long id);
	
	public Campanha getCampanha(Long id);
	
	public String updateCampanha(Campanha campanha);
	
	public String deleteCampanha(Long id);
	
	public String addPersonaje(Campanha c, Personaje p);
	
	public String removePersonaje(Campanha c, Personaje p);
	
}