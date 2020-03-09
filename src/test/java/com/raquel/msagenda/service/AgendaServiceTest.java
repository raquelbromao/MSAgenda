package com.raquel.msagenda.service;

import com.raquel.msagenda.environment.AgendaEnvironment;
import com.raquel.msagenda.model.Agenda;
import com.raquel.msagenda.repository.AgendaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;


@DisplayName("Testes relacionados a AgendaService")
public class AgendaServiceTest {

    private MockMvc mockMvc;

    @InjectMocks
    public AgendaService service;
    @Mock
    public AgendaRepository repository;

    @BeforeAll
    public void init() throws Exception {
        mockMvc = MockMvcBuilders
                .standaloneSetup(service)
                .build();
    }

    @Test
    void criarContatoTest() throws Exception {
        Agenda agenda = AgendaEnvironment.criarContato();
        when(repository.insert(agenda)).thenReturn(agenda.setId("54354355d758j8778"));
        String id = service.criarContato(agenda);

        Assertions.assertEquals("54354355d758j8778", id);
    }
}
