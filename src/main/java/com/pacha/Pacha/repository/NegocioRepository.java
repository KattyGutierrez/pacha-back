package com.pacha.Pacha.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pacha.Pacha.entity.Negocio;
import com.pacha.Pacha.entity.TipoNegocio;

@Repository
public interface NegocioRepository extends CrudRepository<Negocio, Long>{

	Iterable<Negocio> findAllByOrderByPuntuacionAsc();



	Iterable<Negocio> findAllByTipoNegocioOrderByPuntuacionAsc(TipoNegocio tn);

}
