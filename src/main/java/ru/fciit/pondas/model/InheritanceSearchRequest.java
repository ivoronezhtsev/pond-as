package ru.fciit.pondas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class InheritanceSearchRequest {
    public String name;
    @JsonProperty("birth_date")
    String birthDate;
    @JsonProperty("death_date")
    String deathDate;
}
