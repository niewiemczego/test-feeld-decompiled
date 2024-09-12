package expo.modules.kotlin;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Promise.kt */
/* synthetic */ class PromiseKt$toBridgePromise$resolveMethod$2 extends FunctionReferenceImpl implements Function1<Object, Unit> {
    PromiseKt$toBridgePromise$resolveMethod$2(Object obj) {
        super(1, obj, Promise.class, "resolve", "resolve(Ljava/lang/Object;)V", 0);
    }

    public final void invoke(Object obj) {
        ((Promise) this.receiver).resolve(obj);
    }
}
