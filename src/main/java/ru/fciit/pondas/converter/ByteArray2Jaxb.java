package ru.fciit.pondas.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import java.io.ByteArrayInputStream;

@Service
public class ByteArray2Jaxb implements Converter<byte[], JAXBElement<?>> {
    @Override
    public JAXBElement<?> convert(byte[] source) {
        synchronized(this) {
            JAXBContext context;
            try {
                context = JAXBContext.newInstance("ru.fciit.pondas.dto.gen.gate");
                var unmarshaller = context.createUnmarshaller();
                var any = unmarshaller.unmarshal(new ByteArrayInputStream(source));
                if (any instanceof JAXBElement<?>) {
                    return (JAXBElement<?>) any;
                }
                else {
                    return new JAXBElement<>(QName.valueOf(""), Object.class, any);
                }
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
        }
    }
}