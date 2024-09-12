package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class AccountIdentifiers {
    private final String zza;
    private final String zzb;

    AccountIdentifiers(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public String getObfuscatedAccountId() {
        return this.zza;
    }

    public String getObfuscatedProfileId() {
        return this.zzb;
    }
}
