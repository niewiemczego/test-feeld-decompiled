package expo.modules.kotlin.events;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0003"}, d2 = {"normalizeEventName", "", "eventName", "expo-modules-core_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: KModuleEventEmitterWrapper.kt */
public final class KModuleEventEmitterWrapperKt {
    public static final String normalizeEventName(String str) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        if (!StringsKt.startsWith$default(str, "on", false, 2, (Object) null)) {
            return str;
        }
        String substring = str.substring(2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return "top" + substring;
    }
}
