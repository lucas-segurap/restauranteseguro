
package com.br.restauranteseguro.repository;

import com.br.restauranteseguro.model.pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface pedidosrepository extends JpaRepository<pedidos, Long> {

    // Buscar todos os pedidos de um cliente pelo CPF
    List<pedidos> findByCpf(String cpf);

}
