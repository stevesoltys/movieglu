package com.stevesoltys.movieglu.model.nowshowing;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stevesoltys.movieglu.model.date.ReleaseDate;
import com.stevesoltys.movieglu.model.image.Images;
import com.stevesoltys.movieglu.model.rating.AgeRating;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author Steve Soltys
 */
@Data
public class NowShowingFilm {

    @JsonProperty("film_id")
    private int filmId;

    @JsonProperty("imdb_id")
    private int imdbId;

    @JsonProperty("film_name")
    private String filmName;

    @JsonProperty("synopsis_long")
    private String synopsisLong;

    @JsonProperty("age_rating")
    private List<AgeRating> ageRatings;

    @JsonProperty("release_dates")
    private List<ReleaseDate> releaseDates;

    private Images images;

    @JsonProperty("other_titles")
    private Map<String, String> otherTitles;
}
