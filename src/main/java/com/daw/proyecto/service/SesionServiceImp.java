package com.daw.proyecto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.proyecto.dao.SesionDAO;
import com.daw.proyecto.dto.SesionDTO;
import com.daw.proyecto.entity.Campanha;
import com.daw.proyecto.entity.Sesion;
import com.daw.proyecto.entity.Usuario;
import com.daw.proyecto.utils.EntityToDTO;

@Service
public class SesionServiceImp implements SesionService{

	@Autowired
	private SesionDAO sesionDAO;

	/**
	 * Recibe una sesión y llama al DAO para crearla
	 * @param sesion
	 */
	@Override
	public String crearSesion(Sesion sesion) {
		return sesionDAO.crearSesion(sesion);
	}

	/**
	 * Recibe el id de una sesión y una campaña, y llama al DAO para obtener la sesión
	 * y devolver el DTO
	 * @param id
	 * @param campanha
	 */
	@Override
	public SesionDTO getSesionDTO(Long id, Campanha campanha) {
		Sesion s = sesionDAO.getSesion(id, campanha);
		return EntityToDTO.toSesionDTO(s);
	}
	
	/**
	 * Recibe el id de una sesión y una campaña, y llama al DAO para obtener la sesión
	 * y devolverla
	 * @param id
	 * @param campanha
	 */
	@Override
	public Sesion getSesion(Long id, Campanha campanha) {
		return sesionDAO.getSesion(id, campanha);
	}

	/**
	 * Recibe una sesión y llama al DAO para actualizarla
	 * @param sesion
	 */
	@Override
	public String updateSesion(Sesion sesion) {
		return sesionDAO.updateSesion(sesion);
	}

	/**
	 * Recibe el id de una sesión y una campaña, y llama al DAO para borrar la sesión
	 * @param id
	 * @param campanha
	 */
	@Override
	public String deleteSesion(Long id, Campanha campanha) {
		return sesionDAO.deleteSesion(id, campanha);
	}

	/**
	 * Recupera la lista de sesiones de un usuario y devuelve una lista de
	 * SesionDTO
	 * @param usuario
	 */
	@Override
	public List<SesionDTO> getSesiones(Usuario usuario) {
		List<Sesion> ss = sesionDAO.getSesiones(usuario);
		if (ss == null) return null;
		List<SesionDTO> lista = new ArrayList<>();
		for(Sesion s : ss) {
			SesionDTO sdto = EntityToDTO.toSesionDTO(s);
			lista.add(sdto);
		}
		return lista;
	}

	/**
	 * Recupera la lista de sesiones de una campaña y devuelve una lista de
	 * SesionDTO
	 * @param campanha
	 */
	@Override
	public List<SesionDTO> getSesiones(Campanha campanha) {
		List<Sesion> ss = sesionDAO.getSesiones(campanha);
		if (ss == null) return null;
		List<SesionDTO> lista = new ArrayList<>();
		for(Sesion s : ss) {
			SesionDTO sdto = EntityToDTO.toSesionDTO(s);
			lista.add(sdto);
		}
		return lista;
	}

}