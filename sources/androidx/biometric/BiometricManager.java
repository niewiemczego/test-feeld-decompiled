package androidx.biometric;

import android.content.Context;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.util.Log;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BiometricManager {
    public static final int BIOMETRIC_ERROR_HW_UNAVAILABLE = 1;
    public static final int BIOMETRIC_ERROR_NONE_ENROLLED = 11;
    public static final int BIOMETRIC_ERROR_NO_HARDWARE = 12;
    public static final int BIOMETRIC_ERROR_SECURITY_UPDATE_REQUIRED = 15;
    public static final int BIOMETRIC_ERROR_UNSUPPORTED = -2;
    public static final int BIOMETRIC_STATUS_UNKNOWN = -1;
    public static final int BIOMETRIC_SUCCESS = 0;
    private static final String TAG = "BiometricManager";
    private final android.hardware.biometrics.BiometricManager mBiometricManager;
    private final FingerprintManagerCompat mFingerprintManager;
    private final Injector mInjector;

    public interface Authenticators {
        public static final int BIOMETRIC_STRONG = 15;
        public static final int BIOMETRIC_WEAK = 255;
        public static final int DEVICE_CREDENTIAL = 32768;
    }

    interface Injector {
        android.hardware.biometrics.BiometricManager getBiometricManager();

        FingerprintManagerCompat getFingerprintManager();

        boolean isDeviceSecurable();

        boolean isDeviceSecuredWithCredential();

        boolean isFingerprintHardwarePresent();

        boolean isStrongBiometricGuaranteed();
    }

    private static class DefaultInjector implements Injector {
        private final Context mContext;

        DefaultInjector(Context context) {
            this.mContext = context.getApplicationContext();
        }

        public android.hardware.biometrics.BiometricManager getBiometricManager() {
            return Api29Impl.create(this.mContext);
        }

        public FingerprintManagerCompat getFingerprintManager() {
            return FingerprintManagerCompat.from(this.mContext);
        }

        public boolean isDeviceSecurable() {
            return KeyguardUtils.getKeyguardManager(this.mContext) != null;
        }

        public boolean isDeviceSecuredWithCredential() {
            return KeyguardUtils.isDeviceSecuredWithCredential(this.mContext);
        }

        public boolean isFingerprintHardwarePresent() {
            return PackageUtils.hasSystemFeatureFingerprint(this.mContext);
        }

        public boolean isStrongBiometricGuaranteed() {
            return DeviceUtils.canAssumeStrongBiometrics(this.mContext, Build.MODEL);
        }
    }

    public static BiometricManager from(Context context) {
        return new BiometricManager(new DefaultInjector(context));
    }

    BiometricManager(Injector injector) {
        this.mInjector = injector;
        FingerprintManagerCompat fingerprintManagerCompat = null;
        this.mBiometricManager = Build.VERSION.SDK_INT >= 29 ? injector.getBiometricManager() : null;
        this.mFingerprintManager = Build.VERSION.SDK_INT <= 29 ? injector.getFingerprintManager() : fingerprintManagerCompat;
    }

    @Deprecated
    public int canAuthenticate() {
        return canAuthenticate(255);
    }

    public int canAuthenticate(int i) {
        if (Build.VERSION.SDK_INT < 30) {
            return canAuthenticateCompat(i);
        }
        android.hardware.biometrics.BiometricManager biometricManager = this.mBiometricManager;
        if (biometricManager != null) {
            return Api30Impl.canAuthenticate(biometricManager, i);
        }
        Log.e(TAG, "Failure in canAuthenticate(). BiometricManager was null.");
        return 1;
    }

    private int canAuthenticateCompat(int i) {
        if (!AuthenticatorUtils.isSupportedCombination(i)) {
            return -2;
        }
        if (i == 0 || !this.mInjector.isDeviceSecurable()) {
            return 12;
        }
        if (AuthenticatorUtils.isDeviceCredentialAllowed(i)) {
            return this.mInjector.isDeviceSecuredWithCredential() ? 0 : 11;
        }
        if (Build.VERSION.SDK_INT == 29) {
            if (AuthenticatorUtils.isWeakBiometricAllowed(i)) {
                return canAuthenticateWithWeakBiometricOnApi29();
            }
            return canAuthenticateWithStrongBiometricOnApi29();
        } else if (Build.VERSION.SDK_INT != 28) {
            return canAuthenticateWithFingerprint();
        } else {
            if (this.mInjector.isFingerprintHardwarePresent()) {
                return canAuthenticateWithFingerprintOrUnknownBiometric();
            }
            return 12;
        }
    }

    private int canAuthenticateWithStrongBiometricOnApi29() {
        BiometricPrompt.CryptoObject wrapForBiometricPrompt;
        Method canAuthenticateWithCryptoMethod = Api29Impl.getCanAuthenticateWithCryptoMethod();
        if (!(canAuthenticateWithCryptoMethod == null || (wrapForBiometricPrompt = CryptoObjectUtils.wrapForBiometricPrompt(CryptoObjectUtils.createFakeCryptoObject())) == null)) {
            try {
                Object invoke = canAuthenticateWithCryptoMethod.invoke(this.mBiometricManager, new Object[]{wrapForBiometricPrompt});
                if (invoke instanceof Integer) {
                    return ((Integer) invoke).intValue();
                }
                Log.w(TAG, "Invalid return type for canAuthenticate(CryptoObject).");
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                Log.w(TAG, "Failed to invoke canAuthenticate(CryptoObject).", e);
            }
        }
        int canAuthenticateWithWeakBiometricOnApi29 = canAuthenticateWithWeakBiometricOnApi29();
        return (this.mInjector.isStrongBiometricGuaranteed() || canAuthenticateWithWeakBiometricOnApi29 != 0) ? canAuthenticateWithWeakBiometricOnApi29 : canAuthenticateWithFingerprintOrUnknownBiometric();
    }

    private int canAuthenticateWithWeakBiometricOnApi29() {
        android.hardware.biometrics.BiometricManager biometricManager = this.mBiometricManager;
        if (biometricManager != null) {
            return Api29Impl.canAuthenticate(biometricManager);
        }
        Log.e(TAG, "Failure in canAuthenticate(). BiometricManager was null.");
        return 1;
    }

    private int canAuthenticateWithFingerprintOrUnknownBiometric() {
        if (!this.mInjector.isDeviceSecuredWithCredential()) {
            return canAuthenticateWithFingerprint();
        }
        return canAuthenticateWithFingerprint() == 0 ? 0 : -1;
    }

    private int canAuthenticateWithFingerprint() {
        FingerprintManagerCompat fingerprintManagerCompat = this.mFingerprintManager;
        if (fingerprintManagerCompat == null) {
            Log.e(TAG, "Failure in canAuthenticate(). FingerprintManager was null.");
            return 1;
        } else if (!fingerprintManagerCompat.isHardwareDetected()) {
            return 12;
        } else {
            return !this.mFingerprintManager.hasEnrolledFingerprints() ? 11 : 0;
        }
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static int canAuthenticate(android.hardware.biometrics.BiometricManager biometricManager, int i) {
            return biometricManager.canAuthenticate(i);
        }
    }

    private static class Api29Impl {
        private Api29Impl() {
        }

        static android.hardware.biometrics.BiometricManager create(Context context) {
            return (android.hardware.biometrics.BiometricManager) context.getSystemService(android.hardware.biometrics.BiometricManager.class);
        }

        static int canAuthenticate(android.hardware.biometrics.BiometricManager biometricManager) {
            return biometricManager.canAuthenticate();
        }

        static Method getCanAuthenticateWithCryptoMethod() {
            try {
                return android.hardware.biometrics.BiometricManager.class.getMethod("canAuthenticate", new Class[]{BiometricPrompt.CryptoObject.class});
            } catch (NoSuchMethodException unused) {
                return null;
            }
        }
    }
}
