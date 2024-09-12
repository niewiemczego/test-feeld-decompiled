package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactor;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorSession;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzaj extends MultiFactor {
    /* access modifiers changed from: private */
    public final zzaf zza;

    public final Task<Void> enroll(MultiFactorAssertion multiFactorAssertion, String str) {
        Preconditions.checkNotNull(multiFactorAssertion);
        zzaf zzaf = this.zza;
        return FirebaseAuth.getInstance(zzaf.zza()).zza((FirebaseUser) zzaf, multiFactorAssertion, str);
    }

    public final Task<MultiFactorSession> getSession() {
        return this.zza.getIdToken(false).continueWithTask(new zzai(this));
    }

    public final Task<Void> unenroll(MultiFactorInfo multiFactorInfo) {
        Preconditions.checkNotNull(multiFactorInfo);
        return unenroll(multiFactorInfo.getUid());
    }

    public final Task<Void> unenroll(String str) {
        Preconditions.checkNotEmpty(str);
        zzaf zzaf = this.zza;
        return FirebaseAuth.getInstance(zzaf.zza()).zza((FirebaseUser) zzaf, str);
    }

    public final List<MultiFactorInfo> getEnrolledFactors() {
        return this.zza.zzh();
    }

    public zzaj(zzaf zzaf) {
        Preconditions.checkNotNull(zzaf);
        this.zza = zzaf;
    }
}
