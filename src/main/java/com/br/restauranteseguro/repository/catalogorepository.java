package com.br.restauranteseguro.repository;

import com.br.restauranteseguro.model.catalogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface catalogorepository extends JpaRepository<catalogo, Long> {

}
