package com.raquel.msagenda.controller;

import com.raquel.msagenda.model.Agenda;
import com.raquel.msagenda.service.AgendaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller de todas as ações referentes a Agenda
 */
@RestController
@RequestMapping("agenda")
public class AgendaController {

    @Autowired
    private AgendaService service;

    /**
     * Busca um contato na agenda a partir do id
     *
     * @param id do contato presente na base de dados
     * @return objeto do tipo Agenda
     */
    @GetMapping("/{id}")
    public ResponseEntity<Agenda> obterContato(@PathVariable final String id) {
        return ResponseEntity.ok(service.obterContato(id));
    }

    /**
     * Obtêm todos os contatos presentes na base de dados
     *
     * @return lista contendo todos os contatos presentes na base de dados
     */
    @GetMapping("/")
    public ResponseEntity<List<Agenda>> obterAgenda() {
        return ResponseEntity.ok(service.obterAgenda());
    }

    /**
     * Cria um novo contato na base de dados
     *
     * @param contato objeto do tipo Agenda
     * @return o id do novo contato
     */
    @PostMapping("/")
    public ResponseEntity<String> criarContato(@RequestBody Agenda contato) {
        return ResponseEntity.ok(service.criarContato(contato));
    }

    /**
     * Deleta um contato presente na base de dados
     *
     * @param id id do contato presente na base de dados
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deletarContato(@PathVariable final String id) {
        service.deletarContato(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Atualiza um contato presente na base de dados
     *
     * @param contato objeto do tipo Agenda
     */
    @PutMapping("/")
    public ResponseEntity atualizarContato(@RequestBody Agenda contato) {
        service.atualizarContato(contato);
        return ResponseEntity.noContent().build();
    }
}
