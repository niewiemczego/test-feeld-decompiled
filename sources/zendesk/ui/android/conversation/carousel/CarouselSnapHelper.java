package zendesk.ui.android.conversation.carousel;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lzendesk/ui/android/conversation/carousel/CarouselSnapHelper;", "Landroidx/recyclerview/widget/LinearSnapHelper;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "findSnapView", "Landroid/view/View;", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CarouselSnapHelper.kt */
public final class CarouselSnapHelper extends LinearSnapHelper {
    private final LinearLayoutManager linearLayoutManager;

    public CarouselSnapHelper(LinearLayoutManager linearLayoutManager2) {
        Intrinsics.checkNotNullParameter(linearLayoutManager2, "linearLayoutManager");
        this.linearLayoutManager = linearLayoutManager2;
    }

    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        if (this.linearLayoutManager.findFirstVisibleItemPosition() == 0 || this.linearLayoutManager.getItemCount() - 1 == this.linearLayoutManager.findLastVisibleItemPosition()) {
            return null;
        }
        return super.findSnapView(layoutManager);
    }
}
