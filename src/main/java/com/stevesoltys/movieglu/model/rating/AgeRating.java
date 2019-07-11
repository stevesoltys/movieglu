package com.stevesoltys.movieglu.model.rating;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Steve Soltys
 */
@Data
public class AgeRating {

    private String rating;

    @JsonProperty("age_rating_image")
    private String ageRatingImage;

    @JsonProperty("age_advisory")
    private String ageAdvisory;
}
