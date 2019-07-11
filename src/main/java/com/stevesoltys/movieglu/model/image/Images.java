package com.stevesoltys.movieglu.model.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

/**
 * @author Steve Soltys
 */
@Data
public class Images {

    @JsonProperty("poster")
    private Map<String, Poster> posters;

    @JsonProperty("still")
    private Map<String, Still> stills;
}
