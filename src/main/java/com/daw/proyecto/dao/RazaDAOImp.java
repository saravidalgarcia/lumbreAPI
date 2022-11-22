package com.daw.proyecto.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.proyecto.entity.Raza;
import com.daw.proyecto.entity.Usuario;

/**
 * Implementación del DAO de raza
 *
 * @author Sara Vidal García
 */
@Repository
public class RazaDAOImp implements RazaDAO{

	@Autowired
	private EntityManager entityManager;
	
	/**
	 * Devuelve una lista con todas las razas (predefinidas y del usuario) ordenadas alfabeticamente, 
	 * o nulo en caso de error
	 * @param usuario
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Raza> getRazas(Usuario usuario) {
		try {
			String query = "FROM Raza WHERE usuario = :usuario OR usuario = null ORDER BY denominacion";
			List<Raza> lista = Collections.checkedList(entityManager.createQuery(query)
			        .setParameter("usuario", usuario)
			        .getResultList(),Raza.class);
			return lista;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	/**
	 * Recibe una raza y la inserta en la BD, devolviendo "OK" en caso de éxito o un
	 * mensaje de error en caso contrario
	 * @param raza
	 */
	@Override
	public String crearRaza(Raza raza) {
		Session sesion = entityManager.unwrap(Session.class);
		try {
			sesion.saveOrUpdate(raza);
			return "OK";
		}catch(Exception e) {
			return (e.getMessage());
		}
	}

	/**
	 * Recibe un id de raza y devuelve la raza asociada a dicho id,
	 * o nulo en caso de no encontrarla
	 * @param id
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Raza getRaza(Long id) {
		try {
			String query = "FROM Raza WHERE id = :id";
	        List<Raza> lista = Collections.checkedList(entityManager.createQuery(query)
	        		.setParameter("id", id)
	        		.getResultList(),Raza.class);
	        if (lista.isEmpty()) {
	            return null;
	        }
	        return lista.get(0);
		}catch(Exception e) {
			return null;
		}
	}

	/**
	 * Recibe una raza y la actualiza en la BD, devolviendo "OK" en caso de
	 * éxito o un mensaje de error en caso contrario
	 * @param raza
	 */
	@Transactional
	@Override
	public String updateRaza(Raza raza) {
		Session s = entityManager.unwrap(Session.class);
		try {
			s.save(raza);
			return "OK";
		}catch(Exception e) {
			return (e.getMessage());
		}
	}

	/**
	 * Recibe un id de raza y borra la raza asociada de la BD, devolviendo "OK"
	 * en caso de éxito o un mensaje de error en caso contrario
	 * @param id
	 */
	@Transactional
	@Override
	public String deleteRaza(Long id) {
		try {
			String query = "DELETE FROM Raza WHERE id = :id";
			entityManager.createQuery(query)
			        .setParameter("id", id)
			        .executeUpdate();
	        return "OK";
		}catch (Exception e) {
			return e.getMessage();
		}
	}
	
}