package kotlin.reflect.jvm.internal.impl.platform;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: TargetPlatform.kt */
public class TargetPlatform implements Collection<SimplePlatform>, KMappedMarker {
    private final Set<SimplePlatform> componentPlatforms;

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends SimplePlatform> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(SimplePlatform simplePlatform) {
        Intrinsics.checkNotNullParameter(simplePlatform, "element");
        return this.componentPlatforms.contains(simplePlatform);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        return this.componentPlatforms.containsAll(collection);
    }

    public int getSize() {
        return this.componentPlatforms.size();
    }

    public boolean isEmpty() {
        return this.componentPlatforms.isEmpty();
    }

    public Iterator<SimplePlatform> iterator() {
        return this.componentPlatforms.iterator();
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return CollectionToArray.toArray(this, tArr);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof SimplePlatform)) {
            return false;
        }
        return contains((SimplePlatform) obj);
    }

    public final Set<SimplePlatform> getComponentPlatforms() {
        return this.componentPlatforms;
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public String toString() {
        return PlatformUtilKt.getPresentableDescription(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TargetPlatform) && Intrinsics.areEqual((Object) this.componentPlatforms, (Object) ((TargetPlatform) obj).componentPlatforms);
    }

    public int hashCode() {
        return this.componentPlatforms.hashCode();
    }
}
