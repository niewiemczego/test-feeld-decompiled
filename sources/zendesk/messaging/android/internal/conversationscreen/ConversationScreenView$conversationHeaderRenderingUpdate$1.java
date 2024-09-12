package zendesk.messaging.android.internal.conversationscreen;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.android.messaging.model.ColorTheme;
import zendesk.ui.android.conversation.header.ConversationHeaderRendering;
import zendesk.ui.android.conversation.header.ConversationHeaderState;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/header/ConversationHeaderRendering;", "conversationHeaderRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationScreenView.kt */
final class ConversationScreenView$conversationHeaderRenderingUpdate$1 extends Lambda implements Function1<ConversationHeaderRendering, ConversationHeaderRendering> {
    final /* synthetic */ ConversationScreenView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationScreenView$conversationHeaderRenderingUpdate$1(ConversationScreenView conversationScreenView) {
        super(1);
        this.this$0 = conversationScreenView;
    }

    public final ConversationHeaderRendering invoke(ConversationHeaderRendering conversationHeaderRendering) {
        Intrinsics.checkNotNullParameter(conversationHeaderRendering, "conversationHeaderRendering");
        ConversationHeaderRendering.Builder builder = conversationHeaderRendering.toBuilder();
        final ConversationScreenView conversationScreenView = this.this$0;
        return builder.state(new Function1<ConversationHeaderState, ConversationHeaderState>() {
            public final ConversationHeaderState invoke(ConversationHeaderState conversationHeaderState) {
                Intrinsics.checkNotNullParameter(conversationHeaderState, "state");
                String title = conversationScreenView.rendering.getState$zendesk_messaging_messaging_android().getTitle();
                String description = conversationScreenView.rendering.getState$zendesk_messaging_messaging_android().getDescription();
                Uri parse = Uri.parse(conversationScreenView.rendering.getState$zendesk_messaging_messaging_android().getLogoUrl());
                ColorTheme colorTheme = conversationScreenView.rendering.getState$zendesk_messaging_messaging_android().getColorTheme();
                Integer colorInt = colorTheme != null ? colorTheme.toColorInt(colorTheme.getPrimaryColor()) : null;
                ColorTheme colorTheme2 = conversationScreenView.rendering.getState$zendesk_messaging_messaging_android().getColorTheme();
                return conversationHeaderState.copy(title, description, parse, colorInt, colorTheme2 != null ? colorTheme2.toColorInt(colorTheme2.getPrimaryColor()) : null);
            }
        }).onBackButtonClicked(this.this$0.rendering.getOnBackButtonClicked$zendesk_messaging_messaging_android()).build();
    }
}
