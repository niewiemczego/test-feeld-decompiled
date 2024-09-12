package com.adapty.internal.domain;

import androidx.core.app.NotificationCompat;
import com.adapty.internal.data.cache.CacheRepository;
import com.adapty.internal.data.cloud.CloudRepository;
import com.adapty.internal.utils.AdIdRetriever;
import com.adapty.internal.utils.AppSetIdRetriever;
import com.adapty.internal.utils.HashingHelper;
import com.adapty.internal.utils.InstallationMetaCreator;
import com.adapty.internal.utils.LifecycleManager;
import com.adapty.internal.utils.Logger;
import com.adapty.internal.utils.Logger$log$1;
import com.adapty.internal.utils.StoreCountryRetriever;
import com.adapty.utils.AdaptyLogLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u0006\u0010\u0018\u001a\u00020\u0019J\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00162\u0006\u0010\u001c\u001a\u00020\u001dJ\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u0004\u0018\u00010!J\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020!J\u0010\u0010$\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010!JV\u0010&\u001a\b\u0012\u0004\u0012\u0002H'0\u0016\"\u0004\b\u0000\u0010'2\b\b\u0002\u0010(\u001a\u00020)2\u0012\b\u0002\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u0001H'\u0018\u00010+2\u001c\u0010,\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0.\u0012\u0006\u0012\u0004\u0018\u00010\u00010-ø\u0001\u0000¢\u0006\u0002\u0010/R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00060"}, d2 = {"Lcom/adapty/internal/domain/AuthInteractor;", "", "cloudRepository", "Lcom/adapty/internal/data/cloud/CloudRepository;", "cacheRepository", "Lcom/adapty/internal/data/cache/CacheRepository;", "lifecycleManager", "Lcom/adapty/internal/utils/LifecycleManager;", "installationMetaCreator", "Lcom/adapty/internal/utils/InstallationMetaCreator;", "adIdRetriever", "Lcom/adapty/internal/utils/AdIdRetriever;", "appSetIdRetriever", "Lcom/adapty/internal/utils/AppSetIdRetriever;", "storeCountryRetriever", "Lcom/adapty/internal/utils/StoreCountryRetriever;", "hashingHelper", "Lcom/adapty/internal/utils/HashingHelper;", "(Lcom/adapty/internal/data/cloud/CloudRepository;Lcom/adapty/internal/data/cache/CacheRepository;Lcom/adapty/internal/utils/LifecycleManager;Lcom/adapty/internal/utils/InstallationMetaCreator;Lcom/adapty/internal/utils/AdIdRetriever;Lcom/adapty/internal/utils/AppSetIdRetriever;Lcom/adapty/internal/utils/StoreCountryRetriever;Lcom/adapty/internal/utils/HashingHelper;)V", "authSemaphore", "Lkotlinx/coroutines/sync/Semaphore;", "activateOrIdentify", "Lkotlinx/coroutines/flow/Flow;", "Lcom/adapty/internal/domain/models/ProfileRequestResult;", "clearDataOnLogout", "", "createInstallationMeta", "Lcom/adapty/internal/data/models/InstallationMeta;", "isCreatingProfile", "", "createProfileIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCustomerUserId", "", "handleAppKey", "appKey", "prepareAuthDataToSync", "newCustomerUserId", "runWhenAuthDataSynced", "T", "maxAttemptCount", "", "switchIfProfileCreationFailed", "Lkotlin/Function0;", "call", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AuthInteractor.kt */
public final class AuthInteractor {
    private final AdIdRetriever adIdRetriever;
    private final AppSetIdRetriever appSetIdRetriever;
    /* access modifiers changed from: private */
    public final Semaphore authSemaphore = SemaphoreKt.Semaphore$default(1, 0, 2, (Object) null);
    /* access modifiers changed from: private */
    public final CacheRepository cacheRepository;
    /* access modifiers changed from: private */
    public final CloudRepository cloudRepository;
    private final HashingHelper hashingHelper;
    /* access modifiers changed from: private */
    public final InstallationMetaCreator installationMetaCreator;
    private final LifecycleManager lifecycleManager;
    private final StoreCountryRetriever storeCountryRetriever;

