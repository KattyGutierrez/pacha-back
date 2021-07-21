package com.pacha.Pacha.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pacha.Pacha.entity.Categoria;
import com.pacha.Pacha.entity.Negocio;
import com.pacha.Pacha.entity.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{

	Iterable<Producto> findAllByOrderByPuntuacionAsc();

	Iterable<Producto> findAllByCategoriaAndNegocioOrderByPuntuacionAsc(Categoria c,Negocio n);



	Iterable<Producto> findAllByNegocioOrderByPuntuacionAsc(Negocio n);


	Iterable<Producto> findAllByNegocioOrderByIdAsc(Negocio n);

}
