package com.raquel.msagenda.service;

import com.raquel.msagenda.environment.AgendaEnvironment;
import com.raquel.msagenda.model.Agenda;
import com.raquel.msagenda.repository.AgendaRepository;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.raquel.msagenda.util.enums.MensagemErroEnum.CONTATO_NAO_EXISTENTE;
import static java.lang.String.format;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


@DisplayName("Testes relacionados a AgendaService")
public class AgendaServiceTest {

    @InjectMocks
    public AgendaService service;
    @Mock
    public AgendaRepository repository;

    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    void criarContatoTest() throws Exception {
//        Agenda contato = AgendaEnvironment.criarContato();
//        contato.setId("54354355d758j8778");
//        when(repository.insert(contato)).thenReturn(contato);
//        String id = service.criarContato(contato);
//
//        Assertions.assertEquals("54354355d758j8778", id);
//    }

    @Test
    void obterContatoTest() throws Exception {
        String id = "1a";
        Agenda contato = AgendaEnvironment.criarContato();
        when(repository.findById(id)).thenReturn(Optional.of(contato));
        Agenda contatoRetorno = service.obterContato(id);

        Assertions.assertEquals(contato.getId(), contatoRetorno.getId());
    }

    @Test
    void obterContatoErrorTest() throws Exception {
        String id = "1a";
        when(repository.findById(id)).thenReturn(Optional.empty());
        IllegalStateException exception =
                Assertions.assertThrows(IllegalStateException.class,
                        () -> service.obterContato(id));

        Assertions.assertEquals(format(CONTATO_NAO_EXISTENTE.getErro(), id),
                exception.getMessage());
    }

    @Test
    void obterAgendaTest() throws Exception {
        List<Agenda> agenda = Arrays.asList(AgendaEnvironment.criarContato());
        when(repository.findAll()).thenReturn(agenda);
        List<Agenda> agendaRetorno = service.obterAgenda();

        Assertions.assertEquals(agenda.size(), agendaRetorno.size());
    }

    @Test
    void deletarContatoTest() throws Exception {
        String id = "1a";
        Agenda contato = AgendaEnvironment.criarContato();
        when(repository.findById(id)).thenReturn(Optional.of(contato));
        doNothing().when(repository).deleteById(id);
        Assertions.assertDoesNotThrow(() -> service.deletarContato(id));
    }

    @Test
    void deletarContatoErrorTest() throws Exception {
        String id = "1a";
        when(repository.findById(id)).thenReturn(Optional.empty());
        IllegalStateException exception =
                Assertions.assertThrows(IllegalStateException.class,
                        () -> service.deletarContato(id));

        Assertions.assertEquals(format(CONTATO_NAO_EXISTENTE.getErro(), id),
                exception.getMessage());
    }

    @Test
    void atualizarContatoTest() throws Exception {
        Agenda contato = AgendaEnvironment.criarContato();
        when(repository.findById(contato.getId())).thenReturn(Optional.of(contato));
        when(repository.save(contato)).thenReturn(contato);
        Assertions.assertDoesNotThrow(() -> service.atualizarContato(contato));
    }
}
