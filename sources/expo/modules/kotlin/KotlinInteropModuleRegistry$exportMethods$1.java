package expo.modules.kotlin;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001e\u0010\u0004\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\u0002`\b0\u0005H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "", "", "Lexpo/modules/kotlin/ModuleMethodInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: KotlinInteropModuleRegistry.kt */
final class KotlinInteropModuleRegistry$exportMethods$1 extends Lambda implements Function2<String, List<? extends Map<String, ? extends Object>>, Unit> {
    public static final KotlinInteropModuleRegistry$exportMethods$1 INSTANCE = new KotlinInteropModuleRegistry$exportMethods$1();

    KotlinInteropModuleRegistry$exportMethods$1() {
        super(2);
    }

    public final void invoke(String str, List<? extends Map<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(list, "<anonymous parameter 1>");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (List<? extends Map<String, ? extends Object>>) (List) obj2);
        return Unit.INSTANCE;
    }
}
