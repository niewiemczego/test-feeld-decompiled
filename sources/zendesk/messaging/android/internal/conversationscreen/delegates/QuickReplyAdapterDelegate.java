package zendesk.messaging.android.internal.conversationscreen.delegates;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.model.MessageAction;
import zendesk.messaging.R;
import zendesk.messaging.android.internal.adapterdelegate.ListItemAdapterDelegate;
import zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogListenersKt;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.ui.android.conversation.quickreply.QuickReplyView;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\"B\u001f\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\t¢\u0006\u0002\u0010\nJ&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u0006\u0010\u001a\u001a\u00020\u000fH\u0014J(\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00042\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u0019H\u0014J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020!H\u0016R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u0002`\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\nR\"\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006#"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/delegates/QuickReplyAdapterDelegate;", "Lzendesk/messaging/android/internal/adapterdelegate/ListItemAdapterDelegate;", "Lzendesk/messaging/android/internal/model/MessageLogEntry$QuickReply;", "Lzendesk/messaging/android/internal/model/MessageLogEntry;", "Lzendesk/messaging/android/internal/conversationscreen/delegates/QuickReplyAdapterDelegate$ViewHolder;", "onOptionSelected", "Lkotlin/Function1;", "Lzendesk/conversationkit/android/model/MessageAction$Reply;", "", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnReplyActionSelected;", "(Lkotlin/jvm/functions/Function1;)V", "getOnOptionSelected", "()Lkotlin/jvm/functions/Function1;", "setOnOptionSelected", "quickReplyColor", "", "getQuickReplyColor", "()Ljava/lang/Integer;", "setQuickReplyColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "isForViewType", "", "item", "items", "", "position", "onBindViewHolder", "holder", "payloads", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "ViewHolder", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: QuickReplyAdapterDelegate.kt */
public final class QuickReplyAdapterDelegate extends ListItemAdapterDelegate<MessageLogEntry.QuickReply, MessageLogEntry, ViewHolder> {
    private Function1<? super MessageAction.Reply, Unit> onOptionSelected;
    private Integer quickReplyColor;

    public QuickReplyAdapterDelegate() {
        this((Function1) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QuickReplyAdapterDelegate(Function1<MessageAction.Reply, Unit> function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MessageLogListenersKt.getNOOP_ON_QUICK_REPLY_OPTION_SELECTED_LISTENER() : function1);
    }

    public final Function1<MessageAction.Reply, Unit> getOnOptionSelected() {
        return this.onOptionSelected;
    }

    public final void setOnOptionSelected(Function1<? super MessageAction.Reply, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onOptionSelected = function1;
    }

    public QuickReplyAdapterDelegate(Function1<? super MessageAction.Reply, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onOptionSelected");
        this.onOptionSelected = function1;
    }

    public final Integer getQuickReplyColor() {
        return this.quickReplyColor;
    }

    public final void setQuickReplyColor(Integer num) {
        this.quickReplyColor = num;
    }

    /* access modifiers changed from: protected */
    public boolean isForViewType(MessageLogEntry messageLogEntry, List<? extends MessageLogEntry> list, int i) {
        Intrinsics.checkNotNullParameter(messageLogEntry, "item");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        return messageLogEntry instanceof MessageLogEntry.QuickReply;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.zma_view_message_log_entry_quick_reply, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   …ick_reply, parent, false)");
        return new ViewHolder(inflate, this.quickReplyColor);
    }

    /* access modifiers changed from: protected */
    public void onBindViewHolder(MessageLogEntry.QuickReply quickReply, ViewHolder viewHolder, List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(quickReply, "item");
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        viewHolder.bind(quickReply, this.onOptionSelected);
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000b0\u000fj\u0002`\u0011R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/delegates/QuickReplyAdapterDelegate$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "quickReplyColor", "", "(Landroid/view/View;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "quickReplyView", "Lzendesk/ui/android/conversation/quickreply/QuickReplyView;", "bind", "", "item", "Lzendesk/messaging/android/internal/model/MessageLogEntry$QuickReply;", "onReplyActionSelected", "Lkotlin/Function1;", "Lzendesk/conversationkit/android/model/MessageAction$Reply;", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/OnReplyActionSelected;", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: QuickReplyAdapterDelegate.kt */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final Integer quickReplyColor;
        private final QuickReplyView quickReplyView;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ViewHolder(View view, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(view, (i & 2) != 0 ? null : num);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view, Integer num) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.quickReplyColor = num;
            View findViewById = view.findViewById(R.id.zma_quick_reply);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.zma_quick_reply)");
            this.quickReplyView = (QuickReplyView) findViewById;
        }

        public final void bind(MessageLogEntry.QuickReply quickReply, Function1<? super MessageAction.Reply, Unit> function1) {
            Intrinsics.checkNotNullParameter(quickReply, "item");
            Intrinsics.checkNotNullParameter(function1, "onReplyActionSelected");
            this.quickReplyView.render(new QuickReplyAdapterDelegate$ViewHolder$bind$1(quickReply, this, function1));
        }
    }
}
