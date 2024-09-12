package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoy  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzoy {
    /* access modifiers changed from: private */
    public final Map<zzpd, zzmx<?, ?>> zza;
    /* access modifiers changed from: private */
    public final Map<zzpb, zzmt<?>> zzb;
    /* access modifiers changed from: private */
    public final Map<zzpd, zzoa<?, ?>> zzc;
    /* access modifiers changed from: private */
    public final Map<zzpb, zznw<?>> zzd;

    public final <SerializationT extends zzow> zzoy zza(zzmt<SerializationT> zzmt) throws GeneralSecurityException {
        zzpb zzpb = new zzpb(zzmt.zzb(), zzmt.zza());
        if (this.zzb.containsKey(zzpb)) {
            zzmt zzmt2 = this.zzb.get(zzpb);
            if (!zzmt2.equals(zzmt) || !zzmt.equals(zzmt2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + String.valueOf(zzpb));
            }
        } else {
            this.zzb.put(zzpb, zzmt);
        }
        return this;
    }

    public final <KeyT extends zzbu, SerializationT extends zzow> zzoy zza(zzmx<KeyT, SerializationT> zzmx) throws GeneralSecurityException {
        zzpd zzpd = new zzpd(zzmx.zza(), zzmx.zzb());
        if (this.zza.containsKey(zzpd)) {
            zzmx zzmx2 = this.zza.get(zzpd);
            if (!zzmx2.equals(zzmx) || !zzmx.equals(zzmx2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + String.valueOf(zzpd));
            }
        } else {
            this.zza.put(zzpd, zzmx);
        }
        return this;
    }

    public final <SerializationT extends zzow> zzoy zza(zznw<SerializationT> zznw) throws GeneralSecurityException {
        zzpb zzpb = new zzpb(zznw.zzb(), zznw.zza());
        if (this.zzd.containsKey(zzpb)) {
            zznw zznw2 = this.zzd.get(zzpb);
            if (!zznw2.equals(zznw) || !zznw.equals(zznw2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + String.valueOf(zzpb));
            }
        } else {
            this.zzd.put(zzpb, zznw);
        }
        return this;
    }

    public final <ParametersT extends zzci, SerializationT extends zzow> zzoy zza(zzoa<ParametersT, SerializationT> zzoa) throws GeneralSecurityException {
        zzpd zzpd = new zzpd(zzoa.zza(), zzoa.zzb());
        if (this.zzc.containsKey(zzpd)) {
            zzoa zzoa2 = this.zzc.get(zzpd);
            if (!zzoa2.equals(zzoa) || !zzoa.equals(zzoa2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + String.valueOf(zzpd));
            }
        } else {
            this.zzc.put(zzpd, zzoa);
        }
        return this;
    }

    public final zzoz zza() {
        return new zzoz(this);
    }

    public zzoy() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new HashMap();
        this.zzd = new HashMap();
    }

    public zzoy(zzoz zzoz) {
        this.zza = new HashMap(zzoz.zza);
        this.zzb = new HashMap(zzoz.zzb);
        this.zzc = new HashMap(zzoz.zzc);
        this.zzd = new HashMap(zzoz.zzd);
    }
}
