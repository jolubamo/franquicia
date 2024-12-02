package com.franquicia.repository.producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.franquicia.model.Producto;

public class ProductoRepository implements IProductoRepository{

	@Autowired
	private ProductoMapeador mapeador;
	
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Override
	public Integer insertar(Producto t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Producto t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
