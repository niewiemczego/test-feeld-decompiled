package expo.modules.image;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lexpo/modules/image/ImageViewWrapperTarget;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpoImageViewWrapper.kt */
final class ExpoImageViewWrapper$onResourceReady$1$clearPreviousView$1 extends Lambda implements Function0<ImageViewWrapperTarget> {
    final /* synthetic */ ExpoImageView $previousView;
    final /* synthetic */ ImageViewWrapperTarget $target;
    final /* synthetic */ ExpoImageViewWrapper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExpoImageViewWrapper$onResourceReady$1$clearPreviousView$1(ExpoImageView expoImageView, ImageViewWrapperTarget imageViewWrapperTarget, ExpoImageViewWrapper expoImageViewWrapper) {
        super(0);
        this.$previousView = expoImageView;
        this.$target = imageViewWrapperTarget;
        this.this$0 = expoImageViewWrapper;
    }

    public final ImageViewWrapperTarget invoke() {
        ImageViewWrapperTarget recycleView = this.$previousView.recycleView();
        if (recycleView == null) {
            return null;
        }
        ImageViewWrapperTarget imageViewWrapperTarget = this.$target;
        ExpoImageViewWrapper expoImageViewWrapper = this.this$0;
        if (Intrinsics.areEqual((Object) recycleView, (Object) imageViewWrapperTarget)) {
            return recycleView;
        }
        recycleView.clear(expoImageViewWrapper.getRequestManager$expo_image_release());
        return recycleView;
    }
}
