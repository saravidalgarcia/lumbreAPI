package com.daw.proyecto.dao;

import java.util.List;

import com.daw.proyecto.entity.Raza;
import com.daw.proyecto.entity.Usuario;

/**
 * Interfaz del DAO de raza
 *
 * @author Sara Vidal García
 */
public interface RazaDAO {
	
	public List<Raza> getRazas(Usuario usuario);

	public String crearRaza(Raza raza);
	
	public Raza getRaza(Long id);
	
	public String updateRaza(Raza raza);
	
	public String deleteRaza(Long id);
	
}
