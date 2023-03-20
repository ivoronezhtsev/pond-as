package ru.fciit.pondas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.convert.converter.Converter;
import java.util.List;

@Configuration
public class ConversionConfiguration {
    @Bean
    public ConversionService conversionService(List<Converter<?, ?>> converters) {
        var conversionService = new DefaultConversionService();
        converters.forEach(conversionService::addConverter);
        return conversionService;
    }
}