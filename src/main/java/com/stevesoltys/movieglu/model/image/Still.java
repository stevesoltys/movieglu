package com.stevesoltys.movieglu.model.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Steve Soltys
 */
@Data
public class Still {

    @JsonProperty("image_orientation")
    private String imageOrientation;

    private Medium medium;
}
