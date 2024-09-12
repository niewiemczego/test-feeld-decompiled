package androidx.privacysandbox.ads.adservices.adselection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/ReportImpressionRequest;", "", "adSelectionId", "", "adSelectionConfig", "Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionConfig;", "(JLandroidx/privacysandbox/ads/adservices/adselection/AdSelectionConfig;)V", "getAdSelectionConfig", "()Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionConfig;", "getAdSelectionId", "()J", "equals", "", "other", "hashCode", "", "toString", "", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ReportImpressionRequest.kt */
public final class ReportImpressionRequest {
    private final AdSelectionConfig adSelectionConfig;
    private final long adSelectionId;

    public ReportImpressionRequest(long j, AdSelectionConfig adSelectionConfig2) {
        Intrinsics.checkNotNullParameter(adSelectionConfig2, "adSelectionConfig");
        this.adSelectionId = j;
        this.adSelectionConfig = adSelectionConfig2;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public final AdSelectionConfig getAdSelectionConfig() {
        return this.adSelectionConfig;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReportImpressionRequest)) {
            return false;
        }
        ReportImpressionRequest reportImpressionRequest = (ReportImpressionRequest) obj;
        if (this.adSelectionId != reportImpressionRequest.adSelectionId || !Intrinsics.areEqual((Object) this.adSelectionConfig, (Object) reportImpressionRequest.adSelectionConfig)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (Long.hashCode(this.adSelectionId) * 31) + this.adSelectionConfig.hashCode();
    }

    public String toString() {
        return "ReportImpressionRequest: adSelectionId=" + this.adSelectionId + ", adSelectionConfig=" + this.adSelectionConfig;
    }
}
