package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzvh;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzck  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzck<P> {
    private final Class<P> zza;
    private ConcurrentMap<zzcl, List<zzcm<P>>> zzb;
    private final List<zzcm<P>> zzc;
    private zzcm<P> zzd;
    private zzrl zze;

    public final zzck<P> zza(@Nullable P p, @Nullable P p2, zzvh.zza zza2) throws GeneralSecurityException {
        return zza(p, p2, zza2, false);
    }

    public final zzck<P> zzb(@Nullable P p, @Nullable P p2, zzvh.zza zza2) throws GeneralSecurityException {
        return zza(p, p2, zza2, true);
    }

    private final zzck<P> zza(@Nullable P p, @Nullable P p2, zzvh.zza zza2, boolean z) throws GeneralSecurityException {
        byte[] bArr;
        if (this.zzb == null) {
            throw new IllegalStateException("addPrimitive cannot be called after build");
        } else if (p == null && p2 == null) {
            throw new GeneralSecurityException("at least one of the `fullPrimitive` or `primitive` must be set");
        } else if (zza2.zzc() == zzvb.ENABLED) {
            Integer valueOf = Integer.valueOf(zza2.zza());
            if (zza2.zzf() == zzvt.RAW) {
                valueOf = null;
            }
            zzbu zza3 = zznv.zza().zza(zzot.zza(zza2.zzb().zzf(), zza2.zzb().zze(), zza2.zzb().zzb(), zza2.zzf(), valueOf), zzct.zza());
            int i = zzbn.zza[zza2.zzf().ordinal()];
            if (i == 1 || i == 2) {
                bArr = ByteBuffer.allocate(5).put((byte) 0).putInt(zza2.zza()).array();
            } else if (i == 3) {
                bArr = ByteBuffer.allocate(5).put((byte) 1).putInt(zza2.zza()).array();
            } else if (i == 4) {
                bArr = zzbo.zza;
            } else {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            zzcm zzcm = new zzcm(p, p2, bArr, zza2.zzc(), zza2.zzf(), zza2.zza(), zza2.zzb().zzf(), zza3);
            ConcurrentMap<zzcl, List<zzcm<P>>> concurrentMap = this.zzb;
            List<zzcm<P>> list = this.zzc;
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzcm);
            zzcl zzcl = new zzcl(zzcm.zzh());
            List list2 = (List) concurrentMap.put(zzcl, Collections.unmodifiableList(arrayList));
            if (list2 != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(list2);
                arrayList2.add(zzcm);
                concurrentMap.put(zzcl, Collections.unmodifiableList(arrayList2));
            }
            list.add(zzcm);
            if (z) {
                if (this.zzd == null) {
                    this.zzd = zzcm;
                } else {
                    throw new IllegalStateException("you cannot set two primary primitives");
                }
            }
            return this;
        } else {
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
    }

    public final zzck<P> zza(zzrl zzrl) {
        if (this.zzb != null) {
            this.zze = zzrl;
            return this;
        }
        throw new IllegalStateException("setAnnotations cannot be called after build");
    }

    public final zzch<P> zza() throws GeneralSecurityException {
        if (this.zzb != null) {
            zzch zzch = new zzch(this.zzb, this.zzc, this.zzd, this.zze, this.zza);
            this.zzb = null;
            return zzch;
        }
        throw new IllegalStateException("build cannot be called twice");
    }

    private zzck(Class<P> cls) {
        this.zzb = new ConcurrentHashMap();
        this.zzc = new ArrayList();
        this.zza = cls;
        this.zze = zzrl.zza;
    }
}
