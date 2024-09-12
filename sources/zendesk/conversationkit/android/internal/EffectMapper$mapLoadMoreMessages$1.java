package zendesk.conversationkit.android.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.conversationkit.android.ConversationKitEvent;
import zendesk.conversationkit.android.ConversationKitResult;
import zendesk.conversationkit.android.internal.Effect;
import zendesk.conversationkit.android.model.Message;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lzendesk/conversationkit/android/internal/EventReceiver;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: EffectMapper.kt */
final class EffectMapper$mapLoadMoreMessages$1 extends Lambda implements Function1<EventReceiver, Unit> {
    final /* synthetic */ Effect.LoadMoreMessages $effect;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EffectMapper$mapLoadMoreMessages$1(Effect.LoadMoreMessages loadMoreMessages) {
        super(1);
        this.$effect = loadMoreMessages;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((EventReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(EventReceiver eventReceiver) {
        final List list;
        Intrinsics.checkNotNullParameter(eventReceiver, "$this$mapEvents");
        ConversationKitResult<List<Message>> result = this.$effect.getResult();
        if (result instanceof ConversationKitResult.Success) {
            list = (List) ((ConversationKitResult.Success) this.$effect.getResult()).getValue();
        } else if (result instanceof ConversationKitResult.Failure) {
            list = CollectionsKt.emptyList();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        final Effect.LoadMoreMessages loadMoreMessages = this.$effect;
        eventReceiver.event(new Function0<ConversationKitEvent>() {
            public final ConversationKitEvent invoke() {
                return new ConversationKitEvent.LoadMoreMessages(list, loadMoreMessages.getConversationId());
            }
        });
        eventReceiver.event(this.$effect.getConversation(), AnonymousClass2.INSTANCE);
    }
}
