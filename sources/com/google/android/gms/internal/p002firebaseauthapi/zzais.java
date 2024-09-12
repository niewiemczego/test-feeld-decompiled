package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaiu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzais  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzais<T extends zzaiu<T>> {
    private static final zzais zzb = new zzais(true);
    final zzalh<T, Object> zza;
    private boolean zzc;
    private boolean zzd;

    static int zza(zzamo zzamo, int i, Object obj) {
        int zzg = zzaii.zzg(i);
        if (zzamo == zzamo.GROUP) {
            zzajc.zza((zzakk) obj);
            zzg <<= 1;
        }
        return zzg + zza(zzamo, obj);
    }

    private static int zza(zzamo zzamo, Object obj) {
        switch (zzaiv.zzb[zzamo.ordinal()]) {
            case 1:
                return zzaii.zza(((Double) obj).doubleValue());
            case 2:
                return zzaii.zza(((Float) obj).floatValue());
            case 3:
                return zzaii.zzb(((Long) obj).longValue());
            case 4:
                return zzaii.zze(((Long) obj).longValue());
            case 5:
                return zzaii.zzc(((Integer) obj).intValue());
            case 6:
                return zzaii.zza(((Long) obj).longValue());
            case 7:
                return zzaii.zzb(((Integer) obj).intValue());
            case 8:
                return zzaii.zza(((Boolean) obj).booleanValue());
            case 9:
                return zzaii.zza((zzakk) obj);
            case 10:
                if (obj instanceof zzajk) {
                    return zzaii.zza((zzajo) (zzajk) obj);
                }
                return zzaii.zzb((zzakk) obj);
            case 11:
                if (obj instanceof zzahm) {
                    return zzaii.zza((zzahm) obj);
                }
                return zzaii.zza((String) obj);
            case 12:
                if (obj instanceof zzahm) {
                    return zzaii.zza((zzahm) obj);
                }
                return zzaii.zza((byte[]) obj);
            case 13:
                return zzaii.zzh(((Integer) obj).intValue());
            case 14:
                return zzaii.zze(((Integer) obj).intValue());
            case 15:
                return zzaii.zzc(((Long) obj).longValue());
            case 16:
                return zzaii.zzf(((Integer) obj).intValue());
            case 17:
                return zzaii.zzd(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzajf) {
                    return zzaii.zza(((zzajf) obj).zza());
                }
                return zzaii.zza(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzaiu<?> zzaiu, Object obj) {
        zzamo zzb2 = zzaiu.zzb();
        int zza2 = zzaiu.zza();
        if (!zzaiu.zze()) {
            return zza(zzb2, zza2, obj);
        }
        List<Object> list = (List) obj;
        int i = 0;
        if (!zzaiu.zzd()) {
            for (Object zza3 : list) {
                i += zza(zzb2, zza2, zza3);
            }
            return i;
        } else if (list.isEmpty()) {
            return 0;
        } else {
            for (Object zza4 : list) {
                i += zza(zzb2, zza4);
            }
            return zzaii.zzg(zza2) + i + zzaii.zzh(i);
        }
    }

    public final int zza() {
        int i = 0;
        for (int i2 = 0; i2 < this.zza.zzb(); i2++) {
            i += zza(this.zza.zzb(i2));
        }
        for (Map.Entry<T, Object> zza2 : this.zza.zzc()) {
            i += zza(zza2);
        }
        return i;
    }

    private static int zza(Map.Entry<T, Object> entry) {
        zzaiu zzaiu = (zzaiu) entry.getKey();
        Object value = entry.getValue();
        if (zzaiu.zzc() != zzamy.MESSAGE || zzaiu.zze() || zzaiu.zzd()) {
            return zza((zzaiu<?>) zzaiu, value);
        }
        if (value instanceof zzajk) {
            return zzaii.zza(((zzaiu) entry.getKey()).zza(), (zzajo) (zzajk) value);
        }
        return zzaii.zza(((zzaiu) entry.getKey()).zza(), (zzakk) value);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public static <T extends zzaiu<T>> zzais<T> zzb() {
        return zzb;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzais zzais = new zzais();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry<T, Object> zzb2 = this.zza.zzb(i);
            zzais.zzb((zzaiu) zzb2.getKey(), zzb2.getValue());
        }
        for (Map.Entry next : this.zza.zzc()) {
            zzais.zzb((zzaiu) next.getKey(), next.getValue());
        }
        zzais.zzd = this.zzd;
        return zzais;
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzakt) {
            return ((zzakt) obj).zza();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        if (!(obj instanceof zzajk)) {
            return obj;
        }
        zzajk zzajk = (zzajk) obj;
        return zzajk.zza();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> zzc() {
        if (this.zzd) {
            return new zzajp(this.zza.zzd().iterator());
        }
        return this.zza.zzd().iterator();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzd) {
            return new zzajp(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    private zzais() {
        this.zza = zzalh.zza(16);
    }

    private zzais(zzalh<T, Object> zzalh) {
        this.zza = zzalh;
        zze();
    }

    private zzais(boolean z) {
        this(zzalh.zza(0));
        zze();
    }

    public final void zze() {
        if (!this.zzc) {
            for (int i = 0; i < this.zza.zzb(); i++) {
                Map.Entry<T, Object> zzb2 = this.zza.zzb(i);
                if (zzb2.getValue() instanceof zzaja) {
                    ((zzaja) zzb2.getValue()).zzs();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zza(zzais<T> zzais) {
        for (int i = 0; i < zzais.zza.zzb(); i++) {
            zzb(zzais.zza.zzb(i));
        }
        for (Map.Entry<T, Object> zzb2 : zzais.zza.zzc()) {
            zzb(zzb2);
        }
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        Object obj;
        zzaiu zzaiu = (zzaiu) entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zzajk;
        if (zzaiu.zze()) {
            if (!z) {
                Object zza2 = zza(zzaiu);
                if (zza2 == null) {
                    zza2 = new ArrayList();
                }
                for (Object zza3 : (List) value) {
                    ((List) zza2).add(zza(zza3));
                }
                this.zza.put(zzaiu, zza2);
                return;
            }
            throw new IllegalStateException("Lazy fields can not be repeated");
        } else if (zzaiu.zzc() == zzamy.MESSAGE) {
            Object zza4 = zza(zzaiu);
            if (zza4 == null) {
                this.zza.put(zzaiu, zza(value));
                if (z) {
                    this.zzd = true;
                    return;
                }
                return;
            }
            if (z) {
                zzajk zzajk = (zzajk) value;
                value = zzajk.zza();
            }
            if (zza4 instanceof zzakt) {
                obj = zzaiu.zza((zzakt) zza4, (zzakt) value);
            } else {
                obj = zzaiu.zza(((zzakk) zza4).zzq(), (zzakk) value).zzf();
            }
            this.zza.put(zzaiu, obj);
        } else if (!z) {
            this.zza.put(zzaiu, zza(value));
        } else {
            throw new IllegalStateException("Lazy fields must be message-valued");
        }
    }

    private final void zzb(T t, Object obj) {
        if (!t.zze()) {
            zzc(t, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                zzc(t, obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzajk) {
            this.zzd = true;
        }
        this.zza.put(t, obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0029, code lost:
        if ((r6 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzajf) == false) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        if ((r6 instanceof byte[]) == false) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
        if (r0 == false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0049, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0077, code lost:
        throw new java.lang.IllegalArgumentException(java.lang.String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new java.lang.Object[]{java.lang.Integer.valueOf(r5.zza()), r5.zzb().zzb(), r6.getClass().getName()}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0018, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        if ((r6 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzajk) == false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzc(T r5, java.lang.Object r6) {
        /*
            com.google.android.gms.internal.firebase-auth-api.zzamo r0 = r5.zzb()
            com.google.android.gms.internal.p002firebaseauthapi.zzajc.zza(r6)
            int[] r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaiv.zza
            com.google.android.gms.internal.firebase-auth-api.zzamy r0 = r0.zzb()
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            r2 = 0
            switch(r0) {
                case 1: goto L_0x0045;
                case 2: goto L_0x0042;
                case 3: goto L_0x003f;
                case 4: goto L_0x003c;
                case 5: goto L_0x0039;
                case 6: goto L_0x0036;
                case 7: goto L_0x002c;
                case 8: goto L_0x0023;
                case 9: goto L_0x001a;
                default: goto L_0x0018;
            }
        L_0x0018:
            r0 = r2
            goto L_0x0047
        L_0x001a:
            boolean r0 = r6 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzakk
            if (r0 != 0) goto L_0x0034
            boolean r0 = r6 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzajk
            if (r0 == 0) goto L_0x0018
            goto L_0x0034
        L_0x0023:
            boolean r0 = r6 instanceof java.lang.Integer
            if (r0 != 0) goto L_0x0034
            boolean r0 = r6 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzajf
            if (r0 == 0) goto L_0x0018
            goto L_0x0034
        L_0x002c:
            boolean r0 = r6 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzahm
            if (r0 != 0) goto L_0x0034
            boolean r0 = r6 instanceof byte[]
            if (r0 == 0) goto L_0x0018
        L_0x0034:
            r0 = r1
            goto L_0x0047
        L_0x0036:
            boolean r0 = r6 instanceof java.lang.String
            goto L_0x0047
        L_0x0039:
            boolean r0 = r6 instanceof java.lang.Boolean
            goto L_0x0047
        L_0x003c:
            boolean r0 = r6 instanceof java.lang.Double
            goto L_0x0047
        L_0x003f:
            boolean r0 = r6 instanceof java.lang.Float
            goto L_0x0047
        L_0x0042:
            boolean r0 = r6 instanceof java.lang.Long
            goto L_0x0047
        L_0x0045:
            boolean r0 = r6 instanceof java.lang.Integer
        L_0x0047:
            if (r0 == 0) goto L_0x004a
            return
        L_0x004a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            int r4 = r5.zza()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r2] = r4
            com.google.android.gms.internal.firebase-auth-api.zzamo r5 = r5.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzamy r5 = r5.zzb()
            r3[r1] = r5
            r5 = 2
            java.lang.Class r6 = r6.getClass()
            java.lang.String r6 = r6.getName()
            r3[r5] = r6
            java.lang.String r5 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r5 = java.lang.String.format(r5, r3)
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzais.zzc(com.google.android.gms.internal.firebase-auth-api.zzaiu, java.lang.Object):void");
    }

    static void zza(zzaii zzaii, zzamo zzamo, int i, Object obj) throws IOException {
        if (zzamo == zzamo.GROUP) {
            zzakk zzakk = (zzakk) obj;
            zzajc.zza(zzakk);
            zzaii.zzj(i, 3);
            zzakk.zza(zzaii);
            zzaii.zzj(i, 4);
            return;
        }
        zzaii.zzj(i, zzamo.zza());
        switch (zzaiv.zzb[zzamo.ordinal()]) {
            case 1:
                zzaii.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zzaii.zzb(((Float) obj).floatValue());
                return;
            case 3:
                zzaii.zzh(((Long) obj).longValue());
                return;
            case 4:
                zzaii.zzh(((Long) obj).longValue());
                return;
            case 5:
                zzaii.zzj(((Integer) obj).intValue());
                return;
            case 6:
                zzaii.zzf(((Long) obj).longValue());
                return;
            case 7:
                zzaii.zzi(((Integer) obj).intValue());
                return;
            case 8:
                zzaii.zzb(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzakk) obj).zza(zzaii);
                return;
            case 10:
                zzaii.zzc((zzakk) obj);
                return;
            case 11:
                if (obj instanceof zzahm) {
                    zzaii.zzb((zzahm) obj);
                    return;
                } else {
                    zzaii.zzb((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzahm) {
                    zzaii.zzb((zzahm) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzaii.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzaii.zzl(((Integer) obj).intValue());
                return;
            case 14:
                zzaii.zzi(((Integer) obj).intValue());
                return;
            case 15:
                zzaii.zzf(((Long) obj).longValue());
                return;
            case 16:
                zzaii.zzk(((Integer) obj).intValue());
                return;
            case 17:
                zzaii.zzg(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzajf) {
                    zzaii.zzj(((zzajf) obj).zza());
                    return;
                } else {
                    zzaii.zzj(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzais)) {
            return false;
        }
        return this.zza.equals(((zzais) obj).zza);
    }

    public final boolean zzf() {
        return this.zzc;
    }

    public final boolean zzg() {
        for (int i = 0; i < this.zza.zzb(); i++) {
            if (!zzc(this.zza.zzb(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> zzc2 : this.zza.zzc()) {
            if (!zzc(zzc2)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzaiu<T>> boolean zzc(Map.Entry<T, Object> entry) {
        zzaiu zzaiu = (zzaiu) entry.getKey();
        if (zzaiu.zzc() != zzamy.MESSAGE) {
            return true;
        }
        if (!zzaiu.zze()) {
            return zzb(entry.getValue());
        }
        for (Object zzb2 : (List) entry.getValue()) {
            if (!zzb(zzb2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzb(Object obj) {
        if (obj instanceof zzakm) {
            return ((zzakm) obj).zzu();
        }
        if (obj instanceof zzajk) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }
}
