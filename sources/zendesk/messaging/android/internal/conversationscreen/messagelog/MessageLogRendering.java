package zendesk.messaging.android.internal.conversationscreen.messagelog;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.model.Field;
import zendesk.conversationkit.android.model.MessageAction;
import zendesk.messaging.android.internal.StubUriHandler;
import zendesk.messaging.android.internal.UriHandler;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.ui.android.conversation.form.DisplayedField;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001/B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010.\u001a\u00020\u0004R$\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR0\u0010\r\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u000ej\u0002`\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\fR$\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u001aX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\fR \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\fR$\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\t0\u0007j\u0002` X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\fR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0#X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020'X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020+X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u00060"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogRendering;", "", "()V", "builder", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogRendering$Builder;", "(Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogRendering$Builder;)V", "onFailedMessageClicked", "Lkotlin/Function1;", "Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;", "", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFailedMessageClickedListener;", "getOnFailedMessageClicked$zendesk_messaging_messaging_android", "()Lkotlin/jvm/functions/Function1;", "onFormCompleted", "Lkotlin/Function2;", "", "Lzendesk/conversationkit/android/model/Field;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormCompleted;", "getOnFormCompleted$zendesk_messaging_messaging_android", "()Lkotlin/jvm/functions/Function2;", "onFormDisplayedFieldsChanged", "Lzendesk/ui/android/conversation/form/DisplayedField;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormDisplayedFieldsChanged;", "getOnFormDisplayedFieldsChanged$zendesk_messaging_messaging_android", "onFormFocusChanged", "", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormFocusChangedListener;", "getOnFormFocusChanged$zendesk_messaging_messaging_android", "onLoadMoreListener", "getOnLoadMoreListener$zendesk_messaging_messaging_android", "onReplyActionSelected", "Lzendesk/conversationkit/android/model/MessageAction$Reply;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnReplyActionSelected;", "getOnReplyActionSelected$zendesk_messaging_messaging_android", "onRetryLoadMoreClickedListener", "Lkotlin/Function0;", "getOnRetryLoadMoreClickedListener$zendesk_messaging_messaging_android", "()Lkotlin/jvm/functions/Function0;", "onUriClicked", "Lzendesk/messaging/android/internal/UriHandler;", "getOnUriClicked$zendesk_messaging_messaging_android", "()Lzendesk/messaging/android/internal/UriHandler;", "state", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogState;", "getState$zendesk_messaging_messaging_android", "()Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogState;", "toBuilder", "Builder", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLogRendering.kt */
public final class MessageLogRendering {
    private final Function1<MessageLogEntry.MessageContainer, Unit> onFailedMessageClicked;
    private final Function2<List<? extends Field>, MessageLogEntry.MessageContainer, Unit> onFormCompleted;
    private final Function1<DisplayedField, Unit> onFormDisplayedFieldsChanged;
    private final Function1<Boolean, Unit> onFormFocusChanged;
    private final Function1<Boolean, Unit> onLoadMoreListener;
    private final Function1<MessageAction.Reply, Unit> onReplyActionSelected;
    private final Function0<Unit> onRetryLoadMoreClickedListener;
    private final UriHandler onUriClicked;
    private final MessageLogState state;

    public MessageLogRendering(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.onReplyActionSelected = builder.getOnReplyActionSelected$zendesk_messaging_messaging_android();
        this.onFailedMessageClicked = builder.getOnFailedMessageClicked$zendesk_messaging_messaging_android();
        this.onUriClicked = builder.getOnUriClicked$zendesk_messaging_messaging_android();
        this.onFormCompleted = builder.getOnFormCompleted$zendesk_messaging_messaging_android();
        this.onFormFocusChanged = builder.getOnFormFocusChanged$zendesk_messaging_messaging_android();
        this.onFormDisplayedFieldsChanged = builder.getOnFormDisplayedFieldsChanged$zendesk_messaging_messaging_android();
        this.onLoadMoreListener = builder.getOnLoadMoreListener$zendesk_messaging_messaging_android();
        this.onRetryLoadMoreClickedListener = builder.getOnRetryLoadMoreClickedListener$zendesk_messaging_messaging_android();
        this.state = builder.getState$zendesk_messaging_messaging_android();
    }

    public final Function1<MessageAction.Reply, Unit> getOnReplyActionSelected$zendesk_messaging_messaging_android() {
        return this.onReplyActionSelected;
    }

