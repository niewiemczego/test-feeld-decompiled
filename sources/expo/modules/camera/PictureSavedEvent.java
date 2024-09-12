package expo.modules.camera;

import android.os.Bundle;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lexpo/modules/camera/PictureSavedEvent;", "Lexpo/modules/kotlin/records/Record;", "id", "", "data", "Landroid/os/Bundle;", "(ILandroid/os/Bundle;)V", "getData$annotations", "()V", "getData", "()Landroid/os/Bundle;", "getId$annotations", "getId", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "expo-camera_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Events.kt */
public final class PictureSavedEvent implements Record {
    private final Bundle data;
    private final int id;

    public static /* synthetic */ PictureSavedEvent copy$default(PictureSavedEvent pictureSavedEvent, int i, Bundle bundle, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = pictureSavedEvent.id;
        }
        if ((i2 & 2) != 0) {
            bundle = pictureSavedEvent.data;
        }
        return pictureSavedEvent.copy(i, bundle);
    }

    @Field
    public static /* synthetic */ void getData$annotations() {
    }

    @Field
    public static /* synthetic */ void getId$annotations() {
    }

    public final int component1() {
        return this.id;
    }

    public final Bundle component2() {
        return this.data;
    }

    public final PictureSavedEvent copy(int i, Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "data");
        return new PictureSavedEvent(i, bundle);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PictureSavedEvent)) {
            return false;
        }
        PictureSavedEvent pictureSavedEvent = (PictureSavedEvent) obj;
        return this.id == pictureSavedEvent.id && Intrinsics.areEqual((Object) this.data, (Object) pictureSavedEvent.data);
    }

    public int hashCode() {
        return (Integer.hashCode(this.id) * 31) + this.data.hashCode();
    }

    public String toString() {
        int i = this.id;
        return "PictureSavedEvent(id=" + i + ", data=" + this.data + ")";
    }

    public PictureSavedEvent(int i, Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "data");
        this.id = i;
        this.data = bundle;
    }

    public final int getId() {
        return this.id;
    }

    public final Bundle getData() {
        return this.data;
    }
}
