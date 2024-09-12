package androidx.media;

import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;

public final class AudioManagerCompat {
    public static final int AUDIOFOCUS_GAIN = 1;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT_EXCLUSIVE = 4;
    public static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
    private static final String TAG = "AudioManCompat";

    public static int requestAudioFocus(AudioManager audioManager, AudioFocusRequestCompat audioFocusRequestCompat) {
        if (audioManager == null) {
            throw new IllegalArgumentException("AudioManager must not be null");
        } else if (audioFocusRequestCompat == null) {
            throw new IllegalArgumentException("AudioFocusRequestCompat must not be null");
        } else if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.requestAudioFocus(audioManager, audioFocusRequestCompat.getAudioFocusRequest());
        } else {
            return audioManager.requestAudioFocus(audioFocusRequestCompat.getOnAudioFocusChangeListener(), audioFocusRequestCompat.getAudioAttributesCompat().getLegacyStreamType(), audioFocusRequestCompat.getFocusGain());
        }
    }

    public static int abandonAudioFocusRequest(AudioManager audioManager, AudioFocusRequestCompat audioFocusRequestCompat) {
        if (audioManager == null) {
            throw new IllegalArgumentException("AudioManager must not be null");
        } else if (audioFocusRequestCompat == null) {
            throw new IllegalArgumentException("AudioFocusRequestCompat must not be null");
        } else if (Build.VERSION.SDK_INT >= 26) {
            return Api26Impl.abandonAudioFocusRequest(audioManager, audioFocusRequestCompat.getAudioFocusRequest());
        } else {
            return audioManager.abandonAudioFocus(audioFocusRequestCompat.getOnAudioFocusChangeListener());
        }
    }

    public static int getStreamMaxVolume(AudioManager audioManager, int i) {
        return audioManager.getStreamMaxVolume(i);
    }

    public static int getStreamMinVolume(AudioManager audioManager, int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getStreamMinVolume(audioManager, i);
        }
        return 0;
    }

    private AudioManagerCompat() {
    }

    private static class Api26Impl {
        private Api26Impl() {
        }

        static int abandonAudioFocusRequest(AudioManager audioManager, AudioFocusRequest audioFocusRequest) {
            return audioManager.abandonAudioFocusRequest(audioFocusRequest);
        }

        static int requestAudioFocus(AudioManager audioManager, AudioFocusRequest audioFocusRequest) {
            return audioManager.requestAudioFocus(audioFocusRequest);
        }
    }

    private static class Api28Impl {
        private Api28Impl() {
        }

        static int getStreamMinVolume(AudioManager audioManager, int i) {
            return audioManager.getStreamMinVolume(i);
        }
    }
}
