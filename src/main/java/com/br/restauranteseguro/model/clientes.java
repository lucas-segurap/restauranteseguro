
package com.br.restauranteseguro.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "clientes")
public class clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "nome", length = 80)
    private String nome;

    @Column(name = "endereco", length = 100)
    private String endereco;

    @Column(name = "bairro", length = 50)
    private String bairro;

    @Column(name = "cidade", length = 50)
    private String cidade;

    @Column(name = "telefone", length = 25)
    private String telefone;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "datanascimento")
    private LocalDate dataNascimento;

    @Column(name = "saldo", precision = 10, scale = 2)
    private BigDecimal saldo;

    @Column(name = "senha", length = 255)
    private String senha;

    @Column(name = "historico", columnDefinition = "MEDIUMTEXT")
    private String historico;

    @Column(name = "datacadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "ativo")
    private Boolean ativo;

// construtor vazio

    public clientes() {

    }

    // Constructor

    public clientes(Long id, String cpf, String nome, String endereco, String bairro, String cidade, String telefone, String email, LocalDate dataNascimento, BigDecimal saldo, String senha, String historico, LocalDateTime dataCadastro, Boolean ativo) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.saldo = saldo;
        this.senha = senha;
        this.historico = historico;
        this.dataCadastro = dataCadastro;
        this.ativo = ativo;
    }

    // Getter

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public String getSenha() {
        return senha;
    }

    public String getHistorico() {
        return historico;
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

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}