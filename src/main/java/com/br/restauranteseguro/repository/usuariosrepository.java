package com.br.restauranteseguro.repository;

import com.br.restauranteseguro.model.usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usuariosrepository extends JpaRepository<usuarios, Long> {

}
