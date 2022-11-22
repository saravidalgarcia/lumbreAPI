package com.daw.proyecto.dao;


import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.daw.proyecto.entity.Usuario;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

/**
 * Implementación del DAO de usuario
 *
 * @author Sara Vidal García
 */
@Repository
public class UsuarioDAOImp implements UsuarioDAO{

	@Autowired
	private EntityManager entityManager;

	/**
	 * Devuelve una lista con todos los usuarios, o nulo en caso de error
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Usuario> getUsuarios() {
		try {
			String query = "FROM Usuario";
	        List<Usuario> usuarios = Collections.checkedList(entityManager.createQuery(query)
	        		.getResultList(),Usuario.class);
	        if (usuarios.isEmpty())
	            return null;
	        return usuarios;
		}catch(Exception e) {
			return null;
		}
	}

	/**
	 * Recibe un usuario y lo inserta en la BD, devolviendo "OK" en caso de éxito o un
	 * mensaje de error en caso contrario
	 * @param usuario
	 */
	@Override
	public String crearUsuario(Usuario usuario) {
		Session sesion = entityManager.unwrap(Session.class);
		try {
			sesion.saveOrUpdate(usuario);
			return "OK";
		}catch(Exception e) {
			return (e.getMessage());
		}
	}

	/**
	 * Recibe un nombre de usuario y devuelve el usuario asociado a dicho nombre,
	 * o nulo en caso de no encontrarlo
	 * @param username
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Usuario getUsuario(String username) {
		try {
			String query = "FROM Usuario WHERE username = :username";
	        List<Usuario> lista = Collections.checkedList(entityManager.createQuery(query)
	        		.setParameter("username", username)
	        		.getResultList(),Usuario.class);
	        if (lista.isEmpty())
	            return null;
	        return lista.get(0);
		}catch(Exception e) {
			return null;
		}
	}

	/**
	 * Recibe un usuario y lo actualiza en la BD, devolviendo "OK" en caso de
	 * éxito o un mensaje de error en caso contrario
	 * @param usuario
	 */
	@Transactional
	@Override
	public String updateUsuario(Usuario usuario) {
		Session s = entityManager.unwrap(Session.class);
		try {
			s.save(usuario);
			return "OK";
		}catch(Exception e) {
			return (e.getMessage());
		}
	}

	/**
	 * Recibe un usuario y trata de recuperarlo de BD a partir de su nombre de usuario,
	 * si lo encuentra comprueba que la contraseña coincida y, en caso de éxito, devuelve
	 * el usuario (nulo en caso contrario)
	 * @param usuario
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Usuario login(Usuario usuario) {
		try {
			String query = "FROM Usuario WHERE username = :username";
	        List<Usuario> lista = Collections.checkedList(entityManager.createQuery(query)
	        		.setParameter("username", usuario.getUsername())
	        		.getResultList(),Usuario.class);
	        if (lista.isEmpty())
	            return null;
	        String passwordHashed = lista.get(0).getPasswd();
	        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
	        if (argon2.verify(passwordHashed, usuario.getPasswd()))
	            return lista.get(0);
	        return null;
		}catch(Exception e) {
			return null;
		}
	}

}
