package zendesk.messaging.android.internal.conversationscreen;

import com.amplitude.reactnative.DatabaseConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Function0;", "", "store", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationScreenCoordinator.kt */
final class ConversationScreenCoordinator$onRetryConnectionClicked$1 extends Lambda implements Function1<ConversationScreenViewModel, Function0<? extends Unit>> {
    public static final ConversationScreenCoordinator$onRetryConnectionClicked$1 INSTANCE = new ConversationScreenCoordinator$onRetryConnectionClicked$1();

    ConversationScreenCoordinator$onRetryConnectionClicked$1() {
        super(1);
    }

    public final Function0<Unit> invoke(final ConversationScreenViewModel conversationScreenViewModel) {
        Intrinsics.checkNotNullParameter(conversationScreenViewModel, DatabaseConstants.STORE_TABLE_NAME);
        return new Function0<Unit>() {
            public final void invoke() {
                conversationScreenViewModel.dispatchAction(ConversationScreenAction.RetryConnection.INSTANCE);
            }
        };
    }
}
