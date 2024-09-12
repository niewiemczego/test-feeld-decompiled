package com.google.common.collect;

import com.google.common.collect.Table;
import java.util.Comparator;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RegularImmutableTable$$ExternalSyntheticLambda0 implements Comparator {
    public final /* synthetic */ Comparator f$0;
    public final /* synthetic */ Comparator f$1;

    public /* synthetic */ RegularImmutableTable$$ExternalSyntheticLambda0(Comparator comparator, Comparator comparator2) {
        this.f$0 = comparator;
        this.f$1 = comparator2;
    }

    public final int compare(Object obj, Object obj2) {
        return RegularImmutableTable.lambda$forCells$0(this.f$0, this.f$1, (Table.Cell) obj, (Table.Cell) obj2);
    }
}
