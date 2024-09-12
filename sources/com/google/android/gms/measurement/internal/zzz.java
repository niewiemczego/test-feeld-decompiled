package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzew;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzz extends zzac {
    private zzew.zzb zzg;
    private final /* synthetic */ zzt zzh;

    /* access modifiers changed from: package-private */
    public final int zza() {
        return this.zzg.zzb();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzz(zzt zzt, String str, int i, zzew.zzb zzb) {
        super(str, i);
        this.zzh = zzt;
        this.zzg = zzb;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb() {
        return this.zzg.zzk();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x010f, code lost:
        if (r6.booleanValue() == false) goto L_0x03a3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x03af  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x03b2  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x03ba A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x03bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(java.lang.Long r18, java.lang.Long r19, com.google.android.gms.internal.measurement.zzfi.zze r20, long r21, com.google.android.gms.measurement.internal.zzbc r23, boolean r24) {
        /*
            r17 = this;
            r0 = r17
            boolean r1 = com.google.android.gms.internal.measurement.zzob.zza()
            r2 = 1
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            r4 = 0
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r4)
            if (r1 == 0) goto L_0x0024
            com.google.android.gms.measurement.internal.zzt r1 = r0.zzh
            com.google.android.gms.measurement.internal.zzaf r1 = r1.zze()
            java.lang.String r6 = r0.zza
            com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbi.zzbg
            boolean r1 = r1.zzf(r6, r7)
            if (r1 == 0) goto L_0x0024
            r1 = r2
            goto L_0x0025
        L_0x0024:
            r1 = r4
        L_0x0025:
            com.google.android.gms.internal.measurement.zzew$zzb r6 = r0.zzg
            boolean r6 = r6.zzj()
            if (r6 == 0) goto L_0x0032
            r6 = r23
            long r6 = r6.zze
            goto L_0x0034
        L_0x0032:
            r6 = r21
        L_0x0034:
            com.google.android.gms.measurement.internal.zzt r8 = r0.zzh
            com.google.android.gms.measurement.internal.zzfr r8 = r8.zzj()
            r9 = 2
            boolean r8 = r8.zza((int) r9)
            r9 = 0
            if (r8 == 0) goto L_0x0096
            com.google.android.gms.measurement.internal.zzt r8 = r0.zzh
            com.google.android.gms.measurement.internal.zzfr r8 = r8.zzj()
            com.google.android.gms.measurement.internal.zzft r8 = r8.zzp()
            int r10 = r0.zzb
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            com.google.android.gms.internal.measurement.zzew$zzb r11 = r0.zzg
            boolean r11 = r11.zzl()
            if (r11 == 0) goto L_0x0065
            com.google.android.gms.internal.measurement.zzew$zzb r11 = r0.zzg
            int r11 = r11.zzb()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            goto L_0x0066
        L_0x0065:
            r11 = r9
        L_0x0066:
            com.google.android.gms.measurement.internal.zzt r12 = r0.zzh
            com.google.android.gms.measurement.internal.zzfq r12 = r12.zzi()
            com.google.android.gms.internal.measurement.zzew$zzb r13 = r0.zzg
            java.lang.String r13 = r13.zzf()
            java.lang.String r12 = r12.zza((java.lang.String) r13)
            java.lang.String r13 = "Evaluating filter. audience, filter, event"
            r8.zza(r13, r10, r11, r12)
            com.google.android.gms.measurement.internal.zzt r8 = r0.zzh
            com.google.android.gms.measurement.internal.zzfr r8 = r8.zzj()
            com.google.android.gms.measurement.internal.zzft r8 = r8.zzp()
            com.google.android.gms.measurement.internal.zzt r10 = r0.zzh
            com.google.android.gms.measurement.internal.zzmz r10 = r10.g_()
            com.google.android.gms.internal.measurement.zzew$zzb r11 = r0.zzg
            java.lang.String r10 = r10.zza((com.google.android.gms.internal.measurement.zzew.zzb) r11)
            java.lang.String r11 = "Filter definition"
            r8.zza(r11, r10)
        L_0x0096:
            com.google.android.gms.internal.measurement.zzew$zzb r8 = r0.zzg
            boolean r8 = r8.zzl()
            if (r8 == 0) goto L_0x03fc
            com.google.android.gms.internal.measurement.zzew$zzb r8 = r0.zzg
            int r8 = r8.zzb()
            r10 = 256(0x100, float:3.59E-43)
            if (r8 <= r10) goto L_0x00aa
            goto L_0x03fc
        L_0x00aa:
            com.google.android.gms.internal.measurement.zzew$zzb r8 = r0.zzg
            boolean r8 = r8.zzh()
            com.google.android.gms.internal.measurement.zzew$zzb r10 = r0.zzg
            boolean r10 = r10.zzi()
            com.google.android.gms.internal.measurement.zzew$zzb r11 = r0.zzg
            boolean r11 = r11.zzj()
            if (r8 != 0) goto L_0x00c5
            if (r10 != 0) goto L_0x00c5
            if (r11 == 0) goto L_0x00c3
            goto L_0x00c5
        L_0x00c3:
            r8 = r4
            goto L_0x00c6
        L_0x00c5:
            r8 = r2
        L_0x00c6:
            if (r24 == 0) goto L_0x00f2
            if (r8 != 0) goto L_0x00f2
            com.google.android.gms.measurement.internal.zzt r1 = r0.zzh
            com.google.android.gms.measurement.internal.zzfr r1 = r1.zzj()
            com.google.android.gms.measurement.internal.zzft r1 = r1.zzp()
            int r3 = r0.zzb
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            com.google.android.gms.internal.measurement.zzew$zzb r4 = r0.zzg
            boolean r4 = r4.zzl()
            if (r4 == 0) goto L_0x00ec
            com.google.android.gms.internal.measurement.zzew$zzb r4 = r0.zzg
            int r4 = r4.zzb()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r4)
        L_0x00ec:
            java.lang.String r4 = "Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r1.zza(r4, r3, r9)
            return r2
        L_0x00f2:
            com.google.android.gms.internal.measurement.zzew$zzb r10 = r0.zzg
            java.lang.String r11 = r20.zzg()
            boolean r12 = r10.zzk()
            if (r12 == 0) goto L_0x0113
            com.google.android.gms.internal.measurement.zzew$zzd r12 = r10.zze()
            java.lang.Boolean r6 = zza((long) r6, (com.google.android.gms.internal.measurement.zzew.zzd) r12)
            if (r6 != 0) goto L_0x010b
        L_0x0108:
            r5 = r9
            goto L_0x03a3
        L_0x010b:
            boolean r6 = r6.booleanValue()
            if (r6 != 0) goto L_0x0113
            goto L_0x03a3
        L_0x0113:
            java.util.HashSet r6 = new java.util.HashSet
            r6.<init>()
            java.util.List r7 = r10.zzg()
            java.util.Iterator r7 = r7.iterator()
        L_0x0120:
            boolean r12 = r7.hasNext()
            if (r12 == 0) goto L_0x0158
            java.lang.Object r12 = r7.next()
            com.google.android.gms.internal.measurement.zzew$zzc r12 = (com.google.android.gms.internal.measurement.zzew.zzc) r12
            java.lang.String r13 = r12.zze()
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto L_0x0150
            com.google.android.gms.measurement.internal.zzt r5 = r0.zzh
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzj()
            com.google.android.gms.measurement.internal.zzft r5 = r5.zzu()
            com.google.android.gms.measurement.internal.zzt r6 = r0.zzh
            com.google.android.gms.measurement.internal.zzfq r6 = r6.zzi()
            java.lang.String r6 = r6.zza((java.lang.String) r11)
            java.lang.String r7 = "null or empty param name in filter. event"
            r5.zza(r7, r6)
            goto L_0x0108
        L_0x0150:
            java.lang.String r12 = r12.zze()
            r6.add(r12)
            goto L_0x0120
        L_0x0158:
            androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap
            r7.<init>()
            java.util.List r12 = r20.zzh()
            java.util.Iterator r12 = r12.iterator()
        L_0x0165:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x01f2
            java.lang.Object r13 = r12.next()
            com.google.android.gms.internal.measurement.zzfi$zzg r13 = (com.google.android.gms.internal.measurement.zzfi.zzg) r13
            java.lang.String r14 = r13.zzg()
            boolean r14 = r6.contains(r14)
            if (r14 == 0) goto L_0x0165
            boolean r14 = r13.zzl()
            if (r14 == 0) goto L_0x0199
            java.lang.String r14 = r13.zzg()
            boolean r15 = r13.zzl()
            if (r15 == 0) goto L_0x0194
            long r15 = r13.zzd()
            java.lang.Long r13 = java.lang.Long.valueOf(r15)
            goto L_0x0195
        L_0x0194:
            r13 = r9
        L_0x0195:
            r7.put(r14, r13)
            goto L_0x0165
        L_0x0199:
            boolean r14 = r13.zzj()
            if (r14 == 0) goto L_0x01b7
            java.lang.String r14 = r13.zzg()
            boolean r15 = r13.zzj()
            if (r15 == 0) goto L_0x01b2
            double r15 = r13.zza()
            java.lang.Double r13 = java.lang.Double.valueOf(r15)
            goto L_0x01b3
        L_0x01b2:
            r13 = r9
        L_0x01b3:
            r7.put(r14, r13)
            goto L_0x0165
        L_0x01b7:
            boolean r14 = r13.zzn()
            if (r14 == 0) goto L_0x01c9
            java.lang.String r14 = r13.zzg()
            java.lang.String r13 = r13.zzh()
            r7.put(r14, r13)
            goto L_0x0165
        L_0x01c9:
            com.google.android.gms.measurement.internal.zzt r5 = r0.zzh
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzj()
            com.google.android.gms.measurement.internal.zzft r5 = r5.zzu()
            com.google.android.gms.measurement.internal.zzt r6 = r0.zzh
            com.google.android.gms.measurement.internal.zzfq r6 = r6.zzi()
            java.lang.String r6 = r6.zza((java.lang.String) r11)
            com.google.android.gms.measurement.internal.zzt r7 = r0.zzh
            com.google.android.gms.measurement.internal.zzfq r7 = r7.zzi()
            java.lang.String r10 = r13.zzg()
            java.lang.String r7 = r7.zzb(r10)
            java.lang.String r10 = "Unknown value for param. event, param"
            r5.zza(r10, r6, r7)
            goto L_0x0108
        L_0x01f2:
            java.util.List r6 = r10.zzg()
            java.util.Iterator r6 = r6.iterator()
        L_0x01fa:
            boolean r10 = r6.hasNext()
            if (r10 == 0) goto L_0x03a2
            java.lang.Object r10 = r6.next()
            com.google.android.gms.internal.measurement.zzew$zzc r10 = (com.google.android.gms.internal.measurement.zzew.zzc) r10
            boolean r12 = r10.zzg()
            if (r12 == 0) goto L_0x0214
            boolean r12 = r10.zzf()
            if (r12 == 0) goto L_0x0214
            r12 = r2
            goto L_0x0215
        L_0x0214:
            r12 = r4
        L_0x0215:
            java.lang.String r13 = r10.zze()
            boolean r14 = r13.isEmpty()
            if (r14 == 0) goto L_0x023a
            com.google.android.gms.measurement.internal.zzt r5 = r0.zzh
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzj()
            com.google.android.gms.measurement.internal.zzft r5 = r5.zzu()
            com.google.android.gms.measurement.internal.zzt r6 = r0.zzh
            com.google.android.gms.measurement.internal.zzfq r6 = r6.zzi()
            java.lang.String r6 = r6.zza((java.lang.String) r11)
            java.lang.String r7 = "Event has empty param name. event"
            r5.zza(r7, r6)
            goto L_0x0108
        L_0x023a:
            java.lang.Object r14 = r7.get(r13)
            boolean r15 = r14 instanceof java.lang.Long
            if (r15 == 0) goto L_0x0287
            boolean r15 = r10.zzh()
            if (r15 != 0) goto L_0x026d
            com.google.android.gms.measurement.internal.zzt r5 = r0.zzh
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzj()
            com.google.android.gms.measurement.internal.zzft r5 = r5.zzu()
            com.google.android.gms.measurement.internal.zzt r6 = r0.zzh
            com.google.android.gms.measurement.internal.zzfq r6 = r6.zzi()
            java.lang.String r6 = r6.zza((java.lang.String) r11)
            com.google.android.gms.measurement.internal.zzt r7 = r0.zzh
            com.google.android.gms.measurement.internal.zzfq r7 = r7.zzi()
            java.lang.String r7 = r7.zzb(r13)
            java.lang.String r10 = "No number filter for long param. event, param"
            r5.zza(r10, r6, r7)
            goto L_0x0108
        L_0x026d:
            java.lang.Long r14 = (java.lang.Long) r14
            long r13 = r14.longValue()
            com.google.android.gms.internal.measurement.zzew$zzd r10 = r10.zzc()
            java.lang.Boolean r10 = zza((long) r13, (com.google.android.gms.internal.measurement.zzew.zzd) r10)
            if (r10 != 0) goto L_0x027f
            goto L_0x0108
        L_0x027f:
            boolean r10 = r10.booleanValue()
            if (r10 != r12) goto L_0x01fa
            goto L_0x03a3
        L_0x0287:
            boolean r15 = r14 instanceof java.lang.Double
            if (r15 == 0) goto L_0x02d0
            boolean r15 = r10.zzh()
            if (r15 != 0) goto L_0x02b6
            com.google.android.gms.measurement.internal.zzt r5 = r0.zzh
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzj()
            com.google.android.gms.measurement.internal.zzft r5 = r5.zzu()
            com.google.android.gms.measurement.internal.zzt r6 = r0.zzh
            com.google.android.gms.measurement.internal.zzfq r6 = r6.zzi()
            java.lang.String r6 = r6.zza((java.lang.String) r11)
            com.google.android.gms.measurement.internal.zzt r7 = r0.zzh
            com.google.android.gms.measurement.internal.zzfq r7 = r7.zzi()
            java.lang.String r7 = r7.zzb(r13)
            java.lang.String r10 = "No number filter for double param. event, param"
            r5.zza(r10, r6, r7)
            goto L_0x0108
        L_0x02b6:
            java.lang.Double r14 = (java.lang.Double) r14
            double r13 = r14.doubleValue()
            com.google.android.gms.internal.measurement.zzew$zzd r10 = r10.zzc()
            java.lang.Boolean r10 = zza((double) r13, (com.google.android.gms.internal.measurement.zzew.zzd) r10)
            if (r10 != 0) goto L_0x02c8
            goto L_0x0108
        L_0x02c8:
            boolean r10 = r10.booleanValue()
            if (r10 != r12) goto L_0x01fa
            goto L_0x03a3
        L_0x02d0:
            boolean r15 = r14 instanceof java.lang.String
            if (r15 == 0) goto L_0x0357
            boolean r15 = r10.zzj()
            if (r15 == 0) goto L_0x02eb
            java.lang.String r14 = (java.lang.String) r14
            com.google.android.gms.internal.measurement.zzew$zzf r10 = r10.zzd()
            com.google.android.gms.measurement.internal.zzt r13 = r0.zzh
            com.google.android.gms.measurement.internal.zzfr r13 = r13.zzj()
            java.lang.Boolean r10 = zza((java.lang.String) r14, (com.google.android.gms.internal.measurement.zzew.zzf) r10, (com.google.android.gms.measurement.internal.zzfr) r13)
            goto L_0x0301
        L_0x02eb:
            boolean r15 = r10.zzh()
            if (r15 == 0) goto L_0x0332
            java.lang.String r14 = (java.lang.String) r14
            boolean r15 = com.google.android.gms.measurement.internal.zzmz.zzb((java.lang.String) r14)
            if (r15 == 0) goto L_0x030d
            com.google.android.gms.internal.measurement.zzew$zzd r10 = r10.zzc()
            java.lang.Boolean r10 = zza((java.lang.String) r14, (com.google.android.gms.internal.measurement.zzew.zzd) r10)
        L_0x0301:
            if (r10 != 0) goto L_0x0305
            goto L_0x0108
        L_0x0305:
            boolean r10 = r10.booleanValue()
            if (r10 != r12) goto L_0x01fa
            goto L_0x03a3
        L_0x030d:
            com.google.android.gms.measurement.internal.zzt r5 = r0.zzh
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzj()
            com.google.android.gms.measurement.internal.zzft r5 = r5.zzu()
            com.google.android.gms.measurement.internal.zzt r6 = r0.zzh
            com.google.android.gms.measurement.internal.zzfq r6 = r6.zzi()
            java.lang.String r6 = r6.zza((java.lang.String) r11)
            com.google.android.gms.measurement.internal.zzt r7 = r0.zzh
            com.google.android.gms.measurement.internal.zzfq r7 = r7.zzi()
            java.lang.String r7 = r7.zzb(r13)
            java.lang.String r10 = "Invalid param value for number filter. event, param"
            r5.zza(r10, r6, r7)
            goto L_0x0108
        L_0x0332:
            com.google.android.gms.measurement.internal.zzt r5 = r0.zzh
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzj()
            com.google.android.gms.measurement.internal.zzft r5 = r5.zzu()
            com.google.android.gms.measurement.internal.zzt r6 = r0.zzh
            com.google.android.gms.measurement.internal.zzfq r6 = r6.zzi()
            java.lang.String r6 = r6.zza((java.lang.String) r11)
            com.google.android.gms.measurement.internal.zzt r7 = r0.zzh
            com.google.android.gms.measurement.internal.zzfq r7 = r7.zzi()
            java.lang.String r7 = r7.zzb(r13)
            java.lang.String r10 = "No filter for String param. event, param"
            r5.zza(r10, r6, r7)
            goto L_0x0108
        L_0x0357:
            if (r14 != 0) goto L_0x037d
            com.google.android.gms.measurement.internal.zzt r6 = r0.zzh
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzj()
            com.google.android.gms.measurement.internal.zzft r6 = r6.zzp()
            com.google.android.gms.measurement.internal.zzt r7 = r0.zzh
            com.google.android.gms.measurement.internal.zzfq r7 = r7.zzi()
            java.lang.String r7 = r7.zza((java.lang.String) r11)
            com.google.android.gms.measurement.internal.zzt r9 = r0.zzh
            com.google.android.gms.measurement.internal.zzfq r9 = r9.zzi()
            java.lang.String r9 = r9.zzb(r13)
            java.lang.String r10 = "Missing param for filter. event, param"
            r6.zza(r10, r7, r9)
            goto L_0x03a3
        L_0x037d:
            com.google.android.gms.measurement.internal.zzt r5 = r0.zzh
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzj()
            com.google.android.gms.measurement.internal.zzft r5 = r5.zzu()
            com.google.android.gms.measurement.internal.zzt r6 = r0.zzh
            com.google.android.gms.measurement.internal.zzfq r6 = r6.zzi()
            java.lang.String r6 = r6.zza((java.lang.String) r11)
            com.google.android.gms.measurement.internal.zzt r7 = r0.zzh
            com.google.android.gms.measurement.internal.zzfq r7 = r7.zzi()
            java.lang.String r7 = r7.zzb(r13)
            java.lang.String r10 = "Unknown param type. event, param"
            r5.zza(r10, r6, r7)
            goto L_0x0108
        L_0x03a2:
            r5 = r3
        L_0x03a3:
            com.google.android.gms.measurement.internal.zzt r6 = r0.zzh
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzj()
            com.google.android.gms.measurement.internal.zzft r6 = r6.zzp()
            if (r5 != 0) goto L_0x03b2
            java.lang.String r7 = "null"
            goto L_0x03b3
        L_0x03b2:
            r7 = r5
        L_0x03b3:
            java.lang.String r9 = "Event filter result"
            r6.zza(r9, r7)
            if (r5 != 0) goto L_0x03bb
            return r4
        L_0x03bb:
            r0.zzc = r3
            boolean r4 = r5.booleanValue()
            if (r4 != 0) goto L_0x03c4
            return r2
        L_0x03c4:
            r0.zzd = r3
            if (r8 == 0) goto L_0x03fb
            boolean r3 = r20.zzk()
            if (r3 == 0) goto L_0x03fb
            long r3 = r20.zzd()
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            com.google.android.gms.internal.measurement.zzew$zzb r4 = r0.zzg
            boolean r4 = r4.zzi()
            if (r4 == 0) goto L_0x03ed
            if (r1 == 0) goto L_0x03ea
            com.google.android.gms.internal.measurement.zzew$zzb r1 = r0.zzg
            boolean r1 = r1.zzk()
            if (r1 == 0) goto L_0x03ea
            r3 = r18
        L_0x03ea:
            r0.zzf = r3
            goto L_0x03fb
        L_0x03ed:
            if (r1 == 0) goto L_0x03f9
            com.google.android.gms.internal.measurement.zzew$zzb r1 = r0.zzg
            boolean r1 = r1.zzk()
            if (r1 == 0) goto L_0x03f9
            r3 = r19
        L_0x03f9:
            r0.zze = r3
        L_0x03fb:
            return r2
        L_0x03fc:
            com.google.android.gms.measurement.internal.zzt r1 = r0.zzh
            com.google.android.gms.measurement.internal.zzfr r1 = r1.zzj()
            com.google.android.gms.measurement.internal.zzft r1 = r1.zzu()
            java.lang.String r2 = r0.zza
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzfr.zza((java.lang.String) r2)
            com.google.android.gms.internal.measurement.zzew$zzb r3 = r0.zzg
            boolean r3 = r3.zzl()
            if (r3 == 0) goto L_0x041e
            com.google.android.gms.internal.measurement.zzew$zzb r3 = r0.zzg
            int r3 = r3.zzb()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
        L_0x041e:
            java.lang.String r3 = java.lang.String.valueOf(r9)
            java.lang.String r5 = "Invalid event filter ID. appId, id"
            r1.zza(r5, r2, r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzz.zza(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.zzfi$zze, long, com.google.android.gms.measurement.internal.zzbc, boolean):boolean");
    }
}
