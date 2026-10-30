
/* =========================================
   RESTAURANTE SEGURO
   Interatividade da página inicial
========================================= */

document.addEventListener("DOMContentLoaded", function () {

    // ELEMENTOS
    const header = document.querySelector(".site-header");
    const revealElements = document.querySelectorAll(
        ".section-head, .feature-item, .story-panel, .story-highlight, section.py-5"
    );

    const menu = document.querySelector("#menuPrincipal");
    const menuLinks = document.querySelectorAll(
        "#menuPrincipal .nav-link"
    );


    // =====================================
    // 1. EFEITO DO CABEÇALHO AO ROLAR
    // =====================================

    function atualizarHeader() {

        if (!header) return;

        if (window.scrollY > 40) {
            header.classList.add("scrolled");
        } else {
            header.classList.remove("scrolled");
        }

    }

    window.addEventListener("scroll", atualizarHeader, {
        passive: true
    });

    atualizarHeader();


    // =====================================
    // 2. ANIMAÇÃO DAS SEÇÕES
    // =====================================

    if ("IntersectionObserver" in window) {

        const observer = new IntersectionObserver(
            function (entries, observer) {

                entries.forEach(function (entry) {

                    if (entry.isIntersecting) {

                        entry.target.classList.add("visible");

                        observer.unobserve(entry.target);

                    }

                });

            },
            {
                threshold: 0.12
            }
        );

        revealElements.forEach(function (element) {

            element.classList.add("reveal");

            observer.observe(element);

        });

    } else {

        revealElements.forEach(function (element) {
            element.classList.add("visible");
        });

    }


    // =====================================
    // 3. FECHAR MENU NO CELULAR
    // =====================================

    menuLinks.forEach(function (link) {

        link.addEventListener("click", function () {

            if (
                menu &&
                menu.classList.contains("show") &&
                window.bootstrap
            ) {

                const menuBootstrap =
                    bootstrap.Collapse.getOrCreateInstance(menu);

                menuBootstrap.hide();

            }

        });

    });


    // =====================================
    // 4. DESTACAR PÁGINA ATUAL NO MENU
    // =====================================

    const paginaAtual = window.location.pathname;

    menuLinks.forEach(function (link) {

        const destino = new URL(link.href).pathname;

        link.classList.remove("active");
        link.removeAttribute("aria-current");

        if (destino === paginaAtual) {

            link.classList.add("active");
            link.setAttribute("aria-current", "page");

        }

    });


    // =====================================
    // 5. ANO AUTOMÁTICO NO RODAPÉ
    // =====================================

    const textoRodape = document.querySelector(".site-footer small");

    if (textoRodape) {

        textoRodape.innerHTML =
            "&copy; " + new Date().getFullYear() +
            " Restaurante Seguro. Todos os direitos reservados.";

    }


    console.log("Restaurante Seguro carregado com sucesso!");

});
