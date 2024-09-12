package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArrayMap.kt */
public final class EmptyArrayMap extends ArrayMap {
    public static final EmptyArrayMap INSTANCE = new EmptyArrayMap();

    public Void get(int i) {
        return null;
    }

    public int getSize() {
        return 0;
    }

    private EmptyArrayMap() {
        super((DefaultConstructorMarker) null);
    }

    public void set(int i, Void voidR) {
        Intrinsics.checkNotNullParameter(voidR, "value");
        throw new IllegalStateException();
    }

    public Iterator iterator() {
        return new EmptyArrayMap$iterator$1();
    }
}
