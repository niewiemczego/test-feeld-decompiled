package com.swmansion.gesturehandler.core;

import android.graphics.PointF;
import android.view.MotionEvent;
import com.swmansion.gesturehandler.core.RotationGestureDetector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0014J\b\u0010\u001c\u001a\u00020\u0015H\u0014J\b\u0010\u001d\u001a\u00020\u0015H\u0016R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/swmansion/gesturehandler/core/RotationGestureHandler;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "()V", "<set-?>", "", "anchorX", "getAnchorX", "()F", "anchorY", "getAnchorY", "gestureListener", "Lcom/swmansion/gesturehandler/core/RotationGestureDetector$OnRotationGestureListener;", "", "rotation", "getRotation", "()D", "rotationGestureDetector", "Lcom/swmansion/gesturehandler/core/RotationGestureDetector;", "velocity", "getVelocity", "activate", "", "force", "", "onHandle", "event", "Landroid/view/MotionEvent;", "sourceEvent", "onReset", "resetProgress", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RotationGestureHandler.kt */
public final class RotationGestureHandler extends GestureHandler<RotationGestureHandler> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final double ROTATION_RECOGNITION_THRESHOLD = 0.08726646259971647d;
    private float anchorX = Float.NaN;
    private float anchorY = Float.NaN;
    private final RotationGestureDetector.OnRotationGestureListener gestureListener;
    /* access modifiers changed from: private */
    public double rotation;
    private RotationGestureDetector rotationGestureDetector;
    /* access modifiers changed from: private */
    public double velocity;

    public RotationGestureHandler() {
        setShouldCancelWhenOutside(false);
        this.gestureListener = new RotationGestureHandler$gestureListener$1(this);
    }

    public final double getRotation() {
        return this.rotation;
    }

    public final double getVelocity() {
        return this.velocity;
    }

    public final float getAnchorX() {
        return this.anchorX;
    }

    public final float getAnchorY() {
        return this.anchorY;
    }

    /* access modifiers changed from: protected */
    public void onHandle(MotionEvent motionEvent, MotionEvent motionEvent2) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        Intrinsics.checkNotNullParameter(motionEvent2, "sourceEvent");
        if (getState() == 0) {
            resetProgress();
            this.rotationGestureDetector = new RotationGestureDetector(this.gestureListener);
            this.anchorX = motionEvent.getX();
            this.anchorY = motionEvent.getY();
            begin();
        }
        RotationGestureDetector rotationGestureDetector2 = this.rotationGestureDetector;
        if (rotationGestureDetector2 != null) {
            rotationGestureDetector2.onTouchEvent(motionEvent2);
        }
        RotationGestureDetector rotationGestureDetector3 = this.rotationGestureDetector;
        if (rotationGestureDetector3 != null) {
            PointF transformPoint = transformPoint(new PointF(rotationGestureDetector3.getAnchorX(), rotationGestureDetector3.getAnchorY()));
            this.anchorX = transformPoint.x;
            this.anchorY = transformPoint.y;
        }
        if (motionEvent2.getActionMasked() != 1) {
            return;
        }
        if (getState() == 4) {
            end();
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
    public void onReset() {
        this.rotationGestureDetector = null;
        this.anchorX = Float.NaN;
        this.anchorY = Float.NaN;
        resetProgress();
    }

    public void resetProgress() {
        this.velocity = 0.0d;
        this.rotation = 0.0d;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/swmansion/gesturehandler/core/RotationGestureHandler$Companion;", "", "()V", "ROTATION_RECOGNITION_THRESHOLD", "", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RotationGestureHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
