package com.raquel.msagenda.environment;

import com.raquel.msagenda.model.Agenda;
import com.raquel.msagenda.model.Endereco;
import com.raquel.msagenda.model.Telefone;
import com.raquel.msagenda.util.enums.TipoEnderecoEnum;
import com.raquel.msagenda.util.enums.TipoLogradouroEnum;
import com.raquel.msagenda.util.enums.TipoTelefoneEnum;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

public class AgendaEnvironment {
    public static Agenda criarContato() {
        return new Agenda()
                .setId("1234g23444f232")
                .setCpf("418.120.988-12")
                .setDataNascimento(LocalDate.of(1992, Month.JUNE, 26))
                .setNome("Fulana Teste")
                .setTelefones(Arrays.asList(criarTelefone()))
                .setEnderecos(Arrays.asList(criarEndereco()));
    }

    public static Telefone criarTelefone() {
        return new Telefone()
                .setDdd(19)
                .setDdi(55)
                .setNumero("989686284")
                .setRamal("20200")
                .setTipoTelefone(TipoTelefoneEnum.CELULAR_PESSOAL.getDescricao());
    }

    public static Endereco criarEndereco() {
        return new Endereco()
                .setBairro("Centro")
                .setCep("13600-010")
                .setCidade("Araras")
                .setComplemento("Ap. 101")
                .setNumero(863)
                .setTipoEndereco(TipoEnderecoEnum.RESIDENCIAL.getDescricao())
                .setTipoLogradouro(TipoLogradouroEnum.RUA.getDescricao())
                .setLogradouro("Santa Cruz");
    }


}
