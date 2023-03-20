package ru.fciit.pondas.converter;

import lombok.val;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import ru.fciit.pondas.dto.gen.ipAccount.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;


/**
 * @author Aleksey Ivanov
 * @since 05.04.2021
 */
@Service
public class Element2JAXBElement implements Converter<Element, JAXBElement<?>> {
    @Override
    public JAXBElement<?> convert(Element source) {
        synchronized (this) {
            try {
                val context = JAXBContext.newInstance(ObjectFactory.class);
                val unmarshaller = context.createUnmarshaller();
                Object any = unmarshaller.unmarshal(source);
                if (any instanceof JAXBElement<?>) {
                    return (JAXBElement<?>) any;
                } else {
                    return new JAXBElement<>(QName.valueOf(""), Object.class, any);
                }
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }
        }
    }
}