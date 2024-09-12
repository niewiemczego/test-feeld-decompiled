package com.swmansion.reanimated.keyboard;

import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Iterator;
import java.util.List;

public class KeyboardAnimationCallback extends WindowInsetsAnimationCompat.Callback {
    private static final int CONTENT_TYPE_MASK = WindowInsetsCompat.Type.ime();
    private final Keyboard mKeyboard;
    private final NotifyAboutKeyboardChangeFunction mNotifyAboutKeyboardChange;

    public KeyboardAnimationCallback(Keyboard keyboard, NotifyAboutKeyboardChangeFunction notifyAboutKeyboardChangeFunction) {
        super(1);
        this.mNotifyAboutKeyboardChange = notifyAboutKeyboardChangeFunction;
        this.mKeyboard = keyboard;
    }

    public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
        if (!isKeyboardAnimation(windowInsetsAnimationCompat)) {
            return boundsCompat;
        }
        this.mKeyboard.onAnimationStart();
        this.mNotifyAboutKeyboardChange.call();
        return super.onStart(windowInsetsAnimationCompat, boundsCompat);
    }

    public WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List<WindowInsetsAnimationCompat> list) {
        boolean z;
        Iterator<WindowInsetsAnimationCompat> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (isKeyboardAnimation(it.next())) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            this.mKeyboard.updateHeight(windowInsetsCompat);
            this.mNotifyAboutKeyboardChange.call();
        }
        return windowInsetsCompat;
    }

    public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        if (isKeyboardAnimation(windowInsetsAnimationCompat)) {
            this.mKeyboard.onAnimationEnd();
            this.mNotifyAboutKeyboardChange.call();
        }
    }

    private static boolean isKeyboardAnimation(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        return (windowInsetsAnimationCompat.getTypeMask() & CONTENT_TYPE_MASK) != 0;
    }
}
