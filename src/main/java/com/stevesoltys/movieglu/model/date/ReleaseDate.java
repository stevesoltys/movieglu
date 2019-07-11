package com.stevesoltys.movieglu.model.date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Steve Soltys
 */
@Data
public class ReleaseDate {

    @JsonProperty("release_date")
    private String releaseDate;

    private String notes;
}
