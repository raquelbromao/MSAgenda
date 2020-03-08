package com.raquel.msagenda.service;

import com.raquel.msagenda.model.Agenda;
import com.raquel.msagenda.model.Endereco;
import com.raquel.msagenda.model.Telefone;
import com.raquel.msagenda.util.enums.TipoEnderecoEnum;
import com.raquel.msagenda.util.enums.TipoLogradouroEnum;
import com.raquel.msagenda.util.enums.TipoTelefoneEnum;
import static java.lang.String.format;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ValidacaoService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<String> validarContato(Agenda agenda) {
        List<String> erros = new ArrayList<>();
        validarInformacoesPrincipais(agenda, erros);
        validarTelefones(agenda.getTelefones(), erros);
        validarEnderecos(agenda.getEnderecos(), erros);
        return erros;
    }

    private void validarInformacoesPrincipais(Agenda agenda, List<String> erros) {
        validarNome(agenda.getNome(), erros);
        validarCPF(agenda.getCpf(), erros);
    }

    private void validarTelefones(List<Telefone> telefones, List<String> erros) {
        if (!telefones.isEmpty()) {
            telefones
                    .stream()
                    .forEach(telefone -> {
                        validarDddiEDdd(telefone.getDdd(), telefone.getDdi(), erros);
                        validarTipoTelefone(telefone, erros);
                        validarRamal(telefone.getRamal(), erros);
                    });
        }
    }

    private void validarEnderecos(List<Endereco> enderecos, List<String> erros) {
        if (!enderecos.isEmpty()) {
            enderecos
                    .stream()
                    .forEach(endereco -> {
                        validarCep(endereco.getCep(), erros);
                        validarTipoLogradouro(endereco.getTipoLogradouro(), erros);
                        validarTipoEndereco(endereco.getTipoEndereco(), erros);
                        validarBairroECidade(endereco.getBairro(), endereco.getCidade(), erros);
                    });
        }
    }

    private void validarNome(String nome, List<String> erros) {
        if (!Strings.isBlank(nome)) {
            if (!nome.toUpperCase().matches("^[A-Z ]+")) {
                erros.add("Nome fora do padrão [apenas letras e espaços em branco]");
            }
        }
    }

    private void validarCPF(String cpf, List<String> erros) {
        if (!Strings.isBlank(cpf)) {
            if (!cpf.trim().matches("([0-9]{3}[.]*){3}[-][0-9]{2}$")) {
                erros.add("CPF fora do padrão [XXX.XXX.XXX-XX]");
            }
        }
    }

    private void validarCep(String cep, List<String> erros) {
        if (!Strings.isBlank(cep)) {
            if (!cep.trim().matches("[0-9]{5}[-][0-9]{3}")) {
                erros.add("CEP fora do padrão [XXXXX-XXX]");
            }

            return;
        }

        erros.add("CEP é obrigatório");
    }

    private void validarNumeroCelular(String numero, List<String> erros) {
        if (!Strings.isBlank(numero)) {
            if (!numero.trim().matches("[9][0-9]{8}")) {
                erros.add(format("Número de telefone %s fora do padrão [9XXXXXXXX]", numero));
            }
        }
    }

    private void validarNumeroFixo(String numero, List<String> erros) {
        if (!Strings.isBlank(numero)) {
            if (!numero.trim().matches("[0-9]{8}")) {
                erros.add(format("Número de telefone %s fora do padrão [XXXXXXXX]", numero));
            }
        }
    }

    private void validarDddiEDdd(int ddd, int ddi, List<String> erros) {
        String stringDdd = String.valueOf(ddd);
        String stringDdi = String.valueOf(ddi);

        if (!Strings.isBlank(stringDdd)) {
            if (!stringDdd.trim().matches("[0-9]{2}")) {
                erros.add(format("DDD %s fora do padrão [XX]", stringDdd));
            }
        }

        if (!Strings.isBlank(stringDdi)) {
            if (!stringDdi.trim().matches("[0-9]{2}")) {
                erros.add(format("DDD %s fora do padrão [XX]", stringDdi));
            }
        }
    }

    private void validarRamal(String ramal, List<String> erros) {
        if (!Strings.isBlank(ramal)) {
            if (!ramal.trim().matches("[2][0][0-9]{3}")) {
                erros.add(format("Ramal %s fora do padrão [20000-20999]", ramal));
            }
        }
    }

    private void validarTipoTelefone(Telefone telefone, List<String> erros) {
        if (!Strings.isBlank(telefone.getTipoTelefone())) {
            if (!telefone.getTipoTelefone().toUpperCase()
                    .matches("([FIXO RESIDENCIAL]|[FIXO TRABALHO]|[CELULAR TRABALHO]|[CELULAR PESSOAL])")) {
                erros.add("Tipo de Telefone fora do padrão " + obterTodosTiposTelefone());
            } else {

                if (telefone.getTipoTelefone().toUpperCase().contains("FIXO")) {
                    validarNumeroFixo(telefone.getNumero(), erros);
                } else {
                    validarNumeroCelular(telefone.getNumero(), erros);
                }
            }

            return;
        }

        erros.add("Tipo de Telefone é obrigatório " + obterTodosTiposTelefone());
    }

    private void validarTipoLogradouro(String tipoLogradouro, List<String> erros) {
        if (!Strings.isBlank(tipoLogradouro)) {
            if (!tipoLogradouro.toUpperCase()
                    .matches("[RUA]|[AVENIDA]|[RODOVIA]|[ESTRADA]")) {
                erros.add("Tipo de Logradouro fora do padrão " + obterTodosTiposLogradouro());
                return;
            }

            return;
        }

        erros.add("Tipo de Logradouro é obrigatório " + obterTodosTiposLogradouro());
    }

    private void validarTipoEndereco(String tipoEndereco, List<String> erros) {
        if (!Strings.isBlank(tipoEndereco)) {
            if (!tipoEndereco.toUpperCase()
                    .matches("[RESIDENCIAL]|[TRABALHO]|[FERIAS]")) {
                erros.add("Tipo de Endereco fora do padrão " + obterTodosTiposEndereco());
                return;
            }

            return;
        }

        erros.add("Tipo de Endereco é obrigatório " + obterTodosTiposEndereco());
    }

    private void validarBairroECidade(String bairro, String cidade, List<String> erros) {
        if (!Strings.isBlank(cidade)) {
            if (!cidade.toUpperCase().matches("([A-Z ]+)")) {
                erros.add(format("Cidade %s fora do padrão [apenas letras e espaços em branco]", cidade));
            }
            return;
        }

        erros.add("Cidade é obrigatória");

        if (!Strings.isBlank(bairro)) {
            if (!bairro.toUpperCase().matches("([A-Z ]+)")) {
                erros.add(format("Bairro %s fora do padrão [apenas letras e espaços em branco]", bairro));
            }
            return;
        }

        erros.add("Bairro é obrigatório");
    }

    private String obterTodosTiposTelefone() {
        List<String> listaTelefones = new ArrayList<>();
        for (TipoTelefoneEnum telefone : TipoTelefoneEnum.values()) {
            listaTelefones.add(telefone.getDescricao());
        }

        logger.info(listaTelefones.toString());
        return listaTelefones.toString();
    }

    private String obterTodosTiposLogradouro() {
        List<String> listaLogradouros = new ArrayList<>();
        for (TipoLogradouroEnum logradouro : TipoLogradouroEnum.values()) {
            listaLogradouros.add(logradouro.getDescricao());
        }

        logger.info(listaLogradouros.toString());
        return listaLogradouros.toString();
    }

    private String obterTodosTiposEndereco() {
        List<String> listaEnderecos = new ArrayList<>();
        for (TipoEnderecoEnum endereco : TipoEnderecoEnum.values()) {
            listaEnderecos.add(endereco.getDescricao());
        }

        logger.info(listaEnderecos.toString());
        return listaEnderecos.toString();
    }

}
