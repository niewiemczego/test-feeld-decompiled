package androidx.biometric;

import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import androidx.biometric.BiometricPrompt;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;

class AuthenticationCallbackProvider {
    private BiometricPrompt.AuthenticationCallback mBiometricCallback;
    private FingerprintManagerCompat.AuthenticationCallback mFingerprintCallback;
    final Listener mListener;

    static class Listener {
        /* access modifiers changed from: package-private */
        public void onError(int i, CharSequence charSequence) {
        }

        /* access modifiers changed from: package-private */
        public void onFailure() {
        }

        /* access modifiers changed from: package-private */
        public void onHelp(CharSequence charSequence) {
        }

        /* access modifiers changed from: package-private */
        public void onSuccess(BiometricPrompt.AuthenticationResult authenticationResult) {
        }

        Listener() {
        }
    }

    AuthenticationCallbackProvider(Listener listener) {
        this.mListener = listener;
    }

    /* access modifiers changed from: package-private */
    public BiometricPrompt.AuthenticationCallback getBiometricCallback() {
        if (this.mBiometricCallback == null) {
            this.mBiometricCallback = Api28Impl.createCallback(this.mListener);
        }
        return this.mBiometricCallback;
    }

    /* access modifiers changed from: package-private */
    public FingerprintManagerCompat.AuthenticationCallback getFingerprintCallback() {
        if (this.mFingerprintCallback == null) {
            this.mFingerprintCallback = new FingerprintManagerCompat.AuthenticationCallback() {
                public void onAuthenticationError(int i, CharSequence charSequence) {
                    AuthenticationCallbackProvider.this.mListener.onError(i, charSequence);
                }

                public void onAuthenticationHelp(int i, CharSequence charSequence) {
                    AuthenticationCallbackProvider.this.mListener.onHelp(charSequence);
                }

                public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult authenticationResult) {
                    AuthenticationCallbackProvider.this.mListener.onSuccess(new BiometricPrompt.AuthenticationResult(authenticationResult != null ? CryptoObjectUtils.unwrapFromFingerprintManager(authenticationResult.getCryptoObject()) : null, 2));
                }

                public void onAuthenticationFailed() {
                    AuthenticationCallbackProvider.this.mListener.onFailure();
                }
            };
        }
        return this.mFingerprintCallback;
    }

    private static class Api30Impl {
        private Api30Impl() {
        }

        static int getAuthenticationType(BiometricPrompt.AuthenticationResult authenticationResult) {
            return authenticationResult.getAuthenticationType();
        }
    }

    private static class Api28Impl {
        private Api28Impl() {
        }

        static BiometricPrompt.AuthenticationCallback createCallback(final Listener listener) {
            return new BiometricPrompt.AuthenticationCallback() {
                public void onAuthenticationHelp(int i, CharSequence charSequence) {
                }

                public void onAuthenticationError(int i, CharSequence charSequence) {
                    Listener.this.onError(i, charSequence);
                }

                public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
                    BiometricPrompt.CryptoObject unwrapFromBiometricPrompt = authenticationResult != null ? CryptoObjectUtils.unwrapFromBiometricPrompt(authenticationResult.getCryptoObject()) : null;
                    int i = -1;
                    if (Build.VERSION.SDK_INT >= 30) {
                        if (authenticationResult != null) {
                            i = Api30Impl.getAuthenticationType(authenticationResult);
                        }
                    } else if (Build.VERSION.SDK_INT != 29) {
                        i = 2;
                    }
                    Listener.this.onSuccess(new BiometricPrompt.AuthenticationResult(unwrapFromBiometricPrompt, i));
                }

                public void onAuthenticationFailed() {
                    Listener.this.onFailure();
                }
            };
        }
    }
}
