package com.franquicia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.franquicia.model.Producto;
import com.franquicia.service.IProductoService;

@RestController
@RequestMapping(path = "/producto")
public class ProductoController {
	
	@Autowired
	private IProductoService service;
	
	@GetMapping()
	public ResponseEntity<List<Producto>> listar() throws Exception {
		List<Producto> productos = service.listar();
		return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
	}
	
	@GetMapping(path="/mayor-stock/{franquiciaId}")
	public ResponseEntity<List<Producto>> listarProductoMayorStock(@PathVariable int franquiciaId) throws Exception {
		List<Producto> productos = service.listarProductoMayorStock(franquiciaId);
		return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<?> insertar(@RequestBody Producto producto) throws Exception {
		Integer resultado = service.insertar(producto);
		return new ResponseEntity<>(resultado, HttpStatus.CREATED);
	}
	
}
