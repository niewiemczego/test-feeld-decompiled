package zendesk.messaging.android.internal.conversationscreen.delegates;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.conversationkit.android.model.MessageAction;
import zendesk.messaging.android.internal.conversationscreen.delegates.QuickReplyAdapterDelegate;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.ui.android.conversation.quickreply.QuickReplyOption;
import zendesk.ui.android.conversation.quickreply.QuickReplyRendering;
import zendesk.ui.android.conversation.quickreply.QuickReplyState;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/quickreply/QuickReplyRendering;", "quickReplyRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: QuickReplyAdapterDelegate.kt */
final class QuickReplyAdapterDelegate$ViewHolder$bind$1 extends Lambda implements Function1<QuickReplyRendering, QuickReplyRendering> {
    final /* synthetic */ MessageLogEntry.QuickReply $item;
    final /* synthetic */ Function1<MessageAction.Reply, Unit> $onReplyActionSelected;
    final /* synthetic */ QuickReplyAdapterDelegate.ViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QuickReplyAdapterDelegate$ViewHolder$bind$1(MessageLogEntry.QuickReply quickReply, QuickReplyAdapterDelegate.ViewHolder viewHolder, Function1<? super MessageAction.Reply, Unit> function1) {
        super(1);
        this.$item = quickReply;
        this.this$0 = viewHolder;
        this.$onReplyActionSelected = function1;
    }

    public final QuickReplyRendering invoke(QuickReplyRendering quickReplyRendering) {
        Intrinsics.checkNotNullParameter(quickReplyRendering, "quickReplyRendering");
        QuickReplyRendering.Builder builder = quickReplyRendering.toBuilder();
        final MessageLogEntry.QuickReply quickReply = this.$item;
        final QuickReplyAdapterDelegate.ViewHolder viewHolder = this.this$0;
        QuickReplyRendering.Builder state = builder.state(new Function1<QuickReplyState, QuickReplyState>() {
            public final QuickReplyState invoke(QuickReplyState quickReplyState) {
                Intrinsics.checkNotNullParameter(quickReplyState, "state");
                Iterable<MessageAction.Reply> replies = quickReply.getReplies();
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(replies, 10));
                for (MessageAction.Reply reply : replies) {
                    arrayList.add(new QuickReplyOption(reply.getId(), reply.getText()));
                }
                return quickReplyState.copy((List) arrayList, viewHolder.quickReplyColor);
            }
        });
        final Function1<MessageAction.Reply, Unit> function1 = this.$onReplyActionSelected;
        final MessageLogEntry.QuickReply quickReply2 = this.$item;
        return state.onOptionClicked(new Function1<QuickReplyOption, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((QuickReplyOption) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(QuickReplyOption quickReplyOption) {
                Intrinsics.checkNotNullParameter(quickReplyOption, "clickedOption");
                Function1<MessageAction.Reply, Unit> function1 = function1;
                for (Object next : quickReply2.getReplies()) {
                    if (Intrinsics.areEqual((Object) ((MessageAction.Reply) next).getId(), (Object) quickReplyOption.getId())) {
                        function1.invoke(next);
                        return;
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }).build();
    }
}
