package com.swmansion.reanimated;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.concurrent.atomic.AtomicBoolean;

public class AndroidUIScheduler {
    /* access modifiers changed from: private */
    public final AtomicBoolean mActive = new AtomicBoolean(true);
    private final ReactApplicationContext mContext;
    private final HybridData mHybridData = initHybrid();
    /* access modifiers changed from: private */
    public final Runnable mUIThreadRunnable = new Runnable() {
        public void run() {
            if (AndroidUIScheduler.this.mActive.get()) {
                AndroidUIScheduler.this.triggerUI();
            }
        }
    };

    private native HybridData initHybrid();

    public native void triggerUI();

    public AndroidUIScheduler(ReactApplicationContext reactApplicationContext) {
        this.mContext = reactApplicationContext;
    }

    private void scheduleTriggerOnUI() {
        UiThreadUtil.runOnUiThread(new GuardedRunnable(this.mContext.getExceptionHandler()) {
            public void runGuarded() {
                AndroidUIScheduler.this.mUIThreadRunnable.run();
            }
        });
    }

    public void deactivate() {
        this.mActive.set(false);
    }
}
