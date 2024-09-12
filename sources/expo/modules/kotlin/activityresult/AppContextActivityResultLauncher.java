package expo.modules.kotlin.activityresult;

import androidx.activity.result.ActivityResultCallback;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0019\u0010\n\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\fJ#\u0010\n\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fH&¢\u0006\u0002\u0010\u0010R\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lexpo/modules/kotlin/activityresult/AppContextActivityResultLauncher;", "I", "Ljava/io/Serializable;", "O", "", "()V", "contract", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "getContract", "()Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "launch", "input", "(Ljava/io/Serializable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "callback", "Landroidx/activity/result/ActivityResultCallback;", "(Ljava/io/Serializable;Landroidx/activity/result/ActivityResultCallback;)V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AppContextActivityResultLauncher.kt */
public abstract class AppContextActivityResultLauncher<I extends Serializable, O> {
    public abstract AppContextActivityResultContract<I, O> getContract();

    public abstract void launch(I i, ActivityResultCallback<O> activityResultCallback);

    public final Object launch(I i, Continuation<? super O> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        launch(i, new AppContextActivityResultLauncher$launch$2$1(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
