package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

public class DrawerOpenedEvent extends Event<DrawerOpenedEvent> {
    public static final String EVENT_NAME = "topDrawerOpen";

    public String getEventName() {
        return EVENT_NAME;
    }

    @Deprecated
    public DrawerOpenedEvent(int i) {
        this(-1, i);
    }

    public DrawerOpenedEvent(int i, int i2) {
        super(i, i2);
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        return Arguments.createMap();
    }
}
