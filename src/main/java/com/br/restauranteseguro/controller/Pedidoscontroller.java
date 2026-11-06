
package com.br.restauranteseguro.controller;

import com.br.restauranteseguro.model.clientes;
import com.br.restauranteseguro.service.pedidosservice;
import com.br.restauranteseguro.repository.clientesrepository;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Pedidoscontroller {

    private final pedidosservice pedidosService;
    private final clientesrepository clientesRepository;

    public Pedidoscontroller(
            pedidosservice pedidosService,
            clientesrepository clientesRepository) {

        this.pedidosService = pedidosService;
        this.clientesRepository = clientesRepository;
    }

    // Abrir página de pedidos
    @GetMapping("/pedidos")
    public String abrirPedidos(HttpSession session, Model model) {

        // Verificar se o cliente está logado
        Object clienteId = session.getAttribute("clienteId");

        if (clienteId == null) {
            return "redirect:/login";
        }

        // Buscar cliente pelo ID da sessão
        clientes cliente = clientesRepository.findById(
                Long.valueOf(clienteId.toString())
        ).orElse(null);

        if (cliente == null) {
            session.invalidate();
            return "redirect:/login";
        }

        // Buscar pedidos do cliente pelo CPF
        model.addAttribute(
                "pedidos",
                pedidosService.listarPorCpf(cliente.getCpf())
        );

        model.addAttribute("clienteNome", cliente.getNome());

        return "pedidos";
    }
}
