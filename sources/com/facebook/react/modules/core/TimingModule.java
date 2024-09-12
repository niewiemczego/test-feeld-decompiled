package com.facebook.react.modules.core;

import com.facebook.fbreact.specs.NativeTimingSpec;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskEventListener;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "Timing")
public final class TimingModule extends NativeTimingSpec implements LifecycleEventListener, HeadlessJsTaskEventListener {
    public static final String NAME = "Timing";
    private final JavaTimerManager mJavaTimerManager;

    public String getName() {
        return NAME;
    }

    public class BridgeTimerExecutor implements JavaScriptTimerExecutor {
        public BridgeTimerExecutor() {
        }

        public void callTimers(WritableArray writableArray) {
            ReactApplicationContext access$000 = TimingModule.this.getReactApplicationContextIfActiveOrWarn();
            if (access$000 != null) {
                ((JSTimers) access$000.getJSModule(JSTimers.class)).callTimers(writableArray);
            }
        }

        public void callIdleCallbacks(double d) {
            ReactApplicationContext access$100 = TimingModule.this.getReactApplicationContextIfActiveOrWarn();
            if (access$100 != null) {
                ((JSTimers) access$100.getJSModule(JSTimers.class)).callIdleCallbacks(d);
            }
        }

        public void emitTimeDriftWarning(String str) {
            ReactApplicationContext access$200 = TimingModule.this.getReactApplicationContextIfActiveOrWarn();
            if (access$200 != null) {
                ((JSTimers) access$200.getJSModule(JSTimers.class)).emitTimeDriftWarning(str);
            }
        }
    }

    public TimingModule(ReactApplicationContext reactApplicationContext, DevSupportManager devSupportManager) {
        super(reactApplicationContext);
        this.mJavaTimerManager = new JavaTimerManager(reactApplicationContext, new BridgeTimerExecutor(), ReactChoreographer.getInstance(), devSupportManager);
    }

    public void initialize() {
        getReactApplicationContext().addLifecycleEventListener(this);
        HeadlessJsTaskContext.getInstance(getReactApplicationContext()).addTaskEventListener(this);
    }

    public void createTimer(double d, double d2, double d3, boolean z) {
        this.mJavaTimerManager.createAndMaybeCallTimer((int) d, (int) d2, d3, z);
    }

    public void deleteTimer(double d) {
        this.mJavaTimerManager.deleteTimer((int) d);
    }

    public void setSendIdleEvents(boolean z) {
        this.mJavaTimerManager.setSendIdleEvents(z);
    }

    public void onHostResume() {
        this.mJavaTimerManager.onHostResume();
    }

    public void onHostPause() {
        this.mJavaTimerManager.onHostPause();
    }

    public void onHostDestroy() {
        this.mJavaTimerManager.onHostDestroy();
    }

    public void onHeadlessJsTaskStart(int i) {
        this.mJavaTimerManager.onHeadlessJsTaskStart(i);
    }

    public void onHeadlessJsTaskFinish(int i) {
        this.mJavaTimerManager.onHeadlessJsTaskFinish(i);
    }

    public void invalidate() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        HeadlessJsTaskContext.getInstance(reactApplicationContext).removeTaskEventListener(this);
        this.mJavaTimerManager.onInstanceDestroy();
        reactApplicationContext.removeLifecycleEventListener(this);
    }

    public boolean hasActiveTimersInRange(long j) {
        return this.mJavaTimerManager.hasActiveTimersInRange(j);
    }
}
