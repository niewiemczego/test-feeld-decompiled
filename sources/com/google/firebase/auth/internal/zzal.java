package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.p002firebaseauthapi.zzyi;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorResolver;
import com.google.firebase.auth.MultiFactorSession;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import com.google.firebase.auth.zzd;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzal extends MultiFactorResolver {
    public static final Parcelable.Creator<zzal> CREATOR = new zzan();
    private final List<PhoneMultiFactorInfo> zza;
    private final zzam zzb;
    private final String zzc;
    /* access modifiers changed from: private */
    public final zzd zzd;
    private final zzaf zze;
    private final List<TotpMultiFactorInfo> zzf;

    public final Task<AuthResult> resolveSignIn(MultiFactorAssertion multiFactorAssertion) {
        return getFirebaseAuth().zza(multiFactorAssertion, this.zzb, (FirebaseUser) this.zze).continueWithTask(new zzak(this));
    }

    public final FirebaseAuth getFirebaseAuth() {
        return FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzc));
    }

    public final MultiFactorSession getSession() {
        return this.zzb;
    }

    public static zzal zza(zzyi zzyi, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        List<MultiFactorInfo> zzc2 = zzyi.zzc();
        ArrayList arrayList = new ArrayList();
        for (MultiFactorInfo next : zzc2) {
            if (next instanceof PhoneMultiFactorInfo) {
                arrayList.add((PhoneMultiFactorInfo) next);
            }
        }
        List<MultiFactorInfo> zzc3 = zzyi.zzc();
        ArrayList arrayList2 = new ArrayList();
        for (MultiFactorInfo next2 : zzc3) {
            if (next2 instanceof TotpMultiFactorInfo) {
                arrayList2.add((TotpMultiFactorInfo) next2);
            }
        }
        return new zzal(arrayList, zzam.zza(zzyi.zzc(), zzyi.zzb()), firebaseAuth.getApp().getName(), zzyi.zza(), (zzaf) firebaseUser, arrayList2);
    }

    public final List<MultiFactorInfo> getHints() {
        ArrayList arrayList = new ArrayList();
        for (PhoneMultiFactorInfo add : this.zza) {
            arrayList.add(add);
        }
        for (TotpMultiFactorInfo add2 : this.zzf) {
            arrayList.add(add2);
        }
        return arrayList;
    }

    public zzal(List<PhoneMultiFactorInfo> list, zzam zzam, String str, zzd zzd2, zzaf zzaf, List<TotpMultiFactorInfo> list2) {
        this.zza = (List) Preconditions.checkNotNull(list);
        this.zzb = (zzam) Preconditions.checkNotNull(zzam);
        this.zzc = Preconditions.checkNotEmpty(str);
        this.zzd = zzd2;
        this.zze = zzaf;
        this.zzf = (List) Preconditions.checkNotNull(list2);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getSession(), i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeTypedList(parcel, 6, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
