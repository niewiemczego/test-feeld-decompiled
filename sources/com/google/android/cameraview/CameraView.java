package com.google.android.cameraview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.CamcorderProfile;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.os.ParcelableCompat;
import androidx.core.os.ParcelableCompatCreatorCallbacks;
import androidx.core.view.ViewCompat;
import com.facebook.imagepipeline.common.RotationOptions;
import com.google.android.cameraview.CameraViewImpl;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

public class CameraView extends FrameLayout {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int FACING_BACK = 0;
    public static final int FACING_FRONT = 1;
    public static final int FLASH_AUTO = 3;
    public static final int FLASH_OFF = 0;
    public static final int FLASH_ON = 1;
    public static final int FLASH_RED_EYE = 4;
    public static final int FLASH_TORCH = 2;
    private boolean mAdjustViewBounds;
    private final CallbackBridge mCallbacks;
    private Context mContext;
    private final DisplayOrientationDetector mDisplayOrientationDetector;
    CameraViewImpl mImpl;

    public static abstract class Callback {
        public void onCameraClosed(CameraView cameraView) {
        }

        public void onCameraOpened(CameraView cameraView) {
        }

        public void onFramePreview(CameraView cameraView, byte[] bArr, int i, int i2, int i3) {
        }

        public void onMountError(CameraView cameraView) {
        }

        public void onPictureTaken(CameraView cameraView, byte[] bArr) {
        }

        public void onVideoRecorded(CameraView cameraView, String str) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Facing {
    }

    public @interface Flash {
    }

    public CameraView(Context context, boolean z) {
        this(context, (AttributeSet) null, z);
    }

    public CameraView(Context context, AttributeSet attributeSet, boolean z) {
        this(context, attributeSet, 0, z);
    }

