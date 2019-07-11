package com.stevesoltys.movieglu.model.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Steve Soltys
 */
@Data
public class Medium {

    @JsonProperty("film_image")
    private String filmImage;

    private int width;

    private int height;
}
