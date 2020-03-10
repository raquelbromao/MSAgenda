package com.raquel.msagenda.model.dto;
import org.springframework.data.annotation.Id;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class AgendaDTO implements Serializable {
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
    private List<EnderecoDTO> enderecos;
    @Valid
    private List<TelefoneDTO> telefones;

    public String getId() {
        return id;
    }

    public AgendaDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public AgendaDTO setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public AgendaDTO setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public AgendaDTO setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public List<EnderecoDTO> getEnderecos() {
        return enderecos;
    }

    public AgendaDTO setEnderecos(List<EnderecoDTO> enderecos) {
        this.enderecos = enderecos;
        return this;
    }

    public List<TelefoneDTO> getTelefones() {
        return telefones;
    }

    public AgendaDTO setTelefones(List<TelefoneDTO> telefones) {
        this.telefones = telefones;
        return this;
    }
}
