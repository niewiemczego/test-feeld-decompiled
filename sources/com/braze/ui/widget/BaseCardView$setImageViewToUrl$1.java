package com.braze.ui.widget;

import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/braze/ui/widget/BaseCardView$setImageViewToUrl$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BaseCardView.kt */
public final class BaseCardView$setImageViewToUrl$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ ImageView $imageView;
    final /* synthetic */ float $placeholderAspectRatio;

    BaseCardView$setImageViewToUrl$1(ImageView imageView, float f) {
        this.$imageView = imageView;
        this.$placeholderAspectRatio = f;
    }

    public boolean onPreDraw() {
        this.$imageView.getViewTreeObserver().removeOnPreDrawListener(this);
        int width = this.$imageView.getWidth();
        this.$imageView.setLayoutParams(new RelativeLayout.LayoutParams(width, (int) (((float) width) / this.$placeholderAspectRatio)));
        return true;
    }
}
