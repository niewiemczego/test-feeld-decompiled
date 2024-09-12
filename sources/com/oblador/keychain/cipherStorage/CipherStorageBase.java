package com.oblador.keychain.cipherStorage;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyInfo;
import android.text.TextUtils;
import android.util.Log;
import com.oblador.keychain.SecurityLevel;
import com.oblador.keychain.exceptions.CryptoFailedException;
import com.oblador.keychain.exceptions.KeyStoreAccessException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.ProviderException;
import java.security.UnrecoverableKeyException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;

public abstract class CipherStorageBase implements CipherStorage {
    private static final int BUFFER_READ_WRITE_SIZE = 16384;
    private static final int BUFFER_SIZE = 4096;
    public static final String KEYSTORE_TYPE = "AndroidKeyStore";
    protected static final String LOG_TAG = "CipherStorageBase";
    public static final String TEST_KEY_ALIAS = "AndroidKeyStore#supportsSecureHardware";
    public static final Charset UTF8 = Charset.forName("UTF-8");
    protected final Object _sync = new Object();
    protected final Object _syncStrongbox = new Object();
    protected transient Cipher cachedCipher;
    protected transient KeyStore cachedKeyStore;
    protected transient AtomicBoolean isStrongboxAvailable;
    protected transient AtomicBoolean isSupportsSecureHardware;

    public interface DecryptBytesHandler {
        void initialize(Cipher cipher, Key key, InputStream inputStream) throws GeneralSecurityException, IOException;
    }

    public static final class Defaults {
        public static final DecryptBytesHandler decrypt = new CipherStorageBase$Defaults$$ExternalSyntheticLambda1();
        public static final EncryptStringHandler encrypt = new CipherStorageBase$Defaults$$ExternalSyntheticLambda0();
    }

    public interface EncryptStringHandler {
        void initialize(Cipher cipher, Key key, OutputStream outputStream) throws GeneralSecurityException, IOException;
    }

    /* access modifiers changed from: protected */
    public abstract Key generateKey(KeyGenParameterSpec keyGenParameterSpec) throws GeneralSecurityException;

    /* access modifiers changed from: protected */
    public abstract String getEncryptionAlgorithm();

    /* access modifiers changed from: protected */
    public abstract String getEncryptionTransformation();

    /* access modifiers changed from: protected */
    public abstract KeyGenParameterSpec.Builder getKeyGenSpecBuilder(String str) throws GeneralSecurityException;

    /* access modifiers changed from: protected */
    public abstract KeyGenParameterSpec.Builder getKeyGenSpecBuilder(String str, boolean z) throws GeneralSecurityException;

    /* access modifiers changed from: protected */
    public abstract KeyInfo getKeyInfo(Key key) throws GeneralSecurityException;

    public SecurityLevel securityLevel() {
        return SecurityLevel.SECURE_HARDWARE;
    }

