package com.facebook.react.views.scroll;

import android.content.Context;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.views.view.ReactViewGroup;

public class ReactHorizontalScrollContainerView extends ReactViewGroup {
    private int mCurrentWidth = 0;
    private int mLayoutDirection;

    public ReactHorizontalScrollContainerView(Context context) {
        super(context);
        this.mLayoutDirection = I18nUtil.getInstance().isRTL(context) ? 1 : 0;
    }

    public void setRemoveClippedSubviews(boolean z) {
        if (this.mLayoutDirection == 1) {
            super.setRemoveClippedSubviews(false);
        } else {
            super.setRemoveClippedSubviews(z);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mLayoutDirection == 1) {
            setLeft(0);
            setRight((i3 - i) + 0);
            if (this.mCurrentWidth != getWidth()) {
                ReactHorizontalScrollView reactHorizontalScrollView = (ReactHorizontalScrollView) getParent();
                reactHorizontalScrollView.scrollTo(((reactHorizontalScrollView.getScrollX() + getWidth()) - this.mCurrentWidth) - reactHorizontalScrollView.getWidth(), reactHorizontalScrollView.getScrollY());
            }
        }
        this.mCurrentWidth = getWidth();
    }
}
