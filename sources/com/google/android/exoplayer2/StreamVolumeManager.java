package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;

final class StreamVolumeManager {
    private static final String TAG = "StreamVolumeManager";
    private static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
    private static final int VOLUME_FLAGS = 1;
    private final Context applicationContext;
    private final AudioManager audioManager;
    /* access modifiers changed from: private */
    public final Handler eventHandler;
    private final Listener listener;
    private boolean muted;
    private VolumeChangeReceiver receiver;
    private int streamType = 3;
    private int volume;

    public interface Listener {
        void onStreamTypeChanged(int i);

        void onStreamVolumeChanged(int i, boolean z);
    }

    public StreamVolumeManager(Context context, Handler handler, Listener listener2) {
        Context applicationContext2 = context.getApplicationContext();
        this.applicationContext = applicationContext2;
        this.eventHandler = handler;
        this.listener = listener2;
        AudioManager audioManager2 = (AudioManager) Assertions.checkStateNotNull((AudioManager) applicationContext2.getSystemService("audio"));
        this.audioManager = audioManager2;
        this.volume = getVolumeFromManager(audioManager2, 3);
        this.muted = getMutedFromManager(audioManager2, this.streamType);
        VolumeChangeReceiver volumeChangeReceiver = new VolumeChangeReceiver();
        try {
            applicationContext2.registerReceiver(volumeChangeReceiver, new IntentFilter(VOLUME_CHANGED_ACTION));
            this.receiver = volumeChangeReceiver;
        } catch (RuntimeException e) {
            Log.w(TAG, "Error registering stream volume receiver", e);
        }
    }

    public void setStreamType(int i) {
        if (this.streamType != i) {
            this.streamType = i;
            updateVolumeAndNotifyIfChanged();
            this.listener.onStreamTypeChanged(i);
        }
    }

    public int getMinVolume() {
        if (Util.SDK_INT >= 28) {
            return this.audioManager.getStreamMinVolume(this.streamType);
        }
        return 0;
    }

    public int getMaxVolume() {
        return this.audioManager.getStreamMaxVolume(this.streamType);
    }

    public int getVolume() {
        return this.volume;
    }

    public boolean isMuted() {
        return this.muted;
    }

    public void setVolume(int i) {
        if (i >= getMinVolume() && i <= getMaxVolume()) {
            this.audioManager.setStreamVolume(this.streamType, i, 1);
            updateVolumeAndNotifyIfChanged();
        }
    }

    public void increaseVolume() {
        if (this.volume < getMaxVolume()) {
            this.audioManager.adjustStreamVolume(this.streamType, 1, 1);
            updateVolumeAndNotifyIfChanged();
        }
    }

    public void decreaseVolume() {
        if (this.volume > getMinVolume()) {
            this.audioManager.adjustStreamVolume(this.streamType, -1, 1);
            updateVolumeAndNotifyIfChanged();
        }
    }

    public void setMuted(boolean z) {
        if (Util.SDK_INT >= 23) {
            this.audioManager.adjustStreamVolume(this.streamType, z ? -100 : 100, 1);
        } else {
            this.audioManager.setStreamMute(this.streamType, z);
        }
        updateVolumeAndNotifyIfChanged();
    }

    public void release() {
        VolumeChangeReceiver volumeChangeReceiver = this.receiver;
        if (volumeChangeReceiver != null) {
            try {
                this.applicationContext.unregisterReceiver(volumeChangeReceiver);
            } catch (RuntimeException e) {
                Log.w(TAG, "Error unregistering stream volume receiver", e);
            }
            this.receiver = null;
        }
    }

    /* access modifiers changed from: private */
    public void updateVolumeAndNotifyIfChanged() {
        int volumeFromManager = getVolumeFromManager(this.audioManager, this.streamType);
        boolean mutedFromManager = getMutedFromManager(this.audioManager, this.streamType);
        if (this.volume != volumeFromManager || this.muted != mutedFromManager) {
            this.volume = volumeFromManager;
            this.muted = mutedFromManager;
            this.listener.onStreamVolumeChanged(volumeFromManager, mutedFromManager);
        }
    }

    private static int getVolumeFromManager(AudioManager audioManager2, int i) {
        try {
            return audioManager2.getStreamVolume(i);
        } catch (RuntimeException e) {
            Log.w(TAG, "Could not retrieve stream volume for stream type " + i, e);
            return audioManager2.getStreamMaxVolume(i);
        }
    }

    private static boolean getMutedFromManager(AudioManager audioManager2, int i) {
        if (Util.SDK_INT >= 23) {
            return audioManager2.isStreamMute(i);
        }
        return getVolumeFromManager(audioManager2, i) == 0;
    }

    private final class VolumeChangeReceiver extends BroadcastReceiver {
        private VolumeChangeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            StreamVolumeManager.this.eventHandler.post(new StreamVolumeManager$VolumeChangeReceiver$$ExternalSyntheticLambda0(StreamVolumeManager.this));
        }
    }
}
