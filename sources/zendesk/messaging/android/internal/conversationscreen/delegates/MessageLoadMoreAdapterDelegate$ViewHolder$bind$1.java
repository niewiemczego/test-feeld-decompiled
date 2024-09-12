package zendesk.messaging.android.internal.conversationscreen.delegates;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.messaging.android.internal.conversationscreen.delegates.MessageLoadMoreAdapterDelegate;
import zendesk.messaging.android.internal.model.LoadMoreStatus;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.ui.android.conversation.messageloadmore.MessageLoadMoreRendering;
import zendesk.ui.android.conversation.messageloadmore.MessageLoadMoreState;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreRendering;", "messageLoadMoreRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLoadMoreAdapterDelegate.kt */
final class MessageLoadMoreAdapterDelegate$ViewHolder$bind$1 extends Lambda implements Function1<MessageLoadMoreRendering, MessageLoadMoreRendering> {
    final /* synthetic */ MessageLogEntry.LoadMore $item;
    final /* synthetic */ MessageLoadMoreAdapterDelegate.ViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageLoadMoreAdapterDelegate$ViewHolder$bind$1(MessageLoadMoreAdapterDelegate.ViewHolder viewHolder, MessageLogEntry.LoadMore loadMore) {
        super(1);
        this.this$0 = viewHolder;
        this.$item = loadMore;
    }

    public final MessageLoadMoreRendering invoke(MessageLoadMoreRendering messageLoadMoreRendering) {
        Intrinsics.checkNotNullParameter(messageLoadMoreRendering, "messageLoadMoreRendering");
        MessageLoadMoreRendering.Builder builder = messageLoadMoreRendering.toBuilder();
        final MessageLoadMoreAdapterDelegate.ViewHolder viewHolder = this.this$0;
        MessageLoadMoreRendering.Builder onRetryClicked = builder.onRetryClicked(new Function0<Unit>() {
            public final void invoke() {
                Function0<Unit> onRetryClicked = viewHolder.getOnRetryClicked();
                if (onRetryClicked != null) {
                    onRetryClicked.invoke();
                }
            }
        });
        final MessageLogEntry.LoadMore loadMore = this.$item;
        return onRetryClicked.state(new Function1<MessageLoadMoreState, MessageLoadMoreState>() {

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: zendesk.messaging.android.internal.conversationscreen.delegates.MessageLoadMoreAdapterDelegate$ViewHolder$bind$1$2$WhenMappings */
            /* compiled from: MessageLoadMoreAdapterDelegate.kt */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LoadMoreStatus.values().length];
                    iArr[LoadMoreStatus.LOADING.ordinal()] = 1;
                    iArr[LoadMoreStatus.FAILED.ordinal()] = 2;
                    iArr[LoadMoreStatus.NONE.ordinal()] = 3;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public final MessageLoadMoreState invoke(MessageLoadMoreState messageLoadMoreState) {
                MessageLoadMoreState.MessageLoadMoreStatus messageLoadMoreStatus;
                Intrinsics.checkNotNullParameter(messageLoadMoreState, "state");
                String failedRetryText = loadMore.getFailedRetryText();
                int i = WhenMappings.$EnumSwitchMapping$0[loadMore.getStatus().ordinal()];
                if (i == 1) {
                    messageLoadMoreStatus = MessageLoadMoreState.MessageLoadMoreStatus.LOADING;
                } else if (i == 2) {
                    messageLoadMoreStatus = MessageLoadMoreState.MessageLoadMoreStatus.FAILED;
                } else if (i == 3) {
                    messageLoadMoreStatus = MessageLoadMoreState.MessageLoadMoreStatus.NONE;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                return MessageLoadMoreState.copy$default(messageLoadMoreState, failedRetryText, (Integer) null, (Integer) null, messageLoadMoreStatus, 6, (Object) null);
            }
        }).build();
    }
}
