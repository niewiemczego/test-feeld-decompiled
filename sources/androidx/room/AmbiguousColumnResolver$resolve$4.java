package androidx.room;

import androidx.room.AmbiguousColumnResolver;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Landroidx/room/AmbiguousColumnResolver$Match;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AmbiguousColumnResolver.kt */
final class AmbiguousColumnResolver$resolve$4 extends Lambda implements Function1<List<? extends AmbiguousColumnResolver.Match>, Unit> {
    final /* synthetic */ Ref.ObjectRef<AmbiguousColumnResolver.Solution> $bestSolution;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AmbiguousColumnResolver$resolve$4(Ref.ObjectRef<AmbiguousColumnResolver.Solution> objectRef) {
        super(1);
        this.$bestSolution = objectRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<AmbiguousColumnResolver.Match>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<AmbiguousColumnResolver.Match> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        T build = AmbiguousColumnResolver.Solution.Companion.build(list);
        if (build.compareTo((AmbiguousColumnResolver.Solution) this.$bestSolution.element) < 0) {
            this.$bestSolution.element = build;
        }
    }
}
