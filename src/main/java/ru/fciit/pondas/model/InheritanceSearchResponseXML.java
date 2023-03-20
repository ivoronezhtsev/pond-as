package ru.fciit.pondas.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class InheritanceSearchResponseXML {


    @XmlElement(name = "count")
    Integer count;
    @XmlElement(name = "records")
    List<Record> records;

    public static InheritanceSearchResponseXML from(InheritanceSearchResponse inheritanceSearchResponse) {
        var result = new InheritanceSearchResponseXML();
        result.count = inheritanceSearchResponse.getCount();
        result.records = inheritanceSearchResponse.getRecords();
        return result;
    }
}

