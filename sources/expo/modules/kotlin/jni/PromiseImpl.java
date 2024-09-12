package expo.modules.kotlin.jni;

import com.adapty.internal.crossplatform.UtilsKt;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.util.JSStackTrace;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.types.JSTypeConverter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\bJ$\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0016\u0010\u0004\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lexpo/modules/kotlin/jni/PromiseImpl;", "Lexpo/modules/kotlin/Promise;", "resolveBlock", "Lexpo/modules/kotlin/jni/JavaCallback;", "rejectBlock", "(Lexpo/modules/kotlin/jni/JavaCallback;Lexpo/modules/kotlin/jni/JavaCallback;)V", "getRejectBlock$expo_modules_core_release", "()Lexpo/modules/kotlin/jni/JavaCallback;", "getResolveBlock$expo_modules_core_release", "wasResolve", "", "checkIfWasResolved", "", "body", "Lkotlin/Function0;", "reject", "code", "", "message", "cause", "", "resolve", "value", "", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PromiseImpl.kt */
public final class PromiseImpl implements Promise {
    private final JavaCallback rejectBlock;
    private final JavaCallback resolveBlock;
    private boolean wasResolve;

    public PromiseImpl(JavaCallback javaCallback, JavaCallback javaCallback2) {
        Intrinsics.checkNotNullParameter(javaCallback, "resolveBlock");
        Intrinsics.checkNotNullParameter(javaCallback2, "rejectBlock");
        this.resolveBlock = javaCallback;
        this.rejectBlock = javaCallback2;
    }

    public void reject(CodedException codedException) {
        Promise.DefaultImpls.reject(this, codedException);
    }

    public final JavaCallback getResolveBlock$expo_modules_core_release() {
        return this.resolveBlock;
    }

    public final JavaCallback getRejectBlock$expo_modules_core_release() {
        return this.rejectBlock;
    }

    private final void checkIfWasResolved(Function0<Unit> function0) {
        if (!this.wasResolve) {
            function0.invoke();
            this.wasResolve = true;
        }
    }

    public void resolve(Object obj) {
        if (!this.wasResolve) {
            this.resolveBlock.invoke(JSTypeConverter.convertToJSValue$default(JSTypeConverter.INSTANCE, obj, (JSTypeConverter.ContainerProvider) null, 2, (Object) null));
            this.wasResolve = true;
        }
    }

    public void reject(String str, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "code");
        if (!this.wasResolve) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("code", str);
            if (str2 != null) {
                writableNativeMap.putString("message", str2);
            } else if (th != null) {
                writableNativeMap.putString("message", th.getMessage());
            } else {
                writableNativeMap.putString("message", "Error not specified.");
            }
            writableNativeMap.putNull("userInfo");
            if (th != null) {
                StackTraceElement[] stackTrace = th.getStackTrace();
                Intrinsics.checkNotNullExpressionValue(stackTrace, "cause.stackTrace");
                WritableNativeArray writableNativeArray = new WritableNativeArray();
                int i = 0;
                while (i < stackTrace.length && i < 50) {
                    StackTraceElement stackTraceElement = stackTrace[i];
                    WritableMap writableNativeMap2 = new WritableNativeMap();
                    writableNativeMap2.putString(UtilsKt.CLASS_KEY, stackTraceElement.getClassName());
                    writableNativeMap2.putString("file", stackTraceElement.getFileName());
                    writableNativeMap2.putInt("lineNumber", stackTraceElement.getLineNumber());
                    writableNativeMap2.putString(JSStackTrace.METHOD_NAME_KEY, stackTraceElement.getMethodName());
                    writableNativeArray.pushMap(writableNativeMap2);
                    i++;
                }
                writableNativeMap.putArray("nativeStackAndroid", writableNativeArray);
            } else {
                writableNativeMap.putArray("nativeStackAndroid", new WritableNativeArray());
            }
            this.rejectBlock.invoke((Object) writableNativeMap);
            this.wasResolve = true;
        }
    }
}
