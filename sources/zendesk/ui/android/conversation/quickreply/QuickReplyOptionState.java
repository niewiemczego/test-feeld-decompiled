package zendesk.ui.android.conversation.quickreply;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u001dB'\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u000fJ\u000e\u0010\u0010\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÀ\u0003¢\u0006\u0004\b\u0013\u0010\tJ.\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001e"}, d2 = {"Lzendesk/ui/android/conversation/quickreply/QuickReplyOptionState;", "", "id", "", "text", "color", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getColor$zendesk_ui_ui_android", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId$zendesk_ui_ui_android", "()Ljava/lang/String;", "getText$zendesk_ui_ui_android", "component1", "component1$zendesk_ui_ui_android", "component2", "component2$zendesk_ui_ui_android", "component3", "component3$zendesk_ui_ui_android", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lzendesk/ui/android/conversation/quickreply/QuickReplyOptionState;", "equals", "", "other", "hashCode", "toBuilder", "Lzendesk/ui/android/conversation/quickreply/QuickReplyOptionState$Builder;", "toString", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: QuickReplyOptionState.kt */
public final class QuickReplyOptionState {
    private final Integer color;
    private final String id;
    private final String text;

    public QuickReplyOptionState() {
        this((String) null, (String) null, (Integer) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ QuickReplyOptionState copy$default(QuickReplyOptionState quickReplyOptionState, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = quickReplyOptionState.id;
        }
        if ((i & 2) != 0) {
            str2 = quickReplyOptionState.text;
        }
        if ((i & 4) != 0) {
            num = quickReplyOptionState.color;
        }
        return quickReplyOptionState.copy(str, str2, num);
    }

    public final String component1$zendesk_ui_ui_android() {
        return this.id;
    }

    public final String component2$zendesk_ui_ui_android() {
        return this.text;
    }

    public final Integer component3$zendesk_ui_ui_android() {
        return this.color;
    }

    public final QuickReplyOptionState copy(String str, String str2, Integer num) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "text");
        return new QuickReplyOptionState(str, str2, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuickReplyOptionState)) {
            return false;
        }
        QuickReplyOptionState quickReplyOptionState = (QuickReplyOptionState) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) quickReplyOptionState.id) && Intrinsics.areEqual((Object) this.text, (Object) quickReplyOptionState.text) && Intrinsics.areEqual((Object) this.color, (Object) quickReplyOptionState.color);
    }

    public int hashCode() {
        int hashCode = ((this.id.hashCode() * 31) + this.text.hashCode()) * 31;
        Integer num = this.color;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "QuickReplyOptionState(id=" + this.id + ", text=" + this.text + ", color=" + this.color + ')';
    }

    public QuickReplyOptionState(String str, String str2, Integer num) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "text");
        this.id = str;
        this.text = str2;
        this.color = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QuickReplyOptionState(String str, String str2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : num);
    }

    public final String getId$zendesk_ui_ui_android() {
        return this.id;
    }

    public final String getText$zendesk_ui_ui_android() {
        return this.text;
    }

    public final Integer getColor$zendesk_ui_ui_android() {
        return this.color;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0003J\u0010\u0010\u0007\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lzendesk/ui/android/conversation/quickreply/QuickReplyOptionState$Builder;", "", "state", "Lzendesk/ui/android/conversation/quickreply/QuickReplyOptionState;", "(Lzendesk/ui/android/conversation/quickreply/QuickReplyOptionState;)V", "()V", "build", "color", "", "setId", "id", "", "text", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: QuickReplyOptionState.kt */
    public static final class Builder {
        private QuickReplyOptionState state;

        public Builder() {
            this.state = new QuickReplyOptionState((String) null, (String) null, (Integer) null, 7, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(QuickReplyOptionState quickReplyOptionState) {
            this();
            Intrinsics.checkNotNullParameter(quickReplyOptionState, "state");
            this.state = quickReplyOptionState;
        }

        public final Builder setId(String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            Builder builder = this;
            this.state = QuickReplyOptionState.copy$default(this.state, str, (String) null, (Integer) null, 6, (Object) null);
            return this;
        }

        public final Builder text(String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            Builder builder = this;
            this.state = QuickReplyOptionState.copy$default(this.state, (String) null, str, (Integer) null, 5, (Object) null);
            return this;
        }

        public final Builder color(int i) {
            Builder builder = this;
            this.state = QuickReplyOptionState.copy$default(this.state, (String) null, (String) null, Integer.valueOf(i), 3, (Object) null);
            return this;
        }

        public final QuickReplyOptionState build() {
            return this.state;
        }
    }
}
