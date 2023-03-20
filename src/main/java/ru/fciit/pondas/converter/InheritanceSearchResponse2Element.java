package ru.fciit.pondas.converter;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import ru.fciit.pondas.dto.gen.ipAccount.ProbateCaseAnswerType;
import ru.fciit.pondas.dto.gen.ipAccount.RecordType;
import ru.fciit.pondas.model.InheritanceSearchResponse;
import ru.fciit.pondas.model.Record;
import ru.fciit.pondas.model.gen.FormPONDResponseType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class InheritanceSearchResponse2Element implements Converter<InheritanceSearchResponse, Element> {
    @Override
    public Element convert(InheritanceSearchResponse source) {
        try {
            FormPONDResponseType formPONDResponseType = new FormPONDResponseType();
            formPONDResponseType.setOrderId(source.getOrderId());
            ProbateCaseAnswerType probateCaseAnswerType = new ProbateCaseAnswerType();
            probateCaseAnswerType.setCount(source.getCount());
            probateCaseAnswerType.setStateCode((source.getCount() > 0) ? "200" : "404");
            probateCaseAnswerType.getRecords().addAll(source.getRecords().stream().map(this::convertAndGet).toList());
            formPONDResponseType.setProbateCaseAnswer(probateCaseAnswerType);
            return convertToElementAndGet(formPONDResponseType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private RecordType convertAndGet(Record record) {
        var recordType = new RecordType();
        recordType.setCaseNumber(record.getCaseNumber());
        recordType.setNotaryID(record.getNotaryId());
        record.setCaseNumber(record.getCaseNumber());
        record.setCaseDate(record.getCaseDate());
        record.setNotaryId(record.getNotaryId());
        if (record.getArchives() == null) {
            recordType.setNotaryIDAct(null);
        } else {
            recordType.setNotaryIDAct(record.getArchives().stream().min((a1, a2) -> getCaseDate(a2.getDateOn()).compareTo(getCaseDate(a1.getDateOn()))).map(a -> a.getArcNotary().getNotaryId()).orElse(null));
        }
        return recordType;
    }

    Date getCaseDate(String caseDate) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(caseDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private Element convertToElementAndGet(FormPONDResponseType formPondResponse) throws ParserConfigurationException, JAXBException {
        val dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        val doc = dbf.newDocumentBuilder().newDocument();
        JAXBContext context = JAXBContext.newInstance("ru.fciit.pondas.model.gen");
        context.createMarshaller().marshal(formPondResponse, doc);
        return doc.getDocumentElement();
    }
}
