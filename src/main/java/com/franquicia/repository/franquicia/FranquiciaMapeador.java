package com.franquicia.repository.franquicia;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.franquicia.model.Franquicia;

@Component
public class FranquiciaMapeador implements RowMapper<Franquicia>{

	@Override
	public Franquicia mapRow(ResultSet rs, int rowNum) throws SQLException {
		Franquicia franquicia = new Franquicia();
		franquicia.setId(rs.getInt("fra_id"));
		franquicia.setNombre(rs.getString("fra_nombre"));
		return franquicia;
	}

}
