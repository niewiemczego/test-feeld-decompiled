package zendesk.ui.android.conversation.textcell;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0016\u001a\u00020\u0004R&\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lzendesk/ui/android/conversation/textcell/TextCellRendering;", "", "()V", "builder", "Lzendesk/ui/android/conversation/textcell/TextCellRendering$Builder;", "(Lzendesk/ui/android/conversation/textcell/TextCellRendering$Builder;)V", "onActionButtonClicked", "Lkotlin/Function2;", "", "", "getOnActionButtonClicked$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function2;", "onCellClicked", "Lkotlin/Function1;", "getOnCellClicked$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function1;", "onCellTextClicked", "getOnCellTextClicked$zendesk_ui_ui_android", "state", "Lzendesk/ui/android/conversation/textcell/TextCellState;", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/textcell/TextCellState;", "toBuilder", "Builder", "Companion", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextCellRendering.kt */
public final class TextCellRendering {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String LOG_TAG = "TextCellRendering";
    private final Function2<String, String, Unit> onActionButtonClicked;
    private final Function1<String, Unit> onCellClicked;
    private final Function1<String, Unit> onCellTextClicked;
    private final TextCellState state;

    public TextCellRendering(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.onCellClicked = builder.getOnCellClicked$zendesk_ui_ui_android();
        this.onCellTextClicked = builder.getOnCellTextClicked$zendesk_ui_ui_android();
        this.onActionButtonClicked = builder.getOnActionButtonClicked$zendesk_ui_ui_android();
        this.state = builder.getState$zendesk_ui_ui_android();
    }

    public final Function1<String, Unit> getOnCellClicked$zendesk_ui_ui_android() {
        return this.onCellClicked;
    }

    public final Function1<String, Unit> getOnCellTextClicked$zendesk_ui_ui_android() {
        return this.onCellTextClicked;
    }

    public final Function2<String, String, Unit> getOnActionButtonClicked$zendesk_ui_ui_android() {
        return this.onActionButtonClicked;
    }

    public final TextCellState getState$zendesk_ui_ui_android() {
        return this.state;
    }

    public TextCellRendering() {
        this(new Builder());
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001d\u001a\u00020\u0003J \u0010\u0006\u001a\u00020\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007J\u001a\u0010\u000e\u001a\u00020\u00002\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u000fJ\u001a\u0010\u0014\u001a\u00020\u00002\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u000fJ\u001a\u0010\u0017\u001a\u00020\u00002\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u000fR,\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lzendesk/ui/android/conversation/textcell/TextCellRendering$Builder;", "", "rendering", "Lzendesk/ui/android/conversation/textcell/TextCellRendering;", "(Lzendesk/ui/android/conversation/textcell/TextCellRendering;)V", "()V", "onActionButtonClicked", "Lkotlin/Function2;", "", "", "getOnActionButtonClicked$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function2;", "setOnActionButtonClicked$zendesk_ui_ui_android", "(Lkotlin/jvm/functions/Function2;)V", "onCellClicked", "Lkotlin/Function1;", "getOnCellClicked$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function1;", "setOnCellClicked$zendesk_ui_ui_android", "(Lkotlin/jvm/functions/Function1;)V", "onCellTextClicked", "getOnCellTextClicked$zendesk_ui_ui_android", "setOnCellTextClicked$zendesk_ui_ui_android", "state", "Lzendesk/ui/android/conversation/textcell/TextCellState;", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/textcell/TextCellState;", "setState$zendesk_ui_ui_android", "(Lzendesk/ui/android/conversation/textcell/TextCellState;)V", "build", "stateUpdate", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TextCellRendering.kt */
    public static final class Builder {
        private Function2<? super String, ? super String, Unit> onActionButtonClicked;
        private Function1<? super String, Unit> onCellClicked;
        private Function1<? super String, Unit> onCellTextClicked;
        private TextCellState state;

        public Builder() {
            this.onCellClicked = TextCellRendering$Builder$onCellClicked$1.INSTANCE;
            this.onActionButtonClicked = TextCellRendering$Builder$onActionButtonClicked$1.INSTANCE;
            this.state = new TextCellState((String) null, (List) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 63, (DefaultConstructorMarker) null);
        }

        public final Function1<String, Unit> getOnCellClicked$zendesk_ui_ui_android() {
            return this.onCellClicked;
        }

        public final void setOnCellClicked$zendesk_ui_ui_android(Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.onCellClicked = function1;
        }

        public final Function1<String, Unit> getOnCellTextClicked$zendesk_ui_ui_android() {
            return this.onCellTextClicked;
        }

        public final void setOnCellTextClicked$zendesk_ui_ui_android(Function1<? super String, Unit> function1) {
            this.onCellTextClicked = function1;
        }

        public final Function2<String, String, Unit> getOnActionButtonClicked$zendesk_ui_ui_android() {
            return this.onActionButtonClicked;
        }

        public final void setOnActionButtonClicked$zendesk_ui_ui_android(Function2<? super String, ? super String, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "<set-?>");
            this.onActionButtonClicked = function2;
        }

        public final TextCellState getState$zendesk_ui_ui_android() {
            return this.state;
        }

        public final void setState$zendesk_ui_ui_android(TextCellState textCellState) {
            Intrinsics.checkNotNullParameter(textCellState, "<set-?>");
            this.state = textCellState;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(TextCellRendering textCellRendering) {
            this();
            Intrinsics.checkNotNullParameter(textCellRendering, "rendering");
            this.onCellClicked = textCellRendering.getOnCellClicked$zendesk_ui_ui_android();
            this.state = textCellRendering.getState$zendesk_ui_ui_android();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(TextCellRendering textCellRendering, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new TextCellRendering() : textCellRendering);
        }

        public final Builder onCellClicked(Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "onCellClicked");
            Builder builder = this;
            this.onCellClicked = function1;
            return this;
        }

        public final Builder onCellTextClicked(Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "onCellTextClicked");
            Builder builder = this;
            this.onCellTextClicked = function1;
            return this;
        }

        public final Builder onActionButtonClicked(Function2<? super String, ? super String, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "onActionButtonClicked");
            Builder builder = this;
            this.onActionButtonClicked = function2;
            return this;
        }

        public final Builder state(Function1<? super TextCellState, TextCellState> function1) {
            Intrinsics.checkNotNullParameter(function1, "stateUpdate");
            Builder builder = this;
            this.state = function1.invoke(this.state);
            return this;
        }

        public final TextCellRendering build() {
            return new TextCellRendering(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/ui/android/conversation/textcell/TextCellRendering$Companion;", "", "()V", "LOG_TAG", "", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TextCellRendering.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
