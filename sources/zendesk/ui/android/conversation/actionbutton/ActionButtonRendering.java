package zendesk.ui.android.conversation.actionbutton;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0002\u0011\u0012B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0004R&\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lzendesk/ui/android/conversation/actionbutton/ActionButtonRendering;", "", "()V", "builder", "Lzendesk/ui/android/conversation/actionbutton/ActionButtonRendering$Builder;", "(Lzendesk/ui/android/conversation/actionbutton/ActionButtonRendering$Builder;)V", "onActionButtonClicked", "Lkotlin/Function2;", "", "", "getOnActionButtonClicked$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function2;", "state", "Lzendesk/ui/android/conversation/actionbutton/ActionButtonState;", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/actionbutton/ActionButtonState;", "toBuilder", "Builder", "Companion", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActionButtonRendering.kt */
public final class ActionButtonRendering {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String LOG_TAG = "ActionButtonRendering";
    private final Function2<String, String, Unit> onActionButtonClicked;
    private final ActionButtonState state;

    public ActionButtonRendering(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.onActionButtonClicked = builder.getOnActionButtonClicked$zendesk_ui_ui_android();
        this.state = builder.getState$zendesk_ui_ui_android();
    }

    public final Function2<String, String, Unit> getOnActionButtonClicked$zendesk_ui_ui_android() {
        return this.onActionButtonClicked;
    }

    public final ActionButtonState getState$zendesk_ui_ui_android() {
        return this.state;
    }

    public ActionButtonRendering() {
        this(new Builder());
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0014\u001a\u00020\u0003J \u0010\u0006\u001a\u00020\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007J\u001a\u0010\u000e\u001a\u00020\u00002\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0016R,\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lzendesk/ui/android/conversation/actionbutton/ActionButtonRendering$Builder;", "", "rendering", "Lzendesk/ui/android/conversation/actionbutton/ActionButtonRendering;", "(Lzendesk/ui/android/conversation/actionbutton/ActionButtonRendering;)V", "()V", "onActionButtonClicked", "Lkotlin/Function2;", "", "", "getOnActionButtonClicked$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function2;", "setOnActionButtonClicked$zendesk_ui_ui_android", "(Lkotlin/jvm/functions/Function2;)V", "state", "Lzendesk/ui/android/conversation/actionbutton/ActionButtonState;", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/actionbutton/ActionButtonState;", "setState$zendesk_ui_ui_android", "(Lzendesk/ui/android/conversation/actionbutton/ActionButtonState;)V", "build", "stateUpdate", "Lkotlin/Function1;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ActionButtonRendering.kt */
    public static final class Builder {
        private Function2<? super String, ? super String, Unit> onActionButtonClicked;
        private ActionButtonState state;

        public Builder() {
            this.onActionButtonClicked = ActionButtonRendering$Builder$onActionButtonClicked$1.INSTANCE;
            this.state = new ActionButtonState((String) null, (String) null, false, (String) null, (Integer) null, (Integer) null, 63, (DefaultConstructorMarker) null);
        }

        public final Function2<String, String, Unit> getOnActionButtonClicked$zendesk_ui_ui_android() {
            return this.onActionButtonClicked;
        }

        public final void setOnActionButtonClicked$zendesk_ui_ui_android(Function2<? super String, ? super String, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "<set-?>");
            this.onActionButtonClicked = function2;
        }

        public final ActionButtonState getState$zendesk_ui_ui_android() {
            return this.state;
        }

        public final void setState$zendesk_ui_ui_android(ActionButtonState actionButtonState) {
            Intrinsics.checkNotNullParameter(actionButtonState, "<set-?>");
            this.state = actionButtonState;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(ActionButtonRendering actionButtonRendering) {
            this();
            Intrinsics.checkNotNullParameter(actionButtonRendering, "rendering");
            this.onActionButtonClicked = actionButtonRendering.getOnActionButtonClicked$zendesk_ui_ui_android();
            this.state = actionButtonRendering.getState$zendesk_ui_ui_android();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(ActionButtonRendering actionButtonRendering, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ActionButtonRendering() : actionButtonRendering);
        }

        public final Builder onActionButtonClicked(Function2<? super String, ? super String, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "onActionButtonClicked");
            Builder builder = this;
            this.onActionButtonClicked = function2;
            return this;
        }

        public final Builder state(Function1<? super ActionButtonState, ActionButtonState> function1) {
            Intrinsics.checkNotNullParameter(function1, "stateUpdate");
            Builder builder = this;
            this.state = function1.invoke(this.state);
            return this;
        }

        public final ActionButtonRendering build() {
            return new ActionButtonRendering(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/ui/android/conversation/actionbutton/ActionButtonRendering$Companion;", "", "()V", "LOG_TAG", "", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ActionButtonRendering.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
