package com.oblador.keychain.decryptionHandler;

import com.oblador.keychain.cipherStorage.CipherStorage;

public interface DecryptionResultHandler {
    void askAccessPermissions(CipherStorage.DecryptionContext decryptionContext);

    Throwable getError();

    CipherStorage.DecryptionResult getResult();

    void onDecrypt(CipherStorage.DecryptionResult decryptionResult, Throwable th);

    void waitResult();
}
