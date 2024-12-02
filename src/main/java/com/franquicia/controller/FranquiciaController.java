package com.franquicia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.franquicia.model.Franquicia;
import com.franquicia.service.IFranquiciaService;

@RestController
@RequestMapping(path = "/franquicia")
public class FranquiciaController {

	@Autowired
	private IFranquiciaService service;
	
	@GetMapping()
	public ResponseEntity<List<Franquicia>> listar() throws Exception {
		List<Franquicia> franquicias = service.listar();
		return new ResponseEntity<List<Franquicia>>(franquicias, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<?> insertar(@RequestBody Franquicia franquicia) throws Exception {
		Integer resultado = service.insertar(franquicia);
		return new ResponseEntity<>(resultado, HttpStatus.CREATED);
	}
	
	@PutMapping(path="/nombre")
	public ResponseEntity<?> actualizarNombre(@RequestBody Franquicia franquicia)  throws Exception{
		service.actualizar(franquicia);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
