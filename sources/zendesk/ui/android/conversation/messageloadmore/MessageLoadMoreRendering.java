package zendesk.ui.android.conversation.messageloadmore;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.conversation.messageloadmore.MessageLoadMoreState;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0004R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreRendering;", "", "()V", "builder", "Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreRendering$Builder;", "(Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreRendering$Builder;)V", "onRetryClicked", "Lkotlin/Function0;", "", "getOnRetryClicked$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function0;", "state", "Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreState;", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreState;", "toBuilder", "Builder", "Companion", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLoadMoreRendering.kt */
public final class MessageLoadMoreRendering {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String LOG_TAG = "MessageLoadMoreRendering";
    private final Function0<Unit> onRetryClicked;
    private final MessageLoadMoreState state;

    public MessageLoadMoreRendering(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.onRetryClicked = builder.getOnRetryClicked$zendesk_ui_ui_android();
        this.state = builder.getState$zendesk_ui_ui_android();
    }

    public final Function0<Unit> getOnRetryClicked$zendesk_ui_ui_android() {
        return this.onRetryClicked;
    }

    public final MessageLoadMoreState getState$zendesk_ui_ui_android() {
        return this.state;
    }

    public MessageLoadMoreRendering() {
        this(new Builder());
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0013\u001a\u00020\u0003J\u0014\u0010\u0006\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u001a\u0010\r\u001a\u00020\u00002\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0015R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreRendering$Builder;", "", "rendering", "Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreRendering;", "(Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreRendering;)V", "()V", "onRetryClicked", "Lkotlin/Function0;", "", "getOnRetryClicked$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function0;", "setOnRetryClicked$zendesk_ui_ui_android", "(Lkotlin/jvm/functions/Function0;)V", "state", "Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreState;", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreState;", "setState$zendesk_ui_ui_android", "(Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreState;)V", "build", "stateUpdate", "Lkotlin/Function1;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageLoadMoreRendering.kt */
    public static final class Builder {
        private Function0<Unit> onRetryClicked;
        private MessageLoadMoreState state;

        public Builder() {
            this.onRetryClicked = MessageLoadMoreRendering$Builder$onRetryClicked$1.INSTANCE;
            this.state = new MessageLoadMoreState((String) null, (Integer) null, (Integer) null, (MessageLoadMoreState.MessageLoadMoreStatus) null, 15, (DefaultConstructorMarker) null);
        }

        public final Function0<Unit> getOnRetryClicked$zendesk_ui_ui_android() {
            return this.onRetryClicked;
        }

        public final void setOnRetryClicked$zendesk_ui_ui_android(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "<set-?>");
            this.onRetryClicked = function0;
        }

        public final MessageLoadMoreState getState$zendesk_ui_ui_android() {
            return this.state;
        }

        public final void setState$zendesk_ui_ui_android(MessageLoadMoreState messageLoadMoreState) {
            Intrinsics.checkNotNullParameter(messageLoadMoreState, "<set-?>");
            this.state = messageLoadMoreState;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(MessageLoadMoreRendering messageLoadMoreRendering) {
            this();
            Intrinsics.checkNotNullParameter(messageLoadMoreRendering, "rendering");
            this.onRetryClicked = messageLoadMoreRendering.getOnRetryClicked$zendesk_ui_ui_android();
            this.state = messageLoadMoreRendering.getState$zendesk_ui_ui_android();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(MessageLoadMoreRendering messageLoadMoreRendering, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new MessageLoadMoreRendering() : messageLoadMoreRendering);
        }

        public final Builder onRetryClicked(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "onRetryClicked");
            Builder builder = this;
            this.onRetryClicked = function0;
            return this;
        }

        public final Builder state(Function1<? super MessageLoadMoreState, MessageLoadMoreState> function1) {
            Intrinsics.checkNotNullParameter(function1, "stateUpdate");
            Builder builder = this;
            this.state = function1.invoke(this.state);
            return this;
        }

        public final MessageLoadMoreRendering build() {
            return new MessageLoadMoreRendering(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreRendering$Companion;", "", "()V", "LOG_TAG", "", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageLoadMoreRendering.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
