package androidx.privacysandbox.ads.adservices.java.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0000¨\u0006\u0006"}, d2 = {"asListenableFuture", "Lcom/google/common/util/concurrent/ListenableFuture;", "T", "Lkotlinx/coroutines/Deferred;", "tag", "", "ads-adservices-java_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoroutineAdapter.kt */
public final class CoroutineAdapterKt {
    public static /* synthetic */ ListenableFuture asListenableFuture$default(Deferred deferred, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = "Deferred.asListenableFuture";
        }
        return asListenableFuture(deferred, obj);
    }

    public static final <T> ListenableFuture<T> asListenableFuture(Deferred<? extends T> deferred, Object obj) {
        Intrinsics.checkNotNullParameter(deferred, "<this>");
        ListenableFuture<T> future = CallbackToFutureAdapter.getFuture(new CoroutineAdapterKt$$ExternalSyntheticLambda0(deferred, obj));
        Intrinsics.checkNotNullExpressionValue(future, "getFuture { completer ->…        }\n    }\n    tag\n}");
        return future;
    }

    /* access modifiers changed from: private */
    public static final Object asListenableFuture$lambda$0(Deferred deferred, Object obj, CallbackToFutureAdapter.Completer completer) {
        Intrinsics.checkNotNullParameter(deferred, "$this_asListenableFuture");
        Intrinsics.checkNotNullParameter(completer, "completer");
        deferred.invokeOnCompletion(new CoroutineAdapterKt$asListenableFuture$1$1(completer, deferred));
        return obj;
    }
}
