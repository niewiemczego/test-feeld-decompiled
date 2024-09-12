package zendesk.conversationkit.android.internal;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lzendesk/conversationkit/android/internal/ConversationKitDispatchers;", "", "default", "Lkotlinx/coroutines/CoroutineDispatcher;", "io", "main", "unconfined", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationKitDispatchers.kt */
public interface ConversationKitDispatchers {
    /* renamed from: default  reason: not valid java name */
    CoroutineDispatcher m2752default();

    CoroutineDispatcher io();

    CoroutineDispatcher main();

    CoroutineDispatcher unconfined();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitDispatchers.kt */
    public static final class DefaultImpls {
        public static CoroutineDispatcher main(ConversationKitDispatchers conversationKitDispatchers) {
            return Dispatchers.getMain();
        }

        /* renamed from: default  reason: not valid java name */
        public static CoroutineDispatcher m2753default(ConversationKitDispatchers conversationKitDispatchers) {
            return Dispatchers.getDefault();
        }

        public static CoroutineDispatcher io(ConversationKitDispatchers conversationKitDispatchers) {
            return Dispatchers.getIO();
        }

        public static CoroutineDispatcher unconfined(ConversationKitDispatchers conversationKitDispatchers) {
            return Dispatchers.getUnconfined();
        }
    }
}
