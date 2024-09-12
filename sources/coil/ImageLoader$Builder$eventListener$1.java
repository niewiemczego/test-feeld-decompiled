package coil;

import coil.EventListener;
import coil.request.ImageRequest;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcoil/EventListener;", "it", "Lcoil/request/ImageRequest;", "create"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ImageLoader.kt */
final class ImageLoader$Builder$eventListener$1 implements EventListener.Factory {
    final /* synthetic */ EventListener $listener;

    ImageLoader$Builder$eventListener$1(EventListener eventListener) {
        this.$listener = eventListener;
    }

    public final EventListener create(ImageRequest imageRequest) {
        return this.$listener;
    }
}
