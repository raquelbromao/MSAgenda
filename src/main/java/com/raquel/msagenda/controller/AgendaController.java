package com.raquel.msagenda.controller;

import com.raquel.msagenda.model.document.Agenda;
import com.raquel.msagenda.model.dto.AgendaDTO;
import com.raquel.msagenda.service.AgendaService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
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
    @Autowired
    private ConversionService conversor;

    /**
     * Busca um contato na agenda a partir do id
     *
     * @param id do contato presente na base de dados
     * @return objeto do tipo Agenda
     */
    @GetMapping("/{id}")
    public ResponseEntity<AgendaDTO> obterContato(@PathVariable final String id) {
        AgendaDTO contatoDTO = conversor
                .convert(service.obterContato(id), AgendaDTO.class);
        return ResponseEntity.ok(contatoDTO);
    }

    /**
     * Obtêm todos os contatos presentes na base de dados
     *
     * @return lista contendo todos os contatos presentes na base de dados
     */
    @GetMapping("/")
    public ResponseEntity<List<AgendaDTO>> obterAgenda() {
        List<AgendaDTO> agendaDTO
                = service.obterAgenda()
                .stream()
                .map(contato -> conversor.convert(contato, AgendaDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(agendaDTO);
    }

    /**
     * Cria um novo contato na base de dados
     *
     * @param contatoDTO objeto do tipo AgendaDTO
     * @return o id do novo contato
     */
    @PostMapping("/")
    public ResponseEntity<String> criarContato(@RequestBody AgendaDTO contatoDTO) {
        Agenda contato = conversor.convert(contatoDTO, Agenda.class);
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
     * @param contatoDTO objeto do tipo AgendaDTO
     */
    @PutMapping("/")
    public ResponseEntity atualizarContato(@RequestBody AgendaDTO contatoDTO) {
        Agenda contato = conversor.convert(contatoDTO, Agenda.class);
        service.atualizarContato(contato);
        return ResponseEntity.noContent().build();
    }
}
