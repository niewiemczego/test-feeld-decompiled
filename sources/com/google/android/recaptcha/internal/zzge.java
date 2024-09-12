package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.internal.zzge;
import com.google.android.recaptcha.internal.zzgf;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public abstract class zzge<MessageType extends zzgf<MessageType, BuilderType>, BuilderType extends zzge<MessageType, BuilderType>> implements zzkd {
    /* renamed from: zza */
    public abstract zzge clone();

    /* access modifiers changed from: protected */
    public abstract zzge zzb(zzgf zzgf);

    public final /* bridge */ /* synthetic */ zzkd zzc(zzke zzke) {
        if (zzY().getClass().isInstance(zzke)) {
            return zzb((zzgf) zzke);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
