package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.NativeMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH J\b\u0010\r\u001a\u00020\nH\u0004J\t\u0010\u000e\u001a\u00020\u0006H J4\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0016H ¢\u0006\u0002\u0010\u0017J-\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH J4\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u001bH ¢\u0006\u0002\u0010\u001eR\u0010\u0010\u0005\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001f"}, d2 = {"Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "", "name", "", "(Ljava/lang/String;)V", "mHybridData", "Lcom/facebook/jni/HybridData;", "getName", "()Ljava/lang/String;", "exportConstants", "", "constants", "Lcom/facebook/react/bridge/NativeMap;", "finalize", "initHybrid", "registerAsyncFunction", "args", "", "desiredTypes", "", "Lexpo/modules/kotlin/jni/ExpectedType;", "body", "Lexpo/modules/kotlin/jni/JNIAsyncFunctionBody;", "(Ljava/lang/String;I[Lexpo/modules/kotlin/jni/ExpectedType;Lexpo/modules/kotlin/jni/JNIAsyncFunctionBody;)V", "registerProperty", "desiredType", "getter", "Lexpo/modules/kotlin/jni/JNIFunctionBody;", "setter", "registerSyncFunction", "(Ljava/lang/String;I[Lexpo/modules/kotlin/jni/ExpectedType;Lexpo/modules/kotlin/jni/JNIFunctionBody;)V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: JavaScriptModuleObject.kt */
public final class JavaScriptModuleObject {
    private final HybridData mHybridData = initHybrid();
    private final String name;

    private final native HybridData initHybrid();

    public final native void exportConstants(NativeMap nativeMap);

    public final native void registerAsyncFunction(String str, int i, ExpectedType[] expectedTypeArr, JNIAsyncFunctionBody jNIAsyncFunctionBody);

    public final native void registerProperty(String str, ExpectedType expectedType, JNIFunctionBody jNIFunctionBody, JNIFunctionBody jNIFunctionBody2);

    public final native void registerSyncFunction(String str, int i, ExpectedType[] expectedTypeArr, JNIFunctionBody jNIFunctionBody);

    public JavaScriptModuleObject(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        this.mHybridData.resetNative();
    }
}
