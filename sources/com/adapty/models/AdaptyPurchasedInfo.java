package com.adapty.models;

import com.android.billingclient.api.Purchase;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/adapty/models/AdaptyPurchasedInfo;", "", "profile", "Lcom/adapty/models/AdaptyProfile;", "purchase", "Lcom/android/billingclient/api/Purchase;", "(Lcom/adapty/models/AdaptyProfile;Lcom/android/billingclient/api/Purchase;)V", "getProfile", "()Lcom/adapty/models/AdaptyProfile;", "getPurchase", "()Lcom/android/billingclient/api/Purchase;", "toString", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyPurchasedInfo.kt */
public final class AdaptyPurchasedInfo {
    private final AdaptyProfile profile;
    private final Purchase purchase;

    public AdaptyPurchasedInfo(AdaptyProfile adaptyProfile, Purchase purchase2) {
        Intrinsics.checkNotNullParameter(adaptyProfile, Scopes.PROFILE);
        Intrinsics.checkNotNullParameter(purchase2, FirebaseAnalytics.Event.PURCHASE);
        this.profile = adaptyProfile;
        this.purchase = purchase2;
    }

    public final AdaptyProfile getProfile() {
        return this.profile;
    }

    public final Purchase getPurchase() {
        return this.purchase;
    }

    public String toString() {
        return "AdaptyPurchasedInfo(profile=" + this.profile + ", purchase=" + this.purchase + ')';
    }
}
