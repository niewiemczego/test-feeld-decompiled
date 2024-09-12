package com.oblador.keychain.cipherStorage;

import com.oblador.keychain.SecurityLevel;
import com.oblador.keychain.decryptionHandler.DecryptionResultHandler;
import com.oblador.keychain.exceptions.CryptoFailedException;
import com.oblador.keychain.exceptions.KeyStoreAccessException;
import java.security.Key;
import java.util.Set;

public interface CipherStorage {
    DecryptionResult decrypt(String str, byte[] bArr, byte[] bArr2, SecurityLevel securityLevel) throws CryptoFailedException;

    void decrypt(DecryptionResultHandler decryptionResultHandler, String str, byte[] bArr, byte[] bArr2, SecurityLevel securityLevel) throws CryptoFailedException;

    EncryptionResult encrypt(String str, String str2, String str3, SecurityLevel securityLevel) throws CryptoFailedException;

    Set<String> getAllKeys() throws KeyStoreAccessException;

    int getCapabilityLevel();

    String getCipherStorageName();

    String getDefaultAliasServiceName();

    int getMinSupportedApiLevel();

    boolean isBiometrySupported();

    void removeKey(String str) throws KeyStoreAccessException;

    SecurityLevel securityLevel();

    boolean supportsSecureHardware();

    public static abstract class CipherResult<T> {
        public final T password;
        public final T username;

        public CipherResult(T t, T t2) {
            this.username = t;
            this.password = t2;
        }
    }

    public static class EncryptionResult extends CipherResult<byte[]> {
        public final String cipherName;

        public EncryptionResult(byte[] bArr, byte[] bArr2, String str) {
            super(bArr, bArr2);
            this.cipherName = str;
        }

        public EncryptionResult(byte[] bArr, byte[] bArr2, CipherStorage cipherStorage) {
            this(bArr, bArr2, cipherStorage.getCipherStorageName());
        }
    }

    public static class DecryptionResult extends CipherResult<String> {
        private final SecurityLevel securityLevel;

        public DecryptionResult(String str, String str2) {
            this(str, str2, SecurityLevel.ANY);
        }

        public DecryptionResult(String str, String str2, SecurityLevel securityLevel2) {
            super(str, str2);
            this.securityLevel = securityLevel2;
        }

        public SecurityLevel getSecurityLevel() {
            return this.securityLevel;
        }
    }

    public static class DecryptionContext extends CipherResult<byte[]> {
        public final Key key;
        public final String keyAlias;

        public DecryptionContext(String str, Key key2, byte[] bArr, byte[] bArr2) {
            super(bArr2, bArr);
            this.keyAlias = str;
            this.key = key2;
        }
    }
}
