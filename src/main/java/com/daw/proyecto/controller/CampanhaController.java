package com.daw.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.daw.proyecto.service.CampanhaService;
import com.daw.proyecto.service.PersonajeService;
import com.daw.proyecto.service.UsuarioService;
import com.daw.proyecto.utils.JWTUtil;
import com.daw.proyecto.dto.CampanhaDTO;
import com.daw.proyecto.entity.Campanha;
import com.daw.proyecto.entity.Personaje;
import com.daw.proyecto.entity.Usuario;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST, RequestMethod.DELETE})
public class CampanhaController {

	@Autowired
	private CampanhaService campanhaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PersonajeService personajeService;

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
	 * Petición GET para obtener el listado de campañas (DTO)
	 * @param username
	 * @param token
	 * @return
	 */
	@GetMapping("/{username}/campanhas")
	public List<CampanhaDTO> getCampanhas(@PathVariable String username, @RequestHeader(value="Authorization") String token){
		if (!validarToken(token)) { return null; }
		Usuario usuario = usuarioService.getUsuario(username);
		if (usuario == null)
			return null;
		return campanhaService.getCampanhas(usuario);
	}
	
	/**
	 * Petición POST para crear una campaña
	 * @param username
	 * @param token
	 * @param campanha
	 * @return
	 */
	@PostMapping("{username}/campanhas")
	public String crearCampanha(@PathVariable String username, @RequestHeader(value="Authorization") String token,@RequestBody Campanha campanha) {
		if (!validarToken(token)) { return null; }
		Usuario usuario = usuarioService.getUsuario(username);
		if (usuario == null)
			return null;
		campanha.setUsuario(usuario);
		return campanhaService.crearCampanha(campanha);
	}
	
	/**
	 * Petición GET para obtener una campaña (DTO)
	 * @param username
	 * @param id
	 * @param token
	 * @return
	 */
	@GetMapping("/{username}/campanhas/{id}")
	public CampanhaDTO getCampanha(@PathVariable String username, @PathVariable Long id, @RequestHeader(value="Authorization") String token){
		if (!validarToken(token)) { return null; }
		Usuario usuario = usuarioService.getUsuario(username);
		if (usuario == null)
			return null;
		return campanhaService.getCampanhaDTO(id);
	}
	
	/**
	 * Petición PUT para actualizar una campaña
	 * @param username
	 * @param id
	 * @param token
	 * @param campanha
	 * @return
	 */
	@PutMapping("{username}/campanhas/{id}")
	public String updateCampanha(@PathVariable String username, @PathVariable Long id, @RequestHeader(value="Authorization") String token,@RequestBody Campanha campanha) {
		if (!validarToken(token)) { return null; }
		if (usuarioService.getUsuario(username) == null) {return null;}
		if (campanhaService.getCampanha(id) == null) return null;
		Campanha c = campanhaService.getCampanha(id);
		c.setInformacion(campanha.getInformacion());
		c.setTitulo(campanha.getTitulo());
		c.setResumen(campanha.getResumen());
		c.setModificacion(campanha.getModificacion());
		return campanhaService.updateCampanha(c);
	}
	
	/**
	 * Petición PUT para actualizar los personajes de una campaña y añadir un personaje
	 * @param username
	 * @param id
	 * @param id_p
	 * @param token
	 * @return
	 */
	@PutMapping("{username}/campanhas/{id}/addP/{id_p}")
	public String addPersonaje(@PathVariable String username, @PathVariable Long id, @PathVariable Long id_p, @RequestHeader(value="Authorization") String token) {
		if (!validarToken(token)) { return null; }
		Usuario usuario = usuarioService.getUsuario(username);
		if (usuario == null)
			return null;
		Campanha c = campanhaService.getCampanha(id);
		if (c == null)
			return null;
		Personaje p = personajeService.getPersonaje(id_p);
		if (p == null)
			return null;
		return campanhaService.addPersonaje(c,p);
	}
	
	/**
	 * Petición PUT para eliminar un personaje de la campaña
	 * @param username
	 * @param id
	 * @param id_p
	 * @param token
	 * @return
	 */
	@PutMapping("{username}/campanhas/{id}/removeP/{id_p}")
	public String removePersonaje(@PathVariable String username, @PathVariable Long id, @PathVariable Long id_p, @RequestHeader(value="Authorization") String token) {
		if (!validarToken(token)) { return null; }
		Usuario usuario = usuarioService.getUsuario(username);
		if (usuario == null)
			return null;
		Campanha c = campanhaService.getCampanha(id);
		if (c == null)
			return null;
		Personaje p = personajeService.getPersonaje(id_p);
		if (p == null)
			return null;
		return campanhaService.removePersonaje(c,p);
	}
	
	/**
	 * Petición DELETE para eliminar una campaña
	 * @param username
	 * @param id
	 * @param token
	 * @return
	 */
	@DeleteMapping("{username}/campanhas/{id}")
	public String deleteCampanha(@PathVariable String username, @PathVariable Long id, @RequestHeader(value="Authorization") String token) {
		if (!validarToken(token)) { return null; }
		Usuario usuario = usuarioService.getUsuario(username);
		if (usuario == null)
			return null;
		Campanha c = campanhaService.getCampanha(id);
		if (c == null)
			return null;
		return campanhaService.deleteCampanha(id);
	}

}