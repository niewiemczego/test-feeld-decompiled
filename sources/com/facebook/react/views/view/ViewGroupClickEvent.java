package com.facebook.react.views.view;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

public class ViewGroupClickEvent extends Event<ViewGroupClickEvent> {
    private static final String EVENT_NAME = "topClick";

    public boolean canCoalesce() {
        return false;
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    @Deprecated
    public ViewGroupClickEvent(int i) {
        this(-1, i);
    }

    public ViewGroupClickEvent(int i, int i2) {
        super(i, i2);
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        return Arguments.createMap();
    }
}
