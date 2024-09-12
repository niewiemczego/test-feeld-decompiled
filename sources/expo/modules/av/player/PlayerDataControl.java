package expo.modules.av.player;

import android.os.Bundle;
import android.widget.MediaController;
import expo.modules.core.Promise;

public class PlayerDataControl implements MediaController.MediaPlayerControl {
    private final PlayerData mPlayerData;

    public boolean canPause() {
        return true;
    }

    public boolean canSeekBackward() {
        return true;
    }

    public boolean canSeekForward() {
        return true;
    }

    public PlayerDataControl(PlayerData playerData) {
        this.mPlayerData = playerData;
    }

    public void start() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("shouldPlay", true);
        this.mPlayerData.setStatus(bundle, (Promise) null);
    }

    public void pause() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("shouldPlay", false);
        this.mPlayerData.setStatus(bundle, (Promise) null);
    }

    public int getDuration() {
        Bundle status = this.mPlayerData.getStatus();
        if (!status.getBoolean("isLoaded") || !status.containsKey("durationMillis")) {
            return 0;
        }
        return status.getInt("durationMillis");
    }

    public int getCurrentPosition() {
        Bundle status = this.mPlayerData.getStatus();
        if (status.getBoolean("isLoaded")) {
            return status.getInt("positionMillis");
        }
        return 0;
    }

    public void seekTo(int i) {
        Bundle bundle = new Bundle();
        bundle.putDouble("positionMillis", (double) i);
        this.mPlayerData.setStatus(bundle, (Promise) null);
    }

    public boolean isPlaying() {
        Bundle status = this.mPlayerData.getStatus();
        return status.getBoolean("isLoaded") && status.getBoolean(PlayerData.STATUS_IS_PLAYING_KEY_PATH);
    }

    public int getBufferPercentage() {
        Bundle status = this.mPlayerData.getStatus();
        if (!status.getBoolean("isLoaded") || !status.containsKey("durationMillis") || !status.containsKey("playableDurationMillis")) {
            return 0;
        }
        return (int) ((((double) status.getInt("playableDurationMillis")) / ((double) status.getInt("durationMillis"))) * 100.0d);
    }

    public int getAudioSessionId() {
        return this.mPlayerData.getAudioSessionId();
    }

    public boolean isFullscreen() {
        return this.mPlayerData.isPresentedFullscreen();
    }

    public void toggleFullscreen() {
        this.mPlayerData.toggleFullscreen();
    }
}
