package com.stevesoltys.movieglu;

import lombok.Getter;
import retrofit2.Response;

/**
 * @author Steve Soltys
 */
public class MoviegluException extends RuntimeException {

    @Getter
    private Response errorResponse;

    public MoviegluException(Response errorResponse) {
        super(errorResponse.message());

        this.errorResponse = errorResponse;
    }

    public MoviegluException(Exception exception) {
        super(exception);
    }
}
