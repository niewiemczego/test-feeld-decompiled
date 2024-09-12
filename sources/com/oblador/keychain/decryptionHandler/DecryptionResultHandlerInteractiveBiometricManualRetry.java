package com.oblador.keychain.decryptionHandler;

import android.os.Looper;
import android.util.Log;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.bridge.ReactApplicationContext;
import com.oblador.keychain.cipherStorage.CipherStorage;

public class DecryptionResultHandlerInteractiveBiometricManualRetry extends DecryptionResultHandlerInteractiveBiometric implements DecryptionResultHandler {
    private Boolean didFailBiometric = false;
    private BiometricPrompt presentedPrompt;

    public DecryptionResultHandlerInteractiveBiometricManualRetry(ReactApplicationContext reactApplicationContext, CipherStorage cipherStorage, BiometricPrompt.PromptInfo promptInfo) {
        super(reactApplicationContext, cipherStorage, promptInfo);
    }

    private void cancelPresentedAuthentication() {
        Log.d(LOG_TAG, "Cancelling authentication");
        BiometricPrompt biometricPrompt = this.presentedPrompt;
        if (biometricPrompt != null) {
            try {
                biometricPrompt.cancelAuthentication();
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                this.presentedPrompt = null;
                throw th;
            }
            this.presentedPrompt = null;
        }
    }

    public void onAuthenticationError(int i, CharSequence charSequence) {
        if (this.didFailBiometric.booleanValue()) {
            this.presentedPrompt = null;
            this.didFailBiometric = false;
            retryAuthentication();
            return;
        }
        super.onAuthenticationError(i, charSequence);
    }

    public void onAuthenticationFailed() {
        Log.d(LOG_TAG, "Authentication failed: biometric not recognized.");
        if (this.presentedPrompt != null) {
            this.didFailBiometric = true;
            cancelPresentedAuthentication();
        }
    }

    public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
        this.presentedPrompt = null;
        this.didFailBiometric = false;
        super.onAuthenticationSucceeded(authenticationResult);
    }

    public void startAuthentication() {
        FragmentActivity currentActivity = getCurrentActivity();
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            currentActivity.runOnUiThread(new DecryptionResultHandlerInteractiveBiometricManualRetry$$ExternalSyntheticLambda0(this));
            waitResult();
            return;
        }
        this.presentedPrompt = authenticateWithPrompt(currentActivity);
    }

    /* access modifiers changed from: protected */
    public void retryAuthentication() {
        Log.d(LOG_TAG, "Retrying biometric authentication.");
        FragmentActivity currentActivity = getCurrentActivity();
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException unused) {
            }
            currentActivity.runOnUiThread(new DecryptionResultHandlerInteractiveBiometricManualRetry$$ExternalSyntheticLambda1(this));
            return;
        }
        this.presentedPrompt = authenticateWithPrompt(currentActivity);
    }
}
