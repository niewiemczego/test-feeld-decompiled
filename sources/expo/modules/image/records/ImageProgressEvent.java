package expo.modules.image.records;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lexpo/modules/image/records/ImageProgressEvent;", "Lexpo/modules/kotlin/records/Record;", "loaded", "", "total", "(II)V", "getLoaded$annotations", "()V", "getLoaded", "()I", "getTotal$annotations", "getTotal", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: events.kt */
public final class ImageProgressEvent implements Record {
    private final int loaded;
    private final int total;

    public static /* synthetic */ ImageProgressEvent copy$default(ImageProgressEvent imageProgressEvent, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = imageProgressEvent.loaded;
        }
        if ((i3 & 2) != 0) {
            i2 = imageProgressEvent.total;
        }
        return imageProgressEvent.copy(i, i2);
    }

    @Field
    public static /* synthetic */ void getLoaded$annotations() {
    }

    @Field
    public static /* synthetic */ void getTotal$annotations() {
    }

    public final int component1() {
        return this.loaded;
    }

    public final int component2() {
        return this.total;
    }

    public final ImageProgressEvent copy(int i, int i2) {
        return new ImageProgressEvent(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageProgressEvent)) {
            return false;
        }
        ImageProgressEvent imageProgressEvent = (ImageProgressEvent) obj;
        return this.loaded == imageProgressEvent.loaded && this.total == imageProgressEvent.total;
    }

    public int hashCode() {
        return (Integer.hashCode(this.loaded) * 31) + Integer.hashCode(this.total);
    }

    public String toString() {
        int i = this.loaded;
        return "ImageProgressEvent(loaded=" + i + ", total=" + this.total + ")";
    }

    public ImageProgressEvent(int i, int i2) {
        this.loaded = i;
        this.total = i2;
    }

    public final int getLoaded() {
        return this.loaded;
    }

    public final int getTotal() {
        return this.total;
    }
}
