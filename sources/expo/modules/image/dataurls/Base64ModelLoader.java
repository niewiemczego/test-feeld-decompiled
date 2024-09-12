package expo.modules.image.dataurls;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J.\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\u000f"}, d2 = {"Lexpo/modules/image/dataurls/Base64ModelLoader;", "Lcom/bumptech/glide/load/model/ModelLoader;", "", "Ljava/nio/ByteBuffer;", "()V", "buildLoadData", "Lcom/bumptech/glide/load/model/ModelLoader$LoadData;", "model", "width", "", "height", "options", "Lcom/bumptech/glide/load/Options;", "handles", "", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Base64ModelLoader.kt */
public final class Base64ModelLoader implements ModelLoader<String, ByteBuffer> {
    public boolean handles(String str) {
        Intrinsics.checkNotNullParameter(str, "model");
        return StringsKt.startsWith$default(str, "data:", false, 2, (Object) null);
    }

    public ModelLoader.LoadData<ByteBuffer> buildLoadData(String str, int i, int i2, Options options) {
        Intrinsics.checkNotNullParameter(str, "model");
        Intrinsics.checkNotNullParameter(options, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        return new ModelLoader.LoadData<>(new ObjectKey(str), new Base64DataFetcher(str));
    }
}
