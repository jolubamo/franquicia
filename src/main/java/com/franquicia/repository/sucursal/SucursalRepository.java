package com.franquicia.repository.sucursal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.franquicia.model.Sucursal;

@Repository
public class SucursalRepository implements ISucursalRepository{

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Autowired
	private SucursalMapeador mapeo;
	
	@Override
	public Integer insertar(Sucursal t) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", t.getNombre());
		parameter.addValue("franquicia", t.getFranquicia().getId());

		String sql = "INSERT into sucursal (suc_nombre,fra_id) values(:nombre, :franquicia)";

		final KeyHolder holder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(sql, parameter, holder);
		return holder.getKey().intValue();
	}

	@Override
	public void actualizar(Sucursal t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Sucursal listarPorId(Integer id) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("id", id);
        String sql = "select * from sucursal where suc_id = :id";
        List<Sucursal> lstSucursales = namedJdbcTemplate.query(sql, parameter, mapeo);

        return lstSucursales.get(0);
	}

	@Override
	public List<Sucursal> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void actualizarNombre(Sucursal t) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", t.getNombre());
		parameter.addValue("id", t.getId());

        String sql = "UPDATE sucursal SET suc_nombre = :nombre WHERE suc_id = :id;";

        namedJdbcTemplate.update(sql, parameter);
		
	}

}
