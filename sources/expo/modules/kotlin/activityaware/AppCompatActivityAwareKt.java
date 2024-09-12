package expo.modules.kotlin.activityaware;

import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00010\u0004HHø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"withActivityAvailable", "R", "Lexpo/modules/kotlin/activityaware/AppCompatActivityAware;", "onActivityAvailable", "Lkotlin/Function1;", "Landroidx/appcompat/app/AppCompatActivity;", "(Lexpo/modules/kotlin/activityaware/AppCompatActivityAware;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-modules-core_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: AppCompatActivityAware.kt */
public final class AppCompatActivityAwareKt {
    private static final <R> Object withActivityAvailable$$forInline(AppCompatActivityAware appCompatActivityAware, Function1<? super AppCompatActivity, ? extends R> function1, Continuation<? super R> continuation) {
        InlineMarker.mark(0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        AppCompatActivityAwareKt$withActivityAvailable$2$listener$1 appCompatActivityAwareKt$withActivityAvailable$2$listener$1 = new AppCompatActivityAwareKt$withActivityAvailable$2$listener$1(appCompatActivityAware, cancellableContinuation, function1);
        appCompatActivityAware.addOnActivityAvailableListener(appCompatActivityAwareKt$withActivityAvailable$2$listener$1);
        cancellableContinuation.invokeOnCancellation(new AppCompatActivityAwareKt$withActivityAvailable$2$1(appCompatActivityAware, appCompatActivityAwareKt$withActivityAvailable$2$listener$1));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return result;
    }

    public static final <R> Object withActivityAvailable(AppCompatActivityAware appCompatActivityAware, Function1<? super AppCompatActivity, ? extends R> function1, Continuation<? super R> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        AppCompatActivityAwareKt$withActivityAvailable$2$listener$1 appCompatActivityAwareKt$withActivityAvailable$2$listener$1 = new AppCompatActivityAwareKt$withActivityAvailable$2$listener$1(appCompatActivityAware, cancellableContinuation, function1);
        appCompatActivityAware.addOnActivityAvailableListener(appCompatActivityAwareKt$withActivityAvailable$2$listener$1);
        cancellableContinuation.invokeOnCancellation(new AppCompatActivityAwareKt$withActivityAvailable$2$1(appCompatActivityAware, appCompatActivityAwareKt$withActivityAvailable$2$listener$1));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
