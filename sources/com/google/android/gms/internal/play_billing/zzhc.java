package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zzhc extends RuntimeException {
    public zzhc(zzgc zzgc) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzff zza() {
        return new zzff(getMessage());
    }
}
