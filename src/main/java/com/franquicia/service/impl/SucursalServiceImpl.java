package com.franquicia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franquicia.model.Sucursal;
import com.franquicia.repository.generico.GeneralRepo;
import com.franquicia.repository.sucursal.ISucursalRepository;
import com.franquicia.service.ISucursalService;

@Service
public class SucursalServiceImpl extends GeneralServiceImpl<Sucursal, Integer> implements ISucursalService{

	@Autowired
	private ISucursalRepository repo;
	
	@Override
	protected GeneralRepo<Sucursal, Integer> getRepo() {
		return repo;
	}

}
