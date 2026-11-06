
package com.br.restauranteseguro.controller;

import com.br.restauranteseguro.model.clientes;
import com.br.restauranteseguro.service.clienteservice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class clientescontroller {

    private final clienteservice clienteService;

    // Construtor
    public clientescontroller(clienteservice clienteService) {
        this.clienteService = clienteService;
    }

    // Abrir página de cadastro
    @GetMapping("/cadastro")
    public String abrirCadastro(Model model) {

        model.addAttribute("cliente", new clientes());

        return "clientes/cadastro";
    }

    // Processar cadastro
    @PostMapping("/cadastrar")
    public String cadastrar(
            @ModelAttribute("cliente") clientes cliente,
            Model model) {

        try {

            // Salvar cliente
            clienteService.cadastrar(cliente);

            // Mensagem de sucesso
            model.addAttribute(
                    "sucesso",
                    "Cadastro realizado com sucesso! Agora você pode entrar."
            );

            // Limpar formulário
            model.addAttribute("cliente", new clientes());

            return "clientes/cadastro";

        } catch (IllegalArgumentException e) {

            // Mensagem de erro
            model.addAttribute("erro", e.getMessage());

            // Preservar dados preenchidos, exceto senha
            cliente.setSenha("");
            model.addAttribute("cliente", cliente);

            return "clientes/cadastro";
        }
    }
}
