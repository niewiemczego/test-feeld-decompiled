package expo.modules.kotlin;

import expo.modules.kotlin.jni.JavaCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Promise.kt */
/* synthetic */ class PromiseKt$toBridgePromise$resolveMethod$1 extends FunctionReferenceImpl implements Function1<Object, Unit> {
    PromiseKt$toBridgePromise$resolveMethod$1(Object obj) {
        super(1, obj, JavaCallback.class, "invoke", "invoke(Ljava/lang/Object;)V", 0);
    }

    public final void invoke(Object obj) {
        ((JavaCallback) this.receiver).invoke(obj);
    }
}
