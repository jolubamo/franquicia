package com.franquicia.service;

import java.util.List;

import com.franquicia.model.Producto;

public interface IProductoService extends IGeneralService<Producto, Integer>{

	//listar producto con mayor stock en cada sucursal para una franquicia especifica
	List<Producto> listarProductoMayorStock(int idFranquicia);
	
	void actualizarStock(Producto t);
	void actualizarNombre(Producto t);
}
