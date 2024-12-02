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

import com.franquicia.model.Sucursal;
import com.franquicia.service.ISucursalService;

@RestController
@RequestMapping(path = "/sucursal")
public class SucursalController {

	@Autowired
	private ISucursalService service;
	
	@GetMapping()
	public ResponseEntity<List<Sucursal>> listar() throws Exception {
		List<Sucursal> sucursales = service.listar();
		return new ResponseEntity<List<Sucursal>>(sucursales, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<?> insertar(@RequestBody Sucursal sucursal) throws Exception {
		Integer resultado = service.insertar(sucursal);
		return new ResponseEntity<>(resultado, HttpStatus.CREATED);
	}
	
	@PutMapping(path="/nombre")
	public ResponseEntity<?> actualizarNombre(@RequestBody Sucursal sucursal)  throws Exception{
		service.actualizarNombre(sucursal);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
