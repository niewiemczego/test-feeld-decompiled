package zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.jwt;

import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/jwt/ProactiveMessageResponse;", "", "campaign", "Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/jwt/ProactiveMessageCampaign;", "messages", "", "Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/jwt/ProactiveMessage;", "(Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/jwt/ProactiveMessageCampaign;Ljava/util/List;)V", "getCampaign", "()Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/jwt/ProactiveMessageCampaign;", "getMessages", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProactiveMessageResponse.kt */
public final class ProactiveMessageResponse {
    private final ProactiveMessageCampaign campaign;
    private final List<ProactiveMessage> messages;

    public static /* synthetic */ ProactiveMessageResponse copy$default(ProactiveMessageResponse proactiveMessageResponse, ProactiveMessageCampaign proactiveMessageCampaign, List<ProactiveMessage> list, int i, Object obj) {
        if ((i & 1) != 0) {
            proactiveMessageCampaign = proactiveMessageResponse.campaign;
        }
        if ((i & 2) != 0) {
            list = proactiveMessageResponse.messages;
        }
        return proactiveMessageResponse.copy(proactiveMessageCampaign, list);
    }

    public final ProactiveMessageCampaign component1() {
        return this.campaign;
    }

    public final List<ProactiveMessage> component2() {
        return this.messages;
    }

    public final ProactiveMessageResponse copy(ProactiveMessageCampaign proactiveMessageCampaign, List<ProactiveMessage> list) {
        Intrinsics.checkNotNullParameter(proactiveMessageCampaign, "campaign");
        Intrinsics.checkNotNullParameter(list, "messages");
        return new ProactiveMessageResponse(proactiveMessageCampaign, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProactiveMessageResponse)) {
            return false;
        }
        ProactiveMessageResponse proactiveMessageResponse = (ProactiveMessageResponse) obj;
        return Intrinsics.areEqual((Object) this.campaign, (Object) proactiveMessageResponse.campaign) && Intrinsics.areEqual((Object) this.messages, (Object) proactiveMessageResponse.messages);
    }

    public int hashCode() {
        return (this.campaign.hashCode() * 31) + this.messages.hashCode();
    }

    public String toString() {
        return "ProactiveMessageResponse(campaign=" + this.campaign + ", messages=" + this.messages + ')';
    }

    public ProactiveMessageResponse(ProactiveMessageCampaign proactiveMessageCampaign, List<ProactiveMessage> list) {
        Intrinsics.checkNotNullParameter(proactiveMessageCampaign, "campaign");
        Intrinsics.checkNotNullParameter(list, "messages");
        this.campaign = proactiveMessageCampaign;
        this.messages = list;
    }

    public final ProactiveMessageCampaign getCampaign() {
        return this.campaign;
    }

    public final List<ProactiveMessage> getMessages() {
        return this.messages;
    }
}
