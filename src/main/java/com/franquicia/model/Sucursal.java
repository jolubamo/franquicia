package com.franquicia.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Sucursal {

	private Integer id;
	private String nombre;
	private Franquicia franquicia;
}
