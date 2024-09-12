package com.facebook.react.views.textinput;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.TouchesHelper;

class ReactTextInputSubmitEditingEvent extends Event<ReactTextInputSubmitEditingEvent> {
    private static final String EVENT_NAME = "topSubmitEditing";
    private String mText;

    public boolean canCoalesce() {
        return false;
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    @Deprecated
    public ReactTextInputSubmitEditingEvent(int i, String str) {
        this(-1, i, str);
    }

    public ReactTextInputSubmitEditingEvent(int i, int i2, String str) {
        super(i, i2);
        this.mText = str;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(TouchesHelper.TARGET_KEY, getViewTag());
        createMap.putString("text", this.mText);
        return createMap;
    }
}
