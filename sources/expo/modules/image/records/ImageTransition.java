package expo.modules.image.records;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lexpo/modules/image/records/ImageTransition;", "Lexpo/modules/kotlin/records/Record;", "duration", "", "(I)V", "getDuration$annotations", "()V", "getDuration", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ImageTransition.kt */
public final class ImageTransition implements Record {
    private final int duration;

    public ImageTransition() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ImageTransition copy$default(ImageTransition imageTransition, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = imageTransition.duration;
        }
        return imageTransition.copy(i);
    }

    @Field
    public static /* synthetic */ void getDuration$annotations() {
    }

    public final int component1() {
        return this.duration;
    }

    public final ImageTransition copy(int i) {
        return new ImageTransition(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ImageTransition) && this.duration == ((ImageTransition) obj).duration;
    }

    public int hashCode() {
        return Integer.hashCode(this.duration);
    }

    public String toString() {
        return "ImageTransition(duration=" + this.duration + ")";
    }

    public ImageTransition(int i) {
        this.duration = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageTransition(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public final int getDuration() {
        return this.duration;
    }
}
