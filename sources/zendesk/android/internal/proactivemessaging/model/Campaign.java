package zendesk.android.internal.proactivemessaging.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import io.sentry.MonitorConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.pageviewevents.PageView;
import zendesk.conversationkit.android.model.VisitType;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\t\u0010&\u001a\u00020\u0010HÆ\u0003JU\u0010'\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J$\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201J\t\u00102\u001a\u00020\u0010HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00064"}, d2 = {"Lzendesk/android/internal/proactivemessaging/model/Campaign;", "", "campaignId", "", "integration", "Lzendesk/android/internal/proactivemessaging/model/Integration;", "trigger", "Lzendesk/android/internal/proactivemessaging/model/Trigger;", "schedule", "Lzendesk/android/internal/proactivemessaging/model/Schedule;", "status", "Lzendesk/android/internal/proactivemessaging/model/Status;", "paths", "", "Lzendesk/android/internal/proactivemessaging/model/Path;", "version", "", "(Ljava/lang/String;Lzendesk/android/internal/proactivemessaging/model/Integration;Lzendesk/android/internal/proactivemessaging/model/Trigger;Lzendesk/android/internal/proactivemessaging/model/Schedule;Lzendesk/android/internal/proactivemessaging/model/Status;Ljava/util/List;I)V", "getCampaignId", "()Ljava/lang/String;", "getIntegration", "()Lzendesk/android/internal/proactivemessaging/model/Integration;", "getPaths", "()Ljava/util/List;", "getSchedule", "()Lzendesk/android/internal/proactivemessaging/model/Schedule;", "getStatus", "()Lzendesk/android/internal/proactivemessaging/model/Status;", "getTrigger", "()Lzendesk/android/internal/proactivemessaging/model/Trigger;", "getVersion", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "evaluate", "event", "Lzendesk/android/pageviewevents/PageView;", "locale", "Ljava/util/Locale;", "visitType", "Lzendesk/conversationkit/android/model/VisitType;", "hashCode", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Campaign.kt */
public final class Campaign {
    private final String campaignId;
    private final Integration integration;
    private final List<Path> paths;
    private final Schedule schedule;
    private final Status status;
    private final Trigger trigger;
    private final int version;

    public static /* synthetic */ Campaign copy$default(Campaign campaign, String str, Integration integration2, Trigger trigger2, Schedule schedule2, Status status2, List<Path> list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = campaign.campaignId;
        }
        if ((i2 & 2) != 0) {
            integration2 = campaign.integration;
        }
        Integration integration3 = integration2;
        if ((i2 & 4) != 0) {
            trigger2 = campaign.trigger;
        }
        Trigger trigger3 = trigger2;
        if ((i2 & 8) != 0) {
            schedule2 = campaign.schedule;
        }
        Schedule schedule3 = schedule2;
        if ((i2 & 16) != 0) {
            status2 = campaign.status;
        }
        Status status3 = status2;
        if ((i2 & 32) != 0) {
            list = campaign.paths;
        }
        List<Path> list2 = list;
        if ((i2 & 64) != 0) {
            i = campaign.version;
        }
        return campaign.copy(str, integration3, trigger3, schedule3, status3, list2, i);
    }

    public final String component1() {
        return this.campaignId;
    }

    public final Integration component2() {
        return this.integration;
    }

    public final Trigger component3() {
        return this.trigger;
    }

    public final Schedule component4() {
        return this.schedule;
    }

    public final Status component5() {
        return this.status;
    }

    public final List<Path> component6() {
        return this.paths;
    }

    public final int component7() {
        return this.version;
    }

    public final Campaign copy(@Json(name = "campaign_id") String str, Integration integration2, @Json(name = "when") Trigger trigger2, Schedule schedule2, Status status2, List<Path> list, int i) {
        Intrinsics.checkNotNullParameter(str, "campaignId");
        Intrinsics.checkNotNullParameter(integration2, "integration");
        Intrinsics.checkNotNullParameter(trigger2, "trigger");
        Intrinsics.checkNotNullParameter(schedule2, MonitorConfig.JsonKeys.SCHEDULE);
        Intrinsics.checkNotNullParameter(status2, "status");
        Intrinsics.checkNotNullParameter(list, "paths");
        return new Campaign(str, integration2, trigger2, schedule2, status2, list, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Campaign)) {
            return false;
        }
        Campaign campaign = (Campaign) obj;
        return Intrinsics.areEqual((Object) this.campaignId, (Object) campaign.campaignId) && Intrinsics.areEqual((Object) this.integration, (Object) campaign.integration) && Intrinsics.areEqual((Object) this.trigger, (Object) campaign.trigger) && Intrinsics.areEqual((Object) this.schedule, (Object) campaign.schedule) && this.status == campaign.status && Intrinsics.areEqual((Object) this.paths, (Object) campaign.paths) && this.version == campaign.version;
    }

    public int hashCode() {
        return (((((((((((this.campaignId.hashCode() * 31) + this.integration.hashCode()) * 31) + this.trigger.hashCode()) * 31) + this.schedule.hashCode()) * 31) + this.status.hashCode()) * 31) + this.paths.hashCode()) * 31) + Integer.hashCode(this.version);
    }

    public String toString() {
        return "Campaign(campaignId=" + this.campaignId + ", integration=" + this.integration + ", trigger=" + this.trigger + ", schedule=" + this.schedule + ", status=" + this.status + ", paths=" + this.paths + ", version=" + this.version + ')';
    }

    public Campaign(@Json(name = "campaign_id") String str, Integration integration2, @Json(name = "when") Trigger trigger2, Schedule schedule2, Status status2, List<Path> list, int i) {
        Intrinsics.checkNotNullParameter(str, "campaignId");
        Intrinsics.checkNotNullParameter(integration2, "integration");
        Intrinsics.checkNotNullParameter(trigger2, "trigger");
        Intrinsics.checkNotNullParameter(schedule2, MonitorConfig.JsonKeys.SCHEDULE);
        Intrinsics.checkNotNullParameter(status2, "status");
        Intrinsics.checkNotNullParameter(list, "paths");
        this.campaignId = str;
        this.integration = integration2;
        this.trigger = trigger2;
        this.schedule = schedule2;
        this.status = status2;
        this.paths = list;
        this.version = i;
    }

    public final String getCampaignId() {
        return this.campaignId;
    }

    public final Integration getIntegration() {
        return this.integration;
    }

    public final Trigger getTrigger() {
        return this.trigger;
    }

    public final Schedule getSchedule() {
        return this.schedule;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final List<Path> getPaths() {
        return this.paths;
    }

    public final int getVersion() {
        return this.version;
    }

    public final List<Path> evaluate(PageView pageView, Locale locale, VisitType visitType) {
        boolean z;
        Intrinsics.checkNotNullParameter(pageView, "event");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(visitType, "visitType");
        List<Path> arrayList = new ArrayList<>();
        for (Path path : this.paths) {
            Iterator it = path.getCondition().getExpressions().iterator();
            while (true) {
                z = true;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Expression expression = (Expression) it.next();
                    if (!z || !expression.evaluate$zendesk_zendesk_android(pageView, locale, visitType)) {
                        z = false;
                    }
                }
            }
            if (z) {
                arrayList.add(path);
            }
        }
        return arrayList;
    }
}
