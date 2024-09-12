package expo.modules.camera;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R*\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u00020\u000b8\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\u000b8\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u00020\u000b8\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u000eR \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0004¢\u0006\u0010\n\u0002\u0010\u001a\u0012\u0004\b\u0017\u0010\u0002\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\u00020\u00168\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0002\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u00020 8\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0002\u001a\u0004\b\"\u0010#R\u001c\u0010$\u001a\u00020\u000b8\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0002\u001a\u0004\b&\u0010\u000e¨\u0006'"}, d2 = {"Lexpo/modules/camera/PictureOptions;", "Lexpo/modules/kotlin/records/Record;", "()V", "additionalExif", "", "", "", "getAdditionalExif$annotations", "getAdditionalExif", "()Ljava/util/Map;", "base64", "", "getBase64$annotations", "getBase64", "()Z", "exif", "getExif$annotations", "getExif", "fastMode", "getFastMode$annotations", "getFastMode", "id", "", "getId$annotations", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "maxDownsampling", "getMaxDownsampling$annotations", "getMaxDownsampling", "()I", "quality", "", "getQuality$annotations", "getQuality", "()D", "skipProcessing", "getSkipProcessing$annotations", "getSkipProcessing", "expo-camera_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Options.kt */
public final class PictureOptions implements Record {
    private final Map<String, Object> additionalExif;
    private final boolean base64;
    private final boolean exif;
    private final boolean fastMode;
    private final Integer id;
    private final int maxDownsampling = 1;
    private final double quality = 1.0d;
    private final boolean skipProcessing;

    @Field
    public static /* synthetic */ void getAdditionalExif$annotations() {
    }

    @Field
    public static /* synthetic */ void getBase64$annotations() {
    }

    @Field
    public static /* synthetic */ void getExif$annotations() {
    }

    @Field
    public static /* synthetic */ void getFastMode$annotations() {
    }

    @Field
    public static /* synthetic */ void getId$annotations() {
    }

    @Field
    public static /* synthetic */ void getMaxDownsampling$annotations() {
    }

    @Field
    public static /* synthetic */ void getQuality$annotations() {
    }

    @Field
    public static /* synthetic */ void getSkipProcessing$annotations() {
    }

    public final double getQuality() {
        return this.quality;
    }

    public final boolean getBase64() {
        return this.base64;
    }

    public final boolean getExif() {
        return this.exif;
    }

    public final Map<String, Object> getAdditionalExif() {
        return this.additionalExif;
    }

    public final boolean getSkipProcessing() {
        return this.skipProcessing;
    }

    public final boolean getFastMode() {
        return this.fastMode;
    }

    public final Integer getId() {
        return this.id;
    }

    public final int getMaxDownsampling() {
        return this.maxDownsampling;
    }
}
