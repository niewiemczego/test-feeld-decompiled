package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;

public class ContentSizeChangeEvent extends Event<ContentSizeChangeEvent> {
    public static final String EVENT_NAME = "topContentSizeChange";
    private final int mHeight;
    private final int mWidth;

    public String getEventName() {
        return "topContentSizeChange";
    }

    @Deprecated
    public ContentSizeChangeEvent(int i, int i2, int i3) {
        this(-1, i, i2, i3);
    }

    public ContentSizeChangeEvent(int i, int i2, int i3, int i4) {
        super(i, i2);
        this.mWidth = i3;
        this.mHeight = i4;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("width", (double) PixelUtil.toDIPFromPixel((float) this.mWidth));
        createMap.putDouble("height", (double) PixelUtil.toDIPFromPixel((float) this.mHeight));
        return createMap;
    }
}