    public final int getCapabilityLevel() {
        return ((isBiometrySupported() ? 1 : 0) * true) + getMinSupportedApiLevel();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x003a A[Catch:{ all -> 0x0037 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean supportsSecureHardware() {
        /*
            r4 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r4.isSupportsSecureHardware
            if (r0 == 0) goto L_0x0009
            boolean r0 = r0.get()
            return r0
        L_0x0009:
            java.lang.Object r0 = r4._sync
            monitor-enter(r0)
            java.util.concurrent.atomic.AtomicBoolean r1 = r4.isSupportsSecureHardware     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x0016
            boolean r1 = r1.get()     // Catch:{ all -> 0x0045 }
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return r1
        L_0x0016:
            java.util.concurrent.atomic.AtomicBoolean r1 = new java.util.concurrent.atomic.AtomicBoolean     // Catch:{ all -> 0x0045 }
            r2 = 0
            r1.<init>(r2)     // Catch:{ all -> 0x0045 }
            r4.isSupportsSecureHardware = r1     // Catch:{ all -> 0x0045 }
            r1 = 0
            com.oblador.keychain.cipherStorage.CipherStorageBase$SelfDestroyKey r2 = new com.oblador.keychain.cipherStorage.CipherStorageBase$SelfDestroyKey     // Catch:{ all -> 0x0038 }
            java.lang.String r3 = "AndroidKeyStore#supportsSecureHardware"
            r2.<init>(r4, r3)     // Catch:{ all -> 0x0038 }
            com.oblador.keychain.SecurityLevel r1 = com.oblador.keychain.SecurityLevel.SECURE_HARDWARE     // Catch:{ all -> 0x0037 }
            java.security.Key r3 = r2.key     // Catch:{ all -> 0x0037 }
            boolean r1 = r4.validateKeySecurityLevel(r1, r3)     // Catch:{ all -> 0x0037 }
            java.util.concurrent.atomic.AtomicBoolean r3 = r4.isSupportsSecureHardware     // Catch:{ all -> 0x0037 }
            r3.set(r1)     // Catch:{ all -> 0x0037 }
            r2.close()     // Catch:{ all -> 0x0045 }
            goto L_0x003d
        L_0x0037:
            r1 = r2
        L_0x0038:
            if (r1 == 0) goto L_0x003d
            r1.close()     // Catch:{ all -> 0x0045 }
        L_0x003d:
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            java.util.concurrent.atomic.AtomicBoolean r0 = r4.isSupportsSecureHardware
            boolean r0 = r0.get()
            return r0
        L_0x0045:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oblador.keychain.cipherStorage.CipherStorageBase.supportsSecureHardware():boolean");
    }

    public String getDefaultAliasServiceName() {
        return getCipherStorageName();
    }

    public void removeKey(String str) throws KeyStoreAccessException {
        String defaultAliasIfEmpty = getDefaultAliasIfEmpty(str, getDefaultAliasServiceName());
        KeyStore keyStoreAndLoad = getKeyStoreAndLoad();
        try {
            if (keyStoreAndLoad.containsAlias(defaultAliasIfEmpty)) {
                keyStoreAndLoad.deleteEntry(defaultAliasIfEmpty);
            }
        } catch (GeneralSecurityException unused) {
        }
    }

    public Set<String> getAllKeys() throws KeyStoreAccessException {
        KeyStore keyStoreAndLoad = getKeyStoreAndLoad();
        try {
            return new HashSet(Collections.list(keyStoreAndLoad.aliases()));
        } catch (KeyStoreException e) {
            throw new KeyStoreAccessException("Error accessing aliases in keystore " + keyStoreAndLoad, e);
        }
    }

    public Cipher getCachedInstance() throws NoSuchAlgorithmException, NoSuchPaddingException {
        if (this.cachedCipher == null) {
            synchronized (this) {
                if (this.cachedCipher == null) {
                    this.cachedCipher = Cipher.getInstance(getEncryptionTransformation());
                }
            }
        }
        return this.cachedCipher;
    }

    /* access modifiers changed from: protected */
    public void throwIfInsufficientLevel(SecurityLevel securityLevel) throws CryptoFailedException {
        if (!securityLevel().satisfiesSafetyThreshold(securityLevel)) {
            throw new CryptoFailedException(String.format("Insufficient security level (wants %s; got %s)", new Object[]{securityLevel, securityLevel()}));
        }
    }

    /* access modifiers changed from: protected */
    public Key extractGeneratedKey(String str, SecurityLevel securityLevel, AtomicInteger atomicInteger) throws GeneralSecurityException {
        Key extractKey;
        do {
            KeyStore keyStoreAndLoad = getKeyStoreAndLoad();
            if (!keyStoreAndLoad.containsAlias(str)) {
                generateKeyAndStoreUnderAlias(str, securityLevel);
            }
            extractKey = extractKey(keyStoreAndLoad, str, atomicInteger);
        } while (extractKey == null);
        return extractKey;
    }

    /* access modifiers changed from: protected */
    public Key extractKey(KeyStore keyStore, String str, AtomicInteger atomicInteger) throws GeneralSecurityException {
        try {
            Key key = keyStore.getKey(str, (char[]) null);
            if (key != null) {
                return key;
            }
            throw new KeyStoreAccessException("Empty key extracted!");
        } catch (UnrecoverableKeyException e) {
            if (atomicInteger.getAndDecrement() > 0) {
                keyStore.deleteEntry(str);
                return null;
            }
            throw e;
        }
    }

    /* access modifiers changed from: protected */
    public boolean validateKeySecurityLevel(SecurityLevel securityLevel, Key key) throws GeneralSecurityException {
        return getSecurityLevel(key).satisfiesSafetyThreshold(securityLevel);
    }

    /* access modifiers changed from: protected */
    public SecurityLevel getSecurityLevel(Key key) throws GeneralSecurityException {
        KeyInfo keyInfo = getKeyInfo(key);
        if (Build.VERSION.SDK_INT < 23 || !keyInfo.isInsideSecureHardware()) {
            return SecurityLevel.SECURE_SOFTWARE;
        }
        return SecurityLevel.SECURE_HARDWARE;
    }

    public KeyStore getKeyStoreAndLoad() throws KeyStoreAccessException {
        if (this.cachedKeyStore == null) {
            synchronized (this) {
                if (this.cachedKeyStore == null) {
                    try {
                        KeyStore instance = KeyStore.getInstance(KEYSTORE_TYPE);
                        instance.load((KeyStore.LoadStoreParameter) null);
                        this.cachedKeyStore = instance;
                    } catch (Throwable th) {
                        throw new KeyStoreAccessException("Could not access Keystore", th);
                    }
                }
            }
        }
        return this.cachedKeyStore;
    }

    public byte[] encryptString(Key key, String str) throws IOException, GeneralSecurityException {
        return encryptString(key, str, Defaults.encrypt);
    }

    public String decryptBytes(Key key, byte[] bArr) throws IOException, GeneralSecurityException {
        return decryptBytes(key, bArr, Defaults.decrypt);
    }

    /* access modifiers changed from: protected */
    public byte[] encryptString(Key key, String str, EncryptStringHandler encryptStringHandler) throws IOException, GeneralSecurityException {
        CipherOutputStream cipherOutputStream;
        Cipher cachedInstance = getCachedInstance();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (encryptStringHandler != null) {
                try {
                    encryptStringHandler.initialize(cachedInstance, key, byteArrayOutputStream);
                    byteArrayOutputStream.flush();
                } catch (Throwable th) {
                    byteArrayOutputStream.close();
                    throw th;
                }
            }
            cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, cachedInstance);
            cipherOutputStream.write(str.getBytes(UTF8));
            cipherOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
            throw th;
        } catch (Throwable th2) {
            Log.e(LOG_TAG, th2.getMessage(), th2);
            throw th2;
        }
    }

    /* access modifiers changed from: protected */
    public String decryptBytes(Key key, byte[] bArr, DecryptBytesHandler decryptBytesHandler) throws GeneralSecurityException, IOException {
        CipherInputStream cipherInputStream;
        Cipher cachedInstance = getCachedInstance();
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (decryptBytesHandler != null) {
                    try {
                        decryptBytesHandler.initialize(cachedInstance, key, byteArrayInputStream);
                    } catch (Throwable th) {
                        byteArrayOutputStream.close();
                        throw th;
                    }
                }
                cipherInputStream = new CipherInputStream(byteArrayInputStream, cachedInstance);
                copy(cipherInputStream, byteArrayOutputStream);
                cipherInputStream.close();
                String str = new String(byteArrayOutputStream.toByteArray(), UTF8);
                byteArrayOutputStream.close();
                byteArrayInputStream.close();
                return str;
                throw th;
            } catch (Throwable th2) {
                byteArrayInputStream.close();
                throw th2;
            }
        } catch (Throwable th3) {
            Log.w(LOG_TAG, th3.getMessage(), th3);
            throw th3;
        }
    }

