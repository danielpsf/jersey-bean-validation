package com.danielpsf.labs.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

public class ThrowableMapper extends Throwable implements ExceptionMapper<Throwable> {
    private static final long serialVersionUID = 5761416728151147608L;

    public ThrowableMapper() {
    }

    public ThrowableMapper(String message) {
        super(message);
    }

    public ThrowableMapper(Throwable cause) {
        super(cause);
    }

    public ThrowableMapper(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public Response toResponse(Throwable exception) {
        return Response.status(Status.INTERNAL_SERVER_ERROR)
                .entity(new ApplicationError(exception.getMessage(), Status.INTERNAL_SERVER_ERROR.getStatusCode()))
                .build();
    }
}
