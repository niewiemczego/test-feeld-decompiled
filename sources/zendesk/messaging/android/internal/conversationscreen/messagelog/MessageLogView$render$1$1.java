package zendesk.messaging.android.internal.conversationscreen.messagelog;

import android.widget.EdgeEffect;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014¨\u0006\b"}, d2 = {"zendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogView$render$1$1", "Landroidx/recyclerview/widget/RecyclerView$EdgeEffectFactory;", "createEdgeEffect", "Landroid/widget/EdgeEffect;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "direction", "", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLogView.kt */
public final class MessageLogView$render$1$1 extends RecyclerView.EdgeEffectFactory {
    final /* synthetic */ int $customColor;

    MessageLogView$render$1$1(int i) {
        this.$customColor = i;
    }

    /* access modifiers changed from: protected */
    public EdgeEffect createEdgeEffect(RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, ViewHierarchyConstants.VIEW_KEY);
        EdgeEffect edgeEffect = new EdgeEffect(recyclerView.getContext());
        edgeEffect.setColor(this.$customColor);
        return edgeEffect;
    }
}
