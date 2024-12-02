package com.franquicia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franquicia.model.Producto;
import com.franquicia.repository.generico.GeneralRepo;
import com.franquicia.repository.producto.IProductoRepository;
import com.franquicia.service.IProductoService;

@Service
public class ProductoServiceImpl extends GeneralServiceImpl<Producto, Integer> implements IProductoService{

	@Autowired
	private IProductoRepository repo;
	
	@Override
	protected GeneralRepo<Producto, Integer> getRepo() {
		return repo;
	}

	@Override
	public List<Producto> listarProductoMayorStock(int idFranquicia) {
		return repo.listarProductoMayorStock(idFranquicia);
	}

	@Override
	public void actualizarStock(Producto t) {
		repo.actualizarStock(t);
		
	}

	@Override
	public void actualizarNombre(Producto t) {
		repo.actualizarNombre(t);
	}

}
