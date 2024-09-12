package com.oblador.keychain;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.biometric.BiometricPrompt;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.oblador.keychain.PrefsStorage;
import com.oblador.keychain.cipherStorage.CipherStorage;
import com.oblador.keychain.cipherStorage.CipherStorageBase;
import com.oblador.keychain.cipherStorage.CipherStorageFacebookConceal;
import com.oblador.keychain.cipherStorage.CipherStorageKeystoreAesCbc;
import com.oblador.keychain.cipherStorage.CipherStorageKeystoreRsaEcb;
import com.oblador.keychain.decryptionHandler.DecryptionResultHandler;
import com.oblador.keychain.decryptionHandler.DecryptionResultHandlerProvider;
import com.oblador.keychain.exceptions.CryptoFailedException;
import com.oblador.keychain.exceptions.EmptyParameterException;
import com.oblador.keychain.exceptions.KeyStoreAccessException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class KeychainModule extends ReactContextBaseJavaModule {
    public static final String EMPTY_STRING = "";
    public static final String FACE_SUPPORTED_NAME = "Face";
    public static final String FINGERPRINT_SUPPORTED_NAME = "Fingerprint";
    public static final String IRIS_SUPPORTED_NAME = "Iris";
    public static final String KEYCHAIN_MODULE = "RNKeychainManager";
    private static final String LOG_TAG = "KeychainModule";
    public static final String WARMING_UP_ALIAS = "warmingUp";
    private final Map<String, CipherStorage> cipherStorageMap = new HashMap();
    private final PrefsStorage prefsStorage;

    @interface AccessControl {
        public static final String APPLICATION_PASSWORD = "ApplicationPassword";
        public static final String BIOMETRY_ANY = "BiometryAny";
        public static final String BIOMETRY_ANY_OR_DEVICE_PASSCODE = "BiometryAnyOrDevicePasscode";
        public static final String BIOMETRY_CURRENT_SET = "BiometryCurrentSet";
        public static final String BIOMETRY_CURRENT_SET_OR_DEVICE_PASSCODE = "BiometryCurrentSetOrDevicePasscode";
        public static final String DEVICE_PASSCODE = "DevicePasscode";
        public static final String NONE = "None";
        public static final String USER_PRESENCE = "UserPresence";
    }

    @interface AuthPromptOptions {
        public static final String CANCEL = "cancel";
        public static final String DESCRIPTION = "description";
        public static final String SUBTITLE = "subtitle";
        public static final String TITLE = "title";
    }

    @interface Errors {
        public static final String E_CRYPTO_FAILED = "E_CRYPTO_FAILED";
        public static final String E_EMPTY_PARAMETERS = "E_EMPTY_PARAMETERS";
        public static final String E_KEYSTORE_ACCESS_ERROR = "E_KEYSTORE_ACCESS_ERROR";
        public static final String E_SUPPORTED_BIOMETRY_ERROR = "E_SUPPORTED_BIOMETRY_ERROR";
        public static final String E_UNKNOWN_ERROR = "E_UNKNOWN_ERROR";
    }

    public @interface KnownCiphers {
        public static final String AES = "KeystoreAESCBC";
        public static final String FB = "FacebookConceal";
        public static final String RSA = "KeystoreRSAECB";
    }

    @interface Maps {
        public static final String ACCESSIBLE = "accessible";
        public static final String ACCESS_CONTROL = "accessControl";
        public static final String ACCESS_GROUP = "accessGroup";
        public static final String AUTH_PROMPT = "authenticationPrompt";
        public static final String AUTH_TYPE = "authenticationType";
        public static final String PASSWORD = "password";
        public static final String RULES = "rules";
        public static final String SECURITY_LEVEL = "securityLevel";
        public static final String SERVICE = "service";
        public static final String STORAGE = "storage";
        public static final String USERNAME = "username";
    }

    @interface Rules {
        public static final String AUTOMATIC_UPGRADE = "automaticUpgradeToMoreSecuredStorage";
        public static final String NONE = "none";
    }

    private static String getAliasOrDefault(String str) {
        return str == null ? "" : str;
    }

    public String getName() {
        return KEYCHAIN_MODULE;
    }

    public KeychainModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.prefsStorage = new PrefsStorage(reactApplicationContext);
        addCipherStorageToMap(new CipherStorageFacebookConceal(reactApplicationContext));
        addCipherStorageToMap(new CipherStorageKeystoreAesCbc());
        if (Build.VERSION.SDK_INT >= 23) {
            addCipherStorageToMap(new CipherStorageKeystoreRsaEcb());
        }
    }

    public static KeychainModule withWarming(ReactApplicationContext reactApplicationContext) {
        KeychainModule keychainModule = new KeychainModule(reactApplicationContext);
        Objects.requireNonNull(keychainModule);
        Thread thread = new Thread(new KeychainModule$$ExternalSyntheticLambda0(keychainModule), "keychain-warming-up");
        thread.setDaemon(true);
        thread.start();
        return keychainModule;
    }

    /* access modifiers changed from: private */
    public void internalWarmingBestCipher() {
        try {
            long nanoTime = System.nanoTime();
            Log.v(KEYCHAIN_MODULE, "warming up started at " + nanoTime);
            CipherStorageBase cipherStorageBase = (CipherStorageBase) getCipherStorageForCurrentAPILevel();
            cipherStorageBase.getCachedInstance();
            cipherStorageBase.generateKeyAndStoreUnderAlias(WARMING_UP_ALIAS, cipherStorageBase.supportsSecureHardware() ? SecurityLevel.SECURE_HARDWARE : SecurityLevel.SECURE_SOFTWARE);
            cipherStorageBase.getKeyStoreAndLoad();
            Log.v(KEYCHAIN_MODULE, "warming up takes: " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime) + " ms");
        } catch (Throwable th) {
            Log.e(KEYCHAIN_MODULE, "warming up failed!", th);
        }
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put(SecurityLevel.ANY.jsName(), SecurityLevel.ANY.name());
        hashMap.put(SecurityLevel.SECURE_SOFTWARE.jsName(), SecurityLevel.SECURE_SOFTWARE.name());
        hashMap.put(SecurityLevel.SECURE_HARDWARE.jsName(), SecurityLevel.SECURE_HARDWARE.name());
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public void setGenericPassword(String str, String str2, String str3, ReadableMap readableMap, Promise promise) {
        try {
            throwIfEmptyLoginPassword(str2, str3);
            SecurityLevel securityLevelOrDefault = getSecurityLevelOrDefault(readableMap);
            CipherStorage selectedStorage = getSelectedStorage(readableMap);
            throwIfInsufficientLevel(selectedStorage, securityLevelOrDefault);
            this.prefsStorage.storeEncryptedEntry(str, selectedStorage.encrypt(str, str2, str3, securityLevelOrDefault));
            WritableMap createMap = Arguments.createMap();
            createMap.putString("service", str);
            createMap.putString(Maps.STORAGE, selectedStorage.getCipherStorageName());
            promise.resolve(createMap);
        } catch (EmptyParameterException e) {
            Log.e(KEYCHAIN_MODULE, e.getMessage(), e);
            promise.reject(Errors.E_EMPTY_PARAMETERS, (Throwable) e);
        } catch (CryptoFailedException e2) {
            Log.e(KEYCHAIN_MODULE, e2.getMessage(), e2);
            promise.reject(Errors.E_CRYPTO_FAILED, (Throwable) e2);
        } catch (Throwable th) {
            Log.e(KEYCHAIN_MODULE, th.getMessage(), th);
            promise.reject("E_UNKNOWN_ERROR", th);
        }
    }

    @ReactMethod
    public void setGenericPasswordForOptions(ReadableMap readableMap, String str, String str2, Promise promise) {
        setGenericPassword(getServiceOrDefault(readableMap), str, str2, readableMap, promise);
    }

    private CipherStorage getSelectedStorage(ReadableMap readableMap) throws CryptoFailedException {
        boolean useBiometry = getUseBiometry(getAccessControlOrDefault(readableMap));
        String specificStorageOrDefault = getSpecificStorageOrDefault(readableMap);
        CipherStorage cipherStorageByName = specificStorageOrDefault != null ? getCipherStorageByName(specificStorageOrDefault) : null;
        return cipherStorageByName == null ? getCipherStorageForCurrentAPILevel(useBiometry) : cipherStorageByName;
    }

    /* access modifiers changed from: protected */
    public void getGenericPassword(String str, ReadableMap readableMap, Promise promise) {
        CipherStorage cipherStorage;
        try {
            PrefsStorage.ResultSet encryptedEntry = this.prefsStorage.getEncryptedEntry(str);
            if (encryptedEntry == null) {
                Log.e(KEYCHAIN_MODULE, "No entry found for service: " + str);
                promise.resolve(false);
                return;
            }
            String str2 = encryptedEntry.cipherStorageName;
            String securityRulesOrDefault = getSecurityRulesOrDefault(readableMap);
            BiometricPrompt.PromptInfo promptInfo = getPromptInfo(readableMap);
            if (!securityRulesOrDefault.equals(Rules.AUTOMATIC_UPGRADE) || !str2.equals(KnownCiphers.FB)) {
                cipherStorage = getCipherStorageByName(str2);
            } else {
                cipherStorage = getCipherStorageForCurrentAPILevel(getUseBiometry(getAccessControlOrDefault(readableMap)));
            }
            CipherStorage.DecryptionResult decryptCredentials = decryptCredentials(str, cipherStorage, encryptedEntry, securityRulesOrDefault, promptInfo);
            WritableMap createMap = Arguments.createMap();
            createMap.putString("service", str);
            createMap.putString("username", (String) decryptCredentials.username);
            createMap.putString("password", (String) decryptCredentials.password);
            createMap.putString(Maps.STORAGE, cipherStorage.getCipherStorageName());
            promise.resolve(createMap);
        } catch (KeyStoreAccessException e) {
            Log.e(KEYCHAIN_MODULE, e.getMessage());
            promise.reject(Errors.E_KEYSTORE_ACCESS_ERROR, (Throwable) e);
        } catch (CryptoFailedException e2) {
            Log.e(KEYCHAIN_MODULE, e2.getMessage());
            promise.reject(Errors.E_CRYPTO_FAILED, (Throwable) e2);
        } catch (Throwable th) {
            Log.e(KEYCHAIN_MODULE, th.getMessage(), th);
            promise.reject("E_UNKNOWN_ERROR", th);
        }
    }

    @ReactMethod
    public void getAllGenericPasswordServices(Promise promise) {
        try {
            promise.resolve(Arguments.makeNativeArray((Object) doGetAllGenericPasswordServices().toArray()));
        } catch (KeyStoreAccessException e) {
            promise.reject(Errors.E_KEYSTORE_ACCESS_ERROR, (Throwable) e);
        }
    }

    private Collection<String> doGetAllGenericPasswordServices() throws KeyStoreAccessException {
        Set<String> usedCipherNames = this.prefsStorage.getUsedCipherNames();
        ArrayList<CipherStorage> arrayList = new ArrayList<>(usedCipherNames.size());
        for (String cipherStorageByName : usedCipherNames) {
            arrayList.add(getCipherStorageByName(cipherStorageByName));
        }
        HashSet hashSet = new HashSet();
        for (CipherStorage allKeys : arrayList) {
            for (String next : allKeys.getAllKeys()) {
                if (!next.equals(WARMING_UP_ALIAS)) {
                    hashSet.add(next);
                }
            }
        }
        return hashSet;
    }

    @ReactMethod
    public void getGenericPasswordForOptions(ReadableMap readableMap, Promise promise) {
        getGenericPassword(getServiceOrDefault(readableMap), readableMap, promise);
    }

    /* access modifiers changed from: protected */
    public void resetGenericPassword(String str, Promise promise) {
        CipherStorage cipherStorageByName;
        try {
            PrefsStorage.ResultSet encryptedEntry = this.prefsStorage.getEncryptedEntry(str);
            if (!(encryptedEntry == null || (cipherStorageByName = getCipherStorageByName(encryptedEntry.cipherStorageName)) == null)) {
                cipherStorageByName.removeKey(str);
            }
            this.prefsStorage.removeEntry(str);
            promise.resolve(true);
        } catch (KeyStoreAccessException e) {
            Log.e(KEYCHAIN_MODULE, e.getMessage());
            promise.reject(Errors.E_KEYSTORE_ACCESS_ERROR, (Throwable) e);
        } catch (Throwable th) {
            Log.e(KEYCHAIN_MODULE, th.getMessage(), th);
            promise.reject("E_UNKNOWN_ERROR", th);
        }
    }

    @ReactMethod
    public void resetGenericPasswordForOptions(ReadableMap readableMap, Promise promise) {
        resetGenericPassword(getServiceOrDefault(readableMap), promise);
    }

    @ReactMethod
    public void hasInternetCredentialsForServer(String str, Promise promise) {
        String aliasOrDefault = getAliasOrDefault(str);
        PrefsStorage.ResultSet encryptedEntry = this.prefsStorage.getEncryptedEntry(aliasOrDefault);
        if (encryptedEntry == null) {
            Log.e(KEYCHAIN_MODULE, "No entry found for service: " + aliasOrDefault);
            promise.resolve(false);
            return;
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putString("service", aliasOrDefault);
        createMap.putString(Maps.STORAGE, encryptedEntry.cipherStorageName);
        promise.resolve(createMap);
    }

    @ReactMethod
    public void setInternetCredentialsForServer(String str, String str2, String str3, ReadableMap readableMap, Promise promise) {
        setGenericPassword(str, str2, str3, readableMap, promise);
    }

    @ReactMethod
    public void getInternetCredentialsForServer(String str, ReadableMap readableMap, Promise promise) {
        getGenericPassword(str, readableMap, promise);
    }

    @ReactMethod
    public void resetInternetCredentialsForServer(String str, Promise promise) {
        resetGenericPassword(str, promise);
    }

    @ReactMethod
    public void getSupportedBiometryType(Promise promise) {
        try {
            String str = null;
            if (DeviceAvailability.isStrongBiometricAuthAvailable(getReactApplicationContext())) {
                if (isFingerprintAuthAvailable()) {
                    str = FINGERPRINT_SUPPORTED_NAME;
                } else if (isFaceAuthAvailable()) {
                    str = FACE_SUPPORTED_NAME;
                } else if (isIrisAuthAvailable()) {
                    str = IRIS_SUPPORTED_NAME;
                }
            }
            promise.resolve(str);
        } catch (Exception e) {
            Log.e(KEYCHAIN_MODULE, e.getMessage(), e);
            promise.reject(Errors.E_SUPPORTED_BIOMETRY_ERROR, (Throwable) e);
        } catch (Throwable th) {
            Log.e(KEYCHAIN_MODULE, th.getMessage(), th);
            promise.reject("E_UNKNOWN_ERROR", th);
        }
    }

    @ReactMethod
    public void getSecurityLevel(ReadableMap readableMap, Promise promise) {
        promise.resolve(getSecurityLevel(getUseBiometry(getAccessControlOrDefault(readableMap))).name());
    }

    private static String getServiceOrDefault(ReadableMap readableMap) {
        return getAliasOrDefault((readableMap == null || !readableMap.hasKey("service")) ? null : readableMap.getString("service"));
    }

    private static String getSecurityRulesOrDefault(ReadableMap readableMap) {
        return getSecurityRulesOrDefault(readableMap, "none");
    }

    private static String getSecurityRulesOrDefault(ReadableMap readableMap, String str) {
        String string = (readableMap == null || !readableMap.hasKey(Maps.RULES)) ? null : readableMap.getString(Maps.RULES);
        return string == null ? str : string;
    }

    private static String getSpecificStorageOrDefault(ReadableMap readableMap) {
        if (readableMap == null || !readableMap.hasKey(Maps.STORAGE)) {
            return null;
        }
        return readableMap.getString(Maps.STORAGE);
    }

    private static String getAccessControlOrDefault(ReadableMap readableMap) {
        return getAccessControlOrDefault(readableMap, AccessControl.NONE);
    }

    private static String getAccessControlOrDefault(ReadableMap readableMap, String str) {
        String string = (readableMap == null || !readableMap.hasKey(Maps.ACCESS_CONTROL)) ? null : readableMap.getString(Maps.ACCESS_CONTROL);
        return string == null ? str : string;
    }

    private static SecurityLevel getSecurityLevelOrDefault(ReadableMap readableMap) {
        return getSecurityLevelOrDefault(readableMap, SecurityLevel.ANY.name());
    }

    private static SecurityLevel getSecurityLevelOrDefault(ReadableMap readableMap, String str) {
        String string = (readableMap == null || !readableMap.hasKey(Maps.SECURITY_LEVEL)) ? null : readableMap.getString(Maps.SECURITY_LEVEL);
        if (string != null) {
            str = string;
        }
        return SecurityLevel.valueOf(str);
    }

    public static boolean getUseBiometry(String str) {
        return AccessControl.BIOMETRY_ANY.equals(str) || AccessControl.BIOMETRY_CURRENT_SET.equals(str) || AccessControl.BIOMETRY_ANY_OR_DEVICE_PASSCODE.equals(str) || AccessControl.BIOMETRY_CURRENT_SET_OR_DEVICE_PASSCODE.equals(str);
    }

    private void addCipherStorageToMap(CipherStorage cipherStorage) {
        this.cipherStorageMap.put(cipherStorage.getCipherStorageName(), cipherStorage);
    }

    private static BiometricPrompt.PromptInfo getPromptInfo(ReadableMap readableMap) {
        ReadableMap map = (readableMap == null || !readableMap.hasKey(Maps.AUTH_PROMPT)) ? null : readableMap.getMap(Maps.AUTH_PROMPT);
        BiometricPrompt.PromptInfo.Builder builder = new BiometricPrompt.PromptInfo.Builder();
        if (map != null && map.hasKey("title")) {
            builder.setTitle(map.getString("title"));
        }
        if (map != null && map.hasKey(AuthPromptOptions.SUBTITLE)) {
            builder.setSubtitle(map.getString(AuthPromptOptions.SUBTITLE));
        }
        if (map != null && map.hasKey("description")) {
            builder.setDescription(map.getString("description"));
        }
        if (map != null && map.hasKey(AuthPromptOptions.CANCEL)) {
            builder.setNegativeButtonText(map.getString(AuthPromptOptions.CANCEL));
        }
        builder.setAllowedAuthenticators(15);
        builder.setConfirmationRequired(false);
        return builder.build();
    }

    private CipherStorage.DecryptionResult decryptCredentials(String str, CipherStorage cipherStorage, PrefsStorage.ResultSet resultSet, String str2, BiometricPrompt.PromptInfo promptInfo) throws CryptoFailedException, KeyStoreAccessException {
        String str3 = resultSet.cipherStorageName;
        if (str3.equals(cipherStorage.getCipherStorageName())) {
            return decryptToResult(str, cipherStorage, resultSet, promptInfo);
        }
        CipherStorage cipherStorageByName = getCipherStorageByName(str3);
        if (cipherStorageByName != null) {
            CipherStorage.DecryptionResult decryptToResult = decryptToResult(str, cipherStorageByName, resultSet, promptInfo);
            if (Rules.AUTOMATIC_UPGRADE.equals(str2)) {
                try {
                    migrateCipherStorage(str, cipherStorage, cipherStorageByName, decryptToResult);
                } catch (CryptoFailedException unused) {
                    Log.w(KEYCHAIN_MODULE, "Migrating to a less safe storage is not allowed. Keeping the old one");
                }
            }
            return decryptToResult;
        }
        throw new KeyStoreAccessException("Wrong cipher storage name '" + str3 + "' or cipher not available");
    }

    private CipherStorage.DecryptionResult decryptToResult(String str, CipherStorage cipherStorage, PrefsStorage.ResultSet resultSet, BiometricPrompt.PromptInfo promptInfo) throws CryptoFailedException {
        DecryptionResultHandler interactiveHandler = getInteractiveHandler(cipherStorage, promptInfo);
        cipherStorage.decrypt(interactiveHandler, str, (byte[]) resultSet.username, (byte[]) resultSet.password, SecurityLevel.ANY);
        CryptoFailedException.reThrowOnError(interactiveHandler.getError());
        if (interactiveHandler.getResult() != null) {
            return interactiveHandler.getResult();
        }
        throw new CryptoFailedException("No decryption results and no error. Something deeply wrong!");
    }

    /* access modifiers changed from: protected */
    public DecryptionResultHandler getInteractiveHandler(CipherStorage cipherStorage, BiometricPrompt.PromptInfo promptInfo) {
        return DecryptionResultHandlerProvider.getHandler(getReactApplicationContext(), cipherStorage, promptInfo);
    }

    /* access modifiers changed from: package-private */
    public void migrateCipherStorage(String str, CipherStorage cipherStorage, CipherStorage cipherStorage2, CipherStorage.DecryptionResult decryptionResult) throws KeyStoreAccessException, CryptoFailedException {
        this.prefsStorage.storeEncryptedEntry(str, cipherStorage.encrypt(str, (String) decryptionResult.username, (String) decryptionResult.password, decryptionResult.getSecurityLevel()));
        cipherStorage2.removeKey(str);
    }

    /* access modifiers changed from: package-private */
    public CipherStorage getCipherStorageForCurrentAPILevel() throws CryptoFailedException {
        return getCipherStorageForCurrentAPILevel(true);
    }

    /* access modifiers changed from: package-private */
    public CipherStorage getCipherStorageForCurrentAPILevel(boolean z) throws CryptoFailedException {
        int i = Build.VERSION.SDK_INT;
        boolean z2 = z && (isFingerprintAuthAvailable() || isFaceAuthAvailable() || isIrisAuthAvailable());
        CipherStorage cipherStorage = null;
        for (CipherStorage next : this.cipherStorageMap.values()) {
            Log.d(KEYCHAIN_MODULE, "Probe cipher storage: " + next.getClass().getSimpleName());
            int minSupportedApiLevel = next.getMinSupportedApiLevel();
            int capabilityLevel = next.getCapabilityLevel();
            if ((minSupportedApiLevel <= i) && ((cipherStorage == null || capabilityLevel >= cipherStorage.getCapabilityLevel()) && (!next.isBiometrySupported() || z2))) {
                cipherStorage = next;
            }
        }
        if (cipherStorage != null) {
            Log.d(KEYCHAIN_MODULE, "Selected storage: " + cipherStorage.getClass().getSimpleName());
            return cipherStorage;
        }
        throw new CryptoFailedException("Unsupported Android SDK " + Build.VERSION.SDK_INT);
    }

    public static void throwIfEmptyLoginPassword(String str, String str2) throws EmptyParameterException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new EmptyParameterException("you passed empty or null username/password");
        }
    }

    public static void throwIfInsufficientLevel(CipherStorage cipherStorage, SecurityLevel securityLevel) throws CryptoFailedException {
        if (!cipherStorage.securityLevel().satisfiesSafetyThreshold(securityLevel)) {
            throw new CryptoFailedException(String.format("Cipher Storage is too weak. Required security level is: %s, but only %s is provided", new Object[]{securityLevel.name(), cipherStorage.securityLevel().name()}));
        }
    }

    /* access modifiers changed from: package-private */
    public CipherStorage getCipherStorageByName(String str) {
        return this.cipherStorageMap.get(str);
    }

    /* access modifiers changed from: package-private */
    public boolean isFingerprintAuthAvailable() {
        return DeviceAvailability.isStrongBiometricAuthAvailable(getReactApplicationContext()) && DeviceAvailability.isFingerprintAuthAvailable(getReactApplicationContext());
    }

    /* access modifiers changed from: package-private */
    public boolean isFaceAuthAvailable() {
        return DeviceAvailability.isStrongBiometricAuthAvailable(getReactApplicationContext()) && DeviceAvailability.isFaceAuthAvailable(getReactApplicationContext());
    }

    /* access modifiers changed from: package-private */
    public boolean isIrisAuthAvailable() {
        return DeviceAvailability.isStrongBiometricAuthAvailable(getReactApplicationContext()) && DeviceAvailability.isIrisAuthAvailable(getReactApplicationContext());
    }

    /* access modifiers changed from: package-private */
    public boolean isSecureHardwareAvailable() {
        try {
            return getCipherStorageForCurrentAPILevel().supportsSecureHardware();
        } catch (CryptoFailedException unused) {
            return false;
        }
    }

    private SecurityLevel getSecurityLevel(boolean z) {
        try {
            CipherStorage cipherStorageForCurrentAPILevel = getCipherStorageForCurrentAPILevel(z);
            if (!cipherStorageForCurrentAPILevel.securityLevel().satisfiesSafetyThreshold(SecurityLevel.SECURE_SOFTWARE)) {
                return SecurityLevel.ANY;
            }
            if (cipherStorageForCurrentAPILevel.supportsSecureHardware()) {
                return SecurityLevel.SECURE_HARDWARE;
            }
            return SecurityLevel.SECURE_SOFTWARE;
        } catch (CryptoFailedException e) {
            Log.w(KEYCHAIN_MODULE, "Security Level Exception: " + e.getMessage(), e);
            return SecurityLevel.ANY;
        }
    }
}
