package com.danielpsf.labs.exception;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CustomNotFoundException extends NotFoundException implements ExceptionMapper<NotFoundException> {
    private static final long serialVersionUID = 8895117563927638614L;

    public CustomNotFoundException() {
        super();
    }

    public CustomNotFoundException(Response response, Throwable cause) {
        super(response, cause);
    }

    public CustomNotFoundException(Response response) {
        super(response);
    }

    public CustomNotFoundException(String message, Response response, Throwable cause) {
        super(message, response, cause);
    }

    public CustomNotFoundException(String message, Response response) {
        super(message, response);
    }

    public CustomNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomNotFoundException(String message) {
        super(message);
    }

    public CustomNotFoundException(Throwable cause) {
        super(cause);
    }

    @Override
    public Response toResponse(NotFoundException exception) {
        return Response.status(Status.NOT_FOUND)
                       .entity(new ApplicationError(exception.getMessage(), Status.NOT_FOUND.getStatusCode()))
                       .build();
    }
}
