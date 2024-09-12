package zendesk.messaging.android.internal.conversationscreen.delegates;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.model.Field;
import zendesk.conversationkit.android.model.MessageContent;
import zendesk.conversationkit.android.model.MessageStatus;
import zendesk.messaging.R;
import zendesk.messaging.android.internal.UriHandler;
import zendesk.messaging.android.internal.adapterdelegate.ListItemAdapterDelegate;
import zendesk.messaging.android.internal.conversationscreen.RenderingUpdates;
import zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogCellFactory;
import zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogListenersKt;
import zendesk.messaging.android.internal.model.MessageDirection;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.messaging.android.internal.model.MessagePosition;
import zendesk.messaging.android.internal.model.MessageReceipt;
import zendesk.messaging.android.internal.model.MessageSize;
import zendesk.ui.android.conversation.avatar.AvatarImageView;
import zendesk.ui.android.conversation.form.DisplayedField;
import zendesk.ui.android.conversation.receipt.MessageReceiptView;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 B2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002BCB\u0001\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012$\b\u0002\u0010\u000b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\fj\u0002`\u000f\u0012\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\u0012\u0012\u0018\b\u0002\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\u0015\u0012\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00140\u0017¢\u0006\u0002\u0010\u0019J&\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u00032\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010:\u001a\u00020\u0018H\u0014J(\u0010;\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u00042\u000e\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010>0\rH\u0014J\u0010\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020AH\u0016R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR&\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00140\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R6\u0010\u000b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\fj\u0002`\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R*\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R*\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010%\"\u0004\b/\u0010'R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00104\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b5\u0010\u001c\"\u0004\b6\u0010\u001e¨\u0006D"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/delegates/MessageContainerAdapterDelegate;", "Lzendesk/messaging/android/internal/adapterdelegate/ListItemAdapterDelegate;", "Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;", "Lzendesk/messaging/android/internal/model/MessageLogEntry;", "Lzendesk/messaging/android/internal/conversationscreen/delegates/MessageContainerAdapterDelegate$ViewHolder;", "onFailedMessageClicked", "Lkotlin/Function1;", "", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFailedMessageClickedListener;", "onUriClicked", "Lzendesk/messaging/android/internal/UriHandler;", "onFormCompleted", "Lkotlin/Function2;", "", "Lzendesk/conversationkit/android/model/Field;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormCompleted;", "onFormFocusChangedListener", "", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormFocusChangedListener;", "onFormDisplayedFieldsChanged", "Lzendesk/ui/android/conversation/form/DisplayedField;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormDisplayedFieldsChanged;", "mapOfDisplayedFields", "", "", "(Lkotlin/jvm/functions/Function1;Lzendesk/messaging/android/internal/UriHandler;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/util/Map;)V", "actionColor", "getActionColor", "()Ljava/lang/Integer;", "setActionColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMapOfDisplayedFields", "()Ljava/util/Map;", "setMapOfDisplayedFields", "(Ljava/util/Map;)V", "getOnFailedMessageClicked", "()Lkotlin/jvm/functions/Function1;", "setOnFailedMessageClicked", "(Lkotlin/jvm/functions/Function1;)V", "getOnFormCompleted", "()Lkotlin/jvm/functions/Function2;", "setOnFormCompleted", "(Lkotlin/jvm/functions/Function2;)V", "getOnFormDisplayedFieldsChanged", "setOnFormDisplayedFieldsChanged", "getOnFormFocusChangedListener", "setOnFormFocusChangedListener", "getOnUriClicked", "()Lzendesk/messaging/android/internal/UriHandler;", "setOnUriClicked", "(Lzendesk/messaging/android/internal/UriHandler;)V", "outboundMessageColor", "getOutboundMessageColor", "setOutboundMessageColor", "isForViewType", "item", "items", "position", "onBindViewHolder", "holder", "payloads", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "Companion", "ViewHolder", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageContainerAdapterDelegate.kt */
public final class MessageContainerAdapterDelegate extends ListItemAdapterDelegate<MessageLogEntry.MessageContainer, MessageLogEntry, ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final float LABEL_ALPHA = 0.65f;
    private Integer actionColor;
    private Map<Integer, DisplayedField> mapOfDisplayedFields;
    private Function1<? super MessageLogEntry.MessageContainer, Unit> onFailedMessageClicked;
    private Function2<? super List<? extends Field>, ? super MessageLogEntry.MessageContainer, Unit> onFormCompleted;
    private Function1<? super DisplayedField, Unit> onFormDisplayedFieldsChanged;
    private Function1<? super Boolean, Unit> onFormFocusChangedListener;
    private UriHandler onUriClicked;
    private Integer outboundMessageColor;

    public MessageContainerAdapterDelegate() {
        this((Function1) null, (UriHandler) null, (Function2) null, (Function1) null, (Function1) null, (Map) null, 63, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MessageContainerAdapterDelegate(kotlin.jvm.functions.Function1<zendesk.messaging.android.internal.model.MessageLogEntry.MessageContainer, kotlin.Unit> r5, zendesk.messaging.android.internal.UriHandler r6, kotlin.jvm.functions.Function2<java.util.List<? extends zendesk.conversationkit.android.model.Field>, zendesk.messaging.android.internal.model.MessageLogEntry.MessageContainer, kotlin.Unit> r7, kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r8, kotlin.jvm.functions.Function1<zendesk.ui.android.conversation.form.DisplayedField, kotlin.Unit> r9, java.util.Map r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0008
            kotlin.jvm.functions.Function1 r5 = zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogListenersKt.getNOOP_ON_MESSAGE_CONTAINER_CLICKED_LISTENER()
        L_0x0008:
            r12 = r11 & 2
            if (r12 == 0) goto L_0x0010
            zendesk.messaging.android.internal.StubUriHandler r6 = zendesk.messaging.android.internal.StubUriHandler.INSTANCE
            zendesk.messaging.android.internal.UriHandler r6 = (zendesk.messaging.android.internal.UriHandler) r6
        L_0x0010:
            r12 = r6
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0019
            kotlin.jvm.functions.Function2 r7 = zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogListenersKt.getNOOP_ON_FORM_COMPLETED()
        L_0x0019:
            r0 = r7
            r6 = r11 & 8
            if (r6 == 0) goto L_0x0022
            kotlin.jvm.functions.Function1 r8 = zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogListenersKt.getNOOP_ON_FORM_FOCUS_CHANGED_LISTENER()
        L_0x0022:
            r1 = r8
            r6 = r11 & 16
            if (r6 == 0) goto L_0x002b
            kotlin.jvm.functions.Function1 r9 = zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogListenersKt.getNOOP_ON_FORM_DISPLAYED_FIELDS_CHANGED()
        L_0x002b:
            r2 = r9
            r6 = r11 & 32
            if (r6 == 0) goto L_0x0038
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            r10 = r6
            java.util.Map r10 = (java.util.Map) r10
        L_0x0038:
            r3 = r10
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r0
            r10 = r1
            r11 = r2
            r12 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.delegates.MessageContainerAdapterDelegate.<init>(kotlin.jvm.functions.Function1, zendesk.messaging.android.internal.UriHandler, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Function1<MessageLogEntry.MessageContainer, Unit> getOnFailedMessageClicked() {
        return this.onFailedMessageClicked;
    }

    public final void setOnFailedMessageClicked(Function1<? super MessageLogEntry.MessageContainer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onFailedMessageClicked = function1;
    }

    public final UriHandler getOnUriClicked() {
        return this.onUriClicked;
    }

    public final void setOnUriClicked(UriHandler uriHandler) {
        Intrinsics.checkNotNullParameter(uriHandler, "<set-?>");
        this.onUriClicked = uriHandler;
    }

    public final Function2<List<? extends Field>, MessageLogEntry.MessageContainer, Unit> getOnFormCompleted() {
        return this.onFormCompleted;
    }

    public final void setOnFormCompleted(Function2<? super List<? extends Field>, ? super MessageLogEntry.MessageContainer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.onFormCompleted = function2;
    }

    public final Function1<Boolean, Unit> getOnFormFocusChangedListener() {
        return this.onFormFocusChangedListener;
    }

    public final void setOnFormFocusChangedListener(Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onFormFocusChangedListener = function1;
    }

    public final Function1<DisplayedField, Unit> getOnFormDisplayedFieldsChanged() {
        return this.onFormDisplayedFieldsChanged;
    }

    public final void setOnFormDisplayedFieldsChanged(Function1<? super DisplayedField, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onFormDisplayedFieldsChanged = function1;
    }

    public final Map<Integer, DisplayedField> getMapOfDisplayedFields() {
        return this.mapOfDisplayedFields;
    }

    public final void setMapOfDisplayedFields(Map<Integer, DisplayedField> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.mapOfDisplayedFields = map;
    }

    public MessageContainerAdapterDelegate(Function1<? super MessageLogEntry.MessageContainer, Unit> function1, UriHandler uriHandler, Function2<? super List<? extends Field>, ? super MessageLogEntry.MessageContainer, Unit> function2, Function1<? super Boolean, Unit> function12, Function1<? super DisplayedField, Unit> function13, Map<Integer, DisplayedField> map) {
        Intrinsics.checkNotNullParameter(function1, "onFailedMessageClicked");
        Intrinsics.checkNotNullParameter(uriHandler, "onUriClicked");
        Intrinsics.checkNotNullParameter(function2, "onFormCompleted");
        Intrinsics.checkNotNullParameter(function12, "onFormFocusChangedListener");
        Intrinsics.checkNotNullParameter(function13, "onFormDisplayedFieldsChanged");
        Intrinsics.checkNotNullParameter(map, "mapOfDisplayedFields");
        this.onFailedMessageClicked = function1;
        this.onUriClicked = uriHandler;
        this.onFormCompleted = function2;
        this.onFormFocusChangedListener = function12;
        this.onFormDisplayedFieldsChanged = function13;
        this.mapOfDisplayedFields = map;
    }

    public final Integer getOutboundMessageColor() {
        return this.outboundMessageColor;
    }

    public final void setOutboundMessageColor(Integer num) {
        this.outboundMessageColor = num;
    }

    public final Integer getActionColor() {
        return this.actionColor;
    }

    public final void setActionColor(Integer num) {
        this.actionColor = num;
    }

    /* access modifiers changed from: protected */
    public boolean isForViewType(MessageLogEntry messageLogEntry, List<? extends MessageLogEntry> list, int i) {
        Intrinsics.checkNotNullParameter(messageLogEntry, "item");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        return messageLogEntry instanceof MessageLogEntry.MessageContainer;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.zma_view_message_log_entry_message_container, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   …container, parent, false)");
        return new ViewHolder(inflate, this.outboundMessageColor, this.actionColor);
    }

    /* access modifiers changed from: protected */
    public void onBindViewHolder(MessageLogEntry.MessageContainer messageContainer, ViewHolder viewHolder, List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(messageContainer, "item");
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        viewHolder.bind(messageContainer, this.onFailedMessageClicked, this.onUriClicked, this.onFormCompleted, this.onFormFocusChangedListener, this.onFormDisplayedFieldsChanged, this.mapOfDisplayedFields);
    }

    @Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0001\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00120\u001fj\u0002` 2\u0006\u0010!\u001a\u00020\"2\"\u0010#\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00120$j\u0002`'2\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00120\u001fj\u0002`*2\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00120\u001fj\u0002`-2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020,0/J\u001a\u00100\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\u0017H\u0002J\u0001\u00104\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00120\u001fj\u0002` 2\u0006\u0010!\u001a\u00020\"2\"\u0010#\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00120$j\u0002`'2\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00120\u001fj\u0002`*2\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00120\u001fj\u0002`-2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020,0/H\u0002J\u0012\u00106\u001a\u00020\u00122\b\u00107\u001a\u0004\u0018\u000102H\u0002J2\u00108\u001a\u00020\u00122\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u00020)H\u0002J4\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00120\u001fj\u0002` *\u00020\u001d2\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00120\u001fj\u0002` H\u0002J\f\u0010@\u001a\u00020\u0012*\u00020\u0003H\u0002J%\u0010@\u001a\u00020\u0012*\u00020\u00032\u0017\u0010A\u001a\u0013\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u00120\u001f¢\u0006\u0002\bCH\u0002J%\u0010D\u001a\u00020\u0012*\u00020\u00032\u0017\u0010A\u001a\u0013\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u00120\u001f¢\u0006\u0002\bCH\u0002R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/delegates/MessageContainerAdapterDelegate$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "outboundMessageColor", "", "actionColor", "(Landroid/view/View;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "avatarView", "Lzendesk/ui/android/conversation/avatar/AvatarImageView;", "contentView", "Landroid/widget/LinearLayout;", "labelView", "Landroid/widget/TextView;", "receiptView", "Lzendesk/ui/android/conversation/receipt/MessageReceiptView;", "adjustDirectionAndWidth", "", "view", "content", "Lzendesk/conversationkit/android/model/MessageContent;", "direction", "Lzendesk/messaging/android/internal/model/MessageDirection;", "adjustSpacing", "position", "Lzendesk/messaging/android/internal/model/MessagePosition;", "bind", "item", "Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;", "onFailedMessageClicked", "Lkotlin/Function1;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFailedMessageClickedListener;", "onUriClicked", "Lzendesk/messaging/android/internal/UriHandler;", "onFormCompleted", "Lkotlin/Function2;", "", "Lzendesk/conversationkit/android/model/Field;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormCompleted;", "onFormFocusChangedListener", "", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormFocusChangedListener;", "onFormDisplayedFieldsChanged", "Lzendesk/ui/android/conversation/form/DisplayedField;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnFormDisplayedFieldsChanged;", "mapOfDisplayedFields", "", "renderAvatar", "avatarUrl", "", "messageDirection", "renderContent", "onFormFocusChanged", "renderLabel", "labelText", "renderReceipt", "receipt", "Lzendesk/messaging/android/internal/model/MessageReceipt;", "status", "Lzendesk/conversationkit/android/model/MessageStatus;", "showIcon", "isUnsupported", "clickListener", "edgeToEdge", "block", "Landroid/widget/LinearLayout$LayoutParams;", "Lkotlin/ExtensionFunctionType;", "wrap", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageContainerAdapterDelegate.kt */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final Integer actionColor;
        /* access modifiers changed from: private */
        public final AvatarImageView avatarView;
        private final LinearLayout contentView;
        private final TextView labelView;
        /* access modifiers changed from: private */
        public final Integer outboundMessageColor;
        /* access modifiers changed from: private */
        public final MessageReceiptView receiptView;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: MessageContainerAdapterDelegate.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;
            public static final /* synthetic */ int[] $EnumSwitchMapping$2;

            static {
                int[] iArr = new int[MessageStatus.values().length];
                iArr[MessageStatus.PENDING.ordinal()] = 1;
                iArr[MessageStatus.FAILED.ordinal()] = 2;
                iArr[MessageStatus.SENT.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[MessageDirection.values().length];
                iArr2[MessageDirection.INBOUND.ordinal()] = 1;
                iArr2[MessageDirection.OUTBOUND.ordinal()] = 2;
                $EnumSwitchMapping$1 = iArr2;
                int[] iArr3 = new int[MessagePosition.values().length];
                iArr3[MessagePosition.STANDALONE.ordinal()] = 1;
                iArr3[MessagePosition.GROUP_TOP.ordinal()] = 2;
                iArr3[MessagePosition.GROUP_MIDDLE.ordinal()] = 3;
                iArr3[MessagePosition.GROUP_BOTTOM.ordinal()] = 4;
                $EnumSwitchMapping$2 = iArr3;
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ViewHolder(View view, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(view, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view, Integer num, Integer num2) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.outboundMessageColor = num;
            this.actionColor = num2;
            View findViewById = view.findViewById(R.id.zma_message_label);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.zma_message_label)");
            this.labelView = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.zma_avatar_view);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.zma_avatar_view)");
            this.avatarView = (AvatarImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.zma_message_content);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.zma_message_content)");
            this.contentView = (LinearLayout) findViewById3;
            View findViewById4 = view.findViewById(R.id.zma_message_receipt);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.zma_message_receipt)");
            this.receiptView = (MessageReceiptView) findViewById4;
        }

        public final void bind(MessageLogEntry.MessageContainer messageContainer, Function1<? super MessageLogEntry.MessageContainer, Unit> function1, UriHandler uriHandler, Function2<? super List<? extends Field>, ? super MessageLogEntry.MessageContainer, Unit> function2, Function1<? super Boolean, Unit> function12, Function1<? super DisplayedField, Unit> function13, Map<Integer, DisplayedField> map) {
            Intrinsics.checkNotNullParameter(messageContainer, "item");
            Intrinsics.checkNotNullParameter(function1, "onFailedMessageClicked");
            Intrinsics.checkNotNullParameter(uriHandler, "onUriClicked");
            Intrinsics.checkNotNullParameter(function2, "onFormCompleted");
            Intrinsics.checkNotNullParameter(function12, "onFormFocusChangedListener");
            Intrinsics.checkNotNullParameter(function13, "onFormDisplayedFieldsChanged");
            Intrinsics.checkNotNullParameter(map, "mapOfDisplayedFields");
            if (MessageSize.FULL_WIDTH == messageContainer.getSize()) {
                this.avatarView.setVisibility(8);
            } else {
                renderAvatar(messageContainer.getAvatarUrl(), messageContainer.getDirection());
            }
            renderLabel(messageContainer.getLabel());
            renderContent(messageContainer, function1, uriHandler, function2, function12, function13, map);
            renderReceipt(messageContainer.getReceipt(), messageContainer.getDirection(), messageContainer.getStatus(), (messageContainer.getMessage().getContent() instanceof MessageContent.Text) || (messageContainer.getMessage().getContent() instanceof MessageContent.File) || (messageContainer.getMessage().getContent() instanceof MessageContent.Image) || (messageContainer.getMessage().getContent() instanceof MessageContent.FileUpload) || (messageContainer.getMessage().getContent() instanceof MessageContent.Unsupported) || messageContainer.getMessage().getStatus() == MessageStatus.FAILED, messageContainer.getMessage().getContent() instanceof MessageContent.Unsupported);
            adjustSpacing(messageContainer.getPosition());
        }

        private final void renderLabel(String str) {
            this.labelView.setText(str);
            this.labelView.setVisibility(str != null ? 0 : 8);
            this.labelView.setTextColor(MessageLogCellFactory.INSTANCE.adjustAlpha$zendesk_messaging_messaging_android(ContextCompat.getColor(this.labelView.getContext(), R.color.zma_color_on_background), 0.65f));
        }

        private final void renderAvatar(String str, MessageDirection messageDirection) {
            Unit unit;
            if (str != null) {
                this.avatarView.render(new MessageContainerAdapterDelegate$ViewHolder$renderAvatar$1$1(str, this));
                this.avatarView.setVisibility(0);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                ViewHolder viewHolder = this;
                this.avatarView.setVisibility(messageDirection == MessageDirection.INBOUND ? 4 : 8);
            }
        }

        private final void renderContent(MessageLogEntry.MessageContainer messageContainer, Function1<? super MessageLogEntry.MessageContainer, Unit> function1, UriHandler uriHandler, Function2<? super List<? extends Field>, ? super MessageLogEntry.MessageContainer, Unit> function2, Function1<? super Boolean, Unit> function12, Function1<? super DisplayedField, Unit> function13, Map<Integer, DisplayedField> map) {
            View view;
            View view2;
            MessageLogEntry.MessageContainer messageContainer2 = messageContainer;
            UriHandler uriHandler2 = uriHandler;
            Function2<? super List<? extends Field>, ? super MessageLogEntry.MessageContainer, Unit> function22 = function2;
            Function1<? super Boolean, Unit> function14 = function12;
            this.contentView.removeAllViews();
            MessageContent content = messageContainer.getMessage().getContent();
            if (content instanceof MessageContent.Unsupported) {
                view = MessageLogCellFactory.INSTANCE.createUnsupportedCell(messageContainer2, this.contentView);
            } else if (content instanceof MessageContent.Carousel) {
                view = MessageLogCellFactory.INSTANCE.createCarouselCell(this.contentView, (MessageContent.Carousel) content, messageContainer, this.actionColor, uriHandler);
            } else if (content instanceof MessageContent.Image) {
                view = MessageLogCellFactory.createImageCell$default(MessageLogCellFactory.INSTANCE, (MessageContent.Image) content, messageContainer, this.contentView, uriHandler, (Integer) null, (Function1) null, this.actionColor, 48, (Object) null);
            } else if (content instanceof MessageContent.File) {
                view = MessageLogCellFactory.INSTANCE.createFileCell((MessageContent.File) content, messageContainer, this.contentView, this.outboundMessageColor, new MessageContainerAdapterDelegate$ViewHolder$renderContent$view$1(uriHandler2));
            } else if (content instanceof MessageContent.FileUpload) {
                MessageContent.FileUpload fileUpload = (MessageContent.FileUpload) content;
                if (fileUpload.isImageMimeType()) {
                    view = MessageLogCellFactory.INSTANCE.createImageUploadCell(fileUpload, messageContainer, this.contentView, this.outboundMessageColor, function1, uriHandler);
                } else {
                    view = MessageLogCellFactory.INSTANCE.createFileUploadCell(fileUpload, messageContainer, this.contentView, this.outboundMessageColor, function1);
                }
            } else if (content instanceof MessageContent.Form) {
                view = MessageLogCellFactory.INSTANCE.createFormView(this.contentView, RenderingUpdates.INSTANCE.formRenderingUpdate(((MessageContent.Form) content).getFields(), new MessageContainerAdapterDelegate$ViewHolder$renderContent$view$2(function22, messageContainer2), new MessageContainerAdapterDelegate$ViewHolder$renderContent$view$3(function14), this.actionColor, false, function13, map));
            } else if (content instanceof MessageContent.FormResponse) {
                int i = WhenMappings.$EnumSwitchMapping$0[messageContainer.getMessage().getStatus().ordinal()];
                if (i == 1) {
                    view2 = MessageLogCellFactory.INSTANCE.createFormView(this.contentView, RenderingUpdates.INSTANCE.formRenderingUpdate(((MessageContent.FormResponse) content).getFields(), new MessageContainerAdapterDelegate$ViewHolder$renderContent$view$4(function22, messageContainer2), new MessageContainerAdapterDelegate$ViewHolder$renderContent$view$5(function14), this.actionColor, true, function13, map));
                } else if (i == 2) {
                    view2 = MessageLogCellFactory.INSTANCE.createFormView(this.contentView, RenderingUpdates.INSTANCE.formRenderingUpdate(((MessageContent.FormResponse) content).getFields(), new MessageContainerAdapterDelegate$ViewHolder$renderContent$view$6(function22, messageContainer2), new MessageContainerAdapterDelegate$ViewHolder$renderContent$view$7(function14), this.actionColor, false, function13, map));
                } else if (i == 3) {
                    view2 = MessageLogCellFactory.INSTANCE.createFormResponseView(this.contentView, RenderingUpdates.INSTANCE.formResponseRenderingUpdate(((MessageContent.FormResponse) content).getFields()));
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                view = view2;
            } else if (content instanceof MessageContent.Text) {
                MessageLogCellFactory messageLogCellFactory = MessageLogCellFactory.INSTANCE;
                LinearLayout linearLayout = this.contentView;
                ViewGroup viewGroup = linearLayout;
                MessageLogEntry.MessageContainer messageContainer3 = messageContainer;
                view = messageLogCellFactory.createTextCell(messageContainer3, viewGroup, this.outboundMessageColor, this.actionColor, clickListener(messageContainer, function1), new MessageContainerAdapterDelegate$ViewHolder$renderContent$view$8(uriHandler2), uriHandler);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            adjustDirectionAndWidth(view, content, messageContainer.getDirection());
            this.contentView.addView(view);
        }

        private final void renderReceipt(MessageReceipt messageReceipt, MessageDirection messageDirection, MessageStatus messageStatus, boolean z, boolean z2) {
            int i;
            if (messageReceipt == null) {
                this.receiptView.setVisibility(8);
                return;
            }
            this.receiptView.render(new MessageContainerAdapterDelegate$ViewHolder$renderReceipt$1(this, messageReceipt, z, messageDirection, messageStatus, z2));
            this.receiptView.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.receiptView.getLayoutParams();
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                int i2 = WhenMappings.$EnumSwitchMapping$1[messageDirection.ordinal()];
                if (i2 == 1) {
                    i = GravityCompat.START;
                } else if (i2 == 2) {
                    i = GravityCompat.END;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                layoutParams2.gravity = i;
                this.receiptView.setLayoutParams(layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }

        private final void adjustDirectionAndWidth(View view, MessageContent messageContent, MessageDirection messageDirection) {
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(R.dimen.zuia_horizontal_spacing_small);
            int dimensionPixelSize2 = view.getResources().getDimensionPixelSize(R.dimen.zma_cell_inbound_margin_end);
            int dimensionPixelSize3 = view.getResources().getDimensionPixelSize(R.dimen.zma_cell_outbound_margin_end);
            view.setMinimumWidth(view.getResources().getDimensionPixelSize(R.dimen.zma_message_cell_min_width));
            if ((messageContent instanceof MessageContent.Form) || (messageContent instanceof MessageContent.FormResponse)) {
                edgeToEdge(view, new MessageContainerAdapterDelegate$ViewHolder$adjustDirectionAndWidth$1(dimensionPixelSize));
            } else if (messageContent instanceof MessageContent.Carousel) {
                edgeToEdge(view);
            } else if ((messageContent instanceof MessageContent.Image) || adjustDirectionAndWidth$isImageUploadCell(messageContent)) {
                edgeToEdge(view, new MessageContainerAdapterDelegate$ViewHolder$adjustDirectionAndWidth$2(messageDirection, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize));
            } else if ((messageContent instanceof MessageContent.File) || (messageContent instanceof MessageContent.FileUpload) || (messageContent instanceof MessageContent.Text) || (messageContent instanceof MessageContent.Unsupported)) {
                wrap(view, new MessageContainerAdapterDelegate$ViewHolder$adjustDirectionAndWidth$3(messageDirection, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize));
                this.contentView.setGravity(messageDirection == MessageDirection.OUTBOUND ? GravityCompat.END : GravityCompat.START);
            }
        }

        private static final boolean adjustDirectionAndWidth$isImageUploadCell(MessageContent messageContent) {
            return (messageContent instanceof MessageContent.FileUpload) && ((MessageContent.FileUpload) messageContent).isImageMimeType();
        }

        private final void edgeToEdge(View view, Function1<? super LinearLayout.LayoutParams, Unit> function1) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            function1.invoke(layoutParams);
            view.setLayoutParams(layoutParams);
        }

        private final void edgeToEdge(View view) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }

        private final void wrap(View view, Function1<? super LinearLayout.LayoutParams, Unit> function1) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            function1.invoke(layoutParams);
            view.setLayoutParams(layoutParams);
        }

        private final void adjustSpacing(MessagePosition messagePosition) {
            int dimensionPixelSize = this.itemView.getResources().getDimensionPixelSize(R.dimen.zuia_vertical_spacing_small);
            int dimensionPixelSize2 = this.itemView.getResources().getDimensionPixelSize(R.dimen.zuia_vertical_spacing_large);
            int i = WhenMappings.$EnumSwitchMapping$2[messagePosition.ordinal()];
            if (i != 1) {
                if (!(i == 2 || i == 3)) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                this.itemView.setPaddingRelative(0, 0, 0, dimensionPixelSize);
            }
            dimensionPixelSize = dimensionPixelSize2;
            this.itemView.setPaddingRelative(0, 0, 0, dimensionPixelSize);
        }

        private final Function1<MessageLogEntry.MessageContainer, Unit> clickListener(MessageLogEntry.MessageContainer messageContainer, Function1<? super MessageLogEntry.MessageContainer, Unit> function1) {
            return messageContainer.getMessage().getStatus() == MessageStatus.FAILED ? function1 : MessageLogListenersKt.getNOOP_ON_MESSAGE_CONTAINER_CLICKED_LISTENER();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/delegates/MessageContainerAdapterDelegate$Companion;", "", "()V", "LABEL_ALPHA", "", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageContainerAdapterDelegate.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
