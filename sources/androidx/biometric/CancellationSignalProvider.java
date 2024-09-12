package androidx.biometric;

import android.os.Build;
import android.os.CancellationSignal;
import android.util.Log;

class CancellationSignalProvider {
    private static final String TAG = "CancelSignalProvider";
    private CancellationSignal mBiometricCancellationSignal;
    private androidx.core.os.CancellationSignal mFingerprintCancellationSignal;
    private final Injector mInjector;

    interface Injector {
        CancellationSignal getBiometricCancellationSignal();

        androidx.core.os.CancellationSignal getFingerprintCancellationSignal();
    }

    CancellationSignalProvider() {
        this.mInjector = new Injector() {
            public CancellationSignal getBiometricCancellationSignal() {
                return Api16Impl.create();
            }

            public androidx.core.os.CancellationSignal getFingerprintCancellationSignal() {
                return new androidx.core.os.CancellationSignal();
            }
        };
    }

    CancellationSignalProvider(Injector injector) {
        this.mInjector = injector;
    }

    /* access modifiers changed from: package-private */
    public CancellationSignal getBiometricCancellationSignal() {
        if (this.mBiometricCancellationSignal == null) {
            this.mBiometricCancellationSignal = this.mInjector.getBiometricCancellationSignal();
        }
        return this.mBiometricCancellationSignal;
    }

    /* access modifiers changed from: package-private */
    public androidx.core.os.CancellationSignal getFingerprintCancellationSignal() {
        if (this.mFingerprintCancellationSignal == null) {
            this.mFingerprintCancellationSignal = this.mInjector.getFingerprintCancellationSignal();
        }
        return this.mFingerprintCancellationSignal;
    }

    /* access modifiers changed from: package-private */
    public void cancel() {
        CancellationSignal cancellationSignal;
        if (Build.VERSION.SDK_INT >= 16 && (cancellationSignal = this.mBiometricCancellationSignal) != null) {
            try {
                Api16Impl.cancel(cancellationSignal);
            } catch (NullPointerException e) {
                Log.e(TAG, "Got NPE while canceling biometric authentication.", e);
            }
            this.mBiometricCancellationSignal = null;
        }
        androidx.core.os.CancellationSignal cancellationSignal2 = this.mFingerprintCancellationSignal;
        if (cancellationSignal2 != null) {
            try {
                cancellationSignal2.cancel();
            } catch (NullPointerException e2) {
                Log.e(TAG, "Got NPE while canceling fingerprint authentication.", e2);
            }
            this.mFingerprintCancellationSignal = null;
        }
    }

    private static class Api16Impl {
        private Api16Impl() {
        }

        static CancellationSignal create() {
            return new CancellationSignal();
        }

        static void cancel(CancellationSignal cancellationSignal) {
            cancellationSignal.cancel();
        }
    }
}
