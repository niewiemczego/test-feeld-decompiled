package androidx.room;

import androidx.room.AmbiguousColumnResolver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "startIndex", "", "endIndex", "resultColumnsSublist", "", "Landroidx/room/AmbiguousColumnResolver$ResultColumn;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AmbiguousColumnResolver.kt */
final class AmbiguousColumnResolver$resolve$1$1 extends Lambda implements Function3<Integer, Integer, List<? extends AmbiguousColumnResolver.ResultColumn>, Unit> {
    final /* synthetic */ String[] $mapping;
    final /* synthetic */ int $mappingIndex;
    final /* synthetic */ List<List<AmbiguousColumnResolver.Match>> $mappingMatches;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AmbiguousColumnResolver$resolve$1$1(String[] strArr, List<? extends List<AmbiguousColumnResolver.Match>> list, int i) {
        super(3);
        this.$mapping = strArr;
        this.$mappingMatches = list;
        this.$mappingIndex = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (List<AmbiguousColumnResolver.ResultColumn>) (List) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(int i, int i2, List<AmbiguousColumnResolver.ResultColumn> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "resultColumnsSublist");
        String[] strArr = this.$mapping;
        Collection arrayList = new ArrayList(strArr.length);
        int length = strArr.length;
        int i3 = 0;
        while (i3 < length) {
            String str = strArr[i3];
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) str, (Object) ((AmbiguousColumnResolver.ResultColumn) obj).component1())) {
                    break;
                }
            }
            AmbiguousColumnResolver.ResultColumn resultColumn = (AmbiguousColumnResolver.ResultColumn) obj;
            if (resultColumn != null) {
                arrayList.add(Integer.valueOf(resultColumn.getIndex()));
                i3++;
            } else {
                return;
            }
        }
        this.$mappingMatches.get(this.$mappingIndex).add(new AmbiguousColumnResolver.Match(new IntRange(i, i2 - 1), (List) arrayList));
    }
}
