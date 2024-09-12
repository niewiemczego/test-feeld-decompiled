package bo.app;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class o6 {
    public static final a b = new a((DefaultConstructorMarker) null);
    private static final Comparator c = new o6$$ExternalSyntheticLambda0();
    private final PriorityQueue a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public o6(List list) {
        Intrinsics.checkNotNullParameter(list, "fallbackActions");
        PriorityQueue priorityQueue = new PriorityQueue(12, c);
        this.a = priorityQueue;
        priorityQueue.addAll(list);
    }

    public final z2 a() {
        return (z2) this.a.poll();
    }

    /* access modifiers changed from: private */
    public static final int a(z2 z2Var, z2 z2Var2) {
        Intrinsics.checkNotNullParameter(z2Var, "actionA");
        Intrinsics.checkNotNullParameter(z2Var2, "actionB");
        int j = z2Var.n().j();
        int j2 = z2Var2.n().j();
        if (j > j2) {
            return -1;
        }
        if (j < j2) {
            return 1;
        }
        return z2Var.getId().compareTo(z2Var2.getId());
    }
}
