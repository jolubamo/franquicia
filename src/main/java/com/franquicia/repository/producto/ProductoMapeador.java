package com.franquicia.repository.producto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.franquicia.model.Producto;
import com.franquicia.repository.sucursal.ISucursalRepository;

@Component
public class ProductoMapeador implements RowMapper<Producto>{

	@Autowired
	private ISucursalRepository sucursalRepo;
	
	@Override
	public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
		Producto producto = new Producto();
		producto.setId(rs.getInt("pro_id"));
		producto.setNombre(rs.getString("pro_nombre"));
		producto.setStock(rs.getInt("pro_stock"));
		producto.setSucursal(sucursalRepo.listarPorId(rs.getInt("suc_id")));
		return producto;
	}
}