    public void generateKeyAndStoreUnderAlias(String str, SecurityLevel securityLevel) throws GeneralSecurityException {
        Key key;
        synchronized (this._syncStrongbox) {
            AtomicBoolean atomicBoolean = this.isStrongboxAvailable;
            key = null;
            if (atomicBoolean == null || atomicBoolean.get()) {
                if (this.isStrongboxAvailable == null) {
                    this.isStrongboxAvailable = new AtomicBoolean(false);
                }
                try {
                    key = tryGenerateStrongBoxSecurityKey(str);
                    this.isStrongboxAvailable.set(true);
                } catch (GeneralSecurityException | ProviderException e) {
                    Log.w(LOG_TAG, "StrongBox security storage is not available.", e);
                }
            }
        }
        if (key == null || !this.isStrongboxAvailable.get()) {
            try {
                key = tryGenerateRegularSecurityKey(str);
            } catch (GeneralSecurityException e2) {
                Log.e(LOG_TAG, "Regular security storage is not available.", e2);
                throw e2;
            }
        }
        if (!validateKeySecurityLevel(securityLevel, key)) {
            throw new CryptoFailedException("Cannot generate keys with required security guarantees");
        }
    }

    /* access modifiers changed from: protected */
    public Key tryGenerateRegularSecurityKey(String str) throws GeneralSecurityException {
        return tryGenerateRegularSecurityKey(str, false);
    }

