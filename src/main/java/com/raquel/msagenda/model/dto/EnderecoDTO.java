package com.raquel.msagenda.model.dto;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class EnderecoDTO implements Serializable {
    @Pattern(
            regexp = "\\bRESIDENCIAL\\b|\\bTRABALHO\\b|\\bFERIAS\\b",
            message = "Tipo de Endereço inexistente"
    )
    private String tipoEndereco;
    @Pattern(
            regexp = "\\bRUA\\b|\\bAVENIDA\\b|\\bRODOVIA\\b|\\bESTRADA\\b",
            message = "Tipo de Logradouro inexistente"
    )
    private String tipoLogradouro;

    private String logradouro;
    @Pattern(
            regexp = "[0-9]{2}",
            message = "Número do endereço fora do padrão [XX]"
    )
    private int numero;
    private String complemento;
    @Pattern(
            regexp = "([A-Z ]+)",
            message = "Bairro fora do padrão [apenas letras e espaços em branco]"
    )
    private String bairro;
    @Pattern(
            regexp = "([A-Z ]+)",
            message = "Cidade fora do padrão [apenas letras e espaços em branco]"
    )
    private String cidade;
    @Pattern(
            regexp = "[0-9]{5}[-][0-9]{3}",
            message = "CEP fora do padrão [XXXXX-XXX]"
    )
    private String cep;

    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public EnderecoDTO setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
        return this;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public EnderecoDTO setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
        return this;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public EnderecoDTO setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public int getNumero() {
        return numero;
    }

    public EnderecoDTO setNumero(int numero) {
        this.numero = numero;
        return this;
    }

    public String getComplemento() {
        return complemento;
    }

    public EnderecoDTO setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public EnderecoDTO setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public EnderecoDTO setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public EnderecoDTO setCep(String cep) {
        this.cep = cep;
        return this;
    }
}
