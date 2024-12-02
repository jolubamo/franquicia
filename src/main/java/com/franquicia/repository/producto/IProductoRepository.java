package com.franquicia.repository.producto;

import java.util.List;

import com.franquicia.model.Producto;
import com.franquicia.repository.generico.GeneralRepo;

public interface IProductoRepository extends GeneralRepo<Producto, Integer>{

	void actualizarNombre(Producto t);
	void actualizarStock(Producto t);
	
	//listar producto con mayor stock en cada sucursal para una franquicia especifica
	List<Producto> listarProductoMayorStock(int idFranquicia);
}
