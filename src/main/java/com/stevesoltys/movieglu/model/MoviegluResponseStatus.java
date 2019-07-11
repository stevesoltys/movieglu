package com.stevesoltys.movieglu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * The response status.
 *
 * @author Steve Soltys
 */
@Data
public class MoviegluResponseStatus {

    private int count;

    private String state;

    private String method;

    private String message;

    @JsonProperty("request_method")
    private String requestMethod;

    private String version;

    private String territory;

    @JsonProperty("device_datetime_sent")
    private String deviceDatetimeSent;

    @JsonProperty("device_datetime_used")
    private String deviceDatetimeUsed;
}
