package com.google.firebase.auth;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthOptions;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class PhoneAuthProvider {
    public static final String PHONE_SIGN_IN_METHOD = "phone";
    public static final String PROVIDER_ID = "phone";
    private final FirebaseAuth zza;

    public static PhoneAuthCredential getCredential(String str, String str2) {
        return PhoneAuthCredential.zza(str, str2);
    }

    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static class ForceResendingToken extends AbstractSafeParcelable {
        public static final Parcelable.Creator<ForceResendingToken> CREATOR = new zze();

        public static ForceResendingToken zza() {
            return new ForceResendingToken();
        }

        ForceResendingToken() {
        }

        public void writeToParcel(Parcel parcel, int i) {
            SafeParcelWriter.finishObjectHeader(parcel, SafeParcelWriter.beginObjectHeader(parcel));
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static abstract class OnVerificationStateChangedCallbacks {
        private static final Logger zza = new Logger("PhoneAuthProvider", new String[0]);

        public void onCodeSent(String str, ForceResendingToken forceResendingToken) {
        }

        public abstract void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential);

        public abstract void onVerificationFailed(FirebaseException firebaseException);

        public void onCodeAutoRetrievalTimeOut(String str) {
            zza.i("Sms auto retrieval timed-out.", new Object[0]);
        }
    }

    @Deprecated
    public static PhoneAuthProvider getInstance() {
        return new PhoneAuthProvider(FirebaseAuth.getInstance(FirebaseApp.getInstance()));
    }

    @Deprecated
    public static PhoneAuthProvider getInstance(FirebaseAuth firebaseAuth) {
        return new PhoneAuthProvider(firebaseAuth);
    }

    private PhoneAuthProvider(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public static void verifyPhoneNumber(PhoneAuthOptions phoneAuthOptions) {
        Preconditions.checkNotNull(phoneAuthOptions);
        FirebaseAuth.zza(phoneAuthOptions);
    }

    @Deprecated
    public void verifyPhoneNumber(String str, long j, TimeUnit timeUnit, Activity activity, OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        verifyPhoneNumber(PhoneAuthOptions.newBuilder(this.zza).setPhoneNumber(str).setTimeout(Long.valueOf(j), timeUnit).setActivity(activity).setCallbacks(onVerificationStateChangedCallbacks).build());
    }

    @Deprecated
    public void verifyPhoneNumber(String str, long j, TimeUnit timeUnit, Activity activity, OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, ForceResendingToken forceResendingToken) {
        PhoneAuthOptions.Builder callbacks = PhoneAuthOptions.newBuilder(this.zza).setPhoneNumber(str).setTimeout(Long.valueOf(j), timeUnit).setActivity(activity).setCallbacks(onVerificationStateChangedCallbacks);
        if (forceResendingToken != null) {
            callbacks.setForceResendingToken(forceResendingToken);
        }
        verifyPhoneNumber(callbacks.build());
    }
}
