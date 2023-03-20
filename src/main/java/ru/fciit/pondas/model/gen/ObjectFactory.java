package ru.fciit.pondas.model.gen;

import ru.fciit.pondas.dto.gen.ipAccount.*;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    private final static QName _FormPONDRequest_QNAME = new QName("urn://x-artefacts-fciit-ru/pond-epgu/1.0.0", "FormPONDRequest");
    private final static QName _FormPONDResponse_QNAME = new QName("urn://x-artefacts-fciit-ru/pond-epgu/1.0.0", "FormPONDResponse");


    public ObjectFactory() {
    }


    public FormPONDRequestType createFormPONDRequestType() {
        return new FormPONDRequestType();
    }


    public FormPONDResponseType createFormPONDResponseType() {
        return new FormPONDResponseType();
    }


    public RecordType createRecordType() {
        return new RecordType();
    }


    public ProbateCaseQueryType createProbateCaseQueryType() {
        return new ProbateCaseQueryType();
    }


    public ProbateCaseAnswerType createProbateCaseAnswerType() {
        return new ProbateCaseAnswerType();
    }


    @XmlElementDecl(namespace = "urn://x-artefacts-fciit-ru/pond-epgu/1.0.0", name = "FormPONDRequest")
    public JAXBElement<FormPONDRequestType> createFormPONDRequest(FormPONDRequestType value) {
        return new JAXBElement<>(_FormPONDRequest_QNAME, FormPONDRequestType.class, null, value);
    }

    @XmlElementDecl(namespace = "urn://x-artefacts-fciit-ru/pond-epgu/1.0.0", name = "FormPONDResponse")
    public JAXBElement<FormPONDResponseType> createFormPONDResponse(FormPONDResponseType value) {
        return new JAXBElement<>(_FormPONDResponse_QNAME, FormPONDResponseType.class, null, value);
    }
}
