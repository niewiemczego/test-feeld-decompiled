package com.facebook.react.uimanager;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.TouchesHelper;
import io.sentry.protocol.ViewHierarchyNode;

public class OnLayoutEvent extends Event<OnLayoutEvent> {
    private static final Pools.SynchronizedPool<OnLayoutEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(20);
    private int mHeight;
    private int mWidth;
    private int mX;
    private int mY;

    public String getEventName() {
        return "topLayout";
    }

    @Deprecated
    public static OnLayoutEvent obtain(int i, int i2, int i3, int i4, int i5) {
        return obtain(-1, i, i2, i3, i4, i5);
    }

    public static OnLayoutEvent obtain(int i, int i2, int i3, int i4, int i5, int i6) {
        OnLayoutEvent acquire = EVENTS_POOL.acquire();
        if (acquire == null) {
            acquire = new OnLayoutEvent();
        }
        acquire.init(i, i2, i3, i4, i5, i6);
        return acquire;
    }

    public void onDispose() {
        EVENTS_POOL.release(this);
    }

    private OnLayoutEvent() {
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void init(int i, int i2, int i3, int i4, int i5) {
        init(-1, i, i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    public void init(int i, int i2, int i3, int i4, int i5, int i6) {
        super.init(i, i2);
        this.mX = i3;
        this.mY = i4;
        this.mWidth = i5;
        this.mHeight = i6;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble(ViewHierarchyNode.JsonKeys.X, (double) PixelUtil.toDIPFromPixel((float) this.mX));
        createMap.putDouble(ViewHierarchyNode.JsonKeys.Y, (double) PixelUtil.toDIPFromPixel((float) this.mY));
        createMap.putDouble("width", (double) PixelUtil.toDIPFromPixel((float) this.mWidth));
        createMap.putDouble("height", (double) PixelUtil.toDIPFromPixel((float) this.mHeight));
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putMap(TtmlNode.TAG_LAYOUT, createMap);
        createMap2.putInt(TouchesHelper.TARGET_KEY, getViewTag());
        return createMap2;
    }
}
