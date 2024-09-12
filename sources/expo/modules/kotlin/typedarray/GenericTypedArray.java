package expo.modules.kotlin.typedarray;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\u0016\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0006H¦\u0002¢\u0006\u0002\u0010\u0007J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00028\u0000H¦\u0002¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lexpo/modules/kotlin/typedarray/GenericTypedArray;", "T", "Lexpo/modules/kotlin/typedarray/TypedArray;", "", "get", "index", "", "(I)Ljava/lang/Object;", "iterator", "", "set", "", "value", "(ILjava/lang/Object;)V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GenericTypedArray.kt */
public interface GenericTypedArray<T> extends TypedArray, Iterable<T>, KMappedMarker {
    T get(int i);

    Iterator<T> iterator();

    void set(int i, T t);

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: GenericTypedArray.kt */
    public static final class DefaultImpls {
        public static <T> Iterator<T> iterator(GenericTypedArray<T> genericTypedArray) {
            return new TypedArrayIterator<>(genericTypedArray);
        }
    }
}
