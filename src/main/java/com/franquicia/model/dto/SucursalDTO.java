package com.franquicia.model.dto;

import java.util.List;

import com.franquicia.model.Producto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SucursalDTO {

	private Integer id;
	private String nombre;
	private List<Producto> productos;
}
