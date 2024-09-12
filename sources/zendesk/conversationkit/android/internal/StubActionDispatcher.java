package zendesk.conversationkit.android.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import zendesk.conversationkit.android.ConversationKitResult;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lzendesk/conversationkit/android/internal/StubActionDispatcher;", "Lzendesk/conversationkit/android/internal/ActionDispatcher;", "()V", "dispatch", "Lzendesk/conversationkit/android/ConversationKitResult;", "T", "action", "Lzendesk/conversationkit/android/internal/Action;", "(Lzendesk/conversationkit/android/internal/Action;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StubActionDispatcher.kt */
public final class StubActionDispatcher implements ActionDispatcher {
    public <T> Object dispatch(Action action, Continuation<? super ConversationKitResult<? extends T>> continuation) {
        return new ConversationKitResult.Success(Unit.INSTANCE);
    }
}
