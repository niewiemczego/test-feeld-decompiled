package zendesk.android.internal.frontendevents.analyticsevents.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001e"}, d2 = {"Lzendesk/android/internal/frontendevents/analyticsevents/model/ProactiveCampaignAnalyticsDTO;", "", "campaignId", "", "action", "Lzendesk/android/internal/frontendevents/analyticsevents/model/ProactiveCampaignAnalyticsAction;", "timestamp", "version", "", "visitorId", "(Ljava/lang/String;Lzendesk/android/internal/frontendevents/analyticsevents/model/ProactiveCampaignAnalyticsAction;Ljava/lang/String;ILjava/lang/String;)V", "getAction", "()Lzendesk/android/internal/frontendevents/analyticsevents/model/ProactiveCampaignAnalyticsAction;", "getCampaignId", "()Ljava/lang/String;", "getTimestamp", "getVersion", "()I", "getVisitorId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProactiveCampaignAnalyticsDTO.kt */
public final class ProactiveCampaignAnalyticsDTO {
    private final ProactiveCampaignAnalyticsAction action;
    private final String campaignId;
    private final String timestamp;
    private final int version;
    private final String visitorId;

    public static /* synthetic */ ProactiveCampaignAnalyticsDTO copy$default(ProactiveCampaignAnalyticsDTO proactiveCampaignAnalyticsDTO, String str, ProactiveCampaignAnalyticsAction proactiveCampaignAnalyticsAction, String str2, int i, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = proactiveCampaignAnalyticsDTO.campaignId;
        }
        if ((i2 & 2) != 0) {
            proactiveCampaignAnalyticsAction = proactiveCampaignAnalyticsDTO.action;
        }
        ProactiveCampaignAnalyticsAction proactiveCampaignAnalyticsAction2 = proactiveCampaignAnalyticsAction;
        if ((i2 & 4) != 0) {
            str2 = proactiveCampaignAnalyticsDTO.timestamp;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            i = proactiveCampaignAnalyticsDTO.version;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            str3 = proactiveCampaignAnalyticsDTO.visitorId;
        }
        return proactiveCampaignAnalyticsDTO.copy(str, proactiveCampaignAnalyticsAction2, str4, i3, str3);
    }

    public final String component1() {
        return this.campaignId;
    }

    public final ProactiveCampaignAnalyticsAction component2() {
        return this.action;
    }

    public final String component3() {
        return this.timestamp;
    }

    public final int component4() {
        return this.version;
    }

    public final String component5() {
        return this.visitorId;
    }

    public final ProactiveCampaignAnalyticsDTO copy(String str, ProactiveCampaignAnalyticsAction proactiveCampaignAnalyticsAction, String str2, int i, String str3) {
        Intrinsics.checkNotNullParameter(str, "campaignId");
        Intrinsics.checkNotNullParameter(proactiveCampaignAnalyticsAction, "action");
        Intrinsics.checkNotNullParameter(str2, "timestamp");
        Intrinsics.checkNotNullParameter(str3, "visitorId");
        return new ProactiveCampaignAnalyticsDTO(str, proactiveCampaignAnalyticsAction, str2, i, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProactiveCampaignAnalyticsDTO)) {
            return false;
        }
        ProactiveCampaignAnalyticsDTO proactiveCampaignAnalyticsDTO = (ProactiveCampaignAnalyticsDTO) obj;
        return Intrinsics.areEqual((Object) this.campaignId, (Object) proactiveCampaignAnalyticsDTO.campaignId) && this.action == proactiveCampaignAnalyticsDTO.action && Intrinsics.areEqual((Object) this.timestamp, (Object) proactiveCampaignAnalyticsDTO.timestamp) && this.version == proactiveCampaignAnalyticsDTO.version && Intrinsics.areEqual((Object) this.visitorId, (Object) proactiveCampaignAnalyticsDTO.visitorId);
    }

    public int hashCode() {
        return (((((((this.campaignId.hashCode() * 31) + this.action.hashCode()) * 31) + this.timestamp.hashCode()) * 31) + Integer.hashCode(this.version)) * 31) + this.visitorId.hashCode();
    }

    public String toString() {
        return "ProactiveCampaignAnalyticsDTO(campaignId=" + this.campaignId + ", action=" + this.action + ", timestamp=" + this.timestamp + ", version=" + this.version + ", visitorId=" + this.visitorId + ')';
    }

    public ProactiveCampaignAnalyticsDTO(String str, ProactiveCampaignAnalyticsAction proactiveCampaignAnalyticsAction, String str2, int i, String str3) {
        Intrinsics.checkNotNullParameter(str, "campaignId");
        Intrinsics.checkNotNullParameter(proactiveCampaignAnalyticsAction, "action");
        Intrinsics.checkNotNullParameter(str2, "timestamp");
        Intrinsics.checkNotNullParameter(str3, "visitorId");
        this.campaignId = str;
        this.action = proactiveCampaignAnalyticsAction;
        this.timestamp = str2;
        this.version = i;
        this.visitorId = str3;
    }

    public final String getCampaignId() {
        return this.campaignId;
    }

    public final ProactiveCampaignAnalyticsAction getAction() {
        return this.action;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final int getVersion() {
        return this.version;
    }

    public final String getVisitorId() {
        return this.visitorId;
    }
}
