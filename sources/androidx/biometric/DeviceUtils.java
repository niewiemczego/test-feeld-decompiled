package androidx.biometric;

import android.content.Context;
import android.os.Build;

class DeviceUtils {
    private DeviceUtils() {
    }

    static boolean shouldUseFingerprintForCrypto(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT != 28) {
            return false;
        }
        if (isVendorInList(context, str, R.array.crypto_fingerprint_fallback_vendors) || isModelInPrefixList(context, str2, R.array.crypto_fingerprint_fallback_prefixes)) {
            return true;
        }
        return false;
    }

    static boolean shouldHideFingerprintDialog(Context context, String str) {
        if (Build.VERSION.SDK_INT != 28) {
            return false;
        }
        return isModelInPrefixList(context, str, R.array.hide_fingerprint_instantly_prefixes);
    }

    static boolean shouldDelayShowingPrompt(Context context, String str) {
        if (Build.VERSION.SDK_INT != 29) {
            return false;
        }
        return isModelInList(context, str, R.array.delay_showing_prompt_models);
    }

    static boolean canAssumeStrongBiometrics(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 30) {
            return false;
        }
        return isModelInList(context, str, R.array.assume_strong_biometrics_models);
    }

    private static boolean isVendorInList(Context context, String str, int i) {
        if (str == null) {
            return false;
        }
        for (String equalsIgnoreCase : context.getResources().getStringArray(i)) {
            if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isModelInPrefixList(Context context, String str, int i) {
        if (str == null) {
            return false;
        }
        for (String startsWith : context.getResources().getStringArray(i)) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isModelInList(Context context, String str, int i) {
        if (str == null) {
            return false;
        }
        for (String equals : context.getResources().getStringArray(i)) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }
}
