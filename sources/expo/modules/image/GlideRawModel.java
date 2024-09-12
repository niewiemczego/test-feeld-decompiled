package expo.modules.image;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/image/GlideRawModel;", "Lexpo/modules/image/GlideModel;", "data", "", "(Ljava/lang/String;)V", "glideData", "getGlideData", "()Ljava/lang/String;", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GlideModel.kt */
public final class GlideRawModel extends GlideModel {
    private final String glideData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlideRawModel(String str) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "data");
        this.glideData = str;
    }

    public String getGlideData() {
        return this.glideData;
    }
}
