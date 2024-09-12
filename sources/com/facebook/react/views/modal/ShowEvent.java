package com.facebook.react.views.modal;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

class ShowEvent extends Event<ShowEvent> {
    public static final String EVENT_NAME = "topShow";

    public String getEventName() {
        return EVENT_NAME;
    }

    @Deprecated
    protected ShowEvent(int i) {
        this(-1, i);
    }

    protected ShowEvent(int i, int i2) {
        super(i, i2);
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        return Arguments.createMap();
    }
}
