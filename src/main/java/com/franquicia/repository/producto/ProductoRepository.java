package com.franquicia.repository.producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.franquicia.model.Producto;

@Repository
public class ProductoRepository implements IProductoRepository{

	@Autowired
	private ProductoMapeador mapeo;
	
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Override
	public Integer insertar(Producto t) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", t.getNombre());
		parameter.addValue("stock", t.getStock());
		parameter.addValue("sucursal", t.getSucursal().getId());

		String sql = "INSERT into producto (pro_nombre,pro_stock ,suc_id) values(:nombre, :stock, :sucursal)";

		final KeyHolder holder = new GeneratedKeyHolder();
		namedJdbcTemplate.update(sql, parameter, holder);
		return holder.getKey().intValue();
	}

	@Override
	public void actualizar(Producto t) {
		
	}

	@Override
	public void eliminar(Integer id) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("id", id);

		String sql = "DELETE FROM producto WHERE pro_id = :id;";

		namedJdbcTemplate.update(sql, parameter);
		
	}

	@Override
	public Producto listarPorId(Integer id) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("id", id);
        String sql = "select * from producto where pro_id = :id";
        List<Producto> lstProductos = namedJdbcTemplate.query(sql, parameter, mapeo);

        return lstProductos.get(0);
	}

	@Override
	public List<Producto> listar() {
		String sql = "select * from producto";
		List<Producto> lstProductos = namedJdbcTemplate.query(sql, mapeo);
		return lstProductos;
	}

	@Override
	public void actualizarNombre(Producto t) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("nombre", t.getNombre());
		parameter.addValue("id", t.getId());

        String sql = "UPDATE producto SET pro_nombre = :nombre WHERE pro_id = :id;";

        namedJdbcTemplate.update(sql, parameter);
		
	}

	@Override
	public void actualizarStock(Producto t) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
		parameter.addValue("stock", t.getStock());
		parameter.addValue("id", t.getId());

        String sql = "UPDATE producto SET pro_stock = :stock WHERE pro_id = :id;";

        namedJdbcTemplate.update(sql, parameter);
		
	}

	@Override
	public List<Producto> listarProductoMayorStock(int idFranquicia) {
		MapSqlParameterSource parameter = new MapSqlParameterSource();
        parameter.addValue("idFranquicia", idFranquicia);
		String sql = "select p.* from producto p join sucursal s on s.suc_id = p.suc_id "
				+ "where p.pro_stock = (select max(p2.pro_stock) from producto p2 where p2.suc_id = p.suc_id) and s.fra_id = :idFranquicia;";
		List<Producto> lstProductos = namedJdbcTemplate.query(sql, parameter, mapeo);
		return lstProductos;
	}

}
