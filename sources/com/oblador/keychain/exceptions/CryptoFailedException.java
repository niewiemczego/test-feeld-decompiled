package com.oblador.keychain.exceptions;

import java.security.GeneralSecurityException;

public class CryptoFailedException extends GeneralSecurityException {
    public CryptoFailedException(String str) {
        super(str);
    }

    public CryptoFailedException(String str, Throwable th) {
        super(str, th);
    }

    public static void reThrowOnError(Throwable th) throws CryptoFailedException {
        if (th != null) {
            if (th instanceof CryptoFailedException) {
                throw ((CryptoFailedException) th);
            }
            throw new CryptoFailedException("Wrapped error: " + th.getMessage(), th);
        }
    }
}
