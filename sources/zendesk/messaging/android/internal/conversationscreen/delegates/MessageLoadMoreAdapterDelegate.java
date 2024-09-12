package zendesk.messaging.android.internal.conversationscreen.delegates;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zendesk.messaging.R;
import zendesk.messaging.android.internal.adapterdelegate.ListItemAdapterDelegate;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.ui.android.conversation.messageloadmore.MessageLoadMoreView;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0005J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J(\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00042\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0011H\u0014J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/delegates/MessageLoadMoreAdapterDelegate;", "Lzendesk/messaging/android/internal/adapterdelegate/ListItemAdapterDelegate;", "Lzendesk/messaging/android/internal/model/MessageLogEntry$LoadMore;", "Lzendesk/messaging/android/internal/model/MessageLogEntry;", "Lzendesk/messaging/android/internal/conversationscreen/delegates/MessageLoadMoreAdapterDelegate$ViewHolder;", "()V", "onRetryClicked", "Lkotlin/Function0;", "", "getOnRetryClicked$zendesk_messaging_messaging_android", "()Lkotlin/jvm/functions/Function0;", "setOnRetryClicked$zendesk_messaging_messaging_android", "(Lkotlin/jvm/functions/Function0;)V", "isForViewType", "", "item", "items", "", "position", "", "onBindViewHolder", "holder", "payloads", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "ViewHolder", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLoadMoreAdapterDelegate.kt */
public final class MessageLoadMoreAdapterDelegate extends ListItemAdapterDelegate<MessageLogEntry.LoadMore, MessageLogEntry, ViewHolder> {
    private Function0<Unit> onRetryClicked;

    public final Function0<Unit> getOnRetryClicked$zendesk_messaging_messaging_android() {
        return this.onRetryClicked;
    }

    public final void setOnRetryClicked$zendesk_messaging_messaging_android(Function0<Unit> function0) {
        this.onRetryClicked = function0;
    }

    /* access modifiers changed from: protected */
    public boolean isForViewType(MessageLogEntry messageLogEntry, List<? extends MessageLogEntry> list, int i) {
        Intrinsics.checkNotNullParameter(messageLogEntry, "item");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        return messageLogEntry instanceof MessageLogEntry.LoadMore;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.zma_view_message_log_entry_message_load_more, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   …load_more, parent, false)");
        Function0<Unit> function0 = this.onRetryClicked;
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new ViewHolder(inflate, function0, context);
    }

    /* access modifiers changed from: protected */
    public void onBindViewHolder(MessageLogEntry.LoadMore loadMore, ViewHolder viewHolder, List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(loadMore, "item");
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        viewHolder.bind(loadMore);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/delegates/MessageLoadMoreAdapterDelegate$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "onRetryClicked", "Lkotlin/Function0;", "", "context", "Landroid/content/Context;", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "messageLoadMoreView", "Lzendesk/ui/android/conversation/messageloadmore/MessageLoadMoreView;", "getOnRetryClicked", "()Lkotlin/jvm/functions/Function0;", "bind", "item", "Lzendesk/messaging/android/internal/model/MessageLogEntry$LoadMore;", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageLoadMoreAdapterDelegate.kt */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final Context context;
        private final MessageLoadMoreView messageLoadMoreView;
        private final Function0<Unit> onRetryClicked;

        public final Function0<Unit> getOnRetryClicked() {
            return this.onRetryClicked;
        }

        public final Context getContext() {
            return this.context;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view, Function0<Unit> function0, Context context2) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(context2, "context");
            this.onRetryClicked = function0;
            this.context = context2;
            View findViewById = view.findViewById(R.id.zma_messages_load_more);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.zma_messages_load_more)");
            this.messageLoadMoreView = (MessageLoadMoreView) findViewById;
        }

        public final void bind(MessageLogEntry.LoadMore loadMore) {
            Intrinsics.checkNotNullParameter(loadMore, "item");
            this.messageLoadMoreView.render(new MessageLoadMoreAdapterDelegate$ViewHolder$bind$1(this, loadMore));
        }
    }
}
