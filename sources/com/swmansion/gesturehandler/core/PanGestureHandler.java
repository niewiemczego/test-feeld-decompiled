package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 P2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001PB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u000fH\u0016J\b\u00103\u001a\u000201H\u0014J\u0018\u00104\u001a\u0002012\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000206H\u0014J\b\u00108\u001a\u000201H\u0014J\b\u00109\u001a\u000201H\u0016J\b\u0010:\u001a\u000201H\u0016J\u000e\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0006J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010>\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010?\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010@\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\nJ\u000e\u0010A\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010B\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010C\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010D\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\nJ\u000e\u0010E\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010F\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010G\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\nJ\u000e\u0010I\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001aJ\u000e\u0010J\u001a\u00020\u00002\u0006\u0010K\u001a\u00020\nJ\u000e\u0010L\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\nJ\u000e\u0010M\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\nJ\b\u0010N\u001a\u00020\u000fH\u0002J\b\u0010O\u001a\u00020\u000fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010$\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b(\u0010&R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010,\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010&R\u001e\u0010.\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u0010&¨\u0006Q"}, d2 = {"Lcom/swmansion/gesturehandler/core/PanGestureHandler;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "activateAfterLongPress", "", "activateDelayed", "Ljava/lang/Runnable;", "activeOffsetXEnd", "", "activeOffsetXStart", "activeOffsetYEnd", "activeOffsetYStart", "averageTouches", "", "defaultMinDistSq", "failOffsetXEnd", "failOffsetXStart", "failOffsetYEnd", "failOffsetYStart", "handler", "Landroid/os/Handler;", "lastX", "lastY", "maxPointers", "", "minDistSq", "minPointers", "minVelocitySq", "minVelocityX", "minVelocityY", "offsetX", "offsetY", "startX", "startY", "translationX", "getTranslationX", "()F", "translationY", "getTranslationY", "velocityTracker", "Landroid/view/VelocityTracker;", "<set-?>", "velocityX", "getVelocityX", "velocityY", "getVelocityY", "activate", "", "force", "onCancel", "onHandle", "event", "Landroid/view/MotionEvent;", "sourceEvent", "onReset", "resetConfig", "resetProgress", "setActivateAfterLongPress", "time", "setActiveOffsetXEnd", "setActiveOffsetXStart", "setActiveOffsetYEnd", "setActiveOffsetYStart", "setAverageTouches", "setFailOffsetXEnd", "setFailOffsetXStart", "setFailOffsetYEnd", "setFailOffsetYStart", "setMaxPointers", "setMinDist", "minDist", "setMinPointers", "setMinVelocity", "minVelocity", "setMinVelocityX", "setMinVelocityY", "shouldActivate", "shouldFail", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PanGestureHandler.kt */
public final class PanGestureHandler extends GestureHandler<PanGestureHandler> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long DEFAULT_ACTIVATE_AFTER_LONG_PRESS = 0;
    private static final int DEFAULT_MAX_POINTERS = 10;
    private static final int DEFAULT_MIN_POINTERS = 1;
    private static final float MAX_VALUE_IGNORE = Float.MIN_VALUE;
    private static final float MIN_VALUE_IGNORE = Float.MAX_VALUE;
    private long activateAfterLongPress;
    private final Runnable activateDelayed = new PanGestureHandler$$ExternalSyntheticLambda0(this);
    private float activeOffsetXEnd = Float.MIN_VALUE;
    private float activeOffsetXStart = Float.MAX_VALUE;
    private float activeOffsetYEnd = Float.MIN_VALUE;
    private float activeOffsetYStart = Float.MAX_VALUE;
    private boolean averageTouches;
    private final float defaultMinDistSq;
    private float failOffsetXEnd = Float.MAX_VALUE;
    private float failOffsetXStart = Float.MIN_VALUE;
    private float failOffsetYEnd = Float.MAX_VALUE;
    private float failOffsetYStart = Float.MIN_VALUE;
    private Handler handler;
    private float lastX;
    private float lastY;
    private int maxPointers = 10;
    private float minDistSq = Float.MIN_VALUE;
    private int minPointers = 1;
    private float minVelocitySq = Float.MAX_VALUE;
    private float minVelocityX = Float.MAX_VALUE;
    private float minVelocityY = Float.MAX_VALUE;
    private float offsetX;
    private float offsetY;
    private float startX;
    private float startY;
    private VelocityTracker velocityTracker;
    private float velocityX;
    private float velocityY;

    public PanGestureHandler(Context context) {
        Intrinsics.checkNotNull(context);
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        float f = (float) (scaledTouchSlop * scaledTouchSlop);
        this.defaultMinDistSq = f;
        this.minDistSq = f;
    }

    public final float getVelocityX() {
        return this.velocityX;
    }

    public final float getVelocityY() {
        return this.velocityY;
    }

    public final float getTranslationX() {
        return (this.lastX - this.startX) + this.offsetX;
    }

    public final float getTranslationY() {
        return (this.lastY - this.startY) + this.offsetY;
    }

    /* access modifiers changed from: private */
    /* renamed from: activateDelayed$lambda-0  reason: not valid java name */
    public static final void m634activateDelayed$lambda0(PanGestureHandler panGestureHandler) {
        Intrinsics.checkNotNullParameter(panGestureHandler, "this$0");
        panGestureHandler.activate();
    }

    public void resetConfig() {
        super.resetConfig();
        this.activeOffsetXStart = Float.MAX_VALUE;
        this.activeOffsetXEnd = Float.MIN_VALUE;
        this.failOffsetXStart = Float.MIN_VALUE;
        this.failOffsetXEnd = Float.MAX_VALUE;
        this.activeOffsetYStart = Float.MAX_VALUE;
        this.activeOffsetYEnd = Float.MIN_VALUE;
        this.failOffsetYStart = Float.MIN_VALUE;
        this.failOffsetYEnd = Float.MAX_VALUE;
        this.minVelocityX = Float.MAX_VALUE;
        this.minVelocityY = Float.MAX_VALUE;
        this.minVelocitySq = Float.MAX_VALUE;
        this.minDistSq = this.defaultMinDistSq;
        this.minPointers = 1;
        this.maxPointers = 10;
        this.activateAfterLongPress = 0;
        this.averageTouches = false;
    }

    public final PanGestureHandler setActiveOffsetXStart(float f) {
        PanGestureHandler panGestureHandler = this;
        this.activeOffsetXStart = f;
        return this;
    }

    public final PanGestureHandler setActiveOffsetXEnd(float f) {
        PanGestureHandler panGestureHandler = this;
        this.activeOffsetXEnd = f;
        return this;
    }

    public final PanGestureHandler setFailOffsetXStart(float f) {
        PanGestureHandler panGestureHandler = this;
        this.failOffsetXStart = f;
        return this;
    }

    public final PanGestureHandler setFailOffsetXEnd(float f) {
        PanGestureHandler panGestureHandler = this;
        this.failOffsetXEnd = f;
        return this;
    }

    public final PanGestureHandler setActiveOffsetYStart(float f) {
        PanGestureHandler panGestureHandler = this;
        this.activeOffsetYStart = f;
        return this;
    }

    public final PanGestureHandler setActiveOffsetYEnd(float f) {
        PanGestureHandler panGestureHandler = this;
        this.activeOffsetYEnd = f;
        return this;
    }

    public final PanGestureHandler setFailOffsetYStart(float f) {
        PanGestureHandler panGestureHandler = this;
        this.failOffsetYStart = f;
        return this;
    }

    public final PanGestureHandler setFailOffsetYEnd(float f) {
        PanGestureHandler panGestureHandler = this;
        this.failOffsetYEnd = f;
        return this;
    }

    public final PanGestureHandler setMinDist(float f) {
        PanGestureHandler panGestureHandler = this;
        this.minDistSq = f * f;
        return this;
    }

    public final PanGestureHandler setMinPointers(int i) {
        PanGestureHandler panGestureHandler = this;
        this.minPointers = i;
        return this;
    }

    public final PanGestureHandler setMaxPointers(int i) {
        PanGestureHandler panGestureHandler = this;
        this.maxPointers = i;
        return this;
    }

    public final PanGestureHandler setAverageTouches(boolean z) {
        PanGestureHandler panGestureHandler = this;
        this.averageTouches = z;
        return this;
    }

    public final PanGestureHandler setActivateAfterLongPress(long j) {
        PanGestureHandler panGestureHandler = this;
        this.activateAfterLongPress = j;
        return this;
    }

    public final PanGestureHandler setMinVelocity(float f) {
        PanGestureHandler panGestureHandler = this;
        this.minVelocitySq = f * f;
        return this;
    }

    public final PanGestureHandler setMinVelocityX(float f) {
        PanGestureHandler panGestureHandler = this;
        this.minVelocityX = f;
        return this;
    }

    public final PanGestureHandler setMinVelocityY(float f) {
        PanGestureHandler panGestureHandler = this;
        this.minVelocityY = f;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x008a, code lost:
        if ((0.0f <= r1 && r1 <= r0) != false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00ad, code lost:
        if ((0.0f <= r3 && r3 <= r0) != false) goto L_0x00af;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean shouldActivate() {
        /*
            r8 = this;
            float r0 = r8.lastX
            float r1 = r8.startX
            float r0 = r0 - r1
            float r1 = r8.offsetX
            float r0 = r0 + r1
            float r1 = r8.activeOffsetXStart
            r2 = 2139095039(0x7f7fffff, float:3.4028235E38)
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r4 = 0
            r5 = 1
            if (r3 != 0) goto L_0x0015
            r3 = r5
            goto L_0x0016
        L_0x0015:
            r3 = r4
        L_0x0016:
            if (r3 != 0) goto L_0x001d
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x001d
            return r5
        L_0x001d:
            float r1 = r8.activeOffsetXEnd
            r3 = 1
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 != 0) goto L_0x0026
            r6 = r5
            goto L_0x0027
        L_0x0026:
            r6 = r4
        L_0x0027:
            if (r6 != 0) goto L_0x002e
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x002e
            return r5
        L_0x002e:
            float r1 = r8.lastY
            float r6 = r8.startY
            float r1 = r1 - r6
            float r6 = r8.offsetY
            float r1 = r1 + r6
            float r6 = r8.activeOffsetYStart
            int r7 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x003e
            r7 = r5
            goto L_0x003f
        L_0x003e:
            r7 = r4
        L_0x003f:
            if (r7 != 0) goto L_0x0046
            int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r6 >= 0) goto L_0x0046
            return r5
        L_0x0046:
            float r6 = r8.activeOffsetYEnd
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x004e
            r3 = r5
            goto L_0x004f
        L_0x004e:
            r3 = r4
        L_0x004f:
            if (r3 != 0) goto L_0x0056
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x0056
            return r5
        L_0x0056:
            float r0 = r0 * r0
            float r1 = r1 * r1
            float r0 = r0 + r1
            float r1 = r8.minDistSq
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 != 0) goto L_0x0061
            r3 = r5
            goto L_0x0062
        L_0x0061:
            r3 = r4
        L_0x0062:
            if (r3 != 0) goto L_0x0069
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0069
            return r5
        L_0x0069:
            float r0 = r8.velocityX
            float r1 = r8.minVelocityX
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 != 0) goto L_0x0073
            r3 = r5
            goto L_0x0074
        L_0x0073:
            r3 = r4
        L_0x0074:
            r6 = 0
            if (r3 != 0) goto L_0x008d
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x007f
            int r3 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x008c
        L_0x007f:
            int r3 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r3 > 0) goto L_0x0089
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 > 0) goto L_0x0089
            r1 = r5
            goto L_0x008a
        L_0x0089:
            r1 = r4
        L_0x008a:
            if (r1 == 0) goto L_0x008d
        L_0x008c:
            return r5
        L_0x008d:
            float r1 = r8.velocityY
            float r3 = r8.minVelocityY
            int r7 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x0097
            r7 = r5
            goto L_0x0098
        L_0x0097:
            r7 = r4
        L_0x0098:
            if (r7 != 0) goto L_0x00b0
            int r7 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r7 >= 0) goto L_0x00a2
            int r7 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x00af
        L_0x00a2:
            int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r6 > 0) goto L_0x00ac
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 > 0) goto L_0x00ac
            r3 = r5
            goto L_0x00ad
        L_0x00ac:
            r3 = r4
        L_0x00ad:
            if (r3 == 0) goto L_0x00b0
        L_0x00af:
            return r5
        L_0x00b0:
            float r0 = r0 * r0
            float r1 = r1 * r1
            float r0 = r0 + r1
            float r1 = r8.minVelocitySq
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x00bb
            r2 = r5
            goto L_0x00bc
        L_0x00bb:
            r2 = r4
        L_0x00bc:
            if (r2 != 0) goto L_0x00c3
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x00c3
            r4 = r5
        L_0x00c3:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.core.PanGestureHandler.shouldActivate():boolean");
    }

    private final boolean shouldFail() {
        float f = (this.lastX - this.startX) + this.offsetX;
        float f2 = (this.lastY - this.startY) + this.offsetY;
        if (this.activateAfterLongPress <= 0 || (f * f) + (f2 * f2) <= this.defaultMinDistSq) {
            float f3 = this.failOffsetXStart;
            if (!(f3 == Float.MIN_VALUE) && f < f3) {
                return true;
            }
            float f4 = this.failOffsetXEnd;
            if (!(f4 == Float.MAX_VALUE) && f > f4) {
                return true;
            }
            float f5 = this.failOffsetYStart;
            if (!(f5 == Float.MIN_VALUE) && f2 < f5) {
                return true;
            }
            float f6 = this.failOffsetYEnd;
            if ((f6 == Float.MAX_VALUE) || f2 <= f6) {
                return false;
            }
            return true;
        }
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onHandle(MotionEvent motionEvent, MotionEvent motionEvent2) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        Intrinsics.checkNotNullParameter(motionEvent2, "sourceEvent");
        int state = getState();
        int actionMasked = motionEvent2.getActionMasked();
        if (actionMasked == 5 || actionMasked == 6) {
            this.offsetX += this.lastX - this.startX;
            this.offsetY += this.lastY - this.startY;
            this.lastX = GestureUtils.INSTANCE.getLastPointerX(motionEvent2, this.averageTouches);
            float lastPointerY = GestureUtils.INSTANCE.getLastPointerY(motionEvent2, this.averageTouches);
            this.lastY = lastPointerY;
            this.startX = this.lastX;
            this.startY = lastPointerY;
        } else {
            this.lastX = GestureUtils.INSTANCE.getLastPointerX(motionEvent2, this.averageTouches);
            this.lastY = GestureUtils.INSTANCE.getLastPointerY(motionEvent2, this.averageTouches);
        }
        if (state != 0 || motionEvent2.getPointerCount() < this.minPointers) {
            VelocityTracker velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 != null) {
                Companion.addVelocityMovement(velocityTracker2, motionEvent2);
                VelocityTracker velocityTracker3 = this.velocityTracker;
                Intrinsics.checkNotNull(velocityTracker3);
                velocityTracker3.computeCurrentVelocity(1000);
                VelocityTracker velocityTracker4 = this.velocityTracker;
                Intrinsics.checkNotNull(velocityTracker4);
                this.velocityX = velocityTracker4.getXVelocity();
                VelocityTracker velocityTracker5 = this.velocityTracker;
                Intrinsics.checkNotNull(velocityTracker5);
                this.velocityY = velocityTracker5.getYVelocity();
            }
        } else {
            resetProgress();
            this.offsetX = 0.0f;
            this.offsetY = 0.0f;
            this.velocityX = 0.0f;
            this.velocityY = 0.0f;
            VelocityTracker obtain = VelocityTracker.obtain();
            this.velocityTracker = obtain;
            Companion.addVelocityMovement(obtain, motionEvent2);
            begin();
            if (this.activateAfterLongPress > 0) {
                if (this.handler == null) {
                    this.handler = new Handler(Looper.getMainLooper());
                }
                Handler handler2 = this.handler;
                Intrinsics.checkNotNull(handler2);
                handler2.postDelayed(this.activateDelayed, this.activateAfterLongPress);
            }
        }
        if (actionMasked == 1) {
            if (state == 4) {
                end();
            } else {
                fail();
            }
        } else if (actionMasked != 5 || motionEvent2.getPointerCount() <= this.maxPointers) {
            if (actionMasked == 6 && state == 4 && motionEvent2.getPointerCount() < this.minPointers) {
                fail();
            } else if (state != 2) {
            } else {
                if (shouldFail()) {
                    fail();
                } else if (shouldActivate()) {
                    activate();
                }
            }
        } else if (state == 4) {
            cancel();
        } else {
            fail();
        }
    }

    public void activate(boolean z) {
        if (getState() != 4) {
            resetProgress();
        }
        super.activate(z);
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
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages((Object) null);
        }
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.recycle();
            this.velocityTracker = null;
        }
    }

    public void resetProgress() {
        this.startX = this.lastX;
        this.startY = this.lastY;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/swmansion/gesturehandler/core/PanGestureHandler$Companion;", "", "()V", "DEFAULT_ACTIVATE_AFTER_LONG_PRESS", "", "DEFAULT_MAX_POINTERS", "", "DEFAULT_MIN_POINTERS", "MAX_VALUE_IGNORE", "", "MIN_VALUE_IGNORE", "addVelocityMovement", "", "tracker", "Landroid/view/VelocityTracker;", "event", "Landroid/view/MotionEvent;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PanGestureHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final void addVelocityMovement(VelocityTracker velocityTracker, MotionEvent motionEvent) {
            float rawX = motionEvent.getRawX() - motionEvent.getX();
            float rawY = motionEvent.getRawY() - motionEvent.getY();
            motionEvent.offsetLocation(rawX, rawY);
            Intrinsics.checkNotNull(velocityTracker);
            velocityTracker.addMovement(motionEvent);
            motionEvent.offsetLocation(-rawX, -rawY);
        }
    }
}
