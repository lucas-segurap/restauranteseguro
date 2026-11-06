
package com.br.restauranteseguro.repository;

import com.br.restauranteseguro.model.clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface clientesrepository extends JpaRepository<clientes, Long> {

    // Buscar cliente pelo CPF
    Optional<clientes> findByCpf(String cpf);

    // Buscar cliente pelo e-mail
    Optional<clientes> findByEmail(String email);

}
