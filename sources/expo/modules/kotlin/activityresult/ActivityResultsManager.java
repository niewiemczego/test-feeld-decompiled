package expo.modules.kotlin.activityresult;

import android.app.Activity;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import expo.modules.kotlin.activityaware.AppCompatActivityAware;
import expo.modules.kotlin.activityaware.AppCompatActivityAwareHelper;
import expo.modules.kotlin.activityaware.OnActivityAvailableListener;
import expo.modules.kotlin.providers.CurrentActivityProvider;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J(\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0019JU\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001e0\u001c\"\b\b\u0000\u0010\u001d*\u00020\u001f\"\u0004\b\u0001\u0010\u001e2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001e0!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\u001e0#H@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lexpo/modules/kotlin/activityresult/ActivityResultsManager;", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultCaller;", "Lexpo/modules/kotlin/activityaware/AppCompatActivityAware;", "currentActivityProvider", "Lexpo/modules/kotlin/providers/CurrentActivityProvider;", "(Lexpo/modules/kotlin/providers/CurrentActivityProvider;)V", "activityAwareHelper", "Lexpo/modules/kotlin/activityaware/AppCompatActivityAwareHelper;", "nextLocalRequestCode", "Ljava/util/concurrent/atomic/AtomicInteger;", "registry", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultRegistry;", "addOnActivityAvailableListener", "", "listener", "Lexpo/modules/kotlin/activityaware/OnActivityAvailableListener;", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onHostDestroy", "Landroidx/appcompat/app/AppCompatActivity;", "onHostResume", "registerForActivityResult", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultLauncher;", "I", "O", "Ljava/io/Serializable;", "contract", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "fallbackCallback", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultFallbackCallback;", "(Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;Lexpo/modules/kotlin/activityresult/AppContextActivityResultFallbackCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeOnActivityAvailableListener", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ActivityResultsManager.kt */
public final class ActivityResultsManager implements AppContextActivityResultCaller, AppCompatActivityAware {
    private final AppCompatActivityAwareHelper activityAwareHelper = new AppCompatActivityAwareHelper();
    /* access modifiers changed from: private */
    public final AtomicInteger nextLocalRequestCode = new AtomicInteger();
    /* access modifiers changed from: private */
    public final AppContextActivityResultRegistry registry;

    public ActivityResultsManager(CurrentActivityProvider currentActivityProvider) {
        Intrinsics.checkNotNullParameter(currentActivityProvider, "currentActivityProvider");
        this.registry = new AppContextActivityResultRegistry(currentActivityProvider);
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "expo.modules.kotlin.activityresult.ActivityResultsManager$1", f = "ActivityResultsManager.kt", i = {0}, l = {102}, m = "invokeSuspend", n = {"$this$withActivityAvailable$iv"}, s = {"L$0"})
    /* renamed from: expo.modules.kotlin.activityresult.ActivityResultsManager$1  reason: invalid class name */
    /* compiled from: ActivityResultsManager.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ ActivityResultsManager this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ActivityResultsManager activityResultsManager = this.this$0;
                AppCompatActivityAware appCompatActivityAware = activityResultsManager;
                this.L$0 = appCompatActivityAware;
                this.L$1 = activityResultsManager;
                this.label = 1;
                Continuation continuation = this;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
                cancellableContinuationImpl.initCancellability();
                CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                ActivityResultsManager$1$invokeSuspend$$inlined$withActivityAvailable$1 activityResultsManager$1$invokeSuspend$$inlined$withActivityAvailable$1 = new ActivityResultsManager$1$invokeSuspend$$inlined$withActivityAvailable$1(appCompatActivityAware, cancellableContinuation, activityResultsManager);
                appCompatActivityAware.addOnActivityAvailableListener(activityResultsManager$1$invokeSuspend$$inlined$withActivityAvailable$1);
                cancellableContinuation.invokeOnCancellation(new ActivityResultsManager$1$invokeSuspend$$inlined$withActivityAvailable$2(appCompatActivityAware, activityResultsManager$1$invokeSuspend$$inlined$withActivityAvailable$1));
                Object result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(continuation);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ActivityResultsManager activityResultsManager2 = (ActivityResultsManager) this.L$1;
                AppCompatActivityAware appCompatActivityAware2 = (AppCompatActivityAware) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.registry.dispatchResult(i, i2, intent);
    }

    public final void onHostResume(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        this.activityAwareHelper.dispatchOnActivityAvailable(appCompatActivity);
    }

    public final void onHostDestroy(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        this.registry.persistInstanceState(appCompatActivity);
    }

    public <I extends Serializable, O> Object registerForActivityResult(AppContextActivityResultContract<I, O> appContextActivityResultContract, AppContextActivityResultFallbackCallback<I, O> appContextActivityResultFallbackCallback, Continuation<? super AppContextActivityResultLauncher<I, O>> continuation) {
        AppCompatActivityAware appCompatActivityAware = this;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        ActivityResultsManager$registerForActivityResult$$inlined$withActivityAvailable$1 activityResultsManager$registerForActivityResult$$inlined$withActivityAvailable$1 = new ActivityResultsManager$registerForActivityResult$$inlined$withActivityAvailable$1(appCompatActivityAware, cancellableContinuation, this, appContextActivityResultContract, appContextActivityResultFallbackCallback);
        appCompatActivityAware.addOnActivityAvailableListener(activityResultsManager$registerForActivityResult$$inlined$withActivityAvailable$1);
        cancellableContinuation.invokeOnCancellation(new ActivityResultsManager$registerForActivityResult$$inlined$withActivityAvailable$2(appCompatActivityAware, activityResultsManager$registerForActivityResult$$inlined$withActivityAvailable$1));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public void addOnActivityAvailableListener(OnActivityAvailableListener onActivityAvailableListener) {
        Intrinsics.checkNotNullParameter(onActivityAvailableListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.activityAwareHelper.addOnActivityAvailableListener(onActivityAvailableListener);
    }

    public void removeOnActivityAvailableListener(OnActivityAvailableListener onActivityAvailableListener) {
        Intrinsics.checkNotNullParameter(onActivityAvailableListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.activityAwareHelper.removeOnActivityAvailableListener(onActivityAvailableListener);
    }
}
