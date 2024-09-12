package com.google.android.recaptcha.internal;

import android.content.Context;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzeo implements zzen {
    private final Context zzb;
    private final Map zzc = MapsKt.mapOf(TuplesKt.to(2, "activity"), TuplesKt.to(3, "phone"), TuplesKt.to(4, "input_method"), TuplesKt.to(5, "audio"));

    public zzeo(Context context) {
        this.zzb = context;
    }

    public final /* synthetic */ Object cs(Object[] objArr) {
        return zzel.zza(this, objArr);
    }

    public final Object zza(Object... objArr) {
        Integer num = objArr[0];
        if (true != (num instanceof Integer)) {
            num = null;
        }
        Integer num2 = num;
        if (num2 != null) {
            Object obj = this.zzc.get(Integer.valueOf(num2.intValue()));
            if (obj != null) {
                return this.zzb.getSystemService((String) obj);
            }
            throw new zzae(4, 4, (Throwable) null);
        }
        throw new zzae(4, 5, (Throwable) null);
    }
}
