package com.google.android.cameraview;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.view.SurfaceHolder;
import androidx.collection.SparseArrayCompat;
import com.facebook.imagepipeline.common.RotationOptions;
import com.google.android.cameraview.CameraViewImpl;
import com.google.android.cameraview.PreviewImpl;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.DebugKt;

class Camera1 extends CameraViewImpl implements MediaRecorder.OnInfoListener, MediaRecorder.OnErrorListener, Camera.PreviewCallback {
    private static final SparseArrayCompat<String> FLASH_MODES;
    private static final int INVALID_CAMERA_ID = -1;
    private static final SparseArrayCompat<String> WB_MODES;
    /* access modifiers changed from: private */
    public final AtomicBoolean isPictureCaptureInProgress = new AtomicBoolean(false);
    private AspectRatio mAspectRatio;
    private boolean mAutoFocus;
    Camera mCamera;
    private int mCameraId;
    private final Camera.CameraInfo mCameraInfo = new Camera.CameraInfo();
    private Camera.Parameters mCameraParameters;
    private int mDisplayOrientation;
    private int mFacing;
    private int mFlash;
    /* access modifiers changed from: private */
    public boolean mIsPreviewActive = false;
    private boolean mIsRecording;
    /* access modifiers changed from: private */
    public boolean mIsScanning;
    private MediaRecorder mMediaRecorder;
    private Size mPictureSize;
    private final SizeMap mPictureSizes = new SizeMap();
    private final SizeMap mPreviewSizes = new SizeMap();
    private SurfaceTexture mPreviewTexture;
    private boolean mShowingPreview;
    private String mVideoPath;
    private int mWhiteBalance;
    private float mZoom;

    private boolean isLandscape(int i) {
        return i == 90 || i == 270;
    }

    /* access modifiers changed from: package-private */
    public float getFocusDepth() {
        return 0.0f;
    }

    public void setFocusDepth(float f) {
    }

    static {
        SparseArrayCompat<String> sparseArrayCompat = new SparseArrayCompat<>();
        FLASH_MODES = sparseArrayCompat;
        sparseArrayCompat.put(0, DebugKt.DEBUG_PROPERTY_VALUE_OFF);
        sparseArrayCompat.put(1, "on");
        sparseArrayCompat.put(2, "torch");
        sparseArrayCompat.put(3, "auto");
        sparseArrayCompat.put(4, "red-eye");
        SparseArrayCompat<String> sparseArrayCompat2 = new SparseArrayCompat<>();
        WB_MODES = sparseArrayCompat2;
        sparseArrayCompat2.put(0, "auto");
        sparseArrayCompat2.put(1, "cloudy-daylight");
        sparseArrayCompat2.put(2, "daylight");
        sparseArrayCompat2.put(3, "shade");
        sparseArrayCompat2.put(4, "fluorescent");
        sparseArrayCompat2.put(5, "incandescent");
    }

