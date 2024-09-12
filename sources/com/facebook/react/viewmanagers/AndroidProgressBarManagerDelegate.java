package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface;

public class AndroidProgressBarManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & AndroidProgressBarManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    public AndroidProgressBarManagerDelegate(U u) {
        super(u);
    }

    public void setProperty(T t, String str, Object obj) {
        str.hashCode();
        boolean z = true;
        boolean z2 = false;
        char c = 65535;
        switch (str.hashCode()) {
            case -1001078227:
                if (str.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                    c = 0;
                    break;
                }
                break;
            case -877170387:
                if (str.equals(ViewProps.TEST_ID)) {
                    c = 1;
                    break;
                }
                break;
            case -676876213:
                if (str.equals("typeAttr")) {
                    c = 2;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    c = 3;
                    break;
                }
                break;
            case 633138363:
                if (str.equals("indeterminate")) {
                    c = 4;
                    break;
                }
                break;
            case 1118509918:
                if (str.equals("animating")) {
                    c = 5;
                    break;
                }
                break;
            case 1804741442:
                if (str.equals("styleAttr")) {
                    c = 6;
                    break;
                }
                break;
        }
        String str2 = null;
        switch (c) {
            case 0:
                ((AndroidProgressBarManagerInterface) this.mViewManager).setProgress(t, obj == null ? 0.0d : ((Double) obj).doubleValue());
                return;
            case 1:
                ((AndroidProgressBarManagerInterface) this.mViewManager).setTestID(t, obj == null ? "" : (String) obj);
                return;
            case 2:
                AndroidProgressBarManagerInterface androidProgressBarManagerInterface = (AndroidProgressBarManagerInterface) this.mViewManager;
                if (obj != null) {
                    str2 = (String) obj;
                }
                androidProgressBarManagerInterface.setTypeAttr(t, str2);
                return;
            case 3:
                ((AndroidProgressBarManagerInterface) this.mViewManager).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                return;
            case 4:
                AndroidProgressBarManagerInterface androidProgressBarManagerInterface2 = (AndroidProgressBarManagerInterface) this.mViewManager;
                if (obj != null) {
                    z2 = ((Boolean) obj).booleanValue();
                }
                androidProgressBarManagerInterface2.setIndeterminate(t, z2);
                return;
            case 5:
                AndroidProgressBarManagerInterface androidProgressBarManagerInterface3 = (AndroidProgressBarManagerInterface) this.mViewManager;
                if (obj != null) {
                    z = ((Boolean) obj).booleanValue();
                }
                androidProgressBarManagerInterface3.setAnimating(t, z);
                return;
            case 6:
                AndroidProgressBarManagerInterface androidProgressBarManagerInterface4 = (AndroidProgressBarManagerInterface) this.mViewManager;
                if (obj != null) {
                    str2 = (String) obj;
                }
                androidProgressBarManagerInterface4.setStyleAttr(t, str2);
                return;
            default:
                super.setProperty(t, str, obj);
                return;
        }
    }
}
