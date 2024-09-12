package com.oblador.keychain.cipherStorage;

import com.oblador.keychain.cipherStorage.CipherStorageBase;
import java.io.InputStream;
import java.security.Key;
import javax.crypto.Cipher;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CipherStorageBase$Defaults$$ExternalSyntheticLambda1 implements CipherStorageBase.DecryptBytesHandler {
    public final void initialize(Cipher cipher, Key key, InputStream inputStream) {
        cipher.init(2, key);
    }
}
