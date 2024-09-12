package com.transparentvideo;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.widget.LinearLayout;
import com.transparentvideo.VideoRenderer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.HashMap;

public class AlphaMovieView extends GLTextureView {
    private static final int GL_CONTEXT_VERSION = 2;
    private static final int NOT_DEFINED = -1;
    private static final int NOT_DEFINED_COLOR = 0;
    private static final String TAG = "VideoSurfaceView";
    private static final int TIME_DETECTION_INTERVAL_MS = 100;
    private static final float VIEW_ASPECT_RATIO = 1.3333334f;
    private float accuracy;
    private int alphaColor;
    private boolean autoPlayAfterResume;
    final Handler handler = new Handler();
    /* access modifiers changed from: private */
    public boolean isDataSourceSet;
    private boolean isPacked;
    /* access modifiers changed from: private */
    public boolean isSurfaceCreated;
    /* access modifiers changed from: private */
    public long loopEndMs;
    /* access modifiers changed from: private */
    public int loopSeekingMethod = 0;
    /* access modifiers changed from: private */
    public long loopStartMs;
    /* access modifiers changed from: private */
    public MediaPlayer mediaPlayer;
    /* access modifiers changed from: private */
    public OnVideoEndedListener onVideoEndedListener;
    /* access modifiers changed from: private */
    public OnVideoStartedListener onVideoStartedListener;
    private boolean playAfterResume;
    VideoRenderer renderer;
    private String shader;
    /* access modifiers changed from: private */
    public PlayerState state = PlayerState.NOT_PREPARED;
    final Runnable timeDetector = new Runnable() {
        public void run() {
            if (AlphaMovieView.this.getRootView() != null) {
                try {
                    int currentPosition = AlphaMovieView.this.mediaPlayer.getCurrentPosition();
                    if (AlphaMovieView.this.state == PlayerState.STARTED) {
                        AlphaMovieView.this.startTimeDetector();
                        if (AlphaMovieView.this.loopStartMs >= 0 && AlphaMovieView.this.loopEndMs >= 0 && ((long) currentPosition) >= AlphaMovieView.this.loopEndMs) {
                            if (Build.VERSION.SDK_INT >= 26) {
                                AlphaMovieView.this.mediaPlayer.seekTo(AlphaMovieView.this.loopStartMs, AlphaMovieView.this.loopSeekingMethod);
                            } else {
                                AlphaMovieView.this.mediaPlayer.seekTo((int) AlphaMovieView.this.loopStartMs);
                            }
                        }
                    }
                } catch (Exception e) {
                    Log.e("AlphaMovieView", "Time detector error. Did you forget to call AlphaMovieView's onPause in the containing fragment/activity? | " + e.getMessage());
                }
            }
        }
    };
    private float videoAspectRatio = 1.3333334f;

    public interface OnVideoEndedListener {
        void onVideoEnded();
    }

    public interface OnVideoStartedListener {
        void onVideoStarted();
    }

    private enum PlayerState {
        NOT_PREPARED,
        PREPARED,
        STARTED,
        PAUSED,
        STOPPED,
        RELEASE
    }

