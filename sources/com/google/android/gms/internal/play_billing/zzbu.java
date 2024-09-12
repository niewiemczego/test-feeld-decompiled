package com.google.android.gms.internal.play_billing;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzbu {
    /* access modifiers changed from: private */
    public static final zzbw zza = zzb(zzbw.zzd);

    private static zzbw zzb(String[] strArr) {
        zzbw zzbw;
        try {
            zzbw = zzbx.zza();
        } catch (NoClassDefFoundError unused) {
            zzbw = null;
        }
        if (zzbw != null) {
            return zzbw;
        }
        StringBuilder sb = new StringBuilder();
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            try {
                return (zzbw) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable th) {
                th = th;
                if (th instanceof InvocationTargetException) {
                    th = th.getCause();
                }
                sb.append(10);
                sb.append(str);
                sb.append(": ");
                sb.append(th);
                i++;
            }
        }
        throw new IllegalStateException(sb.insert(0, "No logging platforms found:").toString());
    }
}
