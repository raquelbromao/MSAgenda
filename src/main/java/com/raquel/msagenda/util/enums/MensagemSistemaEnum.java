package com.raquel.msagenda.util.enums;

public enum MensagemSistemaEnum {
    INSERINDO_NOVO_CONTATO("Criando novo contato a partir do JSON: %s"),
    OBTENDO_CONTATO("Buscando contato de id %d."),
    BUSCANDO_AGENDA("Buscando todos os contatos presentes na agenda."),;

    private String mensagem;

    MensagemSistemaEnum(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

}