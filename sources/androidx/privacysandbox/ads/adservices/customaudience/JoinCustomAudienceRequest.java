package androidx.privacysandbox.ads.adservices.customaudience;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Landroidx/privacysandbox/ads/adservices/customaudience/JoinCustomAudienceRequest;", "", "customAudience", "Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience;", "(Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience;)V", "getCustomAudience", "()Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience;", "equals", "", "other", "hashCode", "", "toString", "", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: JoinCustomAudienceRequest.kt */
public final class JoinCustomAudienceRequest {
    private final CustomAudience customAudience;

    public JoinCustomAudienceRequest(CustomAudience customAudience2) {
        Intrinsics.checkNotNullParameter(customAudience2, "customAudience");
        this.customAudience = customAudience2;
    }

    public final CustomAudience getCustomAudience() {
        return this.customAudience;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JoinCustomAudienceRequest)) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.customAudience, (Object) ((JoinCustomAudienceRequest) obj).customAudience);
    }

    public int hashCode() {
        return this.customAudience.hashCode();
    }

    public String toString() {
        return "JoinCustomAudience: customAudience=" + this.customAudience;
    }
}
