package ru.fciit.pondas.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.Date;


@Data
public class FormPondRequest {
    private int orderId;
    @JacksonXmlProperty(localName = "Department")
    private String department;
    @JacksonXmlProperty(localName = "ServiceCode")
    private String serviceCode;
    @JacksonXmlProperty(localName = "TargetCode")
    private String targetCode;
    @JacksonXmlProperty(localName = "StatementDate")
    private Date statementDate;
    private ProbateCaseQuery probateCaseQuery;
    private String xmlns;
    private String schemaLocation;
    private String xsi;
    private String text;
}
