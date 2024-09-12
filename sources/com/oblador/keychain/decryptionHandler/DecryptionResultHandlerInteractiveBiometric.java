package com.oblador.keychain.decryptionHandler;

import android.os.Looper;
import android.util.Log;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.bridge.AssertionException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.oblador.keychain.DeviceAvailability;
import com.oblador.keychain.cipherStorage.CipherStorage;
import com.oblador.keychain.cipherStorage.CipherStorageBase;
import com.oblador.keychain.exceptions.CryptoFailedException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DecryptionResultHandlerInteractiveBiometric extends BiometricPrompt.AuthenticationCallback implements DecryptionResultHandler {
    protected static final String LOG_TAG = "DecryptionResultHandlerInteractiveBiometric";
    protected CipherStorage.DecryptionContext context;
    protected Throwable error;
    protected final Executor executor = Executors.newSingleThreadExecutor();
    protected BiometricPrompt.PromptInfo promptInfo;
    protected final ReactApplicationContext reactContext;
    protected CipherStorage.DecryptionResult result;
    protected final CipherStorageBase storage;

    public DecryptionResultHandlerInteractiveBiometric(ReactApplicationContext reactApplicationContext, CipherStorage cipherStorage, BiometricPrompt.PromptInfo promptInfo2) {
        this.reactContext = reactApplicationContext;
        this.storage = (CipherStorageBase) cipherStorage;
        this.promptInfo = promptInfo2;
    }

    public void askAccessPermissions(CipherStorage.DecryptionContext decryptionContext) {
        this.context = decryptionContext;
        if (!DeviceAvailability.isPermissionsGranted(this.reactContext)) {
            onDecrypt((CipherStorage.DecryptionResult) null, new CryptoFailedException("Could not start fingerprint Authentication. No permissions granted."));
        } else {
            startAuthentication();
        }
    }

    public void onDecrypt(CipherStorage.DecryptionResult decryptionResult, Throwable th) {
        this.result = decryptionResult;
        this.error = th;
        synchronized (this) {
            notifyAll();
        }
    }

    public CipherStorage.DecryptionResult getResult() {
        return this.result;
    }

    public Throwable getError() {
        return this.error;
    }

    public void onAuthenticationError(int i, CharSequence charSequence) {
        onDecrypt((CipherStorage.DecryptionResult) null, new CryptoFailedException("code: " + i + ", msg: " + charSequence));
    }

    public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
        try {
            if (this.context != null) {
                onDecrypt(new CipherStorage.DecryptionResult(this.storage.decryptBytes(this.context.key, (byte[]) this.context.username), this.storage.decryptBytes(this.context.key, (byte[]) this.context.password)), (Throwable) null);
                return;
            }
            throw new NullPointerException("Decrypt context is not assigned yet.");
        } catch (Throwable th) {
            onDecrypt((CipherStorage.DecryptionResult) null, th);
        }
    }

    public void startAuthentication() {
        FragmentActivity currentActivity = getCurrentActivity();
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            currentActivity.runOnUiThread(new DecryptionResultHandlerInteractiveBiometric$$ExternalSyntheticLambda0(this));
            waitResult();
            return;
        }
        authenticateWithPrompt(currentActivity);
    }

    /* access modifiers changed from: protected */
    public FragmentActivity getCurrentActivity() {
        FragmentActivity fragmentActivity = (FragmentActivity) this.reactContext.getCurrentActivity();
        if (fragmentActivity != null) {
            return fragmentActivity;
        }
        throw new NullPointerException("Not assigned current activity");
    }

    /* access modifiers changed from: protected */
    public BiometricPrompt authenticateWithPrompt(FragmentActivity fragmentActivity) {
        BiometricPrompt biometricPrompt = new BiometricPrompt(fragmentActivity, this.executor, (BiometricPrompt.AuthenticationCallback) this);
        biometricPrompt.authenticate(this.promptInfo);
        return biometricPrompt;
    }

    public void waitResult() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            Log.i(LOG_TAG, "blocking thread. waiting for done UI operation.");
            try {
                synchronized (this) {
                    wait();
                }
            } catch (InterruptedException unused) {
            }
            Log.i(LOG_TAG, "unblocking thread.");
            return;
        }
        throw new AssertionException("method should not be executed from MAIN thread");
    }
}
