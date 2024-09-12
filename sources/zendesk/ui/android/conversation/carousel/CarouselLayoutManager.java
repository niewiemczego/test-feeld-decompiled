package zendesk.ui.android.conversation.carousel;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lzendesk/ui/android/conversation/carousel/CarouselLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "adapter", "Lzendesk/ui/android/conversation/carousel/CarouselRecyclerViewAdapter;", "(Landroid/content/Context;Lzendesk/ui/android/conversation/carousel/CarouselRecyclerViewAdapter;)V", "getAdapter", "()Lzendesk/ui/android/conversation/carousel/CarouselRecyclerViewAdapter;", "margin", "", "checkLayoutParams", "", "lp", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "setItemMargin", "", "setItemMargin$zendesk_ui_ui_android", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CarouselLayoutManager.kt */
public final class CarouselLayoutManager extends LinearLayoutManager {
    private final CarouselRecyclerViewAdapter adapter;
    private int margin;

    public final CarouselRecyclerViewAdapter getAdapter() {
        return this.adapter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CarouselLayoutManager(Context context, CarouselRecyclerViewAdapter carouselRecyclerViewAdapter) {
        super(context, 0, false);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(carouselRecyclerViewAdapter, "adapter");
        this.adapter = carouselRecyclerViewAdapter;
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        int i;
        Intrinsics.checkNotNullParameter(layoutParams, "lp");
        try {
            i = layoutParams.getViewAdapterPosition();
        } catch (Exception unused) {
            i = -1;
        }
        if (this.adapter.getItemViewType(i) != CarouselViewType.AVATAR.ordinal()) {
            layoutParams.width = getWidth() - this.margin;
            return true;
        }
        layoutParams.width = -2;
        return true;
    }

    public final void setItemMargin$zendesk_ui_ui_android(int i) {
        this.margin = i;
    }
}
