package com.oblador.keychain.exceptions;

import java.security.GeneralSecurityException;

public class KeyStoreAccessException extends GeneralSecurityException {
    public KeyStoreAccessException(String str) {
        super(str);
    }

    public KeyStoreAccessException(String str, Throwable th) {
        super(str, th);
    }
}
