package expo.modules.kotlin;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\rH\u0002J\t\u0010\u000e\u001a\u00020\u0002H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lexpo/modules/kotlin/ReadableArrayIterator;", "", "Lcom/facebook/react/bridge/Dynamic;", "array", "Lcom/facebook/react/bridge/ReadableArray;", "(Lcom/facebook/react/bridge/ReadableArray;)V", "current", "", "getCurrent", "()I", "setCurrent", "(I)V", "hasNext", "", "next", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ReadableArrayIterator.kt */
public final class ReadableArrayIterator implements Iterator<Dynamic>, KMappedMarker {
    private final ReadableArray array;
    private int current;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public ReadableArrayIterator(ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(readableArray, "array");
        this.array = readableArray;
    }

    public final int getCurrent() {
        return this.current;
    }

    public final void setCurrent(int i) {
        this.current = i;
    }

    public boolean hasNext() {
        return this.current < this.array.size();
    }

    public Dynamic next() {
        ReadableArray readableArray = this.array;
        int i = this.current;
        this.current = i + 1;
        Dynamic dynamic = readableArray.getDynamic(i);
        Intrinsics.checkNotNullExpressionValue(dynamic, "array.getDynamic(current++)");
        return dynamic;
    }
}
