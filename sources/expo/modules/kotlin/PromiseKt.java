package expo.modules.kotlin;

import com.facebook.react.bridge.Promise;
import expo.modules.kotlin.jni.PromiseImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"unknownCode", "", "toBridgePromise", "Lcom/facebook/react/bridge/Promise;", "Lexpo/modules/kotlin/Promise;", "expo-modules-core_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Promise.kt */
public final class PromiseKt {
    private static final String unknownCode = "UnknownCode";

    public static final Promise toBridgePromise(Promise promise) {
        KFunction kFunction;
        Intrinsics.checkNotNullParameter(promise, "<this>");
        if (promise instanceof PromiseImpl) {
            kFunction = new PromiseKt$toBridgePromise$resolveMethod$1(((PromiseImpl) promise).getResolveBlock$expo_modules_core_release());
        } else {
            kFunction = new PromiseKt$toBridgePromise$resolveMethod$2(promise);
        }
        return new PromiseKt$toBridgePromise$1(kFunction, promise);
    }
}
