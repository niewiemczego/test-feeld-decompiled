package com.adapty.internal.data.models;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/adapty/internal/data/models/SyncedPurchase;", "", "purchaseToken", "", "purchaseTime", "", "(Ljava/lang/String;Ljava/lang/Long;)V", "getPurchaseTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPurchaseToken", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Long;)Lcom/adapty/internal/data/models/SyncedPurchase;", "equals", "", "other", "hashCode", "", "toString", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SyncedPurchase.kt */
public final class SyncedPurchase {
    @SerializedName("purchase_time")
    private final Long purchaseTime;
    @SerializedName("purchase_token")
    private final String purchaseToken;

    public static /* synthetic */ SyncedPurchase copy$default(SyncedPurchase syncedPurchase, String str, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = syncedPurchase.purchaseToken;
        }
        if ((i & 2) != 0) {
            l = syncedPurchase.purchaseTime;
        }
        return syncedPurchase.copy(str, l);
    }

    public final String component1() {
        return this.purchaseToken;
    }

    public final Long component2() {
        return this.purchaseTime;
    }

    public final SyncedPurchase copy(String str, Long l) {
        return new SyncedPurchase(str, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SyncedPurchase)) {
            return false;
        }
        SyncedPurchase syncedPurchase = (SyncedPurchase) obj;
        return Intrinsics.areEqual((Object) this.purchaseToken, (Object) syncedPurchase.purchaseToken) && Intrinsics.areEqual((Object) this.purchaseTime, (Object) syncedPurchase.purchaseTime);
    }

    public int hashCode() {
        String str = this.purchaseToken;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.purchaseTime;
        if (l != null) {
            i = l.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "SyncedPurchase(purchaseToken=" + this.purchaseToken + ", purchaseTime=" + this.purchaseTime + ')';
    }

    public SyncedPurchase(String str, Long l) {
        this.purchaseToken = str;
        this.purchaseTime = l;
    }

    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    public final Long getPurchaseTime() {
        return this.purchaseTime;
    }
}
