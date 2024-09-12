package expo.modules.kotlin.activityresult;

import androidx.appcompat.app.AppCompatActivity;
import expo.modules.kotlin.activityaware.AppCompatActivityAware;
import expo.modules.kotlin.activityaware.OnActivityAvailableListener;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, d2 = {"expo/modules/kotlin/activityaware/AppCompatActivityAwareKt$withActivityAvailable$2$listener$1", "Lexpo/modules/kotlin/activityaware/OnActivityAvailableListener;", "onActivityAvailable", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AppCompatActivityAware.kt */
public final class ActivityResultsManager$registerForActivityResult$$inlined$withActivityAvailable$1 implements OnActivityAvailableListener {
    final /* synthetic */ CancellableContinuation $continuation;
    final /* synthetic */ AppContextActivityResultContract $contract$inlined;
    final /* synthetic */ AppContextActivityResultFallbackCallback $fallbackCallback$inlined;
    final /* synthetic */ AppCompatActivityAware $this_withActivityAvailable;
    final /* synthetic */ ActivityResultsManager this$0;

    public ActivityResultsManager$registerForActivityResult$$inlined$withActivityAvailable$1(AppCompatActivityAware appCompatActivityAware, CancellableContinuation cancellableContinuation, ActivityResultsManager activityResultsManager, AppContextActivityResultContract appContextActivityResultContract, AppContextActivityResultFallbackCallback appContextActivityResultFallbackCallback) {
        this.$this_withActivityAvailable = appCompatActivityAware;
        this.$continuation = cancellableContinuation;
        this.this$0 = activityResultsManager;
        this.$contract$inlined = appContextActivityResultContract;
        this.$fallbackCallback$inlined = appContextActivityResultFallbackCallback;
    }

    public void onActivityAvailable(AppCompatActivity appCompatActivity) {
        Object obj;
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        this.$this_withActivityAvailable.removeOnActivityAvailableListener(this);
        CancellableContinuation cancellableContinuation = this.$continuation;
        try {
            Result.Companion companion = Result.Companion;
            ActivityResultsManager$registerForActivityResult$$inlined$withActivityAvailable$1 activityResultsManager$registerForActivityResult$$inlined$withActivityAvailable$1 = this;
            obj = Result.m983constructorimpl(this.this$0.registry.register("AppContext_rq#" + this.this$0.nextLocalRequestCode.getAndIncrement(), appCompatActivity, this.$contract$inlined, this.$fallbackCallback$inlined));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m983constructorimpl(ResultKt.createFailure(th));
        }
        cancellableContinuation.resumeWith(obj);
    }
}
