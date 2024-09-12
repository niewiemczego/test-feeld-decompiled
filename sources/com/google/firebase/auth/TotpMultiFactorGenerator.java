package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.internal.zzam;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class TotpMultiFactorGenerator {
    public static final String FACTOR_ID = "totp";

    public static Task<TotpSecret> generateSecret(MultiFactorSession multiFactorSession) {
        Preconditions.checkNotNull(multiFactorSession);
        zzam zzam = (zzam) multiFactorSession;
        return FirebaseAuth.getInstance(zzam.zza().zza()).zza(zzam);
    }

    public static TotpMultiFactorAssertion getAssertionForEnrollment(TotpSecret totpSecret, String str) {
        return new TotpMultiFactorAssertion((String) Preconditions.checkNotNull(str), (TotpSecret) Preconditions.checkNotNull(totpSecret), (String) null);
    }

    public static TotpMultiFactorAssertion getAssertionForSignIn(String str, String str2) {
        return new TotpMultiFactorAssertion((String) Preconditions.checkNotNull(str2), (TotpSecret) null, (String) Preconditions.checkNotNull(str));
    }

    private TotpMultiFactorGenerator() {
    }
}
