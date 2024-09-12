package expo.modules.kotlin.jni;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0002"}, d2 = {"nextValue", "", "expo-modules-core_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: CppType.kt */
public final class CppTypeKt {
    private static int nextValue;

    /* access modifiers changed from: private */
    public static final int nextValue() {
        int i = nextValue;
        int i2 = 1 << i;
        nextValue = i + 1;
        return i2;
    }
}
