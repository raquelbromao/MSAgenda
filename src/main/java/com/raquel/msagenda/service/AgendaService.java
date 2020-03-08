package com.raquel.msagenda.service;

import com.raquel.msagenda.model.Agenda;
import com.raquel.msagenda.repository.AgendaRepository;
import com.raquel.msagenda.util.JsonUtils;
import static com.raquel.msagenda.util.enums.MensagemErroEnum.CONTATO_NAO_EXISTENTE;
import static com.raquel.msagenda.util.enums.MensagemSistemaEnum.BUSCANDO_AGENDA;
import static com.raquel.msagenda.util.enums.MensagemSistemaEnum.INSERINDO_NOVO_CONTATO;
import static com.raquel.msagenda.util.enums.MensagemSistemaEnum.OBTENDO_CONTATO;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static java.lang.String.format;

@Service
public class AgendaService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JsonUtils jsonUtils;
    @Autowired
    private AgendaRepository repository;

    public String criarContato(Agenda contato) {
        logger.info(format(
                INSERINDO_NOVO_CONTATO.getMensagem(), jsonUtils.objectToJson(contato)));
            contato = repository.insert(contato);
            return "SUCESSO: Id " + contato.getId();
    }

    public Agenda obterContato(String id) {
        logger.info(format(
                OBTENDO_CONTATO.getMensagem(), id));
        Optional<Agenda> optionalAgenda = repository.findById(id);
        return optionalAgenda.orElseThrow(()
                -> new IllegalStateException(format(CONTATO_NAO_EXISTENTE.getErro(), id)));
    }

    public List<Agenda> obterAgenda() {
        logger.info(BUSCANDO_AGENDA.getMensagem());
        return repository.findAll();
    }

    public void deletarContato(String id) {
        repository.deleteById(id);
    }
}
