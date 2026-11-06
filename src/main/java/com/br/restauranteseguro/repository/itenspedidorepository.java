
package com.br.restauranteseguro.repository;

import com.br.restauranteseguro.model.itenspedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface itenspedidorepository
        extends JpaRepository<itenspedido, Long> {

    List<itenspedido> findByPedidoId(Long pedidoId);

}
