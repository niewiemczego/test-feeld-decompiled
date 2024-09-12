package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0004J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\bH ¢\u0006\u0002\u0010\tJ\t\u0010\n\u001a\u00020\u000bH J\t\u0010\f\u001a\u00020\rH J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\t\u0010\u0014\u001a\u00020\u0015H J\t\u0010\u0016\u001a\u00020\u0017H J\t\u0010\u0018\u001a\u00020\u0019H J\t\u0010\u001a\u001a\u00020\u000bH J\t\u0010\u001b\u001a\u00020\u000bH J\t\u0010\u001c\u001a\u00020\u000bH J\t\u0010\u001d\u001a\u00020\u000bH J\t\u0010\u001e\u001a\u00020\u000bH J\t\u0010\u001f\u001a\u00020\u000bH J\t\u0010 \u001a\u00020\u000bH J\t\u0010!\u001a\u00020\u000bH J\t\u0010\"\u001a\u00020\u000bH J\t\u0010#\u001a\u00020\u000bH J\t\u0010$\u001a\u00020\u0017H R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lexpo/modules/kotlin/jni/JavaScriptValue;", "", "mHybridData", "Lcom/facebook/jni/HybridData;", "(Lcom/facebook/jni/HybridData;)V", "finalize", "", "getArray", "", "()[Lexpo/modules/kotlin/jni/JavaScriptValue;", "getBool", "", "getDouble", "", "getFloat", "", "getInt", "", "getLong", "", "getObject", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "getString", "", "getTypedArray", "Lexpo/modules/kotlin/jni/JavaScriptTypedArray;", "isArray", "isBool", "isFunction", "isNull", "isNumber", "isObject", "isString", "isSymbol", "isTypedArray", "isUndefined", "kind", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: JavaScriptValue.kt */
public final class JavaScriptValue {
    private final HybridData mHybridData;

    public final native JavaScriptValue[] getArray();

    public final native boolean getBool();

    public final native double getDouble();

    public final native JavaScriptObject getObject();

    public final native String getString();

    public final native JavaScriptTypedArray getTypedArray();

    public final native boolean isArray();

    public final native boolean isBool();

    public final native boolean isFunction();

    public final native boolean isNull();

    public final native boolean isNumber();

    public final native boolean isObject();

    public final native boolean isString();

    public final native boolean isSymbol();

    public final native boolean isTypedArray();

    public final native boolean isUndefined();

    public final native String kind();

    private JavaScriptValue(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public final int getInt() {
        return (int) getDouble();
    }

    public final long getLong() {
        return (long) getDouble();
    }

    public final float getFloat() {
        return (float) getDouble();
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        this.mHybridData.resetNative();
    }
}
