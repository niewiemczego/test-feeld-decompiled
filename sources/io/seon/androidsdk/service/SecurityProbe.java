package io.seon.androidsdk.service;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;

public class SecurityProbe extends AbstractSeonProbe {
    static final String[] KEYS = {"biometric_status", "is_keyguard_secure"};
    private Context mContext;

    enum BiometricSensorStatus {
        HARDWARE_UNAVAILABLE,
        NO_HARDWARE,
        AVAILABLE,
        NOT_ENROLLED,
        REQUIRES_SECURITY_UPDATE
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
        if (r1.hasEnrolledFingerprints() != false) goto L_0x004c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getBiometricStatus() {
        /*
            r3 = this;
            io.seon.androidsdk.service.SecurityProbe$BiometricSensorStatus r0 = io.seon.androidsdk.service.SecurityProbe.BiometricSensorStatus.HARDWARE_UNAVAILABLE     // Catch:{ Exception -> 0x0053 }
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0053 }
            r2 = 30
            if (r1 < r2) goto L_0x0030
            android.content.Context r1 = r3.mContext     // Catch:{ Exception -> 0x0053 }
            java.lang.String r2 = "biometric"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch:{ Exception -> 0x0053 }
            android.hardware.biometrics.BiometricManager r1 = (android.hardware.biometrics.BiometricManager) r1     // Catch:{ Exception -> 0x0053 }
            r2 = 255(0xff, float:3.57E-43)
            int r1 = r1.canAuthenticate(r2)     // Catch:{ Exception -> 0x0053 }
            if (r1 == 0) goto L_0x004c
            r2 = 15
            if (r1 == r2) goto L_0x002d
            r2 = 11
            if (r1 == r2) goto L_0x002a
            r2 = 12
            if (r1 == r2) goto L_0x0027
            goto L_0x004e
        L_0x0027:
            io.seon.androidsdk.service.SecurityProbe$BiometricSensorStatus r0 = io.seon.androidsdk.service.SecurityProbe.BiometricSensorStatus.NO_HARDWARE     // Catch:{ Exception -> 0x0053 }
            goto L_0x004e
        L_0x002a:
            io.seon.androidsdk.service.SecurityProbe$BiometricSensorStatus r0 = io.seon.androidsdk.service.SecurityProbe.BiometricSensorStatus.NOT_ENROLLED     // Catch:{ Exception -> 0x0053 }
            goto L_0x004e
        L_0x002d:
            io.seon.androidsdk.service.SecurityProbe$BiometricSensorStatus r0 = io.seon.androidsdk.service.SecurityProbe.BiometricSensorStatus.REQUIRES_SECURITY_UPDATE     // Catch:{ Exception -> 0x0053 }
            goto L_0x004e
        L_0x0030:
            r2 = 23
            if (r1 < r2) goto L_0x004e
            android.content.Context r1 = r3.mContext     // Catch:{ Exception -> 0x0053 }
            java.lang.String r2 = "fingerprint"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch:{ Exception -> 0x0053 }
            android.hardware.fingerprint.FingerprintManager r1 = (android.hardware.fingerprint.FingerprintManager) r1     // Catch:{ Exception -> 0x0053 }
            boolean r2 = r1.isHardwareDetected()     // Catch:{ Exception -> 0x0053 }
            if (r2 == 0) goto L_0x004e
            io.seon.androidsdk.service.SecurityProbe$BiometricSensorStatus r0 = io.seon.androidsdk.service.SecurityProbe.BiometricSensorStatus.NOT_ENROLLED     // Catch:{ Exception -> 0x0053 }
            boolean r1 = r1.hasEnrolledFingerprints()     // Catch:{ Exception -> 0x0053 }
            if (r1 == 0) goto L_0x004e
        L_0x004c:
            io.seon.androidsdk.service.SecurityProbe$BiometricSensorStatus r0 = io.seon.androidsdk.service.SecurityProbe.BiometricSensorStatus.AVAILABLE     // Catch:{ Exception -> 0x0053 }
        L_0x004e:
            java.lang.String r0 = r0.name()     // Catch:{ Exception -> 0x0053 }
            return r0
        L_0x0053:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.seon.androidsdk.service.SecurityProbe.getBiometricStatus():java.lang.String");
    }

    /* access modifiers changed from: private */
    public Boolean isKeyGuardSecure() {
        return Build.VERSION.SDK_INT >= 16 ? Boolean.valueOf(((KeyguardManager) this.mContext.getSystemService("keyguard")).isKeyguardSecure()) : Boolean.FALSE;
    }

    public void bootstrap(Context context) {
        this.mContext = context;
    }

    public Map<String, Object> getExperimentalFields() {
        return null;
    }

    public Map<String, Object> scan() {
        HashMap hashMap = new HashMap();
        hashMap.put("biometric_status", safeGet(new SecurityProbe$$ExternalSyntheticLambda0(this)));
        hashMap.put("is_keyguard_secure", safeGet(new SecurityProbe$$ExternalSyntheticLambda1(this)));
        return hashMap;
    }
}
