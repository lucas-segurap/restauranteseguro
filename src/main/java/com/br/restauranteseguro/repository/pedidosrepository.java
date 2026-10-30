package com.br.restauranteseguro.repository;


import com.br.restauranteseguro.model.pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface pedidosrepository extends JpaRepository<pedidos, Long> {

}
