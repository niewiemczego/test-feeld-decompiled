package zendesk.conversationkit.android.internal.user;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.conversationkit.android.internal.Action;
import zendesk.conversationkit.android.model.Message;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lzendesk/conversationkit/android/model/Message;", "invoke", "(Lzendesk/conversationkit/android/model/Message;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserActionProcessor.kt */
final class UserActionProcessor$processSendMessage$2$updatedMessages$1 extends Lambda implements Function1<Message, Boolean> {
    final /* synthetic */ Action.SendMessage $action;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserActionProcessor$processSendMessage$2$updatedMessages$1(Action.SendMessage sendMessage) {
        super(1);
        this.$action = sendMessage;
    }

    public final Boolean invoke(Message message) {
        Intrinsics.checkNotNullParameter(message, "it");
        return Boolean.valueOf(Intrinsics.areEqual((Object) message.getLocalId(), (Object) this.$action.getMessage().getLocalId()));
    }
}
