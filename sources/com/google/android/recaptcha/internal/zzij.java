package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzij {
    private static final zzij zzb = new zzij(true);
    final zzle zza = new zzku(16);
    private boolean zzc;
    private boolean zzd;

    private zzij() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x011e, code lost:
        r1 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0120, code lost:
        return r4 + r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(com.google.android.recaptcha.internal.zzii r4, java.lang.Object r5) {
        /*
            com.google.android.recaptcha.internal.zzmb r0 = r4.zzd()
            int r1 = r4.zza()
            r4.zzg()
            int r4 = com.google.android.recaptcha.internal.zzhh.zzb
            int r4 = r1 << 3
            int r4 = com.google.android.recaptcha.internal.zzhh.zzy(r4)
            com.google.android.recaptcha.internal.zzmb r1 = com.google.android.recaptcha.internal.zzmb.GROUP
            if (r0 != r1) goto L_0x0026
            r1 = r5
            com.google.android.recaptcha.internal.zzke r1 = (com.google.android.recaptcha.internal.zzke) r1
            byte[] r2 = com.google.android.recaptcha.internal.zzjc.zzd
            boolean r2 = r1 instanceof com.google.android.recaptcha.internal.zzgg
            if (r2 != 0) goto L_0x0022
            int r4 = r4 + r4
            goto L_0x0026
        L_0x0022:
            com.google.android.recaptcha.internal.zzgg r1 = (com.google.android.recaptcha.internal.zzgg) r1
            r4 = 0
            throw r4
        L_0x0026:
            com.google.android.recaptcha.internal.zzmc r1 = com.google.android.recaptcha.internal.zzmc.INT
            int r0 = r0.ordinal()
            r1 = 4
            r2 = 8
            switch(r0) {
                case 0: goto L_0x0119;
                case 1: goto L_0x0113;
                case 2: goto L_0x0108;
                case 3: goto L_0x00fd;
                case 4: goto L_0x00f2;
                case 5: goto L_0x00ec;
                case 6: goto L_0x00e6;
                case 7: goto L_0x00df;
                case 8: goto L_0x00c7;
                case 9: goto L_0x00c0;
                case 10: goto L_0x00aa;
                case 11: goto L_0x0093;
                case 12: goto L_0x0087;
                case 13: goto L_0x006b;
                case 14: goto L_0x0064;
                case 15: goto L_0x005d;
                case 16: goto L_0x004c;
                case 17: goto L_0x003a;
                default: goto L_0x0032;
            }
        L_0x0032:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.String r5 = "There is no way to get here, but the compiler thinks otherwise."
            r4.<init>(r5)
            throw r4
        L_0x003a:
            java.lang.Long r5 = (java.lang.Long) r5
            long r0 = r5.longValue()
            long r2 = r0 + r0
            r5 = 63
            long r0 = r0 >> r5
            long r0 = r0 ^ r2
            int r1 = com.google.android.recaptcha.internal.zzhh.zzz(r0)
            goto L_0x011f
        L_0x004c:
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            int r0 = r5 + r5
            int r5 = r5 >> 31
            r5 = r5 ^ r0
            int r1 = com.google.android.recaptcha.internal.zzhh.zzy(r5)
            goto L_0x011f
        L_0x005d:
            java.lang.Long r5 = (java.lang.Long) r5
            r5.longValue()
            goto L_0x011e
        L_0x0064:
            java.lang.Integer r5 = (java.lang.Integer) r5
            r5.intValue()
            goto L_0x011f
        L_0x006b:
            boolean r0 = r5 instanceof com.google.android.recaptcha.internal.zziv
            if (r0 == 0) goto L_0x007b
            com.google.android.recaptcha.internal.zziv r5 = (com.google.android.recaptcha.internal.zziv) r5
            int r5 = r5.zza()
            int r1 = com.google.android.recaptcha.internal.zzhh.zzu(r5)
            goto L_0x011f
        L_0x007b:
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            int r1 = com.google.android.recaptcha.internal.zzhh.zzu(r5)
            goto L_0x011f
        L_0x0087:
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            int r1 = com.google.android.recaptcha.internal.zzhh.zzy(r5)
            goto L_0x011f
        L_0x0093:
            boolean r0 = r5 instanceof com.google.android.recaptcha.internal.zzgw
            if (r0 == 0) goto L_0x00a2
            com.google.android.recaptcha.internal.zzgw r5 = (com.google.android.recaptcha.internal.zzgw) r5
            int r5 = r5.zzd()
            int r0 = com.google.android.recaptcha.internal.zzhh.zzy(r5)
            goto L_0x00d5
        L_0x00a2:
            byte[] r5 = (byte[]) r5
            int r5 = r5.length
            int r0 = com.google.android.recaptcha.internal.zzhh.zzy(r5)
            goto L_0x00d5
        L_0x00aa:
            boolean r0 = r5 instanceof com.google.android.recaptcha.internal.zzjj
            if (r0 == 0) goto L_0x00b9
            com.google.android.recaptcha.internal.zzjj r5 = (com.google.android.recaptcha.internal.zzjj) r5
            int r5 = r5.zza()
            int r0 = com.google.android.recaptcha.internal.zzhh.zzy(r5)
            goto L_0x00d5
        L_0x00b9:
            com.google.android.recaptcha.internal.zzke r5 = (com.google.android.recaptcha.internal.zzke) r5
            int r1 = com.google.android.recaptcha.internal.zzhh.zzv(r5)
            goto L_0x011f
        L_0x00c0:
            com.google.android.recaptcha.internal.zzke r5 = (com.google.android.recaptcha.internal.zzke) r5
            int r1 = r5.zzn()
            goto L_0x011f
        L_0x00c7:
            boolean r0 = r5 instanceof com.google.android.recaptcha.internal.zzgw
            if (r0 == 0) goto L_0x00d8
            com.google.android.recaptcha.internal.zzgw r5 = (com.google.android.recaptcha.internal.zzgw) r5
            int r5 = r5.zzd()
            int r0 = com.google.android.recaptcha.internal.zzhh.zzy(r5)
        L_0x00d5:
            int r1 = r0 + r5
            goto L_0x011f
        L_0x00d8:
            java.lang.String r5 = (java.lang.String) r5
            int r1 = com.google.android.recaptcha.internal.zzhh.zzx(r5)
            goto L_0x011f
        L_0x00df:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            r5.booleanValue()
            r1 = 1
            goto L_0x011f
        L_0x00e6:
            java.lang.Integer r5 = (java.lang.Integer) r5
            r5.intValue()
            goto L_0x011f
        L_0x00ec:
            java.lang.Long r5 = (java.lang.Long) r5
            r5.longValue()
            goto L_0x011e
        L_0x00f2:
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            int r1 = com.google.android.recaptcha.internal.zzhh.zzu(r5)
            goto L_0x011f
        L_0x00fd:
            java.lang.Long r5 = (java.lang.Long) r5
            long r0 = r5.longValue()
            int r1 = com.google.android.recaptcha.internal.zzhh.zzz(r0)
            goto L_0x011f
        L_0x0108:
            java.lang.Long r5 = (java.lang.Long) r5
            long r0 = r5.longValue()
            int r1 = com.google.android.recaptcha.internal.zzhh.zzz(r0)
            goto L_0x011f
        L_0x0113:
            java.lang.Float r5 = (java.lang.Float) r5
            r5.floatValue()
            goto L_0x011f
        L_0x0119:
            java.lang.Double r5 = (java.lang.Double) r5
            r5.doubleValue()
        L_0x011e:
            r1 = r2
        L_0x011f:
            int r4 = r4 + r1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzij.zza(com.google.android.recaptcha.internal.zzii, java.lang.Object):int");
    }

    public static zzij zzd() {
        return zzb;
    }

    private static Object zzl(Object obj) {
        if (obj instanceof zzkj) {
            return ((zzkj) obj).zzd();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private final void zzm(Map.Entry entry) {
        Object obj;
        zzii zzii = (zzii) entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zzjj;
        zzii.zzg();
        if (zzii.zze() == zzmc.MESSAGE) {
            Object zze = zze(zzii);
            if (zze == null) {
                this.zza.put(zzii, zzl(value));
                if (z) {
                    this.zzd = true;
                }
            } else if (!z) {
                if (zze instanceof zzkj) {
                    obj = zzii.zzc((zzkj) zze, (zzkj) value);
                } else {
                    zzkd zzX = ((zzke) zze).zzX();
                    zzii.zzb(zzX, (zzke) value);
                    obj = zzX.zzj();
                }
                this.zza.put(zzii, obj);
            } else {
                zzjj zzjj = (zzjj) value;
                throw null;
            }
        } else if (!z) {
            this.zza.put(zzii, zzl(value));
        } else {
            throw new IllegalStateException("Lazy fields must be message-valued");
        }
    }

    private static boolean zzn(Map.Entry entry) {
        zzii zzii = (zzii) entry.getKey();
        if (zzii.zze() != zzmc.MESSAGE) {
            return true;
        }
        zzii.zzg();
        Object value = entry.getValue();
        if (value instanceof zzkf) {
            return ((zzkf) value).zzo();
        }
        if (value instanceof zzjj) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzo(Map.Entry entry) {
        zzii zzii = (zzii) entry.getKey();
        Object value = entry.getValue();
        if (zzii.zze() != zzmc.MESSAGE) {
            return zza(zzii, value);
        }
        zzii.zzg();
        zzii.zzf();
        if (value instanceof zzjj) {
            int zzy = zzhh.zzy(((zzii) entry.getKey()).zza());
            int zza2 = ((zzjj) value).zza();
            int zzy2 = zzhh.zzy(zza2) + zza2;
            int zzy3 = zzhh.zzy(24);
            int zzy4 = zzhh.zzy(16);
            int zzy5 = zzhh.zzy(8);
            return zzy5 + zzy5 + zzy4 + zzy + zzy3 + zzy2;
        }
        int zzy6 = zzhh.zzy(((zzii) entry.getKey()).zza());
        int zzy7 = zzhh.zzy(24) + zzhh.zzv((zzke) value);
        int zzy8 = zzhh.zzy(16);
        int zzy9 = zzhh.zzy(8);
        return zzy9 + zzy9 + zzy8 + zzy6 + zzy7;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzij)) {
            return false;
        }
        return this.zza.equals(((zzij) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzb() {
        int i = 0;
        for (int i2 = 0; i2 < this.zza.zzb(); i2++) {
            i += zzo(this.zza.zzg(i2));
        }
        for (Map.Entry zzo : this.zza.zzc()) {
            i += zzo(zzo);
        }
        return i;
    }

    /* renamed from: zzc */
    public final zzij clone() {
        zzij zzij = new zzij();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry zzg = this.zza.zzg(i);
            zzij.zzi((zzii) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzij.zzi((zzii) entry.getKey(), entry.getValue());
        }
        zzij.zzd = this.zzd;
        return zzij;
    }

    public final Object zze(zzii zzii) {
        Object obj = this.zza.get(zzii);
        if (!(obj instanceof zzjj)) {
            return obj;
        }
        zzjj zzjj = (zzjj) obj;
        throw null;
    }

    public final Iterator zzf() {
        if (this.zzd) {
            return new zzji(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    public final void zzg() {
        if (!this.zzc) {
            for (int i = 0; i < this.zza.zzb(); i++) {
                Map.Entry zzg = this.zza.zzg(i);
                if (zzg.getValue() instanceof zzit) {
                    ((zzit) zzg.getValue()).zzB();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzh(zzij zzij) {
        for (int i = 0; i < zzij.zza.zzb(); i++) {
            zzm(zzij.zza.zzg(i));
        }
        for (Map.Entry zzm : zzij.zza.zzc()) {
            zzm(zzm);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
        if ((r7 instanceof byte[]) == false) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0049, code lost:
        if (r0 != false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004d, code lost:
        if ((r7 instanceof com.google.android.recaptcha.internal.zzjj) == false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004f, code lost:
        r5.zzd = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0051, code lost:
        r5.zza.zze(r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0056, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0085, code lost:
        throw new java.lang.IllegalArgumentException(java.lang.String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new java.lang.Object[]{java.lang.Integer.valueOf(r6.zza()), r6.zzd().zza(), r7.getClass().getName()}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0023, code lost:
        if ((r7 instanceof com.google.android.recaptcha.internal.zzjj) == false) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002c, code lost:
        if ((r7 instanceof com.google.android.recaptcha.internal.zziv) == false) goto L_0x0057;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(com.google.android.recaptcha.internal.zzii r6, java.lang.Object r7) {
        /*
            r5 = this;
            r6.zzg()
            com.google.android.recaptcha.internal.zzmb r0 = r6.zzd()
            byte[] r1 = com.google.android.recaptcha.internal.zzjc.zzd
            r7.getClass()
            com.google.android.recaptcha.internal.zzmb r1 = com.google.android.recaptcha.internal.zzmb.DOUBLE
            com.google.android.recaptcha.internal.zzmc r1 = com.google.android.recaptcha.internal.zzmc.INT
            com.google.android.recaptcha.internal.zzmc r0 = r0.zza()
            int r0 = r0.ordinal()
            r1 = 1
            switch(r0) {
                case 0: goto L_0x0047;
                case 1: goto L_0x0044;
                case 2: goto L_0x0041;
                case 3: goto L_0x003e;
                case 4: goto L_0x003b;
                case 5: goto L_0x0038;
                case 6: goto L_0x002f;
                case 7: goto L_0x0026;
                case 8: goto L_0x001d;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x0057
        L_0x001d:
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzke
            if (r0 != 0) goto L_0x004b
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzjj
            if (r0 == 0) goto L_0x0057
            goto L_0x004b
        L_0x0026:
            boolean r0 = r7 instanceof java.lang.Integer
            if (r0 != 0) goto L_0x004b
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zziv
            if (r0 == 0) goto L_0x0057
            goto L_0x004b
        L_0x002f:
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzgw
            if (r0 != 0) goto L_0x004b
            boolean r0 = r7 instanceof byte[]
            if (r0 == 0) goto L_0x0057
            goto L_0x004b
        L_0x0038:
            boolean r0 = r7 instanceof java.lang.String
            goto L_0x0049
        L_0x003b:
            boolean r0 = r7 instanceof java.lang.Boolean
            goto L_0x0049
        L_0x003e:
            boolean r0 = r7 instanceof java.lang.Double
            goto L_0x0049
        L_0x0041:
            boolean r0 = r7 instanceof java.lang.Float
            goto L_0x0049
        L_0x0044:
            boolean r0 = r7 instanceof java.lang.Long
            goto L_0x0049
        L_0x0047:
            boolean r0 = r7 instanceof java.lang.Integer
        L_0x0049:
            if (r0 == 0) goto L_0x0057
        L_0x004b:
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzjj
            if (r0 == 0) goto L_0x0051
            r5.zzd = r1
        L_0x0051:
            com.google.android.recaptcha.internal.zzle r0 = r5.zza
            r0.put(r6, r7)
            return
        L_0x0057:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            int r4 = r6.zza()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2[r3] = r4
            com.google.android.recaptcha.internal.zzmb r6 = r6.zzd()
            com.google.android.recaptcha.internal.zzmc r6 = r6.zza()
            r2[r1] = r6
            r6 = 2
            java.lang.Class r7 = r7.getClass()
            java.lang.String r7 = r7.getName()
            r2[r6] = r7
            java.lang.String r6 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r6 = java.lang.String.format(r6, r2)
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzij.zzi(com.google.android.recaptcha.internal.zzii, java.lang.Object):void");
    }

    public final boolean zzj() {
        return this.zzc;
    }

    public final boolean zzk() {
        for (int i = 0; i < this.zza.zzb(); i++) {
            if (!zzn(this.zza.zzg(i))) {
                return false;
            }
        }
        for (Map.Entry zzn : this.zza.zzc()) {
            if (!zzn(zzn)) {
                return false;
            }
        }
        return true;
    }

    private zzij(boolean z) {
        zzg();
        zzg();
    }
}
