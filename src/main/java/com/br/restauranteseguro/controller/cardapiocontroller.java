
package com.br.restauranteseguro.controller;

import com.br.restauranteseguro.repository.catalogorepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class cardapiocontroller {

    private final catalogorepository catalogoRepository;

    public cardapiocontroller(catalogorepository catalogoRepository) {
        this.catalogoRepository = catalogoRepository;
    }

    @GetMapping("/cardapio")
    public String cardapio(Model model) {

        model.addAttribute(
                "produtos",
                catalogoRepository.findByAtivoTrue()
        );

        return "cardapio";
    }
}
