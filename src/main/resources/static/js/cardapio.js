
/* =====================================================
   RESTAURANTE SEGURO
   FUNCIONALIDADES DO CARDÁPIO
===================================================== */


/* =====================================================
   CONFIGURAÇÕES
===================================================== */

const CHAVE_CARRINHO = "restauranteSeguroCarrinho";


/* =====================================================
   INICIALIZAÇÃO
===================================================== */

document.addEventListener("DOMContentLoaded", function () {

    inicializarBotoesProdutos();

});


/* =====================================================
   BUSCAR CARRINHO
===================================================== */

function obterCarrinho() {

    try {

        const carrinho = localStorage.getItem(CHAVE_CARRINHO);

        return carrinho ? JSON.parse(carrinho) : [];

    } catch (erro) {

        console.error("Erro ao carregar carrinho:", erro);

        return [];

    }

}


/* =====================================================
   SALVAR CARRINHO
===================================================== */

function salvarCarrinho(carrinho) {

    try {

        localStorage.setItem(
            CHAVE_CARRINHO,
            JSON.stringify(carrinho)
        );

        return true;

    } catch (erro) {

        console.error("Erro ao salvar carrinho:", erro);

        return false;

    }

}


/* =====================================================
   INICIALIZAR BOTÕES DOS PRODUTOS
===================================================== */

function inicializarBotoesProdutos() {

    const botoes = document.querySelectorAll(".btn-produto");

    botoes.forEach(function (botao) {

        botao.addEventListener("click", function () {

            const card = botao.closest(".produto-card");

            if (!card) {
                return;
            }

            const nomeElemento = card.querySelector("h3");
            const precoElemento = card.querySelector(".produto-rodape strong");

            if (!nomeElemento || !precoElemento) {
                mostrarNotificacao("Não foi possível identificar o produto.", "erro");
                return;
            }

            const nome = nomeElemento.textContent.trim();

            const precoTexto = precoElemento.textContent
                .replace("R$", "")
                .trim()
                .replace(/\./g, "")
                .replace(",", ".");

            const preco = Number(precoTexto);

            if (!nome || !Number.isFinite(preco) || preco <= 0) {
                mostrarNotificacao("Dados do produto inválidos.", "erro");
                return;
            }

            adicionarProduto(nome, preco);

        });

    });

}


/* =====================================================
   ADICIONAR PRODUTO AO CARRINHO
===================================================== */

function adicionarProduto(nome, preco) {

    const carrinho = obterCarrinho();

    const produtoExistente = carrinho.find(function (produto) {
        return produto.nome === nome;
    });

    if (produtoExistente) {

        produtoExistente.quantidade++;

    } else {

        carrinho.push({

            nome: nome,
            preco: preco,
            quantidade: 1

        });

    }

    if (salvarCarrinho(carrinho)) {

        mostrarNotificacao(nome + " adicionado ao pedido!");

        console.log("Carrinho atualizado:", carrinho);

    } else {

        mostrarNotificacao("Não foi possível salvar o produto.", "erro");

    }

}


/* =====================================================
   CALCULAR TOTAL DO CARRINHO
===================================================== */

function calcularTotalCarrinho() {

    const carrinho = obterCarrinho();

    return carrinho.reduce(function (total, produto) {

        return total + produto.preco * produto.quantidade;

    }, 0);

}
