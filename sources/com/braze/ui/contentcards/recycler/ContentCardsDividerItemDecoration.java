package com.braze.ui.contentcards.recycler;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.braze.ui.R;
import com.braze.ui.contentcards.adapters.ContentCardAdapter;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0002R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/braze/ui/contentcards/recycler/ContentCardsDividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appContext", "contentCardsItemMaxWidth", "", "itemDividerHeight", "getItemOffsets", "", "itemViewOutputRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getSidePaddingValue", "parentWidth", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContentCardsDividerItemDecoration.kt */
public class ContentCardsDividerItemDecoration extends RecyclerView.ItemDecoration {
    private final Context appContext;
    private final int contentCardsItemMaxWidth;
    private final int itemDividerHeight;

    public ContentCardsDividerItemDecoration(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.appContext = applicationContext;
        this.itemDividerHeight = applicationContext.getResources().getDimensionPixelSize(R.dimen.com_braze_content_cards_divider_height);
        this.contentCardsItemMaxWidth = applicationContext.getResources().getDimensionPixelSize(R.dimen.com_braze_content_cards_max_width);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        boolean z;
        Intrinsics.checkNotNullParameter(rect, "itemViewOutputRect");
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.getItemOffsets(rect, view, recyclerView, state);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = 0;
        if (recyclerView.getAdapter() instanceof ContentCardAdapter) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.braze.ui.contentcards.adapters.ContentCardAdapter");
            z = ((ContentCardAdapter) adapter).isControlCardAtPosition(childAdapterPosition);
        } else {
            z = false;
        }
        rect.top = childAdapterPosition == 0 ? this.itemDividerHeight : 0;
        if (!z) {
            i = this.itemDividerHeight;
        }
        rect.bottom = i;
        int sidePaddingValue = getSidePaddingValue(recyclerView.getWidth());
        rect.left = sidePaddingValue;
        rect.right = sidePaddingValue;
    }

    private final int getSidePaddingValue(int i) {
        return RangesKt.coerceAtLeast((i - this.contentCardsItemMaxWidth) / 2, 0);
    }
}
