
package com.br.restauranteseguro.service;

import com.br.restauranteseguro.model.clientes;
import com.br.restauranteseguro.repository.clientesrepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Loginservice {

    private final clientesrepository clientesRepository;
    private final PasswordEncoder passwordEncoder;

    // Construtor
    public Loginservice(clientesrepository clientesRepository,
                        PasswordEncoder passwordEncoder) {

        this.clientesRepository = clientesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Realizar login
    public Optional<clientes> autenticar(String email, String senha) {

        // Procurar cliente pelo e-mail
        Optional<clientes> resultado =
                clientesRepository.findByEmail(email);

        // Verificar se o cliente existe
        if (resultado.isEmpty()) {
            return Optional.empty();
        }

        clientes cliente = resultado.get();

        // Verificar se a conta está ativa
        if (!Boolean.TRUE.equals(cliente.getAtivo())) {
            return Optional.empty();
        }

        // Verificar a senha
        if (!passwordEncoder.matches(senha, cliente.getSenha())) {
            return Optional.empty();
        }

        // Login autorizado
        return Optional.of(cliente);
    }
}
