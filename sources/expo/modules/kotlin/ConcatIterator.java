package expo.modules.kotlin;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lexpo/modules/kotlin/ConcatIterator;", "T", "", "first", "second", "(Ljava/util/Iterator;Ljava/util/Iterator;)V", "hasNext", "", "next", "()Ljava/lang/Object;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConcatIterator.kt */
public final class ConcatIterator<T> implements Iterator<T>, KMappedMarker {
    private final Iterator<T> first;
    private final Iterator<T> second;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public ConcatIterator(Iterator<? extends T> it, Iterator<? extends T> it2) {
        Intrinsics.checkNotNullParameter(it, "first");
        Intrinsics.checkNotNullParameter(it2, "second");
        this.first = it;
        this.second = it2;
    }

    public boolean hasNext() {
        return this.first.hasNext() || this.second.hasNext();
    }

    public T next() {
        if (this.first.hasNext()) {
            return this.first.next();
        }
        return this.second.next();
    }
}
