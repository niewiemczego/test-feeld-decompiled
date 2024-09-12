package coil;

import android.graphics.Bitmap;
import coil.EventListener;
import coil.decode.DecodeResult;
import coil.decode.Decoder;
import coil.fetch.FetchResult;
import coil.fetch.Fetcher;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.Options;
import coil.request.SuccessResult;
import coil.size.Size;
import coil.transition.Transition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"coil/EventListener$Companion$NONE$1", "Lcoil/EventListener;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: EventListener.kt */
public final class EventListener$Companion$NONE$1 implements EventListener {
    EventListener$Companion$NONE$1() {
    }

    public void decodeEnd(ImageRequest imageRequest, Decoder decoder, Options options, DecodeResult decodeResult) {
        EventListener.DefaultImpls.decodeEnd(this, imageRequest, decoder, options, decodeResult);
    }

    public void decodeStart(ImageRequest imageRequest, Decoder decoder, Options options) {
        EventListener.DefaultImpls.decodeStart(this, imageRequest, decoder, options);
    }

    public void fetchEnd(ImageRequest imageRequest, Fetcher fetcher, Options options, FetchResult fetchResult) {
        EventListener.DefaultImpls.fetchEnd(this, imageRequest, fetcher, options, fetchResult);
    }

    public void fetchStart(ImageRequest imageRequest, Fetcher fetcher, Options options) {
        EventListener.DefaultImpls.fetchStart(this, imageRequest, fetcher, options);
    }

    public void keyEnd(ImageRequest imageRequest, String str) {
        EventListener.DefaultImpls.keyEnd(this, imageRequest, str);
    }

    public void keyStart(ImageRequest imageRequest, Object obj) {
        EventListener.DefaultImpls.keyStart(this, imageRequest, obj);
    }

    public void mapEnd(ImageRequest imageRequest, Object obj) {
        EventListener.DefaultImpls.mapEnd(this, imageRequest, obj);
    }

    public void mapStart(ImageRequest imageRequest, Object obj) {
        EventListener.DefaultImpls.mapStart(this, imageRequest, obj);
    }

    public void onCancel(ImageRequest imageRequest) {
        EventListener.DefaultImpls.onCancel(this, imageRequest);
    }

    public void onError(ImageRequest imageRequest, ErrorResult errorResult) {
        EventListener.DefaultImpls.onError(this, imageRequest, errorResult);
    }

    public void onStart(ImageRequest imageRequest) {
        EventListener.DefaultImpls.onStart(this, imageRequest);
    }

    public void onSuccess(ImageRequest imageRequest, SuccessResult successResult) {
        EventListener.DefaultImpls.onSuccess(this, imageRequest, successResult);
    }

    public void resolveSizeEnd(ImageRequest imageRequest, Size size) {
        EventListener.DefaultImpls.resolveSizeEnd(this, imageRequest, size);
    }

    public void resolveSizeStart(ImageRequest imageRequest) {
        EventListener.DefaultImpls.resolveSizeStart(this, imageRequest);
    }

    public void transformEnd(ImageRequest imageRequest, Bitmap bitmap) {
        EventListener.DefaultImpls.transformEnd(this, imageRequest, bitmap);
    }

    public void transformStart(ImageRequest imageRequest, Bitmap bitmap) {
        EventListener.DefaultImpls.transformStart(this, imageRequest, bitmap);
    }

    public void transitionEnd(ImageRequest imageRequest, Transition transition) {
        EventListener.DefaultImpls.transitionEnd(this, imageRequest, transition);
    }

    public void transitionStart(ImageRequest imageRequest, Transition transition) {
        EventListener.DefaultImpls.transitionStart(this, imageRequest, transition);
    }
}
