package com.task10.crudapi_login.exception;

public class ClientBadRequestException extends RuntimeException {
    public ClientBadRequestException() {
        super();
    }

    public ClientBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientBadRequestException(String message) {
        super(message);
    }

    public ClientBadRequestException(Throwable cause) {
        super(cause);
    }
}
