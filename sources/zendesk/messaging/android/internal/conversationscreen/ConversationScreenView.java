package zendesk.messaging.android.internal.conversationscreen;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.model.Conversation;
import zendesk.conversationkit.android.model.Message;
import zendesk.logger.Logger;
import zendesk.messaging.R;
import zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogRendering;
import zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogView;
import zendesk.messaging.android.internal.model.LoadMoreStatus;
import zendesk.ui.android.Renderer;
import zendesk.ui.android.conversation.bottomsheet.BottomSheetRendering;
import zendesk.ui.android.conversation.bottomsheet.BottomSheetView;
import zendesk.ui.android.conversation.composer.MessageComposerRendering;
import zendesk.ui.android.conversation.composer.MessageComposerView;
import zendesk.ui.android.conversation.connectionbanner.ConnectionBannerRendering;
import zendesk.ui.android.conversation.connectionbanner.ConnectionBannerView;
import zendesk.ui.android.conversation.header.ConversationHeaderRendering;
import zendesk.ui.android.conversation.header.ConversationHeaderView;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 +2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001+B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J&\u0010&\u001a\u00020#2\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\fj\b\u0012\u0004\u0012\u00020\u0003`\u000eH\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0002R$\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\fj\b\u0012\u0004\u0012\u00020\u0012`\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\fj\b\u0012\u0004\u0012\u00020\u0016`\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\fj\b\u0012\u0004\u0012\u00020\u001a`\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\fj\b\u0012\u0004\u0012\u00020 `\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenView;", "Landroid/widget/RelativeLayout;", "Lzendesk/ui/android/Renderer;", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenRendering;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "connectionBannerRenderingUpdate", "Lkotlin/Function1;", "Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerRendering;", "Lzendesk/messaging/android/internal/conversationscreen/RenderingUpdate;", "connectionBannerView", "Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerView;", "conversationHeaderRenderingUpdate", "Lzendesk/ui/android/conversation/header/ConversationHeaderRendering;", "conversationHeaderView", "Lzendesk/ui/android/conversation/header/ConversationHeaderView;", "deniedPermissionBottomSheetRenderingUpdate", "Lzendesk/ui/android/conversation/bottomsheet/BottomSheetRendering;", "deniedPermissionBottomSheetView", "Lzendesk/ui/android/conversation/bottomsheet/BottomSheetView;", "messageComposerRenderingUpdate", "Lzendesk/ui/android/conversation/composer/MessageComposerRendering;", "messageComposerView", "Lzendesk/ui/android/conversation/composer/MessageComposerView;", "messageLogView", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogView;", "messageLogViewRenderingUpdate", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogRendering;", "rendering", "loadMoreMessages", "", "conversation", "Lzendesk/conversationkit/android/model/Conversation;", "render", "renderingUpdate", "updateMessageLogState", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogState;", "state", "Companion", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationScreenView.kt */
public final class ConversationScreenView extends RelativeLayout implements Renderer<ConversationScreenRendering> {
    @Deprecated
    private static final int COMPOSER_MAX_LENGTH = 4096;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String LOG_TAG = "ConversationScreenView";
    @Deprecated
    private static final int MAX_CONVERSATION_LIST_NUM = 100;
    private final Function1<ConnectionBannerRendering, ConnectionBannerRendering> connectionBannerRenderingUpdate;
    private final ConnectionBannerView connectionBannerView;
    private final Function1<ConversationHeaderRendering, ConversationHeaderRendering> conversationHeaderRenderingUpdate;
    private final ConversationHeaderView conversationHeaderView;
    private final Function1<BottomSheetRendering, BottomSheetRendering> deniedPermissionBottomSheetRenderingUpdate;
    private final BottomSheetView deniedPermissionBottomSheetView;
    private final Function1<MessageComposerRendering, MessageComposerRendering> messageComposerRenderingUpdate;
    private final MessageComposerView messageComposerView;
    private final MessageLogView messageLogView;
    private final Function1<MessageLogRendering, MessageLogRendering> messageLogViewRenderingUpdate;
    /* access modifiers changed from: private */
    public ConversationScreenRendering rendering;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationScreenView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadMoreStatus.values().length];
            iArr[LoadMoreStatus.LOADING.ordinal()] = 1;
            iArr[LoadMoreStatus.FAILED.ordinal()] = 2;
            iArr[LoadMoreStatus.NONE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ConversationScreenView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ConversationScreenView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConversationScreenView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConversationScreenView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rendering = new ConversationScreenRendering();
        this.conversationHeaderRenderingUpdate = new ConversationScreenView$conversationHeaderRenderingUpdate$1(this);
        this.connectionBannerRenderingUpdate = new ConversationScreenView$connectionBannerRenderingUpdate$1(this);
        this.messageLogViewRenderingUpdate = new ConversationScreenView$messageLogViewRenderingUpdate$1(this);
        this.messageComposerRenderingUpdate = new ConversationScreenView$messageComposerRenderingUpdate$1(this, context);
        this.deniedPermissionBottomSheetRenderingUpdate = new ConversationScreenView$deniedPermissionBottomSheetRenderingUpdate$1(this, context);
        RelativeLayout.inflate(context, R.layout.zma_view_conversation, this);
        View findViewById = findViewById(R.id.zma_conversation_header_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.zma_conversation_header_view)");
        this.conversationHeaderView = (ConversationHeaderView) findViewById;
        View findViewById2 = findViewById(R.id.zma_message_list);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.zma_message_list)");
        this.messageLogView = (MessageLogView) findViewById2;
        View findViewById3 = findViewById(R.id.zma_message_composer_view);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.zma_message_composer_view)");
        this.messageComposerView = (MessageComposerView) findViewById3;
        View findViewById4 = findViewById(R.id.zma_connection_banner_view);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.zma_connection_banner_view)");
        ConnectionBannerView connectionBannerView2 = (ConnectionBannerView) findViewById4;
        this.connectionBannerView = connectionBannerView2;
        this.deniedPermissionBottomSheetView = new BottomSheetView(context);
        connectionBannerView2.bringToFront();
        render(AnonymousClass1.INSTANCE);
    }

    public void render(Function1<? super ConversationScreenRendering, ConversationScreenRendering> function1) {
        Intrinsics.checkNotNullParameter(function1, "renderingUpdate");
        this.rendering = function1.invoke(this.rendering);
        Logger.i(LOG_TAG, "Updating the Conversation Screen with " + this.rendering.getState$zendesk_messaging_messaging_android(), new Object[0]);
        this.conversationHeaderView.render(this.conversationHeaderRenderingUpdate);
        this.connectionBannerView.render(this.connectionBannerRenderingUpdate);
        this.messageLogView.render(this.messageLogViewRenderingUpdate);
        this.messageComposerView.render(this.messageComposerRenderingUpdate);
        this.deniedPermissionBottomSheetView.render(this.deniedPermissionBottomSheetRenderingUpdate);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogState updateMessageLogState(zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogState r11) {
        /*
            r10 = this;
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenRendering r0 = r10.rendering
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenState r0 = r0.getState$zendesk_messaging_messaging_android()
            java.util.List r2 = r0.getMessageLog()
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenRendering r0 = r10.rendering
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenState r0 = r0.getState$zendesk_messaging_messaging_android()
            zendesk.android.messaging.model.ColorTheme r0 = r0.getColorTheme()
            r1 = r2
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r3 = r1.isEmpty()
            r4 = 1
            r3 = r3 ^ r4
            r5 = 0
            r6 = 0
            if (r3 == 0) goto L_0x003b
            java.lang.Object r3 = kotlin.collections.CollectionsKt.last(r2)
            boolean r7 = r3 instanceof zendesk.messaging.android.internal.model.MessageLogEntry.MessageContainer
            if (r7 == 0) goto L_0x002c
            zendesk.messaging.android.internal.model.MessageLogEntry$MessageContainer r3 = (zendesk.messaging.android.internal.model.MessageLogEntry.MessageContainer) r3
            goto L_0x002d
        L_0x002c:
            r3 = r6
        L_0x002d:
            if (r3 == 0) goto L_0x0034
            zendesk.messaging.android.internal.model.MessageDirection r3 = r3.getDirection()
            goto L_0x0035
        L_0x0034:
            r3 = r6
        L_0x0035:
            zendesk.messaging.android.internal.model.MessageDirection r7 = zendesk.messaging.android.internal.model.MessageDirection.OUTBOUND
            if (r3 != r7) goto L_0x003b
            r3 = r4
            goto L_0x003c
        L_0x003b:
            r3 = r5
        L_0x003c:
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r4
            if (r1 == 0) goto L_0x004d
            java.lang.Object r1 = kotlin.collections.CollectionsKt.last(r2)
            boolean r1 = r1 instanceof zendesk.messaging.android.internal.model.MessageLogEntry.QuickReply
            if (r1 == 0) goto L_0x004d
            r1 = r4
            goto L_0x004e
        L_0x004d:
            r1 = r5
        L_0x004e:
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenRendering r7 = r10.rendering
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenState r7 = r7.getState$zendesk_messaging_messaging_android()
            zendesk.messaging.android.internal.model.LoadMoreStatus r7 = r7.getLoadMoreStatus()
            if (r7 != 0) goto L_0x005c
            r7 = -1
            goto L_0x0064
        L_0x005c:
            int[] r8 = zendesk.messaging.android.internal.conversationscreen.ConversationScreenView.WhenMappings.$EnumSwitchMapping$0
            int r7 = r7.ordinal()
            r7 = r8[r7]
        L_0x0064:
            if (r7 == r4) goto L_0x006e
            r8 = 2
            if (r7 == r8) goto L_0x006e
            r8 = 3
            if (r7 == r8) goto L_0x006e
            r7 = r5
            goto L_0x006f
        L_0x006e:
            r7 = r4
        L_0x006f:
            java.util.List r8 = r11.getMessageLogEntryList$zendesk_messaging_messaging_android()
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L_0x0090
            if (r7 != 0) goto L_0x008e
            java.util.List r7 = r11.getMessageLogEntryList$zendesk_messaging_messaging_android()
            int r7 = r7.size()
            int r8 = r2.size()
            if (r7 == r8) goto L_0x008e
            if (r3 != 0) goto L_0x0090
            if (r1 == 0) goto L_0x008e
            goto L_0x0090
        L_0x008e:
            r3 = r5
            goto L_0x0091
        L_0x0090:
            r3 = r4
        L_0x0091:
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenRendering r1 = r10.rendering
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenState r1 = r1.getState$zendesk_messaging_messaging_android()
            zendesk.android.messaging.model.ColorTheme r1 = r1.getColorTheme()
            if (r1 == 0) goto L_0x00a7
            java.lang.String r4 = r1.getMessageColor()
            java.lang.Integer r1 = r1.toColorInt(r4)
            r7 = r1
            goto L_0x00a8
        L_0x00a7:
            r7 = r6
        L_0x00a8:
            if (r0 == 0) goto L_0x00b4
            java.lang.String r1 = r0.getActionColor()
            java.lang.Integer r1 = r0.toColorInt(r1)
            r8 = r1
            goto L_0x00b5
        L_0x00b4:
            r8 = r6
        L_0x00b5:
            if (r0 == 0) goto L_0x00d7
            java.lang.String r1 = r0.getNotifyColor()
            if (r1 == 0) goto L_0x00c8
            java.lang.Integer r0 = r0.toColorInt(r1)
            if (r0 == 0) goto L_0x00c8
            int r0 = r0.intValue()
            goto L_0x00d2
        L_0x00c8:
            android.content.Context r0 = r10.getContext()
            int r1 = zendesk.messaging.R.color.zma_color_notify
            int r0 = androidx.core.content.ContextCompat.getColor(r0, r1)
        L_0x00d2:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x00d8
        L_0x00d7:
            r0 = r6
        L_0x00d8:
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenRendering r1 = r10.rendering
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenState r1 = r1.getState$zendesk_messaging_messaging_android()
            zendesk.android.messaging.model.ColorTheme r1 = r1.getColorTheme()
            if (r1 == 0) goto L_0x00ee
            java.lang.String r4 = r1.getIconColor()
            if (r4 == 0) goto L_0x00ee
            java.lang.Integer r6 = r1.toColorInt(r4)
        L_0x00ee:
            r9 = r6
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenRendering r1 = r10.rendering
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenState r1 = r1.getState$zendesk_messaging_messaging_android()
            java.util.Map r4 = r1.getMapOfDisplayedFields()
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenRendering r1 = r10.rendering
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenState r1 = r1.getState$zendesk_messaging_messaging_android()
            boolean r5 = r1.getShouldAnnounceMessage()
            r1 = r11
            r6 = r7
            r7 = r8
            r8 = r0
            zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogState r11 = r1.copy(r2, r3, r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.ConversationScreenView.updateMessageLogState(zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogState):zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogState");
    }

    /* access modifiers changed from: private */
    public final void loadMoreMessages(Conversation conversation) {
        this.rendering.getOnLoadMoreMessages$zendesk_messaging_messaging_android().invoke(Double.valueOf(((Message) CollectionsKt.first(conversation.getMessages())).getBeforeTimestamp()));
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenView$Companion;", "", "()V", "COMPOSER_MAX_LENGTH", "", "LOG_TAG", "", "MAX_CONVERSATION_LIST_NUM", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationScreenView.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
