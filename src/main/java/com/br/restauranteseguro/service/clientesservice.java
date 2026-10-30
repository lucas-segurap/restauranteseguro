
package com.br.restauranteseguro.service;

import com.br.restauranteseguro.model.clientes;
import com.br.restauranteseguro.repository.clientesrepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class clientesservice {

    private final clientesrepository clientesrepository;

    public clientesservice(clientesrepository clientesrepository) {
        this.clientesrepository = clientesrepository;
    }

    // Cadastrar ou atualizar cliente
    public clientes salvar(clientes cliente) {
        return clientesrepository.save(cliente);
    }

    // Listar todos os clientes
    public List<clientes> listarTodos() {
        return clientesrepository.findAll();
    }

    // Buscar cliente pelo ID
    public Optional<clientes> buscarPorId(Long id) {
        return clientesrepository.findById(id);
    }

    // Excluir cliente pelo ID
    public void excluir(Long id) {
        clientesrepository.deleteById(id);
    }

    // Verificar se o cliente existe
    public boolean existe(Long id) {
        return clientesrepository.existsById(id);
    }
}
