package com.oblador.keychain.cipherStorage;

import com.oblador.keychain.cipherStorage.CipherStorageBase;
import java.io.OutputStream;
import java.security.Key;
import javax.crypto.Cipher;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CipherStorageBase$Defaults$$ExternalSyntheticLambda0 implements CipherStorageBase.EncryptStringHandler {
    public final void initialize(Cipher cipher, Key key, OutputStream outputStream) {
        cipher.init(1, key);
    }
}