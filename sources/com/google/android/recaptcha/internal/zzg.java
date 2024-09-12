package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzg {
    private final List zza;

    public zzg() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ zzg(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        List emptyList = CollectionsKt.emptyList();
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        arrayList.addAll(emptyList);
    }

    public final Object zza(String str, long j, Continuation continuation) {
        return CoroutineScopeKt.coroutineScope(new zzc(this, str, j, (Continuation) null), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzb(long r11, com.google.android.recaptcha.internal.zzoe r13, kotlin.coroutines.Continuation r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.google.android.recaptcha.internal.zzd
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.google.android.recaptcha.internal.zzd r0 = (com.google.android.recaptcha.internal.zzd) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzc = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.internal.zzd r0 = new com.google.android.recaptcha.internal.zzd
            r0.<init>(r10, r14)
        L_0x0018:
            java.lang.Object r14 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0047
        L_0x0029:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r14)
            com.google.android.recaptcha.internal.zzf r14 = new com.google.android.recaptcha.internal.zzf
            r9 = 0
            r4 = r14
            r5 = r10
            r6 = r11
            r8 = r13
            r4.<init>(r5, r6, r8, r9)
            r0.zzc = r3
            java.lang.Object r14 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r14, r0)
            if (r14 != r1) goto L_0x0047
            return r1
        L_0x0047:
            kotlin.Result r14 = (kotlin.Result) r14
            java.lang.Object r11 = r14.m992unboximpl()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzg.zzb(long, com.google.android.recaptcha.internal.zzoe, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final List zzc() {
        return this.zza;
    }

    public final void zzd(zza zza2) {
        this.zza.add(zza2);
    }
}
