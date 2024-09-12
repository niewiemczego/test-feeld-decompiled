package zendesk.ui.android.conversation.form;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0004R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lzendesk/ui/android/conversation/form/FormButtonRendering;", "", "()V", "builder", "Lzendesk/ui/android/conversation/form/FormButtonRendering$Builder;", "(Lzendesk/ui/android/conversation/form/FormButtonRendering$Builder;)V", "onButtonClicked", "Lkotlin/Function0;", "", "getOnButtonClicked$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function0;", "state", "Lzendesk/ui/android/conversation/form/FormButtonState;", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/form/FormButtonState;", "toBuilder", "Builder", "Companion", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormButtonRendering.kt */
public final class FormButtonRendering {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String LOG_TAG = "FormButtonRendering";
    private final Function0<Unit> onButtonClicked;
    private final FormButtonState state;

    public FormButtonRendering(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.onButtonClicked = builder.getOnButtonClicked$zendesk_ui_ui_android();
        this.state = builder.getState$zendesk_ui_ui_android();
    }

    public final Function0<Unit> getOnButtonClicked$zendesk_ui_ui_android() {
        return this.onButtonClicked;
    }

    public final FormButtonState getState$zendesk_ui_ui_android() {
        return this.state;
    }

    public FormButtonRendering() {
        this(new Builder());
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0013\u001a\u00020\u0003J\u0014\u0010\u0006\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u001a\u0010\r\u001a\u00020\u00002\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0015R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lzendesk/ui/android/conversation/form/FormButtonRendering$Builder;", "", "rendering", "Lzendesk/ui/android/conversation/form/FormButtonRendering;", "(Lzendesk/ui/android/conversation/form/FormButtonRendering;)V", "()V", "onButtonClicked", "Lkotlin/Function0;", "", "getOnButtonClicked$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function0;", "setOnButtonClicked$zendesk_ui_ui_android", "(Lkotlin/jvm/functions/Function0;)V", "state", "Lzendesk/ui/android/conversation/form/FormButtonState;", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/form/FormButtonState;", "setState$zendesk_ui_ui_android", "(Lzendesk/ui/android/conversation/form/FormButtonState;)V", "build", "stateUpdate", "Lkotlin/Function1;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FormButtonRendering.kt */
    public static final class Builder {
        private Function0<Unit> onButtonClicked;
        private FormButtonState state;

        public Builder() {
            this.onButtonClicked = FormButtonRendering$Builder$onButtonClicked$1.INSTANCE;
            this.state = new FormButtonState((String) null, false, (Integer) null, 7, (DefaultConstructorMarker) null);
        }

        public final Function0<Unit> getOnButtonClicked$zendesk_ui_ui_android() {
            return this.onButtonClicked;
        }

        public final void setOnButtonClicked$zendesk_ui_ui_android(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "<set-?>");
            this.onButtonClicked = function0;
        }

        public final FormButtonState getState$zendesk_ui_ui_android() {
            return this.state;
        }

        public final void setState$zendesk_ui_ui_android(FormButtonState formButtonState) {
            Intrinsics.checkNotNullParameter(formButtonState, "<set-?>");
            this.state = formButtonState;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(FormButtonRendering formButtonRendering) {
            this();
            Intrinsics.checkNotNullParameter(formButtonRendering, "rendering");
            this.onButtonClicked = formButtonRendering.getOnButtonClicked$zendesk_ui_ui_android();
            this.state = formButtonRendering.getState$zendesk_ui_ui_android();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(FormButtonRendering formButtonRendering, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new FormButtonRendering() : formButtonRendering);
        }

        public final Builder onButtonClicked(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "onButtonClicked");
            Builder builder = this;
            this.onButtonClicked = function0;
            return this;
        }

        public final Builder state(Function1<? super FormButtonState, FormButtonState> function1) {
            Intrinsics.checkNotNullParameter(function1, "stateUpdate");
            Builder builder = this;
            this.state = function1.invoke(this.state);
            return this;
        }

        public final FormButtonRendering build() {
            return new FormButtonRendering(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/ui/android/conversation/form/FormButtonRendering$Companion;", "", "()V", "LOG_TAG", "", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FormButtonRendering.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
