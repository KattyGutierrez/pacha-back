package com.pacha.Pacha.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pacha.Pacha.entity.Categoria;


@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

	Iterable<Categoria> findAllByOrderByIdAsc();

}
