package com.adapty.internal.domain.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0011B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/adapty/internal/domain/models/BackendProduct;", "", "id", "", "vendorProductId", "timestamp", "", "type", "Lcom/adapty/internal/domain/models/ProductType;", "(Ljava/lang/String;Ljava/lang/String;JLcom/adapty/internal/domain/models/ProductType;)V", "getId", "()Ljava/lang/String;", "getTimestamp", "()J", "getType", "()Lcom/adapty/internal/domain/models/ProductType;", "getVendorProductId", "SubscriptionData", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BackendProduct.kt */
public final class BackendProduct {
    private final String id;
    private final long timestamp;
    private final ProductType type;
    private final String vendorProductId;

    public BackendProduct(String str, String str2, long j, ProductType productType) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "vendorProductId");
        Intrinsics.checkNotNullParameter(productType, "type");
        this.id = str;
        this.vendorProductId = str2;
        this.timestamp = j;
        this.type = productType;
    }

    public final String getId() {
        return this.id;
    }

    public final String getVendorProductId() {
        return this.vendorProductId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final ProductType getType() {
        return this.type;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/adapty/internal/domain/models/BackendProduct$SubscriptionData;", "", "basePlanId", "", "offerId", "(Ljava/lang/String;Ljava/lang/String;)V", "getBasePlanId", "()Ljava/lang/String;", "getOfferId", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BackendProduct.kt */
    public static final class SubscriptionData {
        private final String basePlanId;
        private final String offerId;

        public SubscriptionData(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "basePlanId");
            this.basePlanId = str;
            this.offerId = str2;
        }

        public final String getBasePlanId() {
            return this.basePlanId;
        }

        public final String getOfferId() {
            return this.offerId;
        }
    }
}
