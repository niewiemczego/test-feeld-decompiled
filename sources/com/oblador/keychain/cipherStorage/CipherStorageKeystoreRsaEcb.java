package com.oblador.keychain.cipherStorage;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyInfo;
import com.oblador.keychain.KeychainModule;
import com.oblador.keychain.SecurityLevel;
import com.oblador.keychain.cipherStorage.CipherStorage;
import com.oblador.keychain.decryptionHandler.DecryptionResultHandlerNonInteractive;
import com.oblador.keychain.exceptions.CryptoFailedException;
import com.oblador.keychain.exceptions.KeyStoreAccessException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.NoSuchPaddingException;

public class CipherStorageKeystoreRsaEcb extends CipherStorageBase {
    public static final String ALGORITHM_RSA = "RSA";
    public static final String BLOCK_MODE_ECB = "ECB";
    public static final int ENCRYPTION_KEY_SIZE = 3072;
    public static final int ENCRYPTION_KEY_SIZE_WHEN_TESTING = 512;
    public static final String PADDING_PKCS1 = "PKCS1Padding";
    public static final String TRANSFORMATION_RSA_ECB_PKCS1 = "RSA/ECB/PKCS1Padding";

    public String getCipherStorageName() {
        return KeychainModule.KnownCiphers.RSA;
    }

    /* access modifiers changed from: protected */
    public String getEncryptionAlgorithm() {
        return ALGORITHM_RSA;
    }

    /* access modifiers changed from: protected */
    public String getEncryptionTransformation() {
        return TRANSFORMATION_RSA_ECB_PKCS1;
    }

    public int getMinSupportedApiLevel() {
        return 23;
    }

    public boolean isBiometrySupported() {
        return true;
    }

    public CipherStorage.EncryptionResult encrypt(String str, String str2, String str3, SecurityLevel securityLevel) throws CryptoFailedException {
        throwIfInsufficientLevel(securityLevel);
        try {
            return innerEncryptedCredentials(getDefaultAliasIfEmpty(str, getDefaultAliasServiceName()), str3, str2, securityLevel);
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException e) {
            throw new CryptoFailedException("Could not encrypt data for service " + str, e);
        } catch (KeyStoreAccessException | KeyStoreException e2) {
            throw new CryptoFailedException("Could not access Keystore for service " + str, e2);
        } catch (IOException e3) {
            throw new CryptoFailedException("I/O error: " + e3.getMessage(), e3);
        } catch (Throwable th) {
            throw new CryptoFailedException("Unknown error: " + th.getMessage(), th);
        }
    }

