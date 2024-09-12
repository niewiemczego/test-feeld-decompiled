package expo.modules.image.records;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lexpo/modules/image/records/ImageErrorEvent;", "Lexpo/modules/kotlin/records/Record;", "error", "", "(Ljava/lang/String;)V", "getError$annotations", "()V", "getError", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: events.kt */
public final class ImageErrorEvent implements Record {
    private final String error;

    public static /* synthetic */ ImageErrorEvent copy$default(ImageErrorEvent imageErrorEvent, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = imageErrorEvent.error;
        }
        return imageErrorEvent.copy(str);
    }

    @Field
    public static /* synthetic */ void getError$annotations() {
    }

    public final String component1() {
        return this.error;
    }

    public final ImageErrorEvent copy(String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        return new ImageErrorEvent(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ImageErrorEvent) && Intrinsics.areEqual((Object) this.error, (Object) ((ImageErrorEvent) obj).error);
    }

    public int hashCode() {
        return this.error.hashCode();
    }

    public String toString() {
        return "ImageErrorEvent(error=" + this.error + ")";
    }

    public ImageErrorEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.error = str;
    }

    public final String getError() {
        return this.error;
    }
}
