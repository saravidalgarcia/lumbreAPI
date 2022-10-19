package com.daw.proyecto.service;

import java.util.List;

import com.daw.proyecto.dto.RazaDTO;
import com.daw.proyecto.entity.Raza;
import com.daw.proyecto.entity.Usuario;

public interface RazaService {

	public List<RazaDTO> getRazas(Usuario usuario);

	public String crearRaza(Raza raza);
	
	public RazaDTO getRazaDTO(Long id);
	
	public Raza getRaza(Long id);
	
	public String updateRaza(Raza raza);
	
	public String deleteRaza(Long id);

}
