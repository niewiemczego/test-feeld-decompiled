package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzbe {
    private static zzaf zza(zzaf zzaf, zzh zzh, zzal zzal, Boolean bool, Boolean bool2) {
        zzaf zzaf2 = new zzaf();
        Iterator<Integer> zzg = zzaf.zzg();
        while (zzg.hasNext()) {
            int intValue = zzg.next().intValue();
            if (zzaf.zzc(intValue)) {
                zzaq zza = zzal.zza(zzh, (List<zzaq>) Arrays.asList(new zzaq[]{zzaf.zza(intValue), new zzai(Double.valueOf((double) intValue)), zzaf}));
                if (zza.zzd().equals(bool)) {
                    return zzaf2;
                }
                if (bool2 == null || zza.zzd().equals(bool2)) {
                    zzaf2.zzb(intValue, zza);
                }
            }
        }
        return zzaf2;
    }

    private static zzaf zza(zzaf zzaf, zzh zzh, zzal zzal) {
        return zza(zzaf, zzh, zzal, (Boolean) null, (Boolean) null);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.measurement.zzaq zza(java.lang.String r20, com.google.android.gms.internal.measurement.zzaf r21, com.google.android.gms.internal.measurement.zzh r22, java.util.List<com.google.android.gms.internal.measurement.zzaq> r23) {
        /*
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r20.hashCode()
            int r4 = r20.hashCode()
            java.lang.String r5 = "reverse"
            java.lang.String r6 = "slice"
            java.lang.String r7 = "shift"
            java.lang.String r8 = "every"
            java.lang.String r9 = "sort"
            java.lang.String r10 = "some"
            java.lang.String r11 = "join"
            java.lang.String r12 = "pop"
            java.lang.String r13 = "map"
            java.lang.String r14 = "lastIndexOf"
            java.lang.String r15 = "forEach"
            java.lang.String r1 = "filter"
            java.lang.String r2 = "toString"
            r16 = -1
            r3 = 1
            r17 = r2
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r3)
            switch(r4) {
                case -1776922004: goto L_0x0116;
                case -1354795244: goto L_0x0108;
                case -1274492040: goto L_0x00fb;
                case -934873754: goto L_0x00ec;
                case -895859076: goto L_0x00de;
                case -678635926: goto L_0x00d2;
                case -467511597: goto L_0x00c6;
                case -277637751: goto L_0x00b8;
                case 107868: goto L_0x00ad;
                case 111185: goto L_0x00a3;
                case 3267882: goto L_0x0099;
                case 3452698: goto L_0x008d;
                case 3536116: goto L_0x0083;
                case 3536286: goto L_0x0079;
                case 96891675: goto L_0x006f;
                case 109407362: goto L_0x0065;
                case 109526418: goto L_0x005b;
                case 965561430: goto L_0x004f;
                case 1099846370: goto L_0x0045;
                case 1943291465: goto L_0x0039;
                default: goto L_0x0035;
            }
        L_0x0035:
            r4 = r17
            goto L_0x0121
        L_0x0039:
            java.lang.String r4 = "indexOf"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x0042
            goto L_0x0035
        L_0x0042:
            r16 = 19
            goto L_0x0035
        L_0x0045:
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x004c
            goto L_0x0035
        L_0x004c:
            r16 = 18
            goto L_0x0035
        L_0x004f:
            java.lang.String r4 = "reduceRight"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x0058
            goto L_0x0035
        L_0x0058:
            r16 = 17
            goto L_0x0035
        L_0x005b:
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L_0x0062
            goto L_0x0035
        L_0x0062:
            r16 = 16
            goto L_0x0035
        L_0x0065:
            boolean r0 = r0.equals(r7)
            if (r0 != 0) goto L_0x006c
            goto L_0x0035
        L_0x006c:
            r16 = 15
            goto L_0x0035
        L_0x006f:
            boolean r0 = r0.equals(r8)
            if (r0 != 0) goto L_0x0076
            goto L_0x0035
        L_0x0076:
            r16 = 14
            goto L_0x0035
        L_0x0079:
            boolean r0 = r0.equals(r9)
            if (r0 != 0) goto L_0x0080
            goto L_0x0035
        L_0x0080:
            r16 = 13
            goto L_0x0035
        L_0x0083:
            boolean r0 = r0.equals(r10)
            if (r0 != 0) goto L_0x008a
            goto L_0x0035
        L_0x008a:
            r16 = 12
            goto L_0x0035
        L_0x008d:
            java.lang.String r4 = "push"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x0096
            goto L_0x0035
        L_0x0096:
            r16 = 11
            goto L_0x0035
        L_0x0099:
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x00a0
            goto L_0x0035
        L_0x00a0:
            r16 = 10
            goto L_0x0035
        L_0x00a3:
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x00aa
            goto L_0x0035
        L_0x00aa:
            r16 = 9
            goto L_0x0035
        L_0x00ad:
            boolean r0 = r0.equals(r13)
            if (r0 != 0) goto L_0x00b4
            goto L_0x0035
        L_0x00b4:
            r16 = 8
            goto L_0x0035
        L_0x00b8:
            java.lang.String r4 = "unshift"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x00c2
            goto L_0x0035
        L_0x00c2:
            r16 = 7
            goto L_0x0035
        L_0x00c6:
            boolean r0 = r0.equals(r14)
            if (r0 != 0) goto L_0x00ce
            goto L_0x0035
        L_0x00ce:
            r16 = 6
            goto L_0x0035
        L_0x00d2:
            boolean r0 = r0.equals(r15)
            if (r0 != 0) goto L_0x00da
            goto L_0x0035
        L_0x00da:
            r16 = 5
            goto L_0x0035
        L_0x00de:
            java.lang.String r4 = "splice"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x00e8
            goto L_0x0035
        L_0x00e8:
            r16 = 4
            goto L_0x0035
        L_0x00ec:
            java.lang.String r4 = "reduce"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x00f6
            goto L_0x0035
        L_0x00f6:
            r4 = r17
            r16 = 3
            goto L_0x0121
        L_0x00fb:
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0103
            goto L_0x0035
        L_0x0103:
            r4 = r17
            r16 = 2
            goto L_0x0121
        L_0x0108:
            java.lang.String r4 = "concat"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x0112
            goto L_0x0035
        L_0x0112:
            r16 = r3
            goto L_0x0035
        L_0x0116:
            r4 = r17
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x011f
            goto L_0x0121
        L_0x011f:
            r16 = 0
        L_0x0121:
            r17 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            java.lang.String r0 = "Callback should be a method"
            r19 = r4
            r3 = 0
            switch(r16) {
                case 0: goto L_0x075c;
                case 1: goto L_0x06fa;
                case 2: goto L_0x06a0;
                case 3: goto L_0x0694;
                case 4: goto L_0x05d1;
                case 5: goto L_0x05a1;
                case 6: goto L_0x04ff;
                case 7: goto L_0x0473;
                case 8: goto L_0x0441;
                case 9: goto L_0x0426;
                case 10: goto L_0x03e5;
                case 11: goto L_0x03b2;
                case 12: goto L_0x033f;
                case 13: goto L_0x02e5;
                case 14: goto L_0x02a6;
                case 15: goto L_0x028d;
                case 16: goto L_0x020d;
                case 17: goto L_0x0201;
                case 18: goto L_0x01c9;
                case 19: goto L_0x0134;
                default: goto L_0x012c;
            }
        L_0x012c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Command not supported"
            r0.<init>(r1)
            throw r0
        L_0x0134:
            java.lang.String r0 = "indexOf"
            r15 = r23
            r1 = 2
            com.google.android.gms.internal.measurement.zzg.zzc(r0, r1, r15)
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzc
            boolean r1 = r23.isEmpty()
            if (r1 != 0) goto L_0x0152
            r1 = 0
            java.lang.Object r0 = r15.get(r1)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            r5 = r22
            com.google.android.gms.internal.measurement.zzaq r0 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            goto L_0x0154
        L_0x0152:
            r5 = r22
        L_0x0154:
            int r1 = r23.size()
            r2 = 1
            if (r1 <= r2) goto L_0x0190
            java.lang.Object r1 = r15.get(r2)
            com.google.android.gms.internal.measurement.zzaq r1 = (com.google.android.gms.internal.measurement.zzaq) r1
            com.google.android.gms.internal.measurement.zzaq r1 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r1)
            java.lang.Double r1 = r1.zze()
            double r1 = r1.doubleValue()
            double r1 = com.google.android.gms.internal.measurement.zzg.zza((double) r1)
            int r5 = r21.zzb()
            double r5 = (double) r5
            int r5 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r5 < 0) goto L_0x0184
            com.google.android.gms.internal.measurement.zzai r0 = new com.google.android.gms.internal.measurement.zzai
            java.lang.Double r1 = java.lang.Double.valueOf(r17)
            r0.<init>(r1)
            return r0
        L_0x0184:
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x018f
            int r3 = r21.zzb()
            double r3 = (double) r3
            double r3 = r3 + r1
            goto L_0x0190
        L_0x018f:
            r3 = r1
        L_0x0190:
            java.util.Iterator r1 = r21.zzg()
        L_0x0194:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01bf
            java.lang.Object r2 = r1.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            double r5 = (double) r2
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            r14 = r21
            if (r7 < 0) goto L_0x0194
            com.google.android.gms.internal.measurement.zzaq r2 = r14.zza((int) r2)
            boolean r2 = com.google.android.gms.internal.measurement.zzg.zza(r2, r0)
            if (r2 == 0) goto L_0x0194
            com.google.android.gms.internal.measurement.zzai r0 = new com.google.android.gms.internal.measurement.zzai
            java.lang.Double r1 = java.lang.Double.valueOf(r5)
            r0.<init>(r1)
            return r0
        L_0x01bf:
            com.google.android.gms.internal.measurement.zzai r0 = new com.google.android.gms.internal.measurement.zzai
            java.lang.Double r1 = java.lang.Double.valueOf(r17)
            r0.<init>(r1)
            return r0
        L_0x01c9:
            r14 = r21
            r15 = r23
            r0 = 0
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r5, (int) r0, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r15)
            int r0 = r21.zzb()
            if (r0 == 0) goto L_0x0200
            r3 = 0
        L_0x01d8:
            int r1 = r0 / 2
            if (r3 >= r1) goto L_0x0200
            boolean r1 = r14.zzc((int) r3)
            if (r1 == 0) goto L_0x01fd
            com.google.android.gms.internal.measurement.zzaq r1 = r14.zza((int) r3)
            r2 = 0
            r14.zzb(r3, r2)
            int r2 = r0 + -1
            int r2 = r2 - r3
            boolean r4 = r14.zzc((int) r2)
            if (r4 == 0) goto L_0x01fa
            com.google.android.gms.internal.measurement.zzaq r4 = r14.zza((int) r2)
            r14.zzb(r3, r4)
        L_0x01fa:
            r14.zzb(r2, r1)
        L_0x01fd:
            int r3 = r3 + 1
            goto L_0x01d8
        L_0x0200:
            return r14
        L_0x0201:
            r14 = r21
            r5 = r22
            r15 = r23
            r0 = 0
            com.google.android.gms.internal.measurement.zzaq r0 = zza((com.google.android.gms.internal.measurement.zzaf) r14, (com.google.android.gms.internal.measurement.zzh) r5, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r15, (boolean) r0)
            return r0
        L_0x020d:
            r14 = r21
            r5 = r22
            r15 = r23
            r0 = 0
            r1 = 2
            com.google.android.gms.internal.measurement.zzg.zzc(r6, r1, r15)
            boolean r2 = r23.isEmpty()
            if (r2 == 0) goto L_0x0223
            com.google.android.gms.internal.measurement.zzaq r0 = r21.zzc()
            return r0
        L_0x0223:
            int r2 = r21.zzb()
            double r6 = (double) r2
            java.lang.Object r0 = r15.get(r0)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            java.lang.Double r0 = r0.zze()
            double r8 = r0.doubleValue()
            double r8 = com.google.android.gms.internal.measurement.zzg.zza((double) r8)
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0248
            double r8 = r8 + r6
            double r8 = java.lang.Math.max(r8, r3)
            goto L_0x024c
        L_0x0248:
            double r8 = java.lang.Math.min(r8, r6)
        L_0x024c:
            int r0 = r23.size()
            if (r0 != r1) goto L_0x0277
            r0 = 1
            java.lang.Object r0 = r15.get(r0)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            java.lang.Double r0 = r0.zze()
            double r0 = r0.doubleValue()
            double r0 = com.google.android.gms.internal.measurement.zzg.zza((double) r0)
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x0273
            double r6 = r6 + r0
            double r6 = java.lang.Math.max(r6, r3)
            goto L_0x0277
        L_0x0273:
            double r6 = java.lang.Math.min(r6, r0)
        L_0x0277:
            com.google.android.gms.internal.measurement.zzaf r0 = new com.google.android.gms.internal.measurement.zzaf
            r0.<init>()
            int r1 = (int) r8
        L_0x027d:
            double r2 = (double) r1
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x028c
            com.google.android.gms.internal.measurement.zzaq r2 = r14.zza((int) r1)
            r0.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            int r1 = r1 + 1
            goto L_0x027d
        L_0x028c:
            return r0
        L_0x028d:
            r14 = r21
            r15 = r23
            r1 = 0
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r7, (int) r1, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r15)
            int r0 = r21.zzb()
            if (r0 != 0) goto L_0x029e
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzc
            return r0
        L_0x029e:
            com.google.android.gms.internal.measurement.zzaq r0 = r14.zza((int) r1)
            r14.zzb((int) r1)
            return r0
        L_0x02a6:
            r14 = r21
            r5 = r22
            r15 = r23
            r1 = 0
            r3 = 1
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r8, (int) r3, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r15)
            java.lang.Object r3 = r15.get(r1)
            com.google.android.gms.internal.measurement.zzaq r3 = (com.google.android.gms.internal.measurement.zzaq) r3
            com.google.android.gms.internal.measurement.zzaq r3 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.zzar
            if (r4 == 0) goto L_0x02df
            int r0 = r21.zzb()
            if (r0 == 0) goto L_0x02dc
            com.google.android.gms.internal.measurement.zzar r3 = (com.google.android.gms.internal.measurement.zzar) r3
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            com.google.android.gms.internal.measurement.zzaf r0 = zza(r14, r5, r3, r0, r2)
            int r0 = r0.zzb()
            int r1 = r21.zzb()
            if (r0 == r1) goto L_0x02dc
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzi
            return r0
        L_0x02dc:
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzh
            return r0
        L_0x02df:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r0)
            throw r1
        L_0x02e5:
            r14 = r21
            r5 = r22
            r15 = r23
            r0 = 1
            r1 = 2
            com.google.android.gms.internal.measurement.zzg.zzc(r9, r0, r15)
            int r0 = r21.zzb()
            if (r0 < r1) goto L_0x033e
            java.util.List r0 = r21.zzi()
            boolean r1 = r23.isEmpty()
            if (r1 != 0) goto L_0x031a
            r1 = 0
            java.lang.Object r2 = r15.get(r1)
            com.google.android.gms.internal.measurement.zzaq r2 = (com.google.android.gms.internal.measurement.zzaq) r2
            com.google.android.gms.internal.measurement.zzaq r1 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzal
            if (r2 == 0) goto L_0x0312
            com.google.android.gms.internal.measurement.zzal r1 = (com.google.android.gms.internal.measurement.zzal) r1
            goto L_0x031b
        L_0x0312:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Comparator should be a method"
            r0.<init>(r1)
            throw r0
        L_0x031a:
            r1 = 0
        L_0x031b:
            com.google.android.gms.internal.measurement.zzbh r2 = new com.google.android.gms.internal.measurement.zzbh
            r2.<init>(r1, r5)
            java.util.Collections.sort(r0, r2)
            r21.zzj()
            java.util.Iterator r0 = r0.iterator()
            r3 = 0
        L_0x032b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x033e
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzaq r1 = (com.google.android.gms.internal.measurement.zzaq) r1
            int r2 = r3 + 1
            r14.zzb(r3, r1)
            r3 = r2
            goto L_0x032b
        L_0x033e:
            return r14
        L_0x033f:
            r14 = r21
            r5 = r22
            r15 = r23
            r1 = 2
            r2 = 3
            r3 = 1
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r10, (int) r3, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r15)
            r3 = 0
            java.lang.Object r4 = r15.get(r3)
            com.google.android.gms.internal.measurement.zzaq r4 = (com.google.android.gms.internal.measurement.zzaq) r4
            com.google.android.gms.internal.measurement.zzaq r3 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r4)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.zzal
            if (r4 == 0) goto L_0x03ac
            int r0 = r21.zzb()
            if (r0 == 0) goto L_0x03a9
            com.google.android.gms.internal.measurement.zzal r3 = (com.google.android.gms.internal.measurement.zzal) r3
            java.util.Iterator r0 = r21.zzg()
        L_0x0366:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x03a9
            java.lang.Object r4 = r0.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            boolean r6 = r14.zzc((int) r4)
            if (r6 == 0) goto L_0x0366
            com.google.android.gms.internal.measurement.zzaq[] r6 = new com.google.android.gms.internal.measurement.zzaq[r2]
            com.google.android.gms.internal.measurement.zzaq r7 = r14.zza((int) r4)
            r8 = 0
            r6[r8] = r7
            com.google.android.gms.internal.measurement.zzai r7 = new com.google.android.gms.internal.measurement.zzai
            double r8 = (double) r4
            java.lang.Double r4 = java.lang.Double.valueOf(r8)
            r7.<init>(r4)
            r4 = 1
            r6[r4] = r7
            r6[r1] = r14
            java.util.List r4 = java.util.Arrays.asList(r6)
            com.google.android.gms.internal.measurement.zzaq r4 = r3.zza((com.google.android.gms.internal.measurement.zzh) r5, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r4)
            java.lang.Boolean r4 = r4.zzd()
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0366
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzh
            return r0
        L_0x03a9:
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzi
            return r0
        L_0x03ac:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r0)
            throw r1
        L_0x03b2:
            r14 = r21
            r5 = r22
            r15 = r23
            boolean r0 = r23.isEmpty()
            if (r0 != 0) goto L_0x03d6
            java.util.Iterator r0 = r23.iterator()
        L_0x03c2:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x03d6
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzaq r1 = (com.google.android.gms.internal.measurement.zzaq) r1
            com.google.android.gms.internal.measurement.zzaq r1 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r1)
            r14.zza((com.google.android.gms.internal.measurement.zzaq) r1)
            goto L_0x03c2
        L_0x03d6:
            com.google.android.gms.internal.measurement.zzai r0 = new com.google.android.gms.internal.measurement.zzai
            int r1 = r21.zzb()
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            return r0
        L_0x03e5:
            r14 = r21
            r5 = r22
            r15 = r23
            r0 = 1
            com.google.android.gms.internal.measurement.zzg.zzc(r11, r0, r15)
            int r0 = r21.zzb()
            if (r0 != 0) goto L_0x03f8
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzj
            return r0
        L_0x03f8:
            boolean r0 = r23.isEmpty()
            if (r0 != 0) goto L_0x041a
            r0 = 0
            java.lang.Object r0 = r15.get(r0)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzao
            if (r1 != 0) goto L_0x0417
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzax
            if (r1 == 0) goto L_0x0412
            goto L_0x0417
        L_0x0412:
            java.lang.String r0 = r0.zzf()
            goto L_0x041c
        L_0x0417:
            java.lang.String r0 = ""
            goto L_0x041c
        L_0x041a:
            java.lang.String r0 = ","
        L_0x041c:
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r0 = r14.zzb((java.lang.String) r0)
            r1.<init>(r0)
            return r1
        L_0x0426:
            r14 = r21
            r15 = r23
            r1 = 0
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r12, (int) r1, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r15)
            int r0 = r21.zzb()
            if (r0 != 0) goto L_0x0437
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzc
            return r0
        L_0x0437:
            r2 = 1
            int r0 = r0 - r2
            com.google.android.gms.internal.measurement.zzaq r1 = r14.zza((int) r0)
            r14.zzb((int) r0)
            return r1
        L_0x0441:
            r14 = r21
            r5 = r22
            r15 = r23
            r1 = 0
            r2 = 1
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r13, (int) r2, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r15)
            java.lang.Object r1 = r15.get(r1)
            com.google.android.gms.internal.measurement.zzaq r1 = (com.google.android.gms.internal.measurement.zzaq) r1
            com.google.android.gms.internal.measurement.zzaq r1 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzar
            if (r2 == 0) goto L_0x046d
            int r0 = r21.zzb()
            if (r0 != 0) goto L_0x0466
            com.google.android.gms.internal.measurement.zzaf r0 = new com.google.android.gms.internal.measurement.zzaf
            r0.<init>()
            return r0
        L_0x0466:
            com.google.android.gms.internal.measurement.zzar r1 = (com.google.android.gms.internal.measurement.zzar) r1
            com.google.android.gms.internal.measurement.zzaf r0 = zza(r14, r5, r1)
            return r0
        L_0x046d:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r0)
            throw r1
        L_0x0473:
            r14 = r21
            r5 = r22
            r15 = r23
            boolean r0 = r23.isEmpty()
            if (r0 != 0) goto L_0x04f0
            com.google.android.gms.internal.measurement.zzaf r0 = new com.google.android.gms.internal.measurement.zzaf
            r0.<init>()
            java.util.Iterator r1 = r23.iterator()
        L_0x0488:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x04a8
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzaq r2 = (com.google.android.gms.internal.measurement.zzaq) r2
            com.google.android.gms.internal.measurement.zzaq r2 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzaj
            if (r3 != 0) goto L_0x04a0
            r0.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            goto L_0x0488
        L_0x04a0:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Argument evaluation failed"
            r0.<init>(r1)
            throw r0
        L_0x04a8:
            int r1 = r0.zzb()
            java.util.Iterator r2 = r21.zzg()
        L_0x04b0:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04cd
            java.lang.Object r3 = r2.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r4 = r3.intValue()
            int r4 = r4 + r1
            int r3 = r3.intValue()
            com.google.android.gms.internal.measurement.zzaq r3 = r14.zza((int) r3)
            r0.zzb(r4, r3)
            goto L_0x04b0
        L_0x04cd:
            r21.zzj()
            java.util.Iterator r1 = r0.zzg()
        L_0x04d4:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x04f0
            java.lang.Object r2 = r1.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r3 = r2.intValue()
            int r2 = r2.intValue()
            com.google.android.gms.internal.measurement.zzaq r2 = r0.zza((int) r2)
            r14.zzb(r3, r2)
            goto L_0x04d4
        L_0x04f0:
            com.google.android.gms.internal.measurement.zzai r0 = new com.google.android.gms.internal.measurement.zzai
            int r1 = r21.zzb()
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            return r0
        L_0x04ff:
            r6 = r21
            r5 = r22
            r15 = r23
            r1 = 2
            com.google.android.gms.internal.measurement.zzg.zzc(r14, r1, r15)
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzc
            boolean r1 = r23.isEmpty()
            if (r1 != 0) goto L_0x051c
            r1 = 0
            java.lang.Object r0 = r15.get(r1)
            com.google.android.gms.internal.measurement.zzaq r0 = (com.google.android.gms.internal.measurement.zzaq) r0
            com.google.android.gms.internal.measurement.zzaq r0 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r0)
        L_0x051c:
            int r1 = r21.zzb()
            r2 = 1
            int r1 = r1 - r2
            double r7 = (double) r1
            int r1 = r23.size()
            if (r1 <= r2) goto L_0x055f
            java.lang.Object r1 = r15.get(r2)
            com.google.android.gms.internal.measurement.zzaq r1 = (com.google.android.gms.internal.measurement.zzaq) r1
            com.google.android.gms.internal.measurement.zzaq r1 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r1)
            java.lang.Double r5 = r1.zze()
            double r7 = r5.doubleValue()
            boolean r5 = java.lang.Double.isNaN(r7)
            if (r5 == 0) goto L_0x0548
            int r1 = r21.zzb()
            int r1 = r1 - r2
            double r1 = (double) r1
            goto L_0x0554
        L_0x0548:
            java.lang.Double r1 = r1.zze()
            double r1 = r1.doubleValue()
            double r1 = com.google.android.gms.internal.measurement.zzg.zza((double) r1)
        L_0x0554:
            r7 = r1
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x055f
            int r1 = r21.zzb()
            double r1 = (double) r1
            double r7 = r7 + r1
        L_0x055f:
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x056d
            com.google.android.gms.internal.measurement.zzai r0 = new com.google.android.gms.internal.measurement.zzai
            java.lang.Double r1 = java.lang.Double.valueOf(r17)
            r0.<init>(r1)
            return r0
        L_0x056d:
            int r1 = r21.zzb()
            double r1 = (double) r1
            double r1 = java.lang.Math.min(r1, r7)
            int r1 = (int) r1
        L_0x0577:
            if (r1 < 0) goto L_0x0597
            boolean r2 = r6.zzc((int) r1)
            if (r2 == 0) goto L_0x0594
            com.google.android.gms.internal.measurement.zzaq r2 = r6.zza((int) r1)
            boolean r2 = com.google.android.gms.internal.measurement.zzg.zza(r2, r0)
            if (r2 == 0) goto L_0x0594
            com.google.android.gms.internal.measurement.zzai r0 = new com.google.android.gms.internal.measurement.zzai
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            return r0
        L_0x0594:
            int r1 = r1 + -1
            goto L_0x0577
        L_0x0597:
            com.google.android.gms.internal.measurement.zzai r0 = new com.google.android.gms.internal.measurement.zzai
            java.lang.Double r1 = java.lang.Double.valueOf(r17)
            r0.<init>(r1)
            return r0
        L_0x05a1:
            r6 = r21
            r5 = r22
            r3 = r23
            r1 = 1
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r15, (int) r1, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            r1 = 0
            java.lang.Object r1 = r3.get(r1)
            com.google.android.gms.internal.measurement.zzaq r1 = (com.google.android.gms.internal.measurement.zzaq) r1
            com.google.android.gms.internal.measurement.zzaq r1 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzar
            if (r2 == 0) goto L_0x05cb
            int r0 = r21.zza()
            if (r0 != 0) goto L_0x05c3
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzc
            return r0
        L_0x05c3:
            com.google.android.gms.internal.measurement.zzar r1 = (com.google.android.gms.internal.measurement.zzar) r1
            zza(r6, r5, r1)
            com.google.android.gms.internal.measurement.zzaq r0 = com.google.android.gms.internal.measurement.zzaq.zzc
            return r0
        L_0x05cb:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r0)
            throw r1
        L_0x05d1:
            r6 = r21
            r5 = r22
            r3 = r23
            r1 = 2
            boolean r0 = r23.isEmpty()
            if (r0 == 0) goto L_0x05e4
            com.google.android.gms.internal.measurement.zzaf r0 = new com.google.android.gms.internal.measurement.zzaf
            r0.<init>()
            return r0
        L_0x05e4:
            r0 = 0
            java.lang.Object r2 = r3.get(r0)
            com.google.android.gms.internal.measurement.zzaq r2 = (com.google.android.gms.internal.measurement.zzaq) r2
            com.google.android.gms.internal.measurement.zzaq r2 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            java.lang.Double r2 = r2.zze()
            double r7 = r2.doubleValue()
            double r7 = com.google.android.gms.internal.measurement.zzg.zza((double) r7)
            int r2 = (int) r7
            if (r2 >= 0) goto L_0x0608
            int r4 = r21.zzb()
            int r2 = r2 + r4
            int r2 = java.lang.Math.max(r0, r2)
            goto L_0x0612
        L_0x0608:
            int r0 = r21.zzb()
            if (r2 <= r0) goto L_0x0612
            int r2 = r21.zzb()
        L_0x0612:
            int r0 = r21.zzb()
            com.google.android.gms.internal.measurement.zzaf r4 = new com.google.android.gms.internal.measurement.zzaf
            r4.<init>()
            int r7 = r23.size()
            r8 = 1
            if (r7 <= r8) goto L_0x0683
            java.lang.Object r7 = r3.get(r8)
            com.google.android.gms.internal.measurement.zzaq r7 = (com.google.android.gms.internal.measurement.zzaq) r7
            com.google.android.gms.internal.measurement.zzaq r7 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r7)
            java.lang.Double r7 = r7.zze()
            double r7 = r7.doubleValue()
            double r7 = com.google.android.gms.internal.measurement.zzg.zza((double) r7)
            int r7 = (int) r7
            r8 = 0
            int r7 = java.lang.Math.max(r8, r7)
            if (r7 <= 0) goto L_0x0656
            r8 = r2
        L_0x0641:
            int r9 = r2 + r7
            int r9 = java.lang.Math.min(r0, r9)
            if (r8 >= r9) goto L_0x0656
            com.google.android.gms.internal.measurement.zzaq r9 = r6.zza((int) r2)
            r4.zza((com.google.android.gms.internal.measurement.zzaq) r9)
            r6.zzb((int) r2)
            int r8 = r8 + 1
            goto L_0x0641
        L_0x0656:
            int r0 = r23.size()
            if (r0 <= r1) goto L_0x0682
            r0 = r1
        L_0x065d:
            int r7 = r23.size()
            if (r0 >= r7) goto L_0x0682
            java.lang.Object r7 = r3.get(r0)
            com.google.android.gms.internal.measurement.zzaq r7 = (com.google.android.gms.internal.measurement.zzaq) r7
            com.google.android.gms.internal.measurement.zzaq r7 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r7)
            boolean r8 = r7 instanceof com.google.android.gms.internal.measurement.zzaj
            if (r8 != 0) goto L_0x067a
            int r8 = r2 + r0
            int r8 = r8 - r1
            r6.zza((int) r8, (com.google.android.gms.internal.measurement.zzaq) r7)
            int r0 = r0 + 1
            goto L_0x065d
        L_0x067a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Failed to parse elements to add"
            r0.<init>(r1)
            throw r0
        L_0x0682:
            return r4
        L_0x0683:
            if (r2 >= r0) goto L_0x0693
            com.google.android.gms.internal.measurement.zzaq r1 = r6.zza((int) r2)
            r4.zza((com.google.android.gms.internal.measurement.zzaq) r1)
            r1 = 0
            r6.zzb(r2, r1)
            int r2 = r2 + 1
            goto L_0x0683
        L_0x0693:
            return r4
        L_0x0694:
            r6 = r21
            r5 = r22
            r3 = r23
            r4 = 1
            com.google.android.gms.internal.measurement.zzaq r0 = zza((com.google.android.gms.internal.measurement.zzaf) r6, (com.google.android.gms.internal.measurement.zzh) r5, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3, (boolean) r4)
            return r0
        L_0x06a0:
            r6 = r21
            r5 = r22
            r3 = r23
            r4 = 1
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r1, (int) r4, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            r1 = 0
            java.lang.Object r1 = r3.get(r1)
            com.google.android.gms.internal.measurement.zzaq r1 = (com.google.android.gms.internal.measurement.zzaq) r1
            com.google.android.gms.internal.measurement.zzaq r1 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r1)
            boolean r3 = r1 instanceof com.google.android.gms.internal.measurement.zzar
            if (r3 == 0) goto L_0x06f4
            int r0 = r21.zza()
            if (r0 != 0) goto L_0x06c5
            com.google.android.gms.internal.measurement.zzaf r0 = new com.google.android.gms.internal.measurement.zzaf
            r0.<init>()
            return r0
        L_0x06c5:
            com.google.android.gms.internal.measurement.zzaq r0 = r21.zzc()
            com.google.android.gms.internal.measurement.zzaf r0 = (com.google.android.gms.internal.measurement.zzaf) r0
            com.google.android.gms.internal.measurement.zzar r1 = (com.google.android.gms.internal.measurement.zzar) r1
            r3 = 0
            com.google.android.gms.internal.measurement.zzaf r1 = zza(r6, r5, r1, r3, r2)
            com.google.android.gms.internal.measurement.zzaf r2 = new com.google.android.gms.internal.measurement.zzaf
            r2.<init>()
            java.util.Iterator r1 = r1.zzg()
        L_0x06db:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x06f3
            java.lang.Object r3 = r1.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            com.google.android.gms.internal.measurement.zzaq r3 = r0.zza((int) r3)
            r2.zza((com.google.android.gms.internal.measurement.zzaq) r3)
            goto L_0x06db
        L_0x06f3:
            return r2
        L_0x06f4:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r0)
            throw r1
        L_0x06fa:
            r6 = r21
            r5 = r22
            r3 = r23
            com.google.android.gms.internal.measurement.zzaq r0 = r21.zzc()
            com.google.android.gms.internal.measurement.zzaf r0 = (com.google.android.gms.internal.measurement.zzaf) r0
            boolean r1 = r23.isEmpty()
            if (r1 != 0) goto L_0x075b
            java.util.Iterator r1 = r23.iterator()
        L_0x0710:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x075b
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzaq r2 = (com.google.android.gms.internal.measurement.zzaq) r2
            com.google.android.gms.internal.measurement.zzaq r2 = r5.zza((com.google.android.gms.internal.measurement.zzaq) r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzaj
            if (r3 != 0) goto L_0x0753
            int r3 = r0.zzb()
            boolean r4 = r2 instanceof com.google.android.gms.internal.measurement.zzaf
            if (r4 == 0) goto L_0x074f
            com.google.android.gms.internal.measurement.zzaf r2 = (com.google.android.gms.internal.measurement.zzaf) r2
            java.util.Iterator r4 = r2.zzg()
        L_0x0732:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0710
            java.lang.Object r6 = r4.next()
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r7 = r6.intValue()
            int r7 = r7 + r3
            int r6 = r6.intValue()
            com.google.android.gms.internal.measurement.zzaq r6 = r2.zza((int) r6)
            r0.zzb(r7, r6)
            goto L_0x0732
        L_0x074f:
            r0.zzb(r3, r2)
            goto L_0x0710
        L_0x0753:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Failed evaluation of arguments"
            r0.<init>(r1)
            throw r0
        L_0x075b:
            return r0
        L_0x075c:
            r6 = r21
            r3 = r23
            r0 = r19
            r1 = 0
            com.google.android.gms.internal.measurement.zzg.zza((java.lang.String) r0, (int) r1, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r3)
            com.google.android.gms.internal.measurement.zzas r0 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r1 = r21.toString()
            r0.<init>(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbe.zza(java.lang.String, com.google.android.gms.internal.measurement.zzaf, com.google.android.gms.internal.measurement.zzh, java.util.List):com.google.android.gms.internal.measurement.zzaq");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0096 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.measurement.zzaq zza(com.google.android.gms.internal.measurement.zzaf r9, com.google.android.gms.internal.measurement.zzh r10, java.util.List<com.google.android.gms.internal.measurement.zzaq> r11, boolean r12) {
        /*
            java.lang.String r0 = "reduce"
            r1 = 1
            com.google.android.gms.internal.measurement.zzg.zzb((java.lang.String) r0, (int) r1, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r11)
            r2 = 2
            com.google.android.gms.internal.measurement.zzg.zzc(r0, r2, r11)
            r0 = 0
            java.lang.Object r3 = r11.get(r0)
            com.google.android.gms.internal.measurement.zzaq r3 = (com.google.android.gms.internal.measurement.zzaq) r3
            com.google.android.gms.internal.measurement.zzaq r3 = r10.zza((com.google.android.gms.internal.measurement.zzaq) r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.zzal
            if (r4 == 0) goto L_0x009f
            int r4 = r11.size()
            if (r4 != r2) goto L_0x0036
            java.lang.Object r11 = r11.get(r1)
            com.google.android.gms.internal.measurement.zzaq r11 = (com.google.android.gms.internal.measurement.zzaq) r11
            com.google.android.gms.internal.measurement.zzaq r11 = r10.zza((com.google.android.gms.internal.measurement.zzaq) r11)
            boolean r4 = r11 instanceof com.google.android.gms.internal.measurement.zzaj
            if (r4 != 0) goto L_0x002e
            goto L_0x003d
        L_0x002e:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Failed to parse initial value"
            r9.<init>(r10)
            throw r9
        L_0x0036:
            r11 = 0
            int r4 = r9.zzb()
            if (r4 == 0) goto L_0x0097
        L_0x003d:
            com.google.android.gms.internal.measurement.zzal r3 = (com.google.android.gms.internal.measurement.zzal) r3
            int r4 = r9.zzb()
            if (r12 == 0) goto L_0x0047
            r5 = r0
            goto L_0x0049
        L_0x0047:
            int r5 = r4 + -1
        L_0x0049:
            if (r12 == 0) goto L_0x004d
            int r4 = r4 - r1
            goto L_0x004e
        L_0x004d:
            r4 = r0
        L_0x004e:
            if (r12 == 0) goto L_0x0052
            r12 = r1
            goto L_0x0053
        L_0x0052:
            r12 = -1
        L_0x0053:
            if (r11 != 0) goto L_0x005a
            com.google.android.gms.internal.measurement.zzaq r11 = r9.zza((int) r5)
            goto L_0x0094
        L_0x005a:
            int r6 = r4 - r5
            int r6 = r6 * r12
            if (r6 < 0) goto L_0x0096
            boolean r6 = r9.zzc((int) r5)
            if (r6 == 0) goto L_0x0094
            r6 = 4
            com.google.android.gms.internal.measurement.zzaq[] r6 = new com.google.android.gms.internal.measurement.zzaq[r6]
            r6[r0] = r11
            com.google.android.gms.internal.measurement.zzaq r11 = r9.zza((int) r5)
            r6[r1] = r11
            com.google.android.gms.internal.measurement.zzai r11 = new com.google.android.gms.internal.measurement.zzai
            double r7 = (double) r5
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            r11.<init>(r7)
            r6[r2] = r11
            r11 = 3
            r6[r11] = r9
            java.util.List r11 = java.util.Arrays.asList(r6)
            com.google.android.gms.internal.measurement.zzaq r11 = r3.zza((com.google.android.gms.internal.measurement.zzh) r10, (java.util.List<com.google.android.gms.internal.measurement.zzaq>) r11)
            boolean r6 = r11 instanceof com.google.android.gms.internal.measurement.zzaj
            if (r6 != 0) goto L_0x008c
            goto L_0x0094
        L_0x008c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Reduce operation failed"
            r9.<init>(r10)
            throw r9
        L_0x0094:
            int r5 = r5 + r12
            goto L_0x005a
        L_0x0096:
            return r11
        L_0x0097:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Empty array with no initial value error"
            r9.<init>(r10)
            throw r9
        L_0x009f:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Callback should be a method"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbe.zza(com.google.android.gms.internal.measurement.zzaf, com.google.android.gms.internal.measurement.zzh, java.util.List, boolean):com.google.android.gms.internal.measurement.zzaq");
    }
}
