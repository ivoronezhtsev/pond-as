package ru.fciit.pondas.model;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "NotaryId",
        "NotaryName",
        "NotaryStatus",
        "DistrictName",
        "ChamberId",
        "ChamberName",
        "ContactName",
        "ContactAddress",
        "ContactPhone"
})

public class ArcNotary {

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
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}