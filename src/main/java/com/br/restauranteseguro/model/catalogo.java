package com.br.restauranteseguro.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "catalogo")
public class catalogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "produto", length = 30)
    private String produto;

    @Column(name = "descricao", columnDefinition = "MEDIUMTEXT")
    private String descricao;

    @Column(name = "valor", precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "datacadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "ativo")
    private Boolean ativo;

    // Construtor vazio
    public catalogo() {
    }

    public catalogo(Long id, Integer codigo, String produto, String descricao, BigDecimal valor, LocalDateTime dataCadastro, Boolean ativo) {
        this.id = id;
        this.codigo = codigo;
        this.produto = produto;
        this.descricao = descricao;
        this.valor = valor;
        this.dataCadastro = dataCadastro;
        this.ativo = ativo;
    }
    // Getters


    public Long getId() {
        return id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getProduto() {
        return produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public Boolean getAtivo() {
        return ativo;
    }
    // Setter

    public void setId(Long id) {
        this.id = id;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
