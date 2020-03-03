package com.raquel.msagenda.controller;

import com.raquel.msagenda.model.Agenda;
import com.raquel.msagenda.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("agenda")
public class AgendaController {

    @Autowired
    private AgendaService service;

    @GetMapping("/{id}")
    public Agenda obterAgenda(@PathVariable final Long id) {
        return new Agenda();
    }

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
