package com.google.common.collect;

import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FilteredEntryMultimap$Keys$1$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ Predicate f$0;

    public /* synthetic */ FilteredEntryMultimap$Keys$1$$ExternalSyntheticLambda0(Predicate predicate) {
        this.f$0 = predicate;
    }

    public final boolean apply(Object obj) {
        return this.f$0.apply(Multisets.immutableEntry(((Map.Entry) obj).getKey(), ((Collection) ((Map.Entry) obj).getValue()).size()));
    }
}
