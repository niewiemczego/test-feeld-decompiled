package zendesk.messaging.android.internal.conversationscreen.delegates;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.messaging.R;
import zendesk.messaging.android.internal.adapterdelegate.ListItemAdapterDelegate;
import zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogCellFactory;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.ui.android.conversation.avatar.AvatarImageView;
import zendesk.ui.android.conversation.receipt.MessageReceiptView;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0005J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\nH\u0014J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0016"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/delegates/TypingIndicatorAdapterDelegate;", "Lzendesk/messaging/android/internal/adapterdelegate/ListItemAdapterDelegate;", "Lzendesk/messaging/android/internal/model/MessageLogEntry$TypingIndicator;", "Lzendesk/messaging/android/internal/model/MessageLogEntry;", "Lzendesk/messaging/android/internal/conversationscreen/delegates/TypingIndicatorAdapterDelegate$ViewHolder;", "()V", "isForViewType", "", "item", "items", "", "position", "", "onBindViewHolder", "", "holder", "payloads", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "ViewHolder", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TypingIndicatorAdapterDelegate.kt */
public final class TypingIndicatorAdapterDelegate extends ListItemAdapterDelegate<MessageLogEntry.TypingIndicator, MessageLogEntry, ViewHolder> {
    /* access modifiers changed from: protected */
    public boolean isForViewType(MessageLogEntry messageLogEntry, List<? extends MessageLogEntry> list, int i) {
        Intrinsics.checkNotNullParameter(messageLogEntry, "item");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        return messageLogEntry instanceof MessageLogEntry.TypingIndicator;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.zma_view_message_log_entry_message_container, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   …container, parent, false)");
        return new ViewHolder(inflate);
    }

    /* access modifiers changed from: protected */
    public void onBindViewHolder(MessageLogEntry.TypingIndicator typingIndicator, ViewHolder viewHolder, List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(typingIndicator, "item");
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        viewHolder.bind(typingIndicator);
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/delegates/TypingIndicatorAdapterDelegate$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarView", "Lzendesk/ui/android/conversation/avatar/AvatarImageView;", "contentView", "Landroid/widget/LinearLayout;", "labelView", "Landroid/widget/TextView;", "receiptView", "Lzendesk/ui/android/conversation/receipt/MessageReceiptView;", "bind", "", "item", "Lzendesk/messaging/android/internal/model/MessageLogEntry$TypingIndicator;", "renderAvatar", "avatarUrl", "", "renderContent", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TypingIndicatorAdapterDelegate.kt */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public final AvatarImageView avatarView;
        private final LinearLayout contentView;
        private final TextView labelView;
        private final MessageReceiptView receiptView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
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

        public final void bind(MessageLogEntry.TypingIndicator typingIndicator) {
            Intrinsics.checkNotNullParameter(typingIndicator, "item");
            this.receiptView.setVisibility(8);
            this.labelView.setVisibility(8);
            renderContent();
            renderAvatar(typingIndicator.getAvatarUrl());
        }

        private final void renderContent() {
            LinearLayout linearLayout = this.contentView;
            linearLayout.removeAllViews();
            linearLayout.addView(MessageLogCellFactory.INSTANCE.createTypingIndicatorCell(this.contentView));
            linearLayout.getLayoutParams().width = -2;
            linearLayout.requestLayout();
        }

        private final void renderAvatar(String str) {
            this.avatarView.render(new TypingIndicatorAdapterDelegate$ViewHolder$renderAvatar$1(str, this));
            this.avatarView.setVisibility(0);
        }
    }
}