    public final Function1<MessageLogEntry.MessageContainer, Unit> getOnFailedMessageClicked$zendesk_messaging_messaging_android() {
        return this.onFailedMessageClicked;
    }

    public final UriHandler getOnUriClicked$zendesk_messaging_messaging_android() {
        return this.onUriClicked;
    }

    public final Function2<List<? extends Field>, MessageLogEntry.MessageContainer, Unit> getOnFormCompleted$zendesk_messaging_messaging_android() {
        return this.onFormCompleted;
    }

    public final Function1<Boolean, Unit> getOnFormFocusChanged$zendesk_messaging_messaging_android() {
        return this.onFormFocusChanged;
    }

    public final Function1<DisplayedField, Unit> getOnFormDisplayedFieldsChanged$zendesk_messaging_messaging_android() {
        return this.onFormDisplayedFieldsChanged;
    }

    public final Function1<Boolean, Unit> getOnLoadMoreListener$zendesk_messaging_messaging_android() {
        return this.onLoadMoreListener;
    }

    public final Function0<Unit> getOnRetryLoadMoreClickedListener$zendesk_messaging_messaging_android() {
        return this.onRetryLoadMoreClickedListener;
    }

    public final MessageLogState getState$zendesk_messaging_messaging_android() {
        return this.state;
    }

