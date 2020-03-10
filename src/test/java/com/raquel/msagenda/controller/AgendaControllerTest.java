package com.raquel.msagenda.controller;

import com.raquel.msagenda.environment.AgendaDTOEnvironment;
import com.raquel.msagenda.environment.AgendaEnvironment;
import com.raquel.msagenda.model.document.Agenda;
import com.raquel.msagenda.model.dto.AgendaDTO;
import com.raquel.msagenda.service.AgendaService;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.convert.ConversionService;

import java.util.Arrays;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@DisplayName("Testes relacionados a AgendaController")
public class AgendaControllerTest {

    @InjectMocks
    private AgendaController controller;
    @Mock
    private AgendaService service;
    @Mock
    private ConversionService conversor;

    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void criarContatoTest() throws Exception {
        String id = "1a";
        Agenda contato = AgendaEnvironment.criarContato();
        AgendaDTO contatoDTO = AgendaDTOEnvironment.criarContato();
        when(conversor.convert(contato, AgendaDTO.class))
            .thenReturn(contatoDTO);
        when(service.criarContato(contato)).thenReturn(id);

        controller.criarContato(contatoDTO);

        given()
                .standaloneSetup(controller)
                .contentType(ContentType.JSON)
                .body(contato)
                .post("agenda/")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    void obterContatoTest() throws Exception {
        String id = "1a";
        Agenda contato = AgendaEnvironment.criarContato();
        when(service.obterContato(id)).thenReturn(contato);

        controller.obterContato(id);

        given()
                .standaloneSetup(controller)
                .contentType(ContentType.JSON)
                .get("agenda/" + id)
                .then().log().all()
                .statusCode(200);
    }

    @Test
    void obterAgendaTest() throws Exception {
        Agenda contato = AgendaEnvironment.criarContato();
        AgendaDTO contatoDTO = AgendaDTOEnvironment.criarContato();
        when(service.obterAgenda()).thenReturn(Arrays.asList(contato));
        when(conversor.convert(contato, AgendaDTO.class))
                .thenReturn(contatoDTO);
        controller.obterAgenda();

        given()
                .standaloneSetup(controller)
                .contentType(ContentType.JSON)
                .get("agenda/")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    void deletarContatoTest() throws Exception {
        String id = "1a";
        doNothing().when(service).deletarContato(id);

        controller.deletarContato(id);

        given()
                .standaloneSetup(controller)
                .contentType(ContentType.JSON)
                .delete("agenda/" + id)
                .then().log().all()
                .statusCode(204);
    }

    @Test
    void atualizarContatoTest() throws Exception {
        Agenda contato = AgendaEnvironment.criarContato();
        AgendaDTO contatoDTO = AgendaDTOEnvironment.criarContato();
        doNothing().when(service).atualizarContato(contato);
        when(conversor.convert(contato, AgendaDTO.class))
                .thenReturn(contatoDTO);

        controller.atualizarContato(contatoDTO);

        given()
                .standaloneSetup(controller)
                .contentType(ContentType.JSON)
                .body(contato)
                .put("agenda/")
                .then().log().all()
                .statusCode(204);
    }
}
