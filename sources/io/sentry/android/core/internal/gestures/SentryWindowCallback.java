package io.sentry.android.core.internal.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.Window;
import androidx.core.view.GestureDetectorCompat;
import io.sentry.SentryOptions;
import io.sentry.SpanStatus;

public final class SentryWindowCallback extends WindowCallbackAdapter {
    private final Window.Callback delegate;
    private final GestureDetectorCompat gestureDetector;
    private final SentryGestureListener gestureListener;
    private final MotionEventObtainer motionEventObtainer;
    private final SentryOptions options;

    public SentryWindowCallback(Window.Callback callback, Context context, SentryGestureListener sentryGestureListener, SentryOptions sentryOptions) {
        this(callback, new GestureDetectorCompat(context, sentryGestureListener), sentryGestureListener, sentryOptions, new MotionEventObtainer() {
        });
    }

    SentryWindowCallback(Window.Callback callback, GestureDetectorCompat gestureDetectorCompat, SentryGestureListener sentryGestureListener, SentryOptions sentryOptions, MotionEventObtainer motionEventObtainer2) {
        super(callback);
        this.delegate = callback;
        this.gestureListener = sentryGestureListener;
        this.options = sentryOptions;
        this.gestureDetector = gestureDetectorCompat;
        this.motionEventObtainer = motionEventObtainer2;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null) {
            MotionEvent obtain = this.motionEventObtainer.obtain(motionEvent);
            try {
                handleTouchEvent(obtain);
            } catch (Throwable th) {
                obtain.recycle();
                throw th;
            }
            obtain.recycle();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void handleTouchEvent(MotionEvent motionEvent) {
        this.gestureDetector.onTouchEvent(motionEvent);
        if (motionEvent.getActionMasked() == 1) {
            this.gestureListener.onUp(motionEvent);
        }
    }

    public void stopTracking() {
        this.gestureListener.stopTracing(SpanStatus.CANCELLED);
    }

    public Window.Callback getDelegate() {
        return this.delegate;
    }

    interface MotionEventObtainer {
        MotionEvent obtain(MotionEvent motionEvent) {
            return MotionEvent.obtain(motionEvent);
        }
    }
}
