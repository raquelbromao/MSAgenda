package com.raquel.msagenda.repository;

import com.raquel.msagenda.model.Agenda;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AgendaRepository extends MongoRepository<Agenda, Long> {

}
