package coil.util;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "coil.util.-Lifecycles", f = "Lifecycles.kt", i = {0, 0}, l = {44}, m = "awaitStarted", n = {"$this$awaitStarted", "observer"}, s = {"L$0", "L$1"})
/* renamed from: coil.util.-Lifecycles$awaitStarted$1  reason: invalid class name */
/* compiled from: Lifecycles.kt */
final class Lifecycles$awaitStarted$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    Lifecycles$awaitStarted$1(Continuation<? super Lifecycles$awaitStarted$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return Lifecycles.awaitStarted((Lifecycle) null, this);
    }
}
