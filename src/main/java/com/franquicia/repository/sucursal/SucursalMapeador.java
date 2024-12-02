package com.franquicia.repository.sucursal;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.franquicia.model.Sucursal;
import com.franquicia.repository.franquicia.IFranquiciaRepository;

@Component
public class SucursalMapeador implements RowMapper<Sucursal>{

	@Autowired
	private IFranquiciaRepository franquiciaRepo;
	
	@Override
	public Sucursal mapRow(ResultSet rs, int rowNum) throws SQLException {
		Sucursal sucursal = new Sucursal();
		sucursal.setId(rs.getInt("suc_id"));
		sucursal.setNombre(rs.getString("suc_nombre"));
		sucursal.setFranquicia(franquiciaRepo.listarPorId(rs.getInt("fra_id")));
		return sucursal;
	}
}
