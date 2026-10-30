
package com.br.restauranteseguro.service;

import com.br.restauranteseguro.model.usuarios;
import com.br.restauranteseguro.repository.usuariosrepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class usuariosservice {

    private final usuariosrepository usuariosrepository;

    public usuariosservice(usuariosrepository usuariosrepository) {
        this.usuariosrepository = usuariosrepository;
    }

    // Cadastrar ou atualizar usuário
    public usuarios salvar(usuarios usuario) {
        return usuariosrepository.save(usuario);
    }

    // Listar todos os usuários
    public List<usuarios> listarTodos() {
        return usuariosrepository.findAll();
    }

    // Buscar usuário pelo ID
    public Optional<usuarios> buscarPorId(Long id) {
        return usuariosrepository.findById(id);
    }

    // Excluir usuário pelo ID
    public void excluir(Long id) {
        usuariosrepository.deleteById(id);
    }

    // Verificar se o usuário existe
    public boolean existe(Long id) {
        return usuariosrepository.existsById(id);
    }
}
