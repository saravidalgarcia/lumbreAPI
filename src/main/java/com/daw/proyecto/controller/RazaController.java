package com.daw.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daw.proyecto.dto.RazaDTO;
import com.daw.proyecto.entity.Raza;
import com.daw.proyecto.entity.Usuario;
import com.daw.proyecto.service.RazaService;
import com.daw.proyecto.service.UsuarioService;
import com.daw.proyecto.utils.JWTUtil;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST, RequestMethod.DELETE})
public class RazaController {

	@Autowired
	private RazaService razaService;
	
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
	 * Petición GET para obtener el listado de razas (DTO)
	 * @param username
	 * @param token
	 * @return
	 */
	@GetMapping("/{username}/razas")
	public List<RazaDTO> getRazas(@PathVariable String username, @RequestHeader(value="Authorization") String token){
		if (!validarToken(token)) { return null; }
		Usuario u = usuarioService.getUsuario(username);
		if (u == null)
			return null;
		return razaService.getRazas(u);
	}
	
	/**
	 * Petición POST para la creación de una raza
	 * @param username
	 * @param token
	 * @param raza
	 * @return
	 */
	@PostMapping("{username}/razas")
	public String crearRaza(@PathVariable String username, @RequestHeader(value="Authorization") String token,@RequestBody Raza raza) {
		if (!validarToken(token)) { return null; }
		Usuario u = usuarioService.getUsuario(username);
		if (u == null)
			return null;
		raza.setUsuario(u);
		return razaService.crearRaza(raza);
	}
	
	/**
	 * Petición GET para obtener una raza (DTO) por su id
	 * @param username
	 * @param id
	 * @param token
	 * @return
	 */
	@GetMapping("/{username}/razas/{id}")
	public RazaDTO getRaza(@PathVariable String username, @PathVariable Long id, @RequestHeader(value="Authorization") String token){
		if (!validarToken(token)) { return null; }
		if (usuarioService.getUsuario(username) == null) {return null;}
		return razaService.getRazaDTO(id);
	}
	
	/**
	 * Petición PUT para actualizar una raza por su id
	 * @param username
	 * @param id
	 * @param token
	 * @param raza
	 * @return
	 */
	@PutMapping("{username}/razas/{id}")
	public String updateRaza(@PathVariable String username, @PathVariable Long id, @RequestHeader(value="Authorization") String token,@RequestBody Raza raza) {
		if (!validarToken(token)) { return null; }
		if (usuarioService.getUsuario(username) == null) {return null;}
		if (razaService.getRaza(id) == null) {return null;}
		Raza r = razaService.getRaza(id);
		r.setDenominacion(raza.getDenominacion());
		r.setDescripcion(raza.getDescripcion());
		r.setModificacion(raza.getModificacion());
		return razaService.updateRaza(r);
	}
	
	/**
	 * Petición DELETE para eliminar una raza por su id
	 * @param username
	 * @param id
	 * @param token
	 * @return
	 */
	@DeleteMapping("{username}/razas/{id}")
	public String deleteRaza(@PathVariable String username, @PathVariable Long id, @RequestHeader(value="Authorization") String token) {
		if (!validarToken(token)) { return null; }
		if (usuarioService.getUsuario(username) == null) {return null;}
		if (razaService.getRaza(id) == null) {return null;}
		return razaService.deleteRaza(id);
	}

}