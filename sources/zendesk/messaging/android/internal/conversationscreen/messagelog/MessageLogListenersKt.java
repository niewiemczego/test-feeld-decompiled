package zendesk.messaging.android.internal.conversationscreen.messagelog;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import zendesk.conversationkit.android.model.Field;
import zendesk.conversationkit.android.model.MessageAction;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.ui.android.conversation.form.DisplayedField;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\"0\u0010\u0000\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"$\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\nj\u0002`\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\"$\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\nj\u0002`\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"$\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\nj\u0002`\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"$\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00050\nj\u0002`\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u001e\u0010\u001a\u001a\f\u0012\u0004\u0012\u00020\u00050\u001bj\u0002`\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e*$\b\u0000\u0010\u001f\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\n2\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\n*<\b\u0000\u0010 \"\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001*$\b\u0000\u0010!\"\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\n2\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\n*$\b\u0000\u0010\"\"\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\n2\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\n*$\b\u0000\u0010#\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\n2\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\n*$\b\u0000\u0010$\"\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00050\n2\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00050\n*$\b\u0000\u0010&\"\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00050\n2\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00050\n*\u0018\b\u0000\u0010'\"\b\u0012\u0004\u0012\u00020\u00050\u001b2\b\u0012\u0004\u0012\u00020\u00050\u001b¨\u0006("}, d2 = {"NOOP_ON_FORM_COMPLETED", "Lkotlin/Function2;", "", "Lzendesk/conversationkit/android/model/Field;", "Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;", "", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormCompleted;", "getNOOP_ON_FORM_COMPLETED", "()Lkotlin/jvm/functions/Function2;", "NOOP_ON_FORM_DISPLAYED_FIELDS_CHANGED", "Lkotlin/Function1;", "Lzendesk/ui/android/conversation/form/DisplayedField;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormDisplayedFieldsChanged;", "getNOOP_ON_FORM_DISPLAYED_FIELDS_CHANGED", "()Lkotlin/jvm/functions/Function1;", "NOOP_ON_FORM_FOCUS_CHANGED_LISTENER", "", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormFocusChangedListener;", "getNOOP_ON_FORM_FOCUS_CHANGED_LISTENER", "NOOP_ON_MESSAGE_CONTAINER_CLICKED_LISTENER", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFailedMessageClickedListener;", "getNOOP_ON_MESSAGE_CONTAINER_CLICKED_LISTENER", "NOOP_ON_QUICK_REPLY_OPTION_SELECTED_LISTENER", "Lzendesk/conversationkit/android/model/MessageAction$Reply;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnReplyActionSelected;", "getNOOP_ON_QUICK_REPLY_OPTION_SELECTED_LISTENER", "NOOP_ON_RETRY_CONNECTION_CLICKED_LISTENER", "Lkotlin/Function0;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnRetryConnectionClickedListener;", "getNOOP_ON_RETRY_CONNECTION_CLICKED_LISTENER", "()Lkotlin/jvm/functions/Function0;", "OnFailedMessageClickedListener", "OnFormCompleted", "OnFormDisplayedFieldsChanged", "OnFormFocusChangedListener", "OnMessageClickedListener", "OnQuickReplyOptionListener", "Lzendesk/ui/android/conversation/quickreply/QuickReplyOption;", "OnReplyActionSelected", "OnRetryConnectionClickedListener", "zendesk.messaging_messaging-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLogListeners.kt */
public final class MessageLogListenersKt {
    private static final Function2<List<? extends Field>, MessageLogEntry.MessageContainer, Unit> NOOP_ON_FORM_COMPLETED = MessageLogListenersKt$NOOP_ON_FORM_COMPLETED$1.INSTANCE;
    private static final Function1<DisplayedField, Unit> NOOP_ON_FORM_DISPLAYED_FIELDS_CHANGED = MessageLogListenersKt$NOOP_ON_FORM_DISPLAYED_FIELDS_CHANGED$1.INSTANCE;
    private static final Function1<Boolean, Unit> NOOP_ON_FORM_FOCUS_CHANGED_LISTENER = MessageLogListenersKt$NOOP_ON_FORM_FOCUS_CHANGED_LISTENER$1.INSTANCE;
    private static final Function1<MessageLogEntry.MessageContainer, Unit> NOOP_ON_MESSAGE_CONTAINER_CLICKED_LISTENER = MessageLogListenersKt$NOOP_ON_MESSAGE_CONTAINER_CLICKED_LISTENER$1.INSTANCE;
    private static final Function1<MessageAction.Reply, Unit> NOOP_ON_QUICK_REPLY_OPTION_SELECTED_LISTENER = MessageLogListenersKt$NOOP_ON_QUICK_REPLY_OPTION_SELECTED_LISTENER$1.INSTANCE;
    private static final Function0<Unit> NOOP_ON_RETRY_CONNECTION_CLICKED_LISTENER = MessageLogListenersKt$NOOP_ON_RETRY_CONNECTION_CLICKED_LISTENER$1.INSTANCE;

    public static final Function1<MessageAction.Reply, Unit> getNOOP_ON_QUICK_REPLY_OPTION_SELECTED_LISTENER() {
        return NOOP_ON_QUICK_REPLY_OPTION_SELECTED_LISTENER;
    }

    public static final Function1<MessageLogEntry.MessageContainer, Unit> getNOOP_ON_MESSAGE_CONTAINER_CLICKED_LISTENER() {
        return NOOP_ON_MESSAGE_CONTAINER_CLICKED_LISTENER;
    }

    public static final Function2<List<? extends Field>, MessageLogEntry.MessageContainer, Unit> getNOOP_ON_FORM_COMPLETED() {
        return NOOP_ON_FORM_COMPLETED;
    }

    public static final Function0<Unit> getNOOP_ON_RETRY_CONNECTION_CLICKED_LISTENER() {
        return NOOP_ON_RETRY_CONNECTION_CLICKED_LISTENER;
    }

    public static final Function1<Boolean, Unit> getNOOP_ON_FORM_FOCUS_CHANGED_LISTENER() {
        return NOOP_ON_FORM_FOCUS_CHANGED_LISTENER;
    }

    public static final Function1<DisplayedField, Unit> getNOOP_ON_FORM_DISPLAYED_FIELDS_CHANGED() {
        return NOOP_ON_FORM_DISPLAYED_FIELDS_CHANGED;
    }
}
