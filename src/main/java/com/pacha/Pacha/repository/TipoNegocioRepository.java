package com.pacha.Pacha.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pacha.Pacha.entity.TipoNegocio;

@Repository
public interface TipoNegocioRepository  extends CrudRepository<TipoNegocio, Long>{

}
