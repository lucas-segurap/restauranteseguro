
package com.br.restauranteseguro.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
public class usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registro")
    private Integer registro;

    @Column(name = "nome", length = 80)
    private String nome;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "admissao")
    private LocalDate admissao;

    @Column(name = "senha", length = 255)
    private String senha;

    @Column(name = "ativo")
    private Boolean ativo;



    // construtor vazio

    public usuarios () {

    }
    //Constructor
    public usuarios(Long id, Integer registro, String nome, String email, LocalDate admissao, String senha, Boolean ativo) {
        this.id = id;
        this.registro = registro;
        this.nome = nome;
        this.email = email;
        this.admissao = admissao;
        this.senha = senha;
        this.ativo = ativo;
    }
    //Getter

    public Long getId() {
        return id;
    }

    public Integer getRegistro() {
        return registro;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getAdmissao() {
        return admissao;
    }

    public String getSenha() {
        return senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    //Setter

    public void setId(Long id) {
        this.id = id;
    }

    public void setRegistro(Integer registro) {
        this.registro = registro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdmissao(LocalDate admissao) {
        this.admissao = admissao;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
