package com.adapty.utils;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u001c\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0002\u0010\u0006J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003J\u0013\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u0013\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u000eJ\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0016\u0010\u0005\u001a\u00028\u0001X\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\n\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/adapty/utils/ImmutableCollection;", "T", "C", "", "", "collection", "(Ljava/util/Collection;)V", "getCollection$adapty_release", "()Ljava/util/Collection;", "Ljava/util/Collection;", "size", "", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "equals", "other", "", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "toString", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ImmutableCollections.kt */
public class ImmutableCollection<T, C extends Collection<? extends T>> implements Iterable<T>, KMappedMarker {
    private final C collection;

    public ImmutableCollection(C c) {
        Intrinsics.checkNotNullParameter(c, "collection");
        this.collection = c;
    }

    public final /* synthetic */ Collection getCollection$adapty_release() {
        return this.collection;
    }

    public final int size() {
        return this.collection.size();
    }

    public final boolean isEmpty() {
        return this.collection.isEmpty();
    }

    public final boolean contains(T t) {
        return this.collection.contains(t);
    }

    public Iterator<T> iterator() {
        return this.collection.iterator();
    }

    public final boolean containsAll(Collection<? extends T> collection2) {
        Intrinsics.checkNotNullParameter(collection2, "elements");
        return this.collection.containsAll(collection2);
    }

    public final int indexOf(T t) {
        return CollectionsKt.indexOf((Iterable) this.collection, t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ImmutableCollection) && Intrinsics.areEqual((Object) this.collection, (Object) ((ImmutableCollection) obj).collection);
    }

    public int hashCode() {
        return this.collection.hashCode();
    }

    public String toString() {
        return this.collection.toString();
    }
}