    public MessageLogRendering() {
        this(new Builder());
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010<\u001a\u00020\u0003J\u001e\u0010\u0006\u001a\u00020\u00002\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\nJ*\u0010\u000f\u001a\u00020\u00002\"\u0010\u000f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0010j\u0002`\u0013J\u001e\u0010\u0018\u001a\u00020\u00002\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u001aJ\u001e\u0010\u001d\u001a\u00020\u00002\u0016\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u001fJ\u001a\u0010\"\u001a\u00020\u00002\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\t0\u0007J\u001e\u0010%\u001a\u00020\u00002\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\t0\u0007j\u0002`'J\u0014\u0010*\u001a\u00020\u00002\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\t0+J\u000e\u00100\u001a\u00020\u00002\u0006\u0010>\u001a\u000201J\u001a\u00106\u001a\u00020\u00002\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u0002070\u0007R*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR6\u0010\u000f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0010j\u0002`\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR*\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR&\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\t0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR*\u0010%\u001a\u0012\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\t0\u0007j\u0002`'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR \u0010*\u001a\b\u0012\u0004\u0012\u00020\t0+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000207X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006@"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogRendering$Builder;", "", "rendering", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogRendering;", "(Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogRendering;)V", "()V", "onFailedMessageClicked", "Lkotlin/Function1;", "Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;", "", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFailedMessageClickedListener;", "getOnFailedMessageClicked$zendesk_messaging_messaging_android", "()Lkotlin/jvm/functions/Function1;", "setOnFailedMessageClicked$zendesk_messaging_messaging_android", "(Lkotlin/jvm/functions/Function1;)V", "onFormCompleted", "Lkotlin/Function2;", "", "Lzendesk/conversationkit/android/model/Field;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormCompleted;", "getOnFormCompleted$zendesk_messaging_messaging_android", "()Lkotlin/jvm/functions/Function2;", "setOnFormCompleted$zendesk_messaging_messaging_android", "(Lkotlin/jvm/functions/Function2;)V", "onFormDisplayedFieldsChanged", "Lzendesk/ui/android/conversation/form/DisplayedField;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormDisplayedFieldsChanged;", "getOnFormDisplayedFieldsChanged$zendesk_messaging_messaging_android", "setOnFormDisplayedFieldsChanged$zendesk_messaging_messaging_android", "onFormFocusChanged", "", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormFocusChangedListener;", "getOnFormFocusChanged$zendesk_messaging_messaging_android", "setOnFormFocusChanged$zendesk_messaging_messaging_android", "onLoadMoreListener", "getOnLoadMoreListener$zendesk_messaging_messaging_android", "setOnLoadMoreListener$zendesk_messaging_messaging_android", "onReplyActionSelected", "Lzendesk/conversationkit/android/model/MessageAction$Reply;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnReplyActionSelected;", "getOnReplyActionSelected$zendesk_messaging_messaging_android", "setOnReplyActionSelected$zendesk_messaging_messaging_android", "onRetryLoadMoreClickedListener", "Lkotlin/Function0;", "getOnRetryLoadMoreClickedListener$zendesk_messaging_messaging_android", "()Lkotlin/jvm/functions/Function0;", "setOnRetryLoadMoreClickedListener$zendesk_messaging_messaging_android", "(Lkotlin/jvm/functions/Function0;)V", "onUriClicked", "Lzendesk/messaging/android/internal/UriHandler;", "getOnUriClicked$zendesk_messaging_messaging_android", "()Lzendesk/messaging/android/internal/UriHandler;", "setOnUriClicked$zendesk_messaging_messaging_android", "(Lzendesk/messaging/android/internal/UriHandler;)V", "state", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogState;", "getState$zendesk_messaging_messaging_android", "()Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogState;", "setState$zendesk_messaging_messaging_android", "(Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogState;)V", "build", "onFormFocusChangedListener", "uriHandler", "stateUpdate", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageLogRendering.kt */
    public static final class Builder {
        private Function1<? super MessageLogEntry.MessageContainer, Unit> onFailedMessageClicked;
        private Function2<? super List<? extends Field>, ? super MessageLogEntry.MessageContainer, Unit> onFormCompleted;
        private Function1<? super DisplayedField, Unit> onFormDisplayedFieldsChanged;
        private Function1<? super Boolean, Unit> onFormFocusChanged;
        private Function1<? super Boolean, Unit> onLoadMoreListener;
        private Function1<? super MessageAction.Reply, Unit> onReplyActionSelected;
        private Function0<Unit> onRetryLoadMoreClickedListener;
        private UriHandler onUriClicked;
        private MessageLogState state;

        public Builder() {
            this.onReplyActionSelected = MessageLogListenersKt.getNOOP_ON_QUICK_REPLY_OPTION_SELECTED_LISTENER();
            this.onFailedMessageClicked = MessageLogListenersKt.getNOOP_ON_MESSAGE_CONTAINER_CLICKED_LISTENER();
            this.onUriClicked = StubUriHandler.INSTANCE;
            this.onFormCompleted = MessageLogListenersKt.getNOOP_ON_FORM_COMPLETED();
            this.onFormFocusChanged = MessageLogListenersKt.getNOOP_ON_FORM_FOCUS_CHANGED_LISTENER();
            this.state = new MessageLogState((List) null, false, (Map) null, false, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 255, (DefaultConstructorMarker) null);
            this.onFormDisplayedFieldsChanged = MessageLogListenersKt.getNOOP_ON_FORM_DISPLAYED_FIELDS_CHANGED();
            this.onRetryLoadMoreClickedListener = MessageLogRendering$Builder$onRetryLoadMoreClickedListener$1.INSTANCE;
            this.onLoadMoreListener = MessageLogRendering$Builder$onLoadMoreListener$1.INSTANCE;
        }

        public final Function1<MessageAction.Reply, Unit> getOnReplyActionSelected$zendesk_messaging_messaging_android() {
            return this.onReplyActionSelected;
        }

        public final void setOnReplyActionSelected$zendesk_messaging_messaging_android(Function1<? super MessageAction.Reply, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.onReplyActionSelected = function1;
        }

        public final Function1<MessageLogEntry.MessageContainer, Unit> getOnFailedMessageClicked$zendesk_messaging_messaging_android() {
            return this.onFailedMessageClicked;
        }

        public final void setOnFailedMessageClicked$zendesk_messaging_messaging_android(Function1<? super MessageLogEntry.MessageContainer, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.onFailedMessageClicked = function1;
        }

        public final UriHandler getOnUriClicked$zendesk_messaging_messaging_android() {
            return this.onUriClicked;
        }

        public final void setOnUriClicked$zendesk_messaging_messaging_android(UriHandler uriHandler) {
            Intrinsics.checkNotNullParameter(uriHandler, "<set-?>");
            this.onUriClicked = uriHandler;
        }

        public final Function2<List<? extends Field>, MessageLogEntry.MessageContainer, Unit> getOnFormCompleted$zendesk_messaging_messaging_android() {
            return this.onFormCompleted;
        }

        public final void setOnFormCompleted$zendesk_messaging_messaging_android(Function2<? super List<? extends Field>, ? super MessageLogEntry.MessageContainer, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "<set-?>");
            this.onFormCompleted = function2;
        }

        public final Function1<Boolean, Unit> getOnFormFocusChanged$zendesk_messaging_messaging_android() {
            return this.onFormFocusChanged;
        }

        public final void setOnFormFocusChanged$zendesk_messaging_messaging_android(Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.onFormFocusChanged = function1;
        }

        public final MessageLogState getState$zendesk_messaging_messaging_android() {
            return this.state;
        }

        public final void setState$zendesk_messaging_messaging_android(MessageLogState messageLogState) {
            Intrinsics.checkNotNullParameter(messageLogState, "<set-?>");
            this.state = messageLogState;
        }

        public final Function1<DisplayedField, Unit> getOnFormDisplayedFieldsChanged$zendesk_messaging_messaging_android() {
            return this.onFormDisplayedFieldsChanged;
        }

        public final void setOnFormDisplayedFieldsChanged$zendesk_messaging_messaging_android(Function1<? super DisplayedField, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.onFormDisplayedFieldsChanged = function1;
        }

        public final Function0<Unit> getOnRetryLoadMoreClickedListener$zendesk_messaging_messaging_android() {
            return this.onRetryLoadMoreClickedListener;
        }

        public final void setOnRetryLoadMoreClickedListener$zendesk_messaging_messaging_android(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "<set-?>");
            this.onRetryLoadMoreClickedListener = function0;
        }

