package com.raquel.msagenda.util.enums;

public enum TipoLogradouroEnum {
    RUA(1L, "RUA"),
    AVENIDA(2L, "AVENIDA"),
    RODOVIA(3L, "RODOVIA");

    private Long valor;
    private String descricao;

    TipoLogradouroEnum(Long valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public Long getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}
