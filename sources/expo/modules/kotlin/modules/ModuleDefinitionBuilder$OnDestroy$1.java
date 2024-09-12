package expo.modules.kotlin.modules;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* compiled from: ModuleDefinitionBuilder.kt */
public final class ModuleDefinitionBuilder$OnDestroy$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $body;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModuleDefinitionBuilder$OnDestroy$1(Function0<Unit> function0) {
        super(0);
        this.$body = function0;
    }

    public final void invoke() {
        this.$body.invoke();
    }
}
