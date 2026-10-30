
package com.br.restauranteseguro.repository;

import com.br.restauranteseguro.model.clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clientesrepository extends JpaRepository<clientes, Long> {

}
