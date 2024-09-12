package expo.modules.av.video;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import expo.modules.av.video.scalablevideoview.ScalableType;
import expo.modules.av.video.scalablevideoview.ScaleManager;

public class VideoTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    private boolean mIsAttachedToWindow = false;
    private Surface mSurface = null;
    private VideoView mVideoView;
    private boolean mVisible = true;

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public VideoTextureView(Context context, VideoView videoView) {
        super(context, (AttributeSet) null, 0);
        this.mVideoView = videoView;
        setSurfaceTextureListener(this);
    }

    public boolean isAttachedToWindow() {
        return this.mIsAttachedToWindow;
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public void scaleVideoSize(Pair<Integer, Integer> pair, ScalableType scalableType) {
        Matrix scaleMatrix;
        int intValue = ((Integer) pair.first).intValue();
        int intValue2 = ((Integer) pair.second).intValue();
        if (intValue != 0 && intValue2 != 0 && (scaleMatrix = new ScaleManager(new Size(getWidth(), getHeight()), new Size(intValue, intValue2)).getScaleMatrix(scalableType)) != null) {
            Matrix matrix = new Matrix();
            getTransform(matrix);
            if (!scaleMatrix.equals(matrix)) {
                setTransform(scaleMatrix);
                invalidate();
            }
        }
    }

    public void onResume() {
        if (this.mVisible) {
            onVisibilityChanged(this, 4);
            onVisibilityChanged(this, 0);
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Surface surface = new Surface(surfaceTexture);
        this.mSurface = surface;
        this.mVideoView.tryUpdateVideoSurface(surface);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.mSurface = null;
        this.mVideoView.tryUpdateVideoSurface((Surface) null);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsAttachedToWindow = false;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsAttachedToWindow = true;
        this.mVideoView.tryUpdateVideoSurface(this.mSurface);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.mVisible = i == 0;
    }
}
