package com.swmansion.gesturehandler.core;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0014J\u0018\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0014J\b\u0010#\u001a\u00020\u001aH\u0014J\b\u0010$\u001a\u00020\u001aH\u0016J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\nJ\u000e\u0010(\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\rJ\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\nJ\u000e\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\nJ\u000e\u0010-\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0004J\b\u0010/\u001a\u00020\u001cH\u0002J\b\u00100\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/swmansion/gesturehandler/core/TapGestureHandler;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "()V", "currentMaxNumberOfPointers", "", "failDelayed", "Ljava/lang/Runnable;", "handler", "Landroid/os/Handler;", "lastX", "", "lastY", "maxDelayMs", "", "maxDeltaX", "maxDeltaY", "maxDistSq", "maxDurationMs", "minNumberOfPointers", "numberOfTaps", "offsetX", "offsetY", "startX", "startY", "tapsSoFar", "activate", "", "force", "", "endTap", "onCancel", "onHandle", "event", "Landroid/view/MotionEvent;", "sourceEvent", "onReset", "resetConfig", "setMaxDelayMs", "setMaxDist", "maxDist", "setMaxDurationMs", "setMaxDx", "deltaX", "setMaxDy", "deltaY", "setMinNumberOfPointers", "setNumberOfTaps", "shouldFail", "startTap", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TapGestureHandler.kt */
public final class TapGestureHandler extends GestureHandler<TapGestureHandler> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long DEFAULT_MAX_DELAY_MS = 200;
    private static final long DEFAULT_MAX_DURATION_MS = 500;
    private static final int DEFAULT_MIN_NUMBER_OF_POINTERS = 1;
    private static final int DEFAULT_NUMBER_OF_TAPS = 1;
    private static final float MAX_VALUE_IGNORE = Float.MIN_VALUE;
    private int currentMaxNumberOfPointers = 1;
    private final Runnable failDelayed = new TapGestureHandler$$ExternalSyntheticLambda0(this);
    private Handler handler;
    private float lastX;
    private float lastY;
    private long maxDelayMs = DEFAULT_MAX_DELAY_MS;
    private float maxDeltaX = Float.MIN_VALUE;
    private float maxDeltaY = Float.MIN_VALUE;
    private float maxDistSq = Float.MIN_VALUE;
    private long maxDurationMs = 500;
    private int minNumberOfPointers = 1;
    private int numberOfTaps = 1;
    private float offsetX;
    private float offsetY;
    private float startX;
    private float startY;
    private int tapsSoFar;

    public TapGestureHandler() {
        setShouldCancelWhenOutside(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: failDelayed$lambda-0  reason: not valid java name */
    public static final void m636failDelayed$lambda0(TapGestureHandler tapGestureHandler) {
        Intrinsics.checkNotNullParameter(tapGestureHandler, "this$0");
        tapGestureHandler.fail();
    }

    public void resetConfig() {
        super.resetConfig();
        this.maxDeltaX = Float.MIN_VALUE;
        this.maxDeltaY = Float.MIN_VALUE;
        this.maxDistSq = Float.MIN_VALUE;
        this.maxDurationMs = 500;
        this.maxDelayMs = DEFAULT_MAX_DELAY_MS;
        this.numberOfTaps = 1;
        this.minNumberOfPointers = 1;
    }

    public final TapGestureHandler setNumberOfTaps(int i) {
        TapGestureHandler tapGestureHandler = this;
        this.numberOfTaps = i;
        return this;
    }

    public final TapGestureHandler setMaxDelayMs(long j) {
        TapGestureHandler tapGestureHandler = this;
        this.maxDelayMs = j;
        return this;
    }

    public final TapGestureHandler setMaxDurationMs(long j) {
        TapGestureHandler tapGestureHandler = this;
        this.maxDurationMs = j;
        return this;
    }

    public final TapGestureHandler setMaxDx(float f) {
        TapGestureHandler tapGestureHandler = this;
        this.maxDeltaX = f;
        return this;
    }

    public final TapGestureHandler setMaxDy(float f) {
        TapGestureHandler tapGestureHandler = this;
        this.maxDeltaY = f;
        return this;
    }

    public final TapGestureHandler setMaxDist(float f) {
        TapGestureHandler tapGestureHandler = this;
        this.maxDistSq = f * f;
        return this;
    }

    public final TapGestureHandler setMinNumberOfPointers(int i) {
        TapGestureHandler tapGestureHandler = this;
        this.minNumberOfPointers = i;
        return this;
    }

    private final void startTap() {
        Handler handler2 = this.handler;
        if (handler2 == null) {
            this.handler = new Handler(Looper.getMainLooper());
        } else {
            Intrinsics.checkNotNull(handler2);
            handler2.removeCallbacksAndMessages((Object) null);
        }
        Handler handler3 = this.handler;
        Intrinsics.checkNotNull(handler3);
        handler3.postDelayed(this.failDelayed, this.maxDurationMs);
    }

    private final void endTap() {
        Handler handler2 = this.handler;
        if (handler2 == null) {
            this.handler = new Handler(Looper.getMainLooper());
        } else {
            Intrinsics.checkNotNull(handler2);
            handler2.removeCallbacksAndMessages((Object) null);
        }
        int i = this.tapsSoFar + 1;
        this.tapsSoFar = i;
        if (i != this.numberOfTaps || this.currentMaxNumberOfPointers < this.minNumberOfPointers) {
            Handler handler3 = this.handler;
            Intrinsics.checkNotNull(handler3);
            handler3.postDelayed(this.failDelayed, this.maxDelayMs);
            return;
        }
        activate();
    }

    private final boolean shouldFail() {
        float f = (this.lastX - this.startX) + this.offsetX;
        if (!(this.maxDeltaX == Float.MIN_VALUE) && Math.abs(f) > this.maxDeltaX) {
            return true;
        }
        float f2 = (this.lastY - this.startY) + this.offsetY;
        if (!(this.maxDeltaY == Float.MIN_VALUE) && Math.abs(f2) > this.maxDeltaY) {
            return true;
        }
        float f3 = (f2 * f2) + (f * f);
        float f4 = this.maxDistSq;
        if ((f4 == Float.MIN_VALUE) || f3 <= f4) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onHandle(MotionEvent motionEvent, MotionEvent motionEvent2) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        Intrinsics.checkNotNullParameter(motionEvent2, "sourceEvent");
        int state = getState();
        int actionMasked = motionEvent2.getActionMasked();
        if (state == 0) {
            this.offsetX = 0.0f;
            this.offsetY = 0.0f;
            this.startX = GestureUtils.INSTANCE.getLastPointerX(motionEvent2, true);
            this.startY = GestureUtils.INSTANCE.getLastPointerY(motionEvent2, true);
        }
        if (actionMasked == 5 || actionMasked == 6) {
            this.offsetX += this.lastX - this.startX;
            this.offsetY += this.lastY - this.startY;
            this.lastX = GestureUtils.INSTANCE.getLastPointerX(motionEvent2, true);
            float lastPointerY = GestureUtils.INSTANCE.getLastPointerY(motionEvent2, true);
            this.lastY = lastPointerY;
            this.startX = this.lastX;
            this.startY = lastPointerY;
        } else {
            this.lastX = GestureUtils.INSTANCE.getLastPointerX(motionEvent2, true);
            this.lastY = GestureUtils.INSTANCE.getLastPointerY(motionEvent2, true);
        }
        if (this.currentMaxNumberOfPointers < motionEvent2.getPointerCount()) {
            this.currentMaxNumberOfPointers = motionEvent2.getPointerCount();
        }
        if (shouldFail()) {
            fail();
        } else if (state == 0) {
            if (actionMasked == 0) {
                begin();
            }
            startTap();
        } else if (state != 2) {
        } else {
            if (actionMasked == 0) {
                startTap();
            } else if (actionMasked == 1) {
                endTap();
            }
        }
    }

    public void activate(boolean z) {
        super.activate(z);
        end();
    }

    /* access modifiers changed from: protected */
    public void onCancel() {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        this.tapsSoFar = 0;
        this.currentMaxNumberOfPointers = 0;
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/swmansion/gesturehandler/core/TapGestureHandler$Companion;", "", "()V", "DEFAULT_MAX_DELAY_MS", "", "DEFAULT_MAX_DURATION_MS", "DEFAULT_MIN_NUMBER_OF_POINTERS", "", "DEFAULT_NUMBER_OF_TAPS", "MAX_VALUE_IGNORE", "", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TapGestureHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
