
package com.br.restauranteseguro.service;

import com.br.restauranteseguro.model.itenspedido;
import com.br.restauranteseguro.repository.itenspedidorepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class itenspedidoservice {

    private final itenspedidorepository itensRepository;

    public itenspedidoservice(
            itenspedidorepository itensRepository) {

        this.itensRepository = itensRepository;
    }

    // Salvar item do pedido
    public itenspedido salvar(itenspedido item) {

        if (item.getQuantidade() == null ||
                item.getQuantidade() <= 0) {

            throw new IllegalArgumentException(
                    "A quantidade deve ser maior que zero."
            );
        }

        BigDecimal valor = item.getValorUnitario();

        if (valor == null || valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    "O valor do produto é inválido."
            );
        }

        BigDecimal subtotal = valor.multiply(
                BigDecimal.valueOf(item.getQuantidade())
        ).setScale(2, RoundingMode.HALF_UP);

        item.setSubtotal(subtotal);

        return itensRepository.save(item);
    }

    // Listar itens de um pedido
    public List<itenspedido> listarPorPedido(Long pedidoId) {

        return itensRepository.findByPedidoId(pedidoId);
    }

    // Excluir item
    @Transactional
    public void excluir(Long id) {

        itensRepository.deleteById(id);
    }

    // Calcular total dos itens
    public BigDecimal calcularTotal(Long pedidoId) {

        return listarPorPedido(pedidoId)
                .stream()
                .map(itenspedido::getSubtotal)
                .filter(subtotal -> subtotal != null)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
