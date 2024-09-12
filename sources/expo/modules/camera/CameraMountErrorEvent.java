package expo.modules.camera;

import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lexpo/modules/camera/CameraMountErrorEvent;", "Lexpo/modules/kotlin/records/Record;", "message", "", "(Ljava/lang/String;)V", "getMessage$annotations", "()V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "expo-camera_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Events.kt */
public final class CameraMountErrorEvent implements Record {
    private final String message;

    public static /* synthetic */ CameraMountErrorEvent copy$default(CameraMountErrorEvent cameraMountErrorEvent, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cameraMountErrorEvent.message;
        }
        return cameraMountErrorEvent.copy(str);
    }

    @Field
    public static /* synthetic */ void getMessage$annotations() {
    }

    public final String component1() {
        return this.message;
    }

    public final CameraMountErrorEvent copy(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        return new CameraMountErrorEvent(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CameraMountErrorEvent) && Intrinsics.areEqual((Object) this.message, (Object) ((CameraMountErrorEvent) obj).message);
    }

    public int hashCode() {
        return this.message.hashCode();
    }

    public String toString() {
        return "CameraMountErrorEvent(message=" + this.message + ")";
    }

    public CameraMountErrorEvent(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.message = str;
    }

    public final String getMessage() {
        return this.message;
    }
}
