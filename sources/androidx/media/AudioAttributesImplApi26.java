package androidx.media;

import android.media.AudioAttributes;
import androidx.media.AudioAttributesImplApi21;

public class AudioAttributesImplApi26 extends AudioAttributesImplApi21 {
    public AudioAttributesImplApi26() {
    }

    AudioAttributesImplApi26(AudioAttributes audioAttributes) {
        super(audioAttributes, -1);
    }

    public int getVolumeControlStream() {
        return this.mAudioAttributes.getVolumeControlStream();
    }

    static class Builder extends AudioAttributesImplApi21.Builder {
        Builder() {
        }

        Builder(Object obj) {
            super(obj);
        }

        public AudioAttributesImpl build() {
            return new AudioAttributesImplApi26(this.mFwkBuilder.build());
        }

        public Builder setUsage(int i) {
            this.mFwkBuilder.setUsage(i);
            return this;
        }
    }
}
