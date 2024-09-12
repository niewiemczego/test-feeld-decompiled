package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class ConsumeParams {
    /* access modifiers changed from: private */
    public String zza;

    /* compiled from: com.android.billingclient:billing@@6.1.0 */
    public static final class Builder {
        private String zza;

        private Builder() {
        }

        /* synthetic */ Builder(zzbl zzbl) {
        }

        public ConsumeParams build() {
            String str = this.zza;
            if (str != null) {
                ConsumeParams consumeParams = new ConsumeParams((zzbm) null);
                consumeParams.zza = str;
                return consumeParams;
            }
            throw new IllegalArgumentException("Purchase token must be set");
        }

        public Builder setPurchaseToken(String str) {
            this.zza = str;
            return this;
        }
    }

    private ConsumeParams() {
    }

    /* synthetic */ ConsumeParams(zzbm zzbm) {
    }

    public static Builder newBuilder() {
        return new Builder((zzbl) null);
    }

    public String getPurchaseToken() {
        return this.zza;
    }
}
