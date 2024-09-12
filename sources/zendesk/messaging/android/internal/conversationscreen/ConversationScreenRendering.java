package zendesk.messaging.android.internal.conversationscreen;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.messaging.model.ColorTheme;
import zendesk.conversationkit.android.ConnectionStatus;
import zendesk.conversationkit.android.model.Conversation;
import zendesk.conversationkit.android.model.Field;
import zendesk.conversationkit.android.model.MessageAction;
import zendesk.messaging.android.internal.StubUriHandler;
import zendesk.messaging.android.internal.UriHandler;
import zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogListenersKt;
import zendesk.messaging.android.internal.model.LoadMoreStatus;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.messaging.android.internal.model.TypingUser;
import zendesk.ui.android.conversation.form.DisplayedField;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001EB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010D\u001a\u00020\u0004R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\f\u0012\u0004\u0012\u00020\t0\rj\u0002`\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\f\u0012\u0004\u0012\u00020\t0\rj\u0002`\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0013\u001a\f\u0012\u0004\u0012\u00020\t0\rj\u0002`\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R$\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000bR0\u0010\u0019\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u001aj\u0002`\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0012\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\"X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u000bR$\u0010$\u001a\u0012\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\t0\u0007j\u0002`&X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u000bR \u0010(\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u000bR \u0010+\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u000bR$\u0010.\u001a\u0012\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\t0\u0007j\u0002`0X\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u000bR\u001e\u00102\u001a\f\u0012\u0004\u0012\u00020\t0\rj\u0002`3X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0010R \u00105\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u000bR$\u00107\u001a\u0012\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\t0\u0007j\u0002`8X\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u000bR\u001e\u0010:\u001a\f\u0012\u0004\u0012\u00020\t0\rj\u0002`\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0010R\u0014\u0010<\u001a\u00020=X\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020AX\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010C¨\u0006F"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenRendering;", "", "()V", "builder", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenRendering$Builder;", "(Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenRendering$Builder;)V", "onAttachButtonClicked", "Lkotlin/Function1;", "", "", "getOnAttachButtonClicked$zendesk_messaging_messaging_android", "()Lkotlin/jvm/functions/Function1;", "onBackButtonClicked", "Lkotlin/Function0;", "Lzendesk/messaging/android/internal/conversationscreen/OnClickLambda;", "getOnBackButtonClicked$zendesk_messaging_messaging_android", "()Lkotlin/jvm/functions/Function0;", "onDeniedPermissionActionClicked", "getOnDeniedPermissionActionClicked$zendesk_messaging_messaging_android", "onDeniedPermissionDismissed", "getOnDeniedPermissionDismissed$zendesk_messaging_messaging_android", "onFailedMessageClicked", "Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFailedMessageClickedListener;", "getOnFailedMessageClicked$zendesk_messaging_messaging_android", "onFormCompleted", "Lkotlin/Function2;", "", "Lzendesk/conversationkit/android/model/Field;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormCompleted;", "getOnFormCompleted$zendesk_messaging_messaging_android", "()Lkotlin/jvm/functions/Function2;", "onFormDisplayedFieldsChanged", "Lzendesk/ui/android/conversation/form/DisplayedField;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormDisplayedFieldsChanged;", "getOnFormDisplayedFieldsChanged$zendesk_messaging_messaging_android", "onFormFocusChanged", "", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormFocusChangedListener;", "getOnFormFocusChanged$zendesk_messaging_messaging_android", "onLoadMoreMessages", "", "getOnLoadMoreMessages$zendesk_messaging_messaging_android", "onMessageComposerTextChanged", "", "getOnMessageComposerTextChanged$zendesk_messaging_messaging_android", "onReplyActionSelected", "Lzendesk/conversationkit/android/model/MessageAction$Reply;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnReplyActionSelected;", "getOnReplyActionSelected$zendesk_messaging_messaging_android", "onRetryConnectionClicked", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnRetryConnectionClickedListener;", "getOnRetryConnectionClicked$zendesk_messaging_messaging_android", "onRetryLoadMoreClickedListener", "getOnRetryLoadMoreClickedListener$zendesk_messaging_messaging_android", "onSendButtonClicked", "Lzendesk/messaging/android/internal/conversationscreen/OnSendButtonClickLambda;", "getOnSendButtonClicked$zendesk_messaging_messaging_android", "onTyping", "getOnTyping$zendesk_messaging_messaging_android", "onUriClicked", "Lzendesk/messaging/android/internal/UriHandler;", "getOnUriClicked$zendesk_messaging_messaging_android", "()Lzendesk/messaging/android/internal/UriHandler;", "state", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenState;", "getState$zendesk_messaging_messaging_android", "()Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenState;", "toBuilder", "Builder", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationScreenRendering.kt */
public final class ConversationScreenRendering {
    private final Function1<Integer, Unit> onAttachButtonClicked;
    private final Function0<Unit> onBackButtonClicked;
    private final Function0<Unit> onDeniedPermissionActionClicked;
    private final Function0<Unit> onDeniedPermissionDismissed;
    private final Function1<MessageLogEntry.MessageContainer, Unit> onFailedMessageClicked;
    private final Function2<List<? extends Field>, MessageLogEntry.MessageContainer, Unit> onFormCompleted;
    private final Function1<DisplayedField, Unit> onFormDisplayedFieldsChanged;
    private final Function1<Boolean, Unit> onFormFocusChanged;
    private final Function1<Double, Unit> onLoadMoreMessages;
    private final Function1<String, Unit> onMessageComposerTextChanged;
    private final Function1<MessageAction.Reply, Unit> onReplyActionSelected;
    private final Function0<Unit> onRetryConnectionClicked;
    private final Function1<Double, Unit> onRetryLoadMoreClickedListener;
    private final Function1<String, Unit> onSendButtonClicked;
    private final Function0<Unit> onTyping;
    private final UriHandler onUriClicked;
    private final ConversationScreenState state;

