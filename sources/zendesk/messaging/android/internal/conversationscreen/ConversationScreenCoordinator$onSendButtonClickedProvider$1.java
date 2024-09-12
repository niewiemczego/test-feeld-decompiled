package zendesk.messaging.android.internal.conversationscreen;

import com.amplitude.reactnative.DatabaseConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lkotlin/Function1;", "", "", "store", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModel;", "conversationId", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationScreenCoordinator.kt */
final class ConversationScreenCoordinator$onSendButtonClickedProvider$1 extends Lambda implements Function2<ConversationScreenViewModel, String, Function1<? super String, ? extends Unit>> {
    final /* synthetic */ ConversationScreenCoordinator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationScreenCoordinator$onSendButtonClickedProvider$1(ConversationScreenCoordinator conversationScreenCoordinator) {
        super(2);
        this.this$0 = conversationScreenCoordinator;
    }

    public final Function1<String, Unit> invoke(final ConversationScreenViewModel conversationScreenViewModel, final String str) {
        Intrinsics.checkNotNullParameter(conversationScreenViewModel, DatabaseConstants.STORE_TABLE_NAME);
        final ConversationScreenCoordinator conversationScreenCoordinator = this.this$0;
        return new Function1<String, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "textMessage");
                String str2 = str;
                if (str2 != null) {
                    ConversationScreenCoordinator conversationScreenCoordinator = conversationScreenCoordinator;
                    ConversationScreenViewModel conversationScreenViewModel = conversationScreenViewModel;
                    conversationScreenCoordinator.conversationTypingEvents.onSendMessage(str2);
                    conversationScreenViewModel.dispatchAction(new ConversationScreenAction.SendTextMessage(str, (String) null, (Map) null, str2, 6, (DefaultConstructorMarker) null));
                }
            }
        };
    }
}
