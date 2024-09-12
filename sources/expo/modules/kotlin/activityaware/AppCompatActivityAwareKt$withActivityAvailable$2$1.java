package expo.modules.kotlin.activityaware;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "R", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* compiled from: AppCompatActivityAware.kt */
final class AppCompatActivityAwareKt$withActivityAvailable$2$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ AppCompatActivityAwareKt$withActivityAvailable$2$listener$1 $listener;
    final /* synthetic */ AppCompatActivityAware $this_withActivityAvailable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppCompatActivityAwareKt$withActivityAvailable$2$1(AppCompatActivityAware appCompatActivityAware, AppCompatActivityAwareKt$withActivityAvailable$2$listener$1 appCompatActivityAwareKt$withActivityAvailable$2$listener$1) {
        super(1);
        this.$this_withActivityAvailable = appCompatActivityAware;
        this.$listener = appCompatActivityAwareKt$withActivityAvailable$2$listener$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        this.$this_withActivityAvailable.removeOnActivityAvailableListener(this.$listener);
    }
}
