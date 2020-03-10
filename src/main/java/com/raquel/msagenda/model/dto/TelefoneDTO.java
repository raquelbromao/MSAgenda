package com.raquel.msagenda.model.dto;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class TelefoneDTO implements Serializable {
    @Pattern(
            regexp = "\\bFIXO RESIDENCIAL\\b|\\bFIXO TRABALHO\\b|\\bCELULAR TRABALHO\\b|\\bCELULAR PESSOAL\\b",
            message = "Tipo de Telefone inexistente"
    )
    private String tipoTelefone;
    @Pattern(
            regexp = "[0-9]{2}",
            message = "DDI fora do padrão [XX]"
    )
    private int ddi;
    @Pattern(
            regexp = "[0-9]{2}",
            message = "DDD fora do padrão [XX]"
    )
    private int ddd;
    private String numero;
    @Pattern(
            regexp = "[2][0][0-9]{3}",
            message = "Ramal fora do intervalo [20000-20999]"
    )
    private String ramal;

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public TelefoneDTO setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
        return this;
    }

    public int getDdi() {
        return ddi;
    }

    public TelefoneDTO setDdi(int ddi) {
        this.ddi = ddi;
        return this;
    }

    public int getDdd() {
        return ddd;
    }

    public TelefoneDTO setDdd(int ddd) {
        this.ddd = ddd;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public TelefoneDTO setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String getRamal() {
        return ramal;
    }

    public TelefoneDTO setRamal(String ramal) {
        this.ramal = ramal;
        return this;
    }
}
