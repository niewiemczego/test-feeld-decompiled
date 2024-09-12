package coil.request;

import coil.request.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"coil/request/ImageRequest$Builder$listener$5", "Lcoil/request/ImageRequest$Listener;", "onCancel", "", "request", "Lcoil/request/ImageRequest;", "onError", "result", "Lcoil/request/ErrorResult;", "onStart", "onSuccess", "Lcoil/request/SuccessResult;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 176)
/* compiled from: ImageRequest.kt */
public final class ImageRequest$Builder$listener$5 implements ImageRequest.Listener {
    final /* synthetic */ Function1<ImageRequest, Unit> $onCancel;
    final /* synthetic */ Function2<ImageRequest, ErrorResult, Unit> $onError;
    final /* synthetic */ Function1<ImageRequest, Unit> $onStart;
    final /* synthetic */ Function2<ImageRequest, SuccessResult, Unit> $onSuccess;

    public ImageRequest$Builder$listener$5(Function1<? super ImageRequest, Unit> function1, Function1<? super ImageRequest, Unit> function12, Function2<? super ImageRequest, ? super ErrorResult, Unit> function2, Function2<? super ImageRequest, ? super SuccessResult, Unit> function22) {
        this.$onStart = function1;
        this.$onCancel = function12;
        this.$onError = function2;
        this.$onSuccess = function22;
    }

    public void onStart(ImageRequest imageRequest) {
        this.$onStart.invoke(imageRequest);
    }

    public void onCancel(ImageRequest imageRequest) {
        this.$onCancel.invoke(imageRequest);
    }

    public void onError(ImageRequest imageRequest, ErrorResult errorResult) {
        this.$onError.invoke(imageRequest, errorResult);
    }

    public void onSuccess(ImageRequest imageRequest, SuccessResult successResult) {
        this.$onSuccess.invoke(imageRequest, successResult);
    }
}
