package com.raquel.msagenda.config;

import com.raquel.msagenda.model.document.Agenda;
import com.raquel.msagenda.model.document.Endereco;
import com.raquel.msagenda.model.document.Telefone;
import com.raquel.msagenda.model.dto.AgendaDTO;
import com.raquel.msagenda.model.dto.EnderecoDTO;
import com.raquel.msagenda.model.dto.TelefoneDTO;
import com.raquel.msagenda.util.ConverterUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
public class ConverterConfig {

    @Primary
    @Bean
    public ConversionService conversionService() {
        DefaultConversionService service = new DefaultConversionService();
        service.addConverter(new ConverterUtil<AgendaDTO, Agenda>() {
        });
        service.addConverter(new ConverterUtil<Agenda, AgendaDTO>() {
        });
        return service;
    }
}