    /* access modifiers changed from: protected */
    public Key tryGenerateRegularSecurityKey(String str, boolean z) throws GeneralSecurityException {
        if (Build.VERSION.SDK_INT >= 23) {
            return generateKey(getKeyGenSpecBuilder(str, z).build());
        }
        throw new KeyStoreAccessException("Regular security keystore is not supported for old API" + Build.VERSION.SDK_INT + ".");
    }

    /* access modifiers changed from: protected */
    public Key tryGenerateStrongBoxSecurityKey(String str) throws GeneralSecurityException {
        return tryGenerateStrongBoxSecurityKey(str, false);
    }

    /* access modifiers changed from: protected */
    public Key tryGenerateStrongBoxSecurityKey(String str, boolean z) throws GeneralSecurityException {
        if (Build.VERSION.SDK_INT >= 28) {
            return generateKey(getKeyGenSpecBuilder(str, z).setIsStrongBoxBacked(true).build());
        }
        throw new KeyStoreAccessException("Strong box security keystore is not supported for old API" + Build.VERSION.SDK_INT + ".");
    }

    public CipherStorageBase setCipher(Cipher cipher) {
        this.cachedCipher = cipher;
        return this;
    }

    public CipherStorageBase setKeyStore(KeyStore keyStore) {
        this.cachedKeyStore = keyStore;
        return this;
    }

    public static String getDefaultAliasIfEmpty(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[16384];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static final class IV {
        public static final int IV_LENGTH = 16;
        public static final DecryptBytesHandler decrypt = new CipherStorageBase$IV$$ExternalSyntheticLambda1();
        public static final EncryptStringHandler encrypt = new CipherStorageBase$IV$$ExternalSyntheticLambda0();

        static /* synthetic */ void lambda$static$0(Cipher cipher, Key key, OutputStream outputStream) throws GeneralSecurityException, IOException {
            cipher.init(1, key);
            byte[] iv = cipher.getIV();
            outputStream.write(iv, 0, iv.length);
        }

        public static IvParameterSpec readIv(byte[] bArr) throws IOException {
            byte[] bArr2 = new byte[16];
            if (16 < bArr.length) {
                System.arraycopy(bArr, 0, bArr2, 0, 16);
                return new IvParameterSpec(bArr2);
            }
            throw new IOException("Insufficient length of input data for IV extracting.");
        }

        public static IvParameterSpec readIv(InputStream inputStream) throws IOException {
            byte[] bArr = new byte[16];
            if (inputStream.read(bArr, 0, 16) == 16) {
                return new IvParameterSpec(bArr);
            }
            throw new IOException("Input stream has insufficient data.");
        }
    }

    public class SelfDestroyKey implements Closeable {
        public final Key key;
        public final String name;

        public SelfDestroyKey(CipherStorageBase cipherStorageBase, String str) throws GeneralSecurityException {
            this(str, cipherStorageBase.tryGenerateRegularSecurityKey(str, true));
        }

        public SelfDestroyKey(String str, Key key2) {
            this.name = str;
            this.key = key2;
        }

        public void close() {
            try {
                CipherStorageBase.this.removeKey(this.name);
            } catch (KeyStoreAccessException e) {
                Log.w(CipherStorageBase.LOG_TAG, "AutoClose remove key failed. Error: " + e.getMessage(), e);
            }
        }
    }
}