    public ConversationScreenRendering(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.onFormFocusChanged = builder.getOnFormFocusChanged$zendesk_messaging_messaging_android();
        this.onBackButtonClicked = builder.getOnBackButtonClicked$zendesk_messaging_messaging_android();
        this.onSendButtonClicked = builder.getOnSendButtonClicked$zendesk_messaging_messaging_android();
        this.onAttachButtonClicked = builder.getOnAttachButtonClicked$zendesk_messaging_messaging_android();
        this.onReplyActionSelected = builder.getOnReplyActionSelected$zendesk_messaging_messaging_android();
        this.onFailedMessageClicked = builder.getOnFailedMessageClicked$zendesk_messaging_messaging_android();
        this.onRetryConnectionClicked = builder.getOnRetryConnectionClickedListener$zendesk_messaging_messaging_android();
        this.onUriClicked = builder.getOnUriClicked$zendesk_messaging_messaging_android();
        this.onFormCompleted = builder.getOnFormCompleted$zendesk_messaging_messaging_android();
        this.onTyping = builder.getOnTyping$zendesk_messaging_messaging_android();
        this.onMessageComposerTextChanged = builder.getOnMessageComposerTextChanged$zendesk_messaging_messaging_android();
        this.onDeniedPermissionActionClicked = builder.getOnDeniedPermissionActionClicked$zendesk_messaging_messaging_android();
        this.onDeniedPermissionDismissed = builder.getOnDeniedPermissionDismissed$zendesk_messaging_messaging_android();
        this.onFormDisplayedFieldsChanged = builder.getOnFormDisplayedFieldsChanged$zendesk_messaging_messaging_android();
        this.onLoadMoreMessages = builder.getOnLoadMoreMessages$zendesk_messaging_messaging_android();
        this.onRetryLoadMoreClickedListener = builder.getOnRetryLoadMoreClickedListener$zendesk_messaging_messaging_android();
        this.state = builder.getState$zendesk_messaging_messaging_android();
    }

    public final Function1<Boolean, Unit> getOnFormFocusChanged$zendesk_messaging_messaging_android() {
        return this.onFormFocusChanged;
    }

