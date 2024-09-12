package zendesk.ui.android.conversation.quickreply;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0011\u001a\u00020\u0004R(\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0004\u0018\u0001`\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lzendesk/ui/android/conversation/quickreply/QuickReplyRendering;", "", "()V", "builder", "Lzendesk/ui/android/conversation/quickreply/QuickReplyRendering$Builder;", "(Lzendesk/ui/android/conversation/quickreply/QuickReplyRendering$Builder;)V", "onOptionClicked", "Lkotlin/Function1;", "Lzendesk/ui/android/conversation/quickreply/QuickReplyOption;", "", "Lzendesk/ui/android/conversation/quickreply/OnQuickReplyClickLambda;", "getOnOptionClicked$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function1;", "state", "Lzendesk/ui/android/conversation/quickreply/QuickReplyState;", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/quickreply/QuickReplyState;", "toBuilder", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: QuickReplyRendering.kt */
public final class QuickReplyRendering {
    private final Function1<QuickReplyOption, Unit> onOptionClicked;
    private final QuickReplyState state;

    public QuickReplyRendering(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.onOptionClicked = builder.getOnOptionClicked$zendesk_ui_ui_android();
        this.state = builder.getState$zendesk_ui_ui_android();
    }

    public final Function1<QuickReplyOption, Unit> getOnOptionClicked$zendesk_ui_ui_android() {
        return this.onOptionClicked;
    }

    public final QuickReplyState getState$zendesk_ui_ui_android() {
        return this.state;
    }

    public QuickReplyRendering() {
        this(new Builder());
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0015\u001a\u00020\u0003J\"\u0010\u0006\u001a\u00020\u00002\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0004\u0018\u0001`\nJ\u001a\u0010\u000f\u001a\u00020\u00002\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0007R.\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007j\u0004\u0018\u0001`\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lzendesk/ui/android/conversation/quickreply/QuickReplyRendering$Builder;", "", "rendering", "Lzendesk/ui/android/conversation/quickreply/QuickReplyRendering;", "(Lzendesk/ui/android/conversation/quickreply/QuickReplyRendering;)V", "()V", "onOptionClicked", "Lkotlin/Function1;", "Lzendesk/ui/android/conversation/quickreply/QuickReplyOption;", "", "Lzendesk/ui/android/conversation/quickreply/OnQuickReplyClickLambda;", "getOnOptionClicked$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function1;", "setOnOptionClicked$zendesk_ui_ui_android", "(Lkotlin/jvm/functions/Function1;)V", "state", "Lzendesk/ui/android/conversation/quickreply/QuickReplyState;", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/quickreply/QuickReplyState;", "setState$zendesk_ui_ui_android", "(Lzendesk/ui/android/conversation/quickreply/QuickReplyState;)V", "build", "stateUpdate", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: QuickReplyRendering.kt */
    public static final class Builder {
        private Function1<? super QuickReplyOption, Unit> onOptionClicked;
        private QuickReplyState state;

        public Builder() {
            this.state = new QuickReplyState((List) null, (Integer) null, 3, (DefaultConstructorMarker) null);
        }

        public final Function1<QuickReplyOption, Unit> getOnOptionClicked$zendesk_ui_ui_android() {
            return this.onOptionClicked;
        }

        public final void setOnOptionClicked$zendesk_ui_ui_android(Function1<? super QuickReplyOption, Unit> function1) {
            this.onOptionClicked = function1;
        }

        public final QuickReplyState getState$zendesk_ui_ui_android() {
            return this.state;
        }

        public final void setState$zendesk_ui_ui_android(QuickReplyState quickReplyState) {
            Intrinsics.checkNotNullParameter(quickReplyState, "<set-?>");
            this.state = quickReplyState;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(QuickReplyRendering quickReplyRendering) {
            this();
            Intrinsics.checkNotNullParameter(quickReplyRendering, "rendering");
            this.onOptionClicked = quickReplyRendering.getOnOptionClicked$zendesk_ui_ui_android();
            this.state = quickReplyRendering.getState$zendesk_ui_ui_android();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(QuickReplyRendering quickReplyRendering, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new QuickReplyRendering() : quickReplyRendering);
        }

        public final Builder onOptionClicked(Function1<? super QuickReplyOption, Unit> function1) {
            Builder builder = this;
            this.onOptionClicked = function1;
            return this;
        }

        public final Builder state(Function1<? super QuickReplyState, QuickReplyState> function1) {
            Intrinsics.checkNotNullParameter(function1, "stateUpdate");
            Builder builder = this;
            this.state = function1.invoke(this.state);
            return this;
        }

        public final QuickReplyRendering build() {
            return new QuickReplyRendering(this);
        }
    }
}
