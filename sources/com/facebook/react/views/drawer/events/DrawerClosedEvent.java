package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

public class DrawerClosedEvent extends Event<DrawerClosedEvent> {
    public static final String EVENT_NAME = "topDrawerClose";

    public String getEventName() {
        return EVENT_NAME;
    }

    @Deprecated
    public DrawerClosedEvent(int i) {
        this(-1, i);
    }

    public DrawerClosedEvent(int i, int i2) {
        super(i, i2);
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        return Arguments.createMap();
    }
}
