package com.adapty.internal.domain;

import com.adapty.internal.data.models.PurchaseRecordModel;
import com.adapty.internal.data.models.SyncedPurchase;
import com.adapty.models.AdaptyProfile;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u001e\u0010\u0003\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004H@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "Lcom/adapty/models/AdaptyProfile;", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "", "Lcom/adapty/internal/data/models/PurchaseRecordModel;", "", "Lcom/adapty/internal/data/models/SyncedPurchase;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.PurchasesInteractor$syncPurchasesInternal$2", f = "PurchasesInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PurchasesInteractor.kt */
final class PurchasesInteractor$syncPurchasesInternal$2 extends SuspendLambda implements Function2<Pair<? extends List<? extends PurchaseRecordModel>, ? extends Set<? extends SyncedPurchase>>, Continuation<? super Flow<? extends AdaptyProfile>>, Object> {
    final /* synthetic */ boolean $byUser;
    final /* synthetic */ long $maxAttemptCount;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PurchasesInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PurchasesInteractor$syncPurchasesInternal$2(boolean z, PurchasesInteractor purchasesInteractor, long j, Continuation<? super PurchasesInteractor$syncPurchasesInternal$2> continuation) {
        super(2, continuation);
        this.$byUser = z;
        this.this$0 = purchasesInteractor;
        this.$maxAttemptCount = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PurchasesInteractor$syncPurchasesInternal$2 purchasesInteractor$syncPurchasesInternal$2 = new PurchasesInteractor$syncPurchasesInternal$2(this.$byUser, this.this$0, this.$maxAttemptCount, continuation);
        purchasesInteractor$syncPurchasesInternal$2.L$0 = obj;
        return purchasesInteractor$syncPurchasesInternal$2;
    }

    public final Object invoke(Pair<? extends List<PurchaseRecordModel>, ? extends Set<SyncedPurchase>> pair, Continuation<? super Flow<AdaptyProfile>> continuation) {
        return ((PurchasesInteractor$syncPurchasesInternal$2) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0079 A[EDGE_INSN: B:47:0x0079->B:21:0x0079 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r13.label
            if (r0 != 0) goto L_0x010b
            kotlin.ResultKt.throwOnFailure(r14)
            java.lang.Object r14 = r13.L$0
            kotlin.Pair r14 = (kotlin.Pair) r14
            java.lang.Object r0 = r14.component1()
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r14 = r14.component2()
            r6 = r14
            java.util.Set r6 = (java.util.Set) r6
            boolean r14 = r13.$byUser
            r1 = 1
            if (r14 == 0) goto L_0x0022
        L_0x0020:
            r5 = r0
            goto L_0x0086
        L_0x0022:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.Collection r14 = (java.util.Collection) r14
            java.util.Iterator r0 = r0.iterator()
        L_0x002f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0082
            java.lang.Object r2 = r0.next()
            r3 = r2
            com.adapty.internal.data.models.PurchaseRecordModel r3 = (com.adapty.internal.data.models.PurchaseRecordModel) r3
            r4 = r6
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x0043:
            boolean r5 = r4.hasNext()
            r7 = 0
            if (r5 == 0) goto L_0x0078
            java.lang.Object r5 = r4.next()
            r8 = r5
            com.adapty.internal.data.models.SyncedPurchase r8 = (com.adapty.internal.data.models.SyncedPurchase) r8
            java.lang.String r9 = r8.getPurchaseToken()
            java.lang.String r10 = r3.getPurchaseToken()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r9 == 0) goto L_0x0074
            java.lang.Long r8 = r8.getPurchaseTime()
            long r9 = r3.getPurchaseTime()
            if (r8 != 0) goto L_0x006a
            goto L_0x0074
        L_0x006a:
            long r11 = r8.longValue()
            int r8 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r8 != 0) goto L_0x0074
            r8 = r1
            goto L_0x0075
        L_0x0074:
            r8 = r7
        L_0x0075:
            if (r8 == 0) goto L_0x0043
            goto L_0x0079
        L_0x0078:
            r5 = 0
        L_0x0079:
            if (r5 != 0) goto L_0x007c
            r7 = r1
        L_0x007c:
            if (r7 == 0) goto L_0x002f
            r14.add(r2)
            goto L_0x002f
        L_0x0082:
            r0 = r14
            java.util.List r0 = (java.util.List) r0
            goto L_0x0020
        L_0x0086:
            r14 = r5
            java.util.Collection r14 = (java.util.Collection) r14
            boolean r14 = r14.isEmpty()
            r14 = r14 ^ r1
            if (r14 == 0) goto L_0x00da
            com.adapty.internal.domain.PurchasesInteractor r14 = r13.this$0
            com.adapty.internal.data.cloud.StoreManager r14 = r14.storeManager
            r0 = r5
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x00a4:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00c0
            java.lang.Object r2 = r0.next()
            com.adapty.internal.data.models.PurchaseRecordModel r2 = (com.adapty.internal.data.models.PurchaseRecordModel) r2
            java.util.List r2 = r2.getProducts()
            java.lang.Object r2 = kotlin.collections.CollectionsKt.firstOrNull(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x00a4
            r1.add(r2)
            goto L_0x00a4
        L_0x00c0:
            java.util.List r1 = (java.util.List) r1
            long r2 = r13.$maxAttemptCount
            kotlinx.coroutines.flow.Flow r14 = r14.queryProductDetails(r1, r2)
            com.adapty.internal.domain.PurchasesInteractor$syncPurchasesInternal$2$2 r0 = new com.adapty.internal.domain.PurchasesInteractor$syncPurchasesInternal$2$2
            com.adapty.internal.domain.PurchasesInteractor r2 = r13.this$0
            long r3 = r13.$maxAttemptCount
            r7 = 0
            r1 = r0
            r1.<init>(r2, r3, r5, r6, r7)
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            kotlinx.coroutines.flow.Flow r14 = kotlinx.coroutines.flow.FlowKt.flatMapConcat(r14, r0)
            return r14
        L_0x00da:
            com.adapty.internal.domain.PurchasesInteractor r14 = r13.this$0
            com.adapty.internal.data.cache.CacheRepository r14 = r14.cacheRepository
            r14.setPurchasesHaveBeenSynced(r1)
            java.lang.String r4 = "No purchases to restore"
            com.adapty.internal.utils.Logger r14 = com.adapty.internal.utils.Logger.INSTANCE
            com.adapty.utils.AdaptyLogLevel r0 = com.adapty.utils.AdaptyLogLevel.INFO
            int r1 = r0.value
            boolean r1 = r14.canLog(r1)
            if (r1 == 0) goto L_0x00ff
            java.util.concurrent.ExecutorService r14 = r14.getLogExecutor()
            com.adapty.internal.utils.Logger$log$1 r1 = new com.adapty.internal.utils.Logger$log$1
            r1.<init>(r0, r4)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r14.execute(r1)
        L_0x00ff:
            com.adapty.errors.AdaptyError r14 = new com.adapty.errors.AdaptyError
            r3 = 0
            com.adapty.errors.AdaptyErrorCode r5 = com.adapty.errors.AdaptyErrorCode.NO_PURCHASES_TO_RESTORE
            r6 = 1
            r7 = 0
            r2 = r14
            r2.<init>(r3, r4, r5, r6, r7)
            throw r14
        L_0x010b:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.domain.PurchasesInteractor$syncPurchasesInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
