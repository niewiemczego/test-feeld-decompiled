package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzew;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzab extends zzac {
    private zzew.zze zzg;
    private final /* synthetic */ zzt zzh;

    /* access modifiers changed from: package-private */
    public final int zza() {
        return this.zzg.zza();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc() {
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzab(zzt zzt, String str, int i, zzew.zze zze) {
        super(str, i);
        this.zzh = zzt;
        this.zzg = zze;
    }

    /* JADX WARNING: type inference failed for: r4v17, types: [java.lang.Integer] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(java.lang.Long r11, java.lang.Long r12, com.google.android.gms.internal.measurement.zzfi.zzn r13, boolean r14) {
        /*
            r10 = this;
            boolean r0 = com.google.android.gms.internal.measurement.zzob.zza()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001a
            com.google.android.gms.measurement.internal.zzt r0 = r10.zzh
            com.google.android.gms.measurement.internal.zzaf r0 = r0.zze()
            java.lang.String r3 = r10.zza
            com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzbi.zzbe
            boolean r0 = r0.zzf(r3, r4)
            if (r0 == 0) goto L_0x001a
            r0 = r2
            goto L_0x001b
        L_0x001a:
            r0 = r1
        L_0x001b:
            com.google.android.gms.internal.measurement.zzew$zze r3 = r10.zzg
            boolean r3 = r3.zzf()
            com.google.android.gms.internal.measurement.zzew$zze r4 = r10.zzg
            boolean r4 = r4.zzg()
            com.google.android.gms.internal.measurement.zzew$zze r5 = r10.zzg
            boolean r5 = r5.zzh()
            if (r3 != 0) goto L_0x0036
            if (r4 != 0) goto L_0x0036
            if (r5 == 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r3 = r1
            goto L_0x0037
        L_0x0036:
            r3 = r2
        L_0x0037:
            r4 = 0
            if (r14 == 0) goto L_0x0064
            if (r3 != 0) goto L_0x0064
            com.google.android.gms.measurement.internal.zzt r11 = r10.zzh
            com.google.android.gms.measurement.internal.zzfr r11 = r11.zzj()
            com.google.android.gms.measurement.internal.zzft r11 = r11.zzp()
            int r12 = r10.zzb
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            com.google.android.gms.internal.measurement.zzew$zze r13 = r10.zzg
            boolean r13 = r13.zzi()
            if (r13 == 0) goto L_0x005e
            com.google.android.gms.internal.measurement.zzew$zze r13 = r10.zzg
            int r13 = r13.zza()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r13)
        L_0x005e:
            java.lang.String r13 = "Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r11.zza(r13, r12, r4)
            return r2
        L_0x0064:
            com.google.android.gms.internal.measurement.zzew$zze r6 = r10.zzg
            com.google.android.gms.internal.measurement.zzew$zzc r6 = r6.zzb()
            boolean r7 = r6.zzf()
            boolean r8 = r13.zzk()
            if (r8 == 0) goto L_0x00ab
            boolean r8 = r6.zzh()
            if (r8 != 0) goto L_0x0099
            com.google.android.gms.measurement.internal.zzt r6 = r10.zzh
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzj()
            com.google.android.gms.measurement.internal.zzft r6 = r6.zzu()
            com.google.android.gms.measurement.internal.zzt r7 = r10.zzh
            com.google.android.gms.measurement.internal.zzfq r7 = r7.zzi()
            java.lang.String r8 = r13.zzg()
            java.lang.String r7 = r7.zzc(r8)
            java.lang.String r8 = "No number filter for long property. property"
            r6.zza(r8, r7)
            goto L_0x0189
        L_0x0099:
            long r8 = r13.zzc()
            com.google.android.gms.internal.measurement.zzew$zzd r4 = r6.zzc()
            java.lang.Boolean r4 = zza((long) r8, (com.google.android.gms.internal.measurement.zzew.zzd) r4)
            java.lang.Boolean r4 = zza((java.lang.Boolean) r4, (boolean) r7)
            goto L_0x0189
        L_0x00ab:
            boolean r8 = r13.zzi()
            if (r8 == 0) goto L_0x00e8
            boolean r8 = r6.zzh()
            if (r8 != 0) goto L_0x00d6
            com.google.android.gms.measurement.internal.zzt r6 = r10.zzh
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzj()
            com.google.android.gms.measurement.internal.zzft r6 = r6.zzu()
            com.google.android.gms.measurement.internal.zzt r7 = r10.zzh
            com.google.android.gms.measurement.internal.zzfq r7 = r7.zzi()
            java.lang.String r8 = r13.zzg()
            java.lang.String r7 = r7.zzc(r8)
            java.lang.String r8 = "No number filter for double property. property"
            r6.zza(r8, r7)
            goto L_0x0189
        L_0x00d6:
            double r8 = r13.zza()
            com.google.android.gms.internal.measurement.zzew$zzd r4 = r6.zzc()
            java.lang.Boolean r4 = zza((double) r8, (com.google.android.gms.internal.measurement.zzew.zzd) r4)
            java.lang.Boolean r4 = zza((java.lang.Boolean) r4, (boolean) r7)
            goto L_0x0189
        L_0x00e8:
            boolean r8 = r13.zzm()
            if (r8 == 0) goto L_0x016c
            boolean r8 = r6.zzj()
            if (r8 != 0) goto L_0x0155
            boolean r8 = r6.zzh()
            if (r8 != 0) goto L_0x0118
            com.google.android.gms.measurement.internal.zzt r6 = r10.zzh
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzj()
            com.google.android.gms.measurement.internal.zzft r6 = r6.zzu()
            com.google.android.gms.measurement.internal.zzt r7 = r10.zzh
            com.google.android.gms.measurement.internal.zzfq r7 = r7.zzi()
            java.lang.String r8 = r13.zzg()
            java.lang.String r7 = r7.zzc(r8)
            java.lang.String r8 = "No string or number filter defined. property"
            r6.zza(r8, r7)
            goto L_0x0189
        L_0x0118:
            java.lang.String r8 = r13.zzh()
            boolean r8 = com.google.android.gms.measurement.internal.zzmz.zzb((java.lang.String) r8)
            if (r8 == 0) goto L_0x0133
            java.lang.String r4 = r13.zzh()
            com.google.android.gms.internal.measurement.zzew$zzd r6 = r6.zzc()
            java.lang.Boolean r4 = zza((java.lang.String) r4, (com.google.android.gms.internal.measurement.zzew.zzd) r6)
            java.lang.Boolean r4 = zza((java.lang.Boolean) r4, (boolean) r7)
            goto L_0x0189
        L_0x0133:
            com.google.android.gms.measurement.internal.zzt r6 = r10.zzh
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzj()
            com.google.android.gms.measurement.internal.zzft r6 = r6.zzu()
            com.google.android.gms.measurement.internal.zzt r7 = r10.zzh
            com.google.android.gms.measurement.internal.zzfq r7 = r7.zzi()
            java.lang.String r8 = r13.zzg()
            java.lang.String r7 = r7.zzc(r8)
            java.lang.String r8 = r13.zzh()
            java.lang.String r9 = "Invalid user property value for Numeric number filter. property, value"
            r6.zza(r9, r7, r8)
            goto L_0x0189
        L_0x0155:
            java.lang.String r4 = r13.zzh()
            com.google.android.gms.internal.measurement.zzew$zzf r6 = r6.zzd()
            com.google.android.gms.measurement.internal.zzt r8 = r10.zzh
            com.google.android.gms.measurement.internal.zzfr r8 = r8.zzj()
            java.lang.Boolean r4 = zza((java.lang.String) r4, (com.google.android.gms.internal.measurement.zzew.zzf) r6, (com.google.android.gms.measurement.internal.zzfr) r8)
            java.lang.Boolean r4 = zza((java.lang.Boolean) r4, (boolean) r7)
            goto L_0x0189
        L_0x016c:
            com.google.android.gms.measurement.internal.zzt r6 = r10.zzh
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzj()
            com.google.android.gms.measurement.internal.zzft r6 = r6.zzu()
            com.google.android.gms.measurement.internal.zzt r7 = r10.zzh
            com.google.android.gms.measurement.internal.zzfq r7 = r7.zzi()
            java.lang.String r8 = r13.zzg()
            java.lang.String r7 = r7.zzc(r8)
            java.lang.String r8 = "User property has no value, property"
            r6.zza(r8, r7)
        L_0x0189:
            com.google.android.gms.measurement.internal.zzt r6 = r10.zzh
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzj()
            com.google.android.gms.measurement.internal.zzft r6 = r6.zzp()
            if (r4 != 0) goto L_0x0198
            java.lang.String r7 = "null"
            goto L_0x0199
        L_0x0198:
            r7 = r4
        L_0x0199:
            java.lang.String r8 = "Property filter result"
            r6.zza(r8, r7)
            if (r4 != 0) goto L_0x01a1
            return r1
        L_0x01a1:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r2)
            r10.zzc = r1
            if (r5 == 0) goto L_0x01b0
            boolean r1 = r4.booleanValue()
            if (r1 != 0) goto L_0x01b0
            return r2
        L_0x01b0:
            if (r14 == 0) goto L_0x01ba
            com.google.android.gms.internal.measurement.zzew$zze r14 = r10.zzg
            boolean r14 = r14.zzf()
            if (r14 == 0) goto L_0x01bc
        L_0x01ba:
            r10.zzd = r4
        L_0x01bc:
            boolean r14 = r4.booleanValue()
            if (r14 == 0) goto L_0x0201
            if (r3 == 0) goto L_0x0201
            boolean r14 = r13.zzl()
            if (r14 == 0) goto L_0x0201
            long r13 = r13.zzd()
            if (r11 == 0) goto L_0x01d4
            long r13 = r11.longValue()
        L_0x01d4:
            if (r0 == 0) goto L_0x01ec
            com.google.android.gms.internal.measurement.zzew$zze r11 = r10.zzg
            boolean r11 = r11.zzf()
            if (r11 == 0) goto L_0x01ec
            com.google.android.gms.internal.measurement.zzew$zze r11 = r10.zzg
            boolean r11 = r11.zzg()
            if (r11 != 0) goto L_0x01ec
            if (r12 == 0) goto L_0x01ec
            long r13 = r12.longValue()
        L_0x01ec:
            com.google.android.gms.internal.measurement.zzew$zze r11 = r10.zzg
            boolean r11 = r11.zzg()
            if (r11 == 0) goto L_0x01fb
            java.lang.Long r11 = java.lang.Long.valueOf(r13)
            r10.zzf = r11
            goto L_0x0201
        L_0x01fb:
            java.lang.Long r11 = java.lang.Long.valueOf(r13)
            r10.zze = r11
        L_0x0201:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.zza(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.zzfi$zzn, boolean):boolean");
    }
}
