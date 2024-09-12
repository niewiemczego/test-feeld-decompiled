package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
enum zza {
    RESPONSE_CODE_UNSPECIFIED(-999),
    SERVICE_TIMEOUT(-3),
    FEATURE_NOT_SUPPORTED(-2),
    SERVICE_DISCONNECTED(-1),
    OK(0),
    USER_CANCELED(1),
    SERVICE_UNAVAILABLE(2),
    BILLING_UNAVAILABLE(3),
    ITEM_UNAVAILABLE(4),
    DEVELOPER_ERROR(5),
    ERROR(6),
    ITEM_ALREADY_OWNED(7),
    ITEM_NOT_OWNED(8),
    EXPIRED_OFFER_TOKEN(11),
    NETWORK_ERROR(12);
    
    private static final zzai zzp = null;
    private final int zzr;

    static {
        int i;
        zzah zzah = new zzah();
        for (zza zza : values()) {
            zzah.zza(Integer.valueOf(zza.zzr), zza);
        }
        zzp = zzah.zzb();
    }

    private zza(int i) {
        this.zzr = i;
    }

    static zza zza(int i) {
        zzai zzai = zzp;
        Integer valueOf = Integer.valueOf(i);
        if (!zzai.containsKey(valueOf)) {
            return RESPONSE_CODE_UNSPECIFIED;
        }
        return (zza) zzai.get(valueOf);
    }
}
