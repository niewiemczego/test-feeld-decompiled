package kotlin.reflect.jvm.internal.impl.util.collectionUtils;

import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* compiled from: scopeUtils.kt */
public final class ScopeUtilsKt {
    public static final <T> Collection<T> concat(Collection<? extends T> collection, Collection<? extends T> collection2) {
        Intrinsics.checkNotNullParameter(collection2, "collection");
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == null) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    public static final SmartList<MemberScope> listOfNonEmptyScopes(Iterable<? extends MemberScope> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "scopes");
        Collection smartList = new SmartList();
        for (Object next : iterable) {
            MemberScope memberScope = (MemberScope) next;
            if ((memberScope == null || memberScope == MemberScope.Empty.INSTANCE) ? false : true) {
                smartList.add(next);
            }
        }
        return (SmartList) smartList;
    }
}
