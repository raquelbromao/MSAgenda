package com.raquel.msagenda.model;

import javax.validation.constraints.Pattern;

public class Endereco {

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

    public Endereco setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
        return this;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public Endereco setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
        return this;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Endereco setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public int getNumero() {
        return numero;
    }

    public Endereco setNumero(int numero) {
        this.numero = numero;
        return this;
    }

    public String getComplemento() {
        return complemento;
    }

    public Endereco setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public Endereco setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public Endereco setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public Endereco setCep(String cep) {
        this.cep = cep;
        return this;
    }

}
