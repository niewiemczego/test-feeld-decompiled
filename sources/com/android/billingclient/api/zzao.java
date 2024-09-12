package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zziz;
import com.google.android.gms.internal.play_billing.zzl;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzao implements ServiceConnection {
    final /* synthetic */ BillingClientImpl zza;
    private final Object zzb = new Object();
    private boolean zzc = false;
    private BillingClientStateListener zzd;

    /* synthetic */ zzao(BillingClientImpl billingClientImpl, BillingClientStateListener billingClientStateListener, zzan zzan) {
        this.zza = billingClientImpl;
        this.zzd = billingClientStateListener;
    }

    private final void zzd(BillingResult billingResult) {
        synchronized (this.zzb) {
            BillingClientStateListener billingClientStateListener = this.zzd;
            if (billingClientStateListener != null) {
                billingClientStateListener.onBillingSetupFinished(billingResult);
            }
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzb.zzj("BillingClient", "Billing service connected.");
        this.zza.zzg = zzl.zzr(iBinder);
        zzal zzal = new zzal(this);
        zzam zzam = new zzam(this);
        BillingClientImpl billingClientImpl = this.zza;
        if (billingClientImpl.zzac(zzal, 30000, zzam, billingClientImpl.zzY()) == null) {
            BillingClientImpl billingClientImpl2 = this.zza;
            BillingResult zzi = billingClientImpl2.zzaa();
            billingClientImpl2.zzf.zza(zzbh.zza(25, 6, zzi));
            zzd(zzi);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        zzb.zzk("BillingClient", "Billing service disconnected.");
        this.zza.zzf.zzc(zziz.zzw());
        this.zza.zzg = null;
        this.zza.zza = 0;
        synchronized (this.zzb) {
            BillingClientStateListener billingClientStateListener = this.zzd;
            if (billingClientStateListener != null) {
                billingClientStateListener.onBillingServiceDisconnected();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0207  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object zza() throws java.lang.Exception {
        /*
            r14 = this;
            java.lang.Object r0 = r14.zzb
            monitor-enter(r0)
            boolean r1 = r14.zzc     // Catch:{ all -> 0x021c }
            r2 = 0
            if (r1 == 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x021c }
            goto L_0x021b
        L_0x000b:
            monitor-exit(r0)     // Catch:{ all -> 0x021c }
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L_0x001d
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = "accountName"
            r0.putString(r1, r2)
            goto L_0x001e
        L_0x001d:
            r0 = r2
        L_0x001e:
            r1 = 6
            r3 = 3
            r4 = 0
            com.android.billingclient.api.BillingClientImpl r5 = r14.zza     // Catch:{ Exception -> 0x01dd }
            android.content.Context r5 = r5.zze     // Catch:{ Exception -> 0x01dd }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ Exception -> 0x01dd }
            r6 = 21
            r8 = r3
            r7 = r6
        L_0x002f:
            if (r7 < r3) goto L_0x0068
            if (r0 != 0) goto L_0x0040
            com.android.billingclient.api.BillingClientImpl r9 = r14.zza     // Catch:{ Exception -> 0x01da }
            com.google.android.gms.internal.play_billing.zzm r9 = r9.zzg     // Catch:{ Exception -> 0x01da }
            java.lang.String r10 = "subs"
            int r8 = r9.zzv(r7, r5, r10)     // Catch:{ Exception -> 0x01da }
            goto L_0x004c
        L_0x0040:
            com.android.billingclient.api.BillingClientImpl r9 = r14.zza     // Catch:{ Exception -> 0x01da }
            com.google.android.gms.internal.play_billing.zzm r9 = r9.zzg     // Catch:{ Exception -> 0x01da }
            java.lang.String r10 = "subs"
            int r8 = r9.zzc(r7, r5, r10, r0)     // Catch:{ Exception -> 0x01da }
        L_0x004c:
            if (r8 != 0) goto L_0x0065
            java.lang.String r9 = "BillingClient"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01da }
            r10.<init>()     // Catch:{ Exception -> 0x01da }
            java.lang.String r11 = "highestLevelSupportedForSubs: "
            r10.append(r11)     // Catch:{ Exception -> 0x01da }
            r10.append(r7)     // Catch:{ Exception -> 0x01da }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x01da }
            com.google.android.gms.internal.play_billing.zzb.zzj(r9, r10)     // Catch:{ Exception -> 0x01da }
            goto L_0x0069
        L_0x0065:
            int r7 = r7 + -1
            goto L_0x002f
        L_0x0068:
            r7 = r4
        L_0x0069:
            com.android.billingclient.api.BillingClientImpl r9 = r14.zza     // Catch:{ Exception -> 0x01da }
            r10 = 5
            r11 = 1
            if (r7 < r10) goto L_0x0071
            r10 = r11
            goto L_0x0072
        L_0x0071:
            r10 = r4
        L_0x0072:
            r9.zzj = r10     // Catch:{ Exception -> 0x01da }
            com.android.billingclient.api.BillingClientImpl r9 = r14.zza     // Catch:{ Exception -> 0x01da }
            if (r7 < r3) goto L_0x007b
            r10 = r11
            goto L_0x007c
        L_0x007b:
            r10 = r4
        L_0x007c:
            r9.zzi = r10     // Catch:{ Exception -> 0x01da }
            r9 = 9
            if (r7 >= r3) goto L_0x008c
            java.lang.String r7 = "BillingClient"
            java.lang.String r10 = "In-app billing API does not support subscription on this device."
            com.google.android.gms.internal.play_billing.zzb.zzj(r7, r10)     // Catch:{ Exception -> 0x01da }
            r7 = r9
            goto L_0x008d
        L_0x008c:
            r7 = r11
        L_0x008d:
            r10 = r6
        L_0x008e:
            if (r10 < r3) goto L_0x00d2
            if (r0 != 0) goto L_0x009f
            com.android.billingclient.api.BillingClientImpl r12 = r14.zza     // Catch:{ Exception -> 0x01da }
            com.google.android.gms.internal.play_billing.zzm r12 = r12.zzg     // Catch:{ Exception -> 0x01da }
            java.lang.String r13 = "inapp"
            int r8 = r12.zzv(r10, r5, r13)     // Catch:{ Exception -> 0x01da }
            goto L_0x00ab
        L_0x009f:
            com.android.billingclient.api.BillingClientImpl r12 = r14.zza     // Catch:{ Exception -> 0x01da }
            com.google.android.gms.internal.play_billing.zzm r12 = r12.zzg     // Catch:{ Exception -> 0x01da }
            java.lang.String r13 = "inapp"
            int r8 = r12.zzc(r10, r5, r13, r0)     // Catch:{ Exception -> 0x01da }
        L_0x00ab:
            if (r8 != 0) goto L_0x00cf
            com.android.billingclient.api.BillingClientImpl r0 = r14.zza     // Catch:{ Exception -> 0x01da }
            r0.zzk = r10     // Catch:{ Exception -> 0x01da }
            java.lang.String r0 = "BillingClient"
            com.android.billingclient.api.BillingClientImpl r5 = r14.zza     // Catch:{ Exception -> 0x01da }
            int r5 = r5.zzk     // Catch:{ Exception -> 0x01da }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01da }
            r10.<init>()     // Catch:{ Exception -> 0x01da }
            java.lang.String r12 = "mHighestLevelSupportedForInApp: "
            r10.append(r12)     // Catch:{ Exception -> 0x01da }
            r10.append(r5)     // Catch:{ Exception -> 0x01da }
            java.lang.String r5 = r10.toString()     // Catch:{ Exception -> 0x01da }
            com.google.android.gms.internal.play_billing.zzb.zzj(r0, r5)     // Catch:{ Exception -> 0x01da }
            goto L_0x00d2
        L_0x00cf:
            int r10 = r10 + -1
            goto L_0x008e
        L_0x00d2:
            com.android.billingclient.api.BillingClientImpl r0 = r14.zza     // Catch:{ Exception -> 0x01da }
            int r5 = r0.zzk     // Catch:{ Exception -> 0x01da }
            if (r5 < r6) goto L_0x00dc
            r5 = r11
            goto L_0x00dd
        L_0x00dc:
            r5 = r4
        L_0x00dd:
            r0.zzx = r5     // Catch:{ Exception -> 0x01da }
            com.android.billingclient.api.BillingClientImpl r0 = r14.zza     // Catch:{ Exception -> 0x01da }
            int r5 = r0.zzk     // Catch:{ Exception -> 0x01da }
            r6 = 20
            if (r5 < r6) goto L_0x00ec
            r5 = r11
            goto L_0x00ed
        L_0x00ec:
            r5 = r4
        L_0x00ed:
            r0.zzw = r5     // Catch:{ Exception -> 0x01da }
            com.android.billingclient.api.BillingClientImpl r0 = r14.zza     // Catch:{ Exception -> 0x01da }
            int r5 = r0.zzk     // Catch:{ Exception -> 0x01da }
            r6 = 19
            if (r5 < r6) goto L_0x00fc
            r5 = r11
            goto L_0x00fd
        L_0x00fc:
            r5 = r4
        L_0x00fd:
            r0.zzv = r5     // Catch:{ Exception -> 0x01da }
            com.android.billingclient.api.BillingClientImpl r0 = r14.zza     // Catch:{ Exception -> 0x01da }
            int r5 = r0.zzk     // Catch:{ Exception -> 0x01da }
            r6 = 18
            if (r5 < r6) goto L_0x010c
            r5 = r11
            goto L_0x010d
        L_0x010c:
            r5 = r4
        L_0x010d:
            r0.zzu = r5     // Catch:{ Exception -> 0x01da }
            com.android.billingclient.api.BillingClientImpl r0 = r14.zza     // Catch:{ Exception -> 0x01da }
            int r5 = r0.zzk     // Catch:{ Exception -> 0x01da }
            r6 = 17
            if (r5 < r6) goto L_0x011c
            r5 = r11
            goto L_0x011d
        L_0x011c:
            r5 = r4
        L_0x011d:
            r0.zzt = r5     // Catch:{ Exception -> 0x01da }
            com.android.billingclient.api.BillingClientImpl r0 = r14.zza     // Catch:{ Exception -> 0x01da }
            int r5 = r0.zzk     // Catch:{ Exception -> 0x01da }
            r6 = 16
            if (r5 < r6) goto L_0x012c
            r5 = r11
            goto L_0x012d
        L_0x012c:
            r5 = r4
        L_0x012d:
            r0.zzs = r5     // Catch:{ Exception -> 0x01da }
            com.android.billingclient.api.BillingClientImpl r0 = r14.zza     // Catch:{ Exception -> 0x01da }
            int r5 = r0.zzk     // Catch:{ Exception -> 0x01da }
            r6 = 15
            if (r5 < r6) goto L_0x013c
            r5 = r11
            goto L_0x013d
        L_0x013c:
            r5 = r4
        L_0x013d:
            r0.zzr = r5     // Catch:{ Exception -> 0x01da }
            com.android.billingclient.api.BillingClientImpl r0 = r14.zza     // Catch:{ Exception -> 0x01da }
            int r5 = r0.zzk     // Catch:{ Exception -> 0x01da }
            r6 = 14
            if (r5 < r6) goto L_0x014c
            r5 = r11
            goto L_0x014d
        L_0x014c:
            r5 = r4
        L_0x014d:
            r0.zzq = r5     // Catch:{ Exception -> 0x01da }
            com.android.billingclient.api.BillingClientImpl r0 = r14.zza     // Catch:{ Exception -> 0x01da }
            int r5 = r0.zzk     // Catch:{ Exception -> 0x01da }
            r6 = 12
            if (r5 < r6) goto L_0x015c
            r5 = r11
            goto L_0x015d
        L_0x015c:
            r5 = r4
        L_0x015d:
            r0.zzp = r5     // Catch:{ Exception -> 0x01da }
            com.android.billingclient.api.BillingClientImpl r0 = r14.zza     // Catch:{ Exception -> 0x01da }
            int r5 = r0.zzk     // Catch:{ Exception -> 0x01da }
            r6 = 10
            if (r5 < r6) goto L_0x016c
            r5 = r11
            goto L_0x016d
        L_0x016c:
            r5 = r4
        L_0x016d:
            r0.zzo = r5     // Catch:{ Exception -> 0x01da }
            com.android.billingclient.api.BillingClientImpl r0 = r14.zza     // Catch:{ Exception -> 0x01da }
            int r5 = r0.zzk     // Catch:{ Exception -> 0x01da }
            if (r5 < r9) goto L_0x017a
            r5 = r11
            goto L_0x017b
        L_0x017a:
            r5 = r4
        L_0x017b:
            r0.zzn = r5     // Catch:{ Exception -> 0x01da }
            com.android.billingclient.api.BillingClientImpl r0 = r14.zza     // Catch:{ Exception -> 0x01da }
            int r5 = r0.zzk     // Catch:{ Exception -> 0x01da }
            r6 = 8
            if (r5 < r6) goto L_0x018a
            r5 = r11
            goto L_0x018b
        L_0x018a:
            r5 = r4
        L_0x018b:
            r0.zzm = r5     // Catch:{ Exception -> 0x01da }
            com.android.billingclient.api.BillingClientImpl r0 = r14.zza     // Catch:{ Exception -> 0x01da }
            int r5 = r0.zzk     // Catch:{ Exception -> 0x01da }
            if (r5 < r1) goto L_0x0197
            goto L_0x0198
        L_0x0197:
            r11 = r4
        L_0x0198:
            r0.zzl = r11     // Catch:{ Exception -> 0x01da }
            com.android.billingclient.api.BillingClientImpl r0 = r14.zza     // Catch:{ Exception -> 0x01da }
            int r0 = r0.zzk     // Catch:{ Exception -> 0x01da }
            if (r0 >= r3) goto L_0x01ac
            java.lang.String r0 = "BillingClient"
            java.lang.String r3 = "In-app billing API version 3 is not supported on this device."
            com.google.android.gms.internal.play_billing.zzb.zzk(r0, r3)     // Catch:{ Exception -> 0x01da }
            r7 = 36
        L_0x01ac:
            if (r8 != 0) goto L_0x01cf
            com.android.billingclient.api.BillingClientImpl r0 = r14.zza     // Catch:{ Exception -> 0x01da }
            r3 = 2
            r0.zza = r3     // Catch:{ Exception -> 0x01da }
            com.android.billingclient.api.BillingClientImpl r0 = r14.zza     // Catch:{ Exception -> 0x01da }
            com.android.billingclient.api.zzh r0 = r0.zzd     // Catch:{ Exception -> 0x01da }
            if (r0 == 0) goto L_0x01f2
            com.android.billingclient.api.BillingClientImpl r0 = r14.zza     // Catch:{ Exception -> 0x01da }
            com.android.billingclient.api.zzh r0 = r0.zzd     // Catch:{ Exception -> 0x01da }
            com.android.billingclient.api.BillingClientImpl r3 = r14.zza     // Catch:{ Exception -> 0x01da }
            android.content.Context r3 = r3.zze     // Catch:{ Exception -> 0x01da }
            r3.getPackageName()     // Catch:{ Exception -> 0x01da }
            r0.zzf(r4)     // Catch:{ Exception -> 0x01da }
            goto L_0x01f2
        L_0x01cf:
            com.android.billingclient.api.BillingClientImpl r0 = r14.zza     // Catch:{ Exception -> 0x01da }
            r0.zza = r4     // Catch:{ Exception -> 0x01da }
            com.android.billingclient.api.BillingClientImpl r0 = r14.zza     // Catch:{ Exception -> 0x01da }
            r0.zzg = r2     // Catch:{ Exception -> 0x01da }
            goto L_0x01f2
        L_0x01da:
            r0 = move-exception
            r3 = r8
            goto L_0x01de
        L_0x01dd:
            r0 = move-exception
        L_0x01de:
            java.lang.String r5 = "BillingClient"
            java.lang.String r6 = "Exception while checking if billing is supported; try to reconnect"
            com.google.android.gms.internal.play_billing.zzb.zzl(r5, r6, r0)
            com.android.billingclient.api.BillingClientImpl r0 = r14.zza
            r0.zza = r4
            com.android.billingclient.api.BillingClientImpl r0 = r14.zza
            r0.zzg = r2
            r7 = 42
            r8 = r3
        L_0x01f2:
            if (r8 != 0) goto L_0x0207
            com.android.billingclient.api.BillingClientImpl r0 = r14.zza
            com.android.billingclient.api.zzbi r0 = r0.zzf
            com.google.android.gms.internal.play_billing.zzic r1 = com.android.billingclient.api.zzbh.zzb(r1)
            r0.zzb(r1)
            com.android.billingclient.api.BillingResult r0 = com.android.billingclient.api.zzbk.zzl
            r14.zzd(r0)
            goto L_0x021b
        L_0x0207:
            com.android.billingclient.api.BillingClientImpl r0 = r14.zza
            com.android.billingclient.api.zzbi r0 = r0.zzf
            com.android.billingclient.api.BillingResult r3 = com.android.billingclient.api.zzbk.zza
            com.google.android.gms.internal.play_billing.zzhy r1 = com.android.billingclient.api.zzbh.zza(r7, r1, r3)
            r0.zza(r1)
            com.android.billingclient.api.BillingResult r0 = com.android.billingclient.api.zzbk.zza
            r14.zzd(r0)
        L_0x021b:
            return r2
        L_0x021c:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x021c }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.zzao.zza():java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb() {
        this.zza.zza = 0;
        this.zza.zzg = null;
        this.zza.zzf.zza(zzbh.zza(24, 6, zzbk.zzn));
        zzd(zzbk.zzn);
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        synchronized (this.zzb) {
            this.zzd = null;
            this.zzc = true;
        }
    }
}
