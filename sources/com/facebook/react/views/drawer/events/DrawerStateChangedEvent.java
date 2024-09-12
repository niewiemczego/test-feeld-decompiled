package com.facebook.react.views.drawer.events;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

public class DrawerStateChangedEvent extends Event<DrawerStateChangedEvent> {
    public static final String EVENT_NAME = "topDrawerStateChanged";
    private final int mDrawerState;

    public String getEventName() {
        return EVENT_NAME;
    }

    @Deprecated
    public DrawerStateChangedEvent(int i, int i2) {
        this(-1, i, i2);
    }

    public DrawerStateChangedEvent(int i, int i2, int i3) {
        super(i, i2);
        this.mDrawerState = i3;
    }

    public int getDrawerState() {
        return this.mDrawerState;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("drawerState", (double) getDrawerState());
        return createMap;
    }
}
