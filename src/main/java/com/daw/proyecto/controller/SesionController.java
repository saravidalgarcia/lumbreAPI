package com.daw.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.daw.proyecto.dto.SesionDTO;
import com.daw.proyecto.entity.Campanha;
import com.daw.proyecto.entity.Sesion;
import com.daw.proyecto.entity.Usuario;
import com.daw.proyecto.service.CampanhaService;
import com.daw.proyecto.service.SesionService;
import com.daw.proyecto.service.UsuarioService;
import com.daw.proyecto.utils.JWTUtil;

/**
 * Controlador REST de peticiones relativas a sesiones
 *
 * @author Sara Vidal García
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST, RequestMethod.DELETE})
public class SesionController {
	
	@Autowired
	private SesionService sesionService;
	
	@Autowired
	private UsuarioService usuarioService;
	
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
	 * Petición GET para obtener el listado de sesiones (DTO) de un usuario
	 * @param username
	 * @param token
	 * @return
	 */
	@GetMapping("/{username}/sesiones")
	public ResponseEntity<List<SesionDTO>> getSesiones(@PathVariable String username, @RequestHeader(value="Authorization") String token){
		if (!validarToken(token)) { return ResponseEntity.status(401).body(null); }
		Usuario usuario = usuarioService.getUsuario(username);
		if (usuario == null) { return ResponseEntity.status(404).body(null); }
		List<SesionDTO> resultado = sesionService.getSesiones(usuario);
		return ResponseEntity.status((resultado != null) ? 200 : 400).body(resultado);
	}
	
	/**
	 * Petición GET para obtener el listado de sesiones (DTO) de un usuario para una campaña concreta
	 * @param username
	 * @param id_campanha
	 * @param token
	 * @return
	 */
	@GetMapping("/{username}/{id_campanha}/sesiones")
	public ResponseEntity<List<SesionDTO>> getSesiones(@PathVariable String username, @PathVariable Long id_campanha, @RequestHeader(value="Authorization") String token){
		if (!validarToken(token)) { return ResponseEntity.status(401).body(null); }
		Usuario usuario = usuarioService.getUsuario(username);
		Campanha campanha = campanhaService.getCampanha(id_campanha);
		if (usuario == null || campanha == null) { return ResponseEntity.status(404).body(null); }
		List<SesionDTO> resultado = sesionService.getSesiones(campanha);
		return ResponseEntity.status((resultado != null) ? 200 : 400).body(resultado);
	}
	
	/**
	 * Petición POST para crear una sesión
	 * @param username
	 * @param id_campanha
	 * @param token
	 * @param sesion
	 * @return
	 */
	@PostMapping("{username}/{id_campanha}/sesiones")
	public ResponseEntity<String> crearSesion(@PathVariable String username, @PathVariable Long id_campanha, @RequestHeader(value="Authorization") String token,@RequestBody Sesion sesion) {
		if (!validarToken(token)) { return ResponseEntity.status(401).body(null); }
		Usuario usuario = usuarioService.getUsuario(username);
		Campanha campanha = campanhaService.getCampanha(id_campanha);
		if (usuario == null || campanha == null) { return ResponseEntity.status(404).body(null); }
		sesion.setUsuario(usuario);
		sesion.setCampanha(campanha);
		String resultado = sesionService.crearSesion(sesion);
		return ResponseEntity.status((resultado.equals("OK")) ? 201 : 400).body(resultado);
	}
	
	/**
	 * Petición GET para obtener una sesión (DTO)
	 * @param username
	 * @param id_campanha
	 * @param id
	 * @param token
	 * @return
	 */
	@GetMapping("/{username}/{id_campanha}/sesiones/{id}")
	public ResponseEntity<SesionDTO> getSesion(@PathVariable String username, @PathVariable Long id_campanha, @PathVariable Long id, @RequestHeader(value="Authorization") String token){
		if (!validarToken(token)) { return ResponseEntity.status(401).body(null); }
		Usuario usuario = usuarioService.getUsuario(username);
		Campanha campanha = campanhaService.getCampanha(id_campanha);
		if (usuario == null || campanha == null) { return ResponseEntity.status(404).body(null); }
		SesionDTO resultado = sesionService.getSesionDTO(id, campanha);
		return ResponseEntity.status((resultado != null) ? 200 : 400).body(resultado);
	}
	
	/**
	 * Petición PUT para actualizar una sesión
	 * @param username
	 * @param id_campanha
	 * @param id
	 * @param token
	 * @param sesion
	 * @return
	 */
	@PutMapping("{username}/{id_campanha}/sesiones/{id}")
	public ResponseEntity<String> updateSesion(@PathVariable String username, @PathVariable Long id_campanha, @PathVariable Long id, @RequestHeader(value="Authorization") String token,@RequestBody Sesion sesion) {
		if (!validarToken(token)) { return ResponseEntity.status(401).body(null); }
		Usuario usuario = usuarioService.getUsuario(username);
		Campanha campanha = campanhaService.getCampanha(id_campanha);
		Sesion s = sesionService.getSesion(id, campanha);
		if (usuario == null || campanha == null || s == null) { return ResponseEntity.status(404).body(null); }
		s.setCampanha(campanha);
		s.setEstado(sesion.getEstado());
		s.setFecha(sesion.getFecha());
		s.setModificacion(sesion.getModificacion());
		s.setNombre(sesion.getNombre());
		s.setPlanificacion(sesion.getPlanificacion());
		s.setResultados(sesion.getResultados());
		String resultado = sesionService.updateSesion(s);
		return ResponseEntity.status((resultado.equals("OK")) ? 200 : 400).body(resultado);
	}
	
	/**
	 * Petición DELETE para eliminar una sesión
	 * @param username
	 * @param id_campanha
	 * @param id
	 * @param token
	 * @return
	 */
	@DeleteMapping("{username}/{id_campanha}/sesiones/{id}")
	public ResponseEntity<String> deleteSesion(@PathVariable String username, @PathVariable Long id_campanha, @PathVariable Long id, @RequestHeader(value="Authorization") String token) {
		if (!validarToken(token)) { return ResponseEntity.status(401).body(null); }
		Usuario usuario = usuarioService.getUsuario(username);
		Campanha campanha = campanhaService.getCampanha(id_campanha);
		Sesion s = sesionService.getSesion(id, campanha);
		if (usuario == null || campanha == null || s == null) { return ResponseEntity.status(404).body(null); }
		String resultado = sesionService.deleteSesion(id, campanha);
		return ResponseEntity.status((resultado.equals("OK")) ? 200 : 400).body(resultado);
	}

}