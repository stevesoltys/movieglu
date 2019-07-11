package com.stevesoltys.movieglu;

import com.stevesoltys.movieglu.model.nowshowing.NowShowingResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Steve Soltys
 */
class MoviegluTest {

    private static Movieglu movieglu;

    @BeforeAll
    static void setUp() {
        movieglu = Movieglu.builder()
                .apiEndpoint(System.getenv("API_ENDPOINT"))
                .territory(System.getenv("TERRITORY"))
                .authorization(System.getenv("AUTHORIZATION"))
                .apiKey(System.getenv("API_KEY"))
                .username(System.getenv("USERNAME"))
                .deviceDateTime(Instant.now().toString())
                .build();
    }

    @Test
    void getNowShowing() {
        NowShowingResponse nowShowingResponse = movieglu.getNowShowing(10);

        assertFalse(nowShowingResponse.getFilms().isEmpty());
        assertNotNull(nowShowingResponse.getFilms().get(0).getFilmName());
        assertNotNull(nowShowingResponse.getFilms().get(0).getSynopsisLong());
    }
}