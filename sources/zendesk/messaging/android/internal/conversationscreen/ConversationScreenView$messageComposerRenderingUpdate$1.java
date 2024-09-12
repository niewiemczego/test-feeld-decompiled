package zendesk.messaging.android.internal.conversationscreen;

import android.content.Context;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.android.messaging.model.ColorTheme;
import zendesk.messaging.R;
import zendesk.ui.android.conversation.composer.MessageComposerRendering;
import zendesk.ui.android.conversation.composer.MessageComposerState;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/composer/MessageComposerRendering;", "messageComposerRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationScreenView.kt */
final class ConversationScreenView$messageComposerRenderingUpdate$1 extends Lambda implements Function1<MessageComposerRendering, MessageComposerRendering> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ConversationScreenView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationScreenView$messageComposerRenderingUpdate$1(ConversationScreenView conversationScreenView, Context context) {
        super(1);
        this.this$0 = conversationScreenView;
        this.$context = context;
    }

    public final MessageComposerRendering invoke(MessageComposerRendering messageComposerRendering) {
        Intrinsics.checkNotNullParameter(messageComposerRendering, "messageComposerRendering");
        MessageComposerRendering.Builder onTextChanged = messageComposerRendering.toBuilder().onSendButtonClicked(this.this$0.rendering.getOnSendButtonClicked$zendesk_messaging_messaging_android()).onAttachButtonClicked(this.this$0.rendering.getOnAttachButtonClicked$zendesk_messaging_messaging_android()).onTyping(this.this$0.rendering.getOnTyping$zendesk_messaging_messaging_android()).onTextChanged(this.this$0.rendering.getOnMessageComposerTextChanged$zendesk_messaging_messaging_android());
        final ConversationScreenView conversationScreenView = this.this$0;
        final Context context = this.$context;
        return onTextChanged.state(new Function1<MessageComposerState, MessageComposerState>() {
            public final MessageComposerState invoke(MessageComposerState messageComposerState) {
                int i;
                Intrinsics.checkNotNullParameter(messageComposerState, "state");
                ColorTheme colorTheme = conversationScreenView.rendering.getState$zendesk_messaging_messaging_android().getColorTheme();
                Integer num = null;
                Integer colorInt = colorTheme != null ? colorTheme.toColorInt(colorTheme.getActionColor()) : null;
                ColorTheme colorTheme2 = conversationScreenView.rendering.getState$zendesk_messaging_messaging_android().getColorTheme();
                if (colorTheme2 != null) {
                    String iconColor = colorTheme2.getIconColor();
                    if (iconColor != null) {
                        num = colorTheme2.toColorInt(iconColor);
                    }
                    if (num != null) {
                        i = num.intValue();
                        return messageComposerState.copy(!conversationScreenView.rendering.getState$zendesk_messaging_messaging_android().getBlockChatInput(), conversationScreenView.rendering.getState$zendesk_messaging_messaging_android().getCameraSupported(), conversationScreenView.rendering.getState$zendesk_messaging_messaging_android().getGallerySupported(), true, conversationScreenView.rendering.getState$zendesk_messaging_messaging_android().getMessageComposerVisibility(), 4096, colorInt, Integer.valueOf(i), conversationScreenView.rendering.getState$zendesk_messaging_messaging_android().getComposerText());
                    }
                }
                i = ContextCompat.getColor(context, R.color.zma_color_icon_color_default);
                return messageComposerState.copy(!conversationScreenView.rendering.getState$zendesk_messaging_messaging_android().getBlockChatInput(), conversationScreenView.rendering.getState$zendesk_messaging_messaging_android().getCameraSupported(), conversationScreenView.rendering.getState$zendesk_messaging_messaging_android().getGallerySupported(), true, conversationScreenView.rendering.getState$zendesk_messaging_messaging_android().getMessageComposerVisibility(), 4096, colorInt, Integer.valueOf(i), conversationScreenView.rendering.getState$zendesk_messaging_messaging_android().getComposerText());
            }
        }).build();
    }
}
