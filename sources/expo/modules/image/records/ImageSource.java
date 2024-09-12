package expo.modules.image.records;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\f¨\u0006\u001f"}, d2 = {"Lexpo/modules/image/records/ImageSource;", "Lexpo/modules/kotlin/records/Record;", "url", "", "width", "", "height", "mediaType", "(Ljava/lang/String;IILjava/lang/String;)V", "getHeight$annotations", "()V", "getHeight", "()I", "getMediaType$annotations", "getMediaType", "()Ljava/lang/String;", "getUrl$annotations", "getUrl", "getWidth$annotations", "getWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: events.kt */
public final class ImageSource implements Record {
    private final int height;
    private final String mediaType;
    private final String url;
    private final int width;

    public static /* synthetic */ ImageSource copy$default(ImageSource imageSource, String str, int i, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = imageSource.url;
        }
        if ((i3 & 2) != 0) {
            i = imageSource.width;
        }
        if ((i3 & 4) != 0) {
            i2 = imageSource.height;
        }
        if ((i3 & 8) != 0) {
            str2 = imageSource.mediaType;
        }
        return imageSource.copy(str, i, i2, str2);
    }

    @Field
    public static /* synthetic */ void getHeight$annotations() {
    }

    @Field
    public static /* synthetic */ void getMediaType$annotations() {
    }

    @Field
    public static /* synthetic */ void getUrl$annotations() {
    }

    @Field
    public static /* synthetic */ void getWidth$annotations() {
    }

    public final String component1() {
        return this.url;
    }

    public final int component2() {
        return this.width;
    }

    public final int component3() {
        return this.height;
    }

    public final String component4() {
        return this.mediaType;
    }

    public final ImageSource copy(String str, int i, int i2, String str2) {
        Intrinsics.checkNotNullParameter(str, "url");
        return new ImageSource(str, i, i2, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageSource)) {
            return false;
        }
        ImageSource imageSource = (ImageSource) obj;
        return Intrinsics.areEqual((Object) this.url, (Object) imageSource.url) && this.width == imageSource.width && this.height == imageSource.height && Intrinsics.areEqual((Object) this.mediaType, (Object) imageSource.mediaType);
    }

    public int hashCode() {
        int hashCode = ((((this.url.hashCode() * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31;
        String str = this.mediaType;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.url;
        int i = this.width;
        int i2 = this.height;
        return "ImageSource(url=" + str + ", width=" + i + ", height=" + i2 + ", mediaType=" + this.mediaType + ")";
    }

    public ImageSource(String str, int i, int i2, String str2) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.url = str;
        this.width = i;
        this.height = i2;
        this.mediaType = str2;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getMediaType() {
        return this.mediaType;
    }
}
