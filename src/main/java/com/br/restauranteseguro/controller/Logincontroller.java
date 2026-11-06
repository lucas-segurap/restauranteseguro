
package com.br.restauranteseguro.controller;

import com.br.restauranteseguro.model.clientes;
import com.br.restauranteseguro.service.Loginservice;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Logincontroller {

    private final Loginservice loginService;

    public Logincontroller(Loginservice loginService) {
        this.loginService = loginService;
    }

    // Abrir página de login
    @GetMapping("/login")
    public String abrirLogin() {
        return "login";
    }

    // Processar login
    @PostMapping("/login")
    public String autenticar(
            @RequestParam String email,
            @RequestParam String senha,
            HttpSession session,
            Model model) {

        var resultado = loginService.autenticar(email, senha);

        if (resultado.isEmpty()) {
            model.addAttribute("erro", "E-mail ou senha inválidos.");
            return "login";
        }

        clientes cliente = resultado.get();

        session.setAttribute("clienteId", cliente.getId());
        session.setAttribute("clienteNome", cliente.getNome());

        return "redirect:/";
    }

    // Encerrar sessão
    @GetMapping("/logout")
    public String sair(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
