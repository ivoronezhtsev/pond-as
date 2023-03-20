package ru.fciit.pondas.model;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "DateOn",
        "Reason",
        "Note",
        "ArcNotary"
})
public class Archive {

    @JsonProperty("DateOn")
    private String dateOn;
    @JsonProperty("Reason")
    private String reason;
    @JsonProperty("Note")
    private String note;
    @JsonProperty("ArcNotary")
    private ArcNotary arcNotary;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("DateOn")
    public String getDateOn() {
        return dateOn;
    }

    @JsonProperty("DateOn")
    public void setDateOn(String dateOn) {
        this.dateOn = dateOn;
    }

    @JsonProperty("Reason")
    public String getReason() {
        return reason;
    }

    @JsonProperty("Reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    @JsonProperty("Note")
    public String getNote() {
        return note;
    }

    @JsonProperty("Note")
    public void setNote(String note) {
        this.note = note;
    }

    @JsonProperty("ArcNotary")
    public ArcNotary getArcNotary() {
        return arcNotary;
    }

    @JsonProperty("ArcNotary")
    public void setArcNotary(ArcNotary arcNotary) {
        this.arcNotary = arcNotary;
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