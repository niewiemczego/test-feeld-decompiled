package expo.modules.camera;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0002\u0010\u0007¨\u0006\u0011"}, d2 = {"Lexpo/modules/camera/FaceDetectionErrorEvent;", "Lexpo/modules/kotlin/records/Record;", "isOperational", "", "(Z)V", "isOperational$annotations", "()V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "expo-camera_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Events.kt */
public final class FaceDetectionErrorEvent implements Record {
    private final boolean isOperational;

    public static /* synthetic */ FaceDetectionErrorEvent copy$default(FaceDetectionErrorEvent faceDetectionErrorEvent, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = faceDetectionErrorEvent.isOperational;
        }
        return faceDetectionErrorEvent.copy(z);
    }

    @Field
    public static /* synthetic */ void isOperational$annotations() {
    }

    public final boolean component1() {
        return this.isOperational;
    }

    public final FaceDetectionErrorEvent copy(boolean z) {
        return new FaceDetectionErrorEvent(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FaceDetectionErrorEvent) && this.isOperational == ((FaceDetectionErrorEvent) obj).isOperational;
    }

    public int hashCode() {
        boolean z = this.isOperational;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "FaceDetectionErrorEvent(isOperational=" + this.isOperational + ")";
    }

    public FaceDetectionErrorEvent(boolean z) {
        this.isOperational = z;
    }

    public final boolean isOperational() {
        return this.isOperational;
    }
}
