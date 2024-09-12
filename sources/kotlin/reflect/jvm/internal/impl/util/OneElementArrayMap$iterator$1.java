package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: ArrayMap.kt */
public final class OneElementArrayMap$iterator$1 implements Iterator<T>, KMappedMarker {
    private boolean notVisited = true;
    final /* synthetic */ OneElementArrayMap<T> this$0;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    OneElementArrayMap$iterator$1(OneElementArrayMap<T> oneElementArrayMap) {
        this.this$0 = oneElementArrayMap;
    }

    public boolean hasNext() {
        return this.notVisited;
    }

    public T next() {
        if (this.notVisited) {
            this.notVisited = false;
            return this.this$0.getValue();
        }
        throw new NoSuchElementException();
    }
}
