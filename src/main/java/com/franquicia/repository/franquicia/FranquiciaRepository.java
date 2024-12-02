package com.franquicia.repository.franquicia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.franquicia.model.Franquicia;

@Repository
public class FranquiciaRepository implements IFranquiciaRepository{

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Autowired
	private FranquiciaMapeador mapeo;
	
	@Override
	public Integer insertar(Franquicia t) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", t.getNombre());

		String sql = "INSERT into franquicia (fra_nombre) values(:nombre)";

		final KeyHolder holder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(sql, parameter, holder);
		return holder.getKey().intValue();
	}

	@Override
	public void actualizar(Franquicia t) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", t.getNombre());
		parameter.addValue("id", t.getId());

        String sql = "UPDATE franquicia SET fra_nombre = :nombre WHERE fra_id = :id;";

        namedJdbcTemplate.update(sql, parameter);
		
	}

	@Override
	public void eliminar(Integer id) {
		
	}

	@Override
	public Franquicia listarPorId(Integer id) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("id", id);
        String sql = "select * from franquicia where fra_id = :id";
        List<Franquicia> lstFranquicias = namedJdbcTemplate.query(sql, parameter, mapeo);

        return lstFranquicias.get(0);
	}

	@Override
	public List<Franquicia> listar() {
		return null;
	}
	
}
