package androidx.privacysandbox.ads.adservices.adselection;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\f\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014¨\u0006\""}, d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionConfig;", "", "seller", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "decisionLogicUri", "Landroid/net/Uri;", "customAudienceBuyers", "", "adSelectionSignals", "Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "sellerSignals", "perBuyerSignals", "", "trustedScoringSignalsUri", "(Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;Landroid/net/Uri;Ljava/util/List;Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;Ljava/util/Map;Landroid/net/Uri;)V", "getAdSelectionSignals", "()Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "getCustomAudienceBuyers", "()Ljava/util/List;", "getDecisionLogicUri", "()Landroid/net/Uri;", "getPerBuyerSignals", "()Ljava/util/Map;", "getSeller", "()Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "getSellerSignals", "getTrustedScoringSignalsUri", "equals", "", "other", "hashCode", "", "toString", "", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdSelectionConfig.kt */
public final class AdSelectionConfig {
    private final AdSelectionSignals adSelectionSignals;
    private final List<AdTechIdentifier> customAudienceBuyers;
    private final Uri decisionLogicUri;
    private final Map<AdTechIdentifier, AdSelectionSignals> perBuyerSignals;
    private final AdTechIdentifier seller;
    private final AdSelectionSignals sellerSignals;
    private final Uri trustedScoringSignalsUri;

    public AdSelectionConfig(AdTechIdentifier adTechIdentifier, Uri uri, List<AdTechIdentifier> list, AdSelectionSignals adSelectionSignals2, AdSelectionSignals adSelectionSignals3, Map<AdTechIdentifier, AdSelectionSignals> map, Uri uri2) {
        Intrinsics.checkNotNullParameter(adTechIdentifier, "seller");
        Intrinsics.checkNotNullParameter(uri, "decisionLogicUri");
        Intrinsics.checkNotNullParameter(list, "customAudienceBuyers");
        Intrinsics.checkNotNullParameter(adSelectionSignals2, "adSelectionSignals");
        Intrinsics.checkNotNullParameter(adSelectionSignals3, "sellerSignals");
        Intrinsics.checkNotNullParameter(map, "perBuyerSignals");
        Intrinsics.checkNotNullParameter(uri2, "trustedScoringSignalsUri");
        this.seller = adTechIdentifier;
        this.decisionLogicUri = uri;
        this.customAudienceBuyers = list;
        this.adSelectionSignals = adSelectionSignals2;
        this.sellerSignals = adSelectionSignals3;
        this.perBuyerSignals = map;
        this.trustedScoringSignalsUri = uri2;
    }

    public final AdTechIdentifier getSeller() {
        return this.seller;
    }

    public final Uri getDecisionLogicUri() {
        return this.decisionLogicUri;
    }

    public final List<AdTechIdentifier> getCustomAudienceBuyers() {
        return this.customAudienceBuyers;
    }

    public final AdSelectionSignals getAdSelectionSignals() {
        return this.adSelectionSignals;
    }

    public final AdSelectionSignals getSellerSignals() {
        return this.sellerSignals;
    }

    public final Map<AdTechIdentifier, AdSelectionSignals> getPerBuyerSignals() {
        return this.perBuyerSignals;
    }

    public final Uri getTrustedScoringSignalsUri() {
        return this.trustedScoringSignalsUri;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdSelectionConfig)) {
            return false;
        }
        AdSelectionConfig adSelectionConfig = (AdSelectionConfig) obj;
        if (!Intrinsics.areEqual((Object) this.seller, (Object) adSelectionConfig.seller) || !Intrinsics.areEqual((Object) this.decisionLogicUri, (Object) adSelectionConfig.decisionLogicUri) || !Intrinsics.areEqual((Object) this.customAudienceBuyers, (Object) adSelectionConfig.customAudienceBuyers) || !Intrinsics.areEqual((Object) this.adSelectionSignals, (Object) adSelectionConfig.adSelectionSignals) || !Intrinsics.areEqual((Object) this.sellerSignals, (Object) adSelectionConfig.sellerSignals) || !Intrinsics.areEqual((Object) this.perBuyerSignals, (Object) adSelectionConfig.perBuyerSignals) || !Intrinsics.areEqual((Object) this.trustedScoringSignalsUri, (Object) adSelectionConfig.trustedScoringSignalsUri)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((((((this.seller.hashCode() * 31) + this.decisionLogicUri.hashCode()) * 31) + this.customAudienceBuyers.hashCode()) * 31) + this.adSelectionSignals.hashCode()) * 31) + this.sellerSignals.hashCode()) * 31) + this.perBuyerSignals.hashCode()) * 31) + this.trustedScoringSignalsUri.hashCode();
    }

    public String toString() {
        return "AdSelectionConfig: seller=" + this.seller + ", decisionLogicUri='" + this.decisionLogicUri + "', customAudienceBuyers=" + this.customAudienceBuyers + ", adSelectionSignals=" + this.adSelectionSignals + ", sellerSignals=" + this.sellerSignals + ", perBuyerSignals=" + this.perBuyerSignals + ", trustedScoringSignalsUri=" + this.trustedScoringSignalsUri;
    }
}
