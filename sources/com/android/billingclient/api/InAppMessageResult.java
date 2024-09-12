package com.android.billingclient.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class InAppMessageResult {
    private final int zza;
    private final String zzb;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.android.billingclient:billing@@6.1.0 */
    public @interface InAppMessageResponseCode {
        public static final int NO_ACTION_NEEDED = 0;
        public static final int SUBSCRIPTION_STATUS_UPDATED = 1;
    }

    public InAppMessageResult(int i, String str) {
        this.zza = i;
        this.zzb = str;
    }

    public String getPurchaseToken() {
        return this.zzb;
    }

    public int getResponseCode() {
        return this.zza;
    }
}
