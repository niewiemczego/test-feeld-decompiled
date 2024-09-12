package com.google.android.recaptcha.internal;

import android.os.Build;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzfa {
    public static final zzfa zza = new zzfa();

    private zzfa() {
    }

    public static final Map zza() {
        Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(-4, zzl.zzz), TuplesKt.to(-12, zzl.zzA), TuplesKt.to(-6, zzl.zzv), TuplesKt.to(-11, zzl.zzx), TuplesKt.to(-13, zzl.zzB), TuplesKt.to(-14, zzl.zzC), TuplesKt.to(-2, zzl.zzw), TuplesKt.to(-7, zzl.zzD), TuplesKt.to(-5, zzl.zzE), TuplesKt.to(-9, zzl.zzF), TuplesKt.to(-8, zzl.zzP), TuplesKt.to(-15, zzl.zzy), TuplesKt.to(-1, zzl.zzG), TuplesKt.to(-3, zzl.zzI), TuplesKt.to(-10, zzl.zzJ));
        if (Build.VERSION.SDK_INT >= 26) {
            mutableMapOf.put(-16, zzl.zzH);
        }
        if (Build.VERSION.SDK_INT >= 27) {
            mutableMapOf.put(1, zzl.zzL);
            mutableMapOf.put(2, zzl.zzM);
            mutableMapOf.put(0, zzl.zzN);
            mutableMapOf.put(3, zzl.zzO);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            mutableMapOf.put(4, zzl.zzK);
        }
        return mutableMapOf;
    }
}
