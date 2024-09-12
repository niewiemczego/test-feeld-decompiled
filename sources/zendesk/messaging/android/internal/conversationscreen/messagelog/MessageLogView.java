package zendesk.messaging.android.internal.conversationscreen.messagelog;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.messaging.R;
import zendesk.messaging.android.internal.conversationscreen.MessageListAdapter;
import zendesk.messaging.android.internal.conversationscreen.delegates.MessageContainerAdapterDelegate;
import zendesk.messaging.android.internal.conversationscreen.delegates.MessageLoadMoreAdapterDelegate;
import zendesk.messaging.android.internal.conversationscreen.delegates.MessagesDividerAdapterDelegate;
import zendesk.messaging.android.internal.conversationscreen.delegates.QuickReplyAdapterDelegate;
import zendesk.messaging.android.internal.model.MessageDirection;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.ui.android.Renderer;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000  2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001 B/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u001c\u0010\u0019\u001a\u00020\u00182\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\f\u0010\u001f\u001a\u00020\u0018*\u00020\u0013H\u0002R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogView;", "Landroid/widget/FrameLayout;", "Lzendesk/ui/android/Renderer;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogRendering;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "isFormFocused", "", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "messageListAdapter", "Lzendesk/messaging/android/internal/conversationscreen/MessageListAdapter;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rendering", "verticalScrollOffset", "Ljava/util/concurrent/atomic/AtomicInteger;", "announceNewMessageContentForAccessibility", "", "render", "renderingUpdate", "Lkotlin/Function1;", "updateScrollingBehaviourOnFocusChange", "newFocus", "Landroid/view/View;", "onScrollToBottomIfKeyboardShown", "Companion", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLogView.kt */
public final class MessageLogView extends FrameLayout implements Renderer<MessageLogRendering> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final long NEW_CONTENT_CHANGE_ACCESSIBILITY_EVENT_DELAY = 1500;
    private boolean isFormFocused;
    /* access modifiers changed from: private */
    public LinearLayoutManager layoutManager;
    private final MessageListAdapter messageListAdapter;
    private final RecyclerView recyclerView;
    /* access modifiers changed from: private */
    public MessageLogRendering rendering;
    /* access modifiers changed from: private */
    public AtomicInteger verticalScrollOffset;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MessageLogView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MessageLogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MessageLogView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageLogView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageLogView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rendering = new MessageLogRendering();
        this.layoutManager = new LinearLayoutManager(context, 1, false);
        this.verticalScrollOffset = new AtomicInteger(0);
        FrameLayout.inflate(context, R.layout.zma_view_message_log, this);
        View findViewById = findViewById(R.id.zma_message_list_recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.zma_message_list_recycler_view)");
        RecyclerView recyclerView2 = (RecyclerView) findViewById;
        this.recyclerView = recyclerView2;
        MessageListAdapter messageListAdapter2 = new MessageListAdapter((MessageContainerAdapterDelegate) null, (MessagesDividerAdapterDelegate) null, (MessageLoadMoreAdapterDelegate) null, (QuickReplyAdapterDelegate) null, 15, (DefaultConstructorMarker) null);
        this.messageListAdapter = messageListAdapter2;
        recyclerView2.setAdapter(messageListAdapter2);
        recyclerView2.setLayoutManager(this.layoutManager);
        recyclerView2.addOnLayoutChangeListener(new MessageLogView$$ExternalSyntheticLambda2(this));
        recyclerView2.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
            private AtomicInteger state = new AtomicInteger(0);
            final /* synthetic */ MessageLogView this$0;

            {
                this.this$0 = r2;
            }

            public final AtomicInteger getState() {
                return this.state;
            }

            public final void setState(AtomicInteger atomicInteger) {
                Intrinsics.checkNotNullParameter(atomicInteger, "<set-?>");
                this.state = atomicInteger;
            }

            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                this.state.compareAndSet(0, i);
                if (i != 0) {
                    if (i == 1) {
                        this.state.compareAndSet(0, i);
                    } else if (i == 2) {
                        this.state.compareAndSet(1, i);
                    }
                } else if (!this.state.compareAndSet(2, i)) {
                    this.state.compareAndSet(1, i);
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (this.state.get() != 0) {
                    this.this$0.verticalScrollOffset.getAndAdd(i2);
                    this.this$0.rendering.getOnLoadMoreListener$zendesk_messaging_messaging_android().invoke(Boolean.valueOf(this.this$0.layoutManager.findFirstCompletelyVisibleItemPosition() == 0));
                }
            }
        });
        recyclerView2.getViewTreeObserver().addOnGlobalFocusChangeListener(new MessageLogView$$ExternalSyntheticLambda3(this));
        render(AnonymousClass4.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m691_init_$lambda0(MessageLogView messageLogView, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(messageLogView, "this$0");
        if (!messageLogView.isFormFocused) {
            int i9 = i8 - i4;
            if (Math.abs(i9) <= 0) {
                return;
            }
            if (i9 > 0 || Math.abs(messageLogView.verticalScrollOffset.get()) >= Math.abs(i9)) {
                messageLogView.recyclerView.scrollBy(0, Math.abs(i9));
            } else {
                messageLogView.recyclerView.scrollBy(0, messageLogView.verticalScrollOffset.get());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m692_init_$lambda1(MessageLogView messageLogView, View view, View view2) {
        Intrinsics.checkNotNullParameter(messageLogView, "this$0");
        messageLogView.updateScrollingBehaviourOnFocusChange(view2);
    }

    public void render(Function1<? super MessageLogRendering, MessageLogRendering> function1) {
        Intrinsics.checkNotNullParameter(function1, "renderingUpdate");
        MessageLogRendering invoke = function1.invoke(this.rendering);
        this.rendering = invoke;
        Integer outboundMessageColor$zendesk_messaging_messaging_android = invoke.getState$zendesk_messaging_messaging_android().getOutboundMessageColor$zendesk_messaging_messaging_android();
        if (outboundMessageColor$zendesk_messaging_messaging_android != null) {
            this.recyclerView.setEdgeEffectFactory(new MessageLogView$render$1$1(outboundMessageColor$zendesk_messaging_messaging_android.intValue()));
        }
        MessageListAdapter messageListAdapter2 = this.messageListAdapter;
        messageListAdapter2.setOutboundMessageColor(this.rendering.getState$zendesk_messaging_messaging_android().getOutboundMessageColor$zendesk_messaging_messaging_android());
        messageListAdapter2.setOnReplyActionSelected(this.rendering.getOnReplyActionSelected$zendesk_messaging_messaging_android());
        messageListAdapter2.setOnFailedMessageClicked(this.rendering.getOnFailedMessageClicked$zendesk_messaging_messaging_android());
        messageListAdapter2.setOnUriClicked(this.rendering.getOnUriClicked$zendesk_messaging_messaging_android());
        messageListAdapter2.setOnFormCompleted(this.rendering.getOnFormCompleted$zendesk_messaging_messaging_android());
        messageListAdapter2.setOnFormFocusChanged(this.rendering.getOnFormFocusChanged$zendesk_messaging_messaging_android());
        messageListAdapter2.setActionColor(this.rendering.getState$zendesk_messaging_messaging_android().getActionColor$zendesk_messaging_messaging_android());
        messageListAdapter2.setNotifyColor(this.rendering.getState$zendesk_messaging_messaging_android().getNotifyColor$zendesk_messaging_messaging_android());
        messageListAdapter2.setMapOfDisplayedFields(this.rendering.getState$zendesk_messaging_messaging_android().getMapOfDisplayedFields$zendesk_messaging_messaging_android());
        messageListAdapter2.setOnFormDisplayedFieldsChanged(this.rendering.getOnFormDisplayedFieldsChanged$zendesk_messaging_messaging_android());
        messageListAdapter2.setOnLoadMoreRetryClicked(this.rendering.getOnRetryLoadMoreClickedListener$zendesk_messaging_messaging_android());
        messageListAdapter2.submitList(this.rendering.getState$zendesk_messaging_messaging_android().getMessageLogEntryList$zendesk_messaging_messaging_android(), new MessageLogView$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: render$lambda-4$lambda-3  reason: not valid java name */
    public static final void m694render$lambda4$lambda3(MessageLogView messageLogView) {
        Intrinsics.checkNotNullParameter(messageLogView, "this$0");
        boolean z = true;
        int size = messageLogView.rendering.getState$zendesk_messaging_messaging_android().getMessageLogEntryList$zendesk_messaging_messaging_android().size() - 1;
        RecyclerView.LayoutManager layoutManager2 = messageLogView.recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager2 instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager2 : null;
        if (linearLayoutManager == null || linearLayoutManager.findLastVisibleItemPosition() != size - 1) {
            z = false;
        }
        if (z || messageLogView.rendering.getState$zendesk_messaging_messaging_android().getShouldScrollToBottom$zendesk_messaging_messaging_android()) {
            messageLogView.recyclerView.scrollToPosition(size);
        }
        messageLogView.announceNewMessageContentForAccessibility();
    }

    private final void onScrollToBottomIfKeyboardShown(RecyclerView recyclerView2) {
        RecyclerView.Adapter adapter;
        RecyclerView.LayoutManager layoutManager2 = recyclerView2.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager2 instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager2 : null;
        View view = recyclerView2;
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int height = view.getRootView().getHeight();
        if (((float) (height - rect.bottom)) > ((float) height) * 0.15f && (adapter = recyclerView2.getAdapter()) != null) {
            int itemCount = adapter.getItemCount() - 1;
            if (linearLayoutManager != null) {
                linearLayoutManager.scrollToPosition(itemCount);
                recyclerView2.post(new MessageLogView$onScrollToBottomIfKeyboardShown$1$1$1$1(linearLayoutManager, itemCount, recyclerView2));
            }
        }
    }

    private final void announceNewMessageContentForAccessibility() {
        Collection arrayList = new ArrayList();
        for (Object next : this.rendering.getState$zendesk_messaging_messaging_android().getMessageLogEntryList$zendesk_messaging_messaging_android()) {
            if (next instanceof MessageLogEntry.MessageContainer) {
                arrayList.add(next);
            }
        }
        List list = (List) arrayList;
        if (!list.isEmpty()) {
            MessageLogEntry.MessageContainer messageContainer = (MessageLogEntry.MessageContainer) CollectionsKt.last(list);
            if (messageContainer.getDirection() == MessageDirection.INBOUND && this.rendering.getState$zendesk_messaging_messaging_android().getShouldAnnounceMessage$zendesk_messaging_messaging_android()) {
                this.recyclerView.postDelayed(new MessageLogView$$ExternalSyntheticLambda1(this, messageContainer), NEW_CONTENT_CHANGE_ACCESSIBILITY_EVENT_DELAY);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: announceNewMessageContentForAccessibility$lambda-9  reason: not valid java name */
    public static final void m693announceNewMessageContentForAccessibility$lambda9(MessageLogView messageLogView, MessageLogEntry.MessageContainer messageContainer) {
        Intrinsics.checkNotNullParameter(messageLogView, "this$0");
        Intrinsics.checkNotNullParameter(messageContainer, "$lastMessageEntry");
        RecyclerView recyclerView2 = messageLogView.recyclerView;
        recyclerView2.announceForAccessibility(recyclerView2.getContext().getString(R.string.zuia_new_content_change_accessibility_label, new Object[]{messageContainer.getMessage().getAuthor().getDisplayName()}));
    }

    private final void updateScrollingBehaviourOnFocusChange(View view) {
        if (!(view != null && view.getId() == R.id.zuia_field_input)) {
            this.isFormFocused = false;
            onScrollToBottomIfKeyboardShown(this.recyclerView);
            return;
        }
        this.isFormFocused = true;
        this.recyclerView.stopScroll();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogView$Companion;", "", "()V", "NEW_CONTENT_CHANGE_ACCESSIBILITY_EVENT_DELAY", "", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageLogView.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
