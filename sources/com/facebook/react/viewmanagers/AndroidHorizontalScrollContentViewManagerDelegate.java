package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.viewmanagers.AndroidHorizontalScrollContentViewManagerInterface;

public class AndroidHorizontalScrollContentViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & AndroidHorizontalScrollContentViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public AndroidHorizontalScrollContentViewManagerDelegate(U u) {
        super(u);
    }

    public void setProperty(T t, String str, Object obj) {
        str.hashCode();
        if (!str.equals(ReactClippingViewGroupHelper.PROP_REMOVE_CLIPPED_SUBVIEWS)) {
            super.setProperty(t, str, obj);
        } else {
            ((AndroidHorizontalScrollContentViewManagerInterface) this.mViewManager).setRemoveClippedSubviews(t, obj == null ? false : ((Boolean) obj).booleanValue());
        }
    }
}
