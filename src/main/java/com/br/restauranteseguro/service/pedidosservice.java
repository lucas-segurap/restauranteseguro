
package com.br.restauranteseguro.service;

import com.br.restauranteseguro.model.pedidos;
import com.br.restauranteseguro.repository.pedidosrepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class pedidosservice {

    private final pedidosrepository pedidosrepository;

    public pedidosservice(pedidosrepository pedidosrepository) {
        this.pedidosrepository = pedidosrepository;
    }

    // Cadastrar ou atualizar pedido
    public pedidos salvar(pedidos pedido) {
        return pedidosrepository.save(pedido);
    }

    // Listar todos os pedidos
    public List<pedidos> listarTodos() {
        return pedidosrepository.findAll();
    }

    // Buscar pedido pelo ID
    public Optional<pedidos> buscarPorId(Long id) {
        return pedidosrepository.findById(id);
    }

    // Excluir pedido pelo ID
    public void excluir(Long id) {
        pedidosrepository.deleteById(id);
    }

    // Verificar se o pedido existe
    public boolean existe(Long id) {
        return pedidosrepository.existsById(id);
    }
}
