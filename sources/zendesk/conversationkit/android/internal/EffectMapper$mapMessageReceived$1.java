package zendesk.conversationkit.android.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.conversationkit.android.ConversationKitEvent;
import zendesk.conversationkit.android.internal.Effect;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lzendesk/conversationkit/android/internal/EventReceiver;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: EffectMapper.kt */
final class EffectMapper$mapMessageReceived$1 extends Lambda implements Function1<EventReceiver, Unit> {
    final /* synthetic */ Effect.MessageReceived $effect;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EffectMapper$mapMessageReceived$1(Effect.MessageReceived messageReceived) {
        super(1);
        this.$effect = messageReceived;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((EventReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(EventReceiver eventReceiver) {
        Intrinsics.checkNotNullParameter(eventReceiver, "$this$mapEvents");
        final Effect.MessageReceived messageReceived = this.$effect;
        eventReceiver.event(new Function0<ConversationKitEvent>() {
            public final ConversationKitEvent invoke() {
                return new ConversationKitEvent.MessageReceived(messageReceived.getMessage(), messageReceived.getConversationId());
            }
        });
        eventReceiver.event(this.$effect.getConversation(), AnonymousClass2.INSTANCE);
    }
}
