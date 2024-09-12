package com.swmansion.reanimated.keyboard;

import com.facebook.react.bridge.ReactApplicationContext;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

public class KeyboardAnimationManager {
    private final Keyboard mKeyboard;
    private final ConcurrentHashMap<Integer, KeyboardWorkletWrapper> mListeners = new ConcurrentHashMap<>();
    private int mNextListenerId = 0;
    private final WindowsInsetsManager mWindowsInsetsManager;

    public KeyboardAnimationManager(WeakReference<ReactApplicationContext> weakReference) {
        Keyboard keyboard = new Keyboard();
        this.mKeyboard = keyboard;
        this.mWindowsInsetsManager = new WindowsInsetsManager(weakReference, keyboard, new KeyboardAnimationManager$$ExternalSyntheticLambda0(this));
    }

    public int subscribeForKeyboardUpdates(KeyboardWorkletWrapper keyboardWorkletWrapper, boolean z) {
        int i = this.mNextListenerId;
        this.mNextListenerId = i + 1;
        if (this.mListeners.isEmpty()) {
            this.mWindowsInsetsManager.startObservingChanges(new KeyboardAnimationCallback(this.mKeyboard, new KeyboardAnimationManager$$ExternalSyntheticLambda0(this)), z);
        }
        this.mListeners.put(Integer.valueOf(i), keyboardWorkletWrapper);
        return i;
    }

    public void unsubscribeFromKeyboardUpdates(int i) {
        this.mListeners.remove(Integer.valueOf(i));
        if (this.mListeners.isEmpty()) {
            this.mWindowsInsetsManager.stopObservingChanges();
        }
    }

    public void notifyAboutKeyboardChange() {
        for (KeyboardWorkletWrapper invoke : this.mListeners.values()) {
            invoke.invoke(this.mKeyboard.getState().asInt(), this.mKeyboard.getHeight());
        }
    }
}
