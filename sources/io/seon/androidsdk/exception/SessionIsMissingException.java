package io.seon.androidsdk.exception;

public class SessionIsMissingException extends SeonException {
    public SessionIsMissingException() {
        super("Session ID cannot be null or empty, please check that you have properly configured the session_id property on your Seon object instance!");
    }
}