    public final Function0<Unit> getOnBackButtonClicked$zendesk_messaging_messaging_android() {
        return this.onBackButtonClicked;
    }

    public final Function1<String, Unit> getOnSendButtonClicked$zendesk_messaging_messaging_android() {
        return this.onSendButtonClicked;
    }

    public final Function1<Integer, Unit> getOnAttachButtonClicked$zendesk_messaging_messaging_android() {
        return this.onAttachButtonClicked;
    }

    public final Function1<MessageAction.Reply, Unit> getOnReplyActionSelected$zendesk_messaging_messaging_android() {
        return this.onReplyActionSelected;
    }

    public final Function1<MessageLogEntry.MessageContainer, Unit> getOnFailedMessageClicked$zendesk_messaging_messaging_android() {
        return this.onFailedMessageClicked;
    }

    public final Function0<Unit> getOnRetryConnectionClicked$zendesk_messaging_messaging_android() {
        return this.onRetryConnectionClicked;
    }

    public final UriHandler getOnUriClicked$zendesk_messaging_messaging_android() {
        return this.onUriClicked;
    }

    public final Function2<List<? extends Field>, MessageLogEntry.MessageContainer, Unit> getOnFormCompleted$zendesk_messaging_messaging_android() {
        return this.onFormCompleted;
    }

    public final Function0<Unit> getOnTyping$zendesk_messaging_messaging_android() {
        return this.onTyping;
    }

    public final Function1<String, Unit> getOnMessageComposerTextChanged$zendesk_messaging_messaging_android() {
        return this.onMessageComposerTextChanged;
    }

    public final Function0<Unit> getOnDeniedPermissionActionClicked$zendesk_messaging_messaging_android() {
        return this.onDeniedPermissionActionClicked;
    }

    public final Function0<Unit> getOnDeniedPermissionDismissed$zendesk_messaging_messaging_android() {
        return this.onDeniedPermissionDismissed;
    }

    public final Function1<DisplayedField, Unit> getOnFormDisplayedFieldsChanged$zendesk_messaging_messaging_android() {
        return this.onFormDisplayedFieldsChanged;
    }

    public final Function1<Double, Unit> getOnLoadMoreMessages$zendesk_messaging_messaging_android() {
        return this.onLoadMoreMessages;
    }

    public final Function1<Double, Unit> getOnRetryLoadMoreClickedListener$zendesk_messaging_messaging_android() {
        return this.onRetryLoadMoreClickedListener;
    }

    public final ConversationScreenState getState$zendesk_messaging_messaging_android() {
        return this.state;
    }

