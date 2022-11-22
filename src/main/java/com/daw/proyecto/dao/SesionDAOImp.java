package com.daw.proyecto.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.proyecto.entity.Campanha;
import com.daw.proyecto.entity.Sesion;
import com.daw.proyecto.entity.Usuario;

/**
 * Implementación del DAO de sesión
 *
 * @author Sara Vidal García
 */
@Repository
public class SesionDAOImp implements SesionDAO {

	@Autowired
	private EntityManager entityManager;
	
	/**
	 * Recibe una sesión y la inserta en la BD, devolviendo "OK" en caso de éxito o un
	 * mensaje de error en caso contrario
	 * @param sesion
	 */
	@Override
	public String crearSesion(Sesion sesion) {
		Session s = entityManager.unwrap(Session.class);
		try {
			s.saveOrUpdate(sesion);
			return "OK";
		}catch(Exception e) {
			return (e.getMessage());
		}
	}

	/**
	 * Recibe un id de sesión y una campaña, y devuelve la sesión asociada a dicho id
	 * y campaña, o nulo en caso de no encontrarla
	 * @param id
	 * @param campanha
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Sesion getSesion(Long id, Campanha campanha) {
		try {
			String query = "FROM Sesion WHERE id = :id AND campanha = :campanha";
	        List<Sesion> lista = Collections.checkedList(entityManager.createQuery(query)
	        		.setParameter("id", id)
	        		.setParameter("campanha", campanha)
	        		.getResultList(),Sesion.class);
	        if (lista.isEmpty()) {
	            return null;
	        }
	        return lista.get(0);
		}catch(Exception e) {
			return null;
		}
	}

	/**
	 * Recibe una sesión y la actualiza en la BD, devolviendo "OK" en caso de
	 * éxito o un mensaje de error en caso contrario
	 * @param sesion
	 */
	@Transactional
	@Override
	public String updateSesion(Sesion sesion) {
		Session s = entityManager.unwrap(Session.class);
		try {
			s.save(sesion);
			return "OK";
		}catch(Exception e) {
			return (e.getMessage());
		}
	}

	/**
	 * Recibe un id de sesión y borra la sesión asociada de la BD, devolviendo "OK"
	 * en caso de éxito o un mensaje de error en caso contrario
	 * @param id
	 */
	@Transactional
	@Override
	public String deleteSesion(Long id, Campanha campanha) {
		try {
			String query = "DELETE FROM Sesion WHERE id = :id AND campanha = :campanha";
			entityManager.createQuery(query)
			        .setParameter("id", id)
			        .setParameter("campanha",campanha)
			        .executeUpdate();
	        return "OK";
		}catch (Exception e) {
			return e.getMessage();
		}
	}

	/**
	 * Devuelve una lista con todas las sesiones de un usuario ordenadas
	 * por fecha, o nulo en caso de error
	 * @param usuario
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Sesion> getSesiones(Usuario usuario) {
		try {
			String query = "FROM Sesion WHERE usuario = :usuario ORDER BY fecha";
			List<Sesion> lista = Collections.checkedList(entityManager.createQuery(query)
			        .setParameter("usuario", usuario)
			        .getResultList(),Sesion.class);
			return lista;
		}
		catch(Exception e) {
			return null;
		}
	}

	/**
	 * Devuelve una lista con todas las sesiones de una campaña ordenadas
	 * por fecha, o nulo en caso de error
	 * @param campanha
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Sesion> getSesiones(Campanha campanha) {
		try {
			String query = "FROM Sesion WHERE campanha = :campanha ORDER BY fecha";
			List<Sesion> lista = Collections.checkedList(entityManager.createQuery(query)
			        .setParameter("campanha", campanha)
			        .getResultList(),Sesion.class);
			return lista;
		}
		catch(Exception e) {
			return null;
		}
	}
	
}