package zendesk.ui.android.conversation.avatar;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\n\u001a\u00020\u0004R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lzendesk/ui/android/conversation/avatar/AvatarImageRendering;", "", "()V", "builder", "Lzendesk/ui/android/conversation/avatar/AvatarImageRendering$Builder;", "(Lzendesk/ui/android/conversation/avatar/AvatarImageRendering$Builder;)V", "state", "Lzendesk/ui/android/conversation/avatar/AvatarImageState;", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/avatar/AvatarImageState;", "toBuilder", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AvatarImageRendering.kt */
public final class AvatarImageRendering {
    private final AvatarImageState state;

    public AvatarImageRendering(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.state = builder.getState$zendesk_ui_ui_android();
    }

    public final AvatarImageState getState$zendesk_ui_ui_android() {
        return this.state;
    }

    public AvatarImageRendering() {
        this(new Builder());
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\f\u001a\u00020\u0003J\u001a\u0010\u0006\u001a\u00020\u00002\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lzendesk/ui/android/conversation/avatar/AvatarImageRendering$Builder;", "", "rendering", "Lzendesk/ui/android/conversation/avatar/AvatarImageRendering;", "(Lzendesk/ui/android/conversation/avatar/AvatarImageRendering;)V", "()V", "state", "Lzendesk/ui/android/conversation/avatar/AvatarImageState;", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/avatar/AvatarImageState;", "setState$zendesk_ui_ui_android", "(Lzendesk/ui/android/conversation/avatar/AvatarImageState;)V", "build", "stateUpdate", "Lkotlin/Function1;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AvatarImageRendering.kt */
    public static final class Builder {
        private AvatarImageState state;

        public Builder() {
            this.state = new AvatarImageState((Uri) null, false, 0, (Integer) null, (AvatarMask) null, 31, (DefaultConstructorMarker) null);
        }

        public final AvatarImageState getState$zendesk_ui_ui_android() {
            return this.state;
        }

        public final void setState$zendesk_ui_ui_android(AvatarImageState avatarImageState) {
            Intrinsics.checkNotNullParameter(avatarImageState, "<set-?>");
            this.state = avatarImageState;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(AvatarImageRendering avatarImageRendering) {
            this();
            Intrinsics.checkNotNullParameter(avatarImageRendering, "rendering");
            this.state = avatarImageRendering.getState$zendesk_ui_ui_android();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(AvatarImageRendering avatarImageRendering, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new AvatarImageRendering() : avatarImageRendering);
        }

        public final Builder state(Function1<? super AvatarImageState, AvatarImageState> function1) {
            Intrinsics.checkNotNullParameter(function1, "stateUpdate");
            Builder builder = this;
            this.state = function1.invoke(this.state);
            return this;
        }

        public final AvatarImageRendering build() {
            return new AvatarImageRendering(this);
        }
    }
}
