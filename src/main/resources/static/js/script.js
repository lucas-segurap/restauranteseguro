
/* =====================================================
   RESTAURANTE SEGURO
   SCRIPT GLOBAL DO SISTEMA
===================================================== */


/* =====================================================
   INICIALIZAÇÃO
===================================================== */

document.addEventListener("DOMContentLoaded", function () {

    inicializarAnoFooter();
    inicializarLinksInternos();

});


/* =====================================================
   ANO AUTOMÁTICO DO FOOTER
===================================================== */

function inicializarAnoFooter() {

    const elementosAno = document.querySelectorAll("[data-ano-atual]");

    elementosAno.forEach(function (elemento) {
        elemento.textContent = new Date().getFullYear();
    });

}


/* =====================================================
   NAVEGAÇÃO POR ÂNCORAS
===================================================== */

function inicializarLinksInternos() {

    const links = document.querySelectorAll('a[href^="#"]');

    links.forEach(function (link) {

        link.addEventListener("click", function (evento) {

            const destino = link.getAttribute("href");

            if (!destino || destino === "#") {
                return;
            }

            const elemento = document.querySelector(destino);

            if (elemento) {

                evento.preventDefault();

                elemento.scrollIntoView({
                    behavior: "smooth",
                    block: "start"
                });

            }

        });

    });

}


/* =====================================================
   NOTIFICAÇÕES GLOBAIS
===================================================== */

function mostrarNotificacao(mensagem, tipo = "sucesso") {

    let notificacao = document.getElementById("notificacaoGlobal");

    if (!notificacao) {

        notificacao = document.createElement("div");

        notificacao.id = "notificacaoGlobal";

        notificacao.setAttribute("role", "status");
        notificacao.setAttribute("aria-live", "polite");

        document.body.appendChild(notificacao);

    }

    notificacao.className = "notificacao-global " + tipo;

    notificacao.textContent = mensagem;

    notificacao.classList.add("notificacao-visivel");

    clearTimeout(window.timerNotificacao);

    window.timerNotificacao = setTimeout(function () {

        notificacao.classList.remove("notificacao-visivel");

    }, 3000);

}
