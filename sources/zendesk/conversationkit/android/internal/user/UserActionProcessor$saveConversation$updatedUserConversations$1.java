package zendesk.conversationkit.android.internal.user;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.conversationkit.android.model.Conversation;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lzendesk/conversationkit/android/model/Conversation;", "invoke", "(Lzendesk/conversationkit/android/model/Conversation;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserActionProcessor.kt */
final class UserActionProcessor$saveConversation$updatedUserConversations$1 extends Lambda implements Function1<Conversation, Boolean> {
    final /* synthetic */ Conversation $conversation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserActionProcessor$saveConversation$updatedUserConversations$1(Conversation conversation) {
        super(1);
        this.$conversation = conversation;
    }

    public final Boolean invoke(Conversation conversation) {
        Intrinsics.checkNotNullParameter(conversation, "it");
        return Boolean.valueOf(Intrinsics.areEqual((Object) conversation.getId(), (Object) this.$conversation.getId()));
    }
}