    public AuthInteractor(CloudRepository cloudRepository2, CacheRepository cacheRepository2, LifecycleManager lifecycleManager2, InstallationMetaCreator installationMetaCreator2, AdIdRetriever adIdRetriever2, AppSetIdRetriever appSetIdRetriever2, StoreCountryRetriever storeCountryRetriever2, HashingHelper hashingHelper2) {
        Intrinsics.checkNotNullParameter(cloudRepository2, "cloudRepository");
        Intrinsics.checkNotNullParameter(cacheRepository2, "cacheRepository");
        Intrinsics.checkNotNullParameter(lifecycleManager2, "lifecycleManager");
        Intrinsics.checkNotNullParameter(installationMetaCreator2, "installationMetaCreator");
        Intrinsics.checkNotNullParameter(adIdRetriever2, "adIdRetriever");
        Intrinsics.checkNotNullParameter(appSetIdRetriever2, "appSetIdRetriever");
        Intrinsics.checkNotNullParameter(storeCountryRetriever2, "storeCountryRetriever");
        Intrinsics.checkNotNullParameter(hashingHelper2, "hashingHelper");
        this.cloudRepository = cloudRepository2;
        this.cacheRepository = cacheRepository2;
        this.lifecycleManager = lifecycleManager2;
        this.installationMetaCreator = installationMetaCreator2;
        this.adIdRetriever = adIdRetriever2;
        this.appSetIdRetriever = appSetIdRetriever2;
        this.storeCountryRetriever = storeCountryRetriever2;
        this.hashingHelper = hashingHelper2;
    }

