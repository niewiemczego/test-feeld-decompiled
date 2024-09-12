package zendesk.ui.android.conversation.quickreply;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001bB#\b\u0000\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÀ\u0003¢\u0006\u0002\b\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÀ\u0003¢\u0006\u0004\b\u0010\u0010\tJ*\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lzendesk/ui/android/conversation/quickreply/QuickReplyState;", "", "quickReplyOptions", "", "Lzendesk/ui/android/conversation/quickreply/QuickReplyOption;", "color", "", "(Ljava/util/List;Ljava/lang/Integer;)V", "getColor$zendesk_ui_ui_android", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getQuickReplyOptions$zendesk_ui_ui_android", "()Ljava/util/List;", "component1", "component1$zendesk_ui_ui_android", "component2", "component2$zendesk_ui_ui_android", "copy", "(Ljava/util/List;Ljava/lang/Integer;)Lzendesk/ui/android/conversation/quickreply/QuickReplyState;", "equals", "", "other", "hashCode", "toBuilder", "Lzendesk/ui/android/conversation/quickreply/QuickReplyState$Builder;", "toString", "", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: QuickReplyState.kt */
public final class QuickReplyState {
    private final Integer color;
    private final List<QuickReplyOption> quickReplyOptions;

    public QuickReplyState() {
        this((List) null, (Integer) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ QuickReplyState copy$default(QuickReplyState quickReplyState, List<QuickReplyOption> list, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            list = quickReplyState.quickReplyOptions;
        }
        if ((i & 2) != 0) {
            num = quickReplyState.color;
        }
        return quickReplyState.copy(list, num);
    }

    public final List<QuickReplyOption> component1$zendesk_ui_ui_android() {
        return this.quickReplyOptions;
    }

    public final Integer component2$zendesk_ui_ui_android() {
        return this.color;
    }

    public final QuickReplyState copy(List<QuickReplyOption> list, Integer num) {
        Intrinsics.checkNotNullParameter(list, "quickReplyOptions");
        return new QuickReplyState(list, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuickReplyState)) {
            return false;
        }
        QuickReplyState quickReplyState = (QuickReplyState) obj;
        return Intrinsics.areEqual((Object) this.quickReplyOptions, (Object) quickReplyState.quickReplyOptions) && Intrinsics.areEqual((Object) this.color, (Object) quickReplyState.color);
    }

    public int hashCode() {
        int hashCode = this.quickReplyOptions.hashCode() * 31;
        Integer num = this.color;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "QuickReplyState(quickReplyOptions=" + this.quickReplyOptions + ", color=" + this.color + ')';
    }

    public QuickReplyState(List<QuickReplyOption> list, Integer num) {
        Intrinsics.checkNotNullParameter(list, "quickReplyOptions");
        this.quickReplyOptions = list;
        this.color = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QuickReplyState(List list, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : num);
    }

    public final List<QuickReplyOption> getQuickReplyOptions$zendesk_ui_ui_android() {
        return this.quickReplyOptions;
    }

    public final Integer getColor$zendesk_ui_ui_android() {
        return this.color;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0003J\u0010\u0010\u0007\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\bJ\u0014\u0010\t\u001a\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lzendesk/ui/android/conversation/quickreply/QuickReplyState$Builder;", "", "state", "Lzendesk/ui/android/conversation/quickreply/QuickReplyState;", "(Lzendesk/ui/android/conversation/quickreply/QuickReplyState;)V", "()V", "build", "color", "", "quickReplyOptions", "", "Lzendesk/ui/android/conversation/quickreply/QuickReplyOption;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: QuickReplyState.kt */
    public static final class Builder {
        private QuickReplyState state;

        public Builder() {
            this.state = new QuickReplyState((List) null, (Integer) null, 3, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(QuickReplyState quickReplyState) {
            this();
            Intrinsics.checkNotNullParameter(quickReplyState, "state");
            this.state = quickReplyState;
        }

        public final Builder quickReplyOptions(List<QuickReplyOption> list) {
            Intrinsics.checkNotNullParameter(list, "quickReplyOptions");
            Builder builder = this;
            this.state = QuickReplyState.copy$default(this.state, list, (Integer) null, 2, (Object) null);
            return this;
        }

        public final Builder color(int i) {
            Builder builder = this;
            this.state = QuickReplyState.copy$default(this.state, (List) null, Integer.valueOf(i), 1, (Object) null);
            return this;
        }

        public final QuickReplyState build() {
            return this.state;
        }
    }
}
