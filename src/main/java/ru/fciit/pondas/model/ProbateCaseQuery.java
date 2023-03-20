package ru.fciit.pondas.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ProbateCaseQuery {
    @JacksonXmlProperty(localName = "FamilyName")
    private String familyName;
    @JacksonXmlProperty(localName = "FirstName")
    private String firstName;
    @JacksonXmlProperty(localName = "Patronymic")
    private String patronymic;
    private String birthDate;
    private String deathDate;
}
