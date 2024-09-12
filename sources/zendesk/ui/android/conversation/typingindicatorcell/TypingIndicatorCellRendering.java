package zendesk.ui.android.conversation.typingindicatorcell;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\n\u001a\u00020\u0004R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lzendesk/ui/android/conversation/typingindicatorcell/TypingIndicatorCellRendering;", "", "()V", "builder", "Lzendesk/ui/android/conversation/typingindicatorcell/TypingIndicatorCellRendering$Builder;", "(Lzendesk/ui/android/conversation/typingindicatorcell/TypingIndicatorCellRendering$Builder;)V", "state", "Lzendesk/ui/android/conversation/typingindicatorcell/TypingIndicatorCellState;", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/typingindicatorcell/TypingIndicatorCellState;", "toBuilder", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TypingIndicatorCellRendering.kt */
public final class TypingIndicatorCellRendering {
    private final TypingIndicatorCellState state;

    public TypingIndicatorCellRendering(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.state = builder.getState$zendesk_ui_ui_android();
    }

    public final TypingIndicatorCellState getState$zendesk_ui_ui_android() {
        return this.state;
    }

    public TypingIndicatorCellRendering() {
        this(new Builder());
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\f\u001a\u00020\u0003J\u001a\u0010\u0006\u001a\u00020\u00002\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lzendesk/ui/android/conversation/typingindicatorcell/TypingIndicatorCellRendering$Builder;", "", "rendering", "Lzendesk/ui/android/conversation/typingindicatorcell/TypingIndicatorCellRendering;", "(Lzendesk/ui/android/conversation/typingindicatorcell/TypingIndicatorCellRendering;)V", "()V", "state", "Lzendesk/ui/android/conversation/typingindicatorcell/TypingIndicatorCellState;", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/typingindicatorcell/TypingIndicatorCellState;", "setState$zendesk_ui_ui_android", "(Lzendesk/ui/android/conversation/typingindicatorcell/TypingIndicatorCellState;)V", "build", "stateUpdate", "Lkotlin/Function1;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TypingIndicatorCellRendering.kt */
    public static final class Builder {
        private TypingIndicatorCellState state;

        public Builder() {
            this.state = new TypingIndicatorCellState((Integer) null, 1, (DefaultConstructorMarker) null);
        }

        public final TypingIndicatorCellState getState$zendesk_ui_ui_android() {
            return this.state;
        }

        public final void setState$zendesk_ui_ui_android(TypingIndicatorCellState typingIndicatorCellState) {
            Intrinsics.checkNotNullParameter(typingIndicatorCellState, "<set-?>");
            this.state = typingIndicatorCellState;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(TypingIndicatorCellRendering typingIndicatorCellRendering) {
            this();
            Intrinsics.checkNotNullParameter(typingIndicatorCellRendering, "rendering");
            this.state = typingIndicatorCellRendering.getState$zendesk_ui_ui_android();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(TypingIndicatorCellRendering typingIndicatorCellRendering, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new TypingIndicatorCellRendering() : typingIndicatorCellRendering);
        }

        public final Builder state(Function1<? super TypingIndicatorCellState, TypingIndicatorCellState> function1) {
            Intrinsics.checkNotNullParameter(function1, "stateUpdate");
            Builder builder = this;
            this.state = function1.invoke(this.state);
            return this;
        }

        public final TypingIndicatorCellRendering build() {
            return new TypingIndicatorCellRendering(this);
        }
    }
}
