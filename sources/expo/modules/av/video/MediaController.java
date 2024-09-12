package expo.modules.av.video;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.launchdarkly.sdk.android.LDConfig;
import expo.modules.av.R;
import expo.modules.av.player.PlayerDataControl;
import java.lang.ref.WeakReference;
import java.util.Formatter;
import java.util.Locale;

public class MediaController extends FrameLayout {
    private static final int FADE_OUT = 1;
    private static final int SHOW_PROGRESS = 2;
    private static final int sDefaultTimeout = 3000;
    private ViewGroup mAnchor;
    private Context mContext;
    /* access modifiers changed from: private */
    public TextView mCurrentTime;
    /* access modifiers changed from: private */
    public boolean mDragging;
    private TextView mEndTime;
    private ImageButton mFastForwardButton;
    private View.OnClickListener mFfwdListener;
    private StringBuilder mFormatBuilder;
    private Formatter mFormatter;
    private boolean mFromXml;
    private ImageButton mFullscreenButton;
    private View.OnClickListener mFullscreenListener;
    /* access modifiers changed from: private */
    public Handler mHandler;
    private boolean mListenersSet;
    private ImageButton mNextButton;
    private View.OnClickListener mNextListener;
    private ImageButton mPauseButton;
    private View.OnClickListener mPauseListener;
    /* access modifiers changed from: private */
    public PlayerDataControl mPlayer;
    private ImageButton mPrevButton;
    private View.OnClickListener mPrevListener;
    private ProgressBar mProgress;
    private View.OnClickListener mRewListener;
    private ImageButton mRewindButton;
    private View mRoot;
    private SeekBar.OnSeekBarChangeListener mSeekListener;
    /* access modifiers changed from: private */
    public boolean mShowing;
    private boolean mUseFastForward;

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new MessageHandler(this);
        this.mPauseListener = new View.OnClickListener() {
            public void onClick(View view) {
                MediaController.this.show(3000);
                MediaController.this.doPauseResume();
            }
        };
        this.mFullscreenListener = new View.OnClickListener() {
            public void onClick(View view) {
                MediaController.this.show(3000);
                MediaController.this.doToggleFullscreen();
            }
        };
        this.mSeekListener = new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.show(LDConfig.DEFAULT_BACKGROUND_POLL_INTERVAL_MILLIS);
                MediaController.this.mDragging = true;
                MediaController.this.mHandler.removeMessages(2);
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (MediaController.this.mPlayer != null && z) {
                    int duration = (int) ((((long) MediaController.this.mPlayer.getDuration()) * ((long) i)) / 1000);
                    MediaController.this.mPlayer.seekTo(duration);
                    if (MediaController.this.mCurrentTime != null) {
                        MediaController.this.mCurrentTime.setText(MediaController.this.stringForTime(duration));
                    }
                }
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                MediaController.this.mDragging = false;
                int unused = MediaController.this.setProgress();
                MediaController.this.updatePausePlay();
                MediaController.this.show(3000);
                MediaController.this.mHandler.sendEmptyMessage(2);
            }
        };
        this.mRewListener = new View.OnClickListener() {
            public void onClick(View view) {
                if (MediaController.this.mPlayer != null) {
                    MediaController.this.mPlayer.seekTo(MediaController.this.mPlayer.getCurrentPosition() - 5000);
                    int unused = MediaController.this.setProgress();
                    MediaController.this.show(3000);
                }
            }
        };
        this.mFfwdListener = new View.OnClickListener() {
            public void onClick(View view) {
                if (MediaController.this.mPlayer != null) {
                    MediaController.this.mPlayer.seekTo(MediaController.this.mPlayer.getCurrentPosition() + 15000);
                    int unused = MediaController.this.setProgress();
                    MediaController.this.show(3000);
                }
            }
        };
        this.mRoot = null;
        this.mContext = context;
        this.mUseFastForward = true;
        this.mFromXml = true;
    }

    public MediaController(Context context, boolean z) {
        super(context);
        this.mHandler = new MessageHandler(this);
        this.mPauseListener = new View.OnClickListener() {
            public void onClick(View view) {
                MediaController.this.show(3000);
                MediaController.this.doPauseResume();
            }
        };
        this.mFullscreenListener = new View.OnClickListener() {
            public void onClick(View view) {
                MediaController.this.show(3000);
                MediaController.this.doToggleFullscreen();
            }
        };
        this.mSeekListener = new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.show(LDConfig.DEFAULT_BACKGROUND_POLL_INTERVAL_MILLIS);
                MediaController.this.mDragging = true;
                MediaController.this.mHandler.removeMessages(2);
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (MediaController.this.mPlayer != null && z) {
                    int duration = (int) ((((long) MediaController.this.mPlayer.getDuration()) * ((long) i)) / 1000);
                    MediaController.this.mPlayer.seekTo(duration);
                    if (MediaController.this.mCurrentTime != null) {
                        MediaController.this.mCurrentTime.setText(MediaController.this.stringForTime(duration));
                    }
                }
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                MediaController.this.mDragging = false;
                int unused = MediaController.this.setProgress();
                MediaController.this.updatePausePlay();
                MediaController.this.show(3000);
                MediaController.this.mHandler.sendEmptyMessage(2);
            }
        };
        this.mRewListener = new View.OnClickListener() {
            public void onClick(View view) {
                if (MediaController.this.mPlayer != null) {
                    MediaController.this.mPlayer.seekTo(MediaController.this.mPlayer.getCurrentPosition() - 5000);
                    int unused = MediaController.this.setProgress();
                    MediaController.this.show(3000);
                }
            }
        };
        this.mFfwdListener = new View.OnClickListener() {
            public void onClick(View view) {
                if (MediaController.this.mPlayer != null) {
                    MediaController.this.mPlayer.seekTo(MediaController.this.mPlayer.getCurrentPosition() + 15000);
                    int unused = MediaController.this.setProgress();
                    MediaController.this.show(3000);
                }
            }
        };
        this.mContext = context;
        this.mUseFastForward = z;
    }

    public MediaController(Context context) {
        this(context, true);
    }

    public void onFinishInflate() {
        View view = this.mRoot;
        if (view != null) {
            initControllerView(view);
        }
        super.onFinishInflate();
    }

    public void setMediaPlayer(PlayerDataControl playerDataControl) {
        this.mPlayer = playerDataControl;
        updateControls();
    }

    public void updateControls() {
        setProgress();
        updatePausePlay();
        updateFullScreen();
    }

    public void setAnchorView(ViewGroup viewGroup) {
        this.mAnchor = viewGroup;
        if (this.mRoot == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
            removeAllViews();
            addView(makeControllerView(), layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public View makeControllerView() {
        View inflate = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.expo_media_controller, (ViewGroup) null);
        this.mRoot = inflate;
        initControllerView(inflate);
        return this.mRoot;
    }

    private void initControllerView(View view) {
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.play_button);
        this.mPauseButton = imageButton;
        if (imageButton != null) {
            imageButton.requestFocus();
            this.mPauseButton.setOnClickListener(this.mPauseListener);
        }
        ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.fullscreen_mode_button);
        this.mFullscreenButton = imageButton2;
        if (imageButton2 != null) {
            imageButton2.requestFocus();
            this.mFullscreenButton.setOnClickListener(this.mFullscreenListener);
        }
        ImageButton imageButton3 = (ImageButton) view.findViewById(R.id.fast_forward_button);
        this.mFastForwardButton = imageButton3;
        int i = 0;
        if (imageButton3 != null) {
            imageButton3.setOnClickListener(this.mFfwdListener);
            if (!this.mFromXml) {
                this.mFastForwardButton.setVisibility(this.mUseFastForward ? 0 : 8);
            }
        }
        ImageButton imageButton4 = (ImageButton) view.findViewById(R.id.rewind_button);
        this.mRewindButton = imageButton4;
        if (imageButton4 != null) {
            imageButton4.setOnClickListener(this.mRewListener);
            if (!this.mFromXml) {
                ImageButton imageButton5 = this.mRewindButton;
                if (!this.mUseFastForward) {
                    i = 8;
                }
                imageButton5.setVisibility(i);
            }
        }
        ImageButton imageButton6 = (ImageButton) view.findViewById(R.id.skip_next_button);
        this.mNextButton = imageButton6;
        if (imageButton6 != null && !this.mFromXml && !this.mListenersSet) {
            imageButton6.setVisibility(8);
        }
        ImageButton imageButton7 = (ImageButton) view.findViewById(R.id.skip_previous_button);
        this.mPrevButton = imageButton7;
        if (imageButton7 != null && !this.mFromXml && !this.mListenersSet) {
            imageButton7.setVisibility(8);
        }
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.seek_bar);
        this.mProgress = progressBar;
        if (progressBar != null) {
            if (progressBar instanceof SeekBar) {
                ((SeekBar) progressBar).setOnSeekBarChangeListener(this.mSeekListener);
            }
            this.mProgress.setMax(1000);
        }
        this.mEndTime = (TextView) view.findViewById(R.id.end_time_text);
        this.mCurrentTime = (TextView) view.findViewById(R.id.current_time_text);
        this.mFormatBuilder = new StringBuilder();
        this.mFormatter = new Formatter(this.mFormatBuilder, Locale.getDefault());
        installPrevNextListeners();
    }

    public void show() {
        show(3000);
    }

    private void disableUnsupportedButtons() {
        PlayerDataControl playerDataControl = this.mPlayer;
        if (playerDataControl != null) {
            try {
                if (this.mPauseButton != null && !playerDataControl.canPause()) {
                    this.mPauseButton.setEnabled(false);
                }
                if (this.mRewindButton != null && !this.mPlayer.canSeekBackward()) {
                    this.mRewindButton.setEnabled(false);
                }
                if (this.mFastForwardButton != null && !this.mPlayer.canSeekForward()) {
                    this.mFastForwardButton.setEnabled(false);
                }
            } catch (IncompatibleClassChangeError unused) {
            }
        }
    }

    public void show(int i) {
        if (!this.mShowing && this.mAnchor != null) {
            setProgress();
            ImageButton imageButton = this.mPauseButton;
            if (imageButton != null) {
                imageButton.requestFocus();
            }
            disableUnsupportedButtons();
            this.mAnchor.addView(this, new FrameLayout.LayoutParams(-1, -1));
            this.mShowing = true;
        }
        updateControls();
        this.mHandler.sendEmptyMessage(2);
        Message obtainMessage = this.mHandler.obtainMessage(1);
        if (i != 0) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(obtainMessage, (long) i);
        }
    }

    public boolean isShowing() {
        return this.mShowing;
    }

    public void hide() {
        ViewGroup viewGroup = this.mAnchor;
        if (viewGroup != null) {
            try {
                viewGroup.removeView(this);
                this.mHandler.removeMessages(2);
            } catch (IllegalArgumentException unused) {
                Log.w("MediaController", "already removed");
            }
            this.mShowing = false;
        }
    }

    /* access modifiers changed from: private */
    public String stringForTime(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.mFormatBuilder.setLength(0);
        if (i5 > 0) {
            return this.mFormatter.format("%d:%02d:%02d", new Object[]{Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)}).toString();
        }
        return this.mFormatter.format("%02d:%02d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3)}).toString();
    }

    /* access modifiers changed from: private */
    public int setProgress() {
        PlayerDataControl playerDataControl = this.mPlayer;
        if (playerDataControl == null || this.mDragging) {
            return 0;
        }
        int currentPosition = playerDataControl.getCurrentPosition();
        int duration = this.mPlayer.getDuration();
        ProgressBar progressBar = this.mProgress;
        if (progressBar != null) {
            if (duration > 0) {
                progressBar.setProgress((int) ((((long) currentPosition) * 1000) / ((long) duration)));
            }
            this.mProgress.setSecondaryProgress(this.mPlayer.getBufferPercentage() * 10);
        }
        TextView textView = this.mEndTime;
        if (textView != null) {
            textView.setText(stringForTime(duration));
        }
        TextView textView2 = this.mCurrentTime;
        if (textView2 != null) {
            textView2.setText(stringForTime(currentPosition));
        }
        return currentPosition;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return true;
        }
        show(3000);
        return true;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        show(3000);
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.mPlayer != null && isEnabled()) {
            int keyCode = keyEvent.getKeyCode();
            boolean z = keyEvent.getRepeatCount() == 0 && keyEvent.getAction() == 0;
            if (keyCode == 79 || keyCode == 85 || keyCode == 62) {
                if (z) {
                    doPauseResume();
                    show(3000);
                    ImageButton imageButton = this.mPauseButton;
                    if (imageButton != null) {
                        imageButton.requestFocus();
                    }
                }
            } else if (keyCode == 126) {
                if (z && !this.mPlayer.isPlaying()) {
                    this.mPlayer.start();
                    updatePausePlay();
                    show(3000);
                }
                return true;
            } else if (keyCode == 86 || keyCode == 127) {
                if (z && this.mPlayer.isPlaying()) {
                    this.mPlayer.pause();
                    updatePausePlay();
                    show(3000);
                }
                return true;
            } else if (keyCode == 25 || keyCode == 24 || keyCode == 164) {
                return super.dispatchKeyEvent(keyEvent);
            } else {
                if (keyCode == 4 || keyCode == 82) {
                    if (z) {
                        hide();
                    }
                    return true;
                }
                show(3000);
                return super.dispatchKeyEvent(keyEvent);
            }
        }
        return true;
    }

    public void updatePausePlay() {
        PlayerDataControl playerDataControl;
        if (this.mRoot != null && this.mPauseButton != null && (playerDataControl = this.mPlayer) != null) {
            if (playerDataControl.isPlaying()) {
                this.mPauseButton.setImageResource(R.drawable.exo_controls_pause);
            } else {
                this.mPauseButton.setImageResource(R.drawable.exo_controls_play);
            }
        }
    }

    public void updateFullScreen() {
        PlayerDataControl playerDataControl;
        if (this.mRoot != null && this.mFullscreenButton != null && (playerDataControl = this.mPlayer) != null) {
            if (playerDataControl.isFullscreen()) {
                this.mFullscreenButton.setImageResource(R.drawable.ic_fullscreen_exit_32dp);
            } else {
                this.mFullscreenButton.setImageResource(R.drawable.ic_fullscreen_32dp);
            }
        }
    }

    /* access modifiers changed from: private */
    public void doPauseResume() {
        PlayerDataControl playerDataControl = this.mPlayer;
        if (playerDataControl != null) {
            if (playerDataControl.isPlaying()) {
                this.mPlayer.pause();
            } else {
                this.mPlayer.start();
            }
            updatePausePlay();
        }
    }

    /* access modifiers changed from: private */
    public void doToggleFullscreen() {
        PlayerDataControl playerDataControl = this.mPlayer;
        if (playerDataControl != null) {
            playerDataControl.toggleFullscreen();
        }
    }

    public void setEnabled(boolean z) {
        ImageButton imageButton = this.mPauseButton;
        if (imageButton != null) {
            imageButton.setEnabled(z);
        }
        ImageButton imageButton2 = this.mFastForwardButton;
        if (imageButton2 != null) {
            imageButton2.setEnabled(z);
        }
        ImageButton imageButton3 = this.mRewindButton;
        if (imageButton3 != null) {
            imageButton3.setEnabled(z);
        }
        ImageButton imageButton4 = this.mNextButton;
        boolean z2 = true;
        if (imageButton4 != null) {
            imageButton4.setEnabled(z && this.mNextListener != null);
        }
        ImageButton imageButton5 = this.mPrevButton;
        if (imageButton5 != null) {
            if (!z || this.mPrevListener == null) {
                z2 = false;
            }
            imageButton5.setEnabled(z2);
        }
        ProgressBar progressBar = this.mProgress;
        if (progressBar != null) {
            progressBar.setEnabled(z);
        }
        disableUnsupportedButtons();
        super.setEnabled(z);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(MediaController.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(MediaController.class.getName());
    }

    private void installPrevNextListeners() {
        ImageButton imageButton = this.mNextButton;
        boolean z = true;
        if (imageButton != null) {
            imageButton.setOnClickListener(this.mNextListener);
            this.mNextButton.setEnabled(this.mNextListener != null);
        }
        ImageButton imageButton2 = this.mPrevButton;
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(this.mPrevListener);
            ImageButton imageButton3 = this.mPrevButton;
            if (this.mPrevListener == null) {
                z = false;
            }
            imageButton3.setEnabled(z);
        }
    }

    public void setPrevNextListeners(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.mNextListener = onClickListener;
        this.mPrevListener = onClickListener2;
        this.mListenersSet = true;
        if (this.mRoot != null) {
            installPrevNextListeners();
            ImageButton imageButton = this.mNextButton;
            if (imageButton != null && !this.mFromXml) {
                imageButton.setVisibility(0);
            }
            ImageButton imageButton2 = this.mPrevButton;
            if (imageButton2 != null && !this.mFromXml) {
                imageButton2.setVisibility(0);
            }
        }
    }

    private static class MessageHandler extends Handler {
        private final WeakReference<MediaController> mView;

        MessageHandler(MediaController mediaController) {
            this.mView = new WeakReference<>(mediaController);
        }

        public void handleMessage(Message message) {
            MediaController mediaController = (MediaController) this.mView.get();
            if (mediaController != null && mediaController.mPlayer != null) {
                int i = message.what;
                if (i == 1) {
                    mediaController.hide();
                } else if (i == 2) {
                    int r4 = mediaController.setProgress();
                    if (!mediaController.mDragging && mediaController.mShowing && mediaController.mPlayer.isPlaying()) {
                        sendMessageDelayed(obtainMessage(2), (long) (1000 - (r4 % 1000)));
                    }
                }
            }
        }
    }
}
