package com.google.android.gms.internal.play_billing;

import com.facebook.react.uimanager.events.TouchesHelper;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zzcz {
    private static final String[] zza = {"com.google.common.flogger.util.StackWalkerStackGetter", "com.google.common.flogger.util.JavaLangAccessStackGetter"};
    private static final zzdd zzb;

    static {
        zzdd zzde;
        int i = 0;
        while (true) {
            if (i >= 2) {
                zzde = new zzde();
                break;
            }
            try {
                zzde = (zzdd) Class.forName(zza[i]).asSubclass(zzdd.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused) {
                zzde = null;
            }
            if (zzde != null) {
                break;
            }
            i++;
        }
        zzb = zzde;
    }

    @NullableDecl
    public static StackTraceElement zza(Class cls, int i) {
        zzda.zza(cls, TouchesHelper.TARGET_KEY);
        return zzb.zza(cls, 2);
    }
}
