package com.adapty.models;

import com.facebook.internal.security.CertificateUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/adapty/models/AdaptySubscriptionUpdateParameters;", "", "oldSubVendorProductId", "", "replacementMode", "Lcom/adapty/models/AdaptySubscriptionUpdateParameters$ReplacementMode;", "(Ljava/lang/String;Lcom/adapty/models/AdaptySubscriptionUpdateParameters$ReplacementMode;)V", "getOldSubVendorProductId", "()Ljava/lang/String;", "getReplacementMode", "()Lcom/adapty/models/AdaptySubscriptionUpdateParameters$ReplacementMode;", "toString", "ReplacementMode", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptySubscriptionUpdateParameters.kt */
public final class AdaptySubscriptionUpdateParameters {
    private final String oldSubVendorProductId;
    private final ReplacementMode replacementMode;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/adapty/models/AdaptySubscriptionUpdateParameters$ReplacementMode;", "", "(Ljava/lang/String;I)V", "WITH_TIME_PRORATION", "CHARGE_PRORATED_PRICE", "WITHOUT_PRORATION", "DEFERRED", "CHARGE_FULL_PRICE", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdaptySubscriptionUpdateParameters.kt */
    public enum ReplacementMode {
        WITH_TIME_PRORATION,
        CHARGE_PRORATED_PRICE,
        WITHOUT_PRORATION,
        DEFERRED,
        CHARGE_FULL_PRICE
    }

    public AdaptySubscriptionUpdateParameters(String str, ReplacementMode replacementMode2) {
        Intrinsics.checkNotNullParameter(str, "oldSubVendorProductId");
        Intrinsics.checkNotNullParameter(replacementMode2, "replacementMode");
        this.replacementMode = replacementMode2;
        this.oldSubVendorProductId = (String) StringsKt.split$default((CharSequence) str, new String[]{CertificateUtil.DELIMITER}, false, 0, 6, (Object) null).get(0);
    }

    public final ReplacementMode getReplacementMode() {
        return this.replacementMode;
    }

    public final String getOldSubVendorProductId() {
        return this.oldSubVendorProductId;
    }

    public String toString() {
        return "SubscriptionUpdateParameters(oldSubVendorProductId='" + this.oldSubVendorProductId + "', replacementMode=" + this.replacementMode + ')';
    }
}
