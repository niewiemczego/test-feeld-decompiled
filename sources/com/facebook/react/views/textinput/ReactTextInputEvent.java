package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.TouchesHelper;

public class ReactTextInputEvent extends Event<ReactTextInputEvent> {
    public static final String EVENT_NAME = "topTextInput";
    private String mPreviousText;
    private int mRangeEnd;
    private int mRangeStart;
    private String mText;

    public boolean canCoalesce() {
        return false;
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    @Deprecated
    public ReactTextInputEvent(int i, String str, String str2, int i2, int i3) {
        this(-1, i, str, str2, i2, i3);
    }

    public ReactTextInputEvent(int i, int i2, String str, String str2, int i3, int i4) {
        super(i, i2);
        this.mText = str;
        this.mPreviousText = str2;
        this.mRangeStart = i3;
        this.mRangeEnd = i4;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putDouble("start", (double) this.mRangeStart);
        createMap2.putDouble("end", (double) this.mRangeEnd);
        createMap.putString("text", this.mText);
        createMap.putString("previousText", this.mPreviousText);
        createMap.putMap(SessionDescription.ATTR_RANGE, createMap2);
        createMap.putInt(TouchesHelper.TARGET_KEY, getViewTag());
        return createMap;
    }
}
