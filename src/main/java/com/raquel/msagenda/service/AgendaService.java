package com.raquel.msagenda.service;

import com.raquel.msagenda.model.Agenda;
import com.raquel.msagenda.repository.AgendaRepository;
import com.raquel.msagenda.util.JsonUtils;
import static com.raquel.msagenda.util.enums.MensagemErroEnum.CONTATO_NAO_EXISTENTE;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import static java.lang.String.format;

@Service
public class AgendaService {

    private final Logger logger = LoggerFactory.getLogger(AgendaService.class);

    @Autowired
    private JsonUtils jsonUtils;
    @Autowired
    private AgendaRepository repository;

    public void obterAgenda(Agenda agenda) {
        logger.info(jsonUtils.objectToJson(agenda));
    }

    public void criarContato(Agenda contato) {
        validarInformacoes(contato);
        repository.insert(contato);
        logger.info(jsonUtils.objectToJson(contato));

    }

    public Agenda obterContato(Long id) {
        Optional<Agenda> optionalAgenda = repository.findById(id);

        return optionalAgenda.orElseThrow(()
                -> new IllegalStateException(String.format(CONTATO_NAO_EXISTENTE.getErro(), id)));
    }

    public List<Agenda> obterAgenda() {
        return repository.findAll();
    }

    private void validarInformacoes(Agenda contato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
