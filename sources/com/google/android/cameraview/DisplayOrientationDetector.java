package com.google.android.cameraview;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.OrientationEventListener;
import com.facebook.imagepipeline.common.RotationOptions;

abstract class DisplayOrientationDetector {
    static final SparseIntArray DISPLAY_ORIENTATIONS;
    Display mDisplay;
    private int mLastKnownDisplayOrientation = 0;
    private final OrientationEventListener mOrientationEventListener;

    public abstract void onDisplayOrientationChanged(int i);

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        DISPLAY_ORIENTATIONS = sparseIntArray;
        sparseIntArray.put(0, 0);
        sparseIntArray.put(1, 90);
        sparseIntArray.put(2, RotationOptions.ROTATE_180);
        sparseIntArray.put(3, 270);
    }

    public DisplayOrientationDetector(Context context) {
        this.mOrientationEventListener = new OrientationEventListener(context) {
            private int mLastKnownRotation = -1;

            public void onOrientationChanged(int i) {
                int rotation;
                if (i != -1 && DisplayOrientationDetector.this.mDisplay != null && this.mLastKnownRotation != (rotation = DisplayOrientationDetector.this.mDisplay.getRotation())) {
                    this.mLastKnownRotation = rotation;
                    DisplayOrientationDetector.this.dispatchOnDisplayOrientationChanged(DisplayOrientationDetector.DISPLAY_ORIENTATIONS.get(rotation));
                }
            }
        };
    }

    public void enable(Display display) {
        this.mDisplay = display;
        this.mOrientationEventListener.enable();
        dispatchOnDisplayOrientationChanged(DISPLAY_ORIENTATIONS.get(display.getRotation()));
    }

    public void disable() {
        this.mOrientationEventListener.disable();
        this.mDisplay = null;
    }

    public int getLastKnownDisplayOrientation() {
        return this.mLastKnownDisplayOrientation;
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnDisplayOrientationChanged(int i) {
        this.mLastKnownDisplayOrientation = i;
        onDisplayOrientationChanged(i);
    }
}
