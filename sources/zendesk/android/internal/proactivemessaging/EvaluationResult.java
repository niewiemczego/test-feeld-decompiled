package zendesk.android.internal.proactivemessaging;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.internal.proactivemessaging.model.Campaign;
import zendesk.android.internal.proactivemessaging.model.Path;
import zendesk.android.pageviewevents.PageView;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lzendesk/android/internal/proactivemessaging/EvaluationResult;", "", "campaign", "Lzendesk/android/internal/proactivemessaging/model/Campaign;", "successfulPaths", "", "Lzendesk/android/internal/proactivemessaging/model/Path;", "event", "Lzendesk/android/pageviewevents/PageView;", "(Lzendesk/android/internal/proactivemessaging/model/Campaign;Ljava/util/List;Lzendesk/android/pageviewevents/PageView;)V", "getCampaign", "()Lzendesk/android/internal/proactivemessaging/model/Campaign;", "getEvent", "()Lzendesk/android/pageviewevents/PageView;", "getSuccessfulPaths", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EvaluationResult.kt */
public final class EvaluationResult {
    private final Campaign campaign;
    private final PageView event;
    private final List<Path> successfulPaths;

    public static /* synthetic */ EvaluationResult copy$default(EvaluationResult evaluationResult, Campaign campaign2, List<Path> list, PageView pageView, int i, Object obj) {
        if ((i & 1) != 0) {
            campaign2 = evaluationResult.campaign;
        }
        if ((i & 2) != 0) {
            list = evaluationResult.successfulPaths;
        }
        if ((i & 4) != 0) {
            pageView = evaluationResult.event;
        }
        return evaluationResult.copy(campaign2, list, pageView);
    }

    public final Campaign component1() {
        return this.campaign;
    }

    public final List<Path> component2() {
        return this.successfulPaths;
    }

    public final PageView component3() {
        return this.event;
    }

    public final EvaluationResult copy(Campaign campaign2, List<Path> list, PageView pageView) {
        Intrinsics.checkNotNullParameter(campaign2, "campaign");
        Intrinsics.checkNotNullParameter(list, "successfulPaths");
        Intrinsics.checkNotNullParameter(pageView, "event");
        return new EvaluationResult(campaign2, list, pageView);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EvaluationResult)) {
            return false;
        }
        EvaluationResult evaluationResult = (EvaluationResult) obj;
        return Intrinsics.areEqual((Object) this.campaign, (Object) evaluationResult.campaign) && Intrinsics.areEqual((Object) this.successfulPaths, (Object) evaluationResult.successfulPaths) && Intrinsics.areEqual((Object) this.event, (Object) evaluationResult.event);
    }

    public int hashCode() {
        return (((this.campaign.hashCode() * 31) + this.successfulPaths.hashCode()) * 31) + this.event.hashCode();
    }

    public String toString() {
        return "EvaluationResult(campaign=" + this.campaign + ", successfulPaths=" + this.successfulPaths + ", event=" + this.event + ')';
    }

    public EvaluationResult(Campaign campaign2, List<Path> list, PageView pageView) {
        Intrinsics.checkNotNullParameter(campaign2, "campaign");
        Intrinsics.checkNotNullParameter(list, "successfulPaths");
        Intrinsics.checkNotNullParameter(pageView, "event");
        this.campaign = campaign2;
        this.successfulPaths = list;
        this.event = pageView;
    }

    public final Campaign getCampaign() {
        return this.campaign;
    }

    public final List<Path> getSuccessfulPaths() {
        return this.successfulPaths;
    }

    public final PageView getEvent() {
        return this.event;
    }
}
