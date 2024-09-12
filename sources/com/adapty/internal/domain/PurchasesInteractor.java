package com.adapty.internal.domain;

import android.app.Activity;
import com.adapty.internal.data.cache.CacheRepository;
import com.adapty.internal.data.cloud.CloudRepository;
import com.adapty.internal.data.cloud.StoreManager;
import com.adapty.internal.domain.models.PurchaseableProduct;
import com.adapty.internal.utils.ProductMapper;
import com.adapty.internal.utils.ProfileMapper;
import com.adapty.models.AdaptyPaywallProduct;
import com.adapty.models.AdaptyProfile;
import com.adapty.models.AdaptyPurchasedInfo;
import com.adapty.models.AdaptySubscriptionUpdateParameters;
import com.android.billingclient.api.Purchase;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J-\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ0\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001c2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010 \u001a\u00020!J\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001cJ\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u001c2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'J\u0019\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010*J\"\u0010+\u001a\b\u0012\u0004\u0012\u00020#0\u001c2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020!H\u0002J\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020#0\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010*J\u001e\u00100\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u00101\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Lcom/adapty/internal/domain/PurchasesInteractor;", "", "authInteractor", "Lcom/adapty/internal/domain/AuthInteractor;", "profileInteractor", "Lcom/adapty/internal/domain/ProfileInteractor;", "cloudRepository", "Lcom/adapty/internal/data/cloud/CloudRepository;", "cacheRepository", "Lcom/adapty/internal/data/cache/CacheRepository;", "storeManager", "Lcom/adapty/internal/data/cloud/StoreManager;", "productMapper", "Lcom/adapty/internal/utils/ProductMapper;", "profileMapper", "Lcom/adapty/internal/utils/ProfileMapper;", "(Lcom/adapty/internal/domain/AuthInteractor;Lcom/adapty/internal/domain/ProfileInteractor;Lcom/adapty/internal/data/cloud/CloudRepository;Lcom/adapty/internal/data/cache/CacheRepository;Lcom/adapty/internal/data/cloud/StoreManager;Lcom/adapty/internal/utils/ProductMapper;Lcom/adapty/internal/utils/ProfileMapper;)V", "syncPurchasesSemaphore", "Lkotlinx/coroutines/sync/Semaphore;", "makePurchase", "Lcom/android/billingclient/api/Purchase;", "activity", "Landroid/app/Activity;", "purchaseableProduct", "Lcom/adapty/internal/domain/models/PurchaseableProduct;", "subscriptionUpdateParams", "Lcom/adapty/models/AdaptySubscriptionUpdateParameters;", "(Landroid/app/Activity;Lcom/adapty/internal/domain/models/PurchaseableProduct;Lcom/adapty/models/AdaptySubscriptionUpdateParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "Lcom/adapty/models/AdaptyPurchasedInfo;", "product", "Lcom/adapty/models/AdaptyPaywallProduct;", "isOfferPersonalized", "", "restorePurchases", "Lcom/adapty/models/AdaptyProfile;", "setVariationId", "", "transactionId", "", "variationId", "syncPurchasesIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncPurchasesInternal", "maxAttemptCount", "", "byUser", "syncPurchasesOnStart", "validatePurchase", "purchase", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PurchasesInteractor.kt */
public final class PurchasesInteractor {
    /* access modifiers changed from: private */
    public final AuthInteractor authInteractor;
    /* access modifiers changed from: private */
    public final CacheRepository cacheRepository;
    /* access modifiers changed from: private */
    public final CloudRepository cloudRepository;
    /* access modifiers changed from: private */
    public final ProductMapper productMapper;
    /* access modifiers changed from: private */
    public final ProfileInteractor profileInteractor;
    /* access modifiers changed from: private */
    public final ProfileMapper profileMapper;
    /* access modifiers changed from: private */
    public final StoreManager storeManager;
    /* access modifiers changed from: private */
    public final Semaphore syncPurchasesSemaphore = SemaphoreKt.Semaphore$default(1, 0, 2, (Object) null);

