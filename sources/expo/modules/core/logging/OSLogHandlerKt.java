package expo.modules.core.logging;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0002"}, d2 = {"isAndroid", "", "expo-modules-core_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: OSLogHandler.kt */
public final class OSLogHandlerKt {
    /* access modifiers changed from: private */
    public static final boolean isAndroid = Intrinsics.areEqual((Object) "The Android Project", (Object) System.getProperty("java.specification.vendor"));
}
