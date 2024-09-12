package expo.modules.camera;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\f8\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0007R \u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lexpo/modules/camera/RecordingOptions;", "Lexpo/modules/kotlin/records/Record;", "()V", "maxDuration", "", "getMaxDuration$annotations", "getMaxDuration", "()I", "maxFileSize", "getMaxFileSize$annotations", "getMaxFileSize", "muteValue", "", "getMuteValue$annotations", "getMuteValue", "()Z", "quality", "getQuality$annotations", "getQuality", "videoBitrate", "getVideoBitrate$annotations", "getVideoBitrate", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "expo-camera_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Options.kt */
public final class RecordingOptions implements Record {
    private final int maxDuration = -1;
    private final int maxFileSize = -1;
    private final boolean muteValue;
    private final int quality = 1;
    private final Integer videoBitrate;

    @Field
    public static /* synthetic */ void getMaxDuration$annotations() {
    }

    @Field
    public static /* synthetic */ void getMaxFileSize$annotations() {
    }

    @Field
    public static /* synthetic */ void getMuteValue$annotations() {
    }

    @Field
    public static /* synthetic */ void getQuality$annotations() {
    }

    @Field
    public static /* synthetic */ void getVideoBitrate$annotations() {
    }

    public final int getMaxDuration() {
        return this.maxDuration;
    }

    public final int getMaxFileSize() {
        return this.maxFileSize;
    }

    public final int getQuality() {
        return this.quality;
    }

    public final boolean getMuteValue() {
        return this.muteValue;
    }

    public final Integer getVideoBitrate() {
        return this.videoBitrate;
    }
}