    public PurchasesInteractor(AuthInteractor authInteractor2, ProfileInteractor profileInteractor2, CloudRepository cloudRepository2, CacheRepository cacheRepository2, StoreManager storeManager2, ProductMapper productMapper2, ProfileMapper profileMapper2) {
        Intrinsics.checkNotNullParameter(authInteractor2, "authInteractor");
        Intrinsics.checkNotNullParameter(profileInteractor2, "profileInteractor");
        Intrinsics.checkNotNullParameter(cloudRepository2, "cloudRepository");
        Intrinsics.checkNotNullParameter(cacheRepository2, "cacheRepository");
        Intrinsics.checkNotNullParameter(storeManager2, "storeManager");
        Intrinsics.checkNotNullParameter(productMapper2, "productMapper");
        Intrinsics.checkNotNullParameter(profileMapper2, "profileMapper");
        this.authInteractor = authInteractor2;
        this.profileInteractor = profileInteractor2;
        this.cloudRepository = cloudRepository2;
        this.cacheRepository = cacheRepository2;
        this.storeManager = storeManager2;
        this.productMapper = productMapper2;
        this.profileMapper = profileMapper2;
        Job unused = Intrinsics.checkNotNullParameter(new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), "block");
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.adapty.internal.domain.PurchasesInteractor$1", f = "PurchasesInteractor.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.adapty.internal.domain.PurchasesInteractor$1  reason: invalid class name */
    /* compiled from: PurchasesInteractor.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PurchasesInteractor this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow subscribeOnEventsForStartRequests = this.this$0.profileInteractor.subscribeOnEventsForStartRequests();
                final PurchasesInteractor purchasesInteractor = this.this$0;
                this.label = 1;
                if (FlowKt.collect(FlowKt.m2547catch(Intrinsics.checkNotNullParameter(FlowKt.onEach(subscribeOnEventsForStartRequests, new Function2<Pair<? extends Boolean, ? extends Boolean>, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    /* synthetic */ Object L$0;
                    int label;

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass1 r0 = 

                        public final /* synthetic */ Flow makePurchase(Activity activity, AdaptyPaywallProduct adaptyPaywallProduct, AdaptySubscriptionUpdateParameters adaptySubscriptionUpdateParameters, boolean z) {
                            Intrinsics.checkNotNullParameter(activity, "activity");
                            Intrinsics.checkNotNullParameter(adaptyPaywallProduct, "product");
                            return Intrinsics.checkNotNullParameter(FlowKt.flatMapConcat(this.storeManager.queryInfoForProduct(adaptyPaywallProduct.getVendorProductId(), adaptyPaywallProduct.getPayloadData$adapty_release().getType()), new PurchasesInteractor$makePurchase$1(this, adaptyPaywallProduct, z, activity, adaptySubscriptionUpdateParameters, (Continuation<? super PurchasesInteractor$makePurchase$1>) null)), "<this>");
                        }

                        /* access modifiers changed from: private */
                        public final Flow<AdaptyPurchasedInfo> validatePurchase(Purchase purchase, PurchaseableProduct purchaseableProduct) {
                            return new PurchasesInteractor$validatePurchase$$inlined$map$1(FlowKt.m2547catch(AuthInteractor.runWhenAuthDataSynced$default(this.authInteractor, 0, (Function0) null, new PurchasesInteractor$validatePurchase$1(this, purchase, purchaseableProduct, (Continuation<? super PurchasesInteractor$validatePurchase$1>) null), 3, (Object) null), new PurchasesInteractor$validatePurchase$2(this, purchase, purchaseableProduct, (Continuation<? super PurchasesInteractor$validatePurchase$2>) null)), this, purchase);
                        }

                        public final /* synthetic */ Flow restorePurchases() {
                            return Intrinsics.checkNotNullParameter(syncPurchasesInternal(3, true), "<this>");
                        }

