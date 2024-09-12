package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzis;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
final class zziq<T extends zzis<T>> {
    private static final zziq zzb = new zziq(true);
    final zzlg<T, Object> zza;
    private boolean zzc;
    private boolean zzd;

    static int zza(zzmn zzmn, int i, Object obj) {
        int zzi = zzig.zzi(i);
        if (zzmn == zzmn.GROUP) {
            zziz.zza((zzkj) obj);
            zzi <<= 1;
        }
        return zzi + zza(zzmn, obj);
    }

    private static int zza(zzmn zzmn, Object obj) {
        switch (zzip.zzb[zzmn.ordinal()]) {
            case 1:
                return zzig.zza(((Double) obj).doubleValue());
            case 2:
                return zzig.zza(((Float) obj).floatValue());
            case 3:
                return zzig.zzd(((Long) obj).longValue());
            case 4:
                return zzig.zzg(((Long) obj).longValue());
            case 5:
                return zzig.zzf(((Integer) obj).intValue());
            case 6:
                return zzig.zzc(((Long) obj).longValue());
            case 7:
                return zzig.zze(((Integer) obj).intValue());
            case 8:
                return zzig.zza(((Boolean) obj).booleanValue());
            case 9:
                return zzig.zzb((zzkj) obj);
            case 10:
                if (obj instanceof zzjj) {
                    return zzig.zza((zzjn) (zzjj) obj);
                }
                return zzig.zzc((zzkj) obj);
            case 11:
                if (obj instanceof zzhm) {
                    return zzig.zzb((zzhm) obj);
                }
                return zzig.zzb((String) obj);
            case 12:
                if (obj instanceof zzhm) {
                    return zzig.zzb((zzhm) obj);
                }
                return zzig.zza((byte[]) obj);
            case 13:
                return zzig.zzj(((Integer) obj).intValue());
            case 14:
                return zzig.zzg(((Integer) obj).intValue());
            case 15:
                return zzig.zze(((Long) obj).longValue());
            case 16:
                return zzig.zzh(((Integer) obj).intValue());
            case 17:
                return zzig.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzjc) {
                    return zzig.zzd(((zzjc) obj).zza());
                }
                return zzig.zzd(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzis<?> zzis, Object obj) {
        zzmn zzb2 = zzis.zzb();
        int zza2 = zzis.zza();
        if (!zzis.zze()) {
            return zza(zzb2, zza2, obj);
        }
        List<Object> list = (List) obj;
        int i = 0;
        if (!zzis.zzd()) {
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
            return zzig.zzi(zza2) + i + zzig.zzj(i);
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
        zzis zzis = (zzis) entry.getKey();
        Object value = entry.getValue();
        if (zzis.zzc() != zzmx.MESSAGE || zzis.zze() || zzis.zzd()) {
            return zza((zzis<?>) zzis, value);
        }
        if (value instanceof zzjj) {
            return zzig.zza(((zzis) entry.getKey()).zza(), (zzjn) (zzjj) value);
        }
        return zzig.zzb(((zzis) entry.getKey()).zza(), (zzkj) value);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public static <T extends zzis<T>> zziq<T> zzb() {
        return zzb;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zziq zziq = new zziq();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry<T, Object> zzb2 = this.zza.zzb(i);
            zziq.zzb((zzis) zzb2.getKey(), zzb2.getValue());
        }
        for (Map.Entry next : this.zza.zzc()) {
            zziq.zzb((zzis) next.getKey(), next.getValue());
        }
        zziq.zzd = this.zzd;
        return zziq;
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzks) {
            return ((zzks) obj).zza();
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
        if (!(obj instanceof zzjj)) {
            return obj;
        }
        zzjj zzjj = (zzjj) obj;
        return zzjj.zza();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> zzc() {
        if (this.zzd) {
            return new zzjo(this.zza.zzd().iterator());
        }
        return this.zza.zzd().iterator();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzd) {
            return new zzjo(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    private zziq() {
        this.zza = zzlg.zza(16);
    }

    private zziq(zzlg<T, Object> zzlg) {
        this.zza = zzlg;
        zze();
    }

    private zziq(boolean z) {
        this(zzlg.zza(0));
        zze();
    }

    public final void zze() {
        if (!this.zzc) {
            for (int i = 0; i < this.zza.zzb(); i++) {
                Map.Entry<T, Object> zzb2 = this.zza.zzb(i);
                if (zzb2.getValue() instanceof zzix) {
                    ((zzix) zzb2.getValue()).zzcg();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zza(zziq<T> zziq) {
        for (int i = 0; i < zziq.zza.zzb(); i++) {
            zzb(zziq.zza.zzb(i));
        }
        for (Map.Entry<T, Object> zzb2 : zziq.zza.zzc()) {
            zzb(zzb2);
        }
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        Object obj;
        zzis zzis = (zzis) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzjj) {
            zzjj zzjj = (zzjj) value;
            value = zzjj.zza();
        }
        if (zzis.zze()) {
            Object zza2 = zza(zzis);
            if (zza2 == null) {
                zza2 = new ArrayList();
            }
            for (Object zza3 : (List) value) {
                ((List) zza2).add(zza(zza3));
            }
            this.zza.put(zzis, zza2);
        } else if (zzis.zzc() == zzmx.MESSAGE) {
            Object zza4 = zza(zzis);
            if (zza4 == null) {
                this.zza.put(zzis, zza(value));
                return;
            }
            if (zza4 instanceof zzks) {
                obj = zzis.zza((zzks) zza4, (zzks) value);
            } else {
                obj = zzis.zza(((zzkj) zza4).zzce(), (zzkj) value).zzab();
            }
            this.zza.put(zzis, obj);
        } else {
            this.zza.put(zzis, zza(value));
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
        if (obj instanceof zzjj) {
            this.zzd = true;
        }
        this.zza.put(t, obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0029, code lost:
        if ((r6 instanceof com.google.android.gms.internal.measurement.zzjc) == false) goto L_0x0018;
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
        if ((r6 instanceof com.google.android.gms.internal.measurement.zzjj) == false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzc(T r5, java.lang.Object r6) {
        /*
            com.google.android.gms.internal.measurement.zzmn r0 = r5.zzb()
            com.google.android.gms.internal.measurement.zziz.zza(r6)
            int[] r1 = com.google.android.gms.internal.measurement.zzip.zza
            com.google.android.gms.internal.measurement.zzmx r0 = r0.zzb()
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
            boolean r0 = r6 instanceof com.google.android.gms.internal.measurement.zzkj
            if (r0 != 0) goto L_0x0034
            boolean r0 = r6 instanceof com.google.android.gms.internal.measurement.zzjj
            if (r0 == 0) goto L_0x0018
            goto L_0x0034
        L_0x0023:
            boolean r0 = r6 instanceof java.lang.Integer
            if (r0 != 0) goto L_0x0034
            boolean r0 = r6 instanceof com.google.android.gms.internal.measurement.zzjc
            if (r0 == 0) goto L_0x0018
            goto L_0x0034
        L_0x002c:
            boolean r0 = r6 instanceof com.google.android.gms.internal.measurement.zzhm
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
            com.google.android.gms.internal.measurement.zzmn r5 = r5.zzb()
            com.google.android.gms.internal.measurement.zzmx r5 = r5.zzb()
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zziq.zzc(com.google.android.gms.internal.measurement.zzis, java.lang.Object):void");
    }

    static void zza(zzig zzig, zzmn zzmn, int i, Object obj) throws IOException {
        if (zzmn == zzmn.GROUP) {
            zzkj zzkj = (zzkj) obj;
            zziz.zza(zzkj);
            zzig.zzc(i, 3);
            zzkj.zza(zzig);
            zzig.zzc(i, 4);
            return;
        }
        zzig.zzc(i, zzmn.zza());
        switch (zzip.zzb[zzmn.ordinal()]) {
            case 1:
                zzig.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zzig.zzb(((Float) obj).floatValue());
                return;
            case 3:
                zzig.zzb(((Long) obj).longValue());
                return;
            case 4:
                zzig.zzb(((Long) obj).longValue());
                return;
            case 5:
                zzig.zzb(((Integer) obj).intValue());
                return;
            case 6:
                zzig.zza(((Long) obj).longValue());
                return;
            case 7:
                zzig.zza(((Integer) obj).intValue());
                return;
            case 8:
                zzig.zzb(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzkj) obj).zza(zzig);
                return;
            case 10:
                zzig.zza((zzkj) obj);
                return;
            case 11:
                if (obj instanceof zzhm) {
                    zzig.zza((zzhm) obj);
                    return;
                } else {
                    zzig.zza((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzhm) {
                    zzig.zza((zzhm) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzig.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzig.zzc(((Integer) obj).intValue());
                return;
            case 14:
                zzig.zza(((Integer) obj).intValue());
                return;
            case 15:
                zzig.zza(((Long) obj).longValue());
                return;
            case 16:
                zzig.zzk(((Integer) obj).intValue());
                return;
            case 17:
                zzig.zzh(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzjc) {
                    zzig.zzb(((zzjc) obj).zza());
                    return;
                } else {
                    zzig.zzb(((Integer) obj).intValue());
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
        if (!(obj instanceof zziq)) {
            return false;
        }
        return this.zza.equals(((zziq) obj).zza);
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

    private static <T extends zzis<T>> boolean zzc(Map.Entry<T, Object> entry) {
        zzis zzis = (zzis) entry.getKey();
        if (zzis.zzc() != zzmx.MESSAGE) {
            return true;
        }
        if (!zzis.zze()) {
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
        if (obj instanceof zzkl) {
            return ((zzkl) obj).zzci();
        }
        if (obj instanceof zzjj) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }
}
