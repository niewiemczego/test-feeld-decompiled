package expo.modules.kotlin.typedarray;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\n\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/typedarray/TypedArrayIterator;", "T", "", "typedArray", "Lexpo/modules/kotlin/typedarray/GenericTypedArray;", "(Lexpo/modules/kotlin/typedarray/GenericTypedArray;)V", "current", "", "hasNext", "", "next", "()Ljava/lang/Object;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TypedArrayIterator.kt */
public final class TypedArrayIterator<T> implements Iterator<T>, KMappedMarker {
    private int current;
    private final GenericTypedArray<T> typedArray;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public TypedArrayIterator(GenericTypedArray<T> genericTypedArray) {
        Intrinsics.checkNotNullParameter(genericTypedArray, "typedArray");
        this.typedArray = genericTypedArray;
    }

    public boolean hasNext() {
        return this.current < this.typedArray.getLength();
    }

    public T next() {
        GenericTypedArray<T> genericTypedArray = this.typedArray;
        int i = this.current;
        this.current = i + 1;
        return genericTypedArray.get(i);
    }
}
