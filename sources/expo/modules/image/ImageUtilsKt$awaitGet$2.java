package expo.modules.image;

import com.bumptech.glide.request.FutureTarget;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0000\u001a\n \u0002*\u0004\u0018\u0001H\u0001H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", "kotlin.jvm.PlatformType", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ImageUtils.kt */
final class ImageUtilsKt$awaitGet$2 extends Lambda implements Function0<T> {
    final /* synthetic */ FutureTarget<T> $this_awaitGet;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageUtilsKt$awaitGet$2(FutureTarget<T> futureTarget) {
        super(0);
        this.$this_awaitGet = futureTarget;
    }

    public final T invoke() {
        return this.$this_awaitGet.get();
    }
}