                        /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
                        /* JADX WARNING: Removed duplicated region for block: B:22:0x005d  */
                        /* JADX WARNING: Removed duplicated region for block: B:23:0x0067  */
                        /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final /* synthetic */ java.lang.Object syncPurchasesIfNeeded(kotlin.coroutines.Continuation r12) {
                            /*
                                r11 = this;
                                boolean r0 = r12 instanceof com.adapty.internal.domain.PurchasesInteractor$syncPurchasesIfNeeded$1
                                if (r0 == 0) goto L_0x0014
                                r0 = r12
                                com.adapty.internal.domain.PurchasesInteractor$syncPurchasesIfNeeded$1 r0 = (com.adapty.internal.domain.PurchasesInteractor$syncPurchasesIfNeeded$1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r1 = r1 & r2
                                if (r1 == 0) goto L_0x0014
                                int r12 = r0.label
                                int r12 = r12 - r2
                                r0.label = r12
                                goto L_0x0019
                            L_0x0014:
                                com.adapty.internal.domain.PurchasesInteractor$syncPurchasesIfNeeded$1 r0 = new com.adapty.internal.domain.PurchasesInteractor$syncPurchasesIfNeeded$1
                                r0.<init>(r11, r12)
                            L_0x0019:
                                java.lang.Object r12 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 1
                                r4 = 0
                                if (r2 == 0) goto L_0x0037
                                if (r2 != r3) goto L_0x002f
                                java.lang.Object r0 = r0.L$0
                                com.adapty.internal.domain.PurchasesInteractor r0 = (com.adapty.internal.domain.PurchasesInteractor) r0
                                kotlin.ResultKt.throwOnFailure(r12)
                                goto L_0x0055
                            L_0x002f:
                                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                r12.<init>(r0)
                                throw r12
                            L_0x0037:
                                kotlin.ResultKt.throwOnFailure(r12)
                                com.adapty.internal.data.cache.CacheRepository r12 = r11.cacheRepository
                                boolean r12 = r12.getPurchasesHaveBeenSynced()
                                if (r12 == 0) goto L_0x0047
                                kotlinx.coroutines.flow.Flow r12 = kotlinx.coroutines.flow.FlowKt.flowOf(r4)
                                return r12
                            L_0x0047:
                                kotlinx.coroutines.sync.Semaphore r12 = r11.syncPurchasesSemaphore
                                r0.L$0 = r11
                                r0.label = r3
                                java.lang.Object r12 = r12.acquire(r0)
                                if (r12 != r1) goto L_0x0054
                                return r1
                            L_0x0054:
                                r0 = r11
                            L_0x0055:
                                com.adapty.internal.data.cache.CacheRepository r12 = r0.cacheRepository
                                boolean r12 = r12.getPurchasesHaveBeenSynced()
                                if (r12 == 0) goto L_0x0067
                                kotlinx.coroutines.sync.Semaphore r12 = r0.syncPurchasesSemaphore
                                com.adapty.internal.utils.UtilsKt.releaseQuietly(r12)
                                kotlinx.coroutines.flow.Flow r12 = kotlinx.coroutines.flow.FlowKt.flowOf(r4)
                                goto L_0x008b
                            L_0x0067:
                                r6 = 3
                                r8 = 0
                                r9 = 2
                                r10 = 0
                                r5 = r0
                                kotlinx.coroutines.flow.Flow r12 = syncPurchasesInternal$default(r5, r6, r8, r9, r10)
                                kotlinx.coroutines.flow.Flow r12 = kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, "<this>")
                                com.adapty.internal.domain.PurchasesInteractor$syncPurchasesIfNeeded$2 r1 = new com.adapty.internal.domain.PurchasesInteractor$syncPurchasesIfNeeded$2
                                r1.<init>(r0, r4)
                                kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                                kotlinx.coroutines.flow.Flow r12 = kotlinx.coroutines.flow.FlowKt.onEach(r12, r1)
                                com.adapty.internal.domain.PurchasesInteractor$syncPurchasesIfNeeded$3 r1 = new com.adapty.internal.domain.PurchasesInteractor$syncPurchasesIfNeeded$3
                                r1.<init>(r0, r4)
                                kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
                                kotlinx.coroutines.flow.Flow r12 = kotlinx.coroutines.flow.FlowKt.m2547catch(r12, r1)
                            L_0x008b:
                                return r12
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.domain.PurchasesInteractor.syncPurchasesIfNeeded(kotlin.coroutines.Continuation):java.lang.Object");
                        }

                        /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
                        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final /* synthetic */ java.lang.Object syncPurchasesOnStart(kotlin.coroutines.Continuation r9) {
                            /*
                                r8 = this;
                                boolean r0 = r9 instanceof com.adapty.internal.domain.PurchasesInteractor$syncPurchasesOnStart$1
                                if (r0 == 0) goto L_0x0014
                                r0 = r9
                                com.adapty.internal.domain.PurchasesInteractor$syncPurchasesOnStart$1 r0 = (com.adapty.internal.domain.PurchasesInteractor$syncPurchasesOnStart$1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r1 = r1 & r2
                                if (r1 == 0) goto L_0x0014
                                int r9 = r0.label
                                int r9 = r9 - r2
                                r0.label = r9
                                goto L_0x0019
                            L_0x0014:
                                com.adapty.internal.domain.PurchasesInteractor$syncPurchasesOnStart$1 r0 = new com.adapty.internal.domain.PurchasesInteractor$syncPurchasesOnStart$1
                                r0.<init>(r8, r9)
                            L_0x0019:
                                java.lang.Object r9 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L_0x0036
                                if (r2 != r3) goto L_0x002e
                                java.lang.Object r0 = r0.L$0
                                com.adapty.internal.domain.PurchasesInteractor r0 = (com.adapty.internal.domain.PurchasesInteractor) r0
                                kotlin.ResultKt.throwOnFailure(r9)
                                goto L_0x0047
                            L_0x002e:
                                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                r9.<init>(r0)
                                throw r9
                            L_0x0036:
                                kotlin.ResultKt.throwOnFailure(r9)
                                kotlinx.coroutines.sync.Semaphore r9 = r8.syncPurchasesSemaphore
                                r0.L$0 = r8
                                r0.label = r3
                                java.lang.Object r9 = r9.acquire(r0)
                                if (r9 != r1) goto L_0x0046
                                return r1
                            L_0x0046:
                                r0 = r8
                            L_0x0047:
                                r3 = 3
                                r5 = 0
                                r6 = 2
                                r7 = 0
                                r2 = r0
                                kotlinx.coroutines.flow.Flow r9 = syncPurchasesInternal$default(r2, r3, r5, r6, r7)
                                kotlinx.coroutines.flow.Flow r9 = kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, "<this>")
                                com.adapty.internal.domain.PurchasesInteractor$syncPurchasesOnStart$2 r1 = new com.adapty.internal.domain.PurchasesInteractor$syncPurchasesOnStart$2
                                r2 = 0
                                r1.<init>(r0, r2)
                                kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                                kotlinx.coroutines.flow.Flow r9 = kotlinx.coroutines.flow.FlowKt.onEach(r9, r1)
                                com.adapty.internal.domain.PurchasesInteractor$syncPurchasesOnStart$3 r1 = new com.adapty.internal.domain.PurchasesInteractor$syncPurchasesOnStart$3
                                r1.<init>(r0, r2)
                                kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
                                kotlinx.coroutines.flow.Flow r9 = kotlinx.coroutines.flow.FlowKt.m2547catch(r9, r1)
                                return r9
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.domain.PurchasesInteractor.syncPurchasesOnStart(kotlin.coroutines.Continuation):java.lang.Object");
                        }

                        static /* synthetic */ Flow syncPurchasesInternal$default(PurchasesInteractor purchasesInteractor, long j, boolean z, int i, Object obj) {
                            if ((i & 1) != 0) {
                                j = -1;
                            }
                            if ((i & 2) != 0) {
                                z = false;
                            }
                            return purchasesInteractor.syncPurchasesInternal(j, z);
                        }

                        private final Flow<AdaptyProfile> syncPurchasesInternal(long j, boolean z) {
                            return Intrinsics.checkNotNullParameter(FlowKt.flatMapConcat(FlowKt.zip(this.storeManager.getPurchaseHistoryDataToRestore(j), FlowKt.flowOf(this.cacheRepository.getSyncedPurchases()), new PurchasesInteractor$syncPurchasesInternal$1((Continuation<? super PurchasesInteractor$syncPurchasesInternal$1>) null)), new PurchasesInteractor$syncPurchasesInternal$2(z, this, j, (Continuation<? super PurchasesInteractor$syncPurchasesInternal$2>) null)), "<this>");
                        }

                        public final /* synthetic */ Flow setVariationId(String str, String str2) {
                            Intrinsics.checkNotNullParameter(str, "transactionId");
                            Intrinsics.checkNotNullParameter(str2, "variationId");
                            return AuthInteractor.runWhenAuthDataSynced$default(this.authInteractor, 0, (Function0) null, new PurchasesInteractor$setVariationId$1(this, str, str2, (Continuation<? super PurchasesInteractor$setVariationId$1>) null), 3, (Object) null);
                        }

                        /* access modifiers changed from: private */
                        public final Object makePurchase(Activity activity, PurchaseableProduct purchaseableProduct, AdaptySubscriptionUpdateParameters adaptySubscriptionUpdateParameters, Continuation<? super Purchase> continuation) {
                            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
                            cancellableContinuationImpl.initCancellability();
                            this.storeManager.makePurchase(activity, purchaseableProduct, adaptySubscriptionUpdateParameters, new PurchasesInteractor$makePurchase$3$1(cancellableContinuationImpl));
                            Object result = cancellableContinuationImpl.getResult();
                            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                DebugProbesKt.probeCoroutineSuspended(continuation);
                            }
                            return result;
                        }
                    }
