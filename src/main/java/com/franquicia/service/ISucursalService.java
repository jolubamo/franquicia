package com.franquicia.service;

import com.franquicia.model.Sucursal;

public interface ISucursalService extends IGeneralService<Sucursal, Integer>{

	void actualizarNombre(Sucursal t);
}
