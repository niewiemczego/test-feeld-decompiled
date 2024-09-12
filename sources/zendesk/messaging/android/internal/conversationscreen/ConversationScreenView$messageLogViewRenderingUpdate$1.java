package zendesk.messaging.android.internal.conversationscreen;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.conversationkit.android.model.Conversation;
import zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogRendering;
import zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogState;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogRendering;", "messageLogRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationScreenView.kt */
final class ConversationScreenView$messageLogViewRenderingUpdate$1 extends Lambda implements Function1<MessageLogRendering, MessageLogRendering> {
    final /* synthetic */ ConversationScreenView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationScreenView$messageLogViewRenderingUpdate$1(ConversationScreenView conversationScreenView) {
        super(1);
        this.this$0 = conversationScreenView;
    }

    public final MessageLogRendering invoke(MessageLogRendering messageLogRendering) {
        Intrinsics.checkNotNullParameter(messageLogRendering, "messageLogRendering");
        MessageLogRendering.Builder builder = messageLogRendering.toBuilder();
        final ConversationScreenView conversationScreenView = this.this$0;
        MessageLogRendering.Builder onFormDisplayedFieldsChanged = builder.state(new Function1<MessageLogState, MessageLogState>() {
            public final MessageLogState invoke(MessageLogState messageLogState) {
                Intrinsics.checkNotNullParameter(messageLogState, "state");
                return conversationScreenView.updateMessageLogState(messageLogState);
            }
        }).onReplyActionSelected(this.this$0.rendering.getOnReplyActionSelected$zendesk_messaging_messaging_android()).onFailedMessageClicked(this.this$0.rendering.getOnFailedMessageClicked$zendesk_messaging_messaging_android()).onUriClicked(this.this$0.rendering.getOnUriClicked$zendesk_messaging_messaging_android()).onFormCompleted(this.this$0.rendering.getOnFormCompleted$zendesk_messaging_messaging_android()).onFormFocusChanged(this.this$0.rendering.getOnFormFocusChanged$zendesk_messaging_messaging_android()).onFormDisplayedFieldsChanged(this.this$0.rendering.getOnFormDisplayedFieldsChanged$zendesk_messaging_messaging_android());
        final ConversationScreenView conversationScreenView2 = this.this$0;
        MessageLogRendering.Builder onLoadMoreListener = onFormDisplayedFieldsChanged.onLoadMoreListener(new Function1<Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                Conversation conversation = conversationScreenView2.rendering.getState$zendesk_messaging_messaging_android().getConversation();
                if (conversation != null) {
                    ConversationScreenView conversationScreenView = conversationScreenView2;
                    if (z) {
                        conversationScreenView.loadMoreMessages(conversation);
                    }
                }
            }
        });
        final ConversationScreenView conversationScreenView3 = this.this$0;
        return onLoadMoreListener.onRetryLoadMoreClickedListener(new Function0<Unit>() {
            public final void invoke() {
                Conversation conversation = conversationScreenView3.rendering.getState$zendesk_messaging_messaging_android().getConversation();
                if (conversation != null) {
                    ConversationScreenView conversationScreenView = conversationScreenView3;
                    if (conversation.getMessages().size() >= 100) {
                        conversationScreenView.loadMoreMessages(conversation);
                    }
                }
            }
        }).build();
    }
}
