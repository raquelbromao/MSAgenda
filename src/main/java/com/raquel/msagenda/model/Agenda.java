package com.raquel.msagenda.model;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "agenda")
public class Agenda {

    @Id
    private String id;
    @NotNull(message = "Nome é obrigatório")
    private String nome;
    private LocalDate dataNascimento;
    @NotNull(message = "CPF é obrigatório")
    private String cpf;
    private List<Endereco> enderecos;
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
