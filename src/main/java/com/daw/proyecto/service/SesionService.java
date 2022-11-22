package com.daw.proyecto.service;

import java.util.List;

import com.daw.proyecto.dto.SesionDTO;
import com.daw.proyecto.entity.Campanha;
import com.daw.proyecto.entity.Sesion;
import com.daw.proyecto.entity.Usuario;

/**
 * Interfaz del servicio de sesiones
 *
 * @author Sara Vidal García
 */
public interface SesionService {

	public String crearSesion(Sesion sesion);
	
	public SesionDTO getSesionDTO(Long id, Campanha campanha);
	
	public Sesion getSesion(Long id, Campanha campanha);
	
	public String updateSesion(Sesion sesion);
	
	public String deleteSesion(Long id, Campanha campanha);
	
	public List<SesionDTO> getSesiones(Usuario usuario);
	
	public List<SesionDTO> getSesiones(Campanha campanha);
	

}