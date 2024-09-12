package zendesk.conversationkit.android.internal;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import zendesk.conversationkit.android.internal.ConversationKitDispatchers;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/conversationkit/android/internal/DefaultConversationKitDispatchers;", "Lzendesk/conversationkit/android/internal/ConversationKitDispatchers;", "()V", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationKitDispatchers.kt */
public final class DefaultConversationKitDispatchers implements ConversationKitDispatchers {
    /* renamed from: default  reason: not valid java name */
    public CoroutineDispatcher m2754default() {
        return ConversationKitDispatchers.DefaultImpls.m2753default(this);
    }

    public CoroutineDispatcher io() {
        return ConversationKitDispatchers.DefaultImpls.io(this);
    }

    public CoroutineDispatcher main() {
        return ConversationKitDispatchers.DefaultImpls.main(this);
    }

    public CoroutineDispatcher unconfined() {
        return ConversationKitDispatchers.DefaultImpls.unconfined(this);
    }
}
