package com.daw.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw.proyecto.service.UsuarioService;
import com.daw.proyecto.utils.JWTUtil;
import com.daw.proyecto.dto.UsuarioDTO;
import com.daw.proyecto.entity.Usuario;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
    private JWTUtil jwtUtil;
	
	/**
	 * Recibe un token y lo valida
	 * @param token
	 * @return
	 */
	private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }
	
	
	/**
	 * Petición POST para creación de usuario
	 * @param usuario
	 * @return
	 */
	@PostMapping("/usuarios")
	public String crearUsuario(@RequestBody Usuario usuario) {
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPasswd());
        usuario.setPasswd(hash);
        return usuarioService.crearUsuario(usuario);
	}
	
	/**
	 * Petición POST para actualización de contraseña
	 * @param username
	 * @param token
	 * @param usuario
	 * @return
	 */
	@PostMapping("{username}/password")
	public String updatePassword(@PathVariable String username, 
			@RequestHeader(value="Authorization") String token,
			@RequestBody Usuario usuario) {
		if (!validarToken(token)) { return null; }
		Usuario u = usuarioService.login(usuario);
        if (u != null) {
        	Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            String hash = argon2.hash(1, 1024, 1, usuario.getEmail());
            u.setPasswd(hash);
            return usuarioService.updateUsuario(u);
        }
        return "ERROR";
	}
	

	/**
	 * Petición POST para comprobación de login correcto
	 * @param usuario
	 * @return
	 */
	@PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        Usuario u = usuarioService.login(usuario);
        if (u != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(u.getId()), u.getEmail());
            return tokenJwt;
        }
        return "ERROR";
    }
	
	/**
	 * Petición GET para obtener un listado de usuarios (DTO)
	 * @return
	 */
	@GetMapping("/usuarios")
	public List<UsuarioDTO> getUsuarios(){
		return usuarioService.getUsuarios();
	}
	
}