    public CameraView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i);
        if (isInEditMode()) {
            this.mCallbacks = null;
            this.mDisplayOrientationDetector = null;
            return;
        }
        this.mAdjustViewBounds = true;
        this.mContext = context;
        PreviewImpl createPreviewImpl = createPreviewImpl(context);
        CallbackBridge callbackBridge = new CallbackBridge();
        this.mCallbacks = callbackBridge;
        if (z || Build.VERSION.SDK_INT < 21) {
            this.mImpl = new Camera1(callbackBridge, createPreviewImpl);
        } else if (Build.VERSION.SDK_INT < 23) {
            this.mImpl = new Camera2(callbackBridge, createPreviewImpl, context);
        } else {
            this.mImpl = new Camera2Api23(callbackBridge, createPreviewImpl, context);
        }
        this.mDisplayOrientationDetector = new DisplayOrientationDetector(context) {
            public void onDisplayOrientationChanged(int i) {
                CameraView.this.mImpl.setDisplayOrientation(i);
            }
        };
    }

    private PreviewImpl createPreviewImpl(Context context) {
        if (Build.VERSION.SDK_INT < 14) {
            return new SurfaceViewPreview(context, this);
        }
        return new TextureViewPreview(context, this);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            this.mDisplayOrientationDetector.enable(ViewCompat.getDisplay(this));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (!isInEditMode()) {
            this.mDisplayOrientationDetector.disable();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (isInEditMode()) {
            super.onMeasure(i, i2);
            return;
        }
        if (!this.mAdjustViewBounds) {
            super.onMeasure(i, i2);
        } else if (!isCameraOpened()) {
            this.mCallbacks.reserveRequestLayoutOnOpen();
            super.onMeasure(i, i2);
            return;
        } else {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode == 1073741824 && mode2 != 1073741824) {
                int size = (int) (((float) View.MeasureSpec.getSize(i)) * getAspectRatio().toFloat());
                if (mode2 == Integer.MIN_VALUE) {
                    size = Math.min(size, View.MeasureSpec.getSize(i2));
                }
                super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, 1073741824));
            } else if (mode == 1073741824 || mode2 != 1073741824) {
                super.onMeasure(i, i2);
            } else {
                int size2 = (int) (((float) View.MeasureSpec.getSize(i2)) * getAspectRatio().toFloat());
                if (mode == Integer.MIN_VALUE) {
                    size2 = Math.min(size2, View.MeasureSpec.getSize(i));
                }
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(size2, 1073741824), i2);
            }
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        AspectRatio aspectRatio = getAspectRatio();
        if (this.mDisplayOrientationDetector.getLastKnownDisplayOrientation() % RotationOptions.ROTATE_180 == 0) {
            aspectRatio = aspectRatio.inverse();
        }
        if (measuredHeight < (aspectRatio.getY() * measuredWidth) / aspectRatio.getX()) {
            this.mImpl.getView().measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec((measuredWidth * aspectRatio.getY()) / aspectRatio.getX(), 1073741824));
        } else {
            this.mImpl.getView().measure(View.MeasureSpec.makeMeasureSpec((aspectRatio.getX() * measuredHeight) / aspectRatio.getY(), 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.facing = getFacing();
        savedState.ratio = getAspectRatio();
        savedState.autoFocus = getAutoFocus();
        savedState.flash = getFlash();
        savedState.focusDepth = getFocusDepth();
        savedState.zoom = getZoom();
        savedState.whiteBalance = getWhiteBalance();
        savedState.scanning = getScanning();
        savedState.pictureSize = getPictureSize();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setFacing(savedState.facing);
        setAspectRatio(savedState.ratio);
        setAutoFocus(savedState.autoFocus);
        setFlash(savedState.flash);
        setFocusDepth(savedState.focusDepth);
        setZoom(savedState.zoom);
        setWhiteBalance(savedState.whiteBalance);
        setScanning(savedState.scanning);
        setPictureSize(savedState.pictureSize);
    }

    public void setUsingCamera2Api(boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            boolean isCameraOpened = isCameraOpened();
            Parcelable onSaveInstanceState = onSaveInstanceState();
            if (z) {
                if (isCameraOpened) {
                    stop();
                }
                if (Build.VERSION.SDK_INT < 23) {
                    this.mImpl = new Camera2(this.mCallbacks, this.mImpl.mPreview, this.mContext);
                } else {
                    this.mImpl = new Camera2Api23(this.mCallbacks, this.mImpl.mPreview, this.mContext);
                }
            } else if (!(this.mImpl instanceof Camera1)) {
                if (isCameraOpened) {
                    stop();
                }
                this.mImpl = new Camera1(this.mCallbacks, this.mImpl.mPreview);
            } else {
                return;
            }
            onRestoreInstanceState(onSaveInstanceState);
            if (isCameraOpened) {
                start();
            }
        }
    }

    public void start() {
        if (!this.mImpl.start()) {
            if (this.mImpl.getView() != null) {
                removeView(this.mImpl.getView());
            }
            Parcelable onSaveInstanceState = onSaveInstanceState();
            this.mImpl = new Camera1(this.mCallbacks, createPreviewImpl(getContext()));
            onRestoreInstanceState(onSaveInstanceState);
            this.mImpl.start();
        }
    }

    public void stop() {
        this.mImpl.stop();
    }

    public boolean isCameraOpened() {
        return this.mImpl.isCameraOpened();
    }

    public void addCallback(Callback callback) {
        this.mCallbacks.add(callback);
    }

    public void removeCallback(Callback callback) {
        this.mCallbacks.remove(callback);
    }

    public void setAdjustViewBounds(boolean z) {
        if (this.mAdjustViewBounds != z) {
            this.mAdjustViewBounds = z;
            requestLayout();
        }
    }

    public boolean getAdjustViewBounds() {
        return this.mAdjustViewBounds;
    }

    public View getView() {
        CameraViewImpl cameraViewImpl = this.mImpl;
        if (cameraViewImpl != null) {
            return cameraViewImpl.getView();
        }
        return null;
    }

    public void setFacing(int i) {
        this.mImpl.setFacing(i);
    }

    public int getFacing() {
        return this.mImpl.getFacing();
    }

    public int getCameraId() {
        return this.mImpl.getCameraId();
    }

    public Set<AspectRatio> getSupportedAspectRatios() {
        return this.mImpl.getSupportedAspectRatios();
    }

    public void setAspectRatio(AspectRatio aspectRatio) {
        if (this.mImpl.setAspectRatio(aspectRatio)) {
            requestLayout();
        }
    }

    public AspectRatio getAspectRatio() {
        return this.mImpl.getAspectRatio();
    }

    public SortedSet<Size> getAvailablePictureSizes(AspectRatio aspectRatio) {
        return this.mImpl.getAvailablePictureSizes(aspectRatio);
    }

    public void setPictureSize(Size size) {
        this.mImpl.setPictureSize(size);
    }

    public Size getPictureSize() {
        return this.mImpl.getPictureSize();
    }

    public void setAutoFocus(boolean z) {
        this.mImpl.setAutoFocus(z);
    }

    public boolean getAutoFocus() {
        return this.mImpl.getAutoFocus();
    }

    public void setFlash(int i) {
        this.mImpl.setFlash(i);
    }

    public int getFlash() {
        return this.mImpl.getFlash();
    }

    public void setFocusDepth(float f) {
        this.mImpl.setFocusDepth(f);
    }

    public float getFocusDepth() {
        return this.mImpl.getFocusDepth();
    }

    public void setZoom(float f) {
        this.mImpl.setZoom(f);
    }

    public float getZoom() {
        return this.mImpl.getZoom();
    }

    public void setWhiteBalance(int i) {
        this.mImpl.setWhiteBalance(i);
    }

    public int getWhiteBalance() {
        return this.mImpl.getWhiteBalance();
    }

    public void setScanning(boolean z) {
        this.mImpl.setScanning(z);
    }

    public boolean getScanning() {
        return this.mImpl.getScanning();
    }

    public void takePicture() {
        this.mImpl.takePicture();
    }

    public boolean record(String str, int i, int i2, boolean z, CamcorderProfile camcorderProfile) {
        return this.mImpl.record(str, i, i2, z, camcorderProfile);
    }

    public void stopRecording() {
        this.mImpl.stopRecording();
    }

    public void resumePreview() {
        this.mImpl.resumePreview();
    }

    public void pausePreview() {
        this.mImpl.pausePreview();
    }

    public void setPreviewTexture(SurfaceTexture surfaceTexture) {
        this.mImpl.setPreviewTexture(surfaceTexture);
    }

    public Size getPreviewSize() {
        return this.mImpl.getPreviewSize();
    }

    private class CallbackBridge implements CameraViewImpl.Callback {
        private final ArrayList<Callback> mCallbacks = new ArrayList<>();
        private boolean mRequestLayoutOnOpen;

        CallbackBridge() {
        }

        public void add(Callback callback) {
            this.mCallbacks.add(callback);
        }

        public void remove(Callback callback) {
            this.mCallbacks.remove(callback);
        }

        public void onCameraOpened() {
            if (this.mRequestLayoutOnOpen) {
                this.mRequestLayoutOnOpen = false;
                CameraView.this.requestLayout();
            }
            Iterator<Callback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onCameraOpened(CameraView.this);
            }
        }

        public void onCameraClosed() {
            Iterator<Callback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onCameraClosed(CameraView.this);
            }
        }

        public void onPictureTaken(byte[] bArr) {
            Iterator<Callback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onPictureTaken(CameraView.this, bArr);
            }
        }

        public void onVideoRecorded(String str) {
            Iterator<Callback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onVideoRecorded(CameraView.this, str);
            }
        }

        public void onFramePreview(byte[] bArr, int i, int i2, int i3) {
            Iterator<Callback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onFramePreview(CameraView.this, bArr, i, i2, i3);
            }
        }

        public void onMountError() {
            Iterator<Callback> it = this.mCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onMountError(CameraView.this);
            }
        }

        public void reserveRequestLayoutOnOpen() {
            this.mRequestLayoutOnOpen = true;
        }
    }

    protected static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        });
        boolean autoFocus;
        int facing;
        int flash;
        float focusDepth;
        Size pictureSize;
        AspectRatio ratio;
        boolean scanning;
        int whiteBalance;
        float zoom;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            this.facing = parcel.readInt();
            this.ratio = (AspectRatio) parcel.readParcelable(classLoader);
            boolean z = true;
            this.autoFocus = parcel.readByte() != 0;
            this.flash = parcel.readInt();
            this.focusDepth = parcel.readFloat();
            this.zoom = parcel.readFloat();
            this.whiteBalance = parcel.readInt();
            this.scanning = parcel.readByte() == 0 ? false : z;
            this.pictureSize = (Size) parcel.readParcelable(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.facing);
            parcel.writeParcelable(this.ratio, 0);
            parcel.writeByte(this.autoFocus ? (byte) 1 : 0);
            parcel.writeInt(this.flash);
            parcel.writeFloat(this.focusDepth);
            parcel.writeFloat(this.zoom);
            parcel.writeInt(this.whiteBalance);
            parcel.writeByte(this.scanning ? (byte) 1 : 0);
            parcel.writeParcelable(this.pictureSize, i);
        }
    }
}
