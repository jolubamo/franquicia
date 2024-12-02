package com.franquicia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franquicia.model.Franquicia;
import com.franquicia.repository.franquicia.IFranquiciaRepository;
import com.franquicia.repository.generico.GeneralRepo;
import com.franquicia.service.IFranquiciaService;

@Service
public class FranquiciaServiceImpl extends GeneralServiceImpl<Franquicia, Integer> implements IFranquiciaService{

	@Autowired
	private IFranquiciaRepository repo;
	
	@Override
	protected GeneralRepo<Franquicia, Integer> getRepo() {
		return repo;
	}

}
