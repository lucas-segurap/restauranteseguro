
package com.br.restauranteseguro.service;

import com.br.restauranteseguro.model.catalogo;
import com.br.restauranteseguro.repository.catalogorepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class catalogoservice {

    private final catalogorepository catalogorepository;

    public catalogoservice(catalogorepository catalogorepository) {
        this.catalogorepository = catalogorepository;
    }

    // Cadastrar ou atualizar produto
    public catalogo salvar(catalogo produto) {
        return catalogorepository.save(produto);
    }

    // Listar todos os produtos
    public List<catalogo> listarTodos() {
        return catalogorepository.findAll();
    }

    // Buscar produto pelo ID
    public Optional<catalogo> buscarPorId(Long id) {
        return catalogorepository.findById(id);
    }

    // Excluir produto pelo ID
    public void excluir(Long id) {
        catalogorepository.deleteById(id);
    }

    // Verificar se o produto existe
    public boolean existe(Long id) {
        return catalogorepository.existsById(id);
    }
}
