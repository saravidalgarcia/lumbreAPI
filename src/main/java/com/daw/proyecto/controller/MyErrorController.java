package com.daw.proyecto.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST, RequestMethod.DELETE})
public class MyErrorController implements ErrorController{
	
	/**
	 * Punto de entrada de cualquier petición inválida
	 * @return
	 */
	@RequestMapping("/error")
	public ResponseEntity<String> getError(){
		int status = 404;
		String mensaje = "Error: La petición es incorrecta. Consulta el listado completo de peticiones de LumbreAPI en <a href='http://localhost:8080/lumbre/'>http://localhost:8080/lumbre/</a>";
	    return ResponseEntity.status(status).body(mensaje);
	}

}
