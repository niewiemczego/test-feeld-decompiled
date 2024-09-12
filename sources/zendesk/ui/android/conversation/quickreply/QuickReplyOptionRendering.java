package zendesk.ui.android.conversation.quickreply;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0015\u001a\u00020\u0004RL\u0010\u0006\u001a:\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007j\u0004\u0018\u0001`\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lzendesk/ui/android/conversation/quickreply/QuickReplyOptionRendering;", "", "()V", "builder", "Lzendesk/ui/android/conversation/quickreply/QuickReplyOptionRendering$Builder;", "(Lzendesk/ui/android/conversation/quickreply/QuickReplyOptionRendering$Builder;)V", "onOptionClicked", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "quickReplyOptionId", "quickReplyOptionText", "", "Lzendesk/ui/android/conversation/quickreply/OnQuickReplyOptionClickLambda;", "getOnOptionClicked$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function2;", "state", "Lzendesk/ui/android/conversation/quickreply/QuickReplyOptionState;", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/quickreply/QuickReplyOptionState;", "toBuilder", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: QuickReplyOptionRendering.kt */
public final class QuickReplyOptionRendering {
    private final Function2<String, String, Unit> onOptionClicked;
    private final QuickReplyOptionState state;

    public QuickReplyOptionRendering(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.onOptionClicked = builder.getOnOptionClicked$zendesk_ui_ui_android();
        this.state = builder.getState$zendesk_ui_ui_android();
    }

    public final Function2<String, String, Unit> getOnOptionClicked$zendesk_ui_ui_android() {
        return this.onOptionClicked;
    }

    public final QuickReplyOptionState getState$zendesk_ui_ui_android() {
        return this.state;
    }

    public QuickReplyOptionRendering() {
        this(new Builder());
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0019\u001a\u00020\u0003JF\u0010\u0006\u001a\u00020\u00002>\u0010\u0006\u001a:\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007j\u0004\u0018\u0001`\u000eJ\u001a\u0010\u0013\u001a\u00020\u00002\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u001bRR\u0010\u0006\u001a:\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007j\u0004\u0018\u0001`\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lzendesk/ui/android/conversation/quickreply/QuickReplyOptionRendering$Builder;", "", "rendering", "Lzendesk/ui/android/conversation/quickreply/QuickReplyOptionRendering;", "(Lzendesk/ui/android/conversation/quickreply/QuickReplyOptionRendering;)V", "()V", "onOptionClicked", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "quickReplyOptionId", "quickReplyOptionText", "", "Lzendesk/ui/android/conversation/quickreply/OnQuickReplyOptionClickLambda;", "getOnOptionClicked$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function2;", "setOnOptionClicked$zendesk_ui_ui_android", "(Lkotlin/jvm/functions/Function2;)V", "state", "Lzendesk/ui/android/conversation/quickreply/QuickReplyOptionState;", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/quickreply/QuickReplyOptionState;", "setState$zendesk_ui_ui_android", "(Lzendesk/ui/android/conversation/quickreply/QuickReplyOptionState;)V", "build", "stateUpdate", "Lkotlin/Function1;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: QuickReplyOptionRendering.kt */
    public static final class Builder {
        private Function2<? super String, ? super String, Unit> onOptionClicked;
        private QuickReplyOptionState state;

        public Builder() {
            this.state = new QuickReplyOptionState((String) null, (String) null, (Integer) null, 7, (DefaultConstructorMarker) null);
        }

        public final Function2<String, String, Unit> getOnOptionClicked$zendesk_ui_ui_android() {
            return this.onOptionClicked;
        }

        public final void setOnOptionClicked$zendesk_ui_ui_android(Function2<? super String, ? super String, Unit> function2) {
            this.onOptionClicked = function2;
        }

        public final QuickReplyOptionState getState$zendesk_ui_ui_android() {
            return this.state;
        }

        public final void setState$zendesk_ui_ui_android(QuickReplyOptionState quickReplyOptionState) {
            Intrinsics.checkNotNullParameter(quickReplyOptionState, "<set-?>");
            this.state = quickReplyOptionState;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(QuickReplyOptionRendering quickReplyOptionRendering) {
            this();
            Intrinsics.checkNotNullParameter(quickReplyOptionRendering, "rendering");
            this.onOptionClicked = quickReplyOptionRendering.getOnOptionClicked$zendesk_ui_ui_android();
            this.state = quickReplyOptionRendering.getState$zendesk_ui_ui_android();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(QuickReplyOptionRendering quickReplyOptionRendering, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new QuickReplyOptionRendering() : quickReplyOptionRendering);
        }

        public final Builder onOptionClicked(Function2<? super String, ? super String, Unit> function2) {
            Builder builder = this;
            this.onOptionClicked = function2;
            return this;
        }

        public final Builder state(Function1<? super QuickReplyOptionState, QuickReplyOptionState> function1) {
            Intrinsics.checkNotNullParameter(function1, "stateUpdate");
            Builder builder = this;
            this.state = function1.invoke(this.state);
            return this;
        }

        public final QuickReplyOptionRendering build() {
            return new QuickReplyOptionRendering(this);
        }
    }
}
