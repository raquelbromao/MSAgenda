package com.raquel.msagenda.util.enums;

public enum MensagemSistemaEnum {
    INSERINDO_NOVO_CONTATO("Criando novo contato a partir do JSON:\n%s"),
    OBTENDO_CONTATO("Buscando contato de id [%s]"),
    DELETANDO_CONTATO("Deletando contato de id [%s]"),
    BUSCANDO_AGENDA("Buscando todos os contatos salvos na base de dados"),;

    private String mensagem;

    MensagemSistemaEnum(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

}
