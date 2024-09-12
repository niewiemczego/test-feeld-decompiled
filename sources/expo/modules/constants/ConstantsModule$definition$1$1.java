package expo.modules.constants;

import expo.modules.interfaces.constants.ConstantsInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConstantsModule.kt */
final class ConstantsModule$definition$1$1 extends Lambda implements Function0<Map<String, ? extends Object>> {
    final /* synthetic */ ConstantsModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConstantsModule$definition$1$1(ConstantsModule constantsModule) {
        super(0);
        this.this$0 = constantsModule;
    }

    public final Map<String, Object> invoke() {
        ConstantsInterface constants = this.this$0.getAppContext().getConstants();
        Map<String, Object> constants2 = constants != null ? constants.getConstants() : null;
        return constants2 == null ? MapsKt.emptyMap() : constants2;
    }
}
