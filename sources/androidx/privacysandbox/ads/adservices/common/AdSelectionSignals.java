package androidx.privacysandbox.ads.adservices.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "", "signals", "", "(Ljava/lang/String;)V", "getSignals", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "toString", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdSelectionSignals.kt */
public final class AdSelectionSignals {
    private final String signals;

    public AdSelectionSignals(String str) {
        Intrinsics.checkNotNullParameter(str, "signals");
        this.signals = str;
    }

    public final String getSignals() {
        return this.signals;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdSelectionSignals)) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.signals, (Object) ((AdSelectionSignals) obj).signals);
    }

    public int hashCode() {
        return this.signals.hashCode();
    }

    public String toString() {
        return "AdSelectionSignals: " + this.signals;
    }
}
