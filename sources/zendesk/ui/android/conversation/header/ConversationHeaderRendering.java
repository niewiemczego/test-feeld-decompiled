package zendesk.ui.android.conversation.header;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0004R\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lzendesk/ui/android/conversation/header/ConversationHeaderRendering;", "", "()V", "builder", "Lzendesk/ui/android/conversation/header/ConversationHeaderRendering$Builder;", "(Lzendesk/ui/android/conversation/header/ConversationHeaderRendering$Builder;)V", "onBackButtonClicked", "Lkotlin/Function0;", "", "Lzendesk/ui/android/conversation/header/OnClickLambda;", "getOnBackButtonClicked$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function0;", "state", "Lzendesk/ui/android/conversation/header/ConversationHeaderState;", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/header/ConversationHeaderState;", "toBuilder", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationHeaderRendering.kt */
public final class ConversationHeaderRendering {
    private final Function0<Unit> onBackButtonClicked;
    private final ConversationHeaderState state;

    public ConversationHeaderRendering(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.onBackButtonClicked = builder.getOnBackButtonClicked$zendesk_ui_ui_android();
        this.state = builder.getState$zendesk_ui_ui_android();
    }

    public final Function0<Unit> getOnBackButtonClicked$zendesk_ui_ui_android() {
        return this.onBackButtonClicked;
    }

    public final ConversationHeaderState getState$zendesk_ui_ui_android() {
        return this.state;
    }

    public ConversationHeaderRendering() {
        this(new Builder());
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0014\u001a\u00020\u0003J\u001c\u0010\u0006\u001a\u00020\u00002\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\tJ\u001a\u0010\u000e\u001a\u00020\u00002\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0016R(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\u0004\u0018\u0001`\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lzendesk/ui/android/conversation/header/ConversationHeaderRendering$Builder;", "", "rendering", "Lzendesk/ui/android/conversation/header/ConversationHeaderRendering;", "(Lzendesk/ui/android/conversation/header/ConversationHeaderRendering;)V", "()V", "onBackButtonClicked", "Lkotlin/Function0;", "", "Lzendesk/ui/android/conversation/header/OnClickLambda;", "getOnBackButtonClicked$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function0;", "setOnBackButtonClicked$zendesk_ui_ui_android", "(Lkotlin/jvm/functions/Function0;)V", "state", "Lzendesk/ui/android/conversation/header/ConversationHeaderState;", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/header/ConversationHeaderState;", "setState$zendesk_ui_ui_android", "(Lzendesk/ui/android/conversation/header/ConversationHeaderState;)V", "build", "stateUpdate", "Lkotlin/Function1;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationHeaderRendering.kt */
    public static final class Builder {
        private Function0<Unit> onBackButtonClicked;
        private ConversationHeaderState state;

        public Builder() {
            this.state = new ConversationHeaderState((String) null, (String) null, (Uri) null, (Integer) null, (Integer) null, 31, (DefaultConstructorMarker) null);
        }

        public final Function0<Unit> getOnBackButtonClicked$zendesk_ui_ui_android() {
            return this.onBackButtonClicked;
        }

        public final void setOnBackButtonClicked$zendesk_ui_ui_android(Function0<Unit> function0) {
            this.onBackButtonClicked = function0;
        }

        public final ConversationHeaderState getState$zendesk_ui_ui_android() {
            return this.state;
        }

        public final void setState$zendesk_ui_ui_android(ConversationHeaderState conversationHeaderState) {
            Intrinsics.checkNotNullParameter(conversationHeaderState, "<set-?>");
            this.state = conversationHeaderState;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(ConversationHeaderRendering conversationHeaderRendering) {
            this();
            Intrinsics.checkNotNullParameter(conversationHeaderRendering, "rendering");
            this.onBackButtonClicked = conversationHeaderRendering.getOnBackButtonClicked$zendesk_ui_ui_android();
            this.state = conversationHeaderRendering.getState$zendesk_ui_ui_android();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(ConversationHeaderRendering conversationHeaderRendering, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ConversationHeaderRendering() : conversationHeaderRendering);
        }

        public final Builder onBackButtonClicked(Function0<Unit> function0) {
            Builder builder = this;
            this.onBackButtonClicked = function0;
            return this;
        }

        public final Builder state(Function1<? super ConversationHeaderState, ConversationHeaderState> function1) {
            Intrinsics.checkNotNullParameter(function1, "stateUpdate");
            Builder builder = this;
            this.state = function1.invoke(this.state);
            return this;
        }

        public final ConversationHeaderRendering build() {
            return new ConversationHeaderRendering(this);
        }
    }
}
