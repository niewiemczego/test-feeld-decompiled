package zendesk.conversationkit.android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.ConversationKitResult;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"getOrThrow", "T", "Lzendesk/conversationkit/android/ConversationKitResult;", "(Lzendesk/conversationkit/android/ConversationKitResult;)Ljava/lang/Object;", "zendesk.conversationkit_conversationkit-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationKitResult.kt */
public final class ConversationKitResultKt {
    public static final <T> T getOrThrow(ConversationKitResult<? extends T> conversationKitResult) {
        Intrinsics.checkNotNullParameter(conversationKitResult, "<this>");
        if (conversationKitResult instanceof ConversationKitResult.Failure) {
            throw ((ConversationKitResult.Failure) conversationKitResult).getCause();
        } else if (conversationKitResult instanceof ConversationKitResult.Success) {
            return ((ConversationKitResult.Success) conversationKitResult).getValue();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
