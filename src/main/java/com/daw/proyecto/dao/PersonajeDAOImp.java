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

@Repository
public class PersonajeDAOImp implements PersonajeDAO{

	@Autowired
	private EntityManager entityManager;

	/**
	 * Devuelve una lista con todos los personajes de un usuario, o nulo en caso de error
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Personaje> getPersonajes(Usuario usuario) {
		try {
			String query = "FROM Personaje WHERE usuario = :usuario";
			List<Personaje> lista = Collections.checkedList(entityManager.createQuery(query)
			        .setParameter("usuario", usuario)
			        .getResultList(),Personaje.class);
			return lista;
		}
		catch(Exception e) {
			return null;
		}
	}

	/**
	 * Devuelve una lista con todos los personajes de un usuario y una campaña concreta, o nulo en caso de error
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Personaje> getPersonajes(Usuario usuario, Campanha campanha) {
		try {
			String query = "FROM Personaje WHERE usuario = :usuario AND campanha = :campanha";
			List<Personaje> lista = Collections.checkedList(entityManager.createQuery(query)
			        .setParameter("usuario", usuario)
			        .setParameter("campanha", campanha)
			        .getResultList(),Personaje.class);
			return lista;
		}
		catch(Exception e) {
			return null;
		}
	}

	/**
	 * Recibe un personaje y lo inserta en la BD, devolviendo "OK" en caso de éxito o un
	 * mensaje de error en caso contrario
	 * @param personaje
	 */
	@Override
	public String crearPersonaje(Personaje personaje) {
		Session sesion = entityManager.unwrap(Session.class);
		try {
			sesion.saveOrUpdate(personaje);
			return "OK";
		}catch(Exception e) {
			return (e.getMessage());
		}
	}

	/**
	 * Recibe un id de personaje y devuelve el personaje asociado a dicho id,
	 * o nulo en caso de no encontrarlo
	 * @param id
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Personaje getPersonaje(Long id) {
		try {
			String query = "FROM Personaje WHERE id = :id";
			List<Personaje> lista = Collections.checkedList(entityManager.createQuery(query)
			        .setParameter("id", id)
			        .getResultList(),Personaje.class);
			if (lista.isEmpty()) {
	            return null;
	        }
	        return lista.get(0);
		}catch (Exception e) {
			return null;
		}
	}

	/**
	 * Recibe un personaje y lo actualiza en la BD, devolviendo "OK" en caso de
	 * éxito o un mensaje de error en caso contrario
	 * @param personaje
	 */
	@Transactional
	@Override
	public String updatePersonaje(Personaje personaje) {
		Session s = entityManager.unwrap(Session.class);
		try {
			s.save(personaje);
			return "OK";
		}catch(Exception e) {
			return (e.getMessage());
		}
	}

	/**
	 * Recibe un id de personaje y borra el personaje asociado de la BD, devolviendo "OK"
	 * en caso de éxito o un mensaje de error en caso contrario
	 * @param id
	 */
	@Transactional
	@Override
	public String deletePersonaje(Long id) {
		try {
			String query = "DELETE FROM Personaje WHERE id = :id";
			entityManager.createQuery(query)
			        .setParameter("id", id)
			        .executeUpdate();
	        return "OK";
		}catch (Exception e) {
			return e.getMessage();
		}
	}

}