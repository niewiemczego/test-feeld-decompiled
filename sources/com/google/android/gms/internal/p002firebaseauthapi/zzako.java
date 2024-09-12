package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzako  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzako<T> implements zzalc<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzamh.zzb();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzakk zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final zzakz zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzaks zzo;
    private final zzajt zzp;
    private final zzamb<?, ?> zzq;
    private final zzair<?> zzr;
    private final zzakh zzs;

    private static <T> double zza(T t, long j) {
        return ((Double) zzamh.zze(t, j)).doubleValue();
    }

    private static boolean zzg(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> float zzb(T t, long j) {
        return ((Float) zzamh.zze(t, j)).floatValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return r2 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zza(byte[] r1, int r2, int r3, com.google.android.gms.internal.p002firebaseauthapi.zzamo r4, java.lang.Class<?> r5, com.google.android.gms.internal.p002firebaseauthapi.zzahl r6) throws java.io.IOException {
        /*
            int[] r0 = com.google.android.gms.internal.p002firebaseauthapi.zzakr.zza
            int r4 = r4.ordinal()
            r4 = r0[r4]
            switch(r4) {
                case 1: goto L_0x0099;
                case 2: goto L_0x0094;
                case 3: goto L_0x0087;
                case 4: goto L_0x007a;
                case 5: goto L_0x007a;
                case 6: goto L_0x006f;
                case 7: goto L_0x006f;
                case 8: goto L_0x0064;
                case 9: goto L_0x0057;
                case 10: goto L_0x0057;
                case 11: goto L_0x0057;
                case 12: goto L_0x004a;
                case 13: goto L_0x004a;
                case 14: goto L_0x003d;
                case 15: goto L_0x002b;
                case 16: goto L_0x0019;
                case 17: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "unsupported field type."
            r1.<init>(r2)
            throw r1
        L_0x0013:
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzb(r1, r2, r6)
            goto L_0x00ae
        L_0x0019:
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd(r1, r2, r6)
            long r2 = r6.zzb
            long r2 = com.google.android.gms.internal.p002firebaseauthapi.zzaib.zza((long) r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.zzc = r2
            goto L_0x00ae
        L_0x002b:
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r1, r2, r6)
            int r2 = r6.zza
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzaib.zze(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.zzc = r2
            goto L_0x00ae
        L_0x003d:
            com.google.android.gms.internal.firebase-auth-api.zzaky r4 = com.google.android.gms.internal.p002firebaseauthapi.zzaky.zza()
            com.google.android.gms.internal.firebase-auth-api.zzalc r4 = r4.zza(r5)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza((com.google.android.gms.internal.p002firebaseauthapi.zzalc) r4, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r6)
            goto L_0x00ae
        L_0x004a:
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd(r1, r2, r6)
            long r2 = r6.zzb
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.zzc = r2
            goto L_0x00ae
        L_0x0057:
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r1, r2, r6)
            int r2 = r6.zza
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.zzc = r2
            goto L_0x00ae
        L_0x0064:
            float r1 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzb(r1, r2)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r6.zzc = r1
            goto L_0x0084
        L_0x006f:
            long r3 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd(r1, r2)
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r6.zzc = r1
            goto L_0x0091
        L_0x007a:
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r1, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r6.zzc = r1
        L_0x0084:
            int r1 = r2 + 4
            goto L_0x00ae
        L_0x0087:
            double r3 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza(r1, r2)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r6.zzc = r1
        L_0x0091:
            int r1 = r2 + 8
            goto L_0x00ae
        L_0x0094:
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza(r1, r2, r6)
            goto L_0x00ae
        L_0x0099:
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd(r1, r2, r6)
            long r2 = r6.zzb
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x00a7
            r2 = 1
            goto L_0x00a8
        L_0x00a7:
            r2 = 0
        L_0x00a8:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r6.zzc = r2
        L_0x00ae:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzako.zza(byte[], int, int, com.google.android.gms.internal.firebase-auth-api.zzamo, java.lang.Class, com.google.android.gms.internal.firebase-auth-api.zzahl):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x02cd, code lost:
        r12 = r12 + ((r1 + r2) + r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0397, code lost:
        r12 = r12 + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0398, code lost:
        r15 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x04ce, code lost:
        r12 = r12 + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x04cf, code lost:
        r15 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0584, code lost:
        r11 = r11 + 3;
        r0 = r14;
        r10 = r15;
        r1 = r16;
        r9 = 1048575;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r19) {
        /*
            r18 = this;
            r6 = r18
            r7 = r19
            sun.misc.Unsafe r8 = zzb
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r10 = 0
            r0 = r9
            r1 = r10
            r11 = r1
            r12 = r11
        L_0x000e:
            int[] r2 = r6.zzc
            int r2 = r2.length
            if (r11 >= r2) goto L_0x058f
            int r2 = r6.zzc((int) r11)
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = r3 & r2
            int r3 = r3 >>> 20
            int[] r4 = r6.zzc
            r13 = r4[r11]
            int r5 = r11 + 2
            r4 = r4[r5]
            r5 = r4 & r9
            r14 = 17
            r15 = 1
            if (r3 > r14) goto L_0x0041
            if (r5 == r0) goto L_0x0038
            if (r5 != r9) goto L_0x0031
            r0 = r10
            goto L_0x0036
        L_0x0031:
            long r0 = (long) r5
            int r0 = r8.getInt(r7, r0)
        L_0x0036:
            r1 = r0
            r0 = r5
        L_0x0038:
            int r4 = r4 >>> 20
            int r4 = r15 << r4
            r14 = r0
            r16 = r1
            r5 = r4
            goto L_0x0045
        L_0x0041:
            r14 = r0
            r16 = r1
            r5 = r10
        L_0x0045:
            r0 = r2 & r9
            long r1 = (long) r0
            com.google.android.gms.internal.firebase-auth-api.zzaix r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaix.DOUBLE_LIST_PACKED
            int r0 = r0.zza()
            if (r3 < r0) goto L_0x0056
            com.google.android.gms.internal.firebase-auth-api.zzaix r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaix.SINT64_LIST_PACKED
            int r0 = r0.zza()
        L_0x0056:
            r17 = r5
            r4 = 0
            switch(r3) {
                case 0: goto L_0x056b;
                case 1: goto L_0x0553;
                case 2: goto L_0x0538;
                case 3: goto L_0x051d;
                case 4: goto L_0x0501;
                case 5: goto L_0x04e9;
                case 6: goto L_0x04d2;
                case 7: goto L_0x04ba;
                case 8: goto L_0x0493;
                case 9: goto L_0x0475;
                case 10: goto L_0x0458;
                case 11: goto L_0x043d;
                case 12: goto L_0x0422;
                case 13: goto L_0x040a;
                case 14: goto L_0x03f3;
                case 15: goto L_0x03d8;
                case 16: goto L_0x03bd;
                case 17: goto L_0x039b;
                case 18: goto L_0x038d;
                case 19: goto L_0x0382;
                case 20: goto L_0x0377;
                case 21: goto L_0x036c;
                case 22: goto L_0x0361;
                case 23: goto L_0x0356;
                case 24: goto L_0x034b;
                case 25: goto L_0x0340;
                case 26: goto L_0x0335;
                case 27: goto L_0x0326;
                case 28: goto L_0x031a;
                case 29: goto L_0x030e;
                case 30: goto L_0x0302;
                case 31: goto L_0x02f6;
                case 32: goto L_0x02ea;
                case 33: goto L_0x02de;
                case 34: goto L_0x02d2;
                case 35: goto L_0x02b9;
                case 36: goto L_0x02a4;
                case 37: goto L_0x028f;
                case 38: goto L_0x027a;
                case 39: goto L_0x0265;
                case 40: goto L_0x0250;
                case 41: goto L_0x023a;
                case 42: goto L_0x0224;
                case 43: goto L_0x020e;
                case 44: goto L_0x01f8;
                case 45: goto L_0x01e2;
                case 46: goto L_0x01cc;
                case 47: goto L_0x01b6;
                case 48: goto L_0x01a0;
                case 49: goto L_0x0190;
                case 50: goto L_0x0180;
                case 51: goto L_0x0172;
                case 52: goto L_0x0165;
                case 53: goto L_0x0155;
                case 54: goto L_0x0145;
                case 55: goto L_0x0135;
                case 56: goto L_0x0129;
                case 57: goto L_0x011d;
                case 58: goto L_0x0111;
                case 59: goto L_0x00f3;
                case 60: goto L_0x00df;
                case 61: goto L_0x00cd;
                case 62: goto L_0x00bd;
                case 63: goto L_0x00ad;
                case 64: goto L_0x00a1;
                case 65: goto L_0x0095;
                case 66: goto L_0x0085;
                case 67: goto L_0x0075;
                case 68: goto L_0x005f;
                default: goto L_0x005d;
            }
        L_0x005d:
            goto L_0x0398
        L_0x005f:
            boolean r0 = r6.zzc(r7, (int) r13, (int) r11)
            if (r0 == 0) goto L_0x0398
            java.lang.Object r0 = r8.getObject(r7, r1)
            com.google.android.gms.internal.firebase-auth-api.zzakk r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzakk) r0
            com.google.android.gms.internal.firebase-auth-api.zzalc r1 = r6.zze((int) r11)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zza(r13, r0, r1)
            goto L_0x0397
        L_0x0075:
            boolean r0 = r6.zzc(r7, (int) r13, (int) r11)
            if (r0 == 0) goto L_0x0398
            long r0 = zzd(r7, r1)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzd((int) r13, (long) r0)
            goto L_0x0397
        L_0x0085:
            boolean r0 = r6.zzc(r7, (int) r13, (int) r11)
            if (r0 == 0) goto L_0x0398
            int r0 = zzc(r7, (long) r1)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zze((int) r13, (int) r0)
            goto L_0x0397
        L_0x0095:
            boolean r0 = r6.zzc(r7, (int) r13, (int) r11)
            if (r0 == 0) goto L_0x0398
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzc((int) r13, (long) r4)
            goto L_0x0397
        L_0x00a1:
            boolean r0 = r6.zzc(r7, (int) r13, (int) r11)
            if (r0 == 0) goto L_0x0398
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzd((int) r13, (int) r10)
            goto L_0x0397
        L_0x00ad:
            boolean r0 = r6.zzc(r7, (int) r13, (int) r11)
            if (r0 == 0) goto L_0x0398
            int r0 = zzc(r7, (long) r1)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zza((int) r13, (int) r0)
            goto L_0x0397
        L_0x00bd:
            boolean r0 = r6.zzc(r7, (int) r13, (int) r11)
            if (r0 == 0) goto L_0x0398
            int r0 = zzc(r7, (long) r1)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzf((int) r13, (int) r0)
            goto L_0x0397
        L_0x00cd:
            boolean r0 = r6.zzc(r7, (int) r13, (int) r11)
            if (r0 == 0) goto L_0x0398
            java.lang.Object r0 = r8.getObject(r7, r1)
            com.google.android.gms.internal.firebase-auth-api.zzahm r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzahm) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zza((int) r13, (com.google.android.gms.internal.p002firebaseauthapi.zzahm) r0)
            goto L_0x0397
        L_0x00df:
            boolean r0 = r6.zzc(r7, (int) r13, (int) r11)
            if (r0 == 0) goto L_0x0398
            java.lang.Object r0 = r8.getObject(r7, r1)
            com.google.android.gms.internal.firebase-auth-api.zzalc r1 = r6.zze((int) r11)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zza((int) r13, (java.lang.Object) r0, (com.google.android.gms.internal.p002firebaseauthapi.zzalc) r1)
            goto L_0x0397
        L_0x00f3:
            boolean r0 = r6.zzc(r7, (int) r13, (int) r11)
            if (r0 == 0) goto L_0x0398
            java.lang.Object r0 = r8.getObject(r7, r1)
            boolean r1 = r0 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzahm
            if (r1 == 0) goto L_0x0109
            com.google.android.gms.internal.firebase-auth-api.zzahm r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzahm) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zza((int) r13, (com.google.android.gms.internal.p002firebaseauthapi.zzahm) r0)
            goto L_0x0397
        L_0x0109:
            java.lang.String r0 = (java.lang.String) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zza((int) r13, (java.lang.String) r0)
            goto L_0x0397
        L_0x0111:
            boolean r0 = r6.zzc(r7, (int) r13, (int) r11)
            if (r0 == 0) goto L_0x0398
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zza((int) r13, (boolean) r15)
            goto L_0x0397
        L_0x011d:
            boolean r0 = r6.zzc(r7, (int) r13, (int) r11)
            if (r0 == 0) goto L_0x0398
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzb((int) r13, (int) r10)
            goto L_0x0397
        L_0x0129:
            boolean r0 = r6.zzc(r7, (int) r13, (int) r11)
            if (r0 == 0) goto L_0x0398
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zza((int) r13, (long) r4)
            goto L_0x0397
        L_0x0135:
            boolean r0 = r6.zzc(r7, (int) r13, (int) r11)
            if (r0 == 0) goto L_0x0398
            int r0 = zzc(r7, (long) r1)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzc((int) r13, (int) r0)
            goto L_0x0397
        L_0x0145:
            boolean r0 = r6.zzc(r7, (int) r13, (int) r11)
            if (r0 == 0) goto L_0x0398
            long r0 = zzd(r7, r1)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zze((int) r13, (long) r0)
            goto L_0x0397
        L_0x0155:
            boolean r0 = r6.zzc(r7, (int) r13, (int) r11)
            if (r0 == 0) goto L_0x0398
            long r0 = zzd(r7, r1)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzb((int) r13, (long) r0)
            goto L_0x0397
        L_0x0165:
            boolean r0 = r6.zzc(r7, (int) r13, (int) r11)
            if (r0 == 0) goto L_0x0398
            r4 = 0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zza((int) r13, (float) r4)
            goto L_0x0397
        L_0x0172:
            boolean r0 = r6.zzc(r7, (int) r13, (int) r11)
            if (r0 == 0) goto L_0x0398
            r4 = 0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zza((int) r13, (double) r4)
            goto L_0x0397
        L_0x0180:
            com.google.android.gms.internal.firebase-auth-api.zzakh r0 = r6.zzs
            java.lang.Object r1 = r8.getObject(r7, r1)
            java.lang.Object r2 = r6.zzf((int) r11)
            int r0 = r0.zza(r13, r1, r2)
            goto L_0x0397
        L_0x0190:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            com.google.android.gms.internal.firebase-auth-api.zzalc r1 = r6.zze((int) r11)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zza((int) r13, (java.util.List<com.google.android.gms.internal.p002firebaseauthapi.zzakk>) r0, (com.google.android.gms.internal.p002firebaseauthapi.zzalc) r1)
            goto L_0x0397
        L_0x01a0:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzh(r0)
            if (r0 <= 0) goto L_0x0398
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzg((int) r13)
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzh((int) r0)
            goto L_0x02cd
        L_0x01b6:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzg(r0)
            if (r0 <= 0) goto L_0x0398
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzg((int) r13)
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzh((int) r0)
            goto L_0x02cd
        L_0x01cc:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzd(r0)
            if (r0 <= 0) goto L_0x0398
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzg((int) r13)
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzh((int) r0)
            goto L_0x02cd
        L_0x01e2:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzc(r0)
            if (r0 <= 0) goto L_0x0398
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzg((int) r13)
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzh((int) r0)
            goto L_0x02cd
        L_0x01f8:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzb(r0)
            if (r0 <= 0) goto L_0x0398
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzg((int) r13)
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzh((int) r0)
            goto L_0x02cd
        L_0x020e:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzi(r0)
            if (r0 <= 0) goto L_0x0398
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzg((int) r13)
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzh((int) r0)
            goto L_0x02cd
        L_0x0224:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zza((java.util.List<?>) r0)
            if (r0 <= 0) goto L_0x0398
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzg((int) r13)
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzh((int) r0)
            goto L_0x02cd
        L_0x023a:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzc(r0)
            if (r0 <= 0) goto L_0x0398
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzg((int) r13)
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzh((int) r0)
            goto L_0x02cd
        L_0x0250:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzd(r0)
            if (r0 <= 0) goto L_0x0398
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzg((int) r13)
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzh((int) r0)
            goto L_0x02cd
        L_0x0265:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zze(r0)
            if (r0 <= 0) goto L_0x0398
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzg((int) r13)
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzh((int) r0)
            goto L_0x02cd
        L_0x027a:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzj(r0)
            if (r0 <= 0) goto L_0x0398
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzg((int) r13)
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzh((int) r0)
            goto L_0x02cd
        L_0x028f:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzf(r0)
            if (r0 <= 0) goto L_0x0398
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzg((int) r13)
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzh((int) r0)
            goto L_0x02cd
        L_0x02a4:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzc(r0)
            if (r0 <= 0) goto L_0x0398
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzg((int) r13)
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzh((int) r0)
            goto L_0x02cd
        L_0x02b9:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzd(r0)
            if (r0 <= 0) goto L_0x0398
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzg((int) r13)
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzh((int) r0)
        L_0x02cd:
            int r1 = r1 + r2
            int r1 = r1 + r0
            int r12 = r12 + r1
            goto L_0x0398
        L_0x02d2:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzh(r13, r0, r10)
            goto L_0x0397
        L_0x02de:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzg(r13, r0, r10)
            goto L_0x0397
        L_0x02ea:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzd(r13, r0, r10)
            goto L_0x0397
        L_0x02f6:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzc(r13, r0, r10)
            goto L_0x0397
        L_0x0302:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzb((int) r13, (java.util.List<java.lang.Integer>) r0, (boolean) r10)
            goto L_0x0397
        L_0x030e:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzi(r13, r0, r10)
            goto L_0x0397
        L_0x031a:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zza((int) r13, (java.util.List<com.google.android.gms.internal.p002firebaseauthapi.zzahm>) r0)
            goto L_0x0397
        L_0x0326:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            com.google.android.gms.internal.firebase-auth-api.zzalc r1 = r6.zze((int) r11)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzb((int) r13, (java.util.List<?>) r0, (com.google.android.gms.internal.p002firebaseauthapi.zzalc) r1)
            goto L_0x0397
        L_0x0335:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzb(r13, r0)
            goto L_0x0397
        L_0x0340:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zza((int) r13, (java.util.List<?>) r0, (boolean) r10)
            goto L_0x0397
        L_0x034b:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzc(r13, r0, r10)
            goto L_0x0397
        L_0x0356:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzd(r13, r0, r10)
            goto L_0x0397
        L_0x0361:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zze(r13, r0, r10)
            goto L_0x0397
        L_0x036c:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzj(r13, r0, r10)
            goto L_0x0397
        L_0x0377:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzf(r13, r0, r10)
            goto L_0x0397
        L_0x0382:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzc(r13, r0, r10)
            goto L_0x0397
        L_0x038d:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zzd(r13, r0, r10)
        L_0x0397:
            int r12 = r12 + r0
        L_0x0398:
            r15 = r10
            goto L_0x0584
        L_0x039b:
            r0 = r18
            r4 = r1
            r1 = r19
            r2 = r11
            r3 = r14
            r9 = r4
            r4 = r16
            r5 = r17
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x04cf
            java.lang.Object r0 = r8.getObject(r7, r9)
            com.google.android.gms.internal.firebase-auth-api.zzakk r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzakk) r0
            com.google.android.gms.internal.firebase-auth-api.zzalc r1 = r6.zze((int) r11)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zza(r13, r0, r1)
            goto L_0x04ce
        L_0x03bd:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r16
            r5 = r17
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x04cf
            long r0 = r8.getLong(r7, r9)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzd((int) r13, (long) r0)
            goto L_0x04ce
        L_0x03d8:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r16
            r5 = r17
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x04cf
            int r0 = r8.getInt(r7, r9)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zze((int) r13, (int) r0)
            goto L_0x04ce
        L_0x03f3:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r9 = r4
            r4 = r16
            r5 = r17
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x04cf
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzc((int) r13, (long) r9)
            goto L_0x04ce
        L_0x040a:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r16
            r5 = r17
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x04cf
            r0 = 0
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzd((int) r13, (int) r0)
            int r12 = r12 + r1
            goto L_0x04cf
        L_0x0422:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r16
            r5 = r17
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x04cf
            int r0 = r8.getInt(r7, r9)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zza((int) r13, (int) r0)
            goto L_0x04ce
        L_0x043d:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r16
            r5 = r17
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x04cf
            int r0 = r8.getInt(r7, r9)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzf((int) r13, (int) r0)
            goto L_0x04ce
        L_0x0458:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r16
            r5 = r17
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x04cf
            java.lang.Object r0 = r8.getObject(r7, r9)
            com.google.android.gms.internal.firebase-auth-api.zzahm r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzahm) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zza((int) r13, (com.google.android.gms.internal.p002firebaseauthapi.zzahm) r0)
            goto L_0x04ce
        L_0x0475:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r16
            r5 = r17
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x04cf
            java.lang.Object r0 = r8.getObject(r7, r9)
            com.google.android.gms.internal.firebase-auth-api.zzalc r1 = r6.zze((int) r11)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zza((int) r13, (java.lang.Object) r0, (com.google.android.gms.internal.p002firebaseauthapi.zzalc) r1)
            goto L_0x04ce
        L_0x0493:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r16
            r5 = r17
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x04cf
            java.lang.Object r0 = r8.getObject(r7, r9)
            boolean r1 = r0 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzahm
            if (r1 == 0) goto L_0x04b3
            com.google.android.gms.internal.firebase-auth-api.zzahm r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzahm) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zza((int) r13, (com.google.android.gms.internal.p002firebaseauthapi.zzahm) r0)
            goto L_0x04ce
        L_0x04b3:
            java.lang.String r0 = (java.lang.String) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zza((int) r13, (java.lang.String) r0)
            goto L_0x04ce
        L_0x04ba:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r16
            r5 = r17
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x04cf
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zza((int) r13, (boolean) r15)
        L_0x04ce:
            int r12 = r12 + r0
        L_0x04cf:
            r15 = 0
            goto L_0x0584
        L_0x04d2:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r16
            r5 = r17
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x04cf
            r15 = 0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzb((int) r13, (int) r15)
            goto L_0x0583
        L_0x04e9:
            r15 = r10
            r9 = r4
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r16
            r5 = r17
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x0584
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zza((int) r13, (long) r9)
            goto L_0x0583
        L_0x0501:
            r15 = r10
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r16
            r5 = r17
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x0584
            int r0 = r8.getInt(r7, r9)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzc((int) r13, (int) r0)
            goto L_0x0583
        L_0x051d:
            r15 = r10
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r16
            r5 = r17
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x0584
            long r0 = r8.getLong(r7, r9)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zze((int) r13, (long) r0)
            goto L_0x0583
        L_0x0538:
            r15 = r10
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r16
            r5 = r17
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x0584
            long r0 = r8.getLong(r7, r9)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzb((int) r13, (long) r0)
            goto L_0x0583
        L_0x0553:
            r15 = r10
            r4 = 0
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r9 = r4
            r4 = r16
            r5 = r17
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x0584
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zza((int) r13, (float) r9)
            goto L_0x0583
        L_0x056b:
            r15 = r10
            r4 = 0
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r9 = r4
            r4 = r16
            r5 = r17
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x0584
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaii.zza((int) r13, (double) r9)
        L_0x0583:
            int r12 = r12 + r0
        L_0x0584:
            int r11 = r11 + 3
            r0 = r14
            r10 = r15
            r1 = r16
            r9 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x000e
        L_0x058f:
            r15 = r10
            com.google.android.gms.internal.firebase-auth-api.zzamb<?, ?> r0 = r6.zzq
            java.lang.Object r1 = r0.zzd(r7)
            int r0 = r0.zza(r1)
            int r12 = r12 + r0
            boolean r0 = r6.zzh
            if (r0 == 0) goto L_0x05ed
            com.google.android.gms.internal.firebase-auth-api.zzair<?> r0 = r6.zzr
            com.google.android.gms.internal.firebase-auth-api.zzais r0 = r0.zza((java.lang.Object) r7)
            r10 = r15
        L_0x05a6:
            com.google.android.gms.internal.firebase-auth-api.zzalh<T, java.lang.Object> r1 = r0.zza
            int r1 = r1.zzb()
            if (r10 >= r1) goto L_0x05c6
            com.google.android.gms.internal.firebase-auth-api.zzalh<T, java.lang.Object> r1 = r0.zza
            java.util.Map$Entry r1 = r1.zzb((int) r10)
            java.lang.Object r2 = r1.getKey()
            com.google.android.gms.internal.firebase-auth-api.zzaiu r2 = (com.google.android.gms.internal.p002firebaseauthapi.zzaiu) r2
            java.lang.Object r1 = r1.getValue()
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzais.zza((com.google.android.gms.internal.p002firebaseauthapi.zzaiu<?>) r2, (java.lang.Object) r1)
            int r15 = r15 + r1
            int r10 = r10 + 1
            goto L_0x05a6
        L_0x05c6:
            com.google.android.gms.internal.firebase-auth-api.zzalh<T, java.lang.Object> r0 = r0.zza
            java.lang.Iterable r0 = r0.zzc()
            java.util.Iterator r0 = r0.iterator()
        L_0x05d0:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x05ec
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            com.google.android.gms.internal.firebase-auth-api.zzaiu r2 = (com.google.android.gms.internal.p002firebaseauthapi.zzaiu) r2
            java.lang.Object r1 = r1.getValue()
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzais.zza((com.google.android.gms.internal.p002firebaseauthapi.zzaiu<?>) r2, (java.lang.Object) r1)
            int r15 = r15 + r1
            goto L_0x05d0
        L_0x05ec:
            int r12 = r12 + r15
        L_0x05ed:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzako.zza(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c3, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0227, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0228, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x022c
            int r3 = r8.zzc((int) r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = r3 & r7
            int r3 = r3 >>> 20
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0219;
                case 1: goto L_0x020e;
                case 2: goto L_0x0203;
                case 3: goto L_0x01f8;
                case 4: goto L_0x01f1;
                case 5: goto L_0x01e6;
                case 6: goto L_0x01df;
                case 7: goto L_0x01d4;
                case 8: goto L_0x01c7;
                case 9: goto L_0x01b9;
                case 10: goto L_0x01ad;
                case 11: goto L_0x01a5;
                case 12: goto L_0x019d;
                case 13: goto L_0x0195;
                case 14: goto L_0x0189;
                case 15: goto L_0x0181;
                case 16: goto L_0x0175;
                case 17: goto L_0x016a;
                case 18: goto L_0x015e;
                case 19: goto L_0x015e;
                case 20: goto L_0x015e;
                case 21: goto L_0x015e;
                case 22: goto L_0x015e;
                case 23: goto L_0x015e;
                case 24: goto L_0x015e;
                case 25: goto L_0x015e;
                case 26: goto L_0x015e;
                case 27: goto L_0x015e;
                case 28: goto L_0x015e;
                case 29: goto L_0x015e;
                case 30: goto L_0x015e;
                case 31: goto L_0x015e;
                case 32: goto L_0x015e;
                case 33: goto L_0x015e;
                case 34: goto L_0x015e;
                case 35: goto L_0x015e;
                case 36: goto L_0x015e;
                case 37: goto L_0x015e;
                case 38: goto L_0x015e;
                case 39: goto L_0x015e;
                case 40: goto L_0x015e;
                case 41: goto L_0x015e;
                case 42: goto L_0x015e;
                case 43: goto L_0x015e;
                case 44: goto L_0x015e;
                case 45: goto L_0x015e;
                case 46: goto L_0x015e;
                case 47: goto L_0x015e;
                case 48: goto L_0x015e;
                case 49: goto L_0x015e;
                case 50: goto L_0x0152;
                case 51: goto L_0x013c;
                case 52: goto L_0x012a;
                case 53: goto L_0x0118;
                case 54: goto L_0x0106;
                case 55: goto L_0x00f8;
                case 56: goto L_0x00e6;
                case 57: goto L_0x00d8;
                case 58: goto L_0x00c6;
                case 59: goto L_0x00b2;
                case 60: goto L_0x00a0;
                case 61: goto L_0x008e;
                case 62: goto L_0x0080;
                case 63: goto L_0x0072;
                case 64: goto L_0x0064;
                case 65: goto L_0x0052;
                case 66: goto L_0x0044;
                case 67: goto L_0x0032;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x0228
        L_0x0020:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x0032:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajc.zza((long) r3)
            goto L_0x0227
        L_0x0044:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzc(r9, (long) r5)
            goto L_0x0227
        L_0x0052:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajc.zza((long) r3)
            goto L_0x0227
        L_0x0064:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzc(r9, (long) r5)
            goto L_0x0227
        L_0x0072:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzc(r9, (long) r5)
            goto L_0x0227
        L_0x0080:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzc(r9, (long) r5)
            goto L_0x0227
        L_0x008e:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00a0:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00b2:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00c6:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            boolean r3 = zze(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajc.zza((boolean) r3)
            goto L_0x0227
        L_0x00d8:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzc(r9, (long) r5)
            goto L_0x0227
        L_0x00e6:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajc.zza((long) r3)
            goto L_0x0227
        L_0x00f8:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzc(r9, (long) r5)
            goto L_0x0227
        L_0x0106:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajc.zza((long) r3)
            goto L_0x0227
        L_0x0118:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajc.zza((long) r3)
            goto L_0x0227
        L_0x012a:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            float r3 = zzb(r9, (long) r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x013c:
            boolean r3 = r8.zzc(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            double r3 = zza(r9, (long) r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajc.zza((long) r3)
            goto L_0x0227
        L_0x0152:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x015e:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x016a:
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
            goto L_0x01c3
        L_0x0175:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajc.zza((long) r3)
            goto L_0x0227
        L_0x0181:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r9, r5)
            goto L_0x0227
        L_0x0189:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajc.zza((long) r3)
            goto L_0x0227
        L_0x0195:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r9, r5)
            goto L_0x0227
        L_0x019d:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r9, r5)
            goto L_0x0227
        L_0x01a5:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r9, r5)
            goto L_0x0227
        L_0x01ad:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01b9:
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
        L_0x01c3:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0228
        L_0x01c7:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01d4:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzh(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajc.zza((boolean) r3)
            goto L_0x0227
        L_0x01df:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r9, r5)
            goto L_0x0227
        L_0x01e6:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajc.zza((long) r3)
            goto L_0x0227
        L_0x01f1:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r9, r5)
            goto L_0x0227
        L_0x01f8:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajc.zza((long) r3)
            goto L_0x0227
        L_0x0203:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajc.zza((long) r3)
            goto L_0x0227
        L_0x020e:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzb(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x0219:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajc.zza((long) r3)
        L_0x0227:
            int r2 = r2 + r3
        L_0x0228:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022c:
            int r2 = r2 * 53
            com.google.android.gms.internal.firebase-auth-api.zzamb<?, ?> r0 = r8.zzq
            java.lang.Object r0 = r0.zzd(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x024a
            int r2 = r2 * 53
            com.google.android.gms.internal.firebase-auth-api.zzair<?> r0 = r8.zzr
            com.google.android.gms.internal.firebase-auth-api.zzais r9 = r0.zza((java.lang.Object) r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x024a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzako.zzb(java.lang.Object):int");
    }

    private static <T> int zzc(T t, long j) {
        return ((Integer) zzamh.zze(t, j)).intValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.google.android.gms.internal.firebase-auth-api.zzame} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v44, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v45, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v46, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v51, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v53, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v44, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v44, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v39, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v48, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v45, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v46, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v49, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v66, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v67, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v70, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v75, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v52, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v60, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v76, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v61, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v45, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v54, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v29, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v54, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v55, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v77, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v56, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v79, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v80, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v81, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v83, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v57, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v64, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v88, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v90, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v92, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v58, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v65, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v95, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v96, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v97, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v99, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v101, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v47, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v56, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v70, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v102, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v66, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v59, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v48, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v57, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v71, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v68, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v60, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v104, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v105, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v59, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v73, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v61, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v60, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v74, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v42, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v109, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v61, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v75, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v44, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v115, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v62, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v76, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v118, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v119, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v120, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v122, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v124, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v63, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v77, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v46, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v97, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v70, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v64, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v78, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v126, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v128, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v129, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v130, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v73, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v133, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v135, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v137, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v138, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v139, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v105, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v141, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v142, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v78, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v79, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v65, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v79, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v53, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v80, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v144, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v108, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v148, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v149, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v153, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v81, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v155, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v109, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v54, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v42, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v156, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v158, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v82, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v160, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v43, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v162, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v163, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v164, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v166, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v168, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v44, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v169, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v170, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v171, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v173, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v175, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v45, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v176, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v83, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v46, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v47, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v48, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v179, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v180, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v182, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v49, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v85, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v112, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v86, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v72, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v114, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v64, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v56, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v73, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v57, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v115, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v65, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v76, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v21, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v99, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v47, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v93, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v58, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v67, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v78, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v187, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v117, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v59, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v68, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v79, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v188, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v25, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v54, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v189, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v80, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v69, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v60, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v26, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v55, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v190, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v27, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v56, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v191, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v57, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v28, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v193, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v58, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v29, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v195, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v30, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v31, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v124, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v84, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v70, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v62, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v33, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v61, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v198, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v34, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v199, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v35, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v201, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v64, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v36, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v203, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v65, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v37, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v204, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v66, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v38, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v206, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v207, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v209, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v210, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v39, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v92, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v67, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v40, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v93, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v212, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v41, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v68, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v95, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v213, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v96, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v75, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v69, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v42, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v214, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v43, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v70, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v44, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v215, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v100, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v64, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v102, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v78, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v137, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v46, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v216, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v103, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v79, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v65, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v42, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v48, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v43, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v68, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v106, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v82, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v140, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v67, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v220, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v142, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v84, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v68, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v108, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v51, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v44, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v121, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v72, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v129, resolved type: int} */
    /* JADX WARNING: type inference failed for: r11v69, types: [int] */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x060d  */
    /* JADX WARNING: Removed duplicated region for block: B:577:0x07b2 A[SYNTHETIC] */
    final int zza(T r33, byte[] r34, int r35, int r36, int r37, com.google.android.gms.internal.p002firebaseauthapi.zzahl r38) throws java.io.IOException {
        /*
            r32 = this;
            r6 = r32
            r7 = r33
            r15 = r34
            r4 = r36
            r5 = r37
            r2 = r38
            zzf((java.lang.Object) r33)
            sun.misc.Unsafe r3 = zzb
            r16 = 0
            r8 = r35
            r10 = r16
            r11 = r10
            r13 = r11
            r9 = -1
            r14 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001d:
            if (r8 >= r4) goto L_0x0d09
            int r11 = r8 + 1
            byte r8 = r15[r8]
            if (r8 >= 0) goto L_0x002e
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza((int) r8, (byte[]) r15, (int) r11, (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r2)
            int r11 = r2.zza
            r12 = r11
            r11 = r8
            goto L_0x002f
        L_0x002e:
            r12 = r8
        L_0x002f:
            int r8 = r12 >>> 3
            r0 = r12 & 7
            r1 = 3
            if (r8 <= r9) goto L_0x0046
            int r10 = r10 / r1
            int r9 = r6.zze
            if (r8 < r9) goto L_0x0044
            int r9 = r6.zzf
            if (r8 > r9) goto L_0x0044
            int r9 = r6.zza((int) r8, (int) r10)
            goto L_0x004a
        L_0x0044:
            r9 = -1
            goto L_0x004a
        L_0x0046:
            int r9 = r6.zza((int) r8)
        L_0x004a:
            r10 = r9
            r9 = -1
            if (r10 != r9) goto L_0x005b
            r29 = r3
            r4 = r8
            r17 = r9
            r9 = r12
            r10 = r16
            r12 = r5
            r5 = r2
            r2 = r11
            goto L_0x0ca0
        L_0x005b:
            int[] r9 = r6.zzc
            int r19 = r10 + 1
            r1 = r9[r19]
            r19 = 267386880(0xff00000, float:2.3665827E-29)
            r19 = r1 & r19
            int r4 = r19 >>> 20
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r1 & r17
            r19 = r1
            long r1 = (long) r5
            java.lang.String r5 = ""
            r21 = 0
            r23 = r1
            r2 = 1
            r1 = 17
            if (r4 > r1) goto L_0x0386
            int r1 = r10 + 2
            r1 = r9[r1]
            int r9 = r1 >>> 20
            int r20 = r2 << r9
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r9
            r17 = r10
            if (r1 == r14) goto L_0x00a3
            if (r14 == r9) goto L_0x0093
            long r9 = (long) r14
            r3.putInt(r7, r9, r13)
            r9 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0093:
            if (r1 != r9) goto L_0x0098
            r13 = r16
            goto L_0x009e
        L_0x0098:
            long r13 = (long) r1
            int r10 = r3.getInt(r7, r13)
            r13 = r10
        L_0x009e:
            r27 = r1
            r26 = r13
            goto L_0x00a7
        L_0x00a3:
            r26 = r13
            r27 = r14
        L_0x00a7:
            switch(r4) {
                case 0: goto L_0x0348;
                case 1: goto L_0x032a;
                case 2: goto L_0x02f2;
                case 3: goto L_0x02f2;
                case 4: goto L_0x02d1;
                case 5: goto L_0x02a7;
                case 6: goto L_0x0289;
                case 7: goto L_0x0263;
                case 8: goto L_0x0221;
                case 9: goto L_0x01ed;
                case 10: goto L_0x01c7;
                case 11: goto L_0x02d1;
                case 12: goto L_0x016d;
                case 13: goto L_0x0289;
                case 14: goto L_0x02a7;
                case 15: goto L_0x013d;
                case 16: goto L_0x00f0;
                case 17: goto L_0x00bb;
                default: goto L_0x00aa;
            }
        L_0x00aa:
            r13 = r36
            r14 = r37
            r23 = r8
            r18 = r12
            r8 = r38
            r12 = r3
            r3 = r17
            r17 = -1
            goto L_0x0376
        L_0x00bb:
            r1 = 3
            if (r0 != r1) goto L_0x00aa
            r0 = r17
            java.lang.Object r1 = r6.zza(r7, (int) r0)
            int r2 = r8 << 3
            r13 = r2 | 4
            com.google.android.gms.internal.firebase-auth-api.zzalc r2 = r6.zze((int) r0)
            r4 = r8
            r8 = r1
            r17 = r9
            r5 = -1
            r9 = r2
            r2 = r0
            r10 = r34
            r0 = r12
            r12 = r36
            r14 = r38
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza((java.lang.Object) r8, (com.google.android.gms.internal.p002firebaseauthapi.zzalc) r9, (byte[]) r10, (int) r11, (int) r12, (int) r13, (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r14)
            r6.zza(r7, (int) r2, (java.lang.Object) r1)
            r13 = r26 | r20
            r5 = r37
            r11 = r0
            r10 = r2
            r9 = r4
            r14 = r27
            r4 = r36
            r2 = r38
            goto L_0x001d
        L_0x00f0:
            r4 = r8
            r2 = r17
            r5 = -1
            r17 = r9
            r8 = r38
            if (r0 != 0) goto L_0x012f
            r9 = r23
            int r11 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd(r15, r11, r8)
            long r0 = r8.zzb
            long r13 = com.google.android.gms.internal.p002firebaseauthapi.zzaib.zza((long) r0)
            r1 = r17
            r0 = r3
            r17 = r5
            r5 = r1
            r1 = r33
            r28 = r2
            r18 = r12
            r12 = r3
            r2 = r9
            r9 = r36
            r10 = r37
            r23 = r4
            r4 = r13
            r0.putLong(r1, r2, r4)
            r13 = r26 | r20
            r2 = r8
            r4 = r9
            r5 = r10
            r8 = r11
            r3 = r12
            r11 = r18
            r9 = r23
        L_0x0129:
            r14 = r27
            r10 = r28
            goto L_0x001d
        L_0x012f:
            r23 = r4
            r17 = r5
            r18 = r12
            r12 = r3
            r13 = r36
            r14 = r37
            r3 = r2
            goto L_0x0376
        L_0x013d:
            r13 = r36
            r14 = r37
            r18 = r12
            r28 = r17
            r9 = r23
            r17 = -1
            r12 = r3
            r23 = r8
            r8 = r38
            if (r0 != 0) goto L_0x01c3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r11, r8)
            int r1 = r8.zza
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaib.zze(r1)
            r12.putInt(r7, r9, r1)
            r1 = r26 | r20
            r2 = r8
            r3 = r12
            r4 = r13
            r5 = r14
            r11 = r18
            r9 = r23
            r14 = r27
            r10 = r28
            goto L_0x0372
        L_0x016d:
            r13 = r36
            r14 = r37
            r18 = r12
            r28 = r17
            r9 = r23
            r17 = -1
            r12 = r3
            r23 = r8
            r8 = r38
            if (r0 != 0) goto L_0x01c3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r11, r8)
            int r1 = r8.zza
            r5 = r28
            com.google.android.gms.internal.firebase-auth-api.zzajh r3 = r6.zzd((int) r5)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r19 & r4
            if (r4 == 0) goto L_0x0193
            goto L_0x0195
        L_0x0193:
            r2 = r16
        L_0x0195:
            if (r2 == 0) goto L_0x01bd
            if (r3 == 0) goto L_0x01bd
            boolean r2 = r3.zza(r1)
            if (r2 == 0) goto L_0x01a0
            goto L_0x01bd
        L_0x01a0:
            com.google.android.gms.internal.firebase-auth-api.zzame r2 = zze((java.lang.Object) r33)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r4 = r18
            r2.zza((int) r4, (java.lang.Object) r1)
            r11 = r4
            r10 = r5
            r2 = r8
            r3 = r12
            r4 = r13
            r5 = r14
            r9 = r23
            r13 = r26
            r14 = r27
            r8 = r0
            goto L_0x001d
        L_0x01bd:
            r4 = r18
            r12.putInt(r7, r9, r1)
            goto L_0x01e3
        L_0x01c3:
            r3 = r28
            goto L_0x0376
        L_0x01c7:
            r13 = r36
            r14 = r37
            r4 = r12
            r5 = r17
            r9 = r23
            r1 = 2
            r17 = -1
            r12 = r3
            r23 = r8
            r8 = r38
            if (r0 != r1) goto L_0x021c
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza(r15, r11, r8)
            java.lang.Object r1 = r8.zzc
            r12.putObject(r7, r9, r1)
        L_0x01e3:
            r1 = r26 | r20
            r11 = r4
            r10 = r5
            r2 = r8
            r3 = r12
            r4 = r13
            r5 = r14
            goto L_0x036e
        L_0x01ed:
            r13 = r36
            r14 = r37
            r23 = r8
            r4 = r12
            r5 = r17
            r1 = 2
            r17 = -1
            r8 = r38
            r12 = r3
            if (r0 != r1) goto L_0x021c
            java.lang.Object r9 = r6.zza(r7, (int) r5)
            com.google.android.gms.internal.firebase-auth-api.zzalc r1 = r6.zze((int) r5)
            r0 = r9
            r2 = r34
            r3 = r11
            r18 = r4
            r4 = r36
            r10 = r5
            r5 = r38
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza((java.lang.Object) r0, (com.google.android.gms.internal.p002firebaseauthapi.zzalc) r1, (byte[]) r2, (int) r3, (int) r4, (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r5)
            r6.zza(r7, (int) r10, (java.lang.Object) r9)
            r1 = r26 | r20
            goto L_0x0368
        L_0x021c:
            r18 = r4
            r3 = r5
            goto L_0x0376
        L_0x0221:
            r13 = r36
            r14 = r37
            r18 = r12
            r4 = r17
            r9 = r23
            r1 = 2
            r17 = -1
            r12 = r3
            r23 = r8
            r8 = r38
            if (r0 != r1) goto L_0x0328
            boolean r0 = zzg((int) r19)
            if (r0 == 0) goto L_0x0240
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzb(r15, r11, r8)
            goto L_0x0257
        L_0x0240:
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r11, r8)
            int r1 = r8.zza
            if (r1 < 0) goto L_0x025e
            if (r1 != 0) goto L_0x024d
            r8.zzc = r5
            goto L_0x0257
        L_0x024d:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajc.zza
            r2.<init>(r15, r0, r1, r3)
            r8.zzc = r2
            int r0 = r0 + r1
        L_0x0257:
            java.lang.Object r1 = r8.zzc
            r12.putObject(r7, r9, r1)
            goto L_0x02ed
        L_0x025e:
            com.google.android.gms.internal.firebase-auth-api.zzajj r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzf()
            throw r0
        L_0x0263:
            r13 = r36
            r14 = r37
            r18 = r12
            r4 = r17
            r9 = r23
            r17 = -1
            r12 = r3
            r23 = r8
            r8 = r38
            if (r0 != 0) goto L_0x0328
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd(r15, r11, r8)
            long r2 = r8.zzb
            int r1 = (r2 > r21 ? 1 : (r2 == r21 ? 0 : -1))
            if (r1 == 0) goto L_0x0282
            r2 = 1
            goto L_0x0284
        L_0x0282:
            r2 = r16
        L_0x0284:
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc((java.lang.Object) r7, (long) r9, (boolean) r2)
            goto L_0x02ed
        L_0x0289:
            r13 = r36
            r14 = r37
            r18 = r12
            r4 = r17
            r9 = r23
            r1 = 5
            r17 = -1
            r12 = r3
            r23 = r8
            r8 = r38
            if (r0 != r1) goto L_0x0328
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r11)
            r12.putInt(r7, r9, r0)
            int r0 = r11 + 4
            goto L_0x02ed
        L_0x02a7:
            r13 = r36
            r14 = r37
            r1 = r2
            r18 = r12
            r4 = r17
            r9 = r23
            r17 = -1
            r12 = r3
            r23 = r8
            r8 = r38
            if (r0 != r1) goto L_0x0328
            long r21 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd(r15, r11)
            r0 = r12
            r1 = r33
            r2 = r9
            r9 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            int r0 = r11 + 8
            r1 = r26 | r20
            r2 = r8
            r10 = r9
            goto L_0x0369
        L_0x02d1:
            r13 = r36
            r14 = r37
            r18 = r12
            r4 = r17
            r9 = r23
            r17 = -1
            r12 = r3
            r23 = r8
            r8 = r38
            if (r0 != 0) goto L_0x0328
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r11, r8)
            int r1 = r8.zza
            r12.putInt(r7, r9, r1)
        L_0x02ed:
            r1 = r26 | r20
            r10 = r4
            goto L_0x0368
        L_0x02f2:
            r13 = r36
            r14 = r37
            r18 = r12
            r4 = r17
            r9 = r23
            r17 = -1
            r12 = r3
            r23 = r8
            r8 = r38
            if (r0 != 0) goto L_0x0328
            int r11 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd(r15, r11, r8)
            long r2 = r8.zzb
            r0 = r12
            r1 = r33
            r21 = r2
            r2 = r9
            r9 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            r0 = r26 | r20
            r2 = r8
            r10 = r9
            r8 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r11 = r18
            r9 = r23
            r14 = r27
            r13 = r0
            goto L_0x001d
        L_0x0328:
            r3 = r4
            goto L_0x0376
        L_0x032a:
            r13 = r36
            r14 = r37
            r18 = r12
            r9 = r23
            r1 = 5
            r12 = r3
            r23 = r8
            r3 = r17
            r17 = -1
            r8 = r38
            if (r0 != r1) goto L_0x0376
            float r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzb(r15, r11)
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r7, (long) r9, (float) r0)
            int r0 = r11 + 4
            goto L_0x0365
        L_0x0348:
            r13 = r36
            r14 = r37
            r1 = r2
            r18 = r12
            r9 = r23
            r12 = r3
            r23 = r8
            r3 = r17
            r17 = -1
            r8 = r38
            if (r0 != r1) goto L_0x0376
            double r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza(r15, r11)
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r7, (long) r9, (double) r0)
            int r0 = r11 + 8
        L_0x0365:
            r1 = r26 | r20
            r10 = r3
        L_0x0368:
            r2 = r8
        L_0x0369:
            r3 = r12
            r4 = r13
            r5 = r14
            r11 = r18
        L_0x036e:
            r9 = r23
            r14 = r27
        L_0x0372:
            r8 = r0
            r13 = r1
            goto L_0x001d
        L_0x0376:
            r10 = r3
            r5 = r8
            r2 = r11
            r29 = r12
            r12 = r14
            r9 = r18
            r4 = r23
            r13 = r26
            r14 = r27
            goto L_0x0ca0
        L_0x0386:
            r18 = r12
            r1 = r23
            r17 = -1
            r12 = r3
            r23 = r8
            r3 = r10
            r8 = r38
            r10 = 27
            r20 = 10
            if (r4 != r10) goto L_0x03f0
            r10 = 2
            if (r0 != r10) goto L_0x03e2
            java.lang.Object r0 = r12.getObject(r7, r1)
            com.google.android.gms.internal.firebase-auth-api.zzajg r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzajg) r0
            boolean r4 = r0.zzc()
            if (r4 != 0) goto L_0x03b9
            int r4 = r0.size()
            if (r4 != 0) goto L_0x03ae
            goto L_0x03b0
        L_0x03ae:
            int r20 = r4 << 1
        L_0x03b0:
            r4 = r20
            com.google.android.gms.internal.firebase-auth-api.zzajg r0 = r0.zza(r4)
            r12.putObject(r7, r1, r0)
        L_0x03b9:
            com.google.android.gms.internal.firebase-auth-api.zzalc r1 = r6.zze((int) r3)
            r2 = r8
            r8 = r1
            r9 = r18
            r10 = r34
            r1 = r12
            r4 = r18
            r12 = r36
            r26 = r13
            r13 = r0
            r27 = r14
            r14 = r38
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza((com.google.android.gms.internal.p002firebaseauthapi.zzalc<?>) r8, (int) r9, (byte[]) r10, (int) r11, (int) r12, (com.google.android.gms.internal.p002firebaseauthapi.zzajg<?>) r13, (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r14)
            r5 = r37
            r10 = r3
            r11 = r4
            r9 = r23
            r13 = r26
            r14 = r27
            r4 = r36
            r3 = r1
            goto L_0x001d
        L_0x03e2:
            r26 = r13
            r27 = r14
            r13 = r36
            r28 = r3
            r14 = r8
            r25 = r12
            r12 = r11
            goto L_0x0a06
        L_0x03f0:
            r26 = r13
            r27 = r14
            r14 = r8
            r13 = r12
            r12 = r18
            r8 = 49
            if (r4 > r8) goto L_0x08d5
            r8 = r19
            long r8 = (long) r8
            sun.misc.Unsafe r10 = zzb
            java.lang.Object r18 = r10.getObject(r7, r1)
            r19 = r13
            r13 = r18
            com.google.android.gms.internal.firebase-auth-api.zzajg r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzajg) r13
            boolean r18 = r13.zzc()
            if (r18 != 0) goto L_0x0427
            int r18 = r13.size()
            if (r18 != 0) goto L_0x0418
            goto L_0x041a
        L_0x0418:
            int r20 = r18 << 1
        L_0x041a:
            r18 = r5
            r5 = r20
            com.google.android.gms.internal.firebase-auth-api.zzajg r5 = r13.zza(r5)
            r10.putObject(r7, r1, r5)
            r13 = r5
            goto L_0x0429
        L_0x0427:
            r18 = r5
        L_0x0429:
            switch(r4) {
                case 18: goto L_0x0866;
                case 19: goto L_0x081a;
                case 20: goto L_0x07cf;
                case 21: goto L_0x07cf;
                case 22: goto L_0x07a2;
                case 23: goto L_0x074f;
                case 24: goto L_0x0704;
                case 25: goto L_0x06a1;
                case 26: goto L_0x05da;
                case 27: goto L_0x05b0;
                case 28: goto L_0x0554;
                case 29: goto L_0x07a2;
                case 30: goto L_0x0520;
                case 31: goto L_0x0704;
                case 32: goto L_0x074f;
                case 33: goto L_0x04d0;
                case 34: goto L_0x0480;
                case 35: goto L_0x0866;
                case 36: goto L_0x081a;
                case 37: goto L_0x07cf;
                case 38: goto L_0x07cf;
                case 39: goto L_0x07a2;
                case 40: goto L_0x074f;
                case 41: goto L_0x0704;
                case 42: goto L_0x06a1;
                case 43: goto L_0x07a2;
                case 44: goto L_0x0520;
                case 45: goto L_0x0704;
                case 46: goto L_0x074f;
                case 47: goto L_0x04d0;
                case 48: goto L_0x0480;
                case 49: goto L_0x0437;
                default: goto L_0x042c;
            }
        L_0x042c:
            r10 = r36
            r9 = r37
            r7 = r3
        L_0x0431:
            r8 = r11
            r11 = r12
            r12 = r19
            goto L_0x08b1
        L_0x0437:
            r1 = 3
            if (r0 != r1) goto L_0x047b
            com.google.android.gms.internal.firebase-auth-api.zzalc r8 = r6.zze((int) r3)
            r0 = r12 & -8
            r9 = r0 | 4
            r0 = r8
            r10 = r37
            r1 = r34
            r5 = r36
            r2 = r11
            r4 = r3
            r3 = r36
            r7 = r4
            r4 = r9
            r10 = r5
            r5 = r38
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza((com.google.android.gms.internal.p002firebaseauthapi.zzalc) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r5)
            java.lang.Object r1 = r14.zzc
            r13.add(r1)
        L_0x045b:
            if (r0 >= r10) goto L_0x0477
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r0, r14)
            int r1 = r14.zza
            if (r12 != r1) goto L_0x0477
            r0 = r8
            r1 = r34
            r3 = r36
            r4 = r9
            r5 = r38
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza((com.google.android.gms.internal.p002firebaseauthapi.zzalc) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r5)
            java.lang.Object r1 = r14.zzc
            r13.add(r1)
            goto L_0x045b
        L_0x0477:
            r9 = r37
            goto L_0x054e
        L_0x047b:
            r7 = r3
            r10 = r36
            goto L_0x05d6
        L_0x0480:
            r10 = r36
            r7 = r3
            r1 = 2
            if (r0 != r1) goto L_0x04a7
            com.google.android.gms.internal.firebase-auth-api.zzajz r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzajz) r13
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r11, r14)
            int r1 = r14.zza
            int r1 = r1 + r0
        L_0x048f:
            if (r0 >= r1) goto L_0x049f
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd(r15, r0, r14)
            long r2 = r14.zzb
            long r2 = com.google.android.gms.internal.p002firebaseauthapi.zzaib.zza((long) r2)
            r13.zza((long) r2)
            goto L_0x048f
        L_0x049f:
            if (r0 != r1) goto L_0x04a2
            goto L_0x0477
        L_0x04a2:
            com.google.android.gms.internal.firebase-auth-api.zzajj r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzi()
            throw r0
        L_0x04a7:
            if (r0 != 0) goto L_0x05d6
            com.google.android.gms.internal.firebase-auth-api.zzajz r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzajz) r13
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd(r15, r11, r14)
            long r1 = r14.zzb
            long r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaib.zza((long) r1)
            r13.zza((long) r1)
        L_0x04b8:
            if (r0 >= r10) goto L_0x0477
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r0, r14)
            int r2 = r14.zza
            if (r12 != r2) goto L_0x0477
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd(r15, r1, r14)
            long r1 = r14.zzb
            long r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaib.zza((long) r1)
            r13.zza((long) r1)
            goto L_0x04b8
        L_0x04d0:
            r10 = r36
            r7 = r3
            r1 = 2
            if (r0 != r1) goto L_0x04f7
            com.google.android.gms.internal.firebase-auth-api.zzajd r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzajd) r13
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r11, r14)
            int r1 = r14.zza
            int r1 = r1 + r0
        L_0x04df:
            if (r0 >= r1) goto L_0x04ef
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r0, r14)
            int r2 = r14.zza
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzaib.zze(r2)
            r13.zzc(r2)
            goto L_0x04df
        L_0x04ef:
            if (r0 != r1) goto L_0x04f2
            goto L_0x0477
        L_0x04f2:
            com.google.android.gms.internal.firebase-auth-api.zzajj r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzi()
            throw r0
        L_0x04f7:
            if (r0 != 0) goto L_0x05d6
            com.google.android.gms.internal.firebase-auth-api.zzajd r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzajd) r13
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r11, r14)
            int r1 = r14.zza
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaib.zze(r1)
            r13.zzc(r1)
        L_0x0508:
            if (r0 >= r10) goto L_0x0477
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r0, r14)
            int r2 = r14.zza
            if (r12 != r2) goto L_0x0477
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r1, r14)
            int r1 = r14.zza
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaib.zze(r1)
            r13.zzc(r1)
            goto L_0x0508
        L_0x0520:
            r10 = r36
            r7 = r3
            r1 = 2
            if (r0 != r1) goto L_0x052c
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza((byte[]) r15, (int) r11, (com.google.android.gms.internal.p002firebaseauthapi.zzajg<?>) r13, (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r14)
        L_0x052a:
            r8 = r0
            goto L_0x053c
        L_0x052c:
            if (r0 != 0) goto L_0x05d6
            r0 = r12
            r1 = r34
            r2 = r11
            r3 = r36
            r4 = r13
            r5 = r38
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.p002firebaseauthapi.zzajg<?>) r4, (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r5)
            goto L_0x052a
        L_0x053c:
            com.google.android.gms.internal.firebase-auth-api.zzajh r3 = r6.zzd((int) r7)
            r4 = 0
            com.google.android.gms.internal.firebase-auth-api.zzamb<?, ?> r5 = r6.zzq
            r0 = r33
            r1 = r23
            r2 = r13
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zza(r0, r1, r2, r3, r4, r5)
            r9 = r37
            r0 = r8
        L_0x054e:
            r8 = r11
            r11 = r12
            r12 = r19
            goto L_0x08b2
        L_0x0554:
            r10 = r36
            r7 = r3
            r1 = 2
            if (r0 != r1) goto L_0x05d6
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r11, r14)
            int r1 = r14.zza
            if (r1 < 0) goto L_0x05ab
            int r2 = r15.length
            int r2 = r2 - r0
            if (r1 > r2) goto L_0x05a6
            if (r1 != 0) goto L_0x056e
            com.google.android.gms.internal.firebase-auth-api.zzahm r1 = com.google.android.gms.internal.p002firebaseauthapi.zzahm.zza
            r13.add(r1)
            goto L_0x0576
        L_0x056e:
            com.google.android.gms.internal.firebase-auth-api.zzahm r2 = com.google.android.gms.internal.p002firebaseauthapi.zzahm.zza((byte[]) r15, (int) r0, (int) r1)
            r13.add(r2)
        L_0x0575:
            int r0 = r0 + r1
        L_0x0576:
            if (r0 >= r10) goto L_0x0477
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r0, r14)
            int r2 = r14.zza
            if (r12 != r2) goto L_0x0477
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r1, r14)
            int r1 = r14.zza
            if (r1 < 0) goto L_0x05a1
            int r2 = r15.length
            int r2 = r2 - r0
            if (r1 > r2) goto L_0x059c
            if (r1 != 0) goto L_0x0594
            com.google.android.gms.internal.firebase-auth-api.zzahm r1 = com.google.android.gms.internal.p002firebaseauthapi.zzahm.zza
            r13.add(r1)
            goto L_0x0576
        L_0x0594:
            com.google.android.gms.internal.firebase-auth-api.zzahm r2 = com.google.android.gms.internal.p002firebaseauthapi.zzahm.zza((byte[]) r15, (int) r0, (int) r1)
            r13.add(r2)
            goto L_0x0575
        L_0x059c:
            com.google.android.gms.internal.firebase-auth-api.zzajj r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzi()
            throw r0
        L_0x05a1:
            com.google.android.gms.internal.firebase-auth-api.zzajj r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzf()
            throw r0
        L_0x05a6:
            com.google.android.gms.internal.firebase-auth-api.zzajj r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzi()
            throw r0
        L_0x05ab:
            com.google.android.gms.internal.firebase-auth-api.zzajj r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzf()
            throw r0
        L_0x05b0:
            r10 = r36
            r7 = r3
            r1 = 2
            if (r0 != r1) goto L_0x05d6
            com.google.android.gms.internal.firebase-auth-api.zzalc r8 = r6.zze((int) r7)
            r9 = r12
            r4 = r37
            r5 = r10
            r10 = r34
            r3 = r11
            r2 = r12
            r12 = r36
            r1 = r19
            r0 = r14
            r14 = r38
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza((com.google.android.gms.internal.p002firebaseauthapi.zzalc<?>) r8, (int) r9, (byte[]) r10, (int) r11, (int) r12, (com.google.android.gms.internal.p002firebaseauthapi.zzajg<?>) r13, (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r14)
            r14 = r0
            r12 = r1
            r11 = r2
            r9 = r4
            r10 = r5
            r0 = r8
            r8 = r3
            goto L_0x08b2
        L_0x05d6:
            r9 = r37
            goto L_0x0431
        L_0x05da:
            r5 = r36
            r4 = r37
            r7 = r3
            r3 = r11
            r2 = r12
            r1 = r19
            r10 = 2
            if (r0 != r10) goto L_0x069a
            r10 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r8 & r10
            int r0 = (r8 > r21 ? 1 : (r8 == r21 ? 0 : -1))
            if (r0 != 0) goto L_0x0638
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r3, r14)
            int r8 = r14.zza
            if (r8 < 0) goto L_0x0633
            if (r8 != 0) goto L_0x05fe
            r10 = r18
            r13.add(r10)
            goto L_0x060b
        L_0x05fe:
            r10 = r18
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r11 = com.google.android.gms.internal.p002firebaseauthapi.zzajc.zza
            r9.<init>(r15, r0, r8, r11)
            r13.add(r9)
        L_0x060a:
            int r0 = r0 + r8
        L_0x060b:
            if (r0 >= r5) goto L_0x07b2
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r0, r14)
            int r9 = r14.zza
            if (r2 != r9) goto L_0x07b2
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r8, r14)
            int r8 = r14.zza
            if (r8 < 0) goto L_0x062e
            if (r8 != 0) goto L_0x0623
            r13.add(r10)
            goto L_0x060b
        L_0x0623:
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r11 = com.google.android.gms.internal.p002firebaseauthapi.zzajc.zza
            r9.<init>(r15, r0, r8, r11)
            r13.add(r9)
            goto L_0x060a
        L_0x062e:
            com.google.android.gms.internal.firebase-auth-api.zzajj r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzf()
            throw r0
        L_0x0633:
            com.google.android.gms.internal.firebase-auth-api.zzajj r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzf()
            throw r0
        L_0x0638:
            r10 = r18
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r3, r14)
            int r8 = r14.zza
            if (r8 < 0) goto L_0x0695
            if (r8 != 0) goto L_0x0648
            r13.add(r10)
            goto L_0x065b
        L_0x0648:
            int r9 = r0 + r8
            boolean r11 = com.google.android.gms.internal.p002firebaseauthapi.zzaml.zzc(r15, r0, r9)
            if (r11 == 0) goto L_0x0690
            java.lang.String r11 = new java.lang.String
            java.nio.charset.Charset r12 = com.google.android.gms.internal.p002firebaseauthapi.zzajc.zza
            r11.<init>(r15, r0, r8, r12)
            r13.add(r11)
        L_0x065a:
            r0 = r9
        L_0x065b:
            if (r0 >= r5) goto L_0x07b2
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r0, r14)
            int r9 = r14.zza
            if (r2 != r9) goto L_0x07b2
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r8, r14)
            int r8 = r14.zza
            if (r8 < 0) goto L_0x068b
            if (r8 != 0) goto L_0x0673
            r13.add(r10)
            goto L_0x065b
        L_0x0673:
            int r9 = r0 + r8
            boolean r11 = com.google.android.gms.internal.p002firebaseauthapi.zzaml.zzc(r15, r0, r9)
            if (r11 == 0) goto L_0x0686
            java.lang.String r11 = new java.lang.String
            java.nio.charset.Charset r12 = com.google.android.gms.internal.p002firebaseauthapi.zzajc.zza
            r11.<init>(r15, r0, r8, r12)
            r13.add(r11)
            goto L_0x065a
        L_0x0686:
            com.google.android.gms.internal.firebase-auth-api.zzajj r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzd()
            throw r0
        L_0x068b:
            com.google.android.gms.internal.firebase-auth-api.zzajj r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzf()
            throw r0
        L_0x0690:
            com.google.android.gms.internal.firebase-auth-api.zzajj r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzd()
            throw r0
        L_0x0695:
            com.google.android.gms.internal.firebase-auth-api.zzajj r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzf()
            throw r0
        L_0x069a:
            r12 = r1
            r11 = r2
            r8 = r3
            r9 = r4
            r10 = r5
            goto L_0x08b1
        L_0x06a1:
            r5 = r36
            r4 = r37
            r7 = r3
            r3 = r11
            r2 = r12
            r1 = r19
            r8 = 2
            if (r0 != r8) goto L_0x06d3
            com.google.android.gms.internal.firebase-auth-api.zzahk r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzahk) r13
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r3, r14)
            int r8 = r14.zza
            int r8 = r8 + r0
        L_0x06b6:
            if (r0 >= r8) goto L_0x06ca
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd(r15, r0, r14)
            long r9 = r14.zzb
            int r9 = (r9 > r21 ? 1 : (r9 == r21 ? 0 : -1))
            if (r9 == 0) goto L_0x06c4
            r9 = 1
            goto L_0x06c6
        L_0x06c4:
            r9 = r16
        L_0x06c6:
            r13.zza((boolean) r9)
            goto L_0x06b6
        L_0x06ca:
            if (r0 != r8) goto L_0x06ce
            goto L_0x0772
        L_0x06ce:
            com.google.android.gms.internal.firebase-auth-api.zzajj r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzi()
            throw r0
        L_0x06d3:
            if (r0 != 0) goto L_0x069a
            com.google.android.gms.internal.firebase-auth-api.zzahk r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzahk) r13
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd(r15, r3, r14)
            long r8 = r14.zzb
            int r8 = (r8 > r21 ? 1 : (r8 == r21 ? 0 : -1))
            if (r8 == 0) goto L_0x06e3
            r8 = 1
            goto L_0x06e5
        L_0x06e3:
            r8 = r16
        L_0x06e5:
            r13.zza((boolean) r8)
        L_0x06e8:
            if (r0 >= r5) goto L_0x07b2
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r0, r14)
            int r9 = r14.zza
            if (r2 != r9) goto L_0x07b2
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd(r15, r8, r14)
            long r8 = r14.zzb
            int r8 = (r8 > r21 ? 1 : (r8 == r21 ? 0 : -1))
            if (r8 == 0) goto L_0x06fe
            r8 = 1
            goto L_0x0700
        L_0x06fe:
            r8 = r16
        L_0x0700:
            r13.zza((boolean) r8)
            goto L_0x06e8
        L_0x0704:
            r5 = r36
            r4 = r37
            r7 = r3
            r3 = r11
            r2 = r12
            r1 = r19
            r8 = 2
            if (r0 != r8) goto L_0x072d
            com.google.android.gms.internal.firebase-auth-api.zzajd r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzajd) r13
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r3, r14)
            int r8 = r14.zza
            int r8 = r8 + r0
        L_0x0719:
            if (r0 >= r8) goto L_0x0725
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r0)
            r13.zzc(r9)
            int r0 = r0 + 4
            goto L_0x0719
        L_0x0725:
            if (r0 != r8) goto L_0x0728
            goto L_0x0772
        L_0x0728:
            com.google.android.gms.internal.firebase-auth-api.zzajj r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzi()
            throw r0
        L_0x072d:
            r8 = 5
            if (r0 != r8) goto L_0x069a
            com.google.android.gms.internal.firebase-auth-api.zzajd r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzajd) r13
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r3)
            r13.zzc(r0)
            int r11 = r3 + 4
        L_0x073b:
            if (r11 >= r5) goto L_0x079a
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r11, r14)
            int r8 = r14.zza
            if (r2 != r8) goto L_0x079a
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r0)
            r13.zzc(r8)
            int r11 = r0 + 4
            goto L_0x073b
        L_0x074f:
            r5 = r36
            r4 = r37
            r7 = r3
            r3 = r11
            r2 = r12
            r1 = r19
            r8 = 2
            if (r0 != r8) goto L_0x0778
            com.google.android.gms.internal.firebase-auth-api.zzajz r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzajz) r13
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r3, r14)
            int r8 = r14.zza
            int r8 = r8 + r0
        L_0x0764:
            if (r0 >= r8) goto L_0x0770
            long r9 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd(r15, r0)
            r13.zza((long) r9)
            int r0 = r0 + 8
            goto L_0x0764
        L_0x0770:
            if (r0 != r8) goto L_0x0773
        L_0x0772:
            goto L_0x07b2
        L_0x0773:
            com.google.android.gms.internal.firebase-auth-api.zzajj r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzi()
            throw r0
        L_0x0778:
            r8 = 1
            if (r0 != r8) goto L_0x069a
            com.google.android.gms.internal.firebase-auth-api.zzajz r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzajz) r13
            long r8 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd(r15, r3)
            r13.zza((long) r8)
            int r11 = r3 + 8
        L_0x0786:
            if (r11 >= r5) goto L_0x079a
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r11, r14)
            int r8 = r14.zza
            if (r2 != r8) goto L_0x079a
            long r8 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd(r15, r0)
            r13.zza((long) r8)
            int r11 = r0 + 8
            goto L_0x0786
        L_0x079a:
            r12 = r1
            r8 = r3
            r9 = r4
            r10 = r5
            r0 = r11
            r11 = r2
            goto L_0x08b2
        L_0x07a2:
            r5 = r36
            r4 = r37
            r7 = r3
            r3 = r11
            r2 = r12
            r1 = r19
            r8 = 2
            if (r0 != r8) goto L_0x07b9
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza((byte[]) r15, (int) r3, (com.google.android.gms.internal.p002firebaseauthapi.zzajg<?>) r13, (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r14)
        L_0x07b2:
            r12 = r1
            r11 = r2
            r8 = r3
            r9 = r4
            r10 = r5
            goto L_0x08b2
        L_0x07b9:
            if (r0 != 0) goto L_0x069a
            r0 = r2
            r12 = r1
            r1 = r34
            r11 = r2
            r2 = r3
            r8 = r3
            r3 = r36
            r9 = r4
            r4 = r13
            r10 = r5
            r5 = r38
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.p002firebaseauthapi.zzajg<?>) r4, (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r5)
            goto L_0x08b2
        L_0x07cf:
            r10 = r36
            r9 = r37
            r7 = r3
            r8 = r11
            r11 = r12
            r12 = r19
            r1 = 2
            if (r0 != r1) goto L_0x07f9
            com.google.android.gms.internal.firebase-auth-api.zzajz r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzajz) r13
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r8, r14)
            int r1 = r14.zza
            int r1 = r1 + r0
        L_0x07e4:
            if (r0 >= r1) goto L_0x07f0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd(r15, r0, r14)
            long r2 = r14.zzb
            r13.zza((long) r2)
            goto L_0x07e4
        L_0x07f0:
            if (r0 != r1) goto L_0x07f4
            goto L_0x08b2
        L_0x07f4:
            com.google.android.gms.internal.firebase-auth-api.zzajj r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzi()
            throw r0
        L_0x07f9:
            if (r0 != 0) goto L_0x08b1
            com.google.android.gms.internal.firebase-auth-api.zzajz r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzajz) r13
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd(r15, r8, r14)
            long r1 = r14.zzb
            r13.zza((long) r1)
        L_0x0806:
            if (r0 >= r10) goto L_0x08b2
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r0, r14)
            int r2 = r14.zza
            if (r11 != r2) goto L_0x08b2
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd(r15, r1, r14)
            long r1 = r14.zzb
            r13.zza((long) r1)
            goto L_0x0806
        L_0x081a:
            r10 = r36
            r9 = r37
            r7 = r3
            r8 = r11
            r11 = r12
            r12 = r19
            r1 = 2
            if (r0 != r1) goto L_0x0844
            com.google.android.gms.internal.firebase-auth-api.zzaiy r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzaiy) r13
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r8, r14)
            int r1 = r14.zza
            int r1 = r1 + r0
        L_0x082f:
            if (r0 >= r1) goto L_0x083b
            float r2 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzb(r15, r0)
            r13.zza((float) r2)
            int r0 = r0 + 4
            goto L_0x082f
        L_0x083b:
            if (r0 != r1) goto L_0x083f
            goto L_0x08b2
        L_0x083f:
            com.google.android.gms.internal.firebase-auth-api.zzajj r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzi()
            throw r0
        L_0x0844:
            r1 = 5
            if (r0 != r1) goto L_0x08b1
            com.google.android.gms.internal.firebase-auth-api.zzaiy r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzaiy) r13
            float r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzb(r15, r8)
            r13.zza((float) r0)
            int r0 = r8 + 4
        L_0x0852:
            if (r0 >= r10) goto L_0x08b2
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r0, r14)
            int r2 = r14.zza
            if (r11 != r2) goto L_0x08b2
            float r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzb(r15, r1)
            r13.zza((float) r0)
            int r0 = r1 + 4
            goto L_0x0852
        L_0x0866:
            r10 = r36
            r9 = r37
            r7 = r3
            r8 = r11
            r11 = r12
            r12 = r19
            r1 = 2
            if (r0 != r1) goto L_0x088f
            com.google.android.gms.internal.firebase-auth-api.zzain r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzain) r13
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r8, r14)
            int r1 = r14.zza
            int r1 = r1 + r0
        L_0x087b:
            if (r0 >= r1) goto L_0x0887
            double r2 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza(r15, r0)
            r13.zza((double) r2)
            int r0 = r0 + 8
            goto L_0x087b
        L_0x0887:
            if (r0 != r1) goto L_0x088a
            goto L_0x08b2
        L_0x088a:
            com.google.android.gms.internal.firebase-auth-api.zzajj r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzi()
            throw r0
        L_0x088f:
            r1 = 1
            if (r0 != r1) goto L_0x08b1
            com.google.android.gms.internal.firebase-auth-api.zzain r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzain) r13
            double r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza(r15, r8)
            r13.zza((double) r0)
            int r0 = r8 + 8
        L_0x089d:
            if (r0 >= r10) goto L_0x08b2
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r0, r14)
            int r2 = r14.zza
            if (r11 != r2) goto L_0x08b2
            double r2 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza(r15, r1)
            r13.zza((double) r2)
            int r0 = r1 + 8
            goto L_0x089d
        L_0x08b1:
            r0 = r8
        L_0x08b2:
            if (r0 != r8) goto L_0x08c5
            r2 = r0
            r10 = r7
            r29 = r12
            r5 = r14
            r4 = r23
            r13 = r26
            r14 = r27
            r7 = r33
            r12 = r9
            r9 = r11
            goto L_0x0ca0
        L_0x08c5:
            r8 = r0
            r5 = r9
            r4 = r10
            r3 = r12
            r2 = r14
            r9 = r23
            r13 = r26
            r14 = r27
            r10 = r7
            r7 = r33
            goto L_0x001d
        L_0x08d5:
            r7 = r3
            r10 = r5
            r3 = r11
            r11 = r12
            r12 = r13
            r8 = r19
            r13 = r36
            r5 = 50
            if (r4 != r5) goto L_0x0a18
            r5 = 2
            if (r0 != r5) goto L_0x09fd
            sun.misc.Unsafe r0 = zzb
            java.lang.Object r4 = r6.zzf((int) r7)
            r8 = r7
            r7 = r33
            java.lang.Object r5 = r0.getObject(r7, r1)
            com.google.android.gms.internal.firebase-auth-api.zzakh r9 = r6.zzs
            boolean r9 = r9.zzf(r5)
            if (r9 == 0) goto L_0x0909
            com.google.android.gms.internal.firebase-auth-api.zzakh r9 = r6.zzs
            java.lang.Object r9 = r9.zzb(r4)
            com.google.android.gms.internal.firebase-auth-api.zzakh r10 = r6.zzs
            r10.zza(r9, r5)
            r0.putObject(r7, r1, r9)
            r5 = r9
        L_0x0909:
            com.google.android.gms.internal.firebase-auth-api.zzakh r0 = r6.zzs
            com.google.android.gms.internal.firebase-auth-api.zzakf r9 = r0.zza(r4)
            com.google.android.gms.internal.firebase-auth-api.zzakh r0 = r6.zzs
            java.util.Map r10 = r0.zze(r5)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r3, r14)
            int r1 = r14.zza
            if (r1 < 0) goto L_0x09f8
            int r2 = r13 - r0
            if (r1 > r2) goto L_0x09f8
            int r5 = r0 + r1
            K r1 = r9.zzb
            V r2 = r9.zzd
            r4 = r1
        L_0x0928:
            if (r0 >= r5) goto L_0x09c8
            int r1 = r0 + 1
            byte r0 = r15[r0]
            if (r0 >= 0) goto L_0x093b
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza((int) r0, (byte[]) r15, (int) r1, (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r14)
            int r1 = r14.zza
            r30 = r1
            r1 = r0
            r0 = r30
        L_0x093b:
            r35 = r2
            int r2 = r0 >>> 3
            r18 = r3
            r3 = r0 & 7
            r19 = r4
            r4 = 1
            if (r2 == r4) goto L_0x0991
            r4 = 2
            if (r2 == r4) goto L_0x095a
            r2 = r35
            r28 = r8
            r25 = r12
            r12 = r18
            r8 = r19
            r18 = r11
            r11 = r5
            goto L_0x09b9
        L_0x095a:
            com.google.android.gms.internal.firebase-auth-api.zzamo r2 = r9.zzc
            int r2 = r2.zza()
            if (r3 != r2) goto L_0x0985
            com.google.android.gms.internal.firebase-auth-api.zzamo r3 = r9.zzc
            V r0 = r9.zzd
            java.lang.Class r20 = r0.getClass()
            r0 = r34
            r25 = r12
            r12 = 1
            r2 = r36
            r12 = r18
            r28 = r8
            r8 = r19
            r4 = r20
            r18 = r11
            r11 = r5
            r5 = r38
            int r0 = zza((byte[]) r0, (int) r1, (int) r2, (com.google.android.gms.internal.p002firebaseauthapi.zzamo) r3, (java.lang.Class<?>) r4, (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r5)
            java.lang.Object r2 = r14.zzc
            goto L_0x09bd
        L_0x0985:
            r28 = r8
            r25 = r12
            r12 = r18
            r8 = r19
            r18 = r11
            r11 = r5
            goto L_0x09b7
        L_0x0991:
            r28 = r8
            r25 = r12
            r12 = r18
            r8 = r19
            r18 = r11
            r11 = r5
            com.google.android.gms.internal.firebase-auth-api.zzamo r2 = r9.zza
            int r2 = r2.zza()
            if (r3 != r2) goto L_0x09b7
            com.google.android.gms.internal.firebase-auth-api.zzamo r3 = r9.zza
            r4 = 0
            r0 = r34
            r8 = r35
            r2 = r36
            r5 = r38
            int r0 = zza((byte[]) r0, (int) r1, (int) r2, (com.google.android.gms.internal.p002firebaseauthapi.zzamo) r3, (java.lang.Class<?>) r4, (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r5)
            java.lang.Object r4 = r14.zzc
            r2 = r8
            goto L_0x09be
        L_0x09b7:
            r2 = r35
        L_0x09b9:
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza((int) r0, (byte[]) r15, (int) r1, (int) r13, (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r14)
        L_0x09bd:
            r4 = r8
        L_0x09be:
            r5 = r11
            r3 = r12
            r11 = r18
            r12 = r25
            r8 = r28
            goto L_0x0928
        L_0x09c8:
            r28 = r8
            r18 = r11
            r25 = r12
            r12 = r3
            r8 = r4
            r11 = r5
            if (r0 != r11) goto L_0x09f3
            r10.put(r8, r2)
            if (r11 != r12) goto L_0x09e4
            r12 = r37
            r2 = r11
            r5 = r14
            r9 = r18
            r4 = r23
            r29 = r25
            goto L_0x0c9a
        L_0x09e4:
            r5 = r37
            r8 = r11
            r4 = r13
            r2 = r14
            r11 = r18
            r9 = r23
            r3 = r25
            r13 = r26
            goto L_0x0129
        L_0x09f3:
            com.google.android.gms.internal.firebase-auth-api.zzajj r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzg()
            throw r0
        L_0x09f8:
            com.google.android.gms.internal.firebase-auth-api.zzajj r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzi()
            throw r0
        L_0x09fd:
            r28 = r7
            r18 = r11
            r25 = r12
            r7 = r33
            r12 = r3
        L_0x0a06:
            r2 = r12
            r5 = r14
            r9 = r18
            r4 = r23
            r29 = r25
            r13 = r26
            r14 = r27
            r10 = r28
            r12 = r37
            goto L_0x0ca0
        L_0x0a18:
            r5 = r7
            r18 = r11
            r25 = r12
            r7 = r33
            r12 = r3
            sun.misc.Unsafe r3 = zzb
            int r11 = r5 + 2
            r9 = r9[r11]
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r9 & r11
            r19 = r12
            long r11 = (long) r9
            switch(r4) {
                case 51: goto L_0x0c73;
                case 52: goto L_0x0c53;
                case 53: goto L_0x0c30;
                case 54: goto L_0x0c30;
                case 55: goto L_0x0c10;
                case 56: goto L_0x0bef;
                case 57: goto L_0x0bce;
                case 58: goto L_0x0ba3;
                case 59: goto L_0x0b65;
                case 60: goto L_0x0b30;
                case 61: goto L_0x0b0e;
                case 62: goto L_0x0c10;
                case 63: goto L_0x0ace;
                case 64: goto L_0x0bce;
                case 65: goto L_0x0bef;
                case 66: goto L_0x0aa0;
                case 67: goto L_0x0a77;
                case 68: goto L_0x0a3d;
                default: goto L_0x0a30;
            }
        L_0x0a30:
            r28 = r5
            r5 = r14
            r9 = r18
            r2 = r19
            r4 = r23
            r29 = r25
            goto L_0x0c94
        L_0x0a3d:
            r4 = 3
            if (r0 != r4) goto L_0x0a6a
            r4 = r23
            java.lang.Object r0 = r6.zza(r7, (int) r4, (int) r5)
            r1 = r18 & -8
            r1 = r1 | 4
            com.google.android.gms.internal.firebase-auth-api.zzalc r9 = r6.zze((int) r5)
            r8 = r0
            r10 = r34
            r2 = r18
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r11 = r19
            r2 = r19
            r29 = r25
            r12 = r36
            r13 = r1
            r1 = r14
            r14 = r38
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza((java.lang.Object) r8, (com.google.android.gms.internal.p002firebaseauthapi.zzalc) r9, (byte[]) r10, (int) r11, (int) r12, (int) r13, (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r14)
            r6.zza(r7, (int) r4, (int) r5, (java.lang.Object) r0)
            goto L_0x0ac2
        L_0x0a6a:
            r29 = r25
            r28 = r5
            r5 = r14
            r9 = r18
            r2 = r19
            r4 = r23
            goto L_0x0c94
        L_0x0a77:
            r9 = r18
            r4 = r23
            r29 = r25
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r1
            r1 = r14
            r13 = r30
            r2 = r19
            if (r0 != 0) goto L_0x0b60
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd(r15, r2, r1)
            r18 = r9
            long r8 = r1.zzb
            long r8 = com.google.android.gms.internal.p002firebaseauthapi.zzaib.zza((long) r8)
            java.lang.Long r8 = java.lang.Long.valueOf(r8)
            r3.putObject(r7, r13, r8)
            r3.putInt(r7, r11, r4)
            goto L_0x0ac1
        L_0x0aa0:
            r4 = r23
            r29 = r25
            r30 = r1
            r1 = r14
            r13 = r30
            r2 = r19
            if (r0 != 0) goto L_0x0ac8
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r2, r1)
            int r8 = r1.zza
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzaib.zze(r8)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r3.putObject(r7, r13, r8)
            r3.putInt(r7, r11, r4)
        L_0x0ac1:
            r8 = r0
        L_0x0ac2:
            r28 = r5
            r9 = r18
            goto L_0x0b2d
        L_0x0ac8:
            r28 = r5
            r9 = r18
            goto L_0x0b62
        L_0x0ace:
            r4 = r23
            r29 = r25
            r30 = r1
            r1 = r14
            r13 = r30
            r2 = r19
            if (r0 != 0) goto L_0x0b0a
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r2, r1)
            int r8 = r1.zza
            com.google.android.gms.internal.firebase-auth-api.zzajh r9 = r6.zzd((int) r5)
            if (r9 == 0) goto L_0x0afd
            boolean r9 = r9.zza(r8)
            if (r9 == 0) goto L_0x0aee
            goto L_0x0afd
        L_0x0aee:
            com.google.android.gms.internal.firebase-auth-api.zzame r3 = zze((java.lang.Object) r33)
            long r8 = (long) r8
            java.lang.Long r8 = java.lang.Long.valueOf(r8)
            r9 = r18
            r3.zza((int) r9, (java.lang.Object) r8)
            goto L_0x0b2a
        L_0x0afd:
            r9 = r18
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r3.putObject(r7, r13, r8)
            r3.putInt(r7, r11, r4)
            goto L_0x0b2a
        L_0x0b0a:
            r9 = r18
            goto L_0x0b60
        L_0x0b0e:
            r9 = r18
            r4 = r23
            r29 = r25
            r8 = 2
            r30 = r1
            r1 = r14
            r13 = r30
            r2 = r19
            if (r0 != r8) goto L_0x0b60
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza(r15, r2, r1)
            java.lang.Object r8 = r1.zzc
            r3.putObject(r7, r13, r8)
            r3.putInt(r7, r11, r4)
        L_0x0b2a:
            r8 = r0
            r28 = r5
        L_0x0b2d:
            r5 = r1
            goto L_0x0c95
        L_0x0b30:
            r1 = r14
            r9 = r18
            r2 = r19
            r4 = r23
            r29 = r25
            r8 = 2
            if (r0 != r8) goto L_0x0b60
            java.lang.Object r8 = r6.zza(r7, (int) r4, (int) r5)
            com.google.android.gms.internal.firebase-auth-api.zzalc r3 = r6.zze((int) r5)
            r0 = r8
            r10 = r1
            r1 = r3
            r11 = r2
            r2 = r34
            r3 = r11
            r12 = r4
            r4 = r36
            r13 = r5
            r5 = r38
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza((java.lang.Object) r0, (com.google.android.gms.internal.p002firebaseauthapi.zzalc) r1, (byte[]) r2, (int) r3, (int) r4, (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r5)
            r6.zza(r7, (int) r12, (int) r13, (java.lang.Object) r8)
            r8 = r0
            r5 = r10
            r2 = r11
            r4 = r12
            r28 = r13
            goto L_0x0c95
        L_0x0b60:
            r28 = r5
        L_0x0b62:
            r5 = r1
            goto L_0x0c94
        L_0x0b65:
            r28 = r5
            r5 = r14
            r9 = r18
            r4 = r23
            r29 = r25
            r13 = r1
            r2 = r19
            r1 = 2
            if (r0 != r1) goto L_0x0c94
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r2, r5)
            int r1 = r5.zza
            if (r1 != 0) goto L_0x0b80
            r3.putObject(r7, r13, r10)
            goto L_0x0b9e
        L_0x0b80:
            r10 = 536870912(0x20000000, float:1.0842022E-19)
            r8 = r8 & r10
            if (r8 == 0) goto L_0x0b93
            int r8 = r0 + r1
            boolean r8 = com.google.android.gms.internal.p002firebaseauthapi.zzaml.zzc(r15, r0, r8)
            if (r8 == 0) goto L_0x0b8e
            goto L_0x0b93
        L_0x0b8e:
            com.google.android.gms.internal.firebase-auth-api.zzajj r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzd()
            throw r0
        L_0x0b93:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.p002firebaseauthapi.zzajc.zza
            r8.<init>(r15, r0, r1, r10)
            r3.putObject(r7, r13, r8)
            int r0 = r0 + r1
        L_0x0b9e:
            r3.putInt(r7, r11, r4)
            goto L_0x0c92
        L_0x0ba3:
            r28 = r5
            r5 = r14
            r9 = r18
            r4 = r23
            r29 = r25
            r13 = r1
            r2 = r19
            if (r0 != 0) goto L_0x0c94
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd(r15, r2, r5)
            r35 = r0
            long r0 = r5.zzb
            int r0 = (r0 > r21 ? 1 : (r0 == r21 ? 0 : -1))
            if (r0 == 0) goto L_0x0bc0
            r24 = 1
            goto L_0x0bc2
        L_0x0bc0:
            r24 = r16
        L_0x0bc2:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r24)
            r3.putObject(r7, r13, r0)
            r3.putInt(r7, r11, r4)
            goto L_0x0c50
        L_0x0bce:
            r28 = r5
            r5 = r14
            r9 = r18
            r4 = r23
            r29 = r25
            r13 = r1
            r2 = r19
            r1 = 5
            if (r0 != r1) goto L_0x0c94
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r2)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3.putObject(r7, r13, r0)
            int r0 = r2 + 4
            r3.putInt(r7, r11, r4)
            goto L_0x0c92
        L_0x0bef:
            r28 = r5
            r5 = r14
            r9 = r18
            r4 = r23
            r29 = r25
            r13 = r1
            r2 = r19
            r1 = 1
            if (r0 != r1) goto L_0x0c94
            long r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd(r15, r2)
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r3.putObject(r7, r13, r0)
            int r0 = r2 + 8
            r3.putInt(r7, r11, r4)
            goto L_0x0c92
        L_0x0c10:
            r28 = r5
            r5 = r14
            r9 = r18
            r4 = r23
            r29 = r25
            r13 = r1
            r2 = r19
            if (r0 != 0) goto L_0x0c94
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r15, r2, r5)
            int r1 = r5.zza
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3.putObject(r7, r13, r1)
            r3.putInt(r7, r11, r4)
            goto L_0x0c92
        L_0x0c30:
            r28 = r5
            r5 = r14
            r9 = r18
            r4 = r23
            r29 = r25
            r13 = r1
            r2 = r19
            if (r0 != 0) goto L_0x0c94
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd(r15, r2, r5)
            r35 = r0
            long r0 = r5.zzb
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r3.putObject(r7, r13, r0)
            r3.putInt(r7, r11, r4)
        L_0x0c50:
            r8 = r35
            goto L_0x0c95
        L_0x0c53:
            r28 = r5
            r5 = r14
            r9 = r18
            r4 = r23
            r29 = r25
            r13 = r1
            r2 = r19
            r1 = 5
            if (r0 != r1) goto L_0x0c94
            float r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzb(r15, r2)
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            r3.putObject(r7, r13, r0)
            int r0 = r2 + 4
            r3.putInt(r7, r11, r4)
            goto L_0x0c92
        L_0x0c73:
            r28 = r5
            r5 = r14
            r9 = r18
            r4 = r23
            r29 = r25
            r13 = r1
            r2 = r19
            r1 = 1
            if (r0 != r1) goto L_0x0c94
            double r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza(r15, r2)
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r3.putObject(r7, r13, r0)
            int r0 = r2 + 8
            r3.putInt(r7, r11, r4)
        L_0x0c92:
            r8 = r0
            goto L_0x0c95
        L_0x0c94:
            r8 = r2
        L_0x0c95:
            if (r8 != r2) goto L_0x0cfb
            r12 = r37
            r2 = r8
        L_0x0c9a:
            r13 = r26
            r14 = r27
            r10 = r28
        L_0x0ca0:
            if (r9 != r12) goto L_0x0ca9
            if (r12 != 0) goto L_0x0ca5
            goto L_0x0ca9
        L_0x0ca5:
            r8 = r2
            r11 = r9
            goto L_0x0d10
        L_0x0ca9:
            boolean r0 = r6.zzh
            if (r0 == 0) goto L_0x0cdd
            com.google.android.gms.internal.firebase-auth-api.zzaip r0 = r5.zzd
            com.google.android.gms.internal.firebase-auth-api.zzaip r1 = com.google.android.gms.internal.p002firebaseauthapi.zzaip.zza
            if (r0 == r1) goto L_0x0cdd
            com.google.android.gms.internal.firebase-auth-api.zzakk r0 = r6.zzg
            com.google.android.gms.internal.firebase-auth-api.zzaip r1 = r5.zzd
            com.google.android.gms.internal.firebase-auth-api.zzaja$zzf r0 = r1.zza(r0, r4)
            if (r0 != 0) goto L_0x0ccf
            com.google.android.gms.internal.firebase-auth-api.zzame r8 = zze((java.lang.Object) r33)
            r0 = r9
            r1 = r34
            r3 = r36
            r11 = r4
            r4 = r8
            r5 = r38
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.p002firebaseauthapi.zzame) r4, (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r5)
            goto L_0x0ced
        L_0x0ccf:
            r0 = r7
            com.google.android.gms.internal.firebase-auth-api.zzaja$zzd r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzaja.zzd) r0
            r0.zza()
            com.google.android.gms.internal.firebase-auth-api.zzais<com.google.android.gms.internal.firebase-auth-api.zzaja$zzc> r0 = r0.zzc
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        L_0x0cdd:
            r11 = r4
            com.google.android.gms.internal.firebase-auth-api.zzame r4 = zze((java.lang.Object) r33)
            r0 = r9
            r1 = r34
            r3 = r36
            r5 = r38
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.p002firebaseauthapi.zzame) r4, (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r5)
        L_0x0ced:
            r4 = r36
            r2 = r38
            r5 = r12
        L_0x0cf2:
            r3 = r29
            r30 = r11
            r11 = r9
            r9 = r30
            goto L_0x001d
        L_0x0cfb:
            r11 = r4
            r4 = r36
            r5 = r37
            r2 = r38
            r13 = r26
            r14 = r27
            r10 = r28
            goto L_0x0cf2
        L_0x0d09:
            r29 = r3
            r12 = r5
            r26 = r13
            r27 = r14
        L_0x0d10:
            r0 = 1048575(0xfffff, float:1.469367E-39)
            if (r14 == r0) goto L_0x0d1b
            long r0 = (long) r14
            r2 = r29
            r2.putInt(r7, r0, r13)
        L_0x0d1b:
            r0 = 0
            int r1 = r6.zzm
            r3 = r0
            r9 = r1
        L_0x0d20:
            int r0 = r6.zzn
            if (r9 >= r0) goto L_0x0d3a
            int[] r0 = r6.zzl
            r2 = r0[r9]
            com.google.android.gms.internal.firebase-auth-api.zzamb<?, ?> r4 = r6.zzq
            r0 = r32
            r1 = r33
            r5 = r33
            java.lang.Object r0 = r0.zza((java.lang.Object) r1, (int) r2, r3, r4, (java.lang.Object) r5)
            r3 = r0
            com.google.android.gms.internal.firebase-auth-api.zzame r3 = (com.google.android.gms.internal.p002firebaseauthapi.zzame) r3
            int r9 = r9 + 1
            goto L_0x0d20
        L_0x0d3a:
            if (r3 == 0) goto L_0x0d41
            com.google.android.gms.internal.firebase-auth-api.zzamb<?, ?> r0 = r6.zzq
            r0.zzb((java.lang.Object) r7, r3)
        L_0x0d41:
            if (r12 != 0) goto L_0x0d4d
            r0 = r36
            if (r8 != r0) goto L_0x0d48
            goto L_0x0d53
        L_0x0d48:
            com.google.android.gms.internal.firebase-auth-api.zzajj r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzg()
            throw r0
        L_0x0d4d:
            r0 = r36
            if (r8 > r0) goto L_0x0d54
            if (r11 != r12) goto L_0x0d54
        L_0x0d53:
            return r8
        L_0x0d54:
            com.google.android.gms.internal.firebase-auth-api.zzajj r0 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzg()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzako.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.firebase-auth-api.zzahl):int");
    }

    private final int zza(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zza(i, 0);
    }

    private final int zzb(int i) {
        return this.zzc[i + 2];
    }

    private final int zza(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private final int zzc(int i) {
        return this.zzc[i + 1];
    }

    private static <T> long zzd(T t, long j) {
        return ((Long) zzamh.zze(t, j)).longValue();
    }

    private final zzajh zzd(int i) {
        return (zzajh) this.zzd[((i / 3) << 1) + 1];
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0276  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.p002firebaseauthapi.zzako<T> zza(java.lang.Class<T> r32, com.google.android.gms.internal.p002firebaseauthapi.zzaki r33, com.google.android.gms.internal.p002firebaseauthapi.zzaks r34, com.google.android.gms.internal.p002firebaseauthapi.zzajt r35, com.google.android.gms.internal.p002firebaseauthapi.zzamb<?, ?> r36, com.google.android.gms.internal.p002firebaseauthapi.zzair<?> r37, com.google.android.gms.internal.p002firebaseauthapi.zzakh r38) {
        /*
            r0 = r33
            boolean r1 = r0 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzala
            if (r1 == 0) goto L_0x03f5
            com.google.android.gms.internal.firebase-auth-api.zzala r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzala) r0
            java.lang.String r1 = r0.zzd()
            int r2 = r1.length()
            r3 = 0
            char r4 = r1.charAt(r3)
            r5 = 55296(0xd800, float:7.7486E-41)
            r6 = 1
            if (r4 < r5) goto L_0x0026
            r4 = r6
        L_0x001c:
            int r7 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0027
            r4 = r7
            goto L_0x001c
        L_0x0026:
            r7 = r6
        L_0x0027:
            int r4 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0046
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0033:
            int r10 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0043
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r9
            r7 = r7 | r4
            int r9 = r9 + 13
            r4 = r10
            goto L_0x0033
        L_0x0043:
            int r4 = r4 << r9
            r7 = r7 | r4
            r4 = r10
        L_0x0046:
            if (r7 != 0) goto L_0x0058
            int[] r7 = zza
            r11 = r3
            r12 = r11
            r13 = r12
            r14 = r13
            r16 = r14
            r18 = r16
            r17 = r7
            r7 = r18
            goto L_0x0168
        L_0x0058:
            int r7 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0077
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0064:
            int r10 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0074
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r9
            r4 = r4 | r7
            int r9 = r9 + 13
            r7 = r10
            goto L_0x0064
        L_0x0074:
            int r7 = r7 << r9
            r4 = r4 | r7
            r7 = r10
        L_0x0077:
            int r9 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0096
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0083:
            int r11 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r5) goto L_0x0093
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r10
            r7 = r7 | r9
            int r10 = r10 + 13
            r9 = r11
            goto L_0x0083
        L_0x0093:
            int r9 = r9 << r10
            r7 = r7 | r9
            r9 = r11
        L_0x0096:
            int r10 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r5) goto L_0x00b5
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a2:
            int r12 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r5) goto L_0x00b2
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r11
            r9 = r9 | r10
            int r11 = r11 + 13
            r10 = r12
            goto L_0x00a2
        L_0x00b2:
            int r10 = r10 << r11
            r9 = r9 | r10
            r10 = r12
        L_0x00b5:
            int r11 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r5) goto L_0x00d4
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00c1:
            int r13 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r5) goto L_0x00d1
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r10 = r10 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00c1
        L_0x00d1:
            int r11 = r11 << r12
            r10 = r10 | r11
            r11 = r13
        L_0x00d4:
            int r12 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r5) goto L_0x00f3
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00e0:
            int r14 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x00f0
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00e0
        L_0x00f0:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f3:
            int r13 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x0112
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00ff:
            int r15 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x010f
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00ff
        L_0x010f:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0112:
            int r14 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x0133
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011e:
            int r16 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r5) goto L_0x012f
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011e
        L_0x012f:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0133:
            int r15 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r5) goto L_0x0156
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013f:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r5) goto L_0x0151
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013f
        L_0x0151:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0156:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 << 1
            int r16 = r16 + r7
            r7 = r4
            r17 = r13
            r18 = r14
            r4 = r15
            r13 = r9
            r14 = r10
        L_0x0168:
            sun.misc.Unsafe r9 = zzb
            java.lang.Object[] r10 = r0.zze()
            com.google.android.gms.internal.firebase-auth-api.zzakk r15 = r0.zza()
            java.lang.Class r15 = r15.getClass()
            int r3 = r11 * 3
            int[] r3 = new int[r3]
            int r11 = r11 << r6
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r19 = r18 + r12
            r21 = r18
            r22 = r19
            r12 = 0
            r20 = 0
        L_0x0186:
            if (r4 >= r2) goto L_0x03cf
            int r23 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x01ae
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = r23
            r23 = 13
        L_0x0196:
            int r24 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r5) goto L_0x01a8
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r23
            r4 = r4 | r8
            int r23 = r23 + 13
            r8 = r24
            goto L_0x0196
        L_0x01a8:
            int r8 = r8 << r23
            r4 = r4 | r8
            r8 = r24
            goto L_0x01b0
        L_0x01ae:
            r8 = r23
        L_0x01b0:
            int r23 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r5) goto L_0x01d6
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r6 = r23
            r23 = 13
        L_0x01be:
            int r25 = r6 + 1
            char r6 = r1.charAt(r6)
            if (r6 < r5) goto L_0x01d0
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r23
            r8 = r8 | r6
            int r23 = r23 + 13
            r6 = r25
            goto L_0x01be
        L_0x01d0:
            int r6 = r6 << r23
            r8 = r8 | r6
            r6 = r25
            goto L_0x01d8
        L_0x01d6:
            r6 = r23
        L_0x01d8:
            r5 = r8 & 255(0xff, float:3.57E-43)
            r25 = r2
            r2 = r8 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x01e6
            int r2 = r20 + 1
            r17[r20] = r12
            r20 = r2
        L_0x01e6:
            r2 = 51
            r28 = r14
            if (r5 < r2) goto L_0x028a
            int r2 = r6 + 1
            char r6 = r1.charAt(r6)
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r6 < r14) goto L_0x0215
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r29 = 13
        L_0x01fb:
            int r30 = r2 + 1
            char r2 = r1.charAt(r2)
            if (r2 < r14) goto L_0x0210
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r29
            r6 = r6 | r2
            int r29 = r29 + 13
            r2 = r30
            r14 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01fb
        L_0x0210:
            int r2 = r2 << r29
            r6 = r6 | r2
            r2 = r30
        L_0x0215:
            int r14 = r5 + -51
            r29 = r2
            r2 = 9
            if (r14 == r2) goto L_0x0244
            r2 = 17
            if (r14 != r2) goto L_0x0222
            goto L_0x0244
        L_0x0222:
            r2 = 12
            if (r14 != r2) goto L_0x0242
            com.google.android.gms.internal.firebase-auth-api.zzakz r2 = r0.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzakz r14 = com.google.android.gms.internal.p002firebaseauthapi.zzakz.PROTO2
            boolean r2 = r2.equals(r14)
            if (r2 != 0) goto L_0x0236
            r2 = r8 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x0242
        L_0x0236:
            int r2 = r12 / 3
            r14 = 1
            int r2 = r2 << r14
            int r2 = r2 + r14
            int r24 = r16 + 1
            r16 = r10[r16]
            r11[r2] = r16
            goto L_0x024f
        L_0x0242:
            r14 = 1
            goto L_0x0251
        L_0x0244:
            r14 = 1
            int r2 = r12 / 3
            int r2 = r2 << r14
            int r2 = r2 + r14
            int r24 = r16 + 1
            r16 = r10[r16]
            r11[r2] = r16
        L_0x024f:
            r16 = r24
        L_0x0251:
            int r2 = r6 << 1
            r6 = r10[r2]
            boolean r14 = r6 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x025c
            java.lang.reflect.Field r6 = (java.lang.reflect.Field) r6
            goto L_0x0264
        L_0x025c:
            java.lang.String r6 = (java.lang.String) r6
            java.lang.reflect.Field r6 = zza((java.lang.Class<?>) r15, (java.lang.String) r6)
            r10[r2] = r6
        L_0x0264:
            r30 = r13
            long r13 = r9.objectFieldOffset(r6)
            int r6 = (int) r13
            int r2 = r2 + 1
            r13 = r10[r2]
            boolean r14 = r13 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0276
            java.lang.reflect.Field r13 = (java.lang.reflect.Field) r13
            goto L_0x027e
        L_0x0276:
            java.lang.String r13 = (java.lang.String) r13
            java.lang.reflect.Field r13 = zza((java.lang.Class<?>) r15, (java.lang.String) r13)
            r10[r2] = r13
        L_0x027e:
            long r13 = r9.objectFieldOffset(r13)
            int r2 = (int) r13
            r26 = r0
            r27 = r29
            r0 = 0
            goto L_0x0392
        L_0x028a:
            r30 = r13
            int r2 = r16 + 1
            r13 = r10[r16]
            java.lang.String r13 = (java.lang.String) r13
            java.lang.reflect.Field r13 = zza((java.lang.Class<?>) r15, (java.lang.String) r13)
            r14 = 9
            if (r5 == r14) goto L_0x030c
            r14 = 17
            if (r5 != r14) goto L_0x02a0
            goto L_0x030c
        L_0x02a0:
            r14 = 27
            if (r5 == r14) goto L_0x02fc
            r14 = 49
            if (r5 != r14) goto L_0x02a9
            goto L_0x02fc
        L_0x02a9:
            r14 = 12
            if (r5 == r14) goto L_0x02e2
            r14 = 30
            if (r5 == r14) goto L_0x02e2
            r14 = 44
            if (r5 != r14) goto L_0x02b6
            goto L_0x02e2
        L_0x02b6:
            r14 = 50
            if (r5 != r14) goto L_0x02df
            int r14 = r21 + 1
            r17[r21] = r12
            int r21 = r12 / 3
            r24 = 1
            int r21 = r21 << 1
            int r26 = r2 + 1
            r2 = r10[r2]
            r11[r21] = r2
            r2 = r8 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x02db
            int r21 = r21 + 1
            int r2 = r26 + 1
            r26 = r10[r26]
            r11[r21] = r26
            r26 = r0
            r21 = r14
            goto L_0x0319
        L_0x02db:
            r21 = r14
            r2 = r26
        L_0x02df:
            r26 = r0
            goto L_0x0319
        L_0x02e2:
            com.google.android.gms.internal.firebase-auth-api.zzakz r14 = r0.zzb()
            r26 = r0
            com.google.android.gms.internal.firebase-auth-api.zzakz r0 = com.google.android.gms.internal.p002firebaseauthapi.zzakz.PROTO2
            if (r14 == r0) goto L_0x02f0
            r0 = r8 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0319
        L_0x02f0:
            int r0 = r12 / 3
            r14 = 1
            int r0 = r0 << r14
            int r0 = r0 + r14
            int r24 = r2 + 1
            r2 = r10[r2]
            r11[r0] = r2
            goto L_0x0309
        L_0x02fc:
            r26 = r0
            r14 = 1
            int r0 = r12 / 3
            int r0 = r0 << r14
            int r0 = r0 + r14
            int r24 = r2 + 1
            r2 = r10[r2]
            r11[r0] = r2
        L_0x0309:
            r2 = r24
            goto L_0x0319
        L_0x030c:
            r26 = r0
            r14 = 1
            int r0 = r12 / 3
            int r0 = r0 << r14
            int r0 = r0 + r14
            java.lang.Class r14 = r13.getType()
            r11[r0] = r14
        L_0x0319:
            long r13 = r9.objectFieldOffset(r13)
            int r0 = (int) r13
            r13 = r8 & 4096(0x1000, float:5.74E-42)
            if (r13 == 0) goto L_0x0324
            r14 = 1
            goto L_0x0325
        L_0x0324:
            r14 = 0
        L_0x0325:
            if (r14 == 0) goto L_0x0372
            r13 = 17
            if (r5 > r13) goto L_0x0372
            int r13 = r6 + 1
            char r6 = r1.charAt(r6)
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r6 < r14) goto L_0x0350
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r23 = 13
        L_0x033a:
            int r27 = r13 + 1
            char r13 = r1.charAt(r13)
            if (r13 < r14) goto L_0x034c
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r23
            r6 = r6 | r13
            int r23 = r23 + 13
            r13 = r27
            goto L_0x033a
        L_0x034c:
            int r13 = r13 << r23
            r6 = r6 | r13
            goto L_0x0352
        L_0x0350:
            r27 = r13
        L_0x0352:
            r13 = 1
            int r23 = r7 << 1
            int r24 = r6 / 32
            int r23 = r23 + r24
            r13 = r10[r23]
            boolean r14 = r13 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0362
            java.lang.reflect.Field r13 = (java.lang.reflect.Field) r13
            goto L_0x036a
        L_0x0362:
            java.lang.String r13 = (java.lang.String) r13
            java.lang.reflect.Field r13 = zza((java.lang.Class<?>) r15, (java.lang.String) r13)
            r10[r23] = r13
        L_0x036a:
            long r13 = r9.objectFieldOffset(r13)
            int r13 = (int) r13
            int r6 = r6 % 32
            goto L_0x0378
        L_0x0372:
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r27 = r6
            r6 = 0
        L_0x0378:
            r14 = 18
            if (r5 < r14) goto L_0x038a
            r14 = 49
            if (r5 > r14) goto L_0x038a
            int r14 = r22 + 1
            r17[r22] = r0
            r16 = r2
            r2 = r13
            r22 = r14
            goto L_0x038d
        L_0x038a:
            r16 = r2
            r2 = r13
        L_0x038d:
            r31 = r6
            r6 = r0
            r0 = r31
        L_0x0392:
            int r13 = r12 + 1
            r3[r12] = r4
            int r4 = r13 + 1
            r12 = r8 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x039f
            r12 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03a0
        L_0x039f:
            r12 = 0
        L_0x03a0:
            r14 = r8 & 256(0x100, float:3.59E-43)
            if (r14 == 0) goto L_0x03a7
            r14 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03a8
        L_0x03a7:
            r14 = 0
        L_0x03a8:
            r12 = r12 | r14
            r8 = r8 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x03b0
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x03b1
        L_0x03b0:
            r8 = 0
        L_0x03b1:
            r8 = r8 | r12
            int r5 = r5 << 20
            r5 = r5 | r8
            r5 = r5 | r6
            r3[r13] = r5
            int r12 = r4 + 1
            int r0 = r0 << 20
            r0 = r0 | r2
            r3[r4] = r0
            r2 = r25
            r0 = r26
            r4 = r27
            r14 = r28
            r13 = r30
            r5 = 55296(0xd800, float:7.7486E-41)
            r6 = 1
            goto L_0x0186
        L_0x03cf:
            r26 = r0
            r30 = r13
            r28 = r14
            com.google.android.gms.internal.firebase-auth-api.zzako r0 = new com.google.android.gms.internal.firebase-auth-api.zzako
            com.google.android.gms.internal.firebase-auth-api.zzakk r14 = r26.zza()
            com.google.android.gms.internal.firebase-auth-api.zzakz r15 = r26.zzb()
            r16 = 0
            r9 = r0
            r10 = r3
            r12 = r30
            r13 = r28
            r20 = r34
            r21 = r35
            r22 = r36
            r23 = r37
            r24 = r38
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return r0
        L_0x03f5:
            com.google.android.gms.internal.firebase-auth-api.zzalu r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzalu) r0
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzako.zza(java.lang.Class, com.google.android.gms.internal.firebase-auth-api.zzaki, com.google.android.gms.internal.firebase-auth-api.zzaks, com.google.android.gms.internal.firebase-auth-api.zzajt, com.google.android.gms.internal.firebase-auth-api.zzamb, com.google.android.gms.internal.firebase-auth-api.zzair, com.google.android.gms.internal.firebase-auth-api.zzakh):com.google.android.gms.internal.firebase-auth-api.zzako");
    }

    private final zzalc zze(int i) {
        int i2 = (i / 3) << 1;
        zzalc zzalc = (zzalc) this.zzd[i2];
        if (zzalc != null) {
            return zzalc;
        }
        zzalc zza2 = zzaky.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zza2;
        return zza2;
    }

    private static zzame zze(Object obj) {
        zzaja zzaja = (zzaja) obj;
        zzame zzame = zzaja.zzb;
        if (zzame != zzame.zzc()) {
            return zzame;
        }
        zzame zzd2 = zzame.zzd();
        zzaja.zzb = zzd2;
        return zzd2;
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzamb<UT, UB> zzamb, Object obj2) {
        zzajh zzd2;
        int i2 = this.zzc[i];
        Object zze2 = zzamh.zze(obj, (long) (zzc(i) & 1048575));
        if (zze2 == null || (zzd2 = zzd(i)) == null) {
            return ub;
        }
        return zza(i, i2, this.zzs.zze(zze2), zzd2, ub, zzamb, obj2);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzajh zzajh, UB ub, zzamb<UT, UB> zzamb, Object obj) {
        zzakf<?, ?> zza2 = this.zzs.zza(zzf(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!zzajh.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzamb.zzc(obj);
                }
                zzahv zzc2 = zzahm.zzc(zzakc.zza(zza2, next.getKey(), next.getValue()));
                try {
                    zzakc.zza(zzc2.zzb(), zza2, next.getKey(), next.getValue());
                    zzamb.zza(ub, i2, zzc2.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private final Object zzf(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private final Object zza(T t, int i) {
        zzalc zze2 = zze(i);
        long zzc2 = (long) (zzc(i) & 1048575);
        if (!zzc(t, i)) {
            return zze2.zza();
        }
        Object object = zzb.getObject(t, zzc2);
        if (zzg(object)) {
            return object;
        }
        Object zza2 = zze2.zza();
        if (object != null) {
            zze2.zza(zza2, object);
        }
        return zza2;
    }

    private final Object zza(T t, int i, int i2) {
        zzalc zze2 = zze(i2);
        if (!zzc(t, i, i2)) {
            return zze2.zza();
        }
        Object object = zzb.getObject(t, (long) (zzc(i2) & 1048575));
        if (zzg(object)) {
            return object;
        }
        Object zza2 = zze2.zza();
        if (object != null) {
            zze2.zza(zza2, object);
        }
        return zza2;
    }

    public final T zza() {
        return this.zzo.zza(this.zzg);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private zzako(int[] iArr, Object[] objArr, int i, int i2, zzakk zzakk, zzakz zzakz, boolean z, int[] iArr2, int i3, int i4, zzaks zzaks, zzajt zzajt, zzamb<?, ?> zzamb, zzair<?> zzair, zzakh zzakh) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzakk instanceof zzaja;
        this.zzj = zzakz;
        this.zzh = zzair != null && zzair.zza(zzakk);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzaks;
        this.zzp = zzajt;
        this.zzq = zzamb;
        this.zzr = zzair;
        this.zzg = zzakk;
        this.zzs = zzakh;
    }

    private static void zzf(Object obj) {
        if (!zzg(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: " + String.valueOf(obj));
        }
    }

    public final void zzc(T t) {
        if (zzg((Object) t)) {
            if (t instanceof zzaja) {
                zzaja zzaja = (zzaja) t;
                zzaja.zzb(Integer.MAX_VALUE);
                zzaja.zza = 0;
                zzaja.zzt();
            }
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int zzc2 = zzc(i);
                long j = (long) (1048575 & zzc2);
                int i2 = (zzc2 & 267386880) >>> 20;
                if (i2 != 9) {
                    if (i2 == 60 || i2 == 68) {
                        if (zzc(t, this.zzc[i], i)) {
                            zze(i).zzc(zzb.getObject(t, j));
                        }
                    } else {
                        switch (i2) {
                            case 17:
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.zzp.zzb(t, j);
                                continue;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(t, j);
                                if (object != null) {
                                    unsafe.putObject(t, j, this.zzs.zzc(object));
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                }
                if (zzc(t, i)) {
                    zze(i).zzc(zzb.getObject(t, j));
                }
            }
            this.zzq.zzf(t);
            if (this.zzh) {
                this.zzr.zzc(t);
            }
        }
    }

    public final void zza(T t, T t2) {
        zzf((Object) t);
        t2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzc2 = zzc(i);
            long j = (long) (1048575 & zzc2);
            int i2 = this.zzc[i];
            switch ((zzc2 & 267386880) >>> 20) {
                case 0:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzamh.zza((Object) t, j, zzamh.zza((Object) t2, j));
                        zzb(t, i);
                        break;
                    }
                case 1:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzamh.zza((Object) t, j, zzamh.zzb(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 2:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzamh.zza((Object) t, j, zzamh.zzd(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 3:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzamh.zza((Object) t, j, zzamh.zzd(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 4:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzamh.zza((Object) t, j, zzamh.zzc(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 5:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzamh.zza((Object) t, j, zzamh.zzd(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 6:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzamh.zza((Object) t, j, zzamh.zzc(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 7:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzamh.zzc((Object) t, j, zzamh.zzh(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 8:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzamh.zza((Object) t, j, zzamh.zze(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzamh.zza((Object) t, j, zzamh.zze(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 11:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzamh.zza((Object) t, j, zzamh.zzc(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 12:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzamh.zza((Object) t, j, zzamh.zzc(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 13:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzamh.zza((Object) t, j, zzamh.zzc(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 14:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzamh.zza((Object) t, j, zzamh.zzd(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 15:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzamh.zza((Object) t, j, zzamh.zzc(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 16:
                    if (!zzc(t2, i)) {
                        break;
                    } else {
                        zzamh.zza((Object) t, j, zzamh.zzd(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 17:
                    zza(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzp.zza(t, t2, j);
                    break;
                case 50:
                    zzale.zza(this.zzs, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zzc(t2, i2, i)) {
                        break;
                    } else {
                        zzamh.zza((Object) t, j, zzamh.zze(t2, j));
                        zzb(t, i2, i);
                        break;
                    }
                case 60:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzc(t2, i2, i)) {
                        break;
                    } else {
                        zzamh.zza((Object) t, j, zzamh.zze(t2, j));
                        zzb(t, i2, i);
                        break;
                    }
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzale.zza(this.zzq, t, t2);
        if (this.zzh) {
            zzale.zza(this.zzr, t, t2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:147:0x05e6, code lost:
        r15 = r9;
        r5 = r11;
        r4 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0620, code lost:
        r4 = r10.zzc(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x062b, code lost:
        r0 = r7.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x062f, code lost:
        if (r0 < r7.zzn) goto L_0x0631;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0631, code lost:
        r4 = zza((java.lang.Object) r18, r7.zzl[r0], r4, r10, (java.lang.Object) r18);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0643, code lost:
        if (r4 != null) goto L_0x0645;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0645, code lost:
        r10.zzb((java.lang.Object) r9, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x017b, code lost:
        r13 = r4;
        r11 = r5;
        r14 = r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:165:0x061b */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0620 A[Catch:{ all -> 0x0295 }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0657 A[LOOP:5: B:183:0x0653->B:185:0x0657, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x066b  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x062b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r18, com.google.android.gms.internal.p002firebaseauthapi.zzald r19, com.google.android.gms.internal.p002firebaseauthapi.zzaip r20) throws java.io.IOException {
        /*
            r17 = this;
            r7 = r17
            r15 = r18
            r0 = r19
            r6 = r20
            r20.getClass()
            zzf((java.lang.Object) r18)
            com.google.android.gms.internal.firebase-auth-api.zzamb<?, ?> r14 = r7.zzq
            com.google.android.gms.internal.firebase-auth-api.zzair<?> r5 = r7.zzr
            r16 = 0
            r4 = r16
            r8 = r4
        L_0x0017:
            int r2 = r19.zzc()     // Catch:{ all -> 0x064c }
            int r1 = r7.zza((int) r2)     // Catch:{ all -> 0x064c }
            if (r1 >= 0) goto L_0x00ad
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r1) goto L_0x0044
            int r0 = r7.zzm
        L_0x0028:
            int r1 = r7.zzn
            if (r0 >= r1) goto L_0x003e
            int[] r1 = r7.zzl
            r3 = r1[r0]
            r1 = r17
            r2 = r18
            r5 = r14
            r6 = r18
            java.lang.Object r4 = r1.zza((java.lang.Object) r2, (int) r3, r4, r5, (java.lang.Object) r6)
            int r0 = r0 + 1
            goto L_0x0028
        L_0x003e:
            if (r4 == 0) goto L_0x0043
            r14.zzb((java.lang.Object) r15, r4)
        L_0x0043:
            return
        L_0x0044:
            boolean r1 = r7.zzh     // Catch:{ all -> 0x00aa }
            if (r1 != 0) goto L_0x004b
            r11 = r16
            goto L_0x0052
        L_0x004b:
            com.google.android.gms.internal.firebase-auth-api.zzakk r1 = r7.zzg     // Catch:{ all -> 0x00aa }
            java.lang.Object r1 = r5.zza(r6, r1, r2)     // Catch:{ all -> 0x00aa }
            r11 = r1
        L_0x0052:
            if (r11 == 0) goto L_0x006f
            if (r8 != 0) goto L_0x005a
            com.google.android.gms.internal.firebase-auth-api.zzais r8 = r5.zzb(r15)     // Catch:{ all -> 0x00aa }
        L_0x005a:
            r1 = r8
            r8 = r5
            r9 = r18
            r10 = r19
            r12 = r20
            r13 = r1
            r3 = r14
            r14 = r4
            r2 = r15
            r15 = r3
            java.lang.Object r4 = r8.zza(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x00a5 }
            r8 = r1
        L_0x006c:
            r15 = r2
            r14 = r3
            goto L_0x0017
        L_0x006f:
            r3 = r14
            r2 = r15
            r3.zza((com.google.android.gms.internal.p002firebaseauthapi.zzald) r0)     // Catch:{ all -> 0x00a5 }
            if (r4 != 0) goto L_0x007a
            java.lang.Object r4 = r3.zzc(r2)     // Catch:{ all -> 0x00a5 }
        L_0x007a:
            boolean r1 = r3.zza(r4, (com.google.android.gms.internal.p002firebaseauthapi.zzald) r0)     // Catch:{ all -> 0x00a5 }
            if (r1 != 0) goto L_0x006c
            int r0 = r7.zzm
        L_0x0082:
            int r1 = r7.zzn
            if (r0 >= r1) goto L_0x009d
            int[] r1 = r7.zzl
            r5 = r1[r0]
            r1 = r17
            r9 = r2
            r2 = r18
            r10 = r3
            r3 = r5
            r5 = r10
            r6 = r18
            java.lang.Object r4 = r1.zza((java.lang.Object) r2, (int) r3, r4, r5, (java.lang.Object) r6)
            int r0 = r0 + 1
            r2 = r9
            r3 = r10
            goto L_0x0082
        L_0x009d:
            r9 = r2
            r10 = r3
            if (r4 == 0) goto L_0x00a4
            r10.zzb((java.lang.Object) r9, r4)
        L_0x00a4:
            return
        L_0x00a5:
            r0 = move-exception
            r9 = r2
            r10 = r3
            goto L_0x0650
        L_0x00aa:
            r0 = move-exception
            goto L_0x064e
        L_0x00ad:
            r10 = r14
            r9 = r15
            int r3 = r7.zzc((int) r1)     // Catch:{ all -> 0x0649 }
            r11 = 267386880(0xff00000, float:2.3665827E-29)
            r11 = r11 & r3
            int r11 = r11 >>> 20
            r12 = 1048575(0xfffff, float:1.469367E-39)
            switch(r11) {
                case 0: goto L_0x05d6;
                case 1: goto L_0x05c5;
                case 2: goto L_0x05b4;
                case 3: goto L_0x05a3;
                case 4: goto L_0x0592;
                case 5: goto L_0x0581;
                case 6: goto L_0x056f;
                case 7: goto L_0x055d;
                case 8: goto L_0x0552;
                case 9: goto L_0x053d;
                case 10: goto L_0x052b;
                case 11: goto L_0x0519;
                case 12: goto L_0x04f4;
                case 13: goto L_0x04e2;
                case 14: goto L_0x04d0;
                case 15: goto L_0x04be;
                case 16: goto L_0x04ac;
                case 17: goto L_0x0497;
                case 18: goto L_0x0486;
                case 19: goto L_0x0475;
                case 20: goto L_0x0464;
                case 21: goto L_0x0453;
                case 22: goto L_0x0442;
                case 23: goto L_0x0431;
                case 24: goto L_0x0420;
                case 25: goto L_0x040f;
                case 26: goto L_0x03ea;
                case 27: goto L_0x03d5;
                case 28: goto L_0x03c4;
                case 29: goto L_0x03b3;
                case 30: goto L_0x0397;
                case 31: goto L_0x0386;
                case 32: goto L_0x0375;
                case 33: goto L_0x0364;
                case 34: goto L_0x0353;
                case 35: goto L_0x0342;
                case 36: goto L_0x0331;
                case 37: goto L_0x0320;
                case 38: goto L_0x030f;
                case 39: goto L_0x02fe;
                case 40: goto L_0x02ed;
                case 41: goto L_0x02dc;
                case 42: goto L_0x02cb;
                case 43: goto L_0x02ba;
                case 44: goto L_0x0298;
                case 45: goto L_0x0287;
                case 46: goto L_0x0279;
                case 47: goto L_0x026b;
                case 48: goto L_0x025d;
                case 49: goto L_0x024b;
                case 50: goto L_0x0209;
                case 51: goto L_0x01f7;
                case 52: goto L_0x01e6;
                case 53: goto L_0x01d5;
                case 54: goto L_0x01c4;
                case 55: goto L_0x01b3;
                case 56: goto L_0x01a2;
                case 57: goto L_0x0191;
                case 58: goto L_0x0180;
                case 59: goto L_0x0175;
                case 60: goto L_0x0164;
                case 61: goto L_0x0157;
                case 62: goto L_0x0146;
                case 63: goto L_0x0121;
                case 64: goto L_0x0110;
                case 65: goto L_0x00ff;
                case 66: goto L_0x00ed;
                case 67: goto L_0x00db;
                case 68: goto L_0x00c9;
                default: goto L_0x00be;
            }
        L_0x00be:
            r13 = r4
            r11 = r5
            r14 = r6
            if (r13 != 0) goto L_0x05f3
            java.lang.Object r4 = r10.zzc(r9)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05f4
        L_0x00c9:
            java.lang.Object r3 = r7.zza(r9, (int) r2, (int) r1)     // Catch:{  }
            com.google.android.gms.internal.firebase-auth-api.zzakk r3 = (com.google.android.gms.internal.p002firebaseauthapi.zzakk) r3     // Catch:{  }
            com.google.android.gms.internal.firebase-auth-api.zzalc r11 = r7.zze((int) r1)     // Catch:{  }
            r0.zza(r3, r11, (com.google.android.gms.internal.p002firebaseauthapi.zzaip) r6)     // Catch:{  }
            r7.zza(r9, (int) r2, (int) r1, (java.lang.Object) r3)     // Catch:{  }
            goto L_0x017b
        L_0x00db:
            r3 = r3 & r12
            long r11 = (long) r3     // Catch:{  }
            long r13 = r19.zzn()     // Catch:{  }
            java.lang.Long r3 = java.lang.Long.valueOf(r13)     // Catch:{  }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r11, (java.lang.Object) r3)     // Catch:{  }
            r7.zzb(r9, (int) r2, (int) r1)     // Catch:{  }
            goto L_0x017b
        L_0x00ed:
            r3 = r3 & r12
            long r11 = (long) r3     // Catch:{  }
            int r3 = r19.zzi()     // Catch:{  }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{  }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r11, (java.lang.Object) r3)     // Catch:{  }
            r7.zzb(r9, (int) r2, (int) r1)     // Catch:{  }
            goto L_0x017b
        L_0x00ff:
            r3 = r3 & r12
            long r11 = (long) r3     // Catch:{  }
            long r13 = r19.zzm()     // Catch:{  }
            java.lang.Long r3 = java.lang.Long.valueOf(r13)     // Catch:{  }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r11, (java.lang.Object) r3)     // Catch:{  }
            r7.zzb(r9, (int) r2, (int) r1)     // Catch:{  }
            goto L_0x017b
        L_0x0110:
            r3 = r3 & r12
            long r11 = (long) r3     // Catch:{  }
            int r3 = r19.zzh()     // Catch:{  }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{  }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r11, (java.lang.Object) r3)     // Catch:{  }
            r7.zzb(r9, (int) r2, (int) r1)     // Catch:{  }
            goto L_0x017b
        L_0x0121:
            int r11 = r19.zze()     // Catch:{  }
            com.google.android.gms.internal.firebase-auth-api.zzajh r13 = r7.zzd((int) r1)     // Catch:{  }
            if (r13 == 0) goto L_0x0139
            boolean r13 = r13.zza(r11)     // Catch:{  }
            if (r13 == 0) goto L_0x0132
            goto L_0x0139
        L_0x0132:
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zza(r9, r2, r11, r4, r10)     // Catch:{  }
            r15 = r9
            goto L_0x05ea
        L_0x0139:
            r3 = r3 & r12
            long r12 = (long) r3     // Catch:{  }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r11)     // Catch:{  }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r12, (java.lang.Object) r3)     // Catch:{  }
            r7.zzb(r9, (int) r2, (int) r1)     // Catch:{  }
            goto L_0x017b
        L_0x0146:
            r3 = r3 & r12
            long r11 = (long) r3     // Catch:{  }
            int r3 = r19.zzj()     // Catch:{  }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{  }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r11, (java.lang.Object) r3)     // Catch:{  }
            r7.zzb(r9, (int) r2, (int) r1)     // Catch:{  }
            goto L_0x017b
        L_0x0157:
            r3 = r3 & r12
            long r11 = (long) r3     // Catch:{  }
            com.google.android.gms.internal.firebase-auth-api.zzahm r3 = r19.zzp()     // Catch:{  }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r11, (java.lang.Object) r3)     // Catch:{  }
            r7.zzb(r9, (int) r2, (int) r1)     // Catch:{  }
            goto L_0x017b
        L_0x0164:
            java.lang.Object r3 = r7.zza(r9, (int) r2, (int) r1)     // Catch:{  }
            com.google.android.gms.internal.firebase-auth-api.zzakk r3 = (com.google.android.gms.internal.p002firebaseauthapi.zzakk) r3     // Catch:{  }
            com.google.android.gms.internal.firebase-auth-api.zzalc r11 = r7.zze((int) r1)     // Catch:{  }
            r0.zzb(r3, r11, (com.google.android.gms.internal.p002firebaseauthapi.zzaip) r6)     // Catch:{  }
            r7.zza(r9, (int) r2, (int) r1, (java.lang.Object) r3)     // Catch:{  }
            goto L_0x017b
        L_0x0175:
            r7.zza((java.lang.Object) r9, (int) r3, (com.google.android.gms.internal.p002firebaseauthapi.zzald) r0)     // Catch:{  }
            r7.zzb(r9, (int) r2, (int) r1)     // Catch:{  }
        L_0x017b:
            r13 = r4
            r11 = r5
            r14 = r6
            goto L_0x05e6
        L_0x0180:
            r3 = r3 & r12
            long r11 = (long) r3     // Catch:{  }
            boolean r3 = r19.zzs()     // Catch:{  }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{  }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r11, (java.lang.Object) r3)     // Catch:{  }
            r7.zzb(r9, (int) r2, (int) r1)     // Catch:{  }
            goto L_0x017b
        L_0x0191:
            r3 = r3 & r12
            long r11 = (long) r3     // Catch:{  }
            int r3 = r19.zzf()     // Catch:{  }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{  }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r11, (java.lang.Object) r3)     // Catch:{  }
            r7.zzb(r9, (int) r2, (int) r1)     // Catch:{  }
            goto L_0x017b
        L_0x01a2:
            r3 = r3 & r12
            long r11 = (long) r3     // Catch:{  }
            long r13 = r19.zzk()     // Catch:{  }
            java.lang.Long r3 = java.lang.Long.valueOf(r13)     // Catch:{  }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r11, (java.lang.Object) r3)     // Catch:{  }
            r7.zzb(r9, (int) r2, (int) r1)     // Catch:{  }
            goto L_0x017b
        L_0x01b3:
            r3 = r3 & r12
            long r11 = (long) r3     // Catch:{  }
            int r3 = r19.zzg()     // Catch:{  }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{  }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r11, (java.lang.Object) r3)     // Catch:{  }
            r7.zzb(r9, (int) r2, (int) r1)     // Catch:{  }
            goto L_0x017b
        L_0x01c4:
            r3 = r3 & r12
            long r11 = (long) r3     // Catch:{  }
            long r13 = r19.zzo()     // Catch:{  }
            java.lang.Long r3 = java.lang.Long.valueOf(r13)     // Catch:{  }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r11, (java.lang.Object) r3)     // Catch:{  }
            r7.zzb(r9, (int) r2, (int) r1)     // Catch:{  }
            goto L_0x017b
        L_0x01d5:
            r3 = r3 & r12
            long r11 = (long) r3     // Catch:{  }
            long r13 = r19.zzl()     // Catch:{  }
            java.lang.Long r3 = java.lang.Long.valueOf(r13)     // Catch:{  }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r11, (java.lang.Object) r3)     // Catch:{  }
            r7.zzb(r9, (int) r2, (int) r1)     // Catch:{  }
            goto L_0x017b
        L_0x01e6:
            r3 = r3 & r12
            long r11 = (long) r3     // Catch:{  }
            float r3 = r19.zzb()     // Catch:{  }
            java.lang.Float r3 = java.lang.Float.valueOf(r3)     // Catch:{  }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r11, (java.lang.Object) r3)     // Catch:{  }
            r7.zzb(r9, (int) r2, (int) r1)     // Catch:{  }
            goto L_0x017b
        L_0x01f7:
            r3 = r3 & r12
            long r11 = (long) r3     // Catch:{  }
            double r13 = r19.zza()     // Catch:{  }
            java.lang.Double r3 = java.lang.Double.valueOf(r13)     // Catch:{  }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r11, (java.lang.Object) r3)     // Catch:{  }
            r7.zzb(r9, (int) r2, (int) r1)     // Catch:{  }
            goto L_0x017b
        L_0x0209:
            java.lang.Object r2 = r7.zzf((int) r1)     // Catch:{  }
            int r1 = r7.zzc((int) r1)     // Catch:{  }
            r1 = r1 & r12
            long r11 = (long) r1     // Catch:{  }
            java.lang.Object r1 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r9, r11)     // Catch:{  }
            if (r1 != 0) goto L_0x0223
            com.google.android.gms.internal.firebase-auth-api.zzakh r1 = r7.zzs     // Catch:{  }
            java.lang.Object r1 = r1.zzb(r2)     // Catch:{  }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r11, (java.lang.Object) r1)     // Catch:{  }
            goto L_0x023a
        L_0x0223:
            com.google.android.gms.internal.firebase-auth-api.zzakh r3 = r7.zzs     // Catch:{  }
            boolean r3 = r3.zzf(r1)     // Catch:{  }
            if (r3 == 0) goto L_0x023a
            com.google.android.gms.internal.firebase-auth-api.zzakh r3 = r7.zzs     // Catch:{  }
            java.lang.Object r3 = r3.zzb(r2)     // Catch:{  }
            com.google.android.gms.internal.firebase-auth-api.zzakh r13 = r7.zzs     // Catch:{  }
            r13.zza(r3, r1)     // Catch:{  }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r11, (java.lang.Object) r3)     // Catch:{  }
            r1 = r3
        L_0x023a:
            com.google.android.gms.internal.firebase-auth-api.zzakh r3 = r7.zzs     // Catch:{  }
            java.util.Map r1 = r3.zze(r1)     // Catch:{  }
            com.google.android.gms.internal.firebase-auth-api.zzakh r3 = r7.zzs     // Catch:{  }
            com.google.android.gms.internal.firebase-auth-api.zzakf r2 = r3.zza(r2)     // Catch:{  }
            r0.zza(r1, r2, (com.google.android.gms.internal.p002firebaseauthapi.zzaip) r6)     // Catch:{  }
            goto L_0x017b
        L_0x024b:
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{  }
            com.google.android.gms.internal.firebase-auth-api.zzalc r1 = r7.zze((int) r1)     // Catch:{  }
            com.google.android.gms.internal.firebase-auth-api.zzajt r11 = r7.zzp     // Catch:{  }
            java.util.List r2 = r11.zza(r9, r2)     // Catch:{  }
            r0.zza(r2, r1, (com.google.android.gms.internal.p002firebaseauthapi.zzaip) r6)     // Catch:{  }
            goto L_0x017b
        L_0x025d:
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{  }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{  }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{  }
            r0.zzm(r1)     // Catch:{  }
            goto L_0x017b
        L_0x026b:
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{  }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{  }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{  }
            r0.zzl(r1)     // Catch:{  }
            goto L_0x017b
        L_0x0279:
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{  }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{  }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{  }
            r0.zzk(r1)     // Catch:{  }
            goto L_0x017b
        L_0x0287:
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{  }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{  }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{  }
            r0.zzj(r1)     // Catch:{  }
            goto L_0x017b
        L_0x0295:
            r0 = move-exception
            goto L_0x0650
        L_0x0298:
            com.google.android.gms.internal.firebase-auth-api.zzajt r11 = r7.zzp     // Catch:{ zzaji -> 0x02b5 }
            r3 = r3 & r12
            long r12 = (long) r3     // Catch:{ zzaji -> 0x02b5 }
            java.util.List r3 = r11.zza(r9, r12)     // Catch:{ zzaji -> 0x02b5 }
            r0.zzd(r3)     // Catch:{ zzaji -> 0x02b5 }
            com.google.android.gms.internal.firebase-auth-api.zzajh r11 = r7.zzd((int) r1)     // Catch:{ zzaji -> 0x02b5 }
            r1 = r18
            r13 = r4
            r4 = r11
            r11 = r5
            r5 = r13
            r14 = r6
            r6 = r10
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zza(r1, r2, r3, r4, r5, r6)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x0618
        L_0x02b5:
            r13 = r4
            r11 = r5
            r14 = r6
            goto L_0x05f1
        L_0x02ba:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zzp(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x02cb:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zza(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x02dc:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zze(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x02ed:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zzf(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x02fe:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zzh(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x030f:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zzq(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x0320:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zzi(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x0331:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zzg(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x0342:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zzc(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x0353:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zzm(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x0364:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zzl(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x0375:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zzk(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x0386:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zzj(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x0397:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzajt r4 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r3 = r3 & r12
            long r5 = (long) r3     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r3 = r4.zza(r9, r5)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zzd(r3)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            com.google.android.gms.internal.firebase-auth-api.zzajh r4 = r7.zzd((int) r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r1 = r18
            r5 = r13
            r6 = r10
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zza(r1, r2, r3, r4, r5, r6)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x0618
        L_0x03b3:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zzp(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x03c4:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zzb(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x03d5:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzalc r1 = r7.zze((int) r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            com.google.android.gms.internal.firebase-auth-api.zzajt r4 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r2 = r4.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zzb(r2, r1, (com.google.android.gms.internal.p002firebaseauthapi.zzaip) r14)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x03ea:
            r13 = r4
            r11 = r5
            r14 = r6
            boolean r1 = zzg((int) r3)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            if (r1 == 0) goto L_0x0401
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zzo(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x0401:
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zzn(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x040f:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zza(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x0420:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zze(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x0431:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zzf(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x0442:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zzh(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x0453:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zzq(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x0464:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zzi(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x0475:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zzg(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x0486:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzajt r1 = r7.zzp     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zzc(r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x0497:
            r13 = r4
            r11 = r5
            r14 = r6
            java.lang.Object r2 = r7.zza(r9, (int) r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            com.google.android.gms.internal.firebase-auth-api.zzakk r2 = (com.google.android.gms.internal.p002firebaseauthapi.zzakk) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            com.google.android.gms.internal.firebase-auth-api.zzalc r3 = r7.zze((int) r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zza(r2, r3, (com.google.android.gms.internal.p002firebaseauthapi.zzaip) r14)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r7.zza(r9, (int) r1, (java.lang.Object) r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x04ac:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            long r4 = r19.zzn()     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r2, (long) r4)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r7.zzb(r9, (int) r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x04be:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            int r4 = r19.zzi()     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r2, (int) r4)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r7.zzb(r9, (int) r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x04d0:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            long r4 = r19.zzm()     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r2, (long) r4)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r7.zzb(r9, (int) r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x04e2:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            int r4 = r19.zzh()     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r2, (int) r4)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r7.zzb(r9, (int) r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x04f4:
            r13 = r4
            r11 = r5
            r14 = r6
            int r4 = r19.zze()     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            com.google.android.gms.internal.firebase-auth-api.zzajh r5 = r7.zzd((int) r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            if (r5 == 0) goto L_0x050e
            boolean r5 = r5.zza(r4)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            if (r5 == 0) goto L_0x0508
            goto L_0x050e
        L_0x0508:
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zza(r9, r2, r4, r13, r10)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x0618
        L_0x050e:
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r2, (int) r4)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r7.zzb(r9, (int) r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x0519:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            int r4 = r19.zzj()     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r2, (int) r4)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r7.zzb(r9, (int) r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x052b:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            com.google.android.gms.internal.firebase-auth-api.zzahm r4 = r19.zzp()     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r2, (java.lang.Object) r4)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r7.zzb(r9, (int) r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x053d:
            r13 = r4
            r11 = r5
            r14 = r6
            java.lang.Object r2 = r7.zza(r9, (int) r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            com.google.android.gms.internal.firebase-auth-api.zzakk r2 = (com.google.android.gms.internal.p002firebaseauthapi.zzakk) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            com.google.android.gms.internal.firebase-auth-api.zzalc r3 = r7.zze((int) r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r0.zzb(r2, r3, (com.google.android.gms.internal.p002firebaseauthapi.zzaip) r14)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r7.zza(r9, (int) r1, (java.lang.Object) r2)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x0552:
            r13 = r4
            r11 = r5
            r14 = r6
            r7.zza((java.lang.Object) r9, (int) r3, (com.google.android.gms.internal.p002firebaseauthapi.zzald) r0)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r7.zzb(r9, (int) r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x055d:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            boolean r4 = r19.zzs()     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc((java.lang.Object) r9, (long) r2, (boolean) r4)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r7.zzb(r9, (int) r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x056f:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            int r4 = r19.zzf()     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r2, (int) r4)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r7.zzb(r9, (int) r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x0581:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            long r4 = r19.zzk()     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r2, (long) r4)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r7.zzb(r9, (int) r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x0592:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            int r4 = r19.zzg()     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r2, (int) r4)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r7.zzb(r9, (int) r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x05a3:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            long r4 = r19.zzo()     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r2, (long) r4)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r7.zzb(r9, (int) r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x05b4:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            long r4 = r19.zzl()     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r2, (long) r4)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r7.zzb(r9, (int) r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x05c5:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            float r4 = r19.zzb()     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r2, (float) r4)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r7.zzb(r9, (int) r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            goto L_0x05e6
        L_0x05d6:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            double r4 = r19.zza()     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r9, (long) r2, (double) r4)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
            r7.zzb(r9, (int) r1)     // Catch:{ zzaji -> 0x05f1, all -> 0x05ed }
        L_0x05e6:
            r15 = r9
            r5 = r11
            r4 = r13
        L_0x05e9:
            r6 = r14
        L_0x05ea:
            r14 = r10
            goto L_0x0017
        L_0x05ed:
            r0 = move-exception
            r4 = r13
            goto L_0x0650
        L_0x05f1:
            r4 = r13
            goto L_0x061b
        L_0x05f3:
            r4 = r13
        L_0x05f4:
            boolean r1 = r10.zza(r4, (com.google.android.gms.internal.p002firebaseauthapi.zzald) r0)     // Catch:{ zzaji -> 0x061b }
            if (r1 != 0) goto L_0x0618
            int r0 = r7.zzm
        L_0x05fc:
            int r1 = r7.zzn
            if (r0 >= r1) goto L_0x0612
            int[] r1 = r7.zzl
            r3 = r1[r0]
            r1 = r17
            r2 = r18
            r5 = r10
            r6 = r18
            java.lang.Object r4 = r1.zza((java.lang.Object) r2, (int) r3, r4, r5, (java.lang.Object) r6)
            int r0 = r0 + 1
            goto L_0x05fc
        L_0x0612:
            if (r4 == 0) goto L_0x0617
            r10.zzb((java.lang.Object) r9, r4)
        L_0x0617:
            return
        L_0x0618:
            r15 = r9
            r5 = r11
            goto L_0x05e9
        L_0x061b:
            r10.zza((com.google.android.gms.internal.p002firebaseauthapi.zzald) r0)     // Catch:{ all -> 0x0295 }
            if (r4 != 0) goto L_0x0625
            java.lang.Object r1 = r10.zzc(r9)     // Catch:{ all -> 0x0295 }
            r4 = r1
        L_0x0625:
            boolean r1 = r10.zza(r4, (com.google.android.gms.internal.p002firebaseauthapi.zzald) r0)     // Catch:{ all -> 0x0295 }
            if (r1 != 0) goto L_0x0618
            int r0 = r7.zzm
        L_0x062d:
            int r1 = r7.zzn
            if (r0 >= r1) goto L_0x0643
            int[] r1 = r7.zzl
            r3 = r1[r0]
            r1 = r17
            r2 = r18
            r5 = r10
            r6 = r18
            java.lang.Object r4 = r1.zza((java.lang.Object) r2, (int) r3, r4, r5, (java.lang.Object) r6)
            int r0 = r0 + 1
            goto L_0x062d
        L_0x0643:
            if (r4 == 0) goto L_0x0648
            r10.zzb((java.lang.Object) r9, r4)
        L_0x0648:
            return
        L_0x0649:
            r0 = move-exception
            r13 = r4
            goto L_0x0650
        L_0x064c:
            r0 = move-exception
            r13 = r4
        L_0x064e:
            r10 = r14
            r9 = r15
        L_0x0650:
            int r1 = r7.zzm
            r8 = r1
        L_0x0653:
            int r1 = r7.zzn
            if (r8 >= r1) goto L_0x0669
            int[] r1 = r7.zzl
            r3 = r1[r8]
            r1 = r17
            r2 = r18
            r5 = r10
            r6 = r18
            java.lang.Object r4 = r1.zza((java.lang.Object) r2, (int) r3, r4, r5, (java.lang.Object) r6)
            int r8 = r8 + 1
            goto L_0x0653
        L_0x0669:
            if (r4 == 0) goto L_0x066e
            r10.zzb((java.lang.Object) r9, r4)
        L_0x066e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzako.zza(java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzald, com.google.android.gms.internal.firebase-auth-api.zzaip):void");
    }

    public final void zza(T t, byte[] bArr, int i, int i2, zzahl zzahl) throws IOException {
        zza(t, bArr, i, i2, 0, zzahl);
    }

    private final void zza(T t, T t2, int i) {
        if (zzc(t2, i)) {
            long zzc2 = (long) (zzc(i) & 1048575);
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t2, zzc2);
            if (object != null) {
                zzalc zze2 = zze(i);
                if (!zzc(t, i)) {
                    if (!zzg(object)) {
                        unsafe.putObject(t, zzc2, object);
                    } else {
                        Object zza2 = zze2.zza();
                        zze2.zza(zza2, object);
                        unsafe.putObject(t, zzc2, zza2);
                    }
                    zzb(t, i);
                    return;
                }
                Object object2 = unsafe.getObject(t, zzc2);
                if (!zzg(object2)) {
                    Object zza3 = zze2.zza();
                    zze2.zza(zza3, object2);
                    unsafe.putObject(t, zzc2, zza3);
                    object2 = zza3;
                }
                zze2.zza(object2, object);
                return;
            }
            int i2 = this.zzc[i];
            throw new IllegalStateException("Source subfield " + i2 + " is present but null: " + String.valueOf(t2));
        }
    }

    private final void zzb(T t, T t2, int i) {
        int i2 = this.zzc[i];
        if (zzc(t2, i2, i)) {
            long zzc2 = (long) (zzc(i) & 1048575);
            Unsafe unsafe = zzb;
            Object object = unsafe.getObject(t2, zzc2);
            if (object != null) {
                zzalc zze2 = zze(i);
                if (!zzc(t, i2, i)) {
                    if (!zzg(object)) {
                        unsafe.putObject(t, zzc2, object);
                    } else {
                        Object zza2 = zze2.zza();
                        zze2.zza(zza2, object);
                        unsafe.putObject(t, zzc2, zza2);
                    }
                    zzb(t, i2, i);
                    return;
                }
                Object object2 = unsafe.getObject(t, zzc2);
                if (!zzg(object2)) {
                    Object zza3 = zze2.zza();
                    zze2.zza(zza3, object2);
                    unsafe.putObject(t, zzc2, zza3);
                    object2 = zza3;
                }
                zze2.zza(object2, object);
                return;
            }
            int i3 = this.zzc[i];
            throw new IllegalStateException("Source subfield " + i3 + " is present but null: " + String.valueOf(t2));
        }
    }

    private final void zza(Object obj, int i, zzald zzald) throws IOException {
        if (zzg(i)) {
            zzamh.zza(obj, (long) (i & 1048575), (Object) zzald.zzr());
        } else if (this.zzi) {
            zzamh.zza(obj, (long) (i & 1048575), (Object) zzald.zzq());
        } else {
            zzamh.zza(obj, (long) (i & 1048575), (Object) zzald.zzp());
        }
    }

    private final void zzb(T t, int i) {
        int zzb2 = zzb(i);
        long j = (long) (1048575 & zzb2);
        if (j != 1048575) {
            zzamh.zza((Object) t, j, (1 << (zzb2 >>> 20)) | zzamh.zzc(t, j));
        }
    }

    private final void zzb(T t, int i, int i2) {
        zzamh.zza((Object) t, (long) (zzb(i2) & 1048575), i);
    }

    private final void zza(T t, int i, Object obj) {
        zzb.putObject(t, (long) (zzc(i) & 1048575), obj);
        zzb(t, i);
    }

    private final void zza(T t, int i, int i2, Object obj) {
        zzb.putObject(t, (long) (zzc(i2) & 1048575), obj);
        zzb(t, i, i2);
    }

    private final <K, V> void zza(zzanb zzanb, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzanb.zza(i, this.zzs.zza(zzf(i2)), this.zzs.zzd(obj));
        }
    }

    private static void zza(int i, Object obj, zzanb zzanb) throws IOException {
        if (obj instanceof String) {
            zzanb.zza(i, (String) obj);
        } else {
            zzanb.zza(i, (zzahm) obj);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:196:0x05b9, code lost:
        r22 = r10;
        r20 = r11;
        r21 = r15;
        r16 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x05c1, code lost:
        r11 = r4;
        r15 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x08eb, code lost:
        r22 = r10;
        r20 = r11;
        r16 = r12;
        r21 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:342:0x0b76, code lost:
        r4 = r11 + 3;
        r2 = r13;
        r5 = r15;
        r12 = r16;
        r13 = 1048575;
        r14 = r19;
        r1 = r20;
        r15 = r21;
        r0 = r22;
        r9 = 267386880;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0518  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0557  */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x0b8f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r24, com.google.android.gms.internal.p002firebaseauthapi.zzanb r25) throws java.io.IOException {
        /*
            r23 = this;
            r6 = r23
            r7 = r24
            r8 = r25
            int r0 = r25.zza()
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzana.zzb
            r9 = 267386880(0xff00000, float:2.3665827E-29)
            r11 = 1
            r12 = 0
            r13 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x052d
            com.google.android.gms.internal.firebase-auth-api.zzamb<?, ?> r0 = r6.zzq
            zza(r0, r7, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8)
            boolean r0 = r6.zzh
            if (r0 == 0) goto L_0x0037
            com.google.android.gms.internal.firebase-auth-api.zzair<?> r0 = r6.zzr
            com.google.android.gms.internal.firebase-auth-api.zzais r0 = r0.zza((java.lang.Object) r7)
            com.google.android.gms.internal.firebase-auth-api.zzalh<T, java.lang.Object> r1 = r0.zza
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0037
            java.util.Iterator r0 = r0.zzc()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0039
        L_0x0037:
            r0 = 0
            r1 = 0
        L_0x0039:
            int[] r2 = r6.zzc
            int r2 = r2.length
            int r2 = r2 + -3
        L_0x003e:
            if (r2 < 0) goto L_0x0516
            int r3 = r6.zzc((int) r2)
            int[] r4 = r6.zzc
            r4 = r4[r2]
        L_0x0048:
            if (r1 == 0) goto L_0x0066
            com.google.android.gms.internal.firebase-auth-api.zzair<?> r5 = r6.zzr
            int r5 = r5.zza((java.util.Map.Entry<?, ?>) r1)
            if (r5 <= r4) goto L_0x0066
            com.google.android.gms.internal.firebase-auth-api.zzair<?> r5 = r6.zzr
            r5.zza(r8, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0064
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0048
        L_0x0064:
            r1 = 0
            goto L_0x0048
        L_0x0066:
            r5 = r3 & r9
            int r5 = r5 >>> 20
            switch(r5) {
                case 0: goto L_0x0503;
                case 1: goto L_0x04f3;
                case 2: goto L_0x04e3;
                case 3: goto L_0x04d3;
                case 4: goto L_0x04c3;
                case 5: goto L_0x04b3;
                case 6: goto L_0x04a3;
                case 7: goto L_0x0492;
                case 8: goto L_0x0481;
                case 9: goto L_0x046c;
                case 10: goto L_0x0459;
                case 11: goto L_0x0448;
                case 12: goto L_0x0437;
                case 13: goto L_0x0426;
                case 14: goto L_0x0415;
                case 15: goto L_0x0404;
                case 16: goto L_0x03f3;
                case 17: goto L_0x03de;
                case 18: goto L_0x03cd;
                case 19: goto L_0x03bc;
                case 20: goto L_0x03ab;
                case 21: goto L_0x039a;
                case 22: goto L_0x0389;
                case 23: goto L_0x0378;
                case 24: goto L_0x0367;
                case 25: goto L_0x0356;
                case 26: goto L_0x0345;
                case 27: goto L_0x0330;
                case 28: goto L_0x031f;
                case 29: goto L_0x030e;
                case 30: goto L_0x02fd;
                case 31: goto L_0x02ec;
                case 32: goto L_0x02db;
                case 33: goto L_0x02ca;
                case 34: goto L_0x02b9;
                case 35: goto L_0x02a8;
                case 36: goto L_0x0297;
                case 37: goto L_0x0286;
                case 38: goto L_0x0275;
                case 39: goto L_0x0264;
                case 40: goto L_0x0253;
                case 41: goto L_0x0242;
                case 42: goto L_0x0231;
                case 43: goto L_0x0220;
                case 44: goto L_0x020f;
                case 45: goto L_0x01fe;
                case 46: goto L_0x01ed;
                case 47: goto L_0x01dc;
                case 48: goto L_0x01cb;
                case 49: goto L_0x01b6;
                case 50: goto L_0x01ab;
                case 51: goto L_0x019a;
                case 52: goto L_0x0189;
                case 53: goto L_0x0178;
                case 54: goto L_0x0167;
                case 55: goto L_0x0156;
                case 56: goto L_0x0145;
                case 57: goto L_0x0134;
                case 58: goto L_0x0123;
                case 59: goto L_0x0112;
                case 60: goto L_0x00fd;
                case 61: goto L_0x00ea;
                case 62: goto L_0x00d9;
                case 63: goto L_0x00c8;
                case 64: goto L_0x00b7;
                case 65: goto L_0x00a6;
                case 66: goto L_0x0095;
                case 67: goto L_0x0084;
                case 68: goto L_0x006f;
                default: goto L_0x006d;
            }
        L_0x006d:
            goto L_0x0512
        L_0x006f:
            boolean r5 = r6.zzc(r7, (int) r4, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            com.google.android.gms.internal.firebase-auth-api.zzalc r5 = r6.zze((int) r2)
            r8.zza((int) r4, (java.lang.Object) r3, (com.google.android.gms.internal.p002firebaseauthapi.zzalc) r5)
            goto L_0x0512
        L_0x0084:
            boolean r5 = r6.zzc(r7, (int) r4, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            long r14 = zzd(r7, r14)
            r8.zzd((int) r4, (long) r14)
            goto L_0x0512
        L_0x0095:
            boolean r5 = r6.zzc(r7, (int) r4, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            int r3 = zzc(r7, (long) r14)
            r8.zze((int) r4, (int) r3)
            goto L_0x0512
        L_0x00a6:
            boolean r5 = r6.zzc(r7, (int) r4, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            long r14 = zzd(r7, r14)
            r8.zzc((int) r4, (long) r14)
            goto L_0x0512
        L_0x00b7:
            boolean r5 = r6.zzc(r7, (int) r4, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            int r3 = zzc(r7, (long) r14)
            r8.zzd((int) r4, (int) r3)
            goto L_0x0512
        L_0x00c8:
            boolean r5 = r6.zzc(r7, (int) r4, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            int r3 = zzc(r7, (long) r14)
            r8.zza((int) r4, (int) r3)
            goto L_0x0512
        L_0x00d9:
            boolean r5 = r6.zzc(r7, (int) r4, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            int r3 = zzc(r7, (long) r14)
            r8.zzf(r4, r3)
            goto L_0x0512
        L_0x00ea:
            boolean r5 = r6.zzc(r7, (int) r4, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            com.google.android.gms.internal.firebase-auth-api.zzahm r3 = (com.google.android.gms.internal.p002firebaseauthapi.zzahm) r3
            r8.zza((int) r4, (com.google.android.gms.internal.p002firebaseauthapi.zzahm) r3)
            goto L_0x0512
        L_0x00fd:
            boolean r5 = r6.zzc(r7, (int) r4, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            com.google.android.gms.internal.firebase-auth-api.zzalc r5 = r6.zze((int) r2)
            r8.zzb((int) r4, (java.lang.Object) r3, (com.google.android.gms.internal.p002firebaseauthapi.zzalc) r5)
            goto L_0x0512
        L_0x0112:
            boolean r5 = r6.zzc(r7, (int) r4, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            zza((int) r4, (java.lang.Object) r3, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8)
            goto L_0x0512
        L_0x0123:
            boolean r5 = r6.zzc(r7, (int) r4, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            boolean r3 = zze(r7, r14)
            r8.zza((int) r4, (boolean) r3)
            goto L_0x0512
        L_0x0134:
            boolean r5 = r6.zzc(r7, (int) r4, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            int r3 = zzc(r7, (long) r14)
            r8.zzb((int) r4, (int) r3)
            goto L_0x0512
        L_0x0145:
            boolean r5 = r6.zzc(r7, (int) r4, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            long r14 = zzd(r7, r14)
            r8.zza((int) r4, (long) r14)
            goto L_0x0512
        L_0x0156:
            boolean r5 = r6.zzc(r7, (int) r4, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            int r3 = zzc(r7, (long) r14)
            r8.zzc((int) r4, (int) r3)
            goto L_0x0512
        L_0x0167:
            boolean r5 = r6.zzc(r7, (int) r4, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            long r14 = zzd(r7, r14)
            r8.zze((int) r4, (long) r14)
            goto L_0x0512
        L_0x0178:
            boolean r5 = r6.zzc(r7, (int) r4, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            long r14 = zzd(r7, r14)
            r8.zzb((int) r4, (long) r14)
            goto L_0x0512
        L_0x0189:
            boolean r5 = r6.zzc(r7, (int) r4, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            float r3 = zzb(r7, (long) r14)
            r8.zza((int) r4, (float) r3)
            goto L_0x0512
        L_0x019a:
            boolean r5 = r6.zzc(r7, (int) r4, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            double r14 = zza(r7, (long) r14)
            r8.zza((int) r4, (double) r14)
            goto L_0x0512
        L_0x01ab:
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            r6.zza((com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8, (int) r4, (java.lang.Object) r3, (int) r2)
            goto L_0x0512
        L_0x01b6:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.firebase-auth-api.zzalc r5 = r6.zze((int) r2)
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zza((int) r4, (java.util.List<?>) r3, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8, (com.google.android.gms.internal.p002firebaseauthapi.zzalc) r5)
            goto L_0x0512
        L_0x01cb:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzl(r4, r3, r8, r11)
            goto L_0x0512
        L_0x01dc:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzk(r4, r3, r8, r11)
            goto L_0x0512
        L_0x01ed:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzj(r4, r3, r8, r11)
            goto L_0x0512
        L_0x01fe:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzi(r4, r3, r8, r11)
            goto L_0x0512
        L_0x020f:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzc(r4, r3, r8, r11)
            goto L_0x0512
        L_0x0220:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzm(r4, r3, r8, r11)
            goto L_0x0512
        L_0x0231:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zza((int) r4, (java.util.List<java.lang.Boolean>) r3, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8, (boolean) r11)
            goto L_0x0512
        L_0x0242:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzd(r4, r3, r8, r11)
            goto L_0x0512
        L_0x0253:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zze(r4, r3, r8, r11)
            goto L_0x0512
        L_0x0264:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzg(r4, r3, r8, r11)
            goto L_0x0512
        L_0x0275:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzn(r4, r3, r8, r11)
            goto L_0x0512
        L_0x0286:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzh(r4, r3, r8, r11)
            goto L_0x0512
        L_0x0297:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzf(r4, r3, r8, r11)
            goto L_0x0512
        L_0x02a8:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzb((int) r4, (java.util.List<java.lang.Double>) r3, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8, (boolean) r11)
            goto L_0x0512
        L_0x02b9:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzl(r4, r3, r8, r12)
            goto L_0x0512
        L_0x02ca:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzk(r4, r3, r8, r12)
            goto L_0x0512
        L_0x02db:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzj(r4, r3, r8, r12)
            goto L_0x0512
        L_0x02ec:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzi(r4, r3, r8, r12)
            goto L_0x0512
        L_0x02fd:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzc(r4, r3, r8, r12)
            goto L_0x0512
        L_0x030e:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzm(r4, r3, r8, r12)
            goto L_0x0512
        L_0x031f:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zza((int) r4, (java.util.List<com.google.android.gms.internal.p002firebaseauthapi.zzahm>) r3, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8)
            goto L_0x0512
        L_0x0330:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.firebase-auth-api.zzalc r5 = r6.zze((int) r2)
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzb((int) r4, (java.util.List<?>) r3, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8, (com.google.android.gms.internal.p002firebaseauthapi.zzalc) r5)
            goto L_0x0512
        L_0x0345:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzb((int) r4, (java.util.List<java.lang.String>) r3, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8)
            goto L_0x0512
        L_0x0356:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zza((int) r4, (java.util.List<java.lang.Boolean>) r3, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8, (boolean) r12)
            goto L_0x0512
        L_0x0367:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzd(r4, r3, r8, r12)
            goto L_0x0512
        L_0x0378:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zze(r4, r3, r8, r12)
            goto L_0x0512
        L_0x0389:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzg(r4, r3, r8, r12)
            goto L_0x0512
        L_0x039a:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzn(r4, r3, r8, r12)
            goto L_0x0512
        L_0x03ab:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzh(r4, r3, r8, r12)
            goto L_0x0512
        L_0x03bc:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzf(r4, r3, r8, r12)
            goto L_0x0512
        L_0x03cd:
            int[] r4 = r6.zzc
            r4 = r4[r2]
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzb((int) r4, (java.util.List<java.lang.Double>) r3, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8, (boolean) r12)
            goto L_0x0512
        L_0x03de:
            boolean r5 = r6.zzc(r7, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            com.google.android.gms.internal.firebase-auth-api.zzalc r5 = r6.zze((int) r2)
            r8.zza((int) r4, (java.lang.Object) r3, (com.google.android.gms.internal.p002firebaseauthapi.zzalc) r5)
            goto L_0x0512
        L_0x03f3:
            boolean r5 = r6.zzc(r7, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            long r14 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r7, r14)
            r8.zzd((int) r4, (long) r14)
            goto L_0x0512
        L_0x0404:
            boolean r5 = r6.zzc(r7, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r7, r14)
            r8.zze((int) r4, (int) r3)
            goto L_0x0512
        L_0x0415:
            boolean r5 = r6.zzc(r7, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            long r14 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r7, r14)
            r8.zzc((int) r4, (long) r14)
            goto L_0x0512
        L_0x0426:
            boolean r5 = r6.zzc(r7, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r7, r14)
            r8.zzd((int) r4, (int) r3)
            goto L_0x0512
        L_0x0437:
            boolean r5 = r6.zzc(r7, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r7, r14)
            r8.zza((int) r4, (int) r3)
            goto L_0x0512
        L_0x0448:
            boolean r5 = r6.zzc(r7, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r7, r14)
            r8.zzf(r4, r3)
            goto L_0x0512
        L_0x0459:
            boolean r5 = r6.zzc(r7, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            com.google.android.gms.internal.firebase-auth-api.zzahm r3 = (com.google.android.gms.internal.p002firebaseauthapi.zzahm) r3
            r8.zza((int) r4, (com.google.android.gms.internal.p002firebaseauthapi.zzahm) r3)
            goto L_0x0512
        L_0x046c:
            boolean r5 = r6.zzc(r7, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            com.google.android.gms.internal.firebase-auth-api.zzalc r5 = r6.zze((int) r2)
            r8.zzb((int) r4, (java.lang.Object) r3, (com.google.android.gms.internal.p002firebaseauthapi.zzalc) r5)
            goto L_0x0512
        L_0x0481:
            boolean r5 = r6.zzc(r7, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r7, r14)
            zza((int) r4, (java.lang.Object) r3, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8)
            goto L_0x0512
        L_0x0492:
            boolean r5 = r6.zzc(r7, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            boolean r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzh(r7, r14)
            r8.zza((int) r4, (boolean) r3)
            goto L_0x0512
        L_0x04a3:
            boolean r5 = r6.zzc(r7, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r7, r14)
            r8.zzb((int) r4, (int) r3)
            goto L_0x0512
        L_0x04b3:
            boolean r5 = r6.zzc(r7, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            long r14 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r7, r14)
            r8.zza((int) r4, (long) r14)
            goto L_0x0512
        L_0x04c3:
            boolean r5 = r6.zzc(r7, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r7, r14)
            r8.zzc((int) r4, (int) r3)
            goto L_0x0512
        L_0x04d3:
            boolean r5 = r6.zzc(r7, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            long r14 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r7, r14)
            r8.zze((int) r4, (long) r14)
            goto L_0x0512
        L_0x04e3:
            boolean r5 = r6.zzc(r7, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            long r14 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r7, r14)
            r8.zzb((int) r4, (long) r14)
            goto L_0x0512
        L_0x04f3:
            boolean r5 = r6.zzc(r7, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            float r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzb(r7, r14)
            r8.zza((int) r4, (float) r3)
            goto L_0x0512
        L_0x0503:
            boolean r5 = r6.zzc(r7, (int) r2)
            if (r5 == 0) goto L_0x0512
            r3 = r3 & r13
            long r14 = (long) r3
            double r14 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r7, (long) r14)
            r8.zza((int) r4, (double) r14)
        L_0x0512:
            int r2 = r2 + -3
            goto L_0x003e
        L_0x0516:
            if (r1 == 0) goto L_0x052c
            com.google.android.gms.internal.firebase-auth-api.zzair<?> r2 = r6.zzr
            r2.zza(r8, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x052a
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0516
        L_0x052a:
            r1 = 0
            goto L_0x0516
        L_0x052c:
            return
        L_0x052d:
            boolean r0 = r6.zzh
            if (r0 == 0) goto L_0x054b
            com.google.android.gms.internal.firebase-auth-api.zzair<?> r0 = r6.zzr
            com.google.android.gms.internal.firebase-auth-api.zzais r0 = r0.zza((java.lang.Object) r7)
            com.google.android.gms.internal.firebase-auth-api.zzalh<T, java.lang.Object> r1 = r0.zza
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x054b
            java.util.Iterator r0 = r0.zzd()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            r14 = r0
            goto L_0x054d
        L_0x054b:
            r1 = 0
            r14 = 0
        L_0x054d:
            int[] r0 = r6.zzc
            int r15 = r0.length
            sun.misc.Unsafe r5 = zzb
            r2 = r12
            r4 = r2
            r0 = r13
        L_0x0555:
            if (r4 >= r15) goto L_0x0b8b
            int r3 = r6.zzc((int) r4)
            int[] r10 = r6.zzc
            r12 = r10[r4]
            r17 = r3 & r9
            int r9 = r17 >>> 20
            r11 = 17
            if (r9 > r11) goto L_0x058b
            int r11 = r4 + 2
            r10 = r10[r11]
            r11 = r10 & r13
            if (r11 == r0) goto L_0x057f
            if (r11 != r13) goto L_0x0575
            r19 = r14
            r2 = 0
            goto L_0x057d
        L_0x0575:
            r19 = r14
            long r13 = (long) r11
            int r0 = r5.getInt(r7, r13)
            r2 = r0
        L_0x057d:
            r0 = r11
            goto L_0x0581
        L_0x057f:
            r19 = r14
        L_0x0581:
            int r10 = r10 >>> 20
            r11 = 1
            int r10 = r11 << r10
            r11 = r1
            r13 = r2
            r14 = r10
            r10 = r0
            goto L_0x0591
        L_0x058b:
            r19 = r14
            r10 = r0
            r11 = r1
            r13 = r2
            r14 = 0
        L_0x0591:
            if (r11 == 0) goto L_0x05b0
            com.google.android.gms.internal.firebase-auth-api.zzair<?> r0 = r6.zzr
            int r0 = r0.zza((java.util.Map.Entry<?, ?>) r11)
            if (r0 > r12) goto L_0x05b0
            com.google.android.gms.internal.firebase-auth-api.zzair<?> r0 = r6.zzr
            r0.zza(r8, r11)
            boolean r0 = r19.hasNext()
            if (r0 == 0) goto L_0x05ae
            java.lang.Object r0 = r19.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            r11 = r0
            goto L_0x0591
        L_0x05ae:
            r11 = 0
            goto L_0x0591
        L_0x05b0:
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r3 & r18
            long r2 = (long) r0
            switch(r9) {
                case 0: goto L_0x0b55;
                case 1: goto L_0x0b33;
                case 2: goto L_0x0b11;
                case 3: goto L_0x0aee;
                case 4: goto L_0x0acb;
                case 5: goto L_0x0aa8;
                case 6: goto L_0x0a85;
                case 7: goto L_0x0a62;
                case 8: goto L_0x0a3f;
                case 9: goto L_0x0a18;
                case 10: goto L_0x09f3;
                case 11: goto L_0x09d0;
                case 12: goto L_0x09ad;
                case 13: goto L_0x098a;
                case 14: goto L_0x0967;
                case 15: goto L_0x0944;
                case 16: goto L_0x0921;
                case 17: goto L_0x08f5;
                case 18: goto L_0x08dc;
                case 19: goto L_0x08cc;
                case 20: goto L_0x08bc;
                case 21: goto L_0x08ac;
                case 22: goto L_0x089c;
                case 23: goto L_0x088c;
                case 24: goto L_0x087c;
                case 25: goto L_0x086c;
                case 26: goto L_0x085c;
                case 27: goto L_0x0848;
                case 28: goto L_0x0838;
                case 29: goto L_0x0827;
                case 30: goto L_0x0816;
                case 31: goto L_0x0805;
                case 32: goto L_0x07f4;
                case 33: goto L_0x07e3;
                case 34: goto L_0x07d2;
                case 35: goto L_0x07c2;
                case 36: goto L_0x07b2;
                case 37: goto L_0x07a2;
                case 38: goto L_0x0792;
                case 39: goto L_0x0782;
                case 40: goto L_0x0772;
                case 41: goto L_0x0762;
                case 42: goto L_0x0752;
                case 43: goto L_0x0742;
                case 44: goto L_0x0732;
                case 45: goto L_0x0722;
                case 46: goto L_0x0712;
                case 47: goto L_0x0702;
                case 48: goto L_0x06f2;
                case 49: goto L_0x06df;
                case 50: goto L_0x06d6;
                case 51: goto L_0x06c7;
                case 52: goto L_0x06b8;
                case 53: goto L_0x06a9;
                case 54: goto L_0x069a;
                case 55: goto L_0x068b;
                case 56: goto L_0x067c;
                case 57: goto L_0x066d;
                case 58: goto L_0x065e;
                case 59: goto L_0x064f;
                case 60: goto L_0x063c;
                case 61: goto L_0x062b;
                case 62: goto L_0x061d;
                case 63: goto L_0x060f;
                case 64: goto L_0x0601;
                case 65: goto L_0x05f3;
                case 66: goto L_0x05e5;
                case 67: goto L_0x05d7;
                case 68: goto L_0x05c5;
                default: goto L_0x05b9;
            }
        L_0x05b9:
            r22 = r10
            r20 = r11
            r21 = r15
            r16 = 0
        L_0x05c1:
            r11 = r4
            r15 = r5
            goto L_0x0b76
        L_0x05c5:
            boolean r0 = r6.zzc(r7, (int) r12, (int) r4)
            if (r0 == 0) goto L_0x05b9
            java.lang.Object r0 = r5.getObject(r7, r2)
            com.google.android.gms.internal.firebase-auth-api.zzalc r1 = r6.zze((int) r4)
            r8.zza((int) r12, (java.lang.Object) r0, (com.google.android.gms.internal.p002firebaseauthapi.zzalc) r1)
            goto L_0x05b9
        L_0x05d7:
            boolean r0 = r6.zzc(r7, (int) r12, (int) r4)
            if (r0 == 0) goto L_0x05b9
            long r0 = zzd(r7, r2)
            r8.zzd((int) r12, (long) r0)
            goto L_0x05b9
        L_0x05e5:
            boolean r0 = r6.zzc(r7, (int) r12, (int) r4)
            if (r0 == 0) goto L_0x05b9
            int r0 = zzc(r7, (long) r2)
            r8.zze((int) r12, (int) r0)
            goto L_0x05b9
        L_0x05f3:
            boolean r0 = r6.zzc(r7, (int) r12, (int) r4)
            if (r0 == 0) goto L_0x05b9
            long r0 = zzd(r7, r2)
            r8.zzc((int) r12, (long) r0)
            goto L_0x05b9
        L_0x0601:
            boolean r0 = r6.zzc(r7, (int) r12, (int) r4)
            if (r0 == 0) goto L_0x05b9
            int r0 = zzc(r7, (long) r2)
            r8.zzd((int) r12, (int) r0)
            goto L_0x05b9
        L_0x060f:
            boolean r0 = r6.zzc(r7, (int) r12, (int) r4)
            if (r0 == 0) goto L_0x05b9
            int r0 = zzc(r7, (long) r2)
            r8.zza((int) r12, (int) r0)
            goto L_0x05b9
        L_0x061d:
            boolean r0 = r6.zzc(r7, (int) r12, (int) r4)
            if (r0 == 0) goto L_0x05b9
            int r0 = zzc(r7, (long) r2)
            r8.zzf(r12, r0)
            goto L_0x05b9
        L_0x062b:
            boolean r0 = r6.zzc(r7, (int) r12, (int) r4)
            if (r0 == 0) goto L_0x05b9
            java.lang.Object r0 = r5.getObject(r7, r2)
            com.google.android.gms.internal.firebase-auth-api.zzahm r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzahm) r0
            r8.zza((int) r12, (com.google.android.gms.internal.p002firebaseauthapi.zzahm) r0)
            goto L_0x05b9
        L_0x063c:
            boolean r0 = r6.zzc(r7, (int) r12, (int) r4)
            if (r0 == 0) goto L_0x05b9
            java.lang.Object r0 = r5.getObject(r7, r2)
            com.google.android.gms.internal.firebase-auth-api.zzalc r1 = r6.zze((int) r4)
            r8.zzb((int) r12, (java.lang.Object) r0, (com.google.android.gms.internal.p002firebaseauthapi.zzalc) r1)
            goto L_0x05b9
        L_0x064f:
            boolean r0 = r6.zzc(r7, (int) r12, (int) r4)
            if (r0 == 0) goto L_0x05b9
            java.lang.Object r0 = r5.getObject(r7, r2)
            zza((int) r12, (java.lang.Object) r0, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8)
            goto L_0x05b9
        L_0x065e:
            boolean r0 = r6.zzc(r7, (int) r12, (int) r4)
            if (r0 == 0) goto L_0x05b9
            boolean r0 = zze(r7, r2)
            r8.zza((int) r12, (boolean) r0)
            goto L_0x05b9
        L_0x066d:
            boolean r0 = r6.zzc(r7, (int) r12, (int) r4)
            if (r0 == 0) goto L_0x05b9
            int r0 = zzc(r7, (long) r2)
            r8.zzb((int) r12, (int) r0)
            goto L_0x05b9
        L_0x067c:
            boolean r0 = r6.zzc(r7, (int) r12, (int) r4)
            if (r0 == 0) goto L_0x05b9
            long r0 = zzd(r7, r2)
            r8.zza((int) r12, (long) r0)
            goto L_0x05b9
        L_0x068b:
            boolean r0 = r6.zzc(r7, (int) r12, (int) r4)
            if (r0 == 0) goto L_0x05b9
            int r0 = zzc(r7, (long) r2)
            r8.zzc((int) r12, (int) r0)
            goto L_0x05b9
        L_0x069a:
            boolean r0 = r6.zzc(r7, (int) r12, (int) r4)
            if (r0 == 0) goto L_0x05b9
            long r0 = zzd(r7, r2)
            r8.zze((int) r12, (long) r0)
            goto L_0x05b9
        L_0x06a9:
            boolean r0 = r6.zzc(r7, (int) r12, (int) r4)
            if (r0 == 0) goto L_0x05b9
            long r0 = zzd(r7, r2)
            r8.zzb((int) r12, (long) r0)
            goto L_0x05b9
        L_0x06b8:
            boolean r0 = r6.zzc(r7, (int) r12, (int) r4)
            if (r0 == 0) goto L_0x05b9
            float r0 = zzb(r7, (long) r2)
            r8.zza((int) r12, (float) r0)
            goto L_0x05b9
        L_0x06c7:
            boolean r0 = r6.zzc(r7, (int) r12, (int) r4)
            if (r0 == 0) goto L_0x05b9
            double r0 = zza(r7, (long) r2)
            r8.zza((int) r12, (double) r0)
            goto L_0x05b9
        L_0x06d6:
            java.lang.Object r0 = r5.getObject(r7, r2)
            r6.zza((com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8, (int) r12, (java.lang.Object) r0, (int) r4)
            goto L_0x05b9
        L_0x06df:
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.firebase-auth-api.zzalc r2 = r6.zze((int) r4)
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zza((int) r0, (java.util.List<?>) r1, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8, (com.google.android.gms.internal.p002firebaseauthapi.zzalc) r2)
            goto L_0x05b9
        L_0x06f2:
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            r9 = 1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzl(r0, r1, r8, r9)
            goto L_0x05b9
        L_0x0702:
            r9 = 1
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzk(r0, r1, r8, r9)
            goto L_0x05b9
        L_0x0712:
            r9 = 1
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzj(r0, r1, r8, r9)
            goto L_0x05b9
        L_0x0722:
            r9 = 1
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzi(r0, r1, r8, r9)
            goto L_0x05b9
        L_0x0732:
            r9 = 1
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzc(r0, r1, r8, r9)
            goto L_0x05b9
        L_0x0742:
            r9 = 1
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzm(r0, r1, r8, r9)
            goto L_0x05b9
        L_0x0752:
            r9 = 1
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zza((int) r0, (java.util.List<java.lang.Boolean>) r1, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8, (boolean) r9)
            goto L_0x05b9
        L_0x0762:
            r9 = 1
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzd(r0, r1, r8, r9)
            goto L_0x05b9
        L_0x0772:
            r9 = 1
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zze(r0, r1, r8, r9)
            goto L_0x05b9
        L_0x0782:
            r9 = 1
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzg(r0, r1, r8, r9)
            goto L_0x05b9
        L_0x0792:
            r9 = 1
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzn(r0, r1, r8, r9)
            goto L_0x05b9
        L_0x07a2:
            r9 = 1
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzh(r0, r1, r8, r9)
            goto L_0x05b9
        L_0x07b2:
            r9 = 1
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzf(r0, r1, r8, r9)
            goto L_0x05b9
        L_0x07c2:
            r9 = 1
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzb((int) r0, (java.util.List<java.lang.Double>) r1, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8, (boolean) r9)
            goto L_0x05b9
        L_0x07d2:
            r9 = 1
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            r12 = 0
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzl(r0, r1, r8, r12)
            goto L_0x08eb
        L_0x07e3:
            r9 = 1
            r12 = 0
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzk(r0, r1, r8, r12)
            goto L_0x08eb
        L_0x07f4:
            r9 = 1
            r12 = 0
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzj(r0, r1, r8, r12)
            goto L_0x08eb
        L_0x0805:
            r9 = 1
            r12 = 0
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzi(r0, r1, r8, r12)
            goto L_0x08eb
        L_0x0816:
            r9 = 1
            r12 = 0
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzc(r0, r1, r8, r12)
            goto L_0x08eb
        L_0x0827:
            r9 = 1
            r12 = 0
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzm(r0, r1, r8, r12)
            goto L_0x08eb
        L_0x0838:
            r9 = 1
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zza((int) r0, (java.util.List<com.google.android.gms.internal.p002firebaseauthapi.zzahm>) r1, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8)
            goto L_0x05b9
        L_0x0848:
            r9 = 1
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.firebase-auth-api.zzalc r2 = r6.zze((int) r4)
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzb((int) r0, (java.util.List<?>) r1, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8, (com.google.android.gms.internal.p002firebaseauthapi.zzalc) r2)
            goto L_0x05b9
        L_0x085c:
            r9 = 1
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzb((int) r0, (java.util.List<java.lang.String>) r1, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8)
            goto L_0x05b9
        L_0x086c:
            r9 = 1
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            r12 = 0
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zza((int) r0, (java.util.List<java.lang.Boolean>) r1, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8, (boolean) r12)
            goto L_0x08eb
        L_0x087c:
            r9 = 1
            r12 = 0
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzd(r0, r1, r8, r12)
            goto L_0x08eb
        L_0x088c:
            r9 = 1
            r12 = 0
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zze(r0, r1, r8, r12)
            goto L_0x08eb
        L_0x089c:
            r9 = 1
            r12 = 0
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzg(r0, r1, r8, r12)
            goto L_0x08eb
        L_0x08ac:
            r9 = 1
            r12 = 0
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzn(r0, r1, r8, r12)
            goto L_0x08eb
        L_0x08bc:
            r9 = 1
            r12 = 0
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzh(r0, r1, r8, r12)
            goto L_0x08eb
        L_0x08cc:
            r9 = 1
            r12 = 0
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzf(r0, r1, r8, r12)
            goto L_0x08eb
        L_0x08dc:
            r9 = 1
            r12 = 0
            int[] r0 = r6.zzc
            r0 = r0[r4]
            java.lang.Object r1 = r5.getObject(r7, r2)
            java.util.List r1 = (java.util.List) r1
            com.google.android.gms.internal.p002firebaseauthapi.zzale.zzb((int) r0, (java.util.List<java.lang.Double>) r1, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8, (boolean) r12)
        L_0x08eb:
            r22 = r10
            r20 = r11
            r16 = r12
            r21 = r15
            goto L_0x05c1
        L_0x08f5:
            r9 = 1
            r16 = 0
            r0 = r23
            r1 = r24
            r8 = r2
            r2 = r4
            r3 = r10
            r20 = r11
            r11 = r4
            r4 = r13
            r21 = r15
            r15 = r5
            r5 = r14
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x091b
            java.lang.Object r0 = r15.getObject(r7, r8)
            com.google.android.gms.internal.firebase-auth-api.zzalc r1 = r6.zze((int) r11)
            r8 = r25
            r8.zza((int) r12, (java.lang.Object) r0, (com.google.android.gms.internal.p002firebaseauthapi.zzalc) r1)
            goto L_0x091d
        L_0x091b:
            r8 = r25
        L_0x091d:
            r22 = r10
            goto L_0x0b76
        L_0x0921:
            r20 = r11
            r21 = r15
            r16 = 0
            r11 = r4
            r15 = r5
            r4 = r2
            r0 = r23
            r1 = r24
            r2 = r11
            r3 = r10
            r22 = r10
            r9 = r4
            r4 = r13
            r5 = r14
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x0b76
            long r0 = r15.getLong(r7, r9)
            r8.zzd((int) r12, (long) r0)
            goto L_0x0b76
        L_0x0944:
            r22 = r10
            r20 = r11
            r21 = r15
            r16 = 0
            r9 = r2
            r11 = r4
            r15 = r5
            r0 = r23
            r1 = r24
            r2 = r11
            r3 = r22
            r4 = r13
            r5 = r14
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x0b76
            int r0 = r15.getInt(r7, r9)
            r8.zze((int) r12, (int) r0)
            goto L_0x0b76
        L_0x0967:
            r22 = r10
            r20 = r11
            r21 = r15
            r16 = 0
            r9 = r2
            r11 = r4
            r15 = r5
            r0 = r23
            r1 = r24
            r2 = r11
            r3 = r22
            r4 = r13
            r5 = r14
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x0b76
            long r0 = r15.getLong(r7, r9)
            r8.zzc((int) r12, (long) r0)
            goto L_0x0b76
        L_0x098a:
            r22 = r10
            r20 = r11
            r21 = r15
            r16 = 0
            r9 = r2
            r11 = r4
            r15 = r5
            r0 = r23
            r1 = r24
            r2 = r11
            r3 = r22
            r4 = r13
            r5 = r14
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x0b76
            int r0 = r15.getInt(r7, r9)
            r8.zzd((int) r12, (int) r0)
            goto L_0x0b76
        L_0x09ad:
            r22 = r10
            r20 = r11
            r21 = r15
            r16 = 0
            r9 = r2
            r11 = r4
            r15 = r5
            r0 = r23
            r1 = r24
            r2 = r11
            r3 = r22
            r4 = r13
            r5 = r14
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x0b76
            int r0 = r15.getInt(r7, r9)
            r8.zza((int) r12, (int) r0)
            goto L_0x0b76
        L_0x09d0:
            r22 = r10
            r20 = r11
            r21 = r15
            r16 = 0
            r9 = r2
            r11 = r4
            r15 = r5
            r0 = r23
            r1 = r24
            r2 = r11
            r3 = r22
            r4 = r13
            r5 = r14
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x0b76
            int r0 = r15.getInt(r7, r9)
            r8.zzf(r12, r0)
            goto L_0x0b76
        L_0x09f3:
            r22 = r10
            r20 = r11
            r21 = r15
            r16 = 0
            r9 = r2
            r11 = r4
            r15 = r5
            r0 = r23
            r1 = r24
            r2 = r11
            r3 = r22
            r4 = r13
            r5 = r14
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x0b76
            java.lang.Object r0 = r15.getObject(r7, r9)
            com.google.android.gms.internal.firebase-auth-api.zzahm r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzahm) r0
            r8.zza((int) r12, (com.google.android.gms.internal.p002firebaseauthapi.zzahm) r0)
            goto L_0x0b76
        L_0x0a18:
            r22 = r10
            r20 = r11
            r21 = r15
            r16 = 0
            r9 = r2
            r11 = r4
            r15 = r5
            r0 = r23
            r1 = r24
            r2 = r11
            r3 = r22
            r4 = r13
            r5 = r14
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x0b76
            java.lang.Object r0 = r15.getObject(r7, r9)
            com.google.android.gms.internal.firebase-auth-api.zzalc r1 = r6.zze((int) r11)
            r8.zzb((int) r12, (java.lang.Object) r0, (com.google.android.gms.internal.p002firebaseauthapi.zzalc) r1)
            goto L_0x0b76
        L_0x0a3f:
            r22 = r10
            r20 = r11
            r21 = r15
            r16 = 0
            r9 = r2
            r11 = r4
            r15 = r5
            r0 = r23
            r1 = r24
            r2 = r11
            r3 = r22
            r4 = r13
            r5 = r14
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x0b76
            java.lang.Object r0 = r15.getObject(r7, r9)
            zza((int) r12, (java.lang.Object) r0, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8)
            goto L_0x0b76
        L_0x0a62:
            r22 = r10
            r20 = r11
            r21 = r15
            r16 = 0
            r9 = r2
            r11 = r4
            r15 = r5
            r0 = r23
            r1 = r24
            r2 = r11
            r3 = r22
            r4 = r13
            r5 = r14
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x0b76
            boolean r0 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzh(r7, r9)
            r8.zza((int) r12, (boolean) r0)
            goto L_0x0b76
        L_0x0a85:
            r22 = r10
            r20 = r11
            r21 = r15
            r16 = 0
            r9 = r2
            r11 = r4
            r15 = r5
            r0 = r23
            r1 = r24
            r2 = r11
            r3 = r22
            r4 = r13
            r5 = r14
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x0b76
            int r0 = r15.getInt(r7, r9)
            r8.zzb((int) r12, (int) r0)
            goto L_0x0b76
        L_0x0aa8:
            r22 = r10
            r20 = r11
            r21 = r15
            r16 = 0
            r9 = r2
            r11 = r4
            r15 = r5
            r0 = r23
            r1 = r24
            r2 = r11
            r3 = r22
            r4 = r13
            r5 = r14
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x0b76
            long r0 = r15.getLong(r7, r9)
            r8.zza((int) r12, (long) r0)
            goto L_0x0b76
        L_0x0acb:
            r22 = r10
            r20 = r11
            r21 = r15
            r16 = 0
            r9 = r2
            r11 = r4
            r15 = r5
            r0 = r23
            r1 = r24
            r2 = r11
            r3 = r22
            r4 = r13
            r5 = r14
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x0b76
            int r0 = r15.getInt(r7, r9)
            r8.zzc((int) r12, (int) r0)
            goto L_0x0b76
        L_0x0aee:
            r22 = r10
            r20 = r11
            r21 = r15
            r16 = 0
            r9 = r2
            r11 = r4
            r15 = r5
            r0 = r23
            r1 = r24
            r2 = r11
            r3 = r22
            r4 = r13
            r5 = r14
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x0b76
            long r0 = r15.getLong(r7, r9)
            r8.zze((int) r12, (long) r0)
            goto L_0x0b76
        L_0x0b11:
            r22 = r10
            r20 = r11
            r21 = r15
            r16 = 0
            r9 = r2
            r11 = r4
            r15 = r5
            r0 = r23
            r1 = r24
            r2 = r11
            r3 = r22
            r4 = r13
            r5 = r14
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x0b76
            long r0 = r15.getLong(r7, r9)
            r8.zzb((int) r12, (long) r0)
            goto L_0x0b76
        L_0x0b33:
            r22 = r10
            r20 = r11
            r21 = r15
            r16 = 0
            r9 = r2
            r11 = r4
            r15 = r5
            r0 = r23
            r1 = r24
            r2 = r11
            r3 = r22
            r4 = r13
            r5 = r14
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x0b76
            float r0 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzb(r7, r9)
            r8.zza((int) r12, (float) r0)
            goto L_0x0b76
        L_0x0b55:
            r22 = r10
            r20 = r11
            r21 = r15
            r16 = 0
            r9 = r2
            r11 = r4
            r15 = r5
            r0 = r23
            r1 = r24
            r2 = r11
            r3 = r22
            r4 = r13
            r5 = r14
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x0b76
            double r0 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r7, (long) r9)
            r8.zza((int) r12, (double) r0)
        L_0x0b76:
            int r4 = r11 + 3
            r2 = r13
            r5 = r15
            r12 = r16
            r13 = r18
            r14 = r19
            r1 = r20
            r15 = r21
            r0 = r22
            r9 = 267386880(0xff00000, float:2.3665827E-29)
            r11 = 1
            goto L_0x0555
        L_0x0b8b:
            r19 = r14
        L_0x0b8d:
            if (r1 == 0) goto L_0x0ba4
            com.google.android.gms.internal.firebase-auth-api.zzair<?> r0 = r6.zzr
            r0.zza(r8, r1)
            boolean r0 = r19.hasNext()
            if (r0 == 0) goto L_0x0ba2
            java.lang.Object r0 = r19.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            r1 = r0
            goto L_0x0b8d
        L_0x0ba2:
            r1 = 0
            goto L_0x0b8d
        L_0x0ba4:
            com.google.android.gms.internal.firebase-auth-api.zzamb<?, ?> r0 = r6.zzq
            zza(r0, r7, (com.google.android.gms.internal.p002firebaseauthapi.zzanb) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzako.zza(java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzanb):void");
    }

    private static <UT, UB> void zza(zzamb<UT, UB> zzamb, T t, zzanb zzanb) throws IOException {
        zzamb.zzb(zzamb.zzd(t), zzanb);
    }

    private final boolean zzc(T t, T t2, int i) {
        return zzc(t, i) == zzc(t2, i);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzale.zza(com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r10, r6), com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzale.zza(com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r10, r6), com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzale.zza(com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r10, r6), com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzale.zza(com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r10, r6), com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzh(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzh(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r10, r6) == com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzb(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzb(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c1, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.p002firebaseauthapi.zzale.zza(com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r10, r6), com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzc
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.zzc((int) r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x01a7;
                case 1: goto L_0x018e;
                case 2: goto L_0x017b;
                case 3: goto L_0x0168;
                case 4: goto L_0x0157;
                case 5: goto L_0x0144;
                case 6: goto L_0x0132;
                case 7: goto L_0x0120;
                case 8: goto L_0x010a;
                case 9: goto L_0x00f4;
                case 10: goto L_0x00de;
                case 11: goto L_0x00cc;
                case 12: goto L_0x00ba;
                case 13: goto L_0x00a8;
                case 14: goto L_0x0094;
                case 15: goto L_0x0082;
                case 16: goto L_0x006e;
                case 17: goto L_0x0058;
                case 18: goto L_0x004a;
                case 19: goto L_0x004a;
                case 20: goto L_0x004a;
                case 21: goto L_0x004a;
                case 22: goto L_0x004a;
                case 23: goto L_0x004a;
                case 24: goto L_0x004a;
                case 25: goto L_0x004a;
                case 26: goto L_0x004a;
                case 27: goto L_0x004a;
                case 28: goto L_0x004a;
                case 29: goto L_0x004a;
                case 30: goto L_0x004a;
                case 31: goto L_0x004a;
                case 32: goto L_0x004a;
                case 33: goto L_0x004a;
                case 34: goto L_0x004a;
                case 35: goto L_0x004a;
                case 36: goto L_0x004a;
                case 37: goto L_0x004a;
                case 38: goto L_0x004a;
                case 39: goto L_0x004a;
                case 40: goto L_0x004a;
                case 41: goto L_0x004a;
                case 42: goto L_0x004a;
                case 43: goto L_0x004a;
                case 44: goto L_0x004a;
                case 45: goto L_0x004a;
                case 46: goto L_0x004a;
                case 47: goto L_0x004a;
                case 48: goto L_0x004a;
                case 49: goto L_0x004a;
                case 50: goto L_0x003c;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01c2
        L_0x001c:
            int r4 = r9.zzb((int) r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r10, r4)
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r11, r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r11, r6)
            boolean r4 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r11, r6)
            boolean r3 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zza((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r11, r6)
            boolean r3 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zza((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r11, r6)
            boolean r4 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r10, r6)
            long r6 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r10, r6)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r10, r6)
            long r6 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r10, r6)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r10, r6)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r10, r6)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r11, r6)
            boolean r4 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r11, r6)
            boolean r4 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zze(r11, r6)
            boolean r4 = com.google.android.gms.internal.p002firebaseauthapi.zzale.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzh(r10, r6)
            boolean r5 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzh(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r10, r6)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r10, r6)
            long r6 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r10, r6)
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzc(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r10, r6)
            long r6 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r10, r6)
            long r6 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzd(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzb(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zzb(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzc(r10, r11, (int) r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r10, (long) r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.p002firebaseauthapi.zzamh.zza((java.lang.Object) r11, (long) r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
        L_0x01c1:
            r3 = r1
        L_0x01c2:
            if (r3 != 0) goto L_0x01c5
            return r1
        L_0x01c5:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01c9:
            com.google.android.gms.internal.firebase-auth-api.zzamb<?, ?> r0 = r9.zzq
            java.lang.Object r0 = r0.zzd(r10)
            com.google.android.gms.internal.firebase-auth-api.zzamb<?, ?> r2 = r9.zzq
            java.lang.Object r2 = r2.zzd(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zzh
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.firebase-auth-api.zzair<?> r0 = r9.zzr
            com.google.android.gms.internal.firebase-auth-api.zzais r10 = r0.zza((java.lang.Object) r10)
            com.google.android.gms.internal.firebase-auth-api.zzair<?> r0 = r9.zzr
            com.google.android.gms.internal.firebase-auth-api.zzais r11 = r0.zza((java.lang.Object) r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzako.zzb(java.lang.Object, java.lang.Object):boolean");
    }

    private final boolean zzc(T t, int i) {
        int zzb2 = zzb(i);
        long j = (long) (zzb2 & 1048575);
        if (j == 1048575) {
            int zzc2 = zzc(i);
            long j2 = (long) (zzc2 & 1048575);
            switch ((zzc2 & 267386880) >>> 20) {
                case 0:
                    return Double.doubleToRawLongBits(zzamh.zza((Object) t, j2)) != 0;
                case 1:
                    return Float.floatToRawIntBits(zzamh.zzb(t, j2)) != 0;
                case 2:
                    return zzamh.zzd(t, j2) != 0;
                case 3:
                    return zzamh.zzd(t, j2) != 0;
                case 4:
                    return zzamh.zzc(t, j2) != 0;
                case 5:
                    return zzamh.zzd(t, j2) != 0;
                case 6:
                    return zzamh.zzc(t, j2) != 0;
                case 7:
                    return zzamh.zzh(t, j2);
                case 8:
                    Object zze2 = zzamh.zze(t, j2);
                    if (zze2 instanceof String) {
                        return !((String) zze2).isEmpty();
                    }
                    if (zze2 instanceof zzahm) {
                        return !zzahm.zza.equals(zze2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzamh.zze(t, j2) != null;
                case 10:
                    return !zzahm.zza.equals(zzamh.zze(t, j2));
                case 11:
                    return zzamh.zzc(t, j2) != 0;
                case 12:
                    return zzamh.zzc(t, j2) != 0;
                case 13:
                    return zzamh.zzc(t, j2) != 0;
                case 14:
                    return zzamh.zzd(t, j2) != 0;
                case 15:
                    return zzamh.zzc(t, j2) != 0;
                case 16:
                    return zzamh.zzd(t, j2) != 0;
                case 17:
                    return zzamh.zze(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zzamh.zzc(t, j) & (1 << (zzb2 >>> 20))) != 0;
        }
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzc(t, i);
        }
        return (i3 & i4) != 0;
    }

    public final boolean zzd(T t) {
        int i;
        int i2;
        T t2 = t;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i5 >= this.zzm) {
                return !this.zzh || this.zzr.zza((Object) t2).zzg();
            }
            int i6 = this.zzl[i5];
            int i7 = this.zzc[i6];
            int zzc2 = zzc(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(t2, (long) i9);
                }
                i = i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if (((268435456 & zzc2) != 0) && !zza(t, i6, i2, i, i10)) {
                return false;
            }
            int i11 = (267386880 & zzc2) >>> 20;
            if (i11 != 9 && i11 != 17) {
                if (i11 != 27) {
                    if (i11 == 60 || i11 == 68) {
                        if (zzc(t2, i7, i6) && !zza((Object) t2, zzc2, zze(i6))) {
                            return false;
                        }
                    } else if (i11 != 49) {
                        if (i11 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzd2 = this.zzs.zzd(zzamh.zze(t2, (long) (zzc2 & 1048575)));
                            if (!zzd2.isEmpty()) {
                                if (this.zzs.zza(zzf(i6)).zzc.zzb() == zzamy.MESSAGE) {
                                    zzalc<?> zzalc = null;
                                    Iterator<?> it = zzd2.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzalc == null) {
                                            zzalc = zzaky.zza().zza(next.getClass());
                                        }
                                        if (!zzalc.zzd(next)) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzamh.zze(t2, (long) (zzc2 & 1048575));
                if (!list.isEmpty()) {
                    zzalc zze2 = zze(i6);
                    int i12 = 0;
                    while (true) {
                        if (i12 >= list.size()) {
                            break;
                        } else if (!zze2.zzd(list.get(i12))) {
                            z = false;
                            break;
                        } else {
                            i12++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza(t, i6, i2, i, i10) && !zza((Object) t2, zzc2, zze(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
    }

    private static boolean zza(Object obj, int i, zzalc zzalc) {
        return zzalc.zzd(zzamh.zze(obj, (long) (i & 1048575)));
    }

    private static boolean zzg(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzaja) {
            return ((zzaja) obj).zzv();
        }
        return true;
    }

    private final boolean zzc(T t, int i, int i2) {
        return zzamh.zzc(t, (long) (zzb(i2) & 1048575)) == i;
    }

    private static <T> boolean zze(T t, long j) {
        return ((Boolean) zzamh.zze(t, j)).booleanValue();
    }
}
