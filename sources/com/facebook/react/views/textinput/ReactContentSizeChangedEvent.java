package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.TouchesHelper;

public class ReactContentSizeChangedEvent extends Event<ReactTextChangedEvent> {
    public static final String EVENT_NAME = "topContentSizeChange";
    private float mContentHeight;
    private float mContentWidth;

    public String getEventName() {
        return "topContentSizeChange";
    }

    @Deprecated
    public ReactContentSizeChangedEvent(int i, float f, float f2) {
        this(-1, i, f, f2);
    }

    public ReactContentSizeChangedEvent(int i, int i2, float f, float f2) {
        super(i, i2);
        this.mContentWidth = f;
        this.mContentHeight = f2;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putDouble("width", (double) this.mContentWidth);
        createMap2.putDouble("height", (double) this.mContentHeight);
        createMap.putMap("contentSize", createMap2);
        createMap.putInt(TouchesHelper.TARGET_KEY, getViewTag());
        return createMap;
    }
}
