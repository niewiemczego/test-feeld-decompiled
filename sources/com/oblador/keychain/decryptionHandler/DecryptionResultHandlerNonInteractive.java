package com.oblador.keychain.decryptionHandler;

import com.oblador.keychain.cipherStorage.CipherStorage;
import com.oblador.keychain.exceptions.CryptoFailedException;

public class DecryptionResultHandlerNonInteractive implements DecryptionResultHandler {
    private Throwable error;
    private CipherStorage.DecryptionResult result;

    public void waitResult() {
    }

    public void askAccessPermissions(CipherStorage.DecryptionContext decryptionContext) {
        onDecrypt((CipherStorage.DecryptionResult) null, new CryptoFailedException("Non interactive decryption mode."));
    }

    public void onDecrypt(CipherStorage.DecryptionResult decryptionResult, Throwable th) {
        this.result = decryptionResult;
        this.error = th;
    }

    public CipherStorage.DecryptionResult getResult() {
        return this.result;
    }

    public Throwable getError() {
        return this.error;
    }
}
