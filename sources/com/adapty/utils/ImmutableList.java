package com.adapty.utils;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/adapty/utils/ImmutableList;", "T", "Lcom/adapty/utils/ImmutableCollection;", "", "list", "(Ljava/util/List;)V", "get", "index", "", "(I)Ljava/lang/Object;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ImmutableCollections.kt */
public final class ImmutableList<T> extends ImmutableCollection<T, List<? extends T>> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImmutableList(List<? extends T> list) {
        super(list);
        Intrinsics.checkNotNullParameter(list, "list");
    }

    public final T get(int i) {
        return ((List) getCollection$adapty_release()).get(i);
    }
}
