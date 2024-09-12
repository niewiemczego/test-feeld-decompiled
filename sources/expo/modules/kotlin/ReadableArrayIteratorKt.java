package expo.modules.kotlin;

import com.facebook.react.bridge.ReadableArray;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"iterator", "Lexpo/modules/kotlin/ReadableArrayIterator;", "Lcom/facebook/react/bridge/ReadableArray;", "expo-modules-core_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ReadableArrayIterator.kt */
public final class ReadableArrayIteratorKt {
    public static final ReadableArrayIterator iterator(ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(readableArray, "<this>");
        return new ReadableArrayIterator(readableArray);
    }
}
