package com.raquel.msagenda.controller;

import com.raquel.msagenda.model.Agenda;
import com.raquel.msagenda.service.AgendaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("agenda")
public class AgendaController {

    @Autowired
    private AgendaService service;

    @GetMapping("/{id}")
    public ResponseEntity<Agenda> obterContato(@PathVariable final String id) {
        return ResponseEntity.ok(service.obterContato(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Agenda>> obterAgenda() {
        return ResponseEntity.ok(service.obterAgenda());
    }

    @PostMapping("/")
    public ResponseEntity<String> criarContato(@RequestBody Agenda contato) {
        return ResponseEntity.ok(service.criarContato(contato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarContato(@PathVariable final String id) {
        service.deletarContato(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/")
    public ResponseEntity atualizarContato(@RequestBody Agenda agenda) {
        service.atualizarContato(agenda);
        return ResponseEntity.noContent().build();
    }
}
