package ru.fciit.pondas.model;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Fio",
        "BirthDate",
        "DeathDate",
        "DeathActDate",
        "DeathActNumber",
        "Address",
        "CaseIndex",
        "CaseNumber",
        "CaseDate",
        "CaseCloseDate",
        "NotaryId",
        "NotaryName",
        "NotaryStatus",
        "DistrictName",
        "ChamberId",
        "ChamberName",
        "ContactName",
        "ContactAddress",
        "ContactPhone",
        "Archives",
        "CaseId",
        "CaseIDDate"
})
public class Record {

    @JsonProperty("Fio")
    private String fio;
    @JsonProperty("BirthDate")
    private String birthDate;
    @JsonProperty("DeathDate")
    private String deathDate;
    @JsonProperty("DeathActDate")
    private String deathActDate;
    @JsonProperty("DeathActNumber")
    private String deathActNumber;
    @JsonProperty("Address")
    private String address;
    @JsonProperty("CaseIndex")
    private String caseIndex;
    @JsonProperty("CaseNumber")
    private String caseNumber;
    @JsonProperty("CaseDate")
    private String caseDate;
    @JsonProperty("CaseCloseDate")
    private Object caseCloseDate;
    @JsonProperty("NotaryId")
    private String notaryId;
    @JsonProperty("NotaryName")
    private String notaryName;
    @JsonProperty("NotaryStatus")
    private String notaryStatus;
    @JsonProperty("DistrictName")
    private String districtName;
    @JsonProperty("ChamberId")
    private String chamberId;
    @JsonProperty("ChamberName")
    private String chamberName;
    @JsonProperty("ContactName")
    private String contactName;
    @JsonProperty("ContactAddress")
    private String contactAddress;
    @JsonProperty("ContactPhone")
    private String contactPhone;
    @JsonProperty(value = "Archives", required = false)
    private List<Archive> archives;
    @JsonProperty("CaseId")
    private String caseId;
    @JsonProperty("CaseIDDate")
    private String caseIDDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("Fio")
    public String getFio() {
        return fio;
    }

    @JsonProperty("Fio")
    public void setFio(String fio) {
        this.fio = fio;
    }

    @JsonProperty("BirthDate")
    public String getBirthDate() {
        return birthDate;
    }

    @JsonProperty("BirthDate")
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @JsonProperty("DeathDate")
    public String getDeathDate() {
        return deathDate;
    }

    @JsonProperty("DeathDate")
    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }

    @JsonProperty("DeathActDate")
    public String getDeathActDate() {
        return deathActDate;
    }

    @JsonProperty("DeathActDate")
    public void setDeathActDate(String deathActDate) {
        this.deathActDate = deathActDate;
    }

    @JsonProperty("DeathActNumber")
    public String getDeathActNumber() {
        return deathActNumber;
    }

    @JsonProperty("DeathActNumber")
    public void setDeathActNumber(String deathActNumber) {
        this.deathActNumber = deathActNumber;
    }

    @JsonProperty("Address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("Address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("CaseIndex")
    public String getCaseIndex() {
        return caseIndex;
    }

    @JsonProperty("CaseIndex")
    public void setCaseIndex(String caseIndex) {
        this.caseIndex = caseIndex;
    }

    @JsonProperty("CaseNumber")
    public String getCaseNumber() {
        return caseNumber;
    }

    @JsonProperty("CaseNumber")
    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    @JsonProperty("CaseDate")
    public String getCaseDate() {
        return caseDate;
    }

    @JsonProperty("CaseDate")
    public void setCaseDate(String caseDate) {
        this.caseDate = caseDate;
    }

    @JsonProperty("CaseCloseDate")
    public Object getCaseCloseDate() {
        return caseCloseDate;
    }

    @JsonProperty("CaseCloseDate")
    public void setCaseCloseDate(Object caseCloseDate) {
        this.caseCloseDate = caseCloseDate;
    }

    @JsonProperty("NotaryId")
    public String getNotaryId() {
        return notaryId;
    }

    @JsonProperty("NotaryId")
    public void setNotaryId(String notaryId) {
        this.notaryId = notaryId;
    }

    @JsonProperty("NotaryName")
    public String getNotaryName() {
        return notaryName;
    }

    @JsonProperty("NotaryName")
    public void setNotaryName(String notaryName) {
        this.notaryName = notaryName;
    }

    @JsonProperty("NotaryStatus")
    public String getNotaryStatus() {
        return notaryStatus;
    }

    @JsonProperty("NotaryStatus")
    public void setNotaryStatus(String notaryStatus) {
        this.notaryStatus = notaryStatus;
    }

    @JsonProperty("DistrictName")
    public String getDistrictName() {
        return districtName;
    }

    @JsonProperty("DistrictName")
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    @JsonProperty("ChamberId")
    public String getChamberId() {
        return chamberId;
    }

    @JsonProperty("ChamberId")
    public void setChamberId(String chamberId) {
        this.chamberId = chamberId;
    }

    @JsonProperty("ChamberName")
    public String getChamberName() {
        return chamberName;
    }

    @JsonProperty("ChamberName")
    public void setChamberName(String chamberName) {
        this.chamberName = chamberName;
    }

    @JsonProperty("ContactName")
    public String getContactName() {
        return contactName;
    }

    @JsonProperty("ContactName")
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @JsonProperty("ContactAddress")
    public String getContactAddress() {
        return contactAddress;
    }

    @JsonProperty("ContactAddress")
    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    @JsonProperty("ContactPhone")
    public String getContactPhone() {
        return contactPhone;
    }

    @JsonProperty("ContactPhone")
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    @JsonProperty("Archives")
    public List<Archive> getArchives() {
        return archives;
    }

    @JsonProperty("Archives")
    public void setArchives(List<Archive> archives) {
        this.archives = archives;
    }

    @JsonProperty("CaseId")
    public String getCaseId() {
        return caseId;
    }

    @JsonProperty("CaseId")
    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    @JsonProperty("CaseIDDate")
    public String getCaseIDDate() {
        return caseIDDate;
    }

    @JsonProperty("CaseIDDate")
    public void setCaseIDDate(String caseIDDate) {
        this.caseIDDate = caseIDDate;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}