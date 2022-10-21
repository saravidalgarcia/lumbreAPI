package com.daw.proyecto.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.daw.proyecto.dto.PersonajeDTO;
import com.daw.proyecto.entity.Campanha;
import com.daw.proyecto.entity.Personaje;
import com.daw.proyecto.entity.Usuario;
import com.daw.proyecto.service.CampanhaService;
import com.daw.proyecto.service.PersonajeService;
import com.daw.proyecto.service.RazaService;
import com.daw.proyecto.service.UsuarioService;
import com.daw.proyecto.utils.JWTUtil;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST, RequestMethod.DELETE})
public class PersonajeController {

	@Autowired
	private PersonajeService personajeService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RazaService razaService;
	
	@Autowired
	private CampanhaService campanhaService;

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
	 * Recibe un tipo de archivo y comprueba si se corresponde con una imagen
	 * @param contentType
	 * @return
	 */
	private static boolean esImagen(String contentType) {
		boolean esImagen = !ObjectUtils.isEmpty(contentType) && (
			contentType.equals("image/gif") || 
			contentType.equals("image/png") || 
			contentType.equals("image/jpg") || 
			contentType.equals("image/jpeg") || 
			contentType.equals("image/pjpeg")	
		);
		return esImagen;
	}
	
	/**
	 * Petición GET para obtener el listado de personajes (DTO) de un usuario
	 * @param username
	 * @param token
	 * @return
	 */
	@GetMapping("/{username}/personajes")
	public List<PersonajeDTO> getPersonajes(@PathVariable String username, @RequestHeader(value="Authorization") String token){
		if (!validarToken(token)) { return null; }
		Usuario u = usuarioService.getUsuario(username);
		if (u == null)
			return null;
		return personajeService.getPersonajes(u);
	}
	
	/**
	 * Petición GET para obtener un personaje (DTO)
	 * @param username
	 * @param id
	 * @param token
	 * @return
	 */
	@GetMapping("/{username}/personajes/{id}")
	public PersonajeDTO getPersonaje(@PathVariable String username, @PathVariable Long id, @RequestHeader(value="Authorization") String token){
		if (!validarToken(token)) { return null; }
		if (usuarioService.getUsuario(username) == null) {return null;}
		return personajeService.getPersonajeDTO(id);
	}
	
	
	/**
	 * Petición POST para la creación de un personaje
	 * @param username
	 * @param token
	 * @param file
	 * @param nombre
	 * @param idraza
	 * @param jugador
	 * @param informacion
	 * @return
	 */
	@PostMapping("{username}/personajes")
	public String crearPersonaje(@PathVariable String username, @RequestHeader(value="Authorization") String token,
			@RequestParam("file") MultipartFile file,
    		@RequestParam("nombre") String nombre,
    		@RequestParam("raza") Long idraza,
    		@RequestParam("jugador") String jugador, 
    		@RequestParam("informacion") String informacion){
		if (!validarToken(token)) { return null; }
	    if (!esImagen(file.getContentType())) {
	    	return "Formato de imagen incorrecto";
	    }
		Personaje p = new Personaje();
		try {
			p.setImagen(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p.setNombre(nombre);
		p.setJugador(jugador);
		p.setInformacion(informacion);
		p.setCreacion(LocalDate.now());
		p.setModificacion(LocalDate.now());
		p.setRaza(razaService.getRaza(idraza));
		p.setUsuario(usuarioService.getUsuario(username));
		return personajeService.crearPersonaje(p);
	}
	
	/**
	 * Petición PUT para la actualización de un personaje
	 * @param username
	 * @param id
	 * @param token
	 * @param file
	 * @param nombre
	 * @param idraza
	 * @param jugador
	 * @param informacion
	 * @return
	 */
	@PutMapping("{username}/personajes/{id}")
	public String updatePersonaje(@PathVariable String username, @PathVariable Long id, @RequestHeader(value="Authorization") String token,
			@RequestParam("file") MultipartFile file,
    		@RequestParam("nombre") String nombre,
    		@RequestParam("raza") Long idraza,
    		@RequestParam("jugador") String jugador, 
    		@RequestParam("informacion") String informacion){
		if (!validarToken(token)) { return null; }
		Personaje p = personajeService.getPersonaje(id);
	    String contentType = file.getContentType();  
	    if (!contentType.equals("application/octet-stream")) {
	    	if (!esImagen(contentType)) {
		    	return "Formato de imagen incorrecto "+contentType;
		    }
			try {
				p.setImagen(Base64.getEncoder().encodeToString(file.getBytes()));
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
		p.setNombre(nombre);
		p.setRaza(razaService.getRaza(idraza));
		p.setJugador(jugador);
		p.setInformacion(informacion);
		p.setModificacion(LocalDate.now());
		return personajeService.updatePersonaje(p);
	}
	
	/**
	 * Petición DELETE para eliminar un personaje
	 * @param username
	 * @param id
	 * @param token
	 * @return
	 */
	@DeleteMapping("{username}/personajes/{id}")
	public String deletePersonaje(@PathVariable String username, @PathVariable Long id, @RequestHeader(value="Authorization") String token) {
		if (!validarToken(token)) { return null; }
		if (usuarioService.getUsuario(username) == null) {return null;}
		if (personajeService.getPersonaje(id) == null) {return null;}
		return personajeService.deletePersonaje(id);
	}

}