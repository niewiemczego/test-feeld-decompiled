package com.google.android.recaptcha.internal;

import android.content.Context;
import android.webkit.WebView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutCancellationException;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzez implements zza {
    public static final zzep zza = new zzep((DefaultConstructorMarker) null);
    public CompletableDeferred zzb;
    public zzbu zzc;
    private final WebView zzd;
    private final String zze;
    private final Context zzf;
    private final zzab zzg;
    private final zzbd zzh;
    /* access modifiers changed from: private */
    public final zzbg zzi;
    private final zzbq zzj;
    /* access modifiers changed from: private */
    public final Map zzk = zzfa.zza();
    /* access modifiers changed from: private */
    public final Map zzl;
    private final Map zzm;
    /* access modifiers changed from: private */
    public final zzfh zzn;
    private final zzeq zzo;
    /* access modifiers changed from: private */
    public final zzbd zzp;
    /* access modifiers changed from: private */
    public final zzt zzq;

    public zzez(WebView webView, String str, Context context, zzab zzab, zzbd zzbd, zzt zzt, zzbg zzbg, zzbq zzbq) {
        this.zzd = webView;
        this.zze = str;
        this.zzf = context;
        this.zzg = zzab;
        this.zzh = zzbd;
        this.zzq = zzt;
        this.zzi = zzbg;
        this.zzj = zzbq;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzl = linkedHashMap;
        this.zzm = linkedHashMap;
        this.zzn = zzfh.zzc();
        zzeq zzeq = new zzeq(this);
        this.zzo = zzeq;
        zzbd zzb2 = zzbd.zzb();
        zzb2.zzc(zzbd.zzd());
        this.zzp = zzb2;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(zzeq, "RN");
        webView.setWebViewClient(new zzeu(this));
    }

    public static final /* synthetic */ void zzl(zzez zzez, zzoe zzoe) {
        zzez.zzd.clearCache(true);
        zzbb zza2 = zzez.zzp.zza(zzne.INIT_NETWORK);
        zzez.zzi.zze.put(zza2, new zzbf(zza2, zzez.zzi.zza, new zzac()));
        Job unused = BuildersKt__Builders_commonKt.launch$default(zzez.zzq.zza(), (CoroutineContext) null, (CoroutineStart) null, new zzey(zzez, zzoe, zza2, (Continuation) null), 3, (Object) null);
    }

    public static final /* synthetic */ void zzm(zzez zzez, String str) {
        zzbb zza2 = zzez.zzp.zza(zzne.LOAD_WEBVIEW);
        try {
            zzez.zzi.zze.put(zza2, new zzbf(zza2, zzez.zzi.zza, new zzac()));
            zzez.zzd.loadDataWithBaseURL(zzez.zzg.zza(), str, "text/html", "utf-8", (String) null);
        } catch (Exception unused) {
            zzp zzp2 = new zzp(zzn.zzc, zzl.zzag, (String) null);
            zzez.zzi.zzb(zza2, zzp2, (String) null);
            zzez.zzk().completeExceptionally(zzp2);
        }
    }

    private final zzp zzp(Exception exc, zzp zzp2) {
        if (exc instanceof TimeoutCancellationException) {
            return new zzp(zzn.zzc, zzl.zzj, (String) null);
        }
        return exc instanceof zzp ? (zzp) exc : zzp2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zza(java.lang.String r5, long r6, kotlin.coroutines.Continuation r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.google.android.recaptcha.internal.zzer
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.google.android.recaptcha.internal.zzer r0 = (com.google.android.recaptcha.internal.zzer) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzc = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzer r0 = new com.google.android.recaptcha.internal.zzer
            r0.<init>(r4, r8)
        L_0x0018:
            java.lang.Object r8 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.String r5 = r0.zze
            com.google.android.recaptcha.internal.zzez r6 = r0.zzd
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ Exception -> 0x002d }
            goto L_0x004e
        L_0x002d:
            r7 = move-exception
            goto L_0x005a
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r8)
            com.google.android.recaptcha.internal.zzet r8 = new com.google.android.recaptcha.internal.zzet     // Catch:{ Exception -> 0x0057 }
            r2 = 0
            r8.<init>(r5, r4, r2)     // Catch:{ Exception -> 0x0057 }
            r0.zzd = r4     // Catch:{ Exception -> 0x0057 }
            r0.zze = r5     // Catch:{ Exception -> 0x0057 }
            r0.zzc = r3     // Catch:{ Exception -> 0x0057 }
            java.lang.Object r8 = kotlinx.coroutines.TimeoutKt.withTimeout(r6, r8, r0)     // Catch:{ Exception -> 0x0057 }
            if (r8 != r1) goto L_0x004d
            return r1
        L_0x004d:
            r6 = r4
        L_0x004e:
            com.google.android.recaptcha.internal.zzog r8 = (com.google.android.recaptcha.internal.zzog) r8     // Catch:{ Exception -> 0x002d }
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ Exception -> 0x002d }
            java.lang.Object r5 = kotlin.Result.m983constructorimpl(r8)     // Catch:{ Exception -> 0x002d }
            goto L_0x008a
        L_0x0057:
            r6 = move-exception
            r7 = r6
            r6 = r4
        L_0x005a:
            java.lang.Class r8 = r7.getClass()
            com.google.android.recaptcha.internal.zzp r0 = new com.google.android.recaptcha.internal.zzp
            com.google.android.recaptcha.internal.zzn r1 = com.google.android.recaptcha.internal.zzn.zzc
            com.google.android.recaptcha.internal.zzl r2 = com.google.android.recaptcha.internal.zzl.zzai
            java.lang.String r8 = r8.getSimpleName()
            r0.<init>(r1, r2, r8)
            com.google.android.recaptcha.internal.zzp r7 = r6.zzp(r7, r0)
            java.util.Map r6 = r6.zzl
            java.lang.Object r5 = r6.remove(r5)
            kotlinx.coroutines.CompletableDeferred r5 = (kotlinx.coroutines.CompletableDeferred) r5
            if (r5 == 0) goto L_0x0080
            boolean r5 = r5.completeExceptionally(r7)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
        L_0x0080:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r7)
            java.lang.Object r5 = kotlin.Result.m983constructorimpl(r5)
        L_0x008a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzez.zza(java.lang.String, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b9, code lost:
        if (r2.longValue() > (r8 - 2000)) goto L_0x00bb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e4 A[LOOP:0: B:37:0x00de->B:39:0x00e4, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzb(long r8, com.google.android.recaptcha.internal.zzoe r10, kotlin.coroutines.Continuation r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.google.android.recaptcha.internal.zzev
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.google.android.recaptcha.internal.zzev r0 = (com.google.android.recaptcha.internal.zzev) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzd = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzev r0 = new com.google.android.recaptcha.internal.zzev
            r0.<init>(r7, r11)
        L_0x0018:
            java.lang.Object r11 = r0.zzb
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzd
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0039
            if (r2 != r4) goto L_0x0031
            long r8 = r0.zza
            com.google.android.recaptcha.internal.zzez r10 = r0.zze
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ Exception -> 0x002f }
            goto L_0x007b
        L_0x002f:
            r11 = move-exception
            goto L_0x0087
        L_0x0031:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r11)
            com.google.android.recaptcha.internal.zzbg r11 = r7.zzi     // Catch:{ Exception -> 0x0084 }
            com.google.android.recaptcha.internal.zzbd r2 = r7.zzp     // Catch:{ Exception -> 0x0084 }
            com.google.android.recaptcha.internal.zzne r6 = com.google.android.recaptcha.internal.zzne.INIT_NATIVE     // Catch:{ Exception -> 0x0084 }
            com.google.android.recaptcha.internal.zzbb r2 = r2.zza(r6)     // Catch:{ Exception -> 0x0084 }
            r11.zze.put(r2, new com.google.android.recaptcha.internal.zzbf(r2, r11.zza, new com.google.android.recaptcha.internal.zzac()))     // Catch:{ Exception -> 0x0084 }
            com.google.android.recaptcha.internal.zzag r11 = new com.google.android.recaptcha.internal.zzag     // Catch:{ Exception -> 0x0084 }
            com.google.android.recaptcha.internal.zzgw r2 = r10.zzf()     // Catch:{ Exception -> 0x0084 }
            r11.<init>(r2)     // Catch:{ Exception -> 0x0084 }
            com.google.android.recaptcha.internal.zzca r11 = r7.zzo(r10, r11)     // Catch:{ Exception -> 0x0084 }
            r7.zzc = r11     // Catch:{ Exception -> 0x0084 }
            kotlinx.coroutines.CompletableDeferred r11 = kotlinx.coroutines.CompletableDeferredKt.CompletableDeferred$default(r5, r4, r5)     // Catch:{ Exception -> 0x0084 }
            r7.zzb = r11     // Catch:{ Exception -> 0x0084 }
            kotlinx.coroutines.CompletableDeferred r11 = r7.zzk()     // Catch:{ Exception -> 0x0084 }
            int r11 = r11.hashCode()     // Catch:{ Exception -> 0x0084 }
            kotlin.coroutines.jvm.internal.Boxing.boxInt(r11)     // Catch:{ Exception -> 0x0084 }
            com.google.android.recaptcha.internal.zzew r11 = new com.google.android.recaptcha.internal.zzew     // Catch:{ Exception -> 0x0084 }
            r11.<init>(r7, r10, r5)     // Catch:{ Exception -> 0x0084 }
            r0.zze = r7     // Catch:{ Exception -> 0x0084 }
            r0.zza = r8     // Catch:{ Exception -> 0x0084 }
            r0.zzd = r4     // Catch:{ Exception -> 0x0084 }
            java.lang.Object r11 = kotlinx.coroutines.TimeoutKt.withTimeout(r8, r11, r0)     // Catch:{ Exception -> 0x0084 }
            if (r11 == r1) goto L_0x0083
            r10 = r7
        L_0x007b:
            kotlin.Result r11 = (kotlin.Result) r11     // Catch:{ Exception -> 0x002f }
            java.lang.Object r8 = r11.m992unboximpl()     // Catch:{ Exception -> 0x002f }
            goto L_0x0104
        L_0x0083:
            return r1
        L_0x0084:
            r10 = move-exception
            r11 = r10
            r10 = r7
        L_0x0087:
            r11.getMessage()
            boolean r0 = r11 instanceof kotlinx.coroutines.TimeoutCancellationException
            if (r0 == 0) goto L_0x009e
            com.google.android.recaptcha.internal.zzne[] r1 = new com.google.android.recaptcha.internal.zzne[r3]
            r2 = 0
            com.google.android.recaptcha.internal.zzne r3 = com.google.android.recaptcha.internal.zzne.INIT_TOTAL
            r1[r2] = r3
            com.google.android.recaptcha.internal.zzne r2 = com.google.android.recaptcha.internal.zzne.LOAD_WEBVIEW
            r1[r4] = r2
            java.util.List r1 = kotlin.collections.CollectionsKt.listOf(r1)
            goto L_0x00a4
        L_0x009e:
            com.google.android.recaptcha.internal.zzne r1 = com.google.android.recaptcha.internal.zzne.INIT_TOTAL
            java.util.List r1 = kotlin.collections.CollectionsKt.listOf(r1)
        L_0x00a4:
            com.google.android.recaptcha.internal.zzeq r2 = r10.zzo
            java.lang.Long r2 = r2.zza()
            if (r0 != 0) goto L_0x00ad
            goto L_0x00c5
        L_0x00ad:
            if (r2 != 0) goto L_0x00b0
            goto L_0x00bb
        L_0x00b0:
            r3 = -2000(0xfffffffffffff830, double:NaN)
            long r8 = r8 + r3
            long r2 = r2.longValue()
            int r8 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x00c5
        L_0x00bb:
            com.google.android.recaptcha.internal.zzp r8 = new com.google.android.recaptcha.internal.zzp
            com.google.android.recaptcha.internal.zzn r9 = com.google.android.recaptcha.internal.zzn.zze
            com.google.android.recaptcha.internal.zzl r11 = com.google.android.recaptcha.internal.zzl.zzS
            r8.<init>(r9, r11, r5)
            goto L_0x00da
        L_0x00c5:
            java.lang.Class r8 = r11.getClass()
            com.google.android.recaptcha.internal.zzp r9 = new com.google.android.recaptcha.internal.zzp
            com.google.android.recaptcha.internal.zzn r0 = com.google.android.recaptcha.internal.zzn.zzc
            com.google.android.recaptcha.internal.zzl r2 = com.google.android.recaptcha.internal.zzl.zzah
            java.lang.String r8 = r8.getSimpleName()
            r9.<init>(r0, r2, r8)
            com.google.android.recaptcha.internal.zzp r8 = r10.zzp(r11, r9)
        L_0x00da:
            java.util.Iterator r9 = r1.iterator()
        L_0x00de:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x00f6
            java.lang.Object r11 = r9.next()
            com.google.android.recaptcha.internal.zzne r11 = (com.google.android.recaptcha.internal.zzne) r11
            com.google.android.recaptcha.internal.zzbg r0 = r10.zzi
            com.google.android.recaptcha.internal.zzbd r1 = r10.zzp
            com.google.android.recaptcha.internal.zzbb r11 = r1.zza(r11)
            r0.zzb(r11, r8, r5)
            goto L_0x00de
        L_0x00f6:
            kotlin.Result$Companion r9 = kotlin.Result.Companion
            com.google.android.recaptcha.RecaptchaException r8 = r8.zzc()
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r8 = kotlin.Result.m983constructorimpl(r8)
        L_0x0104:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzez.zzb(long, com.google.android.recaptcha.internal.zzoe, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final WebView zzc() {
        return this.zzd;
    }

    public final zzbq zzf() {
        return this.zzj;
    }

    public final zzeq zzg() {
        return this.zzo;
    }

    public final CompletableDeferred zzk() {
        CompletableDeferred completableDeferred = this.zzb;
        if (completableDeferred != null) {
            return completableDeferred;
        }
        return null;
    }

    public final zzca zzo(zzoe zzoe, zzag zzag) {
        zzcd zzcd = new zzcd(this.zzd, this.zzq.zzb());
        zzef zzef = new zzef();
        zzef.zzb(CollectionsKt.toLongArray(zzoe.zzK()));
        zzcl zzcl = new zzcl(zzcd, zzag, new zzaa());
        zzeg zzeg = new zzeg(zzef, new zzed());
        zzcl.zzf(3, this.zzf);
        zzcl.zzf(5, zzen.class.getMethod("cs", new Class[]{new Object[0].getClass()}));
        zzcl.zzf(6, new zzeh(this.zzf));
        zzcl.zzf(7, new zzej());
        zzcl.zzf(8, new zzeo(this.zzf));
        zzcl.zzf(9, new zzek(this.zzf));
        zzcl.zzf(10, new zzei(this.zzf));
        return new zzca(this.zzq.zzc(), zzcl, zzeg, zzbt.zza());
    }
}
