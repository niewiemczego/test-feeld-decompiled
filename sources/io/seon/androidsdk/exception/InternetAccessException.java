package io.seon.androidsdk.exception;

public class InternetAccessException extends SeonException {
    public InternetAccessException() {
        super("Internet access denied. Please make sure you have added right permission in manifest");
    }
}
