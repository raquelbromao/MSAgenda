package com.raquel.msagenda.service;

import com.raquel.msagenda.model.Agenda;
import com.raquel.msagenda.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaService {

    private final Logger logger = LoggerFactory.getLogger(AgendaService.class);

    @Autowired
    private JsonUtils jsonUtils;

    public void publicarAgenda(Agenda agenda) {
        logger.info(jsonUtils.objectToJson(agenda));
    }
}
