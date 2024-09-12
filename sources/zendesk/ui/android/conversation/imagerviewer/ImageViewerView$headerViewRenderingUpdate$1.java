package zendesk.ui.android.conversation.imagerviewer;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.ui.android.conversation.header.ConversationHeaderRendering;
import zendesk.ui.android.conversation.header.ConversationHeaderState;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/header/ConversationHeaderRendering;", "conversationHeaderRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageViewerView.kt */
final class ImageViewerView$headerViewRenderingUpdate$1 extends Lambda implements Function1<ConversationHeaderRendering, ConversationHeaderRendering> {
    final /* synthetic */ ImageViewerView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageViewerView$headerViewRenderingUpdate$1(ImageViewerView imageViewerView) {
        super(1);
        this.this$0 = imageViewerView;
    }

    public final ConversationHeaderRendering invoke(ConversationHeaderRendering conversationHeaderRendering) {
        Intrinsics.checkNotNullParameter(conversationHeaderRendering, "conversationHeaderRendering");
        ConversationHeaderRendering.Builder builder = conversationHeaderRendering.toBuilder();
        final ImageViewerView imageViewerView = this.this$0;
        ConversationHeaderRendering.Builder state = builder.state(new Function1<ConversationHeaderState, ConversationHeaderState>() {
            public final ConversationHeaderState invoke(ConversationHeaderState conversationHeaderState) {
                Intrinsics.checkNotNullParameter(conversationHeaderState, "state");
                return ConversationHeaderState.copy$default(conversationHeaderState, (String) null, (String) null, (Uri) null, imageViewerView.rendering.getState$zendesk_ui_ui_android().getToolbarColor$zendesk_ui_ui_android(), imageViewerView.rendering.getState$zendesk_ui_ui_android().getStatusBarColor$zendesk_ui_ui_android(), 7, (Object) null);
            }
        });
        final ImageViewerView imageViewerView2 = this.this$0;
        return state.onBackButtonClicked(new Function0<Unit>() {
            public final void invoke() {
                imageViewerView2.rendering.getOnBackButtonClicked$zendesk_ui_ui_android().invoke();
            }
        }).build();
    }
}
