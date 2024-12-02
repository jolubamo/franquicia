package com.franquicia.model.dto;

import java.util.List;

import com.franquicia.model.Sucursal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FranquiciaDTO {

	private Integer id;
	private String nombre;
	private List<Sucursal> sucursales;
}
