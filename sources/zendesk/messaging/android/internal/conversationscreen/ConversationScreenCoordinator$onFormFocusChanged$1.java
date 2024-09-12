package zendesk.messaging.android.internal.conversationscreen;

import com.amplitude.reactnative.DatabaseConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lkotlin/Function1;", "", "", "store", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationScreenCoordinator.kt */
final class ConversationScreenCoordinator$onFormFocusChanged$1 extends Lambda implements Function1<ConversationScreenViewModel, Function1<? super Boolean, ? extends Unit>> {
    public static final ConversationScreenCoordinator$onFormFocusChanged$1 INSTANCE = new ConversationScreenCoordinator$onFormFocusChanged$1();

    ConversationScreenCoordinator$onFormFocusChanged$1() {
        super(1);
    }

    public final Function1<Boolean, Unit> invoke(final ConversationScreenViewModel conversationScreenViewModel) {
        Intrinsics.checkNotNullParameter(conversationScreenViewModel, DatabaseConstants.STORE_TABLE_NAME);
        return new Function1<Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    conversationScreenViewModel.dispatchAction(ConversationScreenAction.HideMessageComposer.INSTANCE);
                } else {
                    conversationScreenViewModel.dispatchAction(ConversationScreenAction.ShowMessageComposer.INSTANCE);
                }
            }
        };
    }
}
