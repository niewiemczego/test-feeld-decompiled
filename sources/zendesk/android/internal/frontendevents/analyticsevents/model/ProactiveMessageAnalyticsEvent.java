package zendesk.android.internal.frontendevents.analyticsevents.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.internal.frontendevents.FrontendEventsStorage;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006#"}, d2 = {"Lzendesk/android/internal/frontendevents/analyticsevents/model/ProactiveMessageAnalyticsEvent;", "", "buid", "", "channel", "version", "timestamp", "suid", "idempotencyToken", "proactiveCampaign", "Lzendesk/android/internal/frontendevents/analyticsevents/model/ProactiveCampaignAnalyticsDTO;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lzendesk/android/internal/frontendevents/analyticsevents/model/ProactiveCampaignAnalyticsDTO;)V", "getBuid", "()Ljava/lang/String;", "getChannel", "getIdempotencyToken", "getProactiveCampaign", "()Lzendesk/android/internal/frontendevents/analyticsevents/model/ProactiveCampaignAnalyticsDTO;", "getSuid", "getTimestamp", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProactiveMessageAnalyticsEvent.kt */
public final class ProactiveMessageAnalyticsEvent {
    private final String buid;
    private final String channel;
    private final String idempotencyToken;
    private final ProactiveCampaignAnalyticsDTO proactiveCampaign;
    private final String suid;
    private final String timestamp;
    private final String version;

    public static /* synthetic */ ProactiveMessageAnalyticsEvent copy$default(ProactiveMessageAnalyticsEvent proactiveMessageAnalyticsEvent, String str, String str2, String str3, String str4, String str5, String str6, ProactiveCampaignAnalyticsDTO proactiveCampaignAnalyticsDTO, int i, Object obj) {
        if ((i & 1) != 0) {
            str = proactiveMessageAnalyticsEvent.buid;
        }
        if ((i & 2) != 0) {
            str2 = proactiveMessageAnalyticsEvent.channel;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = proactiveMessageAnalyticsEvent.version;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = proactiveMessageAnalyticsEvent.timestamp;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = proactiveMessageAnalyticsEvent.suid;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = proactiveMessageAnalyticsEvent.idempotencyToken;
        }
        String str11 = str6;
        if ((i & 64) != 0) {
            proactiveCampaignAnalyticsDTO = proactiveMessageAnalyticsEvent.proactiveCampaign;
        }
        return proactiveMessageAnalyticsEvent.copy(str, str7, str8, str9, str10, str11, proactiveCampaignAnalyticsDTO);
    }

    public final String component1() {
        return this.buid;
    }

    public final String component2() {
        return this.channel;
    }

    public final String component3() {
        return this.version;
    }

    public final String component4() {
        return this.timestamp;
    }

    public final String component5() {
        return this.suid;
    }

    public final String component6() {
        return this.idempotencyToken;
    }

    public final ProactiveCampaignAnalyticsDTO component7() {
        return this.proactiveCampaign;
    }

    public final ProactiveMessageAnalyticsEvent copy(String str, String str2, String str3, String str4, String str5, String str6, ProactiveCampaignAnalyticsDTO proactiveCampaignAnalyticsDTO) {
        Intrinsics.checkNotNullParameter(str, "buid");
        Intrinsics.checkNotNullParameter(str2, "channel");
        Intrinsics.checkNotNullParameter(str3, "version");
        Intrinsics.checkNotNullParameter(str4, "timestamp");
        Intrinsics.checkNotNullParameter(str5, FrontendEventsStorage.KEY_SUID);
        Intrinsics.checkNotNullParameter(str6, "idempotencyToken");
        ProactiveCampaignAnalyticsDTO proactiveCampaignAnalyticsDTO2 = proactiveCampaignAnalyticsDTO;
        Intrinsics.checkNotNullParameter(proactiveCampaignAnalyticsDTO2, "proactiveCampaign");
        return new ProactiveMessageAnalyticsEvent(str, str2, str3, str4, str5, str6, proactiveCampaignAnalyticsDTO2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProactiveMessageAnalyticsEvent)) {
            return false;
        }
        ProactiveMessageAnalyticsEvent proactiveMessageAnalyticsEvent = (ProactiveMessageAnalyticsEvent) obj;
        return Intrinsics.areEqual((Object) this.buid, (Object) proactiveMessageAnalyticsEvent.buid) && Intrinsics.areEqual((Object) this.channel, (Object) proactiveMessageAnalyticsEvent.channel) && Intrinsics.areEqual((Object) this.version, (Object) proactiveMessageAnalyticsEvent.version) && Intrinsics.areEqual((Object) this.timestamp, (Object) proactiveMessageAnalyticsEvent.timestamp) && Intrinsics.areEqual((Object) this.suid, (Object) proactiveMessageAnalyticsEvent.suid) && Intrinsics.areEqual((Object) this.idempotencyToken, (Object) proactiveMessageAnalyticsEvent.idempotencyToken) && Intrinsics.areEqual((Object) this.proactiveCampaign, (Object) proactiveMessageAnalyticsEvent.proactiveCampaign);
    }

    public int hashCode() {
        return (((((((((((this.buid.hashCode() * 31) + this.channel.hashCode()) * 31) + this.version.hashCode()) * 31) + this.timestamp.hashCode()) * 31) + this.suid.hashCode()) * 31) + this.idempotencyToken.hashCode()) * 31) + this.proactiveCampaign.hashCode();
    }

    public String toString() {
        return "ProactiveMessageAnalyticsEvent(buid=" + this.buid + ", channel=" + this.channel + ", version=" + this.version + ", timestamp=" + this.timestamp + ", suid=" + this.suid + ", idempotencyToken=" + this.idempotencyToken + ", proactiveCampaign=" + this.proactiveCampaign + ')';
    }

    public ProactiveMessageAnalyticsEvent(String str, String str2, String str3, String str4, String str5, String str6, ProactiveCampaignAnalyticsDTO proactiveCampaignAnalyticsDTO) {
        Intrinsics.checkNotNullParameter(str, "buid");
        Intrinsics.checkNotNullParameter(str2, "channel");
        Intrinsics.checkNotNullParameter(str3, "version");
        Intrinsics.checkNotNullParameter(str4, "timestamp");
        Intrinsics.checkNotNullParameter(str5, FrontendEventsStorage.KEY_SUID);
        Intrinsics.checkNotNullParameter(str6, "idempotencyToken");
        Intrinsics.checkNotNullParameter(proactiveCampaignAnalyticsDTO, "proactiveCampaign");
        this.buid = str;
        this.channel = str2;
        this.version = str3;
        this.timestamp = str4;
        this.suid = str5;
        this.idempotencyToken = str6;
        this.proactiveCampaign = proactiveCampaignAnalyticsDTO;
    }

    public final String getBuid() {
        return this.buid;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final String getSuid() {
        return this.suid;
    }

    public final String getIdempotencyToken() {
        return this.idempotencyToken;
    }

    public final ProactiveCampaignAnalyticsDTO getProactiveCampaign() {
        return this.proactiveCampaign;
    }
}
