package com.daw.proyecto.dao;

import java.util.List;

import com.daw.proyecto.entity.Campanha;
import com.daw.proyecto.entity.Usuario;

/**
 * Interfaz del DAO de campaña
 *
 * @author Sara Vidal García
 */
public interface CampanhaDAO {
	
	public List<Campanha> getCampanhas(Usuario usuario);
	
	public String crearCampanha(Campanha campanha);
	
	public Campanha getCampanha(Long id);
	
	public String updateCampanha(Campanha campanha);
	
	public String deleteCampanha(Long id);
	
}