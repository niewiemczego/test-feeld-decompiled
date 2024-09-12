package zendesk.messaging.android.internal.conversationscreen;

import androidx.recyclerview.widget.DiffUtil;
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
import zendesk.messaging.android.internal.UriHandler;
import zendesk.messaging.android.internal.adapterdelegate.AdapterDelegatesManager;
import zendesk.messaging.android.internal.adapterdelegate.AsyncListDifferDelegationAdapter;
import zendesk.messaging.android.internal.conversationscreen.delegates.MessageContainerAdapterDelegate;
import zendesk.messaging.android.internal.conversationscreen.delegates.MessageLoadMoreAdapterDelegate;
import zendesk.messaging.android.internal.conversationscreen.delegates.MessagesDividerAdapterDelegate;
import zendesk.messaging.android.internal.conversationscreen.delegates.QuickReplyAdapterDelegate;
import zendesk.messaging.android.internal.conversationscreen.delegates.TypingIndicatorAdapterDelegate;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.ui.android.conversation.form.DisplayedField;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 M2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001MB-\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR,\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r8F@FX\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R<\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00150\u00142\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00150\u00148F@FX\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R,\u0010\u001b\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r8F@FX\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012RD\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001ej\u0002`!2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001ej\u0002`!8F@FX\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\\\u0010+\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0'j\u0002`*2\"\u0010\f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0'j\u0002`*8F@FX\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/RD\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020 0\u001ej\u0002`02\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020 0\u001ej\u0002`08F@FX\u000e¢\u0006\f\u001a\u0004\b2\u0010$\"\u0004\b3\u0010&RD\u00106\u001a\u0012\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020 0\u001ej\u0002`52\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020 0\u001ej\u0002`58F@FX\u000e¢\u0006\f\u001a\u0004\b7\u0010$\"\u0004\b8\u0010&R4\u0010:\u001a\n\u0012\u0004\u0012\u00020 \u0018\u0001092\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u0001098F@FX\u000e¢\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>RD\u0010A\u001a\u0012\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020 0\u001ej\u0002`@2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020 0\u001ej\u0002`@8F@FX\u000e¢\u0006\f\u001a\u0004\bB\u0010$\"\u0004\bC\u0010&R$\u0010E\u001a\u00020D2\u0006\u0010\f\u001a\u00020D8F@FX\u000e¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR,\u0010J\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r8F@FX\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\bK\u0010\u0010\"\u0004\bL\u0010\u0012R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/MessageListAdapter;", "Lzendesk/messaging/android/internal/adapterdelegate/AsyncListDifferDelegationAdapter;", "Lzendesk/messaging/android/internal/model/MessageLogEntry;", "messageContainerAdapterDelegate", "Lzendesk/messaging/android/internal/conversationscreen/delegates/MessageContainerAdapterDelegate;", "messagesDividerAdapterDelegate", "Lzendesk/messaging/android/internal/conversationscreen/delegates/MessagesDividerAdapterDelegate;", "messageLoadMoreAdapterDelegate", "Lzendesk/messaging/android/internal/conversationscreen/delegates/MessageLoadMoreAdapterDelegate;", "quickReplyAdapterDelegate", "Lzendesk/messaging/android/internal/conversationscreen/delegates/QuickReplyAdapterDelegate;", "(Lzendesk/messaging/android/internal/conversationscreen/delegates/MessageContainerAdapterDelegate;Lzendesk/messaging/android/internal/conversationscreen/delegates/MessagesDividerAdapterDelegate;Lzendesk/messaging/android/internal/conversationscreen/delegates/MessageLoadMoreAdapterDelegate;Lzendesk/messaging/android/internal/conversationscreen/delegates/QuickReplyAdapterDelegate;)V", "value", "", "actionColor", "getActionColor", "()Ljava/lang/Integer;", "setActionColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "", "Lzendesk/ui/android/conversation/form/DisplayedField;", "mapOfDisplayedFields", "getMapOfDisplayedFields", "()Ljava/util/Map;", "setMapOfDisplayedFields", "(Ljava/util/Map;)V", "notifyColor", "getNotifyColor", "setNotifyColor", "Lkotlin/Function1;", "Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;", "", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFailedMessageClickedListener;", "onFailedMessageClicked", "getOnFailedMessageClicked", "()Lkotlin/jvm/functions/Function1;", "setOnFailedMessageClicked", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "", "Lzendesk/conversationkit/android/model/Field;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormCompleted;", "onFormCompleted", "getOnFormCompleted", "()Lkotlin/jvm/functions/Function2;", "setOnFormCompleted", "(Lkotlin/jvm/functions/Function2;)V", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormDisplayedFieldsChanged;", "onFormDisplayedFieldsChanged", "getOnFormDisplayedFieldsChanged", "setOnFormDisplayedFieldsChanged", "", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormFocusChangedListener;", "onFormFocusChanged", "getOnFormFocusChanged", "setOnFormFocusChanged", "Lkotlin/Function0;", "onLoadMoreRetryClicked", "getOnLoadMoreRetryClicked", "()Lkotlin/jvm/functions/Function0;", "setOnLoadMoreRetryClicked", "(Lkotlin/jvm/functions/Function0;)V", "Lzendesk/conversationkit/android/model/MessageAction$Reply;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnReplyActionSelected;", "onReplyActionSelected", "getOnReplyActionSelected", "setOnReplyActionSelected", "Lzendesk/messaging/android/internal/UriHandler;", "onUriClicked", "getOnUriClicked", "()Lzendesk/messaging/android/internal/UriHandler;", "setOnUriClicked", "(Lzendesk/messaging/android/internal/UriHandler;)V", "outboundMessageColor", "getOutboundMessageColor", "setOutboundMessageColor", "Companion", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageListAdapter.kt */
public final class MessageListAdapter extends AsyncListDifferDelegationAdapter<MessageLogEntry> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Integer actionColor;
    private final MessageContainerAdapterDelegate messageContainerAdapterDelegate;
    private final MessageLoadMoreAdapterDelegate messageLoadMoreAdapterDelegate;
    private final MessagesDividerAdapterDelegate messagesDividerAdapterDelegate;
    private Integer notifyColor;
    private Integer outboundMessageColor;
    private final QuickReplyAdapterDelegate quickReplyAdapterDelegate;

    public MessageListAdapter() {
        this((MessageContainerAdapterDelegate) null, (MessagesDividerAdapterDelegate) null, (MessageLoadMoreAdapterDelegate) null, (QuickReplyAdapterDelegate) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageListAdapter(MessageContainerAdapterDelegate messageContainerAdapterDelegate2, MessagesDividerAdapterDelegate messagesDividerAdapterDelegate2, MessageLoadMoreAdapterDelegate messageLoadMoreAdapterDelegate2, QuickReplyAdapterDelegate quickReplyAdapterDelegate2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new MessageContainerAdapterDelegate((Function1) null, (UriHandler) null, (Function2) null, (Function1) null, (Function1) null, (Map) null, 63, (DefaultConstructorMarker) null) : messageContainerAdapterDelegate2, (i & 2) != 0 ? new MessagesDividerAdapterDelegate() : messagesDividerAdapterDelegate2, (i & 4) != 0 ? new MessageLoadMoreAdapterDelegate() : messageLoadMoreAdapterDelegate2, (i & 8) != 0 ? new QuickReplyAdapterDelegate((Function1) null, 1, (DefaultConstructorMarker) null) : quickReplyAdapterDelegate2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageListAdapter(MessageContainerAdapterDelegate messageContainerAdapterDelegate2, MessagesDividerAdapterDelegate messagesDividerAdapterDelegate2, MessageLoadMoreAdapterDelegate messageLoadMoreAdapterDelegate2, QuickReplyAdapterDelegate quickReplyAdapterDelegate2) {
        super(Companion, new AdapterDelegatesManager(messageContainerAdapterDelegate2, messagesDividerAdapterDelegate2, new TypingIndicatorAdapterDelegate(), messageLoadMoreAdapterDelegate2, quickReplyAdapterDelegate2));
        Intrinsics.checkNotNullParameter(messageContainerAdapterDelegate2, "messageContainerAdapterDelegate");
        Intrinsics.checkNotNullParameter(messagesDividerAdapterDelegate2, "messagesDividerAdapterDelegate");
        Intrinsics.checkNotNullParameter(messageLoadMoreAdapterDelegate2, "messageLoadMoreAdapterDelegate");
        Intrinsics.checkNotNullParameter(quickReplyAdapterDelegate2, "quickReplyAdapterDelegate");
        this.messageContainerAdapterDelegate = messageContainerAdapterDelegate2;
        this.messagesDividerAdapterDelegate = messagesDividerAdapterDelegate2;
        this.messageLoadMoreAdapterDelegate = messageLoadMoreAdapterDelegate2;
        this.quickReplyAdapterDelegate = quickReplyAdapterDelegate2;
        this.outboundMessageColor = messageContainerAdapterDelegate2.getOutboundMessageColor();
        this.actionColor = messageContainerAdapterDelegate2.getActionColor();
        this.notifyColor = messagesDividerAdapterDelegate2.getDividerColor();
    }

    public final Integer getOutboundMessageColor() {
        return this.messageContainerAdapterDelegate.getOutboundMessageColor();
    }

    public final void setOutboundMessageColor(Integer num) {
        this.outboundMessageColor = num;
        this.messageContainerAdapterDelegate.setOutboundMessageColor(num);
    }

    public final Integer getActionColor() {
        return this.messageContainerAdapterDelegate.getActionColor();
    }

    public final void setActionColor(Integer num) {
        this.actionColor = num;
        this.messageContainerAdapterDelegate.setActionColor(num);
        this.quickReplyAdapterDelegate.setQuickReplyColor(num);
    }

    public final Integer getNotifyColor() {
        return this.messagesDividerAdapterDelegate.getDividerColor();
    }

    public final void setNotifyColor(Integer num) {
        this.notifyColor = num;
        this.messagesDividerAdapterDelegate.setDividerColor(num);
    }

    public final Function1<MessageAction.Reply, Unit> getOnReplyActionSelected() {
        return this.quickReplyAdapterDelegate.getOnOptionSelected();
    }

    public final void setOnReplyActionSelected(Function1<? super MessageAction.Reply, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "value");
        this.quickReplyAdapterDelegate.setOnOptionSelected(function1);
    }

    public final Function1<MessageLogEntry.MessageContainer, Unit> getOnFailedMessageClicked() {
        return this.messageContainerAdapterDelegate.getOnFailedMessageClicked();
    }

    public final void setOnFailedMessageClicked(Function1<? super MessageLogEntry.MessageContainer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "value");
        this.messageContainerAdapterDelegate.setOnFailedMessageClicked(function1);
    }

    public final UriHandler getOnUriClicked() {
        return this.messageContainerAdapterDelegate.getOnUriClicked();
    }

    public final void setOnUriClicked(UriHandler uriHandler) {
        Intrinsics.checkNotNullParameter(uriHandler, "value");
        this.messageContainerAdapterDelegate.setOnUriClicked(uriHandler);
    }

    public final Function2<List<? extends Field>, MessageLogEntry.MessageContainer, Unit> getOnFormCompleted() {
        return this.messageContainerAdapterDelegate.getOnFormCompleted();
    }

    public final void setOnFormCompleted(Function2<? super List<? extends Field>, ? super MessageLogEntry.MessageContainer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "value");
        this.messageContainerAdapterDelegate.setOnFormCompleted(function2);
    }

    public final Function1<Boolean, Unit> getOnFormFocusChanged() {
        return this.messageContainerAdapterDelegate.getOnFormFocusChangedListener();
    }

    public final void setOnFormFocusChanged(Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "value");
        this.messageContainerAdapterDelegate.setOnFormFocusChangedListener(function1);
    }

    public final Function1<DisplayedField, Unit> getOnFormDisplayedFieldsChanged() {
        return this.messageContainerAdapterDelegate.getOnFormDisplayedFieldsChanged();
    }

    public final void setOnFormDisplayedFieldsChanged(Function1<? super DisplayedField, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "value");
        this.messageContainerAdapterDelegate.setOnFormDisplayedFieldsChanged(function1);
    }

    public final Map<Integer, DisplayedField> getMapOfDisplayedFields() {
        return this.messageContainerAdapterDelegate.getMapOfDisplayedFields();
    }

    public final void setMapOfDisplayedFields(Map<Integer, DisplayedField> map) {
        Intrinsics.checkNotNullParameter(map, "value");
        this.messageContainerAdapterDelegate.setMapOfDisplayedFields(map);
    }

    public final Function0<Unit> getOnLoadMoreRetryClicked() {
        return this.messageLoadMoreAdapterDelegate.getOnRetryClicked$zendesk_messaging_messaging_android();
    }

    public final void setOnLoadMoreRetryClicked(Function0<Unit> function0) {
        this.messageLoadMoreAdapterDelegate.setOnRetryClicked$zendesk_messaging_messaging_android(function0);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/MessageListAdapter$Companion;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lzendesk/messaging/android/internal/model/MessageLogEntry;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageListAdapter.kt */
    public static final class Companion extends DiffUtil.ItemCallback<MessageLogEntry> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public boolean areItemsTheSame(MessageLogEntry messageLogEntry, MessageLogEntry messageLogEntry2) {
            Intrinsics.checkNotNullParameter(messageLogEntry, "oldItem");
            Intrinsics.checkNotNullParameter(messageLogEntry2, "newItem");
            if ((messageLogEntry instanceof MessageLogEntry.LoadMore) && (messageLogEntry2 instanceof MessageLogEntry.LoadMore)) {
                return Intrinsics.areEqual((Object) messageLogEntry.getId(), (Object) messageLogEntry2.getId());
            }
            if ((messageLogEntry instanceof MessageLogEntry.MessagesDivider) && (messageLogEntry2 instanceof MessageLogEntry.MessagesDivider)) {
                return Intrinsics.areEqual((Object) ((MessageLogEntry.MessagesDivider) messageLogEntry).getText(), (Object) ((MessageLogEntry.MessagesDivider) messageLogEntry2).getText());
            }
            if ((messageLogEntry instanceof MessageLogEntry.MessageContainer) && (messageLogEntry2 instanceof MessageLogEntry.MessageContainer)) {
                return Intrinsics.areEqual((Object) ((MessageLogEntry.MessageContainer) messageLogEntry).getMessage().getLocalId(), (Object) ((MessageLogEntry.MessageContainer) messageLogEntry2).getMessage().getLocalId());
            }
            if ((messageLogEntry instanceof MessageLogEntry.QuickReply) && (messageLogEntry2 instanceof MessageLogEntry.QuickReply)) {
                return Intrinsics.areEqual((Object) ((MessageLogEntry.QuickReply) messageLogEntry).getReplies(), (Object) ((MessageLogEntry.QuickReply) messageLogEntry2).getReplies());
            }
            if (!(messageLogEntry instanceof MessageLogEntry.TypingIndicator) || !(messageLogEntry2 instanceof MessageLogEntry.TypingIndicator)) {
                return false;
            }
            return Intrinsics.areEqual((Object) ((MessageLogEntry.TypingIndicator) messageLogEntry).getAvatarUrl(), (Object) ((MessageLogEntry.TypingIndicator) messageLogEntry2).getAvatarUrl());
        }

        public boolean areContentsTheSame(MessageLogEntry messageLogEntry, MessageLogEntry messageLogEntry2) {
            Intrinsics.checkNotNullParameter(messageLogEntry, "oldItem");
            Intrinsics.checkNotNullParameter(messageLogEntry2, "newItem");
            return Intrinsics.areEqual((Object) messageLogEntry, (Object) messageLogEntry2);
        }
    }
}
