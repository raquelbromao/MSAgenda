package com.raquel.msagenda.controller;

import com.raquel.msagenda.model.Agenda;
import com.raquel.msagenda.service.AgendaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("agenda")
public class AgendaController {

    @Autowired
    private AgendaService service;

    @GetMapping("/{id}")
    public Agenda obterContato(@PathVariable final Long id) {
        return service.obterContato(id);
    }

    @GetMapping("/")
    public List<Agenda> obterAgenda() {
        return service.obterAgenda();
    }

    @PostMapping("/")
    public String criarContato(@RequestBody Agenda contato) {
        return service.criarContato(contato);
    }

    @DeleteMapping("/{id}")
    public String deletarContato(@PathVariable final Long id) {
        service.deletarContato(id);
        return "SUCESSO";
    }
}
