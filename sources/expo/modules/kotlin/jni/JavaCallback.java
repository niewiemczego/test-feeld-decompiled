package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import expo.modules.kotlin.exception.UnexpectedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0004J\t\u0010\u0007\u001a\u00020\u0006H J\u0011\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH J\u0011\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\nH J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0002J\u0011\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u000bH J\u0011\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\fH J\u0011\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\rH J\u0011\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u000eH J\u0011\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u000fH R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lexpo/modules/kotlin/jni/JavaCallback;", "", "mHybridData", "Lcom/facebook/jni/HybridData;", "(Lcom/facebook/jni/HybridData;)V", "finalize", "", "invoke", "result", "Lcom/facebook/react/bridge/WritableNativeArray;", "Lcom/facebook/react/bridge/WritableNativeMap;", "", "", "", "", "", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: JavaCallback.kt */
public final class JavaCallback {
    private final HybridData mHybridData;

    private final native void invoke();

    private final native void invoke(double d);

    private final native void invoke(float f);

    private final native void invoke(int i);

    private final native void invoke(WritableNativeArray writableNativeArray);

    private final native void invoke(WritableNativeMap writableNativeMap);

    private final native void invoke(String str);

    private final native void invoke(boolean z);

    public JavaCallback(HybridData hybridData) {
        Intrinsics.checkNotNullParameter(hybridData, "mHybridData");
        this.mHybridData = hybridData;
    }

    public final void invoke(Object obj) {
        if (obj == null) {
            invoke();
        } else if (obj instanceof Integer) {
            invoke(((Number) obj).intValue());
        } else if (obj instanceof Boolean) {
            invoke(((Boolean) obj).booleanValue());
        } else if (obj instanceof Double) {
            invoke(((Number) obj).doubleValue());
        } else if (obj instanceof Float) {
            invoke(((Number) obj).floatValue());
        } else if (obj instanceof String) {
            invoke((String) obj);
        } else if (obj instanceof WritableNativeArray) {
            invoke((WritableNativeArray) obj);
        } else if (obj instanceof WritableNativeMap) {
            invoke((WritableNativeMap) obj);
        } else {
            throw new UnexpectedException("Unknown type: " + obj.getClass());
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        this.mHybridData.resetNative();
    }
}
