package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.swmansion.gesturehandler.core.ScaleGestureDetector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0014J\b\u0010\u001e\u001a\u00020\u0017H\u0014J\b\u0010\u001f\u001a\u00020\u0017H\u0016R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f¨\u0006 "}, d2 = {"Lcom/swmansion/gesturehandler/core/PinchGestureHandler;", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "()V", "<set-?>", "", "focalPointX", "getFocalPointX", "()F", "focalPointY", "getFocalPointY", "gestureListener", "Lcom/swmansion/gesturehandler/core/ScaleGestureDetector$OnScaleGestureListener;", "", "scale", "getScale", "()D", "scaleGestureDetector", "Lcom/swmansion/gesturehandler/core/ScaleGestureDetector;", "spanSlop", "startingSpan", "velocity", "getVelocity", "activate", "", "force", "", "onHandle", "event", "Landroid/view/MotionEvent;", "sourceEvent", "onReset", "resetProgress", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PinchGestureHandler.kt */
public final class PinchGestureHandler extends GestureHandler<PinchGestureHandler> {
    private float focalPointX = Float.NaN;
    private float focalPointY = Float.NaN;
    private final ScaleGestureDetector.OnScaleGestureListener gestureListener = new PinchGestureHandler$gestureListener$1(this);
    /* access modifiers changed from: private */
    public double scale;
    private ScaleGestureDetector scaleGestureDetector;
    /* access modifiers changed from: private */
    public float spanSlop;
    /* access modifiers changed from: private */
    public float startingSpan;
    /* access modifiers changed from: private */
    public double velocity;

    public final double getScale() {
        return this.scale;
    }

    public final double getVelocity() {
        return this.velocity;
    }

    public final float getFocalPointX() {
        return this.focalPointX;
    }

    public final float getFocalPointY() {
        return this.focalPointY;
    }

    /* access modifiers changed from: protected */
    public void onHandle(MotionEvent motionEvent, MotionEvent motionEvent2) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        Intrinsics.checkNotNullParameter(motionEvent2, "sourceEvent");
        if (getState() == 0) {
            View view = getView();
            Intrinsics.checkNotNull(view);
            Context context = view.getContext();
            resetProgress();
            this.scaleGestureDetector = new ScaleGestureDetector(context, this.gestureListener);
            this.spanSlop = (float) ViewConfiguration.get(context).getScaledTouchSlop();
            this.focalPointX = motionEvent.getX();
            this.focalPointY = motionEvent.getY();
            begin();
        }
        ScaleGestureDetector scaleGestureDetector2 = this.scaleGestureDetector;
        if (scaleGestureDetector2 != null) {
            scaleGestureDetector2.onTouchEvent(motionEvent2);
        }
        ScaleGestureDetector scaleGestureDetector3 = this.scaleGestureDetector;
        if (scaleGestureDetector3 != null) {
            PointF transformPoint = transformPoint(new PointF(scaleGestureDetector3.getFocusX(), scaleGestureDetector3.getFocusY()));
            this.focalPointX = transformPoint.x;
            this.focalPointY = transformPoint.y;
        }
        int pointerCount = motionEvent2.getPointerCount();
        if (motionEvent2.getActionMasked() == 6) {
            pointerCount--;
        }
        if (getState() == 4 && pointerCount < 2) {
            end();
        } else if (motionEvent2.getActionMasked() == 1) {
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
        this.scaleGestureDetector = null;
        this.focalPointX = Float.NaN;
        this.focalPointY = Float.NaN;
        resetProgress();
    }

    public void resetProgress() {
        this.velocity = 0.0d;
        this.scale = 1.0d;
    }
}
