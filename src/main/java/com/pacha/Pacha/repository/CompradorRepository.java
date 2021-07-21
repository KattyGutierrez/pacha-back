package com.pacha.Pacha.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pacha.Pacha.entity.Comprador;

@Repository
public interface CompradorRepository extends CrudRepository<Comprador, Long> {



}
