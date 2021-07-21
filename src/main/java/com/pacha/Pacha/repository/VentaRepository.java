package com.pacha.Pacha.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pacha.Pacha.entity.Venta;


@Repository
public interface VentaRepository extends CrudRepository<Venta, Long> {

}
