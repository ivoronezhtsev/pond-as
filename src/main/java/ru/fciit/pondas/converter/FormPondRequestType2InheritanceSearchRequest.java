package ru.fciit.pondas.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import ru.fciit.pondas.dto.gen.ipAccount.FormPONDRequestType;
import ru.fciit.pondas.model.InheritanceSearchRequest;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;

@Service
public class FormPondRequestType2InheritanceSearchRequest implements Converter<FormPONDRequestType, InheritanceSearchRequest> {
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

    @Override
    public InheritanceSearchRequest convert(FormPONDRequestType source) {
        var inheritanceSearchRequest = new InheritanceSearchRequest();
        var probateCaseQuery = source.getProbateCaseQuery();
        inheritanceSearchRequest.setName(probateCaseQuery.getFamilyName() + " " + probateCaseQuery.getFirstName() + " " + probateCaseQuery.getPatronymic());
        inheritanceSearchRequest.setBirthDate(convertDate(probateCaseQuery.getBirthDate()));
        inheritanceSearchRequest.setDeathDate(convertDate(probateCaseQuery.getDeathDate()));
        return inheritanceSearchRequest;
    }

    private String convertDate(XMLGregorianCalendar date) {
        return date != null ? simpleDateFormat.format(date.toGregorianCalendar().getTime()) : null;
    }
}
