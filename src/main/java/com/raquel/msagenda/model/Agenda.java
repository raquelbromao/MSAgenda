package com.raquel.msagenda.model;

import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "agenda")
public class Agenda {

    @Id
    private String id;
    @NotNull(message = "Nome é obrigatório")
    @Pattern(
            regexp = "^[A-Z ]+",
            message = "Nome fora do padrão [apenas letras e espaços em branco]"
    )
    private String nome;
    private LocalDate dataNascimento;
    @NotNull(message = "CPF é obrigatório")
    @Pattern(
            regexp = "([0-9]{3}[.]*){3}[-][0-9]{2}$",
            message = "CPF fora do padrão [XXX.XXX.XXX-XX]"
    )
    private String cpf;
    @Valid
    private List<Endereco> enderecos;
    @Valid
    private List<Telefone> telefones;

    public String getId() {
        return id;
    }

    public Agenda setId(String id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Agenda setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Agenda setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Agenda setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public Agenda setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
        return this;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public Agenda setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
        return this;
    }

}
