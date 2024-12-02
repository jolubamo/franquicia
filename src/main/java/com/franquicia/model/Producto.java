package com.franquicia.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Producto {

	private Integer id;
	private String nombre;
	private int stock;
	private Sucursal sucursal;
}
