package com.facebook.react.viewmanagers;

import android.view.View;
import com.BV.LinearGradient.LinearGradientManager;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface;

public class AndroidSwipeRefreshLayoutManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & AndroidSwipeRefreshLayoutManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public AndroidSwipeRefreshLayoutManagerDelegate(U u) {
        super(u);
    }

    public void setProperty(T t, String str, Object obj) {
        str.hashCode();
        boolean z = true;
        boolean z2 = false;
        char c = 65535;
        switch (str.hashCode()) {
            case -1609594047:
                if (str.equals("enabled")) {
                    c = 0;
                    break;
                }
                break;
            case -1354842768:
                if (str.equals(LinearGradientManager.PROP_COLORS)) {
                    c = 1;
                    break;
                }
                break;
            case -885150488:
                if (str.equals("progressBackgroundColor")) {
                    c = 2;
                    break;
                }
                break;
            case -416037467:
                if (str.equals("progressViewOffset")) {
                    c = 3;
                    break;
                }
                break;
            case -321826009:
                if (str.equals("refreshing")) {
                    c = 4;
                    break;
                }
                break;
            case 3530753:
                if (str.equals("size")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                AndroidSwipeRefreshLayoutManagerInterface androidSwipeRefreshLayoutManagerInterface = (AndroidSwipeRefreshLayoutManagerInterface) this.mViewManager;
                if (obj != null) {
                    z = ((Boolean) obj).booleanValue();
                }
                androidSwipeRefreshLayoutManagerInterface.setEnabled(t, z);
                return;
            case 1:
                ((AndroidSwipeRefreshLayoutManagerInterface) this.mViewManager).setColors(t, (ReadableArray) obj);
                return;
            case 2:
                ((AndroidSwipeRefreshLayoutManagerInterface) this.mViewManager).setProgressBackgroundColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                return;
            case 3:
                ((AndroidSwipeRefreshLayoutManagerInterface) this.mViewManager).setProgressViewOffset(t, obj == null ? 0.0f : ((Double) obj).floatValue());
                return;
            case 4:
                AndroidSwipeRefreshLayoutManagerInterface androidSwipeRefreshLayoutManagerInterface2 = (AndroidSwipeRefreshLayoutManagerInterface) this.mViewManager;
                if (obj != null) {
                    z2 = ((Boolean) obj).booleanValue();
                }
                androidSwipeRefreshLayoutManagerInterface2.setRefreshing(t, z2);
                return;
            case 5:
                ((AndroidSwipeRefreshLayoutManagerInterface) this.mViewManager).setSize(t, (String) obj);
                return;
            default:
                super.setProperty(t, str, obj);
                return;
        }
    }

    public void receiveCommand(T t, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("setNativeRefreshing")) {
            ((AndroidSwipeRefreshLayoutManagerInterface) this.mViewManager).setNativeRefreshing(t, readableArray.getBoolean(0));
        }
    }
}
