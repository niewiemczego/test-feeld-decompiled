package com.oblador.keychain.cipherStorage;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyInfo;
import android.util.Log;
import com.oblador.keychain.KeychainModule;
import com.oblador.keychain.SecurityLevel;
import com.oblador.keychain.cipherStorage.CipherStorage;
import com.oblador.keychain.cipherStorage.CipherStorageBase;
import com.oblador.keychain.decryptionHandler.DecryptionResultHandler;
import com.oblador.keychain.exceptions.CryptoFailedException;
import com.oblador.keychain.exceptions.KeyStoreAccessException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;

public class CipherStorageKeystoreAesCbc extends CipherStorageBase {
    public static final String ALGORITHM_AES = "AES";
    public static final String BLOCK_MODE_CBC = "CBC";
    public static final String DEFAULT_SERVICE = "RN_KEYCHAIN_DEFAULT_ALIAS";
    public static final int ENCRYPTION_KEY_SIZE = 256;
    public static final String ENCRYPTION_TRANSFORMATION = "AES/CBC/PKCS7Padding";
    public static final String PADDING_PKCS7 = "PKCS7Padding";

    public String getCipherStorageName() {
        return KeychainModule.KnownCiphers.AES;
    }

    public String getDefaultAliasServiceName() {
        return DEFAULT_SERVICE;
    }

    /* access modifiers changed from: protected */
    public String getEncryptionAlgorithm() {
        return ALGORITHM_AES;
    }

    /* access modifiers changed from: protected */
    public String getEncryptionTransformation() {
        return ENCRYPTION_TRANSFORMATION;
    }

    public int getMinSupportedApiLevel() {
        return 23;
    }

    public boolean isBiometrySupported() {
        return false;
    }

    public SecurityLevel securityLevel() {
        return SecurityLevel.SECURE_HARDWARE;
    }

    public CipherStorage.EncryptionResult encrypt(String str, String str2, String str3, SecurityLevel securityLevel) throws CryptoFailedException {
        throwIfInsufficientLevel(securityLevel);
        try {
            Key extractGeneratedKey = extractGeneratedKey(getDefaultAliasIfEmpty(str, getDefaultAliasServiceName()), securityLevel, new AtomicInteger(1));
            return new CipherStorage.EncryptionResult(encryptString(extractGeneratedKey, str2), encryptString(extractGeneratedKey, str3), (CipherStorage) this);
        } catch (GeneralSecurityException e) {
            throw new CryptoFailedException("Could not encrypt data with alias: " + str, e);
        } catch (Throwable th) {
            throw new CryptoFailedException("Unknown error with alias: " + str + ", error: " + th.getMessage(), th);
        }
    }

    public CipherStorage.DecryptionResult decrypt(String str, byte[] bArr, byte[] bArr2, SecurityLevel securityLevel) throws CryptoFailedException {
        throwIfInsufficientLevel(securityLevel);
        try {
            Key extractGeneratedKey = extractGeneratedKey(getDefaultAliasIfEmpty(str, getDefaultAliasServiceName()), securityLevel, new AtomicInteger(1));
            return new CipherStorage.DecryptionResult(decryptBytes(extractGeneratedKey, bArr), decryptBytes(extractGeneratedKey, bArr2), getSecurityLevel(extractGeneratedKey));
        } catch (GeneralSecurityException e) {
            throw new CryptoFailedException("Could not decrypt data with alias: " + str, e);
        } catch (Throwable th) {
            throw new CryptoFailedException("Unknown error with alias: " + str + ", error: " + th.getMessage(), th);
        }
    }

    public void decrypt(DecryptionResultHandler decryptionResultHandler, String str, byte[] bArr, byte[] bArr2, SecurityLevel securityLevel) {
        try {
            decryptionResultHandler.onDecrypt(decrypt(str, bArr, bArr2, securityLevel), (Throwable) null);
        } catch (Throwable th) {
            decryptionResultHandler.onDecrypt((CipherStorage.DecryptionResult) null, th);
        }
    }

    /* access modifiers changed from: protected */
    public KeyGenParameterSpec.Builder getKeyGenSpecBuilder(String str) throws GeneralSecurityException {
        return getKeyGenSpecBuilder(str, false);
    }

    /* access modifiers changed from: protected */
    public KeyGenParameterSpec.Builder getKeyGenSpecBuilder(String str, boolean z) throws GeneralSecurityException {
        if (Build.VERSION.SDK_INT >= 23) {
            return new KeyGenParameterSpec.Builder(str, 3).setBlockModes(new String[]{BLOCK_MODE_CBC}).setEncryptionPaddings(new String[]{PADDING_PKCS7}).setRandomizedEncryptionRequired(true).setKeySize(256);
        }
        throw new KeyStoreAccessException("Unsupported API" + Build.VERSION.SDK_INT + " version detected.");
    }

    /* access modifiers changed from: protected */
    public KeyInfo getKeyInfo(Key key) throws GeneralSecurityException {
        if (Build.VERSION.SDK_INT >= 23) {
            return (KeyInfo) SecretKeyFactory.getInstance(key.getAlgorithm(), CipherStorageBase.KEYSTORE_TYPE).getKeySpec((SecretKey) key, KeyInfo.class);
        }
        throw new KeyStoreAccessException("Unsupported API" + Build.VERSION.SDK_INT + " version detected.");
    }

    /* access modifiers changed from: protected */
    public Key generateKey(KeyGenParameterSpec keyGenParameterSpec) throws GeneralSecurityException {
        if (Build.VERSION.SDK_INT >= 23) {
            KeyGenerator instance = KeyGenerator.getInstance(getEncryptionAlgorithm(), CipherStorageBase.KEYSTORE_TYPE);
            instance.init(keyGenParameterSpec);
            return instance.generateKey();
        }
        throw new KeyStoreAccessException("Unsupported API" + Build.VERSION.SDK_INT + " version detected.");
    }

    /* access modifiers changed from: protected */
    public String decryptBytes(Key key, byte[] bArr, CipherStorageBase.DecryptBytesHandler decryptBytesHandler) throws GeneralSecurityException, IOException {
        Cipher cachedInstance = getCachedInstance();
        try {
            cachedInstance.init(2, key, CipherStorageBase.IV.readIv(bArr));
            return new String(cachedInstance.doFinal(bArr, 16, bArr.length - 16), UTF8);
        } catch (Throwable th) {
            Log.w(LOG_TAG, th.getMessage(), th);
            throw th;
        }
    }

    public byte[] encryptString(Key key, String str) throws GeneralSecurityException, IOException {
        return encryptString(key, str, CipherStorageBase.IV.encrypt);
    }

    public String decryptBytes(Key key, byte[] bArr) throws GeneralSecurityException, IOException {
        return decryptBytes(key, bArr, CipherStorageBase.IV.decrypt);
    }
}
