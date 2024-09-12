package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import java.lang.Throwable;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends FluentFuture.TrustedFuture<V> implements Runnable {
    @CheckForNull
    Class<X> exceptionType;
    @CheckForNull
    F fallback;
    @CheckForNull
    ListenableFuture<? extends V> inputFuture;

    /* access modifiers changed from: package-private */
    @ParametricNullness
    public abstract T doFallback(F f, X x) throws Exception;

    /* access modifiers changed from: package-private */
    public abstract void setResult(@ParametricNullness T t);

    static <V, X extends Throwable> ListenableFuture<V> create(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        CatchingFuture catchingFuture = new CatchingFuture(listenableFuture, cls, function);
        listenableFuture.addListener(catchingFuture, MoreExecutors.rejectionPropagatingExecutor(executor, catchingFuture));
        return catchingFuture;
    }

    static <X extends Throwable, V> ListenableFuture<V> create(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        AsyncCatchingFuture asyncCatchingFuture = new AsyncCatchingFuture(listenableFuture, cls, asyncFunction);
        listenableFuture.addListener(asyncCatchingFuture, MoreExecutors.rejectionPropagatingExecutor(executor, asyncCatchingFuture));
        return asyncCatchingFuture;
    }

    AbstractCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, F f) {
        this.inputFuture = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        this.exceptionType = (Class) Preconditions.checkNotNull(cls);
        this.fallback = Preconditions.checkNotNull(f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r9 = this;
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r9.inputFuture
            java.lang.Class<X> r1 = r9.exceptionType
            F r2 = r9.fallback
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x000c
            r5 = r3
            goto L_0x000d
        L_0x000c:
            r5 = r4
        L_0x000d:
            if (r1 != 0) goto L_0x0011
            r6 = r3
            goto L_0x0012
        L_0x0011:
            r6 = r4
        L_0x0012:
            r5 = r5 | r6
            if (r2 != 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r3 = r4
        L_0x0017:
            r3 = r3 | r5
            if (r3 != 0) goto L_0x00bf
            boolean r3 = r9.isCancelled()
            if (r3 == 0) goto L_0x0022
            goto L_0x00bf
        L_0x0022:
            r3 = 0
            r9.inputFuture = r3
            boolean r4 = r0 instanceof com.google.common.util.concurrent.internal.InternalFutureFailureAccess     // Catch:{ ExecutionException -> 0x003c, all -> 0x0039 }
            if (r4 == 0) goto L_0x0031
            r4 = r0
            com.google.common.util.concurrent.internal.InternalFutureFailureAccess r4 = (com.google.common.util.concurrent.internal.InternalFutureFailureAccess) r4     // Catch:{ ExecutionException -> 0x003c, all -> 0x0039 }
            java.lang.Throwable r4 = com.google.common.util.concurrent.internal.InternalFutures.tryInternalFastPathGetFailure(r4)     // Catch:{ ExecutionException -> 0x003c, all -> 0x0039 }
            goto L_0x0032
        L_0x0031:
            r4 = r3
        L_0x0032:
            if (r4 != 0) goto L_0x003a
            java.lang.Object r5 = com.google.common.util.concurrent.Futures.getDone(r0)     // Catch:{ ExecutionException -> 0x003c, all -> 0x0039 }
            goto L_0x0090
        L_0x0039:
            r4 = move-exception
        L_0x003a:
            r5 = r3
            goto L_0x0090
        L_0x003c:
            r4 = move-exception
            java.lang.Throwable r5 = r4.getCause()
            if (r5 != 0) goto L_0x008e
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.Class r6 = r0.getClass()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r7 = java.lang.String.valueOf(r6)
            int r7 = r7.length()
            int r7 = r7 + 35
            java.lang.String r8 = java.lang.String.valueOf(r4)
            int r8 = r8.length()
            int r7 = r7 + r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r7)
            java.lang.String r7 = "Future type "
            java.lang.StringBuilder r7 = r8.append(r7)
            java.lang.StringBuilder r6 = r7.append(r6)
            java.lang.String r7 = " threw "
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r4 = r6.append(r4)
            java.lang.String r6 = " without a cause"
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
        L_0x008e:
            r4 = r5
            goto L_0x003a
        L_0x0090:
            if (r4 != 0) goto L_0x009a
            java.lang.Object r0 = com.google.common.util.concurrent.NullnessCasts.uncheckedCastNullableTToT(r5)
            r9.set(r0)
            return
        L_0x009a:
            boolean r1 = com.google.common.util.concurrent.Platform.isInstanceOfThrowableClass(r4, r1)
            if (r1 != 0) goto L_0x00a4
            r9.setFuture(r0)
            return
        L_0x00a4:
            java.lang.Object r0 = r9.doFallback(r2, r4)     // Catch:{ all -> 0x00b0 }
            r9.exceptionType = r3
            r9.fallback = r3
            r9.setResult(r0)
            return
        L_0x00b0:
            r0 = move-exception
            r9.setException(r0)     // Catch:{ all -> 0x00b9 }
            r9.exceptionType = r3
            r9.fallback = r3
            return
        L_0x00b9:
            r0 = move-exception
            r9.exceptionType = r3
            r9.fallback = r3
            throw r0
        L_0x00bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractCatchingFuture.run():void");
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public String pendingToString() {
        String str;
        ListenableFuture<? extends V> listenableFuture = this.inputFuture;
        Class<X> cls = this.exceptionType;
        F f = this.fallback;
        String pendingToString = super.pendingToString();
        if (listenableFuture != null) {
            String valueOf = String.valueOf(listenableFuture);
            str = new StringBuilder(String.valueOf(valueOf).length() + 16).append("inputFuture=[").append(valueOf).append("], ").toString();
        } else {
            str = "";
        }
        if (cls != null && f != null) {
            String valueOf2 = String.valueOf(cls);
            String valueOf3 = String.valueOf(f);
            return new StringBuilder(String.valueOf(str).length() + 29 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length()).append(str).append("exceptionType=[").append(valueOf2).append("], fallback=[").append(valueOf3).append("]").toString();
        } else if (pendingToString == null) {
            return null;
        } else {
            String valueOf4 = String.valueOf(str);
            String valueOf5 = String.valueOf(pendingToString);
            return valueOf5.length() != 0 ? valueOf4.concat(valueOf5) : new String(valueOf4);
        }
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.exceptionType = null;
        this.fallback = null;
    }

    private static final class AsyncCatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, AsyncFunction<? super X, ? extends V>, ListenableFuture<? extends V>> {
        AsyncCatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction) {
            super(listenableFuture, cls, asyncFunction);
        }

        /* access modifiers changed from: package-private */
        public ListenableFuture<? extends V> doFallback(AsyncFunction<? super X, ? extends V> asyncFunction, X x) throws Exception {
            ListenableFuture<? extends V> apply = asyncFunction.apply(x);
            Preconditions.checkNotNull(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", (Object) asyncFunction);
            return apply;
        }

        /* access modifiers changed from: package-private */
        public void setResult(ListenableFuture<? extends V> listenableFuture) {
            setFuture(listenableFuture);
        }
    }

    private static final class CatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, Function<? super X, ? extends V>, V> {
        CatchingFuture(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function) {
            super(listenableFuture, cls, function);
        }

        /* access modifiers changed from: package-private */
        @ParametricNullness
        public V doFallback(Function<? super X, ? extends V> function, X x) throws Exception {
            return function.apply(x);
        }

        /* access modifiers changed from: package-private */
        public void setResult(@ParametricNullness V v) {
            set(v);
        }
    }
}