    public ConversationScreenRendering() {
        this(new Builder());
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010Z\u001a\u00020\u0003J\u001a\u0010[\u001a\u00020\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007J\u0018\u0010\u000e\u001a\u00020\u00002\u0010\u0010\u000e\u001a\f\u0012\u0004\u0012\u00020\t0\u000fj\u0002`\u0010J\u0018\u0010\u0015\u001a\u00020\u00002\u0010\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\t0\u000fj\u0002`\u0010J\u0018\u0010\u0018\u001a\u00020\u00002\u0010\u0010\u0018\u001a\f\u0012\u0004\u0012\u00020\t0\u000fj\u0002`\u0010J\u001e\u0010\u001b\u001a\u00020\u00002\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u001dJ*\u0010 \u001a\u00020\u00002\"\u0010 \u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\t0!j\u0002`$J\u001e\u0010)\u001a\u00020\u00002\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\t0\u0007j\u0002`+J\u001e\u0010.\u001a\u00020\u00002\u0016\u0010.\u001a\u0012\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\t0\u0007j\u0002`0J\u001a\u00103\u001a\u00020\u00002\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\t0\u0007J\u001a\u00107\u001a\u00020\u00002\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\t0\u0007J\u001e\u0010;\u001a\u00020\u00002\u0016\u0010;\u001a\u0012\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\t0\u0007j\u0002`=J\u0018\u0010\\\u001a\u00020\u00002\u0010\u0010@\u001a\f\u0012\u0004\u0012\u00020\t0\u000fj\u0002`AJ\u001a\u0010D\u001a\u00020\u00002\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\t0\u0007J\u001e\u0010G\u001a\u00020\u00002\u0016\u0010G\u001a\u0012\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\t0\u0007j\u0002`HJ\u0018\u0010K\u001a\u00020\u00002\u0010\u0010K\u001a\f\u0012\u0004\u0012\u00020\t0\u000fj\u0002`\u0010J\u000e\u0010N\u001a\u00020\u00002\u0006\u0010]\u001a\u00020OJ\u001a\u0010T\u001a\u00020\u00002\u0012\u0010^\u001a\u000e\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020U0\u0007R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\f\u0012\u0004\u0012\u00020\t0\u000fj\u0002`\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\t0\u000fj\u0002`\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R$\u0010\u0018\u001a\f\u0012\u0004\u0012\u00020\t0\u000fj\u0002`\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R*\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010\rR6\u0010 \u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\t0!j\u0002`$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R*\u0010)\u001a\u0012\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\t0\u0007j\u0002`+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u000b\"\u0004\b-\u0010\rR*\u0010.\u001a\u0012\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\t0\u0007j\u0002`0X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000b\"\u0004\b2\u0010\rR&\u00103\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\t0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u000b\"\u0004\b6\u0010\rR&\u00107\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\t0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u000b\"\u0004\b:\u0010\rR*\u0010;\u001a\u0012\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\t0\u0007j\u0002`=X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u000b\"\u0004\b?\u0010\rR$\u0010@\u001a\f\u0012\u0004\u0012\u00020\t0\u000fj\u0002`AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0012\"\u0004\bC\u0010\u0014R&\u0010D\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\t0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u000b\"\u0004\bF\u0010\rR*\u0010G\u001a\u0012\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\t0\u0007j\u0002`HX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u000b\"\u0004\bJ\u0010\rR$\u0010K\u001a\f\u0012\u0004\u0012\u00020\t0\u000fj\u0002`\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0012\"\u0004\bM\u0010\u0014R\u001a\u0010N\u001a\u00020OX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001a\u0010T\u001a\u00020UX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010Y¨\u0006_"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenRendering$Builder;", "", "rendering", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenRendering;", "(Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenRendering;)V", "()V", "onAttachButtonClicked", "Lkotlin/Function1;", "", "", "getOnAttachButtonClicked$zendesk_messaging_messaging_android", "()Lkotlin/jvm/functions/Function1;", "setOnAttachButtonClicked$zendesk_messaging_messaging_android", "(Lkotlin/jvm/functions/Function1;)V", "onBackButtonClicked", "Lkotlin/Function0;", "Lzendesk/messaging/android/internal/conversationscreen/OnClickLambda;", "getOnBackButtonClicked$zendesk_messaging_messaging_android", "()Lkotlin/jvm/functions/Function0;", "setOnBackButtonClicked$zendesk_messaging_messaging_android", "(Lkotlin/jvm/functions/Function0;)V", "onDeniedPermissionActionClicked", "getOnDeniedPermissionActionClicked$zendesk_messaging_messaging_android", "setOnDeniedPermissionActionClicked$zendesk_messaging_messaging_android", "onDeniedPermissionDismissed", "getOnDeniedPermissionDismissed$zendesk_messaging_messaging_android", "setOnDeniedPermissionDismissed$zendesk_messaging_messaging_android", "onFailedMessageClicked", "Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFailedMessageClickedListener;", "getOnFailedMessageClicked$zendesk_messaging_messaging_android", "setOnFailedMessageClicked$zendesk_messaging_messaging_android", "onFormCompleted", "Lkotlin/Function2;", "", "Lzendesk/conversationkit/android/model/Field;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormCompleted;", "getOnFormCompleted$zendesk_messaging_messaging_android", "()Lkotlin/jvm/functions/Function2;", "setOnFormCompleted$zendesk_messaging_messaging_android", "(Lkotlin/jvm/functions/Function2;)V", "onFormDisplayedFieldsChanged", "Lzendesk/ui/android/conversation/form/DisplayedField;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormDisplayedFieldsChanged;", "getOnFormDisplayedFieldsChanged$zendesk_messaging_messaging_android", "setOnFormDisplayedFieldsChanged$zendesk_messaging_messaging_android", "onFormFocusChanged", "", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormFocusChangedListener;", "getOnFormFocusChanged$zendesk_messaging_messaging_android", "setOnFormFocusChanged$zendesk_messaging_messaging_android", "onLoadMoreMessages", "", "getOnLoadMoreMessages$zendesk_messaging_messaging_android", "setOnLoadMoreMessages$zendesk_messaging_messaging_android", "onMessageComposerTextChanged", "", "getOnMessageComposerTextChanged$zendesk_messaging_messaging_android", "setOnMessageComposerTextChanged$zendesk_messaging_messaging_android", "onReplyActionSelected", "Lzendesk/conversationkit/android/model/MessageAction$Reply;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnReplyActionSelected;", "getOnReplyActionSelected$zendesk_messaging_messaging_android", "setOnReplyActionSelected$zendesk_messaging_messaging_android", "onRetryConnectionClickedListener", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnRetryConnectionClickedListener;", "getOnRetryConnectionClickedListener$zendesk_messaging_messaging_android", "setOnRetryConnectionClickedListener$zendesk_messaging_messaging_android", "onRetryLoadMoreClickedListener", "getOnRetryLoadMoreClickedListener$zendesk_messaging_messaging_android", "setOnRetryLoadMoreClickedListener$zendesk_messaging_messaging_android", "onSendButtonClicked", "Lzendesk/messaging/android/internal/conversationscreen/OnSendButtonClickLambda;", "getOnSendButtonClicked$zendesk_messaging_messaging_android", "setOnSendButtonClicked$zendesk_messaging_messaging_android", "onTyping", "getOnTyping$zendesk_messaging_messaging_android", "setOnTyping$zendesk_messaging_messaging_android", "onUriClicked", "Lzendesk/messaging/android/internal/UriHandler;", "getOnUriClicked$zendesk_messaging_messaging_android", "()Lzendesk/messaging/android/internal/UriHandler;", "setOnUriClicked$zendesk_messaging_messaging_android", "(Lzendesk/messaging/android/internal/UriHandler;)V", "state", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenState;", "getState$zendesk_messaging_messaging_android", "()Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenState;", "setState$zendesk_messaging_messaging_android", "(Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenState;)V", "build", "onAttachMenuItemClicked", "onRetryConnectionButtonClicked", "uriHandler", "stateUpdate", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationScreenRendering.kt */
    public static final class Builder {
        private Function1<? super Integer, Unit> onAttachButtonClicked;
        private Function0<Unit> onBackButtonClicked;
        private Function0<Unit> onDeniedPermissionActionClicked;
        private Function0<Unit> onDeniedPermissionDismissed;
        private Function1<? super MessageLogEntry.MessageContainer, Unit> onFailedMessageClicked;
        private Function2<? super List<? extends Field>, ? super MessageLogEntry.MessageContainer, Unit> onFormCompleted;
        private Function1<? super DisplayedField, Unit> onFormDisplayedFieldsChanged;
        private Function1<? super Boolean, Unit> onFormFocusChanged;
        private Function1<? super Double, Unit> onLoadMoreMessages;
        private Function1<? super String, Unit> onMessageComposerTextChanged;
        private Function1<? super MessageAction.Reply, Unit> onReplyActionSelected;
        private Function0<Unit> onRetryConnectionClickedListener;
        private Function1<? super Double, Unit> onRetryLoadMoreClickedListener;
        private Function1<? super String, Unit> onSendButtonClicked;
        private Function0<Unit> onTyping;
        private UriHandler onUriClicked;
        private ConversationScreenState state;

        public Builder() {
            this.onFormFocusChanged = ConversationScreenRendering$Builder$onFormFocusChanged$1.INSTANCE;
            this.onBackButtonClicked = ConversationScreenRendering$Builder$onBackButtonClicked$1.INSTANCE;
            this.onAttachButtonClicked = ConversationScreenRendering$Builder$onAttachButtonClicked$1.INSTANCE;
            this.onSendButtonClicked = ConversationScreenRendering$Builder$onSendButtonClicked$1.INSTANCE;
            this.onUriClicked = StubUriHandler.INSTANCE;
            this.onReplyActionSelected = MessageLogListenersKt.getNOOP_ON_QUICK_REPLY_OPTION_SELECTED_LISTENER();
            this.onFailedMessageClicked = MessageLogListenersKt.getNOOP_ON_MESSAGE_CONTAINER_CLICKED_LISTENER();
            this.onRetryConnectionClickedListener = MessageLogListenersKt.getNOOP_ON_RETRY_CONNECTION_CLICKED_LISTENER();
            this.onFormCompleted = MessageLogListenersKt.getNOOP_ON_FORM_COMPLETED();
            this.onTyping = ConversationScreenRendering$Builder$onTyping$1.INSTANCE;
            this.onMessageComposerTextChanged = ConversationScreenRendering$Builder$onMessageComposerTextChanged$1.INSTANCE;
            this.onDeniedPermissionActionClicked = ConversationScreenRendering$Builder$onDeniedPermissionActionClicked$1.INSTANCE;
            this.onDeniedPermissionDismissed = ConversationScreenRendering$Builder$onDeniedPermissionDismissed$1.INSTANCE;
            this.state = new ConversationScreenState((ColorTheme) null, (String) null, (String) null, (String) null, (List) null, (Conversation) null, (Throwable) null, false, 0, (ConnectionStatus) null, false, false, (String) null, (Map) null, (TypingUser) null, (String) null, false, (LoadMoreStatus) null, false, 524287, (DefaultConstructorMarker) null);
            this.onFormDisplayedFieldsChanged = ConversationScreenRendering$Builder$onFormDisplayedFieldsChanged$1.INSTANCE;
            this.onLoadMoreMessages = ConversationScreenRendering$Builder$onLoadMoreMessages$1.INSTANCE;
            this.onRetryLoadMoreClickedListener = ConversationScreenRendering$Builder$onRetryLoadMoreClickedListener$1.INSTANCE;
        }

        public final Function1<Boolean, Unit> getOnFormFocusChanged$zendesk_messaging_messaging_android() {
            return this.onFormFocusChanged;
        }

        public final void setOnFormFocusChanged$zendesk_messaging_messaging_android(Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.onFormFocusChanged = function1;
        }

        public final Function0<Unit> getOnBackButtonClicked$zendesk_messaging_messaging_android() {
            return this.onBackButtonClicked;
        }

        public final void setOnBackButtonClicked$zendesk_messaging_messaging_android(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "<set-?>");
            this.onBackButtonClicked = function0;
        }

        public final Function1<Integer, Unit> getOnAttachButtonClicked$zendesk_messaging_messaging_android() {
            return this.onAttachButtonClicked;
        }

        public final void setOnAttachButtonClicked$zendesk_messaging_messaging_android(Function1<? super Integer, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.onAttachButtonClicked = function1;
        }

        public final Function1<String, Unit> getOnSendButtonClicked$zendesk_messaging_messaging_android() {
            return this.onSendButtonClicked;
        }

        public final void setOnSendButtonClicked$zendesk_messaging_messaging_android(Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.onSendButtonClicked = function1;
        }

        public final UriHandler getOnUriClicked$zendesk_messaging_messaging_android() {
            return this.onUriClicked;
        }

        public final void setOnUriClicked$zendesk_messaging_messaging_android(UriHandler uriHandler) {
            Intrinsics.checkNotNullParameter(uriHandler, "<set-?>");
            this.onUriClicked = uriHandler;
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

        public final Function0<Unit> getOnRetryConnectionClickedListener$zendesk_messaging_messaging_android() {
            return this.onRetryConnectionClickedListener;
        }

        public final void setOnRetryConnectionClickedListener$zendesk_messaging_messaging_android(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "<set-?>");
            this.onRetryConnectionClickedListener = function0;
        }

        public final Function2<List<? extends Field>, MessageLogEntry.MessageContainer, Unit> getOnFormCompleted$zendesk_messaging_messaging_android() {
            return this.onFormCompleted;
        }

        public final void setOnFormCompleted$zendesk_messaging_messaging_android(Function2<? super List<? extends Field>, ? super MessageLogEntry.MessageContainer, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "<set-?>");
            this.onFormCompleted = function2;
        }

        public final Function0<Unit> getOnTyping$zendesk_messaging_messaging_android() {
            return this.onTyping;
        }

        public final void setOnTyping$zendesk_messaging_messaging_android(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "<set-?>");
            this.onTyping = function0;
        }

        public final Function1<String, Unit> getOnMessageComposerTextChanged$zendesk_messaging_messaging_android() {
            return this.onMessageComposerTextChanged;
        }

        public final void setOnMessageComposerTextChanged$zendesk_messaging_messaging_android(Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.onMessageComposerTextChanged = function1;
        }

        public final Function0<Unit> getOnDeniedPermissionActionClicked$zendesk_messaging_messaging_android() {
            return this.onDeniedPermissionActionClicked;
        }

        public final void setOnDeniedPermissionActionClicked$zendesk_messaging_messaging_android(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "<set-?>");
            this.onDeniedPermissionActionClicked = function0;
        }

        public final Function0<Unit> getOnDeniedPermissionDismissed$zendesk_messaging_messaging_android() {
            return this.onDeniedPermissionDismissed;
        }

        public final void setOnDeniedPermissionDismissed$zendesk_messaging_messaging_android(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "<set-?>");
            this.onDeniedPermissionDismissed = function0;
        }

        public final ConversationScreenState getState$zendesk_messaging_messaging_android() {
            return this.state;
        }

        public final void setState$zendesk_messaging_messaging_android(ConversationScreenState conversationScreenState) {
            Intrinsics.checkNotNullParameter(conversationScreenState, "<set-?>");
            this.state = conversationScreenState;
        }

        public final Function1<DisplayedField, Unit> getOnFormDisplayedFieldsChanged$zendesk_messaging_messaging_android() {
            return this.onFormDisplayedFieldsChanged;
        }

        public final void setOnFormDisplayedFieldsChanged$zendesk_messaging_messaging_android(Function1<? super DisplayedField, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.onFormDisplayedFieldsChanged = function1;
        }

        public final Function1<Double, Unit> getOnLoadMoreMessages$zendesk_messaging_messaging_android() {
            return this.onLoadMoreMessages;
        }

        public final void setOnLoadMoreMessages$zendesk_messaging_messaging_android(Function1<? super Double, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.onLoadMoreMessages = function1;
        }

        public final Function1<Double, Unit> getOnRetryLoadMoreClickedListener$zendesk_messaging_messaging_android() {
            return this.onRetryLoadMoreClickedListener;
        }

        public final void setOnRetryLoadMoreClickedListener$zendesk_messaging_messaging_android(Function1<? super Double, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.onRetryLoadMoreClickedListener = function1;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(ConversationScreenRendering conversationScreenRendering) {
            this();
            Intrinsics.checkNotNullParameter(conversationScreenRendering, "rendering");
            this.onBackButtonClicked = conversationScreenRendering.getOnBackButtonClicked$zendesk_messaging_messaging_android();
            this.onSendButtonClicked = conversationScreenRendering.getOnSendButtonClicked$zendesk_messaging_messaging_android();
            this.onAttachButtonClicked = conversationScreenRendering.getOnAttachButtonClicked$zendesk_messaging_messaging_android();
            this.onReplyActionSelected = conversationScreenRendering.getOnReplyActionSelected$zendesk_messaging_messaging_android();
            this.onFailedMessageClicked = conversationScreenRendering.getOnFailedMessageClicked$zendesk_messaging_messaging_android();
            this.onRetryConnectionClickedListener = conversationScreenRendering.getOnRetryConnectionClicked$zendesk_messaging_messaging_android();
            this.onUriClicked = conversationScreenRendering.getOnUriClicked$zendesk_messaging_messaging_android();
            this.onFormCompleted = conversationScreenRendering.getOnFormCompleted$zendesk_messaging_messaging_android();
            this.onFormFocusChanged = conversationScreenRendering.getOnFormFocusChanged$zendesk_messaging_messaging_android();
            this.onFormDisplayedFieldsChanged = conversationScreenRendering.getOnFormDisplayedFieldsChanged$zendesk_messaging_messaging_android();
            this.onTyping = conversationScreenRendering.getOnTyping$zendesk_messaging_messaging_android();
            this.onMessageComposerTextChanged = conversationScreenRendering.getOnMessageComposerTextChanged$zendesk_messaging_messaging_android();
            this.onDeniedPermissionActionClicked = conversationScreenRendering.getOnDeniedPermissionActionClicked$zendesk_messaging_messaging_android();
            this.onDeniedPermissionDismissed = conversationScreenRendering.getOnDeniedPermissionDismissed$zendesk_messaging_messaging_android();
            this.onLoadMoreMessages = conversationScreenRendering.getOnLoadMoreMessages$zendesk_messaging_messaging_android();
            this.onRetryLoadMoreClickedListener = conversationScreenRendering.getOnRetryLoadMoreClickedListener$zendesk_messaging_messaging_android();
            this.state = conversationScreenRendering.getState$zendesk_messaging_messaging_android();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(ConversationScreenRendering conversationScreenRendering, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ConversationScreenRendering() : conversationScreenRendering);
        }

        public final Builder onBackButtonClicked(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "onBackButtonClicked");
            Builder builder = this;
            this.onBackButtonClicked = function0;
            return this;
        }

        public final Builder onSendButtonClicked(Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "onSendButtonClicked");
            Builder builder = this;
            this.onSendButtonClicked = function1;
            return this;
        }

        public final Builder onAttachMenuItemClicked(Function1<? super Integer, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "onAttachButtonClicked");
            Builder builder = this;
            this.onAttachButtonClicked = function1;
            return this;
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

        public final Builder onRetryConnectionButtonClicked(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "onRetryConnectionClickedListener");
            Builder builder = this;
            this.onRetryConnectionClickedListener = function0;
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
            Intrinsics.checkNotNullParameter(function1, "onFormFocusChanged");
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

        public final Builder onTyping(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "onTyping");
            Builder builder = this;
            this.onTyping = function0;
            return this;
        }

        public final Builder onMessageComposerTextChanged(Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "onMessageComposerTextChanged");
            Builder builder = this;
            this.onMessageComposerTextChanged = function1;
            return this;
        }

        public final Builder onDeniedPermissionActionClicked(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "onDeniedPermissionActionClicked");
            Builder builder = this;
            this.onDeniedPermissionActionClicked = function0;
            return this;
        }

        public final Builder onDeniedPermissionDismissed(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "onDeniedPermissionDismissed");
            Builder builder = this;
            this.onDeniedPermissionDismissed = function0;
            return this;
        }

        public final Builder onLoadMoreMessages(Function1<? super Double, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "onLoadMoreMessages");
            Builder builder = this;
            this.onLoadMoreMessages = function1;
            return this;
        }

        public final Builder onRetryLoadMoreClickedListener(Function1<? super Double, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "onRetryLoadMoreClickedListener");
            Builder builder = this;
            this.onRetryLoadMoreClickedListener = function1;
            return this;
        }

        public final Builder state(Function1<? super ConversationScreenState, ConversationScreenState> function1) {
            Intrinsics.checkNotNullParameter(function1, "stateUpdate");
            Builder builder = this;
            this.state = function1.invoke(this.state);
            return this;
        }

        public final ConversationScreenRendering build() {
            return new ConversationScreenRendering(this);
        }
    }
}
