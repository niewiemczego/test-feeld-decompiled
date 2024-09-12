package expo.modules.image;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u0012\u0010\u0003\u001a\u00020\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0001\u0005\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lexpo/modules/image/GlideModel;", "", "()V", "glideData", "getGlideData", "()Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "Lexpo/modules/image/GlideBlurhashModel;", "Lexpo/modules/image/GlideRawModel;", "Lexpo/modules/image/GlideThumbhashModel;", "Lexpo/modules/image/GlideUriModel;", "Lexpo/modules/image/GlideUrlModel;", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GlideModel.kt */
public abstract class GlideModel {
    public /* synthetic */ GlideModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Object getGlideData();

    private GlideModel() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GlideModel) && Intrinsics.areEqual(getGlideData(), ((GlideModel) obj).getGlideData());
    }

    public int hashCode() {
        return getGlideData().hashCode();
    }
}
