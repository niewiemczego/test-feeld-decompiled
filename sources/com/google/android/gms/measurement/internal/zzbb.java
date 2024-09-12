package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzbb extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzbb> CREATOR = new zzbd();
    /* access modifiers changed from: private */
    public final Bundle zza;

    public final int zza() {
        return this.zza.size();
    }

    public final Bundle zzb() {
        return new Bundle(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final Double zza(String str) {
        return Double.valueOf(this.zza.getDouble(str));
    }

    /* access modifiers changed from: package-private */
    public final Long zzb(String str) {
        return Long.valueOf(this.zza.getLong(str));
    }

    /* access modifiers changed from: package-private */
    public final Object zzc(String str) {
        return this.zza.get(str);
    }

    /* access modifiers changed from: package-private */
    public final String zzd(String str) {
        return this.zza.getString(str);
    }

    public final String toString() {
        return this.zza.toString();
    }

    public final Iterator<String> iterator() {
        return new zzbe(this);
    }

    zzbb(Bundle bundle) {
        this.zza = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, zzb(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
