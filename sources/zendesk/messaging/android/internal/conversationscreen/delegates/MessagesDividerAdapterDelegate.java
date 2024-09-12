package zendesk.messaging.android.internal.conversationscreen.delegates;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.messaging.R;
import zendesk.messaging.android.internal.adapterdelegate.ListItemAdapterDelegate;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.messaging.android.internal.model.MessageLogType;
import zendesk.ui.android.conversation.messagesdivider.MessagesDividerState;
import zendesk.ui.android.conversation.messagesdivider.MessagesDividerView;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0005J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0014J(\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00042\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0011H\u0014J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/delegates/MessagesDividerAdapterDelegate;", "Lzendesk/messaging/android/internal/adapterdelegate/ListItemAdapterDelegate;", "Lzendesk/messaging/android/internal/model/MessageLogEntry$MessagesDivider;", "Lzendesk/messaging/android/internal/model/MessageLogEntry;", "Lzendesk/messaging/android/internal/conversationscreen/delegates/MessagesDividerAdapterDelegate$ViewHolder;", "()V", "dividerColor", "", "getDividerColor", "()Ljava/lang/Integer;", "setDividerColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "isForViewType", "", "item", "items", "", "position", "onBindViewHolder", "", "holder", "payloads", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "ViewHolder", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessagesDividerAdapterDelegate.kt */
public final class MessagesDividerAdapterDelegate extends ListItemAdapterDelegate<MessageLogEntry.MessagesDivider, MessageLogEntry, ViewHolder> {
    private Integer dividerColor;

    public final Integer getDividerColor() {
        return this.dividerColor;
    }

    public final void setDividerColor(Integer num) {
        this.dividerColor = num;
    }

    /* access modifiers changed from: protected */
    public boolean isForViewType(MessageLogEntry messageLogEntry, List<? extends MessageLogEntry> list, int i) {
        Intrinsics.checkNotNullParameter(messageLogEntry, "item");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        return messageLogEntry instanceof MessageLogEntry.MessagesDivider;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.zma_view_message_log_entry_messages_divider, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   …s_divider, parent, false)");
        Integer num = this.dividerColor;
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new ViewHolder(inflate, num, context);
    }

    /* access modifiers changed from: protected */
    public void onBindViewHolder(MessageLogEntry.MessagesDivider messagesDivider, ViewHolder viewHolder, List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(messagesDivider, "item");
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        viewHolder.bind(messagesDivider);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/delegates/MessagesDividerAdapterDelegate$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "dividerColor", "", "context", "Landroid/content/Context;", "(Landroid/view/View;Ljava/lang/Integer;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "Ljava/lang/Integer;", "messagesDividerView", "Lzendesk/ui/android/conversation/messagesdivider/MessagesDividerView;", "bind", "", "item", "Lzendesk/messaging/android/internal/model/MessageLogEntry$MessagesDivider;", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessagesDividerAdapterDelegate.kt */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final Context context;
        private final Integer dividerColor;
        private final MessagesDividerView messagesDividerView;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: MessagesDividerAdapterDelegate.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[MessageLogType.values().length];
                iArr[MessageLogType.NewMessagesDivider.ordinal()] = 1;
                iArr[MessageLogType.TimeStampDivider.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ViewHolder(View view, Integer num, Context context2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(view, (i & 2) != 0 ? null : num, context2);
        }

        public final Context getContext() {
            return this.context;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view, Integer num, Context context2) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(context2, "context");
            this.dividerColor = num;
            this.context = context2;
            View findViewById = view.findViewById(R.id.zma_messages_divider);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(\n …essages_divider\n        )");
            this.messagesDividerView = (MessagesDividerView) findViewById;
        }

        public final void bind(MessageLogEntry.MessagesDivider messagesDivider) {
            MessagesDividerState messagesDividerState;
            Intrinsics.checkNotNullParameter(messagesDivider, "item");
            int i = WhenMappings.$EnumSwitchMapping$0[messagesDivider.getType().ordinal()];
            if (i == 1) {
                messagesDividerState = MessagesDividerState.Companion.newMessagesDividerState(this.dividerColor, this.context);
            } else if (i == 2) {
                messagesDividerState = MessagesDividerState.Companion.timeDividerState(this.context);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            this.messagesDividerView.render(new MessagesDividerAdapterDelegate$ViewHolder$bind$1(messagesDivider, messagesDividerState));
        }
    }
}
