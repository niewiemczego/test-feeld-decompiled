package expo.modules.av.video;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lexpo/modules/av/video/FullscreenPlayerUpdate;", "", "jsValue", "", "(Ljava/lang/String;II)V", "getJsValue", "()I", "FULLSCREEN_PLAYER_WILL_PRESENT", "FULLSCREEN_PLAYER_DID_PRESENT", "FULLSCREEN_PLAYER_WILL_DISMISS", "FULLSCREEN_PLAYER_DID_DISMISS", "expo-av_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FullscreenPlayerUpdate.kt */
public enum FullscreenPlayerUpdate {
    FULLSCREEN_PLAYER_WILL_PRESENT(0),
    FULLSCREEN_PLAYER_DID_PRESENT(1),
    FULLSCREEN_PLAYER_WILL_DISMISS(2),
    FULLSCREEN_PLAYER_DID_DISMISS(3);
    
    private final int jsValue;

    private FullscreenPlayerUpdate(int i) {
        this.jsValue = i;
    }

    public final int getJsValue() {
        return this.jsValue;
    }
}
