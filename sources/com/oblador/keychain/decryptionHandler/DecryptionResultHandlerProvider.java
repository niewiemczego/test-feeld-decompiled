package com.oblador.keychain.decryptionHandler;

import android.os.Build;
import androidx.biometric.BiometricPrompt;
import com.facebook.react.bridge.ReactApplicationContext;
import com.oblador.keychain.cipherStorage.CipherStorage;
import java.util.Arrays;

public class DecryptionResultHandlerProvider {
    private static final String ONE_PLUS_BRAND = "oneplus";
    private static final String[] ONE_PLUS_MODELS_WITHOUT_BIOMETRIC_BUG = {"A0001", "ONE A2001", "ONE A2003", "ONE A2005", "ONE E1001", "ONE E1003", "ONE E1005", "ONEPLUS A3000", "ONEPLUS SM-A3000", "ONEPLUS A3003", "ONEPLUS A3010", "ONEPLUS A5000", "ONEPLUS A5010", "ONEPLUS A6000", "ONEPLUS A6003"};

    private static boolean hasOnePlusBiometricBug() {
        return Build.BRAND.toLowerCase().equals(ONE_PLUS_BRAND) && !Arrays.asList(ONE_PLUS_MODELS_WITHOUT_BIOMETRIC_BUG).contains(Build.MODEL);
    }

    public static DecryptionResultHandler getHandler(ReactApplicationContext reactApplicationContext, CipherStorage cipherStorage, BiometricPrompt.PromptInfo promptInfo) {
        if (!cipherStorage.isBiometrySupported()) {
            return new DecryptionResultHandlerNonInteractive();
        }
        if (hasOnePlusBiometricBug()) {
            return new DecryptionResultHandlerInteractiveBiometricManualRetry(reactApplicationContext, cipherStorage, promptInfo);
        }
        return new DecryptionResultHandlerInteractiveBiometric(reactApplicationContext, cipherStorage, promptInfo);
    }
}
