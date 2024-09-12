package com.google.android.gms.internal.auth;

import com.google.android.gms.internal.auth.zzdo;
import com.google.android.gms.internal.auth.zzdp;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
public abstract class zzdo<MessageType extends zzdp<MessageType, BuilderType>, BuilderType extends zzdo<MessageType, BuilderType>> implements zzfv {
    /* renamed from: zza */
    public abstract zzdo clone();

    /* access modifiers changed from: protected */
    public abstract zzdo zzb(zzdp zzdp);

    public final /* bridge */ /* synthetic */ zzfv zzc(zzfw zzfw) {
        if (zzh().getClass().isInstance(zzfw)) {
            return zzb((zzdp) zzfw);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
