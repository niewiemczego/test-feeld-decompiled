package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class QueryPurchaseHistoryParams {
    private final String zza;

    /* compiled from: com.android.billingclient:billing@@6.1.0 */
    public static class Builder {
        /* access modifiers changed from: private */
        public String zza;

        private Builder() {
        }

        /* synthetic */ Builder(zzcl zzcl) {
        }

        public QueryPurchaseHistoryParams build() {
            if (this.zza != null) {
                return new QueryPurchaseHistoryParams(this, (zzcm) null);
            }
            throw new IllegalArgumentException("Product type must be set");
        }

        public Builder setProductType(String str) {
            this.zza = str;
            return this;
        }
    }

    /* synthetic */ QueryPurchaseHistoryParams(Builder builder, zzcm zzcm) {
        this.zza = builder.zza;
    }

    public static Builder newBuilder() {
        return new Builder((zzcl) null);
    }

    public final String zza() {
        return this.zza;
    }
}