    Camera1(CameraViewImpl.Callback callback, PreviewImpl previewImpl) {
        super(callback, previewImpl);
        previewImpl.setCallback(new PreviewImpl.Callback() {
            public void onSurfaceChanged() {
                if (Camera1.this.mCamera != null) {
                    Camera1.this.setUpPreview();
                    Camera1.this.adjustCameraParameters();
                }
            }

            public void onSurfaceDestroyed() {
                Camera1.this.stop();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public boolean start() {
        chooseCamera();
        if (!openCamera()) {
            this.mCallback.onMountError();
            return true;
        }
        if (this.mPreview.isReady()) {
            setUpPreview();
        }
        this.mShowingPreview = true;
        startCameraPreview();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void stop() {
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.stopPreview();
            this.mIsPreviewActive = false;
            this.mCamera.setPreviewCallback((Camera.PreviewCallback) null);
        }
        this.mShowingPreview = false;
        MediaRecorder mediaRecorder = this.mMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.stop();
            this.mMediaRecorder.release();
            this.mMediaRecorder = null;
            if (this.mIsRecording) {
                this.mCallback.onVideoRecorded(this.mVideoPath);
                this.mIsRecording = false;
            }
        }
        releaseCamera();
    }

    /* access modifiers changed from: package-private */
    public void setUpPreview() {
        try {
            SurfaceTexture surfaceTexture = this.mPreviewTexture;
            if (surfaceTexture != null) {
                this.mCamera.setPreviewTexture(surfaceTexture);
            } else if (this.mPreview.getOutputClass() == SurfaceHolder.class) {
                boolean z = this.mShowingPreview && Build.VERSION.SDK_INT < 14;
                if (z) {
                    this.mCamera.stopPreview();
                    this.mIsPreviewActive = false;
                }
                this.mCamera.setPreviewDisplay(this.mPreview.getSurfaceHolder());
                if (z) {
                    startCameraPreview();
                }
            } else {
                this.mCamera.setPreviewTexture((SurfaceTexture) this.mPreview.getSurfaceTexture());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void startCameraPreview() {
        this.mCamera.startPreview();
        this.mIsPreviewActive = true;
        if (this.mIsScanning) {
            this.mCamera.setPreviewCallback(this);
        }
    }

    public void resumePreview() {
        startCameraPreview();
    }

    public void pausePreview() {
        this.mCamera.stopPreview();
        this.mIsPreviewActive = false;
    }

    /* access modifiers changed from: package-private */
    public boolean isCameraOpened() {
        return this.mCamera != null;
    }

    /* access modifiers changed from: package-private */
    public void setFacing(int i) {
        if (this.mFacing != i) {
            this.mFacing = i;
            if (isCameraOpened()) {
                stop();
                start();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int getFacing() {
        return this.mFacing;
    }

    /* access modifiers changed from: package-private */
    public int getCameraId() {
        return this.mCameraId;
    }

    /* access modifiers changed from: package-private */
    public Set<AspectRatio> getSupportedAspectRatios() {
        SizeMap sizeMap = this.mPreviewSizes;
        for (AspectRatio next : sizeMap.ratios()) {
            if (this.mPictureSizes.sizes(next) == null) {
                sizeMap.remove(next);
            }
        }
        return sizeMap.ratios();
    }

    /* access modifiers changed from: package-private */
    public SortedSet<Size> getAvailablePictureSizes(AspectRatio aspectRatio) {
        return this.mPictureSizes.sizes(aspectRatio);
    }

    /* access modifiers changed from: package-private */
    public void setPictureSize(Size size) {
        if (size != null) {
            this.mPictureSize = size;
            Camera.Parameters parameters = this.mCameraParameters;
            if (parameters != null && this.mCamera != null) {
                parameters.setPictureSize(size.getWidth(), size.getHeight());
                this.mCamera.setParameters(this.mCameraParameters);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Size getPictureSize() {
        return this.mPictureSize;
    }

    /* access modifiers changed from: package-private */
    public boolean setAspectRatio(AspectRatio aspectRatio) {
        if (this.mAspectRatio == null || !isCameraOpened()) {
            this.mAspectRatio = aspectRatio;
            return true;
        } else if (this.mAspectRatio.equals(aspectRatio)) {
            return false;
        } else {
            if (this.mPreviewSizes.sizes(aspectRatio) != null) {
                this.mAspectRatio = aspectRatio;
                this.mPictureSize = this.mPictureSizes.sizes(aspectRatio).last();
                adjustCameraParameters();
                return true;
            }
            throw new UnsupportedOperationException(aspectRatio + " is not supported");
        }
    }

    /* access modifiers changed from: package-private */
    public AspectRatio getAspectRatio() {
        return this.mAspectRatio;
    }

    /* access modifiers changed from: package-private */
    public void setAutoFocus(boolean z) {
        if (this.mAutoFocus != z && setAutoFocusInternal(z)) {
            this.mCamera.setParameters(this.mCameraParameters);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean getAutoFocus() {
        if (!isCameraOpened()) {
            return this.mAutoFocus;
        }
        String focusMode = this.mCameraParameters.getFocusMode();
        return focusMode != null && focusMode.contains("continuous");
    }

    /* access modifiers changed from: package-private */
    public void setFlash(int i) {
        if (i != this.mFlash && setFlashInternal(i)) {
            this.mCamera.setParameters(this.mCameraParameters);
        }
    }

    /* access modifiers changed from: package-private */
    public int getFlash() {
        return this.mFlash;
    }

    /* access modifiers changed from: package-private */
    public void setZoom(float f) {
        if (f != this.mZoom && setZoomInternal(f)) {
            this.mCamera.setParameters(this.mCameraParameters);
        }
    }

    /* access modifiers changed from: package-private */
    public float getZoom() {
        return this.mZoom;
    }

    public void setWhiteBalance(int i) {
        if (i != this.mWhiteBalance && setWhiteBalanceInternal(i)) {
            this.mCamera.setParameters(this.mCameraParameters);
        }
    }

    public int getWhiteBalance() {
        return this.mWhiteBalance;
    }

    /* access modifiers changed from: package-private */
    public void setScanning(boolean z) {
        if (z != this.mIsScanning) {
            setScanningInternal(z);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean getScanning() {
        return this.mIsScanning;
    }

    /* access modifiers changed from: package-private */
    public void takePicture() {
        if (!isCameraOpened()) {
            throw new IllegalStateException("Camera is not ready. Call start() before takePicture().");
        } else if (!this.mIsPreviewActive) {
            throw new IllegalStateException("Preview is paused - resume it before taking a picture.");
        } else if (getAutoFocus()) {
            this.mCamera.cancelAutoFocus();
            this.mCamera.autoFocus(new Camera.AutoFocusCallback() {
                public void onAutoFocus(boolean z, Camera camera) {
                    Camera1.this.takePictureInternal();
                }
            });
        } else {
            takePictureInternal();
        }
    }

    /* access modifiers changed from: package-private */
    public void takePictureInternal() {
        if (!this.isPictureCaptureInProgress.getAndSet(true)) {
            this.mCamera.takePicture((Camera.ShutterCallback) null, (Camera.PictureCallback) null, (Camera.PictureCallback) null, new Camera.PictureCallback() {
                public void onPictureTaken(byte[] bArr, Camera camera) {
                    Camera1.this.isPictureCaptureInProgress.set(false);
                    camera.cancelAutoFocus();
                    camera.startPreview();
                    boolean unused = Camera1.this.mIsPreviewActive = true;
                    if (Camera1.this.mIsScanning) {
                        camera.setPreviewCallback(Camera1.this);
                    }
                    Camera1.this.mCallback.onPictureTaken(bArr);
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public boolean record(String str, int i, int i2, boolean z, CamcorderProfile camcorderProfile) {
        if (!this.mIsRecording) {
            setUpMediaRecorder(str, i, i2, z, camcorderProfile);
            try {
                this.mMediaRecorder.prepare();
                this.mMediaRecorder.start();
                this.mIsRecording = true;
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void stopRecording() {
        if (this.mIsRecording) {
            stopMediaRecorder();
            Camera camera = this.mCamera;
            if (camera != null) {
                camera.lock();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setDisplayOrientation(int i) {
        if (this.mDisplayOrientation != i) {
            this.mDisplayOrientation = i;
            if (isCameraOpened()) {
                this.mCameraParameters.setRotation(calcCameraRotation(i));
                this.mCamera.setParameters(this.mCameraParameters);
                boolean z = this.mShowingPreview && Build.VERSION.SDK_INT < 14;
                if (z) {
                    this.mCamera.stopPreview();
                    this.mIsPreviewActive = false;
                }
                this.mCamera.setDisplayOrientation(calcDisplayOrientation(i));
                if (z) {
                    startCameraPreview();
                }
            }
        }
    }

    public void setPreviewTexture(SurfaceTexture surfaceTexture) {
        try {
            Camera camera = this.mCamera;
            if (camera == null) {
                this.mPreviewTexture = surfaceTexture;
                return;
            }
            camera.stopPreview();
            this.mIsPreviewActive = false;
            if (surfaceTexture == null) {
                this.mCamera.setPreviewTexture((SurfaceTexture) this.mPreview.getSurfaceTexture());
            } else {
                this.mCamera.setPreviewTexture(surfaceTexture);
            }
            this.mPreviewTexture = surfaceTexture;
            startCameraPreview();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Size getPreviewSize() {
        Camera.Size previewSize = this.mCameraParameters.getPreviewSize();
        return new Size(previewSize.width, previewSize.height);
    }

    private void chooseCamera() {
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, this.mCameraInfo);
            if (this.mCameraInfo.facing == this.mFacing) {
                this.mCameraId = i;
                return;
            }
        }
        this.mCameraId = -1;
    }

    private boolean openCamera() {
        if (this.mCamera != null) {
            releaseCamera();
        }
        try {
            Camera open = Camera.open(this.mCameraId);
            this.mCamera = open;
            this.mCameraParameters = open.getParameters();
            this.mPreviewSizes.clear();
            for (Camera.Size next : this.mCameraParameters.getSupportedPreviewSizes()) {
                this.mPreviewSizes.add(new Size(next.width, next.height));
            }
            this.mPictureSizes.clear();
            for (Camera.Size next2 : this.mCameraParameters.getSupportedPictureSizes()) {
                this.mPictureSizes.add(new Size(next2.width, next2.height));
            }
            if (this.mAspectRatio == null) {
                this.mAspectRatio = Constants.DEFAULT_ASPECT_RATIO;
            }
            adjustCameraParameters();
            this.mCamera.setDisplayOrientation(calcDisplayOrientation(this.mDisplayOrientation));
            this.mCallback.onCameraOpened();
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    private AspectRatio chooseAspectRatio() {
        Iterator<AspectRatio> it = this.mPreviewSizes.ratios().iterator();
        AspectRatio aspectRatio = null;
        while (it.hasNext()) {
            aspectRatio = it.next();
            if (aspectRatio.equals(Constants.DEFAULT_ASPECT_RATIO)) {
                break;
            }
        }
        return aspectRatio;
    }

    /* access modifiers changed from: package-private */
    public void adjustCameraParameters() {
        SortedSet<Size> sizes = this.mPreviewSizes.sizes(this.mAspectRatio);
        if (sizes == null) {
            AspectRatio chooseAspectRatio = chooseAspectRatio();
            this.mAspectRatio = chooseAspectRatio;
            sizes = this.mPreviewSizes.sizes(chooseAspectRatio);
        }
        Size chooseOptimalSize = chooseOptimalSize(sizes);
        if (this.mPictureSize == null) {
            this.mPictureSize = this.mPictureSizes.sizes(this.mAspectRatio).last();
        }
        if (this.mShowingPreview) {
            this.mCamera.stopPreview();
            this.mIsPreviewActive = false;
        }
        this.mCameraParameters.setPreviewSize(chooseOptimalSize.getWidth(), chooseOptimalSize.getHeight());
        this.mCameraParameters.setPictureSize(this.mPictureSize.getWidth(), this.mPictureSize.getHeight());
        this.mCameraParameters.setRotation(calcCameraRotation(this.mDisplayOrientation));
        setAutoFocusInternal(this.mAutoFocus);
        setFlashInternal(this.mFlash);
        setAspectRatio(this.mAspectRatio);
        setZoomInternal(this.mZoom);
        setWhiteBalanceInternal(this.mWhiteBalance);
        setScanningInternal(this.mIsScanning);
        this.mCamera.setParameters(this.mCameraParameters);
        if (this.mShowingPreview) {
            startCameraPreview();
        }
    }

    private Size chooseOptimalSize(SortedSet<Size> sortedSet) {
        if (!this.mPreview.isReady()) {
            return sortedSet.first();
        }
        int width = this.mPreview.getWidth();
        int height = this.mPreview.getHeight();
        if (isLandscape(this.mDisplayOrientation)) {
            int i = height;
            height = width;
            width = i;
        }
        r2 = null;
        for (Size size : sortedSet) {
            if (width <= size.getWidth() && height <= size.getHeight()) {
                break;
            }
        }
        return size;
    }

    private void releaseCamera() {
        Camera camera = this.mCamera;
        if (camera != null) {
            camera.release();
            this.mCamera = null;
            this.mPictureSize = null;
            this.mCallback.onCameraClosed();
        }
    }

    private int calcDisplayOrientation(int i) {
        if (this.mCameraInfo.facing == 1) {
            return (360 - ((this.mCameraInfo.orientation + i) % 360)) % 360;
        }
        return ((this.mCameraInfo.orientation - i) + 360) % 360;
    }

    private int calcCameraRotation(int i) {
        if (this.mCameraInfo.facing == 1) {
            return (this.mCameraInfo.orientation + i) % 360;
        }
        return ((this.mCameraInfo.orientation + i) + (isLandscape(i) ? RotationOptions.ROTATE_180 : 0)) % 360;
    }

    private boolean setAutoFocusInternal(boolean z) {
        this.mAutoFocus = z;
        if (!isCameraOpened()) {
            return false;
        }
        List<String> supportedFocusModes = this.mCameraParameters.getSupportedFocusModes();
        if (z && supportedFocusModes.contains("continuous-picture")) {
            this.mCameraParameters.setFocusMode("continuous-picture");
            return true;
        } else if (supportedFocusModes.contains("fixed")) {
            this.mCameraParameters.setFocusMode("fixed");
            return true;
        } else if (supportedFocusModes.contains("infinity")) {
            this.mCameraParameters.setFocusMode("infinity");
            return true;
        } else {
            this.mCameraParameters.setFocusMode(supportedFocusModes.get(0));
            return true;
        }
    }

    private boolean setFlashInternal(int i) {
        if (isCameraOpened()) {
            List<String> supportedFlashModes = this.mCameraParameters.getSupportedFlashModes();
            SparseArrayCompat<String> sparseArrayCompat = FLASH_MODES;
            String str = sparseArrayCompat.get(i);
            if (supportedFlashModes == null || !supportedFlashModes.contains(str)) {
                String str2 = sparseArrayCompat.get(this.mFlash);
                if (supportedFlashModes != null && supportedFlashModes.contains(str2)) {
                    return false;
                }
                this.mCameraParameters.setFlashMode(DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                return true;
            }
            this.mCameraParameters.setFlashMode(str);
            this.mFlash = i;
            return true;
        }
        this.mFlash = i;
        return false;
    }

    private boolean setZoomInternal(float f) {
        if (!isCameraOpened() || !this.mCameraParameters.isZoomSupported()) {
            this.mZoom = f;
            return false;
        }
        this.mCameraParameters.setZoom((int) (((float) this.mCameraParameters.getMaxZoom()) * f));
        this.mZoom = f;
        return true;
    }

    private boolean setWhiteBalanceInternal(int i) {
        this.mWhiteBalance = i;
        if (!isCameraOpened()) {
            return false;
        }
        List<String> supportedWhiteBalance = this.mCameraParameters.getSupportedWhiteBalance();
        SparseArrayCompat<String> sparseArrayCompat = WB_MODES;
        String str = sparseArrayCompat.get(i);
        if (supportedWhiteBalance == null || !supportedWhiteBalance.contains(str)) {
            String str2 = sparseArrayCompat.get(this.mWhiteBalance);
            if (supportedWhiteBalance != null && supportedWhiteBalance.contains(str2)) {
                return false;
            }
            this.mCameraParameters.setWhiteBalance("auto");
            return true;
        }
        this.mCameraParameters.setWhiteBalance(str);
        return true;
    }

    private void setScanningInternal(boolean z) {
        this.mIsScanning = z;
        if (!isCameraOpened()) {
            return;
        }
        if (this.mIsScanning) {
            this.mCamera.setPreviewCallback(this);
        } else {
            this.mCamera.setPreviewCallback((Camera.PreviewCallback) null);
        }
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Camera.Size previewSize = this.mCameraParameters.getPreviewSize();
        this.mCallback.onFramePreview(bArr, previewSize.width, previewSize.height, this.mDisplayOrientation);
    }

    private void setUpMediaRecorder(String str, int i, int i2, boolean z, CamcorderProfile camcorderProfile) {
        this.mMediaRecorder = new MediaRecorder();
        this.mCamera.unlock();
        this.mMediaRecorder.setCamera(this.mCamera);
        this.mMediaRecorder.setVideoSource(1);
        if (z) {
            this.mMediaRecorder.setAudioSource(5);
        }
        this.mMediaRecorder.setOutputFile(str);
        this.mVideoPath = str;
        if (CamcorderProfile.hasProfile(this.mCameraId, camcorderProfile.quality)) {
            setCamcorderProfile(CamcorderProfile.get(this.mCameraId, camcorderProfile.quality), z);
        } else {
            setCamcorderProfile(CamcorderProfile.get(this.mCameraId, 1), z);
        }
        this.mMediaRecorder.setOrientationHint(calcCameraRotation(this.mDisplayOrientation));
        if (i != -1) {
            this.mMediaRecorder.setMaxDuration(i);
        }
        if (i2 != -1) {
            this.mMediaRecorder.setMaxFileSize((long) i2);
        }
        this.mMediaRecorder.setOnInfoListener(this);
        this.mMediaRecorder.setOnErrorListener(this);
    }

    private void stopMediaRecorder() {
        this.mIsRecording = false;
        MediaRecorder mediaRecorder = this.mMediaRecorder;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.stop();
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            this.mMediaRecorder.reset();
            this.mMediaRecorder.release();
            this.mMediaRecorder = null;
        }
        if (this.mVideoPath == null || !new File(this.mVideoPath).exists()) {
            this.mCallback.onVideoRecorded((String) null);
            return;
        }
        this.mCallback.onVideoRecorded(this.mVideoPath);
        this.mVideoPath = null;
    }

    private void setCamcorderProfile(CamcorderProfile camcorderProfile, boolean z) {
        this.mMediaRecorder.setOutputFormat(camcorderProfile.fileFormat);
        this.mMediaRecorder.setVideoFrameRate(camcorderProfile.videoFrameRate);
        this.mMediaRecorder.setVideoSize(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
        this.mMediaRecorder.setVideoEncodingBitRate(camcorderProfile.videoBitRate);
        this.mMediaRecorder.setVideoEncoder(camcorderProfile.videoCodec);
        if (z) {
            this.mMediaRecorder.setAudioEncodingBitRate(camcorderProfile.audioBitRate);
            this.mMediaRecorder.setAudioChannels(camcorderProfile.audioChannels);
            this.mMediaRecorder.setAudioSamplingRate(camcorderProfile.audioSampleRate);
            this.mMediaRecorder.setAudioEncoder(camcorderProfile.audioCodec);
        }
    }

    public void onInfo(MediaRecorder mediaRecorder, int i, int i2) {
        if (i == 800 || i == 801) {
            stopRecording();
        }
    }

    public void onError(MediaRecorder mediaRecorder, int i, int i2) {
        stopRecording();
    }
}
