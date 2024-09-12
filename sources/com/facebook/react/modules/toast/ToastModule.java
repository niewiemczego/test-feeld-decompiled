package com.facebook.react.modules.toast;

import android.widget.Toast;
import com.facebook.fbreact.specs.NativeToastAndroidSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "ToastAndroid")
public class ToastModule extends NativeToastAndroidSpec {
    private static final String DURATION_LONG_KEY = "LONG";
    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String GRAVITY_BOTTOM_KEY = "BOTTOM";
    private static final String GRAVITY_CENTER = "CENTER";
    private static final String GRAVITY_TOP_KEY = "TOP";
    public static final String NAME = "ToastAndroid";

    public String getName() {
        return NAME;
    }

    public ToastModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public Map<String, Object> getTypedExportedConstants() {
        HashMap newHashMap = MapBuilder.newHashMap();
        newHashMap.put(DURATION_SHORT_KEY, 0);
        newHashMap.put(DURATION_LONG_KEY, 1);
        newHashMap.put(GRAVITY_TOP_KEY, 49);
        newHashMap.put(GRAVITY_BOTTOM_KEY, 81);
        newHashMap.put(GRAVITY_CENTER, 17);
        return newHashMap;
    }

    public void show(final String str, double d) {
        final int i = (int) d;
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(ToastModule.this.getReactApplicationContext(), str, i).show();
            }
        });
    }

    public void showWithGravity(final String str, double d, double d2) {
        final int i = (int) d;
        final int i2 = (int) d2;
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Toast makeText = Toast.makeText(ToastModule.this.getReactApplicationContext(), str, i);
                makeText.setGravity(i2, 0, 0);
                makeText.show();
            }
        });
    }

    public void showWithGravityAndOffset(String str, double d, double d2, double d3, double d4) {
        int i = (int) d2;
        final int i2 = (int) d3;
        final int i3 = (int) d4;
        final String str2 = str;
        final int i4 = (int) d;
        final int i5 = i;
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Toast makeText = Toast.makeText(ToastModule.this.getReactApplicationContext(), str2, i4);
                makeText.setGravity(i5, i2, i3);
                makeText.show();
            }
        });
    }
}