    public AlphaMovieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            init(attributeSet);
        }
    }

    private void init(AttributeSet attributeSet) {
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        initMediaPlayer();
        this.renderer = new VideoRenderer();
        obtainRendererOptions(attributeSet);
        addOnSurfacePrepareListener();
        setRenderer(this.renderer);
        bringToFront();
        setPreserveEGLContextOnPause(true);
        setOpaque(false);
    }

    private void initMediaPlayer() {
        this.mediaPlayer = new MediaPlayer();
        setScreenOnWhilePlaying(true);
        setLooping(true);
        this.mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (AlphaMovieView.this.onVideoEndedListener != null) {
                    AlphaMovieView.this.onVideoEndedListener.onVideoEnded();
                }
                if (AlphaMovieView.this.loopStartMs < 0 || AlphaMovieView.this.loopEndMs != -1) {
                    PlayerState unused = AlphaMovieView.this.state = PlayerState.PAUSED;
                    return;
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    AlphaMovieView.this.mediaPlayer.seekTo(AlphaMovieView.this.loopStartMs, AlphaMovieView.this.loopSeekingMethod);
                } else {
                    AlphaMovieView.this.mediaPlayer.seekTo((int) AlphaMovieView.this.loopStartMs);
                }
                AlphaMovieView.this.mediaPlayer.start();
            }
        });
    }

    private void obtainRendererOptions(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.AlphaMovieView);
        this.accuracy = obtainStyledAttributes.getFloat(R.styleable.AlphaMovieView_accuracy, 0.95f);
        this.alphaColor = obtainStyledAttributes.getColor(R.styleable.AlphaMovieView_alphaColor, Color.argb(1, 0, 255, 0));
        this.autoPlayAfterResume = obtainStyledAttributes.getBoolean(R.styleable.AlphaMovieView_autoPlayAfterResume, false);
        this.isPacked = obtainStyledAttributes.getBoolean(R.styleable.AlphaMovieView_packed, false);
        this.loopStartMs = (long) obtainStyledAttributes.getInteger(R.styleable.AlphaMovieView_loopStartMs, -1);
        this.loopEndMs = (long) obtainStyledAttributes.getInteger(R.styleable.AlphaMovieView_loopEndMs, -1);
        updateMediaPlayerLoopSetting();
        if (Build.VERSION.SDK_INT >= 26) {
            this.loopSeekingMethod = obtainStyledAttributes.getInteger(R.styleable.AlphaMovieView_loopSeekingMethod, 2);
        } else {
            this.loopSeekingMethod = 0;
        }
        this.shader = obtainStyledAttributes.getString(R.styleable.AlphaMovieView_shader);
        obtainStyledAttributes.recycle();
        updateRendererOptions();
    }

    private void updateRendererOptions() {
        this.renderer.setPacked(this.isPacked);
        int i = this.alphaColor;
        if (i != 0) {
            this.renderer.setAlphaColor(i);
        }
        String str = this.shader;
        if (str != null) {
            this.renderer.setCustomShader(str);
        }
        float f = this.accuracy;
        if (f != -1.0f) {
            this.renderer.setAccuracy((double) f);
        }
    }

    private void addOnSurfacePrepareListener() {
        VideoRenderer videoRenderer = this.renderer;
        if (videoRenderer != null) {
            videoRenderer.setOnSurfacePrepareListener(new VideoRenderer.OnSurfacePrepareListener() {
                public void surfacePrepared(Surface surface) {
                    boolean unused = AlphaMovieView.this.isSurfaceCreated = true;
                    AlphaMovieView.this.mediaPlayer.setSurface(surface);
                    surface.release();
                    if (AlphaMovieView.this.isDataSourceSet) {
                        AlphaMovieView.this.prepareAndStartMediaPlayer();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void prepareAndStartMediaPlayer() {
        prepareAsync(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                AlphaMovieView.this.start();
            }
        });
    }

    private void calculateVideoAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.videoAspectRatio = ((float) i) / ((float) i2);
        }
        requestLayout();
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        double d = ((double) size) / ((double) size2);
        float f = this.videoAspectRatio;
        if (d > ((double) f)) {
            size = (int) (((float) size2) * f);
        } else {
            size2 = (int) (((float) size) / f);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, mode), View.MeasureSpec.makeMeasureSpec(size2, mode2));
    }

    private void onDataSourceSet(MediaMetadataRetriever mediaMetadataRetriever) {
        int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
        int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
        if (this.isPacked) {
            parseInt2 = (int) (((float) parseInt2) / 2.0f);
        }
        calculateVideoAspectRatio(parseInt, parseInt2);
        this.isDataSourceSet = true;
        if (this.isSurfaceCreated) {
            prepareAndStartMediaPlayer();
        }
    }

    public void setAutoPlayAfterResume(boolean z) {
        this.autoPlayAfterResume = z;
    }

    public void setPacked(boolean z) {
        this.isPacked = z;
        this.renderer.setPacked(z);
        updateRendererOptions();
        this.renderer.refreshShader();
    }

    private void updateMediaPlayerLoopSetting() {
        if (this.loopStartMs >= 0 || this.loopEndMs >= 0) {
            setLooping(false);
        }
    }

    public void setLoopStartMs(long j) {
        this.loopStartMs = j;
        updateMediaPlayerLoopSetting();
    }

    public void setLoopEndMs(long j) {
        this.loopEndMs = j;
        updateMediaPlayerLoopSetting();
    }

    public void setVideoFromAssets(String str) {
        reset();
        try {
            AssetFileDescriptor openFd = getContext().getAssets().openFd(str);
            this.mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            onDataSourceSet(mediaMetadataRetriever);
        } catch (IOException e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

    public void setVideoFromAssets(String str, boolean z) {
        setPacked(z);
        setVideoFromAssets(str);
    }

    public void setVideoByUrl(String str) {
        reset();
        try {
            this.mediaPlayer.setDataSource(str);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str, new HashMap());
            onDataSourceSet(mediaMetadataRetriever);
        } catch (IOException e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

    public void setVideoFromResourceId(Context context, int i) {
        reset();
        try {
            AssetFileDescriptor openRawResourceFd = context.getResources().openRawResourceFd(i);
            if (openRawResourceFd != null) {
                FileDescriptor fileDescriptor = openRawResourceFd.getFileDescriptor();
                long startOffset = openRawResourceFd.getStartOffset();
                long length = openRawResourceFd.getLength();
                this.mediaPlayer.setDataSource(fileDescriptor, startOffset, length);
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(fileDescriptor, startOffset, length);
                onDataSourceSet(mediaMetadataRetriever);
            }
        } catch (IOException e) {
            Log.e("VideoSurfaceView setVideoFromResourceId", e.getMessage(), e);
        }
    }

    public void setVideoFromFile(FileDescriptor fileDescriptor) {
        reset();
        try {
            this.mediaPlayer.setDataSource(fileDescriptor);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(fileDescriptor);
            onDataSourceSet(mediaMetadataRetriever);
        } catch (IOException e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

    public void setVideoFromFile(FileDescriptor fileDescriptor, int i, int i2) {
        reset();
        try {
            long j = (long) i;
            long j2 = (long) i2;
            this.mediaPlayer.setDataSource(fileDescriptor, j, j2);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(fileDescriptor, j, j2);
            onDataSourceSet(mediaMetadataRetriever);
        } catch (IOException e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

    public void setVideoFromMediaDataSource(MediaDataSource mediaDataSource) {
        reset();
        this.mediaPlayer.setDataSource(mediaDataSource);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(mediaDataSource);
        onDataSourceSet(mediaMetadataRetriever);
    }

    public void setVideoFromUri(Context context, Uri uri) {
        reset();
        try {
            this.mediaPlayer.setDataSource(context, uri);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(context, uri);
            onDataSourceSet(mediaMetadataRetriever);
        } catch (IOException e) {
            Log.e(TAG, e.getMessage(), e);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.autoPlayAfterResume && this.playAfterResume) {
            this.playAfterResume = false;
            start();
        }
    }

    public void onPause() {
        super.onPause();
        this.handler.removeCallbacks(this.timeDetector);
        if (isPlaying() && this.autoPlayAfterResume) {
            this.playAfterResume = true;
        }
        pause();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
        this.handler.removeCallbacks(this.timeDetector);
        TransparentVideoViewManager.destroyView((LinearLayout) getParent());
    }

    private void prepareAsync(final MediaPlayer.OnPreparedListener onPreparedListener) {
        if ((this.mediaPlayer != null && this.state == PlayerState.NOT_PREPARED) || this.state == PlayerState.STOPPED) {
            this.mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer mediaPlayer) {
                    PlayerState unused = AlphaMovieView.this.state = PlayerState.PREPARED;
                    onPreparedListener.onPrepared(mediaPlayer);
                }
            });
            this.mediaPlayer.prepareAsync();
        }
    }

    /* access modifiers changed from: private */
    public void startTimeDetector() {
        this.handler.postDelayed(this.timeDetector, 100);
    }

    /* renamed from: com.transparentvideo.AlphaMovieView$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$com$transparentvideo$AlphaMovieView$PlayerState;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.transparentvideo.AlphaMovieView$PlayerState[] r0 = com.transparentvideo.AlphaMovieView.PlayerState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$transparentvideo$AlphaMovieView$PlayerState = r0
                com.transparentvideo.AlphaMovieView$PlayerState r1 = com.transparentvideo.AlphaMovieView.PlayerState.PREPARED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$transparentvideo$AlphaMovieView$PlayerState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.transparentvideo.AlphaMovieView$PlayerState r1 = com.transparentvideo.AlphaMovieView.PlayerState.PAUSED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$transparentvideo$AlphaMovieView$PlayerState     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.transparentvideo.AlphaMovieView$PlayerState r1 = com.transparentvideo.AlphaMovieView.PlayerState.STOPPED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transparentvideo.AlphaMovieView.AnonymousClass7.<clinit>():void");
        }
    }

    public void start() {
        if (this.mediaPlayer != null) {
            int i = AnonymousClass7.$SwitchMap$com$transparentvideo$AlphaMovieView$PlayerState[this.state.ordinal()];
            if (i == 1) {
                this.mediaPlayer.start();
                startTimeDetector();
                this.state = PlayerState.STARTED;
                OnVideoStartedListener onVideoStartedListener2 = this.onVideoStartedListener;
                if (onVideoStartedListener2 != null) {
                    onVideoStartedListener2.onVideoStarted();
                }
            } else if (i == 2) {
                this.mediaPlayer.start();
                startTimeDetector();
                this.state = PlayerState.STARTED;
            } else if (i == 3) {
                prepareAsync(new MediaPlayer.OnPreparedListener() {
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        AlphaMovieView.this.mediaPlayer.start();
                        AlphaMovieView.this.startTimeDetector();
                        PlayerState unused = AlphaMovieView.this.state = PlayerState.STARTED;
                        if (AlphaMovieView.this.onVideoStartedListener != null) {
                            AlphaMovieView.this.onVideoStartedListener.onVideoStarted();
                        }
                    }
                });
            }
        }
    }

    public void pause() {
        if (this.mediaPlayer != null && this.state == PlayerState.STARTED) {
            this.mediaPlayer.pause();
            this.state = PlayerState.PAUSED;
        }
    }

    public void stop() {
        if (this.mediaPlayer == null) {
            return;
        }
        if (this.state == PlayerState.STARTED || this.state == PlayerState.PAUSED) {
            this.mediaPlayer.stop();
            this.state = PlayerState.STOPPED;
        }
    }

    public void reset() {
        if (this.mediaPlayer == null) {
            return;
        }
        if (this.state == PlayerState.STARTED || this.state == PlayerState.PAUSED || this.state == PlayerState.STOPPED) {
            this.mediaPlayer.reset();
            this.state = PlayerState.NOT_PREPARED;
        }
    }

    public void release() {
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.release();
            this.state = PlayerState.RELEASE;
        }
    }

    public PlayerState getState() {
        return this.state;
    }

    public boolean isPlaying() {
        return this.state == PlayerState.STARTED;
    }

    public boolean isPaused() {
        return this.state == PlayerState.PAUSED;
    }

    public boolean isStopped() {
        return this.state == PlayerState.STOPPED;
    }

    public boolean isReleased() {
        return this.state == PlayerState.RELEASE;
    }

    public void seekTo(int i) {
        this.mediaPlayer.seekTo(i);
    }

    public void setLooping(boolean z) {
        this.mediaPlayer.setLooping(z);
    }

    public int getCurrentPosition() {
        return this.mediaPlayer.getCurrentPosition();
    }

    public void setScreenOnWhilePlaying(boolean z) {
        this.mediaPlayer.setScreenOnWhilePlaying(z);
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.mediaPlayer.setOnErrorListener(onErrorListener);
    }

    public void setOnVideoStartedListener(OnVideoStartedListener onVideoStartedListener2) {
        this.onVideoStartedListener = onVideoStartedListener2;
    }

    public void setOnVideoEndedListener(OnVideoEndedListener onVideoEndedListener2) {
        this.onVideoEndedListener = onVideoEndedListener2;
    }

    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mediaPlayer.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    public void setLoopSeekingMethod(int i) {
        this.loopSeekingMethod = i;
    }

    public int getLoopSeekingMethod() {
        return this.loopSeekingMethod;
    }

    public MediaPlayer getMediaPlayer() {
        return this.mediaPlayer;
    }
}
