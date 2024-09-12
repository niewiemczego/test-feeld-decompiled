package androidx.room;

import androidx.room.AmbiguousColumnResolver;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "indices", "", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AmbiguousColumnResolver.kt */
final class AmbiguousColumnResolver$resolve$1$2 extends Lambda implements Function1<List<? extends Integer>, Unit> {
    final /* synthetic */ int $mappingIndex;
    final /* synthetic */ List<List<AmbiguousColumnResolver.Match>> $mappingMatches;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AmbiguousColumnResolver$resolve$1$2(List<? extends List<AmbiguousColumnResolver.Match>> list, int i) {
        super(1);
        this.$mappingMatches = list;
        this.$mappingIndex = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<Integer>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "indices");
        Iterable iterable = list;
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            while (it.hasNext()) {
                int intValue2 = ((Number) it.next()).intValue();
                if (intValue > intValue2) {
                    intValue = intValue2;
                }
            }
            Iterator it2 = iterable.iterator();
            if (it2.hasNext()) {
                int intValue3 = ((Number) it2.next()).intValue();
                while (it2.hasNext()) {
                    int intValue4 = ((Number) it2.next()).intValue();
                    if (intValue3 < intValue4) {
                        intValue3 = intValue4;
                    }
                }
                this.$mappingMatches.get(this.$mappingIndex).add(new AmbiguousColumnResolver.Match(new IntRange(intValue, intValue3), list));
                return;
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
    }
}
