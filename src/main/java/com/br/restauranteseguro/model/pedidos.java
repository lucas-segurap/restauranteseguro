

package com.br.restauranteseguro.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

    @Entity
    @Table(name = "pedidos")
    public class pedidos {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "cpf")
        private String cpf;

        @Enumerated(EnumType.STRING)
        @Column(name = "tipo")
        private tipoatendimento tipo;

        @Column(name = "local")
        private Integer local;

        @Column(name = "codigo")
        private Integer codigo;

        @Column(name = "qtde")
        private Integer quantidade;

        @Enumerated(EnumType.STRING)
        @Column(name = "pagto")
        private formpagamento pagamento;

        @Column(name = "total", precision = 10, scale = 2)
        private BigDecimal total;

        @Column(name = "data")
        private LocalDateTime data;

        @Enumerated(EnumType.STRING)
        @Column(name = "status")
        private statuspedido status;


        // Contrutor vazio
        public pedidos() {
        }

        // Constructor

        public pedidos(Long id, String cpf, tipoatendimento tipo, Integer local, Integer codigo, Integer quantidade, formpagamento pagamento, BigDecimal total, LocalDateTime data, statuspedido status) {
            this.id = id;
            this.cpf = cpf;
            this.tipo = tipo;
            this.local = local;
            this.codigo = codigo;
            this.quantidade = quantidade;
            this.pagamento = pagamento;
            this.total = total;
            this.data = data;
            this.status = status;
        }
        // Getter

        public Long getId() {
            return id;
        }

        public String getCpf() {
            return cpf;
        }

        public tipoatendimento getTipo() {
            return tipo;
        }

        public Integer getLocal() {
            return local;
        }

        public Integer getCodigo() {
            return codigo;
        }

        public Integer getQuantidade() {
            return quantidade;
        }

        public formpagamento getPagamento() {
            return pagamento;
        }

        public BigDecimal getTotal() {
            return total;
        }

        public LocalDateTime getData() {
            return data;
        }

        public statuspedido getStatus() {
            return status;
        }
        // Setter


        public void setId(Long id) {
            this.id = id;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public void setTipo(tipoatendimento tipo) {
            this.tipo = tipo;
        }

        public void setLocal(Integer local) {
            this.local = local;
        }

        public void setCodigo(Integer codigo) {
            this.codigo = codigo;
        }

        public void setQuantidade(Integer quantidade) {
            this.quantidade = quantidade;
        }

        public void setPagamento(formpagamento pagamento) {
            this.pagamento = pagamento;
        }

        public void setTotal(BigDecimal total) {
            this.total = total;
        }

        public void setData(LocalDateTime data) {
            this.data = data;
        }

        public void setStatus(statuspedido status) {
            this.status = status;
        }
    }
