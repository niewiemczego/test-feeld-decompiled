package coil.util;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0001\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"awaitStarted", "", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeAndAddObserver", "observer", "Landroidx/lifecycle/LifecycleObserver;", "coil-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* renamed from: coil.util.-Lifecycles  reason: invalid class name */
/* compiled from: Lifecycles.kt */
public final class Lifecycles {
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object awaitStarted(androidx.lifecycle.Lifecycle r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof coil.util.Lifecycles$awaitStarted$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            coil.util.-Lifecycles$awaitStarted$1 r0 = (coil.util.Lifecycles$awaitStarted$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            coil.util.-Lifecycles$awaitStarted$1 r0 = new coil.util.-Lifecycles$awaitStarted$1
            r0.<init>(r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r6 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r0 = r0.L$0
            androidx.lifecycle.Lifecycle r0 = (androidx.lifecycle.Lifecycle) r0
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0032 }
            goto L_0x008b
        L_0x0032:
            r7 = move-exception
            goto L_0x009c
        L_0x0034:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.lifecycle.Lifecycle$State r7 = r6.getCurrentState()
            androidx.lifecycle.Lifecycle$State r2 = androidx.lifecycle.Lifecycle.State.STARTED
            boolean r7 = r7.isAtLeast(r2)
            if (r7 == 0) goto L_0x004e
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x004e:
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            r0.L$0 = r6     // Catch:{ all -> 0x0097 }
            r0.L$1 = r7     // Catch:{ all -> 0x0097 }
            r0.label = r3     // Catch:{ all -> 0x0097 }
            kotlinx.coroutines.CancellableContinuationImpl r2 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch:{ all -> 0x0097 }
            kotlin.coroutines.Continuation r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)     // Catch:{ all -> 0x0097 }
            r2.<init>(r4, r3)     // Catch:{ all -> 0x0097 }
            r2.initCancellability()     // Catch:{ all -> 0x0097 }
            r3 = r2
            kotlinx.coroutines.CancellableContinuation r3 = (kotlinx.coroutines.CancellableContinuation) r3     // Catch:{ all -> 0x0097 }
            coil.util.-Lifecycles$awaitStarted$2$1 r4 = new coil.util.-Lifecycles$awaitStarted$2$1     // Catch:{ all -> 0x0097 }
            r4.<init>(r3)     // Catch:{ all -> 0x0097 }
            r7.element = r4     // Catch:{ all -> 0x0097 }
            T r3 = r7.element     // Catch:{ all -> 0x0097 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch:{ all -> 0x0097 }
            androidx.lifecycle.LifecycleObserver r3 = (androidx.lifecycle.LifecycleObserver) r3     // Catch:{ all -> 0x0097 }
            r6.addObserver(r3)     // Catch:{ all -> 0x0097 }
            java.lang.Object r2 = r2.getResult()     // Catch:{ all -> 0x0097 }
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x0097 }
            if (r2 != r3) goto L_0x0086
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch:{ all -> 0x0097 }
        L_0x0086:
            if (r2 != r1) goto L_0x0089
            return r1
        L_0x0089:
            r0 = r6
            r6 = r7
        L_0x008b:
            T r6 = r6.element
            androidx.lifecycle.LifecycleObserver r6 = (androidx.lifecycle.LifecycleObserver) r6
            if (r6 == 0) goto L_0x0094
            r0.removeObserver(r6)
        L_0x0094:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0097:
            r0 = move-exception
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
        L_0x009c:
            T r6 = r6.element
            androidx.lifecycle.LifecycleObserver r6 = (androidx.lifecycle.LifecycleObserver) r6
            if (r6 == 0) goto L_0x00a5
            r0.removeObserver(r6)
        L_0x00a5:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.util.Lifecycles.awaitStarted(androidx.lifecycle.Lifecycle, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void removeAndAddObserver(Lifecycle lifecycle, LifecycleObserver lifecycleObserver) {
        lifecycle.removeObserver(lifecycleObserver);
        lifecycle.addObserver(lifecycleObserver);
    }
}
