package zendesk.messaging.android.internal.conversationscreen.delegates;

import android.net.Uri;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.messaging.R;
import zendesk.messaging.android.internal.conversationscreen.delegates.MessageContainerAdapterDelegate;
import zendesk.ui.android.conversation.avatar.AvatarImageRendering;
import zendesk.ui.android.conversation.avatar.AvatarImageState;
import zendesk.ui.android.conversation.avatar.AvatarMask;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/avatar/AvatarImageRendering;", "rendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageContainerAdapterDelegate.kt */
final class MessageContainerAdapterDelegate$ViewHolder$renderAvatar$1$1 extends Lambda implements Function1<AvatarImageRendering, AvatarImageRendering> {
    final /* synthetic */ String $it;
    final /* synthetic */ MessageContainerAdapterDelegate.ViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageContainerAdapterDelegate$ViewHolder$renderAvatar$1$1(String str, MessageContainerAdapterDelegate.ViewHolder viewHolder) {
        super(1);
        this.$it = str;
        this.this$0 = viewHolder;
    }

    public final AvatarImageRendering invoke(AvatarImageRendering avatarImageRendering) {
        Intrinsics.checkNotNullParameter(avatarImageRendering, "rendering");
        AvatarImageRendering.Builder builder = avatarImageRendering.toBuilder();
        final String str = this.$it;
        final MessageContainerAdapterDelegate.ViewHolder viewHolder = this.this$0;
        return builder.state(new Function1<AvatarImageState, AvatarImageState>() {
            public final AvatarImageState invoke(AvatarImageState avatarImageState) {
                Intrinsics.checkNotNullParameter(avatarImageState, "state");
                return AvatarImageState.copy$default(avatarImageState, Uri.parse(str), false, 0, Integer.valueOf(ContextCompat.getColor(viewHolder.avatarView.getContext(), R.color.zma_color_message_inbound_background)), AvatarMask.CIRCLE, 6, (Object) null);
            }
        }).build();
    }
}
