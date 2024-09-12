package zendesk.messaging.android.internal.conversationscreen.messagelog;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLogView.kt */
final class MessageLogView$onScrollToBottomIfKeyboardShown$1$1$1$1 implements Runnable {
    final /* synthetic */ int $lastItemPosition;
    final /* synthetic */ LinearLayoutManager $layoutManager;
    final /* synthetic */ RecyclerView $this_onScrollToBottomIfKeyboardShown;

    MessageLogView$onScrollToBottomIfKeyboardShown$1$1$1$1(LinearLayoutManager linearLayoutManager, int i, RecyclerView recyclerView) {
        this.$layoutManager = linearLayoutManager;
        this.$lastItemPosition = i;
        this.$this_onScrollToBottomIfKeyboardShown = recyclerView;
    }

    public final void run() {
        View findViewByPosition = this.$layoutManager.findViewByPosition(this.$lastItemPosition);
        if (findViewByPosition != null) {
            this.$layoutManager.scrollToPositionWithOffset(this.$lastItemPosition, this.$this_onScrollToBottomIfKeyboardShown.getMeasuredHeight() - findViewByPosition.getMeasuredHeight());
        }
    }
}