    public final /* synthetic */ Flow activateOrIdentify() {
        return Intrinsics.checkNotNullParameter(Intrinsics.checkNotNullParameter(FlowKt.flatMapConcat(this.lifecycleManager.onActivateAllowed(), new AuthInteractor$activateOrIdentify$1(this, (Continuation<? super AuthInteractor$activateOrIdentify$1>) null)), "<this>"), "<this>");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createProfileIfNeeded(kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.adapty.internal.domain.models.ProfileRequestResult>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.adapty.internal.domain.AuthInteractor$createProfileIfNeeded$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.adapty.internal.domain.AuthInteractor$createProfileIfNeeded$1 r0 = (com.adapty.internal.domain.AuthInteractor$createProfileIfNeeded$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.adapty.internal.domain.AuthInteractor$createProfileIfNeeded$1 r0 = new com.adapty.internal.domain.AuthInteractor$createProfileIfNeeded$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            java.lang.Object r0 = r0.L$0
            com.adapty.internal.domain.AuthInteractor r0 = (com.adapty.internal.domain.AuthInteractor) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0081
        L_0x002f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            com.adapty.internal.data.cache.CacheRepository r6 = r5.cacheRepository
            kotlin.Pair r6 = r6.getUnsyncedAuthData()
            java.lang.Object r2 = r6.component1()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r6 = r6.component2()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0059
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0057
            goto L_0x0059
        L_0x0057:
            r2 = r3
            goto L_0x005a
        L_0x0059:
            r2 = r4
        L_0x005a:
            if (r2 == 0) goto L_0x0073
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x0069
            int r6 = r6.length()
            if (r6 != 0) goto L_0x0067
            goto L_0x0069
        L_0x0067:
            r6 = r3
            goto L_0x006a
        L_0x0069:
            r6 = r4
        L_0x006a:
            if (r6 == 0) goto L_0x0073
            com.adapty.internal.domain.models.ProfileRequestResult$ProfileIdSame r6 = com.adapty.internal.domain.models.ProfileRequestResult.ProfileIdSame.INSTANCE
            kotlinx.coroutines.flow.Flow r6 = kotlinx.coroutines.flow.FlowKt.flowOf(r6)
            return r6
        L_0x0073:
            kotlinx.coroutines.sync.Semaphore r6 = r5.authSemaphore
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r6.acquire(r0)
            if (r6 != r1) goto L_0x0080
            return r1
        L_0x0080:
            r0 = r5
        L_0x0081:
            com.adapty.internal.data.cache.CacheRepository r6 = r0.cacheRepository
            kotlin.Pair r6 = r6.getUnsyncedAuthData()
            java.lang.Object r1 = r6.component1()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r6 = r6.component2()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x00a0
            int r1 = r1.length()
            if (r1 != 0) goto L_0x009e
            goto L_0x00a0
        L_0x009e:
            r1 = r3
            goto L_0x00a1
        L_0x00a0:
            r1 = r4
        L_0x00a1:
            if (r1 == 0) goto L_0x00bd
            r1 = r6
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x00ae
            int r1 = r1.length()
            if (r1 != 0) goto L_0x00af
        L_0x00ae:
            r3 = r4
        L_0x00af:
            if (r3 == 0) goto L_0x00bd
            kotlinx.coroutines.sync.Semaphore r6 = r0.authSemaphore
            r6.release()
            com.adapty.internal.domain.models.ProfileRequestResult$ProfileIdSame r6 = com.adapty.internal.domain.models.ProfileRequestResult.ProfileIdSame.INSTANCE
            kotlinx.coroutines.flow.Flow r6 = kotlinx.coroutines.flow.FlowKt.flowOf(r6)
            goto L_0x00cd
        L_0x00bd:
            kotlinx.coroutines.flow.Flow r1 = r0.createInstallationMeta(r4)
            com.adapty.internal.domain.AuthInteractor$createProfileIfNeeded$3 r2 = new com.adapty.internal.domain.AuthInteractor$createProfileIfNeeded$3
            r3 = 0
            r2.<init>(r0, r6, r3)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            kotlinx.coroutines.flow.Flow r6 = kotlinx.coroutines.flow.FlowKt.flatMapConcat(r1, r2)
        L_0x00cd:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.domain.AuthInteractor.createProfileIfNeeded(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final /* synthetic */ void clearDataOnLogout() {
        this.cacheRepository.clearOnLogout();
    }

    public final /* synthetic */ void handleAppKey(String str) {
        Intrinsics.checkNotNullParameter(str, "appKey");
        String sha256 = this.hashingHelper.sha256(str);
        String appKey = this.cacheRepository.getAppKey();
        if (!Intrinsics.areEqual((Object) sha256, (Object) appKey)) {
            CharSequence charSequence = appKey;
            if (!(charSequence == null || charSequence.length() == 0) && !Intrinsics.areEqual((Object) sha256, (Object) this.hashingHelper.sha256(appKey))) {
                this.cacheRepository.clearOnAppKeyChanged();
            }
            Logger logger = Logger.INSTANCE;
            AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.VERBOSE;
            if (logger.canLog(adaptyLogLevel.value)) {
                logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, "changing apiKeyHash = " + sha256));
            }
            this.cacheRepository.saveAppKey(sha256);
        }
    }

    public final /* synthetic */ String getCustomerUserId() {
        return this.cacheRepository.getCustomerUserId();
    }

    public final /* synthetic */ Flow createInstallationMeta(boolean z) {
        return FlowKt.combine(this.adIdRetriever.getAdIdIfAvailable(), this.storeCountryRetriever.getStoreCountryIfAvailable(!z), this.appSetIdRetriever.getAppSetIdIfAvailable(), new AuthInteractor$createInstallationMeta$1(this, (Continuation<? super AuthInteractor$createInstallationMeta$1>) null));
    }

    public final /* synthetic */ void prepareAuthDataToSync(String str) {
        this.cacheRepository.prepareProfileIdToSync();
        this.cacheRepository.prepareCustomerUserIdToSync(str);
    }

    public static /* synthetic */ Flow runWhenAuthDataSynced$default(AuthInteractor authInteractor, long j, Function0 function0, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 3;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        return authInteractor.runWhenAuthDataSynced(j, function0, function1);
    }

    public final /* synthetic */ Flow runWhenAuthDataSynced(long j, Function0 function0, Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, NotificationCompat.CATEGORY_CALL);
        return Intrinsics.checkNotNullParameter(Intrinsics.checkNotNullParameter(FlowKt.mapLatest(FlowKt.m2547catch(FlowKt.flatMapConcat(this.lifecycleManager.onActivateAllowed(), new AuthInteractor$runWhenAuthDataSynced$1(this, (Continuation<? super AuthInteractor$runWhenAuthDataSynced$1>) null)), new AuthInteractor$runWhenAuthDataSynced$2(function0, (Continuation<? super AuthInteractor$runWhenAuthDataSynced$2>) null)), new AuthInteractor$runWhenAuthDataSynced$3(function0, function1, (Continuation<? super AuthInteractor$runWhenAuthDataSynced$3>) null)), "<this>"), "<this>");
    }
}
