package expo.modules.kotlin.objects;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
final class ObjectDefinitionBuilder$Constants$1 extends Lambda implements Function0<Map<String, ? extends Object>> {
    final /* synthetic */ Pair<String, Object>[] $constants;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ObjectDefinitionBuilder$Constants$1(Pair<String, ? extends Object>[] pairArr) {
        super(0);
        this.$constants = pairArr;
    }

    public final Map<String, Object> invoke() {
        return MapsKt.toMap((Pair<? extends K, ? extends V>[]) this.$constants);
    }
}
