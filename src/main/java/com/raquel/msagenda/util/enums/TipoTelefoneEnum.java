package com.raquel.msagenda.util.enums;

public enum TipoTelefoneEnum {
    RESIDENCIAL(1L, "RESIDENCIAL"),
    CELULAR_PESSOAL(2L, "CELULAR PESSOAL"),
    CELULAR_TRABALHO(3L, "CELULAR TRABALHO"),
    TRABALHO(4L, "TRABALHO");

    private Long valor;
    private String descricao;

    TipoTelefoneEnum(Long valor, String descricao) {
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
