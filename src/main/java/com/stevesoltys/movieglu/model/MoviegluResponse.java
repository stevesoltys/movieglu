package com.stevesoltys.movieglu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * A Movieglu response base class.
 *
 * @author Steve Soltys
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MoviegluResponse {

    private MoviegluResponseStatus responseStatus;
}
