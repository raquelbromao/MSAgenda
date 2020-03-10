package com.raquel.msagenda.model.document;

public class Telefone {

    private String tipoTelefone;
    private int ddi;
    private int ddd;
    private String numero;
    private String ramal;

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public Telefone setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
        return this;
    }

    public int getDdi() {
        return ddi;
    }

    public Telefone setDdi(int ddi) {
        this.ddi = ddi;
        return this;
    }

    public int getDdd() {
        return ddd;
    }

    public Telefone setDdd(int ddd) {
        this.ddd = ddd;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Telefone setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String getRamal() {
        return ramal;
    }

    public Telefone setRamal(String ramal) {
        this.ramal = ramal;
        return this;
    }

}
