package zendesk.ui.android.conversation.typingindicatorcell;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u0013\b\u0000\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0004\b\t\u0010\u0006J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lzendesk/ui/android/conversation/typingindicatorcell/TypingIndicatorCellState;", "", "backgroundColor", "", "(Ljava/lang/Integer;)V", "getBackgroundColor$zendesk_ui_ui_android", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component1$zendesk_ui_ui_android", "copy", "(Ljava/lang/Integer;)Lzendesk/ui/android/conversation/typingindicatorcell/TypingIndicatorCellState;", "equals", "", "other", "hashCode", "toBuilder", "Lzendesk/ui/android/conversation/typingindicatorcell/TypingIndicatorCellState$Builder;", "toString", "", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TypingIndicatorCellState.kt */
public final class TypingIndicatorCellState {
    private final Integer backgroundColor;

    public TypingIndicatorCellState() {
        this((Integer) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TypingIndicatorCellState copy$default(TypingIndicatorCellState typingIndicatorCellState, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = typingIndicatorCellState.backgroundColor;
        }
        return typingIndicatorCellState.copy(num);
    }

    public final Integer component1$zendesk_ui_ui_android() {
        return this.backgroundColor;
    }

    public final TypingIndicatorCellState copy(Integer num) {
        return new TypingIndicatorCellState(num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TypingIndicatorCellState) && Intrinsics.areEqual((Object) this.backgroundColor, (Object) ((TypingIndicatorCellState) obj).backgroundColor);
    }

    public int hashCode() {
        Integer num = this.backgroundColor;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public String toString() {
        return "TypingIndicatorCellState(backgroundColor=" + this.backgroundColor + ')';
    }

    public TypingIndicatorCellState(Integer num) {
        this.backgroundColor = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TypingIndicatorCellState(Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num);
    }

    public final Integer getBackgroundColor$zendesk_ui_ui_android() {
        return this.backgroundColor;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lzendesk/ui/android/conversation/typingindicatorcell/TypingIndicatorCellState$Builder;", "", "state", "Lzendesk/ui/android/conversation/typingindicatorcell/TypingIndicatorCellState;", "(Lzendesk/ui/android/conversation/typingindicatorcell/TypingIndicatorCellState;)V", "()V", "backgroundColor", "color", "", "build", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TypingIndicatorCellState.kt */
    public static final class Builder {
        private TypingIndicatorCellState state;

        public Builder() {
            this.state = new TypingIndicatorCellState((Integer) null, 1, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(TypingIndicatorCellState typingIndicatorCellState) {
            this();
            Intrinsics.checkNotNullParameter(typingIndicatorCellState, "state");
            this.state = typingIndicatorCellState;
        }

        public final Builder backgroundColor(int i) {
            Builder builder = this;
            this.state = this.state.copy(Integer.valueOf(i));
            return this;
        }

        public final TypingIndicatorCellState build() {
            return this.state;
        }
    }
}
