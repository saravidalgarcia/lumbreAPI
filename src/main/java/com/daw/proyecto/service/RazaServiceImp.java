package com.daw.proyecto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.proyecto.dao.RazaDAO;
import com.daw.proyecto.dto.RazaDTO;
import com.daw.proyecto.entity.Raza;
import com.daw.proyecto.entity.Usuario;
import com.daw.proyecto.utils.EntityToDTO;

@Service
public class RazaServiceImp implements RazaService{

	@Autowired
	private RazaDAO razaDAO;

	/**
	 * Recupera la lista de razas y devuelve una lista de
	 * RazaDTO
	 */
	@Override
	public List<RazaDTO> getRazas(Usuario usuario) {
		List<Raza> rr = razaDAO.getRazas(usuario);
		if (rr == null) return null;
		List<RazaDTO> lista = new ArrayList<>();
		for (Raza r : rr) {
			RazaDTO rdto = EntityToDTO.toRazaDTO(r);
			lista.add(rdto);
		}
		return lista;
	}

	/**
	 * Recibe una raza y llama al DAO para crearla
	 * @param raza
	 */
	@Override
	public String crearRaza(Raza raza) {
		return razaDAO.crearRaza(raza);
	}

	/**
	 * Recibe el id de una raza y llama al DAO para recuperar la raza
	 * y devolver el DTO
	 * @param id
	 */
	@Override
	public RazaDTO getRazaDTO(Long id) {
		Raza r = razaDAO.getRaza(id);
		return EntityToDTO.toRazaDTO(r);
	}
	
	/**
	 * Recibe el id de una raza y llama al DAO para recuperar la raza
	 * @param id
	 */
	@Override
	public Raza getRaza(Long id) {
		return razaDAO.getRaza(id);
	}

	/**
	 * Recibe una raza y llama al DAO para actualizarla
	 * @param raza
	 */
	@Override
	public String updateRaza(Raza raza) {
		return razaDAO.updateRaza(raza);
	}

	/**
	 * Recibe el id de una raza y llama al DAO para borrarla
	 * @param id
	 */
	@Override
	public String deleteRaza(Long id) {
		return razaDAO.deleteRaza(id);
	}
	
}