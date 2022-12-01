package com.daw.proyecto.service;

import java.util.List;

import com.daw.proyecto.dto.CampanhaDTO;
import com.daw.proyecto.entity.Campanha;
import com.daw.proyecto.entity.Usuario;

/**
 * Interfaz del servicio de campañas
 *
 * @author Sara Vidal García
 */
public interface CampanhaService {

	public List<CampanhaDTO> getCampanhas(Usuario usuario);
	
	public String crearCampanha(Campanha campanha);
	
	public CampanhaDTO getCampanhaDTO(Long id);
	
	public Campanha getCampanha(Long id);
	
	public String updateCampanha(Campanha campanha);
	
	public String deleteCampanha(Long id);

}