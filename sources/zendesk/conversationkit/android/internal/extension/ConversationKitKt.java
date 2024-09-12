package zendesk.conversationkit.android.internal.extension;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import zendesk.conversationkit.android.ConversationKit;
import zendesk.conversationkit.android.ConversationKitEvent;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"eventFlow", "Lkotlinx/coroutines/flow/Flow;", "Lzendesk/conversationkit/android/ConversationKitEvent;", "Lzendesk/conversationkit/android/ConversationKit;", "getEventFlow", "(Lzendesk/conversationkit/android/ConversationKit;)Lkotlinx/coroutines/flow/Flow;", "zendesk.conversationkit_conversationkit-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationKit.kt */
public final class ConversationKitKt {
    public static final Flow<ConversationKitEvent> getEventFlow(ConversationKit conversationKit) {
        Intrinsics.checkNotNullParameter(conversationKit, "<this>");
        return FlowKt.callbackFlow(new ConversationKitKt$eventFlow$1(conversationKit, (Continuation<? super ConversationKitKt$eventFlow$1>) null));
    }
}
