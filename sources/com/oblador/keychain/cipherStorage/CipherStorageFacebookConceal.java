package com.oblador.keychain.cipherStorage;

import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyInfo;
import android.util.Log;
import com.facebook.android.crypto.keychain.AndroidConceal;
import com.facebook.android.crypto.keychain.SharedPrefsBackedKeyChain;
import com.facebook.crypto.Crypto;
import com.facebook.crypto.CryptoConfig;
import com.facebook.crypto.Entity;
import com.facebook.react.bridge.AssertionException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.oblador.keychain.KeychainModule;
import com.oblador.keychain.SecurityLevel;
import com.oblador.keychain.cipherStorage.CipherStorage;
import com.oblador.keychain.decryptionHandler.DecryptionResultHandler;
import com.oblador.keychain.exceptions.CryptoFailedException;
import java.security.GeneralSecurityException;
import java.security.Key;

public class CipherStorageFacebookConceal extends CipherStorageBase {
    public static final String KEYCHAIN_DATA = "RN_KEYCHAIN";
    private final Crypto crypto;

    public String getCipherStorageName() {
        return KeychainModule.KnownCiphers.FB;
    }

    public int getMinSupportedApiLevel() {
        return 16;
    }

    public boolean isBiometrySupported() {
        return false;
    }

    public boolean supportsSecureHardware() {
        return false;
    }

    public CipherStorageFacebookConceal(ReactApplicationContext reactApplicationContext) {
        this.crypto = AndroidConceal.get().createDefaultCrypto(new SharedPrefsBackedKeyChain(reactApplicationContext, CryptoConfig.KEY_256));
    }

    public SecurityLevel securityLevel() {
        return SecurityLevel.ANY;
    }

    public CipherStorage.EncryptionResult encrypt(String str, String str2, String str3, SecurityLevel securityLevel) throws CryptoFailedException {
        throwIfInsufficientLevel(securityLevel);
        throwIfNoCryptoAvailable();
        try {
            return new CipherStorage.EncryptionResult(this.crypto.encrypt(str2.getBytes(UTF8), createUsernameEntity(str)), this.crypto.encrypt(str3.getBytes(UTF8), createPasswordEntity(str)), (CipherStorage) this);
        } catch (Throwable th) {
            throw new CryptoFailedException("Encryption failed for alias: " + str, th);
        }
    }

    public CipherStorage.DecryptionResult decrypt(String str, byte[] bArr, byte[] bArr2, SecurityLevel securityLevel) throws CryptoFailedException {
        throwIfInsufficientLevel(securityLevel);
        throwIfNoCryptoAvailable();
        Entity createUsernameEntity = createUsernameEntity(str);
        Entity createPasswordEntity = createPasswordEntity(str);
        try {
            return new CipherStorage.DecryptionResult(new String(this.crypto.decrypt(bArr, createUsernameEntity), UTF8), new String(this.crypto.decrypt(bArr2, createPasswordEntity), UTF8), SecurityLevel.ANY);
        } catch (Throwable th) {
            throw new CryptoFailedException("Decryption failed for alias: " + str, th);
        }
    }

    public void decrypt(DecryptionResultHandler decryptionResultHandler, String str, byte[] bArr, byte[] bArr2, SecurityLevel securityLevel) {
        try {
            decryptionResultHandler.onDecrypt(decrypt(str, bArr, bArr2, securityLevel), (Throwable) null);
        } catch (Throwable th) {
            decryptionResultHandler.onDecrypt((CipherStorage.DecryptionResult) null, th);
        }
    }

    public void removeKey(String str) {
        Log.w(LOG_TAG, "CipherStorageFacebookConceal removeKey called. alias: " + str);
    }

    /* access modifiers changed from: protected */
    public KeyGenParameterSpec.Builder getKeyGenSpecBuilder(String str) throws GeneralSecurityException {
        throw new CryptoFailedException("Not designed for a call");
    }

    /* access modifiers changed from: protected */
    public KeyGenParameterSpec.Builder getKeyGenSpecBuilder(String str, boolean z) throws GeneralSecurityException {
        throw new CryptoFailedException("Not designed for a call");
    }

    /* access modifiers changed from: protected */
    public KeyInfo getKeyInfo(Key key) throws GeneralSecurityException {
        throw new CryptoFailedException("Not designed for a call");
    }

    /* access modifiers changed from: protected */
    public Key generateKey(KeyGenParameterSpec keyGenParameterSpec) throws GeneralSecurityException {
        throw new CryptoFailedException("Not designed for a call");
    }

    /* access modifiers changed from: protected */
    public String getEncryptionAlgorithm() {
        throw new AssertionException("Not designed for a call");
    }

    /* access modifiers changed from: protected */
    public String getEncryptionTransformation() {
        throw new AssertionException("Not designed for a call");
    }

    private void throwIfNoCryptoAvailable() throws CryptoFailedException {
        if (!this.crypto.isAvailable()) {
            throw new CryptoFailedException("Crypto is missing");
        }
    }

    private static Entity createUsernameEntity(String str) {
        return Entity.create(getEntityPrefix(str) + "user");
    }

    private static Entity createPasswordEntity(String str) {
        return Entity.create(getEntityPrefix(str) + "pass");
    }

    private static String getEntityPrefix(String str) {
        return "RN_KEYCHAIN:" + str;
    }
}
