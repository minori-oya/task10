package com.task10.crudapi_login.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException() {

        super();
    }

    public ClientNotFoundException(String message, Throwable cause) {

        super(message, cause);
    }

    public ClientNotFoundException(String message) {

        super(message);
    }

    public ClientNotFoundException(Throwable cause) {

        super(cause);
    }
}
