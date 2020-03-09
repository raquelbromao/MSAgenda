package com.raquel.msagenda.service;

import com.raquel.msagenda.model.Agenda;
import com.raquel.msagenda.repository.AgendaRepository;
import com.raquel.msagenda.util.JsonUtils;

import static com.raquel.msagenda.util.enums.MensagemErroEnum.*;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.raquel.msagenda.util.enums.MensagemSistemaEnum.*;
import static java.lang.String.format;

/**
 * Service referente a todas as operações envolvem a Agenda
 */
@Service
public class AgendaService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JsonUtils jsonUtils;
    @Autowired
    private AgendaRepository repository;

    /**
     * Cria um novo contato na base de dados
     *
     * @param contato objeto do tipo Agenda
     * @return id do novo contato na base de dados
     * @throws IllegalStateException caso o número fornecido não esteja dentro do padrão
     */
    public String criarContato(Agenda contato) {
        logger.info(format(
                INSERINDO_NOVO_CONTATO.getMensagem(), jsonUtils.objectToJson(contato)));

        contato.getTelefones()
                .stream()
                .forEach(telefone -> {
                    if (telefone.getTipoTelefone().contains("FIXO")) {
                        if (!telefone.getNumero().matches("[0-9]{8}")) {
                            throw new IllegalStateException(format(
                                    NUMERO_FIXO_FORA_PADRAO.getErro(), telefone.getNumero()));
                        }
                    } else {
                        if (!telefone.getNumero().matches("[9][0-9]{8}")) {
                            throw new IllegalStateException(format(
                                    NUMERO_CELULAR_FORA_PADRAO.getErro(), telefone.getNumero()));
                        }
                    }
                });
        contato = repository.insert(contato);
        return contato.getId();
    }

    /**
     * Obtêm o contato da agenda a partir do id
     *
     * @param id do contato na base de dados
     * @return objeto do tipo Agenda
     * @throws IllegalStateException caso o contato não exista na base de dados
     */
    public Agenda obterContato(String id) {
        logger.info(format(
                OBTENDO_CONTATO.getMensagem(), id));
        Optional<Agenda> optionalAgenda = repository.findById(id);
        return optionalAgenda.orElseThrow(()
                -> new IllegalStateException(format(CONTATO_NAO_EXISTENTE.getErro(), id)));
    }

    /**
     * Retorna a agenda inteira
     *
     * @return lista de todos os contatos presentes na base de dados
     */
    public List<Agenda> obterAgenda() {
        logger.info(BUSCANDO_AGENDA.getMensagem());
        return repository.findAll();
    }

    /**
     * Deleta um contato da agenda a partir do id
     *
     * @param id do contato na base de dados
     * @throws IllegalStateException caso o contato não exista na base de dados
     */
    public void deletarContato(String id) {
        logger.info(format(
                DELETANDO_CONTATO.getMensagem(), id));
        verificarId(id);
        repository.deleteById(id);
    }

    /**
     * Atualiza um contato na agenda
     *
     * @param contatoAtualizado objeto do tipo Agenda com as informações atualizadas
     * @throws IllegalStateException caso o contato não exista na base de dados
     */
    public void atualizarContato(Agenda contatoAtualizado) {
        logger.info(format(
                OBTENDO_CONTATO.getMensagem(), contatoAtualizado.getId()));
        verificarId(contatoAtualizado.getId());
        repository.save(contatoAtualizado);
    }

    /**
     * Verifica existẽncia do id na base de dados
     *
     * @param id do contato na base de dados
     * @throws IllegalStateException caso o contato não exista na base de dados
     */
    private void verificarId(String id) {
        repository
                .findById(id)
                .orElseThrow(()
                        -> new IllegalStateException(
                        format(CONTATO_NAO_EXISTENTE.getErro(), id)));
    }
}
