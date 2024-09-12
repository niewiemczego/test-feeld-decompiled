package expo.modules.kotlin;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/CoroutineScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ModuleRegistry.kt */
final class ModuleRegistry$register$2 extends Lambda implements Function0<CoroutineScope> {
    final /* synthetic */ ModuleHolder $holder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModuleRegistry$register$2(ModuleHolder moduleHolder) {
        super(0);
        this.$holder = moduleHolder;
    }

    public final CoroutineScope invoke() {
        return CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new CoroutineName(this.$holder.getDefinition().getName())));
    }
}
