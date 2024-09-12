package expo.modules.camera;

import android.os.Bundle;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003JK\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\b\b\u0002\u0010\u000b\u001a\u00020\tHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u000b\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R,\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0019¨\u0006("}, d2 = {"Lexpo/modules/camera/BarCodeScannedEvent;", "Lexpo/modules/kotlin/records/Record;", "target", "", "data", "", "type", "cornerPoints", "Ljava/util/ArrayList;", "Landroid/os/Bundle;", "Lkotlin/collections/ArrayList;", "boundingBox", "(ILjava/lang/String;ILjava/util/ArrayList;Landroid/os/Bundle;)V", "getBoundingBox$annotations", "()V", "getBoundingBox", "()Landroid/os/Bundle;", "getCornerPoints$annotations", "getCornerPoints", "()Ljava/util/ArrayList;", "getData$annotations", "getData", "()Ljava/lang/String;", "getTarget$annotations", "getTarget", "()I", "getType$annotations", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "expo-camera_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Events.kt */
public final class BarCodeScannedEvent implements Record {
    private final Bundle boundingBox;
    private final ArrayList<Bundle> cornerPoints;
    private final String data;
    private final int target;
    private final int type;

    public static /* synthetic */ BarCodeScannedEvent copy$default(BarCodeScannedEvent barCodeScannedEvent, int i, String str, int i2, ArrayList<Bundle> arrayList, Bundle bundle, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = barCodeScannedEvent.target;
        }
        if ((i3 & 2) != 0) {
            str = barCodeScannedEvent.data;
        }
        String str2 = str;
        if ((i3 & 4) != 0) {
            i2 = barCodeScannedEvent.type;
        }
        int i4 = i2;
        if ((i3 & 8) != 0) {
            arrayList = barCodeScannedEvent.cornerPoints;
        }
        ArrayList<Bundle> arrayList2 = arrayList;
        if ((i3 & 16) != 0) {
            bundle = barCodeScannedEvent.boundingBox;
        }
        return barCodeScannedEvent.copy(i, str2, i4, arrayList2, bundle);
    }

    @Field
    public static /* synthetic */ void getBoundingBox$annotations() {
    }

    @Field
    public static /* synthetic */ void getCornerPoints$annotations() {
    }

    @Field
    public static /* synthetic */ void getData$annotations() {
    }

    @Field
    public static /* synthetic */ void getTarget$annotations() {
    }

    @Field
    public static /* synthetic */ void getType$annotations() {
    }

    public final int component1() {
        return this.target;
    }

    public final String component2() {
        return this.data;
    }

    public final int component3() {
        return this.type;
    }

    public final ArrayList<Bundle> component4() {
        return this.cornerPoints;
    }

    public final Bundle component5() {
        return this.boundingBox;
    }

    public final BarCodeScannedEvent copy(int i, String str, int i2, ArrayList<Bundle> arrayList, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "data");
        Intrinsics.checkNotNullParameter(arrayList, "cornerPoints");
        Intrinsics.checkNotNullParameter(bundle, "boundingBox");
        return new BarCodeScannedEvent(i, str, i2, arrayList, bundle);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BarCodeScannedEvent)) {
            return false;
        }
        BarCodeScannedEvent barCodeScannedEvent = (BarCodeScannedEvent) obj;
        return this.target == barCodeScannedEvent.target && Intrinsics.areEqual((Object) this.data, (Object) barCodeScannedEvent.data) && this.type == barCodeScannedEvent.type && Intrinsics.areEqual((Object) this.cornerPoints, (Object) barCodeScannedEvent.cornerPoints) && Intrinsics.areEqual((Object) this.boundingBox, (Object) barCodeScannedEvent.boundingBox);
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.target) * 31) + this.data.hashCode()) * 31) + Integer.hashCode(this.type)) * 31) + this.cornerPoints.hashCode()) * 31) + this.boundingBox.hashCode();
    }

    public String toString() {
        int i = this.target;
        String str = this.data;
        int i2 = this.type;
        ArrayList<Bundle> arrayList = this.cornerPoints;
        return "BarCodeScannedEvent(target=" + i + ", data=" + str + ", type=" + i2 + ", cornerPoints=" + arrayList + ", boundingBox=" + this.boundingBox + ")";
    }

    public BarCodeScannedEvent(int i, String str, int i2, ArrayList<Bundle> arrayList, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "data");
        Intrinsics.checkNotNullParameter(arrayList, "cornerPoints");
        Intrinsics.checkNotNullParameter(bundle, "boundingBox");
        this.target = i;
        this.data = str;
        this.type = i2;
        this.cornerPoints = arrayList;
        this.boundingBox = bundle;
    }

    public final int getTarget() {
        return this.target;
    }

    public final String getData() {
        return this.data;
    }

    public final int getType() {
        return this.type;
    }

    public final ArrayList<Bundle> getCornerPoints() {
        return this.cornerPoints;
    }

    public final Bundle getBoundingBox() {
        return this.boundingBox;
    }
}
