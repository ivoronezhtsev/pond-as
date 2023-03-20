package ru.fciit.pondas.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class FormPondResponse {
    public Long orderId;
    public ProbateCaseAnswer probateCaseAnswer;
    @JacksonXmlProperty(isAttribute = true)
    public String xsi = "http://www.w3.org/2001/XMLSchema-instance";
    @JacksonXmlProperty(isAttribute = true)
    public final String tns = "urn://x-artefacts-fciit-ru/pond-epgu/1.0.0";
    public String text;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProbateCaseAnswer {
        private int stateCode;
        private int count;
        private List<Records> Records;
    }
    @Data
    public static class Records {
        private String CaseNumber;
        private String CaseDate;
        private String NotaryID;
        private Integer NotaryIDAct;
    }

}


