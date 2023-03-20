package ru.fciit.pondas.converter;

import lombok.val;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import javax.xml.bind.*;

import java.io.ByteArrayOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;

@Service
public class Jaxb2ByteArray implements Converter<JAXBElement<?>, byte[]> {
    @Override
    public byte[] convert(JAXBElement<?> source) {
        synchronized (this) {
            try {
                val context = JAXBContext.newInstance("ru.fciit.pondas.dto.gen.gate");
                val marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
                marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
                val outputStream = new ByteArrayOutputStream();
                marshaller.marshal(source, outputStream);
                return outputStream.toByteArray();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}