package coil.disk;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "coil.disk.DiskLruCache$launchCleanup$1", f = "DiskLruCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DiskLruCache.kt */
final class DiskLruCache$launchCleanup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DiskLruCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiskLruCache$launchCleanup$1(DiskLruCache diskLruCache, Continuation<? super DiskLruCache$launchCleanup$1> continuation) {
        super(2, continuation);
        this.this$0 = diskLruCache;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DiskLruCache$launchCleanup$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DiskLruCache$launchCleanup$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:9|10|11|12|13|14|15|(1:17)|20|21|22|23) */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r3.mostRecentRebuildFailed = true;
        r3.journalWriter = okio.Okio.buffer(okio.Okio.blackhole());
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x001f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x002c */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x0040=Splitter:B:24:0x0040, B:14:0x0022=Splitter:B:14:0x0022, B:12:0x001f=Splitter:B:12:0x001f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r3) {
        /*
            r2 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r2.label
            if (r0 != 0) goto L_0x0047
            kotlin.ResultKt.throwOnFailure(r3)
            coil.disk.DiskLruCache r3 = r2.this$0
            monitor-enter(r3)
            boolean r0 = r3.initialized     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0040
            boolean r0 = r3.closed     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x001a
            goto L_0x0040
        L_0x001a:
            r0 = 1
            r3.trimToSize()     // Catch:{ IOException -> 0x001f }
            goto L_0x0022
        L_0x001f:
            r3.mostRecentTrimFailed = r0     // Catch:{ all -> 0x0044 }
        L_0x0022:
            boolean r1 = r3.journalRewriteRequired()     // Catch:{ IOException -> 0x002c }
            if (r1 == 0) goto L_0x003a
            r3.writeJournal()     // Catch:{ IOException -> 0x002c }
            goto L_0x003a
        L_0x002c:
            r3.mostRecentRebuildFailed = r0     // Catch:{ all -> 0x0044 }
            okio.Sink r0 = okio.Okio.blackhole()     // Catch:{ all -> 0x0044 }
            okio.BufferedSink r0 = okio.Okio.buffer((okio.Sink) r0)     // Catch:{ all -> 0x0044 }
            r3.journalWriter = r0     // Catch:{ all -> 0x0044 }
        L_0x003a:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0044 }
            monitor-exit(r3)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        L_0x0040:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0044 }
            monitor-exit(r3)
            return r0
        L_0x0044:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x0047:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.disk.DiskLruCache$launchCleanup$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
