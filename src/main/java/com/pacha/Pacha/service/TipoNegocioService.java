package com.pacha.Pacha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pacha.Pacha.entity.TipoNegocio;
import com.pacha.Pacha.repository.TipoNegocioRepository;

@Service
public class TipoNegocioService {
	@Autowired
	TipoNegocioRepository repo;
	
	public TipoNegocio getTipoNegocio(Long id) {
		return repo.findById(id).get();
	}
	
	public Iterable<TipoNegocio> getTipoNegocios(){
		return repo.findAll();
	}
}
