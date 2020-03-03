package com.raquel.msagenda.model;

public class Endereco {

    private String tipoEndereco;
    private String tipoLogradouro;
    private String Logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
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
        return Logradouro;
    }

    public Endereco setLogradouro(String Logradouro) {
        this.Logradouro = Logradouro;
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
