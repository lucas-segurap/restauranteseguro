
package com.br.restauranteseguro.service;

import com.br.restauranteseguro.model.clientes;
import com.br.restauranteseguro.repository.clientesrepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class clienteservice {

    private final clientesrepository clientesRepository;
    private final PasswordEncoder passwordEncoder;

    // Construtor
    public clienteservice(clientesrepository clientesRepository,
                          PasswordEncoder passwordEncoder) {

        this.clientesRepository = clientesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Cadastrar cliente
    public clientes cadastrar(clientes cliente) {

        // Validar campos obrigatórios
        if (cliente.getNome() == null || cliente.getNome().isBlank()
                || cliente.getCpf() == null || cliente.getCpf().isBlank()
                || cliente.getEmail() == null || cliente.getEmail().isBlank()
                || cliente.getSenha() == null || cliente.getSenha().isBlank()) {

            throw new IllegalArgumentException(
                    "Preencha todos os campos obrigatórios."
            );
        }

        // Verificar tamanho da senha
        if (cliente.getSenha().length() < 8
                || cliente.getSenha().length() > 72) {

            throw new IllegalArgumentException(
                    "A senha deve ter entre 8 e 72 caracteres."
            );
        }

        // Verificar CPF duplicado
        if (clientesRepository.findByCpf(cliente.getCpf()).isPresent()) {

            throw new IllegalArgumentException(
                    "CPF já cadastrado."
            );
        }

        // Verificar e-mail duplicado
        if (clientesRepository.findByEmail(cliente.getEmail()).isPresent()) {

            throw new IllegalArgumentException(
                    "E-mail já cadastrado."
            );
        }

        // Criptografar senha
        cliente.setSenha(
                passwordEncoder.encode(cliente.getSenha())
        );

        // Configurações iniciais
        cliente.setSaldo(BigDecimal.ZERO);
        cliente.setDataCadastro(LocalDateTime.now());
        cliente.setAtivo(true);
        cliente.setHistorico("");

        // Salvar cliente
        return clientesRepository.save(cliente);
    }

    // Buscar cliente pelo ID
    public Optional<clientes> buscarPorId(Long id) {

        return clientesRepository.findById(id);
    }

    // Listar todos os clientes
    public List<clientes> listarTodos() {

        return clientesRepository.findAll();
    }

}
