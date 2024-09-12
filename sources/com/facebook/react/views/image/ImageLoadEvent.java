package com.facebook.react.views.image;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

public class ImageLoadEvent extends Event<ImageLoadEvent> {
    public static final int ON_ERROR = 1;
    public static final int ON_LOAD = 2;
    public static final int ON_LOAD_END = 3;
    public static final int ON_LOAD_START = 4;
    public static final int ON_PROGRESS = 5;
    private final String mErrorMessage;
    private final int mEventType;
    private final int mHeight;
    private final int mLoaded;
    private final String mSourceUri;
    private final int mTotal;
    private final int mWidth;

    @Deprecated
    public static final ImageLoadEvent createLoadStartEvent(int i) {
        return createLoadStartEvent(-1, i);
    }

    @Deprecated
    public static final ImageLoadEvent createProgressEvent(int i, String str, int i2, int i3) {
        return createProgressEvent(-1, i, str, i2, i3);
    }

    @Deprecated
    public static final ImageLoadEvent createLoadEvent(int i, String str, int i2, int i3) {
        return createLoadEvent(-1, i, str, i2, i3);
    }

    @Deprecated
    public static final ImageLoadEvent createErrorEvent(int i, Throwable th) {
        return createErrorEvent(-1, i, th);
    }

    @Deprecated
    public static final ImageLoadEvent createLoadEndEvent(int i) {
        return createLoadEndEvent(-1, i);
    }

    public static final ImageLoadEvent createLoadStartEvent(int i, int i2) {
        return new ImageLoadEvent(i, i2, 4);
    }

    public static final ImageLoadEvent createProgressEvent(int i, int i2, String str, int i3, int i4) {
        return new ImageLoadEvent(i, i2, 5, (String) null, str, 0, 0, i3, i4);
    }

    public static final ImageLoadEvent createLoadEvent(int i, int i2, String str, int i3, int i4) {
        return new ImageLoadEvent(i, i2, 2, (String) null, str, i3, i4, 0, 0);
    }

    public static final ImageLoadEvent createErrorEvent(int i, int i2, Throwable th) {
        return new ImageLoadEvent(i, i2, 1, th.getMessage(), (String) null, 0, 0, 0, 0);
    }

    public static final ImageLoadEvent createLoadEndEvent(int i, int i2) {
        return new ImageLoadEvent(i, i2, 3);
    }

    private ImageLoadEvent(int i, int i2, int i3) {
        this(i, i2, i3, (String) null, (String) null, 0, 0, 0, 0);
    }

    private ImageLoadEvent(int i, int i2, int i3, String str, String str2, int i4, int i5, int i6, int i7) {
        super(i, i2);
        this.mEventType = i3;
        this.mErrorMessage = str;
        this.mSourceUri = str2;
        this.mWidth = i4;
        this.mHeight = i5;
        this.mLoaded = i6;
        this.mTotal = i7;
    }

    public static String eventNameForType(int i) {
        if (i == 1) {
            return "topError";
        }
        if (i == 2) {
            return "topLoad";
        }
        if (i == 3) {
            return "topLoadEnd";
        }
        if (i == 4) {
            return "topLoadStart";
        }
        if (i == 5) {
            return "topProgress";
        }
        throw new IllegalStateException("Invalid image event: " + Integer.toString(i));
    }

    public String getEventName() {
        return eventNameForType(this.mEventType);
    }

    public short getCoalescingKey() {
        return (short) this.mEventType;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        int i = this.mEventType;
        if (i == 1) {
            createMap.putString("error", this.mErrorMessage);
        } else if (i == 2) {
            createMap.putMap("source", createEventDataSource());
        } else if (i == 5) {
            createMap.putInt("loaded", this.mLoaded);
            createMap.putInt("total", this.mTotal);
        }
        return createMap;
    }

    private WritableMap createEventDataSource() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("uri", this.mSourceUri);
        createMap.putDouble("width", (double) this.mWidth);
        createMap.putDouble("height", (double) this.mHeight);
        return createMap;
    }
}
