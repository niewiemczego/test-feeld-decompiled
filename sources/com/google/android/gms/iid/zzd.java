package com.google.android.gms.iid;

import com.oblador.keychain.cipherStorage.CipherStorageKeystoreRsaEcb;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public final class zzd {
    public static KeyPair zzl() {
        try {
            KeyPairGenerator instance = KeyPairGenerator.getInstance(CipherStorageKeystoreRsaEcb.ALGORITHM_RSA);
            instance.initialize(2048);
            return instance.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }
}
