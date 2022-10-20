package com.daw.proyecto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.proyecto.dao.CampanhaDAO;
import com.daw.proyecto.dao.SesionDAO;
import com.daw.proyecto.dto.CampanhaDTO;
import com.daw.proyecto.entity.Campanha;
import com.daw.proyecto.entity.Personaje;
import com.daw.proyecto.entity.Sesion;
import com.daw.proyecto.entity.Usuario;
import com.daw.proyecto.utils.EntityToDTO;

@Service
public class CampanhaServiceImp implements CampanhaService{
	
	@Autowired
	private CampanhaDAO campanhaDAO;
	
	@Autowired
	private SesionDAO sesionDAO;

	/**
	 * Recupera la lista de campañas de un usuario y devuelve una lista de
	 * CampanhaDTO
	 * @param usuario
	 */
	@Override
	public List<CampanhaDTO> getCampanhas(Usuario usuario) {
		List<Campanha> cc = campanhaDAO.getCampanhas(usuario);
		if (cc == null) return null;
		List<CampanhaDTO> lista = new ArrayList<>();
		for(Campanha c: cc) {
			CampanhaDTO cdto = EntityToDTO.toCampanhaDTO(c, null);
			lista.add(cdto);
		}
		return lista;
	}

	/**
	 * Recibe una campaña y llama al DAO para crearla
	 * @param campanha
	 */
	@Override
	public String crearCampanha(Campanha campanha) {
		return campanhaDAO.crearCampanha(campanha);
	}

	/**
	 * Recibe el id de una campaña y llama al DAO para obtener la campaña
	 * y devolver el DTO
	 * @param id
	 */
	@Override
	public CampanhaDTO getCampanhaDTO(Long id) {
		Campanha c = campanhaDAO.getCampanha(id);
		List<Sesion> ss = sesionDAO.getSesiones(c);
		return EntityToDTO.toCampanhaDTO(c,ss);
	}
	
	/**
	 * Recibe el id de una campaña y llama al DAO para obtener la campaña
	 * y devolverla
	 * @param id
	 */
	@Override
	public Campanha getCampanha(Long id) {
		return campanhaDAO.getCampanha(id);
	}

	/**
	 * Recibe una campaña y llama al DAO para actualizarla
	 * @param campanha
	 */
	@Override
	public String updateCampanha(Campanha campanha) {
		return campanhaDAO.updateCampanha(campanha);
	}

	/**
	 * Recibe el id de una campaña y llama al DAO para borrarla
	 * @param id
	 */
	@Override
	public String deleteCampanha(Long id) {
		return campanhaDAO.deleteCampanha(id);
	}

	/**
	 * Recibe una campaña y un personaje y llama al DAO para añadir
	 * el personaje a la campaña
	 * @param c
	 * @param p
	 */
	@Override
	public String addPersonaje(Campanha c, Personaje p) {
		return campanhaDAO.addPersonaje(c, p);
	}

	/**
	 * Recibe una campaña y un personaje y llama al DAO para quitar
	 * al personaje de la campaña
	 * @param c
	 * @param p
	 */
	@Override
	public String removePersonaje(Campanha c, Personaje p) {
		return campanhaDAO.removePersonaje(c, p);
	}

}