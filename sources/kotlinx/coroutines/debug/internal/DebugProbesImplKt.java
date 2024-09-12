package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0002¨\u0006\u0002"}, d2 = {"repr", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DebugProbesImpl.kt */
public final class DebugProbesImplKt {
    /* access modifiers changed from: private */
    public static final String repr(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(Typography.quote);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\"') {
                sb.append("\\\"");
            } else if (charAt == '\\') {
                sb.append("\\\\");
            } else if (charAt == 8) {
                sb.append("\\b");
            } else if (charAt == 10) {
                sb.append("\\n");
            } else if (charAt == 13) {
                sb.append("\\r");
            } else if (charAt == 9) {
                sb.append("\\t");
            } else {
                sb.append(charAt);
            }
        }
        sb.append(Typography.quote);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
