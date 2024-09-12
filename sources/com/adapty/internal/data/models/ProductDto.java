package com.adapty.internal.data.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\b\u0001\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0005\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/adapty/internal/data/models/ProductDto;", "", "id", "", "vendorProductId", "isConsumable", "", "basePlanId", "offerId", "timestamp", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getBasePlanId", "()Ljava/lang/String;", "getId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getOfferId", "getTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getVendorProductId", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProductDto.kt */
public final class ProductDto {
    @SerializedName("base_plan_id")
    private final String basePlanId;
    @SerializedName("adapty_product_id")
    private final String id;
    @SerializedName("is_consumable")
    private final Boolean isConsumable;
    @SerializedName("offer_id")
    private final String offerId;
    @SerializedName("timestamp")
    private final Long timestamp;
    @SerializedName("vendor_product_id")
    private final String vendorProductId;

    public ProductDto(String str, String str2, Boolean bool, String str3, String str4, Long l) {
        this.id = str;
        this.vendorProductId = str2;
        this.isConsumable = bool;
        this.basePlanId = str3;
        this.offerId = str4;
        this.timestamp = l;
    }

    public final String getId() {
        return this.id;
    }

    public final String getVendorProductId() {
        return this.vendorProductId;
    }

    public final Boolean isConsumable() {
        return this.isConsumable;
    }

    public final String getBasePlanId() {
        return this.basePlanId;
    }

    public final String getOfferId() {
        return this.offerId;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }
}
