package com.adapty.internal.domain;

import com.adapty.errors.AdaptyError;
import com.adapty.errors.AdaptyErrorCode;
import com.adapty.internal.data.cache.CacheRepository;
import com.adapty.internal.data.cloud.CloudRepository;
import com.adapty.internal.data.cloud.StoreManager;
import com.adapty.internal.domain.models.BackendProduct;
import com.adapty.internal.utils.LifecycleManager;
import com.adapty.internal.utils.Logger;
import com.adapty.internal.utils.Logger$log$1;
import com.adapty.internal.utils.PaywallMapper;
import com.adapty.internal.utils.PaywallPicker;
import com.adapty.internal.utils.ProductMapper;
import com.adapty.internal.utils.ProductPicker;
import com.adapty.internal.utils.ViewConfigurationMapper;
import com.adapty.models.AdaptyPaywall;
import com.adapty.utils.AdaptyLogLevel;
import com.android.billingclient.api.ProductDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\b\u0001\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J0\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b0\u001a2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\"H\u0002J.\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001a2\u0006\u0010%\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010\u001c2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J1\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u001a2\u0006\u0010%\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010\u001c2\b\u0010,\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u0010-J(\u0010.\u001a\b\u0012\u0004\u0012\u00020$0\u001a2\u0006\u0010%\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010\u001c2\u0006\u0010)\u001a\u00020*H\u0002J\u001a\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u001f0\u001a2\u0006\u00101\u001a\u00020$J\u0012\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001f0\u001aJ$\u00103\u001a\b\u0012\u0004\u0012\u0002040\u001a2\u0006\u00101\u001a\u00020$2\u0006\u0010&\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*J\u0010\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\u001cJ\u0017\u00108\u001a\b\u0012\u0004\u0012\u0002090\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010:J\b\u0010;\u001a\u00020<H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006="}, d2 = {"Lcom/adapty/internal/domain/ProductsInteractor;", "", "authInteractor", "Lcom/adapty/internal/domain/AuthInteractor;", "purchasesInteractor", "Lcom/adapty/internal/domain/PurchasesInteractor;", "cloudRepository", "Lcom/adapty/internal/data/cloud/CloudRepository;", "cacheRepository", "Lcom/adapty/internal/data/cache/CacheRepository;", "lifecycleManager", "Lcom/adapty/internal/utils/LifecycleManager;", "storeManager", "Lcom/adapty/internal/data/cloud/StoreManager;", "paywallMapper", "Lcom/adapty/internal/utils/PaywallMapper;", "viewConfigurationMapper", "Lcom/adapty/internal/utils/ViewConfigurationMapper;", "productMapper", "Lcom/adapty/internal/utils/ProductMapper;", "paywallPicker", "Lcom/adapty/internal/utils/PaywallPicker;", "productPicker", "Lcom/adapty/internal/utils/ProductPicker;", "(Lcom/adapty/internal/domain/AuthInteractor;Lcom/adapty/internal/domain/PurchasesInteractor;Lcom/adapty/internal/data/cloud/CloudRepository;Lcom/adapty/internal/data/cache/CacheRepository;Lcom/adapty/internal/utils/LifecycleManager;Lcom/adapty/internal/data/cloud/StoreManager;Lcom/adapty/internal/utils/PaywallMapper;Lcom/adapty/internal/utils/ViewConfigurationMapper;Lcom/adapty/internal/utils/ProductMapper;Lcom/adapty/internal/utils/PaywallPicker;Lcom/adapty/internal/utils/ProductPicker;)V", "getBillingInfo", "Lkotlinx/coroutines/flow/Flow;", "", "", "Lcom/android/billingclient/api/ProductDetails;", "products", "", "Lcom/adapty/internal/domain/models/BackendProduct;", "maxAttemptCount", "", "getPaywall", "Lcom/adapty/models/AdaptyPaywall;", "id", "locale", "fetchPolicy", "Lcom/adapty/models/AdaptyPaywall$FetchPolicy;", "loadTimeout", "", "getPaywallFromCache", "maxAgeMillis", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lkotlinx/coroutines/flow/Flow;", "getPaywallFromCloud", "getPaywallProducts", "Lcom/adapty/models/AdaptyPaywallProduct;", "paywall", "getProductsOnStart", "getViewConfiguration", "Lcom/adapty/models/AdaptyViewConfiguration;", "setFallbackPaywalls", "Lcom/adapty/errors/AdaptyError;", "paywalls", "syncPurchasesIfNeeded", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "throwNoProductIdsFoundError", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProductsInteractor.kt */
public final class ProductsInteractor {
    private final AuthInteractor authInteractor;
    /* access modifiers changed from: private */
    public final CacheRepository cacheRepository;
    /* access modifiers changed from: private */
    public final CloudRepository cloudRepository;
    private final LifecycleManager lifecycleManager;
    /* access modifiers changed from: private */
    public final PaywallMapper paywallMapper;
    /* access modifiers changed from: private */
    public final PaywallPicker paywallPicker;
    /* access modifiers changed from: private */
    public final ProductMapper productMapper;
    /* access modifiers changed from: private */
    public final ProductPicker productPicker;
    private final PurchasesInteractor purchasesInteractor;
    /* access modifiers changed from: private */
    public final StoreManager storeManager;
    /* access modifiers changed from: private */
    public final ViewConfigurationMapper viewConfigurationMapper;

    public ProductsInteractor(AuthInteractor authInteractor2, PurchasesInteractor purchasesInteractor2, CloudRepository cloudRepository2, CacheRepository cacheRepository2, LifecycleManager lifecycleManager2, StoreManager storeManager2, PaywallMapper paywallMapper2, ViewConfigurationMapper viewConfigurationMapper2, ProductMapper productMapper2, PaywallPicker paywallPicker2, ProductPicker productPicker2) {
        Intrinsics.checkNotNullParameter(authInteractor2, "authInteractor");
        Intrinsics.checkNotNullParameter(purchasesInteractor2, "purchasesInteractor");
        Intrinsics.checkNotNullParameter(cloudRepository2, "cloudRepository");
        Intrinsics.checkNotNullParameter(cacheRepository2, "cacheRepository");
        Intrinsics.checkNotNullParameter(lifecycleManager2, "lifecycleManager");
        Intrinsics.checkNotNullParameter(storeManager2, "storeManager");
        Intrinsics.checkNotNullParameter(paywallMapper2, "paywallMapper");
        Intrinsics.checkNotNullParameter(viewConfigurationMapper2, "viewConfigurationMapper");
        Intrinsics.checkNotNullParameter(productMapper2, "productMapper");
        Intrinsics.checkNotNullParameter(paywallPicker2, "paywallPicker");
        Intrinsics.checkNotNullParameter(productPicker2, "productPicker");
        this.authInteractor = authInteractor2;
        this.purchasesInteractor = purchasesInteractor2;
        this.cloudRepository = cloudRepository2;
        this.cacheRepository = cacheRepository2;
        this.lifecycleManager = lifecycleManager2;
        this.storeManager = storeManager2;
        this.paywallMapper = paywallMapper2;
        this.viewConfigurationMapper = viewConfigurationMapper2;
        this.productMapper = productMapper2;
        this.paywallPicker = paywallPicker2;
        this.productPicker = productPicker2;
    }

    public final /* synthetic */ Flow getPaywall(String str, String str2, AdaptyPaywall.FetchPolicy fetchPolicy, int i) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(fetchPolicy, "fetchPolicy");
        if (fetchPolicy instanceof AdaptyPaywall.FetchPolicy.ReloadRevalidatingCacheData) {
            return getPaywallFromCloud(str, str2, i);
        }
        Long l = null;
        AdaptyPaywall.FetchPolicy.ReturnCacheDataIfNotExpiredElseLoad returnCacheDataIfNotExpiredElseLoad = fetchPolicy instanceof AdaptyPaywall.FetchPolicy.ReturnCacheDataIfNotExpiredElseLoad ? (AdaptyPaywall.FetchPolicy.ReturnCacheDataIfNotExpiredElseLoad) fetchPolicy : null;
        if (returnCacheDataIfNotExpiredElseLoad != null) {
            l = Long.valueOf(returnCacheDataIfNotExpiredElseLoad.getMaxAgeMillis());
        }
        return FlowKt.flatMapConcat(getPaywallFromCache(str, str2, l), new ProductsInteractor$getPaywall$1(this, str, str2, i, (Continuation<? super ProductsInteractor$getPaywall$1>) null));
    }

    /* access modifiers changed from: private */
    public final Flow<AdaptyPaywall> getPaywallFromCloud(String str, String str2, int i) {
        Flow flattenConcat = FlowKt.flattenConcat(AuthInteractor.runWhenAuthDataSynced$default(this.authInteractor, 0, new ProductsInteractor$getPaywallFromCloud$baseFlow$1(this, str), new ProductsInteractor$getPaywallFromCloud$baseFlow$2(this, str, str2, (Continuation<? super ProductsInteractor$getPaywallFromCloud$baseFlow$2>) null), 1, (Object) null));
        if (i != Integer.MAX_VALUE) {
            flattenConcat = new ProductsInteractor$getPaywallFromCloud$$inlined$map$1(Intrinsics.checkNotNullParameter(flattenConcat, "flow"), this, str, str2);
        }
        return Intrinsics.checkNotNullParameter(FlowKt.m2547catch(new ProductsInteractor$getPaywallFromCloud$$inlined$map$2(flattenConcat, this), new ProductsInteractor$getPaywallFromCloud$3(this, str, str2, (Continuation<? super ProductsInteractor$getPaywallFromCloud$3>) null)), "<this>");
    }

    private final Flow<AdaptyPaywall> getPaywallFromCache(String str, String str2, Long l) {
        return FlowKt.flow(new ProductsInteractor$getPaywallFromCache$1(this, str, l, str2, (Continuation<? super ProductsInteractor$getPaywallFromCache$1>) null));
    }

    public final /* synthetic */ Flow getViewConfiguration(AdaptyPaywall adaptyPaywall, String str, int i) {
        Intrinsics.checkNotNullParameter(adaptyPaywall, "paywall");
        Intrinsics.checkNotNullParameter(str, "locale");
        Flow runWhenAuthDataSynced$default = AuthInteractor.runWhenAuthDataSynced$default(this.authInteractor, 0, (Function0) null, new ProductsInteractor$getViewConfiguration$baseFlow$1(this, adaptyPaywall, str, (Continuation<? super ProductsInteractor$getViewConfiguration$baseFlow$1>) null), 3, (Object) null);
        if (i != Integer.MAX_VALUE) {
            runWhenAuthDataSynced$default = Intrinsics.checkNotNullParameter(runWhenAuthDataSynced$default, "flow");
        }
        return Intrinsics.checkNotNullParameter(new ProductsInteractor$getViewConfiguration$$inlined$map$1(runWhenAuthDataSynced$default, this, adaptyPaywall, str), "<this>");
    }

    public final /* synthetic */ Flow getPaywallProducts(AdaptyPaywall adaptyPaywall) {
        Intrinsics.checkNotNullParameter(adaptyPaywall, "paywall");
        return Intrinsics.checkNotNullParameter(FlowKt.flatMapConcat(FlowKt.flow(new ProductsInteractor$getPaywallProducts$1(adaptyPaywall, (Continuation<? super ProductsInteractor$getPaywallProducts$1>) null)), new ProductsInteractor$getPaywallProducts$2(this, adaptyPaywall, (Continuation<? super ProductsInteractor$getPaywallProducts$2>) null)), "<this>");
    }

    public final /* synthetic */ Flow getProductsOnStart() {
        return Intrinsics.checkNotNullParameter(FlowKt.flatMapConcat(Intrinsics.checkNotNullParameter(FlowKt.mapLatest(this.lifecycleManager.onActivateAllowed(), new ProductsInteractor$getProductsOnStart$1(this, (Continuation<? super ProductsInteractor$getProductsOnStart$1>) null)), "<this>"), new ProductsInteractor$getProductsOnStart$2(this, (Continuation<? super ProductsInteractor$getProductsOnStart$2>) null)), "<this>");
    }

    public final /* synthetic */ AdaptyError setFallbackPaywalls(String str) {
        Intrinsics.checkNotNullParameter(str, "paywalls");
        return this.cacheRepository.saveFallbackPaywalls(str);
    }

    /* access modifiers changed from: private */
    public final Flow<Map<String, ProductDetails>> getBillingInfo(List<BackendProduct> list, long j) {
        if (!list.isEmpty()) {
            Iterable<BackendProduct> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (BackendProduct vendorProductId : iterable) {
                arrayList.add(vendorProductId.getVendorProductId());
            }
            return new ProductsInteractor$getBillingInfo$$inlined$map$1(this.storeManager.queryProductDetails(CollectionsKt.distinct((List) arrayList), j), this);
        }
        throwNoProductIdsFoundError();
        throw new KotlinNothingValueException();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object syncPurchasesIfNeeded(kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<java.lang.Boolean>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.adapty.internal.domain.ProductsInteractor$syncPurchasesIfNeeded$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            com.adapty.internal.domain.ProductsInteractor$syncPurchasesIfNeeded$1 r0 = (com.adapty.internal.domain.ProductsInteractor$syncPurchasesIfNeeded$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            com.adapty.internal.domain.ProductsInteractor$syncPurchasesIfNeeded$1 r0 = new com.adapty.internal.domain.ProductsInteractor$syncPurchasesIfNeeded$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0040
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            com.adapty.internal.domain.PurchasesInteractor r5 = r4.purchasesInteractor
            r0.label = r3
            java.lang.Object r5 = r5.syncPurchasesIfNeeded(r0)
            if (r5 != r1) goto L_0x0040
            return r1
        L_0x0040:
            kotlinx.coroutines.flow.Flow r5 = (kotlinx.coroutines.flow.Flow) r5
            com.adapty.internal.domain.ProductsInteractor$syncPurchasesIfNeeded$$inlined$map$1 r0 = new com.adapty.internal.domain.ProductsInteractor$syncPurchasesIfNeeded$$inlined$map$1
            r0.<init>(r5)
            kotlinx.coroutines.flow.Flow r0 = (kotlinx.coroutines.flow.Flow) r0
            com.adapty.internal.domain.ProductsInteractor$syncPurchasesIfNeeded$3 r5 = new com.adapty.internal.domain.ProductsInteractor$syncPurchasesIfNeeded$3
            r1 = 0
            r5.<init>(r1)
            kotlin.jvm.functions.Function3 r5 = (kotlin.jvm.functions.Function3) r5
            kotlinx.coroutines.flow.Flow r5 = kotlinx.coroutines.flow.FlowKt.m2547catch(r0, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.domain.ProductsInteractor.syncPurchasesIfNeeded(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Void throwNoProductIdsFoundError() {
        Logger logger = Logger.INSTANCE;
        AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.ERROR;
        if (logger.canLog(adaptyLogLevel.value)) {
            logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, "No In-App Purchase product identifiers were found."));
        }
        throw new AdaptyError((Throwable) null, "No In-App Purchase product identifiers were found.", AdaptyErrorCode.NO_PRODUCT_IDS_FOUND, 1, (DefaultConstructorMarker) null);
    }
}
