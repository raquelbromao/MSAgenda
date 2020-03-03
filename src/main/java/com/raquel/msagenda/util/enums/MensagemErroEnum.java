package com.raquel.msagenda.util.enums;

public enum MensagemErroEnum {
    CONTATO_NAO_EXISTENTE("Contato de id %d não existente");

    private String erro;

    MensagemErroEnum(String erro) {
        this.erro = erro;
    }

    public String getErro() {
        return erro;
    }
}
