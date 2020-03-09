package com.raquel.msagenda.util.enums;

public enum MensagemErroEnum {
    CONTATO_NAO_EXISTENTE("Contato de id [%s] não existente na base de dados."),
    NUMERO_FIXO_FORA_PADRAO("Número fixo [%s] fora do padrão [XXXXXXXX]"),
    NUMERO_CELULAR_FORA_PADRAO("Número celular [%s] fora do padrão [9XXXXXXXX]");

    private String erro;

    MensagemErroEnum(String erro) {
        this.erro = erro;
    }

    public String getErro() {
        return erro;
    }
}
