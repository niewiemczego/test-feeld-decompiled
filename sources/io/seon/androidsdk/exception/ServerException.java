package io.seon.androidsdk.exception;

public class ServerException extends SeonException {
    public ServerException() {
        super("Unfortunately, server is currently unavailable, please try again later");
    }
}