    public CipherStorage.DecryptionResult decrypt(String str, byte[] bArr, byte[] bArr2, SecurityLevel securityLevel) throws CryptoFailedException {
        DecryptionResultHandlerNonInteractive decryptionResultHandlerNonInteractive = new DecryptionResultHandlerNonInteractive();
        decrypt(decryptionResultHandlerNonInteractive, str, bArr, bArr2, securityLevel);
        CryptoFailedException.reThrowOnError(decryptionResultHandlerNonInteractive.getError());
        if (decryptionResultHandlerNonInteractive.getResult() != null) {
            return decryptionResultHandlerNonInteractive.getResult();
        }
        throw new CryptoFailedException("No decryption results and no error. Something deeply wrong!");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002a, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002b, code lost:
        r5.onDecrypt((com.oblador.keychain.cipherStorage.CipherStorage.DecryptionResult) null, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x002a A[ExcHandler: all (r6v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0012] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decrypt(com.oblador.keychain.decryptionHandler.DecryptionResultHandler r5, java.lang.String r6, byte[] r7, byte[] r8, com.oblador.keychain.SecurityLevel r9) throws com.oblador.keychain.exceptions.CryptoFailedException {
        /*
            r4 = this;
            r4.throwIfInsufficientLevel(r9)
            java.lang.String r0 = r4.getDefaultAliasServiceName()
            java.lang.String r6 = getDefaultAliasIfEmpty(r6, r0)
            java.util.concurrent.atomic.AtomicInteger r0 = new java.util.concurrent.atomic.AtomicInteger
            r1 = 1
            r0.<init>(r1)
            r1 = 0
            java.security.Key r9 = r4.extractGeneratedKey(r6, r9, r0)     // Catch:{ UserNotAuthenticatedException -> 0x002f, all -> 0x002a }
            com.oblador.keychain.cipherStorage.CipherStorage$DecryptionResult r0 = new com.oblador.keychain.cipherStorage.CipherStorage$DecryptionResult     // Catch:{ UserNotAuthenticatedException -> 0x0027, all -> 0x002a }
            java.lang.String r2 = r4.decryptBytes(r9, r7)     // Catch:{ UserNotAuthenticatedException -> 0x0027, all -> 0x002a }
            java.lang.String r3 = r4.decryptBytes(r9, r8)     // Catch:{ UserNotAuthenticatedException -> 0x0027, all -> 0x002a }
            r0.<init>(r2, r3)     // Catch:{ UserNotAuthenticatedException -> 0x0027, all -> 0x002a }
            r5.onDecrypt(r0, r1)     // Catch:{ UserNotAuthenticatedException -> 0x0027, all -> 0x002a }
            goto L_0x0054
        L_0x0027:
            r0 = move-exception
            r1 = r9
            goto L_0x0030
        L_0x002a:
            r6 = move-exception
            r5.onDecrypt(r1, r6)
            goto L_0x0054
        L_0x002f:
            r0 = move-exception
        L_0x0030:
            java.lang.String r9 = LOG_TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unlock of keystore is needed. Error: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r0.getMessage()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r9, r2, r0)
            com.oblador.keychain.cipherStorage.CipherStorage$DecryptionContext r9 = new com.oblador.keychain.cipherStorage.CipherStorage$DecryptionContext
            r9.<init>(r6, r1, r8, r7)
            r5.askAccessPermissions(r9)
        L_0x0054:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oblador.keychain.cipherStorage.CipherStorageKeystoreRsaEcb.decrypt(com.oblador.keychain.decryptionHandler.DecryptionResultHandler, java.lang.String, byte[], byte[], com.oblador.keychain.SecurityLevel):void");
    }

    private CipherStorage.EncryptionResult innerEncryptedCredentials(String str, String str2, String str3, SecurityLevel securityLevel) throws GeneralSecurityException, IOException {
        KeyStore keyStoreAndLoad = getKeyStoreAndLoad();
        if (!keyStoreAndLoad.containsAlias(str)) {
            generateKeyAndStoreUnderAlias(str, securityLevel);
        }
        PublicKey generatePublic = KeyFactory.getInstance(ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(keyStoreAndLoad.getCertificate(str).getPublicKey().getEncoded()));
        return new CipherStorage.EncryptionResult(encryptString(generatePublic, str3), encryptString(generatePublic, str2), (CipherStorage) this);
    }

    /* access modifiers changed from: protected */
    public KeyGenParameterSpec.Builder getKeyGenSpecBuilder(String str) throws GeneralSecurityException {
        return getKeyGenSpecBuilder(str, false);
    }

    /* access modifiers changed from: protected */
    public KeyGenParameterSpec.Builder getKeyGenSpecBuilder(String str, boolean z) throws GeneralSecurityException {
        if (Build.VERSION.SDK_INT >= 23) {
            return new KeyGenParameterSpec.Builder(str, 3).setBlockModes(new String[]{BLOCK_MODE_ECB}).setEncryptionPaddings(new String[]{PADDING_PKCS1}).setRandomizedEncryptionRequired(true).setUserAuthenticationRequired(true).setUserAuthenticationValidityDurationSeconds(5).setKeySize(z ? 512 : ENCRYPTION_KEY_SIZE);
        }
        throw new KeyStoreAccessException("Unsupported API" + Build.VERSION.SDK_INT + " version detected.");
    }

    /* access modifiers changed from: protected */
    public KeyInfo getKeyInfo(Key key) throws GeneralSecurityException {
        if (Build.VERSION.SDK_INT >= 23) {
            return (KeyInfo) KeyFactory.getInstance(key.getAlgorithm(), CipherStorageBase.KEYSTORE_TYPE).getKeySpec(key, KeyInfo.class);
        }
        throw new KeyStoreAccessException("Unsupported API" + Build.VERSION.SDK_INT + " version detected.");
    }

    /* access modifiers changed from: protected */
    public Key generateKey(KeyGenParameterSpec keyGenParameterSpec) throws GeneralSecurityException {
        if (Build.VERSION.SDK_INT >= 23) {
            KeyPairGenerator instance = KeyPairGenerator.getInstance(getEncryptionAlgorithm(), CipherStorageBase.KEYSTORE_TYPE);
            instance.initialize(keyGenParameterSpec);
            return instance.generateKeyPair().getPrivate();
        }
        throw new KeyStoreAccessException("Unsupported API" + Build.VERSION.SDK_INT + " version detected.");
    }
}
