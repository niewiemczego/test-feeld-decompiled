package expo.modules.kotlin.activityaware;

import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"expo/modules/kotlin/activityaware/AppCompatActivityAwareKt$withActivityAvailable$2$listener$1", "Lexpo/modules/kotlin/activityaware/OnActivityAvailableListener;", "onActivityAvailable", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 176)
/* compiled from: AppCompatActivityAware.kt */
public final class AppCompatActivityAwareKt$withActivityAvailable$2$listener$1 implements OnActivityAvailableListener {
    final /* synthetic */ CancellableContinuation<R> $continuation;
    final /* synthetic */ Function1<AppCompatActivity, R> $onActivityAvailable;
    final /* synthetic */ AppCompatActivityAware $this_withActivityAvailable;

    public AppCompatActivityAwareKt$withActivityAvailable$2$listener$1(AppCompatActivityAware appCompatActivityAware, CancellableContinuation<? super R> cancellableContinuation, Function1<? super AppCompatActivity, ? extends R> function1) {
        this.$this_withActivityAvailable = appCompatActivityAware;
        this.$continuation = cancellableContinuation;
        this.$onActivityAvailable = function1;
    }

    public void onActivityAvailable(AppCompatActivity appCompatActivity) {
        Object obj;
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        this.$this_withActivityAvailable.removeOnActivityAvailableListener(this);
        CancellableContinuation<R> cancellableContinuation = this.$continuation;
        Function1<AppCompatActivity, R> function1 = this.$onActivityAvailable;
        try {
            Result.Companion companion = Result.Companion;
            AppCompatActivityAwareKt$withActivityAvailable$2$listener$1 appCompatActivityAwareKt$withActivityAvailable$2$listener$1 = this;
            obj = Result.m983constructorimpl(function1.invoke(appCompatActivity));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m983constructorimpl(ResultKt.createFailure(th));
        }
        cancellableContinuation.resumeWith(obj);
    }
}
