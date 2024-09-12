package com.adapty.internal.data.models;

import com.adapty.internal.crossplatform.AdaptyPaywallTypeAdapterFactory;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/adapty/internal/data/models/PurchaseRecordModel;", "", "purchaseToken", "", "purchaseTime", "", "products", "", "type", "(Ljava/lang/String;JLjava/util/List;Ljava/lang/String;)V", "getProducts", "()Ljava/util/List;", "getPurchaseTime", "()J", "getPurchaseToken", "()Ljava/lang/String;", "getType", "equals", "", "other", "hashCode", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PurchaseRecordModel.kt */
public final class PurchaseRecordModel {
    private final List<String> products;
    private final long purchaseTime;
    private final String purchaseToken;
    private final String type;

    public PurchaseRecordModel(String str, long j, List<String> list, String str2) {
        Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_PURCHASE_TOKEN);
        Intrinsics.checkNotNullParameter(list, AdaptyPaywallTypeAdapterFactory.PRODUCTS);
        Intrinsics.checkNotNullParameter(str2, "type");
        this.purchaseToken = str;
        this.purchaseTime = j;
        this.products = list;
        this.type = str2;
    }

    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    public final long getPurchaseTime() {
        return this.purchaseTime;
    }

    public final List<String> getProducts() {
        return this.products;
    }

    public final String getType() {
        return this.type;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PurchaseRecordModel)) {
            return false;
        }
        PurchaseRecordModel purchaseRecordModel = (PurchaseRecordModel) obj;
        return Intrinsics.areEqual((Object) this.purchaseToken, (Object) purchaseRecordModel.purchaseToken) && this.purchaseTime == purchaseRecordModel.purchaseTime && Intrinsics.areEqual((Object) this.products, (Object) purchaseRecordModel.products) && Intrinsics.areEqual((Object) this.type, (Object) purchaseRecordModel.type);
    }

    public int hashCode() {
        return (((((this.purchaseToken.hashCode() * 31) + Long.hashCode(this.purchaseTime)) * 31) + this.products.hashCode()) * 31) + this.type.hashCode();
    }
}
