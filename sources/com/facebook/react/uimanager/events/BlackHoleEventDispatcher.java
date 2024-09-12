package com.facebook.react.uimanager.events;

import com.facebook.common.logging.FLog;

public class BlackHoleEventDispatcher implements EventDispatcher {
    private static final EventDispatcher sEventDispatcher = new BlackHoleEventDispatcher();

    public void addBatchEventDispatchedListener(BatchEventDispatchedListener batchEventDispatchedListener) {
    }

    public void addListener(EventDispatcherListener eventDispatcherListener) {
    }

    public void dispatchAllEvents() {
    }

    public void onCatalystInstanceDestroyed() {
    }

    public void registerEventEmitter(int i, RCTEventEmitter rCTEventEmitter) {
    }

    public void registerEventEmitter(int i, RCTModernEventEmitter rCTModernEventEmitter) {
    }

    public void removeBatchEventDispatchedListener(BatchEventDispatchedListener batchEventDispatchedListener) {
    }

    public void removeListener(EventDispatcherListener eventDispatcherListener) {
    }

    public void unregisterEventEmitter(int i) {
    }

    public static EventDispatcher get() {
        return sEventDispatcher;
    }

    private BlackHoleEventDispatcher() {
    }

    public void dispatchEvent(Event event) {
        FLog.d(getClass().getSimpleName(), "Trying to emit event to JS, but the React instance isn't ready. Event: " + event.getEventName());
    }
}
