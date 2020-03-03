package com.raquel.msagenda.util.enums;

public enum TipoEnderecoEnum {
    RESIDENCIAL(1L, "RESIDENCIAL"),
    TRABALHO(2L, "TRABALHO"),
    FERIAS(3L, "FERIAS");

    private Long valor;
    private String descricao;

    TipoEnderecoEnum(Long valor, String descricao) {
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
