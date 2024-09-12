package zendesk.ui.android.conversation.carousel;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"zendesk/ui/android/conversation/carousel/CarouselCellView$setUpNextAndPreviousButton$3", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CarouselCellView.kt */
public final class CarouselCellView$setUpNextAndPreviousButton$3 extends RecyclerView.OnScrollListener {
    final /* synthetic */ CarouselCellView this$0;

    CarouselCellView$setUpNextAndPreviousButton$3(CarouselCellView carouselCellView) {
        this.this$0 = carouselCellView;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        int i3 = 0;
        boolean z = this.this$0.layoutManager.findFirstCompletelyVisibleItemPosition() == 0 || this.this$0.layoutManager.findFirstCompletelyVisibleItemPosition() == 1;
        boolean z2 = this.this$0.layoutManager.findLastCompletelyVisibleItemPosition() == this.this$0.adapter.getItemCount() - 1;
        this.this$0.getPrevButton().setVisibility(z ^ true ? 0 : 8);
        View access$getNextButton = this.this$0.getNextButton();
        if (!(true ^ z2)) {
            i3 = 8;
        }
        access$getNextButton.setVisibility(i3);
    }
}
