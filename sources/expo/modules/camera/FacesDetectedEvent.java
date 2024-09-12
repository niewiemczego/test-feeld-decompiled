package expo.modules.camera;

import android.os.Bundle;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lexpo/modules/camera/FacesDetectedEvent;", "Lexpo/modules/kotlin/records/Record;", "type", "", "faces", "", "Landroid/os/Bundle;", "target", "", "(Ljava/lang/String;Ljava/util/List;I)V", "getFaces$annotations", "()V", "getFaces", "()Ljava/util/List;", "getTarget$annotations", "getTarget", "()I", "getType$annotations", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "expo-camera_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Events.kt */
public final class FacesDetectedEvent implements Record {
    private final List<Bundle> faces;
    private final int target;
    private final String type;

    public static /* synthetic */ FacesDetectedEvent copy$default(FacesDetectedEvent facesDetectedEvent, String str, List<Bundle> list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = facesDetectedEvent.type;
        }
        if ((i2 & 2) != 0) {
            list = facesDetectedEvent.faces;
        }
        if ((i2 & 4) != 0) {
            i = facesDetectedEvent.target;
        }
        return facesDetectedEvent.copy(str, list, i);
    }

    @Field
    public static /* synthetic */ void getFaces$annotations() {
    }

    @Field
    public static /* synthetic */ void getTarget$annotations() {
    }

    @Field
    public static /* synthetic */ void getType$annotations() {
    }

    public final String component1() {
        return this.type;
    }

    public final List<Bundle> component2() {
        return this.faces;
    }

    public final int component3() {
        return this.target;
    }

    public final FacesDetectedEvent copy(String str, List<Bundle> list, int i) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(list, "faces");
        return new FacesDetectedEvent(str, list, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FacesDetectedEvent)) {
            return false;
        }
        FacesDetectedEvent facesDetectedEvent = (FacesDetectedEvent) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) facesDetectedEvent.type) && Intrinsics.areEqual((Object) this.faces, (Object) facesDetectedEvent.faces) && this.target == facesDetectedEvent.target;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.faces.hashCode()) * 31) + Integer.hashCode(this.target);
    }

    public String toString() {
        String str = this.type;
        List<Bundle> list = this.faces;
        return "FacesDetectedEvent(type=" + str + ", faces=" + list + ", target=" + this.target + ")";
    }

    public FacesDetectedEvent(String str, List<Bundle> list, int i) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(list, "faces");
        this.type = str;
        this.faces = list;
        this.target = i;
    }

    public final String getType() {
        return this.type;
    }

    public final List<Bundle> getFaces() {
        return this.faces;
    }

    public final int getTarget() {
        return this.target;
    }
}
