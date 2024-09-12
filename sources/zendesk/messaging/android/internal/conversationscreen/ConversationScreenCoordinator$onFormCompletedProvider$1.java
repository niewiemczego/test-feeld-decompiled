package zendesk.messaging.android.internal.conversationscreen;

import com.amplitude.reactnative.DatabaseConstants;
import com.facebook.GraphRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.conversationkit.android.model.Field;
import zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction;
import zendesk.messaging.android.internal.model.MessageLogEntry;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "Lkotlin/Function2;", "", "Lzendesk/conversationkit/android/model/Field;", "Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;", "", "store", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModel;", "conversationId", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationScreenCoordinator.kt */
final class ConversationScreenCoordinator$onFormCompletedProvider$1 extends Lambda implements Function2<ConversationScreenViewModel, String, Function2<? super List<? extends Field>, ? super MessageLogEntry.MessageContainer, ? extends Unit>> {
    public static final ConversationScreenCoordinator$onFormCompletedProvider$1 INSTANCE = new ConversationScreenCoordinator$onFormCompletedProvider$1();

    ConversationScreenCoordinator$onFormCompletedProvider$1() {
        super(2);
    }

    public final Function2<List<? extends Field>, MessageLogEntry.MessageContainer, Unit> invoke(final ConversationScreenViewModel conversationScreenViewModel, final String str) {
        Intrinsics.checkNotNullParameter(conversationScreenViewModel, DatabaseConstants.STORE_TABLE_NAME);
        return new Function2<List<? extends Field>, MessageLogEntry.MessageContainer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((List<? extends Field>) (List) obj, (MessageLogEntry.MessageContainer) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(List<? extends Field> list, MessageLogEntry.MessageContainer messageContainer) {
                Intrinsics.checkNotNullParameter(list, GraphRequest.FIELDS_PARAM);
                Intrinsics.checkNotNullParameter(messageContainer, "formMessageContainer");
                String str = str;
                if (str != null) {
                    conversationScreenViewModel.dispatchAction(new ConversationScreenAction.SendFormResponse(list, messageContainer, str));
                }
            }
        };
    }
}