        public final Function1<Boolean, Unit> getOnLoadMoreListener$zendesk_messaging_messaging_android() {
            return this.onLoadMoreListener;
        }

        public final void setOnLoadMoreListener$zendesk_messaging_messaging_android(Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.onLoadMoreListener = function1;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(MessageLogRendering messageLogRendering) {
            this();
            Intrinsics.checkNotNullParameter(messageLogRendering, "rendering");
            this.onReplyActionSelected = messageLogRendering.getOnReplyActionSelected$zendesk_messaging_messaging_android();
            this.onFailedMessageClicked = messageLogRendering.getOnFailedMessageClicked$zendesk_messaging_messaging_android();
            this.onUriClicked = messageLogRendering.getOnUriClicked$zendesk_messaging_messaging_android();
            this.onFormFocusChanged = messageLogRendering.getOnFormFocusChanged$zendesk_messaging_messaging_android();
            this.onFormDisplayedFieldsChanged = messageLogRendering.getOnFormDisplayedFieldsChanged$zendesk_messaging_messaging_android();
            this.onLoadMoreListener = messageLogRendering.getOnLoadMoreListener$zendesk_messaging_messaging_android();
            this.onRetryLoadMoreClickedListener = messageLogRendering.getOnRetryLoadMoreClickedListener$zendesk_messaging_messaging_android();
            this.state = messageLogRendering.getState$zendesk_messaging_messaging_android();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(MessageLogRendering messageLogRendering, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new MessageLogRendering() : messageLogRendering);
        }

        public final Builder onReplyActionSelected(Function1<? super MessageAction.Reply, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "onReplyActionSelected");
            Builder builder = this;
            this.onReplyActionSelected = function1;
            return this;
        }

        public final Builder onFailedMessageClicked(Function1<? super MessageLogEntry.MessageContainer, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "onFailedMessageClicked");
            Builder builder = this;
            this.onFailedMessageClicked = function1;
            return this;
        }

        public final Builder onUriClicked(UriHandler uriHandler) {
            Intrinsics.checkNotNullParameter(uriHandler, "uriHandler");
            Builder builder = this;
            this.onUriClicked = uriHandler;
            return this;
        }

        public final Builder onFormCompleted(Function2<? super List<? extends Field>, ? super MessageLogEntry.MessageContainer, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "onFormCompleted");
            Builder builder = this;
            this.onFormCompleted = function2;
            return this;
        }

        public final Builder onFormFocusChanged(Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "onFormFocusChangedListener");
            Builder builder = this;
            this.onFormFocusChanged = function1;
            return this;
        }

        public final Builder onFormDisplayedFieldsChanged(Function1<? super DisplayedField, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "onFormDisplayedFieldsChanged");
            Builder builder = this;
            this.onFormDisplayedFieldsChanged = function1;
            return this;
        }

        public final Builder onLoadMoreListener(Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "onLoadMoreListener");
            Builder builder = this;
            this.onLoadMoreListener = function1;
            return this;
        }

        public final Builder onRetryLoadMoreClickedListener(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "onRetryLoadMoreClickedListener");
            Builder builder = this;
            this.onRetryLoadMoreClickedListener = function0;
            return this;
        }

        public final Builder state(Function1<? super MessageLogState, MessageLogState> function1) {
            Intrinsics.checkNotNullParameter(function1, "stateUpdate");
            Builder builder = this;
            this.state = function1.invoke(this.state);
            return this;
        }

        public final MessageLogRendering build() {
            return new MessageLogRendering(this);
        }
    }
}
