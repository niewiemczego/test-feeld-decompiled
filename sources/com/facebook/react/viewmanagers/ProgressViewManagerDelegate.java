package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.ProgressViewManagerInterface;

public class ProgressViewManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & ProgressViewManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public ProgressViewManagerDelegate(U u) {
        super(u);
    }

    public void setProperty(T t, String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1948954017:
                if (str.equals("progressViewStyle")) {
                    c = 0;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                    c = 1;
                    break;
                }
                break;
            case -287374307:
                if (str.equals("trackTintColor")) {
                    c = 2;
                    break;
                }
                break;
            case 760630062:
                if (str.equals("progressImage")) {
                    c = 3;
                    break;
                }
                break;
            case 962728315:
                if (str.equals("progressTintColor")) {
                    c = 4;
                    break;
                }
                break;
            case 1139400400:
                if (str.equals("trackImage")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                ((ProgressViewManagerInterface) this.mViewManager).setProgressViewStyle(t, (String) obj);
                return;
            case 1:
                ((ProgressViewManagerInterface) this.mViewManager).setProgress(t, obj == null ? 0.0f : ((Double) obj).floatValue());
                return;
            case 2:
                ((ProgressViewManagerInterface) this.mViewManager).setTrackTintColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                return;
            case 3:
                ((ProgressViewManagerInterface) this.mViewManager).setProgressImage(t, (ReadableMap) obj);
                return;
            case 4:
                ((ProgressViewManagerInterface) this.mViewManager).setProgressTintColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                return;
            case 5:
                ((ProgressViewManagerInterface) this.mViewManager).setTrackImage(t, (ReadableMap) obj);
                return;
            default:
                super.setProperty(t, str, obj);
                return;
        }
    }
}
