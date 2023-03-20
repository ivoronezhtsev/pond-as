package ru.fciit.pondas.validator;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

@Slf4j
@Getter
@Component
public class XmlErrorHandler implements ErrorHandler {

    @Override
    public void warning(SAXParseException exception) throws SAXParseException {
        log.warn("Предупреждение валидации: {}", exception.getMessage());
        throw exception;
    }

    @Override
    public void error(SAXParseException exception) throws SAXParseException {
        log.warn("Ошибка валидации: {}", exception.getMessage());
        throw exception;
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXParseException {
        log.warn("Фатальная ошибка валидации: {}", exception.getMessage());
        throw exception;
    }
}
