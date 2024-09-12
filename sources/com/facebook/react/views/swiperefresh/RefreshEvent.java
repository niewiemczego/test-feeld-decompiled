package com.facebook.react.views.swiperefresh;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

public class RefreshEvent extends Event<RefreshEvent> {
    public String getEventName() {
        return "topRefresh";
    }

    @Deprecated
    protected RefreshEvent(int i) {
        this(-1, i);
    }

    protected RefreshEvent(int i, int i2) {
        super(i, i2);
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        return Arguments.createMap();
    }
}
