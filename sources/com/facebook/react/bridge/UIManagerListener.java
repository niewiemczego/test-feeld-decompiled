package com.facebook.react.bridge;

public interface UIManagerListener {
    void didDispatchMountItems(UIManager uIManager);

    void didScheduleMountItems(UIManager uIManager);

    void willDispatchViewUpdates(UIManager uIManager);
}
