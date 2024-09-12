package zendesk.messaging.android.internal.conversationscreen;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationScreenCoordinator.kt */
final class ConversationScreenCoordinator$onDeniedPermissionDismissed$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ConversationScreenCoordinator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationScreenCoordinator$onDeniedPermissionDismissed$1(ConversationScreenCoordinator conversationScreenCoordinator) {
        super(0);
        this.this$0 = conversationScreenCoordinator;
    }

    public final void invoke() {
        this.this$0.conversationScreenViewModel.dispatchAction(ConversationScreenAction.HideDeniedPermission.INSTANCE);
    }
}
