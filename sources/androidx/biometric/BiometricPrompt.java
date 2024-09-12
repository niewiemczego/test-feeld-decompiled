package androidx.biometric;

import android.os.Build;
import android.security.identity.IdentityCredential;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProvider;
import java.lang.ref.WeakReference;
import java.security.Signature;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public class BiometricPrompt {
    public static final int AUTHENTICATION_RESULT_TYPE_BIOMETRIC = 2;
    public static final int AUTHENTICATION_RESULT_TYPE_DEVICE_CREDENTIAL = 1;
    public static final int AUTHENTICATION_RESULT_TYPE_UNKNOWN = -1;
    private static final String BIOMETRIC_FRAGMENT_TAG = "androidx.biometric.BiometricFragment";
    static final int BIOMETRIC_SUCCESS = 0;
    public static final int ERROR_CANCELED = 5;
    public static final int ERROR_HW_NOT_PRESENT = 12;
    public static final int ERROR_HW_UNAVAILABLE = 1;
    public static final int ERROR_LOCKOUT = 7;
    public static final int ERROR_LOCKOUT_PERMANENT = 9;
    public static final int ERROR_NEGATIVE_BUTTON = 13;
    public static final int ERROR_NO_BIOMETRICS = 11;
    public static final int ERROR_NO_DEVICE_CREDENTIAL = 14;
    public static final int ERROR_NO_SPACE = 4;
    public static final int ERROR_SECURITY_UPDATE_REQUIRED = 15;
    public static final int ERROR_TIMEOUT = 3;
    public static final int ERROR_UNABLE_TO_PROCESS = 2;
    public static final int ERROR_USER_CANCELED = 10;
    public static final int ERROR_VENDOR = 8;
    private static final String TAG = "BiometricPromptCompat";
    private FragmentManager mClientFragmentManager;

    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        }
    }

    public static class CryptoObject {
        private final Cipher mCipher;
        private final IdentityCredential mIdentityCredential;
        private final Mac mMac;
        private final Signature mSignature;

        public CryptoObject(Signature signature) {
            this.mSignature = signature;
            this.mCipher = null;
            this.mMac = null;
            this.mIdentityCredential = null;
        }

        public CryptoObject(Cipher cipher) {
            this.mSignature = null;
            this.mCipher = cipher;
            this.mMac = null;
            this.mIdentityCredential = null;
        }

        public CryptoObject(Mac mac) {
            this.mSignature = null;
            this.mCipher = null;
            this.mMac = mac;
            this.mIdentityCredential = null;
        }

        public CryptoObject(IdentityCredential identityCredential) {
            this.mSignature = null;
            this.mCipher = null;
            this.mMac = null;
            this.mIdentityCredential = identityCredential;
        }

        public Signature getSignature() {
            return this.mSignature;
        }

        public Cipher getCipher() {
            return this.mCipher;
        }

        public Mac getMac() {
            return this.mMac;
        }

        public IdentityCredential getIdentityCredential() {
            return this.mIdentityCredential;
        }
    }

    public static class AuthenticationResult {
        private final int mAuthenticationType;
        private final CryptoObject mCryptoObject;

        AuthenticationResult(CryptoObject cryptoObject, int i) {
            this.mCryptoObject = cryptoObject;
            this.mAuthenticationType = i;
        }

        public CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }

        public int getAuthenticationType() {
            return this.mAuthenticationType;
        }
    }

    public static class PromptInfo {
        private final int mAllowedAuthenticators;
        private final CharSequence mDescription;
        private final boolean mIsConfirmationRequired;
        private final boolean mIsDeviceCredentialAllowed;
        private final CharSequence mNegativeButtonText;
        private final CharSequence mSubtitle;
        private final CharSequence mTitle;

        public static class Builder {
            private int mAllowedAuthenticators = 0;
            private CharSequence mDescription = null;
            private boolean mIsConfirmationRequired = true;
            private boolean mIsDeviceCredentialAllowed = false;
            private CharSequence mNegativeButtonText = null;
            private CharSequence mSubtitle = null;
            private CharSequence mTitle = null;

            public Builder setTitle(CharSequence charSequence) {
                this.mTitle = charSequence;
                return this;
            }

            public Builder setSubtitle(CharSequence charSequence) {
                this.mSubtitle = charSequence;
                return this;
            }

            public Builder setDescription(CharSequence charSequence) {
                this.mDescription = charSequence;
                return this;
            }

            public Builder setNegativeButtonText(CharSequence charSequence) {
                this.mNegativeButtonText = charSequence;
                return this;
            }

            public Builder setConfirmationRequired(boolean z) {
                this.mIsConfirmationRequired = z;
                return this;
            }

            @Deprecated
            public Builder setDeviceCredentialAllowed(boolean z) {
                this.mIsDeviceCredentialAllowed = z;
                return this;
            }

            public Builder setAllowedAuthenticators(int i) {
                this.mAllowedAuthenticators = i;
                return this;
            }

            public PromptInfo build() {
                boolean z;
                if (TextUtils.isEmpty(this.mTitle)) {
                    throw new IllegalArgumentException("Title must be set and non-empty.");
                } else if (AuthenticatorUtils.isSupportedCombination(this.mAllowedAuthenticators)) {
                    int i = this.mAllowedAuthenticators;
                    if (i != 0) {
                        z = AuthenticatorUtils.isDeviceCredentialAllowed(i);
                    } else {
                        z = this.mIsDeviceCredentialAllowed;
                    }
                    if (TextUtils.isEmpty(this.mNegativeButtonText) && !z) {
                        throw new IllegalArgumentException("Negative text must be set and non-empty.");
                    } else if (TextUtils.isEmpty(this.mNegativeButtonText) || !z) {
                        return new PromptInfo(this.mTitle, this.mSubtitle, this.mDescription, this.mNegativeButtonText, this.mIsConfirmationRequired, this.mIsDeviceCredentialAllowed, this.mAllowedAuthenticators);
                    } else {
                        throw new IllegalArgumentException("Negative text must not be set if device credential authentication is allowed.");
                    }
                } else {
                    throw new IllegalArgumentException("Authenticator combination is unsupported on API " + Build.VERSION.SDK_INT + ": " + AuthenticatorUtils.convertToString(this.mAllowedAuthenticators));
                }
            }
        }

        PromptInfo(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, boolean z, boolean z2, int i) {
            this.mTitle = charSequence;
            this.mSubtitle = charSequence2;
            this.mDescription = charSequence3;
            this.mNegativeButtonText = charSequence4;
            this.mIsConfirmationRequired = z;
            this.mIsDeviceCredentialAllowed = z2;
            this.mAllowedAuthenticators = i;
        }

        public CharSequence getTitle() {
            return this.mTitle;
        }

        public CharSequence getSubtitle() {
            return this.mSubtitle;
        }

        public CharSequence getDescription() {
            return this.mDescription;
        }

        public CharSequence getNegativeButtonText() {
            CharSequence charSequence = this.mNegativeButtonText;
            return charSequence != null ? charSequence : "";
        }

        public boolean isConfirmationRequired() {
            return this.mIsConfirmationRequired;
        }

        @Deprecated
        public boolean isDeviceCredentialAllowed() {
            return this.mIsDeviceCredentialAllowed;
        }

        public int getAllowedAuthenticators() {
            return this.mAllowedAuthenticators;
        }
    }

    private static class ResetCallbackObserver implements LifecycleObserver {
        private final WeakReference<BiometricViewModel> mViewModelRef;

        ResetCallbackObserver(BiometricViewModel biometricViewModel) {
            this.mViewModelRef = new WeakReference<>(biometricViewModel);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void resetCallback() {
            if (this.mViewModelRef.get() != null) {
                ((BiometricViewModel) this.mViewModelRef.get()).resetClientCallback();
            }
        }
    }

    public BiometricPrompt(FragmentActivity fragmentActivity, AuthenticationCallback authenticationCallback) {
        if (fragmentActivity == null) {
            throw new IllegalArgumentException("FragmentActivity must not be null.");
        } else if (authenticationCallback != null) {
            init(fragmentActivity.getSupportFragmentManager(), getViewModel(fragmentActivity), (Executor) null, authenticationCallback);
        } else {
            throw new IllegalArgumentException("AuthenticationCallback must not be null.");
        }
    }

    public BiometricPrompt(Fragment fragment, AuthenticationCallback authenticationCallback) {
        if (fragment == null) {
            throw new IllegalArgumentException("Fragment must not be null.");
        } else if (authenticationCallback != null) {
            FragmentActivity activity = fragment.getActivity();
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            BiometricViewModel viewModel = getViewModel(activity);
            addObservers(fragment, viewModel);
            init(childFragmentManager, viewModel, (Executor) null, authenticationCallback);
        } else {
            throw new IllegalArgumentException("AuthenticationCallback must not be null.");
        }
    }

    public BiometricPrompt(FragmentActivity fragmentActivity, Executor executor, AuthenticationCallback authenticationCallback) {
        if (fragmentActivity == null) {
            throw new IllegalArgumentException("FragmentActivity must not be null.");
        } else if (executor == null) {
            throw new IllegalArgumentException("Executor must not be null.");
        } else if (authenticationCallback != null) {
            init(fragmentActivity.getSupportFragmentManager(), getViewModel(fragmentActivity), executor, authenticationCallback);
        } else {
            throw new IllegalArgumentException("AuthenticationCallback must not be null.");
        }
    }

    public BiometricPrompt(Fragment fragment, Executor executor, AuthenticationCallback authenticationCallback) {
        if (fragment == null) {
            throw new IllegalArgumentException("Fragment must not be null.");
        } else if (executor == null) {
            throw new IllegalArgumentException("Executor must not be null.");
        } else if (authenticationCallback != null) {
            FragmentActivity activity = fragment.getActivity();
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            BiometricViewModel viewModel = getViewModel(activity);
            addObservers(fragment, viewModel);
            init(childFragmentManager, viewModel, executor, authenticationCallback);
        } else {
            throw new IllegalArgumentException("AuthenticationCallback must not be null.");
        }
    }

    private void init(FragmentManager fragmentManager, BiometricViewModel biometricViewModel, Executor executor, AuthenticationCallback authenticationCallback) {
        this.mClientFragmentManager = fragmentManager;
        if (biometricViewModel != null) {
            if (executor != null) {
                biometricViewModel.setClientExecutor(executor);
            }
            biometricViewModel.setClientCallback(authenticationCallback);
        }
    }

    public void authenticate(PromptInfo promptInfo, CryptoObject cryptoObject) {
        if (promptInfo == null) {
            throw new IllegalArgumentException("PromptInfo cannot be null.");
        } else if (cryptoObject != null) {
            int consolidatedAuthenticators = AuthenticatorUtils.getConsolidatedAuthenticators(promptInfo, cryptoObject);
            if (AuthenticatorUtils.isWeakBiometricAllowed(consolidatedAuthenticators)) {
                throw new IllegalArgumentException("Crypto-based authentication is not supported for Class 2 (Weak) biometrics.");
            } else if (Build.VERSION.SDK_INT >= 30 || !AuthenticatorUtils.isDeviceCredentialAllowed(consolidatedAuthenticators)) {
                authenticateInternal(promptInfo, cryptoObject);
            } else {
                throw new IllegalArgumentException("Crypto-based authentication is not supported for device credential prior to API 30.");
            }
        } else {
            throw new IllegalArgumentException("CryptoObject cannot be null.");
        }
    }

    public void authenticate(PromptInfo promptInfo) {
        if (promptInfo != null) {
            authenticateInternal(promptInfo, (CryptoObject) null);
            return;
        }
        throw new IllegalArgumentException("PromptInfo cannot be null.");
    }

    private void authenticateInternal(PromptInfo promptInfo, CryptoObject cryptoObject) {
        FragmentManager fragmentManager = this.mClientFragmentManager;
        if (fragmentManager == null) {
            Log.e(TAG, "Unable to start authentication. Client fragment manager was null.");
        } else if (fragmentManager.isStateSaved()) {
            Log.e(TAG, "Unable to start authentication. Called after onSaveInstanceState().");
        } else {
            findOrAddBiometricFragment(this.mClientFragmentManager).authenticate(promptInfo, cryptoObject);
        }
    }

    public void cancelAuthentication() {
        FragmentManager fragmentManager = this.mClientFragmentManager;
        if (fragmentManager == null) {
            Log.e(TAG, "Unable to start authentication. Client fragment manager was null.");
            return;
        }
        BiometricFragment findBiometricFragment = findBiometricFragment(fragmentManager);
        if (findBiometricFragment == null) {
            Log.e(TAG, "Unable to cancel authentication. BiometricFragment not found.");
        } else {
            findBiometricFragment.cancelAuthentication(3);
        }
    }

    private static BiometricViewModel getViewModel(FragmentActivity fragmentActivity) {
        if (fragmentActivity != null) {
            return (BiometricViewModel) new ViewModelProvider(fragmentActivity).get(BiometricViewModel.class);
        }
        return null;
    }

    private static void addObservers(Fragment fragment, BiometricViewModel biometricViewModel) {
        if (biometricViewModel != null) {
            fragment.getLifecycle().addObserver(new ResetCallbackObserver(biometricViewModel));
        }
    }

    private static BiometricFragment findBiometricFragment(FragmentManager fragmentManager) {
        return (BiometricFragment) fragmentManager.findFragmentByTag(BIOMETRIC_FRAGMENT_TAG);
    }

    private static BiometricFragment findOrAddBiometricFragment(FragmentManager fragmentManager) {
        BiometricFragment findBiometricFragment = findBiometricFragment(fragmentManager);
        if (findBiometricFragment != null) {
            return findBiometricFragment;
        }
        BiometricFragment newInstance = BiometricFragment.newInstance();
        fragmentManager.beginTransaction().add((Fragment) newInstance, BIOMETRIC_FRAGMENT_TAG).commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();
        return newInstance;
    }
}
