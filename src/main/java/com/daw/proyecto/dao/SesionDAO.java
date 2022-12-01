package com.daw.proyecto.dao;

import java.util.List;

import com.daw.proyecto.entity.Sesion;
import com.daw.proyecto.entity.Usuario;
import com.daw.proyecto.entity.Campanha;

/**
 * Interfaz del DAO de sesión
 *
 * @author Sara Vidal García
 */
public interface SesionDAO {

	public String crearSesion(Sesion sesion);
	
	public Sesion getSesion(Long id, Campanha campanha);
	
	public String updateSesion(Sesion sesion);
	
	public String deleteSesion(Long id, Campanha campanha);
	
	public List<Sesion> getSesiones(Usuario usuario);
	
	public List<Sesion> getSesiones(Campanha campanha);
	
}