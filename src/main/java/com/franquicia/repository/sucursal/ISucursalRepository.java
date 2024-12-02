package com.franquicia.repository.sucursal;

import com.franquicia.model.Sucursal;
import com.franquicia.repository.generico.GeneralRepo;

public interface ISucursalRepository extends GeneralRepo<Sucursal, Integer>{

	void actualizarNombre(Sucursal t);

}
