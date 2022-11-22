package com.daw.proyecto.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.proyecto.entity.Campanha;
import com.daw.proyecto.entity.Personaje;
import com.daw.proyecto.entity.Usuario;

/**
 * Implementación del DAO de campaña
 *
 * @author Sara Vidal García
 */
@Repository
public class CampanhaDAOImp implements CampanhaDAO{

	@Autowired
	private EntityManager entityManager;

	/**
	 * Devuelve una lista con todas las campañas de un usuario, o nulo en caso de error
	 * @param usuario
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Campanha> getCampanhas(Usuario usuario) {
		try {
			String query = "FROM Campanha WHERE usuario = :usuario";
			List<Campanha> lista = Collections.checkedList(entityManager.createQuery(query)
			        .setParameter("usuario", usuario)
			        .getResultList(),Campanha.class);
			return lista;
		}
		catch(Exception e) {
			return null;
		}
	}

	/**
	 * Recibe una campaña y la inserta en la BD, devolviendo "OK" en caso de éxito o un
	 * mensaje de error en caso contrario
	 * @param campanha
	 */
	@Override
	public String crearCampanha(Campanha campanha) {
		Session sesion = entityManager.unwrap(Session.class);
		try {
			sesion.saveOrUpdate(campanha);
			return "OK";
		}catch(Exception e) {
			return (e.getMessage());
		}
	}

	/**
	 * Recibe un id de campaña y devuelve la campaña asociada a dicho id,
	 * o nulo en caso de no encontrarla
	 * @param id
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Campanha getCampanha(Long id) {
		try {
			String query = "FROM Campanha WHERE id = :id";
			List<Campanha> lista = Collections.checkedList(entityManager.createQuery(query)
			        .setParameter("id", id)
			        .getResultList(),Campanha.class);
			if (lista.isEmpty()) {
	            return null;
	        }
	        return lista.get(0);
		}catch (Exception e) {
			return null;
		}
	}

	/**
	 * Recibe una campaña y la actualiza en la BD, devolviendo "OK" en caso de
	 * éxito o un mensaje de error en caso contrario
	 * @param campanha
	 */
	@Transactional
	@Override
	public String updateCampanha(Campanha campanha) {
		Session s = entityManager.unwrap(Session.class);
		try {
			s.save(campanha);
			return "OK";
		}catch(Exception e) {
			return (e.getMessage());
		}
	}

	/**
	 * Recibe un id de campaña y borra la campaña asociada de la BD, devolviendo "OK"
	 * en caso de éxito o un mensaje de error en caso contrario
	 * @param id
	 */
	@Transactional
	@Override
	public String deleteCampanha(Long id) {
		try {
			String query = "DELETE FROM Campanha WHERE id = :id";
			entityManager.createQuery(query)
			        .setParameter("id", id)
			        .executeUpdate();
	        return "OK";
		}catch (Exception e) {
			return e.getMessage();
		}
	}

}