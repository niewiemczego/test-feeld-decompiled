package com.adapty.internal.data.cache;

import com.adapty.errors.AdaptyError;
import com.adapty.errors.AdaptyErrorCode;
import com.adapty.internal.crossplatform.AdaptyImmutableMapTypeAdapterFactory;
import com.adapty.internal.data.models.AnalyticsConfig;
import com.adapty.internal.data.models.AnalyticsData;
import com.adapty.internal.data.models.FallbackPaywalls;
import com.adapty.internal.data.models.InstallationMeta;
import com.adapty.internal.data.models.PaywallDto;
import com.adapty.internal.data.models.ProfileDto;
import com.adapty.internal.utils.Logger;
import com.adapty.internal.utils.Logger$log$1;
import com.adapty.internal.utils.UtilsKt;
import com.adapty.utils.AdaptyLogLevel;
import com.google.gson.Gson;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 x2\u00020\u0001:\u0001xB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u001aH\u0002J\u0006\u0010\u001c\u001a\u00020\u0018J\u0006\u0010\u001d\u001a\u00020\u0018J\u0006\u0010\u001e\u001a\u00020\u0018J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010$\u001a\u0004\u0018\u00010\u0011J\b\u0010%\u001a\u0004\u0018\u00010\u0011J2\u0010&\u001a\u0004\u0018\u0001H'\"\u0006\b\u0000\u0010'\u0018\u00012\u0006\u0010(\u001a\u00020\u00112\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u0002H'\u0018\u00010*H\b¢\u0006\u0002\u0010+J\r\u0010,\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u0010-J\b\u0010.\u001a\u0004\u0018\u00010/J\b\u00100\u001a\u0004\u0018\u000101J\u0006\u00102\u001a\u00020\u0011J\u0006\u00103\u001a\u000204J!\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\u00112\n\b\u0002\u00108\u001a\u0004\u0018\u000104¢\u0006\u0002\u00109J\u0010\u0010:\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u0011H\u0002J\b\u0010;\u001a\u0004\u0018\u00010\u0014J\u0006\u0010<\u001a\u00020\u0011J\u0006\u0010=\u001a\u00020\"J\b\u0010>\u001a\u0004\u0018\u00010\u0011J\u0017\u0010?\u001a\u0004\u0018\u00010\u00112\u0006\u0010(\u001a\u00020\u0011H\u0000¢\u0006\u0002\b@J\f\u0010A\u001a\b\u0012\u0004\u0012\u00020B0\u001aJ\u0016\u0010C\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00110DJ\u0010\u0010E\u001a\u00020\u00182\u0006\u0010F\u001a\u00020\u0011H\u0002J\u0010\u0010G\u001a\u00020\u00182\b\u0010H\u001a\u0004\u0018\u00010\u0011J\u0006\u0010I\u001a\u00020\u0018J\u0016\u0010J\u001a\u00020\u00182\u0006\u0010K\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u000e\u0010L\u001a\u00020\u00182\u0006\u0010M\u001a\u00020\u0011J\u0010\u0010N\u001a\u00020\u00182\u0006\u0010O\u001a\u00020\u0011H\u0002J\u001a\u0010P\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00112\b\u0010K\u001a\u0004\u0018\u00010\u0001H\u0002J\u000e\u0010Q\u001a\u00020\u00182\u0006\u0010R\u001a\u00020\"J\u0010\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010U\u001a\u00020\u0011J\u0010\u0010V\u001a\u00020\u00182\u0006\u0010W\u001a\u00020\u0011H\u0002J\u000e\u0010X\u001a\u00020\u00182\u0006\u0010Y\u001a\u000204J\u000e\u0010Z\u001a\u00020\u00182\u0006\u0010[\u001a\u000201J\u0016\u0010\\\u001a\u00020\u00182\u0006\u00107\u001a\u00020\u00112\u0006\u0010]\u001a\u000206J\u0019\u0010^\u001a\u00020\u00142\u0006\u0010_\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010`J\u0010\u0010a\u001a\u00020\u00182\u0006\u0010b\u001a\u00020\u0011H\u0002J!\u0010c\u001a\u00020\u00182\u0012\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110eH\u0000¢\u0006\u0002\bfJ\u0014\u0010g\u001a\u00020\u00182\f\u0010K\u001a\b\u0012\u0004\u0012\u00020B0\u001aJ\u000e\u0010h\u001a\u00020\u00182\u0006\u0010i\u001a\u00020\"J\f\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00140kJ!\u0010l\u001a\u00020\"2\u0006\u0010_\u001a\u00020\u00142\u0006\u0010[\u001a\u000201H@ø\u0001\u0000¢\u0006\u0002\u0010mJ#\u0010n\u001a\u00020\u00142\u0006\u0010_\u001a\u00020\u00142\b\u0010o\u001a\u0004\u0018\u00010\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010pJB\u0010q\u001a\u0004\u0018\u0001Hr\"\u0004\b\u0000\u0010s\"\u0004\b\u0001\u0010r*\u000e\u0012\u0004\u0012\u0002Hs\u0012\u0004\u0012\u0002Hr0t2\u0006\u0010(\u001a\u0002Hs2\f\u0010u\u001a\b\u0012\u0004\u0012\u0002Hr0vH\b¢\u0006\u0002\u0010wR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006y"}, d2 = {"Lcom/adapty/internal/data/cache/CacheRepository;", "", "preferenceManager", "Lcom/adapty/internal/data/cache/PreferenceManager;", "responseCacheKeyProvider", "Lcom/adapty/internal/data/cache/ResponseCacheKeyProvider;", "gson", "Lcom/google/gson/Gson;", "(Lcom/adapty/internal/data/cache/PreferenceManager;Lcom/adapty/internal/data/cache/ResponseCacheKeyProvider;Lcom/google/gson/Gson;)V", "analyticsConfig", "Lcom/adapty/internal/data/models/AnalyticsConfig;", "getAnalyticsConfig", "()Lcom/adapty/internal/data/models/AnalyticsConfig;", "setAnalyticsConfig", "(Lcom/adapty/internal/data/models/AnalyticsConfig;)V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "currentProfile", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/adapty/internal/data/models/ProfileDto;", "installationMetaLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "clearData", "", "containsKeys", "", "startsWithKeys", "clearOnAppKeyChanged", "clearOnLogout", "clearSyncedPurchases", "getAnalyticsData", "Lcom/adapty/internal/data/models/AnalyticsData;", "isSystemLog", "", "getAnalyticsKey", "getAppKey", "getCustomerUserId", "getData", "T", "key", "classOfT", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "getExternalAnalyticsEnabled", "()Ljava/lang/Boolean;", "getFallbackPaywalls", "Lcom/adapty/internal/data/models/FallbackPaywalls;", "getInstallationMeta", "Lcom/adapty/internal/data/models/InstallationMeta;", "getInstallationMetaId", "getLastAppOpenedTime", "", "getPaywall", "Lcom/adapty/internal/data/models/PaywallDto;", "id", "maxAgeMillis", "(Ljava/lang/String;Ljava/lang/Long;)Lcom/adapty/internal/data/models/PaywallDto;", "getPaywallCacheKey", "getProfile", "getProfileId", "getPurchasesHaveBeenSynced", "getSessionId", "getString", "getString$adapty_release", "getSyncedPurchases", "Lcom/adapty/internal/data/models/SyncedPurchase;", "getUnsyncedAuthData", "Lkotlin/Pair;", "onNewProfileIdReceived", "newProfileId", "prepareCustomerUserIdToSync", "newCustomerUserId", "prepareProfileIdToSync", "saveAnalyticsData", "data", "saveAppKey", "appKey", "saveCustomerUserId", "customerUserId", "saveData", "saveExternalAnalyticsEnabled", "enabled", "saveFallbackPaywalls", "Lcom/adapty/errors/AdaptyError;", "paywalls", "saveInstallationMetaId", "installationMetaId", "saveLastAppOpenedTime", "timeMillis", "saveLastSentInstallationMeta", "installationMeta", "savePaywall", "paywallDto", "saveProfile", "profile", "(Lcom/adapty/internal/data/models/ProfileDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveProfileId", "profileId", "saveRequestOrResponseLatestData", "map", "", "saveRequestOrResponseLatestData$adapty_release", "saveSyncedPurchases", "setPurchasesHaveBeenSynced", "synced", "subscribeOnProfileChanges", "Lkotlinx/coroutines/flow/Flow;", "updateDataOnCreateProfile", "(Lcom/adapty/internal/data/models/ProfileDto;Lcom/adapty/internal/data/models/InstallationMeta;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateOnProfileReceived", "profileIdWhenRequestSent", "(Lcom/adapty/internal/data/models/ProfileDto;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "safeGetOrPut", "V", "K", "Ljava/util/concurrent/ConcurrentMap;", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/concurrent/ConcurrentMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CacheRepository.kt */
public final class CacheRepository {
    @Deprecated
    private static final int CURRENT_FALLBACK_PAYWALL_VERSION = 4;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private volatile AnalyticsConfig analyticsConfig = AnalyticsConfig.Companion.getDEFAULT();
    /* access modifiers changed from: private */
    public final ConcurrentHashMap<String, Object> cache = new ConcurrentHashMap<>(32);
    private final MutableSharedFlow<ProfileDto> currentProfile = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
    private final Gson gson;
    private final ReentrantReadWriteLock installationMetaLock = new ReentrantReadWriteLock();
    /* access modifiers changed from: private */
    public final PreferenceManager preferenceManager;
    private final ResponseCacheKeyProvider responseCacheKeyProvider;

    private final String getAnalyticsKey(boolean z) {
        return z ? CacheKeysKt.ANALYTICS_LOW_PRIORITY_DATA : CacheKeysKt.ANALYTICS_DATA;
    }

    public CacheRepository(PreferenceManager preferenceManager2, ResponseCacheKeyProvider responseCacheKeyProvider2, Gson gson2) {
        Intrinsics.checkNotNullParameter(preferenceManager2, "preferenceManager");
        Intrinsics.checkNotNullParameter(responseCacheKeyProvider2, "responseCacheKeyProvider");
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.preferenceManager = preferenceManager2;
        this.responseCacheKeyProvider = responseCacheKeyProvider2;
        this.gson = gson2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object updateDataOnCreateProfile(com.adapty.internal.data.models.ProfileDto r10, com.adapty.internal.data.models.InstallationMeta r11, kotlin.coroutines.Continuation r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.adapty.internal.data.cache.CacheRepository$updateDataOnCreateProfile$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.adapty.internal.data.cache.CacheRepository$updateDataOnCreateProfile$1 r0 = (com.adapty.internal.data.cache.CacheRepository$updateDataOnCreateProfile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            com.adapty.internal.data.cache.CacheRepository$updateDataOnCreateProfile$1 r0 = new com.adapty.internal.data.cache.CacheRepository$updateDataOnCreateProfile$1
            r0.<init>(r9, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "UNSYNCED_PROFILE_ID"
            r4 = 1
            if (r2 == 0) goto L_0x0047
            if (r2 != r4) goto L_0x003f
            java.lang.Object r10 = r0.L$3
            kotlin.jvm.internal.Ref$BooleanRef r10 = (kotlin.jvm.internal.Ref.BooleanRef) r10
            java.lang.Object r11 = r0.L$2
            com.adapty.internal.data.models.InstallationMeta r11 = (com.adapty.internal.data.models.InstallationMeta) r11
            java.lang.Object r1 = r0.L$1
            com.adapty.internal.data.models.ProfileDto r1 = (com.adapty.internal.data.models.ProfileDto) r1
            java.lang.Object r0 = r0.L$0
            com.adapty.internal.data.cache.CacheRepository r0 = (com.adapty.internal.data.cache.CacheRepository) r0
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r10
            r10 = r1
            goto L_0x00d3
        L_0x003f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Long r12 = r10.getTimestamp()
            r5 = 0
            if (r12 == 0) goto L_0x0057
            long r7 = r12.longValue()
            goto L_0x0058
        L_0x0057:
            r7 = r5
        L_0x0058:
            com.adapty.internal.data.models.ProfileDto r12 = r9.getProfile()
            if (r12 == 0) goto L_0x0068
            java.lang.Long r12 = r12.getTimestamp()
            if (r12 == 0) goto L_0x0068
            long r5 = r12.longValue()
        L_0x0068:
            int r12 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r12 >= 0) goto L_0x0072
            r10 = 0
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
            return r10
        L_0x0072:
            kotlin.jvm.internal.Ref$BooleanRef r12 = new kotlin.jvm.internal.Ref$BooleanRef
            r12.<init>()
            java.lang.String r2 = r10.getProfileId()
            if (r2 != 0) goto L_0x008b
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> r2 = r9.cache
            java.lang.Object r2 = r2.get(r3)
            boolean r5 = r2 instanceof java.lang.String
            if (r5 == 0) goto L_0x008a
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x008b
        L_0x008a:
            r2 = 0
        L_0x008b:
            if (r2 == 0) goto L_0x00a3
            com.adapty.internal.data.cache.PreferenceManager r5 = r9.preferenceManager
            java.lang.String r6 = "PROFILE_ID"
            java.lang.String r5 = r5.getString(r6)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            r5 = r5 ^ r4
            r12.element = r5
            boolean r5 = r12.element
            if (r5 == 0) goto L_0x00a3
            r9.onNewProfileIdReceived(r2)
        L_0x00a3:
            boolean r2 = r12.element
            if (r2 != 0) goto L_0x00b5
            java.lang.String r2 = r9.getCustomerUserId()
            java.lang.String r5 = r10.getCustomerUserId()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            if (r2 != 0) goto L_0x00b8
        L_0x00b5:
            r9.clearSyncedPurchases()
        L_0x00b8:
            java.lang.String r2 = r10.getCustomerUserId()
            if (r2 == 0) goto L_0x00c1
            r9.saveCustomerUserId(r2)
        L_0x00c1:
            r0.L$0 = r9
            r0.L$1 = r10
            r0.L$2 = r11
            r0.L$3 = r12
            r0.label = r4
            java.lang.Object r0 = r9.saveProfile(r10, r0)
            if (r0 != r1) goto L_0x00d2
            return r1
        L_0x00d2:
            r0 = r9
        L_0x00d3:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> r1 = r0.cache
            r1.remove(r3)
            java.lang.String r10 = r10.getCustomerUserId()
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> r1 = r0.cache
            java.lang.String r2 = "UNSYNCED_CUSTOMER_USER_ID"
            java.lang.Object r1 = r1.get(r2)
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r1)
            r10 = r10 ^ r4
            if (r10 != 0) goto L_0x00f0
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> r10 = r0.cache
            r10.remove(r2)
        L_0x00f0:
            r0.saveLastSentInstallationMeta(r11)
            boolean r10 = r12.element
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.cache.CacheRepository.updateDataOnCreateProfile(com.adapty.internal.data.models.ProfileDto, com.adapty.internal.data.models.InstallationMeta, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final /* synthetic */ Object updateOnProfileReceived(ProfileDto profileDto, String str, Continuation continuation) {
        Long timestamp;
        if (str != null && !Intrinsics.areEqual((Object) getProfileId(), (Object) str)) {
            Long timestamp2 = profileDto.getTimestamp();
            long j = 0;
            long longValue = timestamp2 != null ? timestamp2.longValue() : 0;
            ProfileDto profile = getProfile();
            if (!(profile == null || (timestamp = profile.getTimestamp()) == null)) {
                j = timestamp.longValue();
            }
            if (longValue < j) {
                return profileDto;
            }
        }
        return saveProfile(profileDto, continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object saveProfile(com.adapty.internal.data.models.ProfileDto r5, kotlin.coroutines.Continuation<? super com.adapty.internal.data.models.ProfileDto> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.adapty.internal.data.cache.CacheRepository$saveProfile$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.adapty.internal.data.cache.CacheRepository$saveProfile$1 r0 = (com.adapty.internal.data.cache.CacheRepository$saveProfile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.adapty.internal.data.cache.CacheRepository$saveProfile$1 r0 = new com.adapty.internal.data.cache.CacheRepository$saveProfile$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            java.lang.Object r5 = r0.L$2
            com.adapty.internal.data.models.ProfileDto r5 = (com.adapty.internal.data.models.ProfileDto) r5
            java.lang.Object r1 = r0.L$1
            com.adapty.internal.data.models.ProfileDto r1 = (com.adapty.internal.data.models.ProfileDto) r1
            java.lang.Object r0 = r0.L$0
            com.adapty.internal.data.cache.CacheRepository r0 = (com.adapty.internal.data.cache.CacheRepository) r0
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r5
            r5 = r1
            goto L_0x0056
        L_0x0038:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.flow.MutableSharedFlow<com.adapty.internal.data.models.ProfileDto> r6 = r4.currentProfile
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r5
            r0.label = r3
            java.lang.Object r6 = r6.emit(r5, r0)
            if (r6 != r1) goto L_0x0054
            return r1
        L_0x0054:
            r0 = r4
            r6 = r5
        L_0x0056:
            java.lang.String r1 = "PROFILE"
            r0.saveData(r1, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.cache.CacheRepository.saveProfile(com.adapty.internal.data.models.ProfileDto, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final /* synthetic */ Flow subscribeOnProfileChanges() {
        return FlowKt.distinctUntilChanged(this.currentProfile);
    }

    public final /* synthetic */ String getAppKey() {
        return this.preferenceManager.getString(CacheKeysKt.APP_KEY);
    }

    public final /* synthetic */ void saveAppKey(String str) {
        Intrinsics.checkNotNullParameter(str, "appKey");
        this.preferenceManager.saveString(CacheKeysKt.APP_KEY, str);
    }

    public final /* synthetic */ String getProfileId() {
        Object obj = this.cache.get(CacheKeysKt.UNSYNCED_PROFILE_ID);
        String str = null;
        String str2 = obj instanceof String ? (String) obj : null;
        if (str2 == null) {
            str2 = getString$adapty_release(CacheKeysKt.PROFILE_ID);
        }
        if (str2 != null) {
            if (str2.length() > 0) {
                str = str2;
            }
            if (str != null) {
                return str;
            }
        }
        String generateUuid = UtilsKt.generateUuid();
        this.cache.put(CacheKeysKt.UNSYNCED_PROFILE_ID, generateUuid);
        return generateUuid;
    }

    private final void saveProfileId(String str) {
        this.cache.put(CacheKeysKt.PROFILE_ID, str);
        this.preferenceManager.saveString(CacheKeysKt.PROFILE_ID, str);
    }

    private final void onNewProfileIdReceived(String str) {
        clearData(SetsKt.setOf(CacheKeysKt.PROFILE, CacheKeysKt.SYNCED_PURCHASES, CacheKeysKt.PURCHASES_HAVE_BEEN_SYNCED, CacheKeysKt.APP_OPENED_TIME, CacheKeysKt.PRODUCT_RESPONSE, CacheKeysKt.PRODUCT_RESPONSE_HASH, CacheKeysKt.PROFILE_RESPONSE, CacheKeysKt.PROFILE_RESPONSE_HASH), SetsKt.setOf(CacheKeysKt.PAYWALL_RESPONSE_START_PART));
        saveProfileId(str);
    }

    public final /* synthetic */ String getCustomerUserId() {
        return getString$adapty_release(CacheKeysKt.CUSTOMER_USER_ID);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ kotlin.Pair getUnsyncedAuthData() {
        /*
            r4 = this;
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> r0 = r4.cache
            java.lang.String r1 = "UNSYNCED_PROFILE_ID"
            java.lang.Object r0 = r0.get(r1)
            boolean r1 = r0 instanceof java.lang.String
            r2 = 0
            if (r1 == 0) goto L_0x0010
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Object> r1 = r4.cache
            java.lang.String r3 = "UNSYNCED_CUSTOMER_USER_ID"
            java.lang.Object r1 = r1.get(r3)
            boolean r3 = r1 instanceof java.lang.String
            if (r3 == 0) goto L_0x0020
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2
        L_0x0020:
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.cache.CacheRepository.getUnsyncedAuthData():kotlin.Pair");
    }

    private final void saveCustomerUserId(String str) {
        this.cache.put(CacheKeysKt.CUSTOMER_USER_ID, str);
        this.preferenceManager.saveString(CacheKeysKt.CUSTOMER_USER_ID, str);
    }

    public final /* synthetic */ void prepareCustomerUserIdToSync(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            this.cache.remove(CacheKeysKt.UNSYNCED_CUSTOMER_USER_ID);
        } else if (!Intrinsics.areEqual((Object) getString$adapty_release(CacheKeysKt.CUSTOMER_USER_ID), (Object) str)) {
            this.cache.put(CacheKeysKt.UNSYNCED_CUSTOMER_USER_ID, str);
        }
    }

    public final /* synthetic */ void prepareProfileIdToSync() {
        if (this.cache.get(CacheKeysKt.UNSYNCED_PROFILE_ID) == null) {
            CharSequence string$adapty_release = getString$adapty_release(CacheKeysKt.PROFILE_ID);
            if (string$adapty_release == null || string$adapty_release.length() == 0) {
                this.cache.put(CacheKeysKt.UNSYNCED_PROFILE_ID, UtilsKt.generateUuid());
            }
        }
    }

    public final /* synthetic */ String getInstallationMetaId() {
        try {
            this.installationMetaLock.readLock().lock();
            String string$adapty_release = getString$adapty_release(CacheKeysKt.INSTALLATION_META_ID);
            CharSequence charSequence = string$adapty_release;
            boolean z = false;
            if (!(charSequence == null || charSequence.length() == 0)) {
                return string$adapty_release;
            }
            this.installationMetaLock.readLock().unlock();
            try {
                this.installationMetaLock.writeLock().lock();
                String string$adapty_release2 = getString$adapty_release(CacheKeysKt.INSTALLATION_META_ID);
                CharSequence charSequence2 = string$adapty_release2;
                if (charSequence2 == null || charSequence2.length() == 0) {
                    z = true;
                }
                if (z) {
                    string$adapty_release2 = UtilsKt.generateUuid();
                    saveInstallationMetaId(string$adapty_release2);
                }
                return string$adapty_release2;
            } finally {
                this.installationMetaLock.writeLock().unlock();
            }
        } finally {
            this.installationMetaLock.readLock().unlock();
        }
    }

    private final void saveInstallationMetaId(String str) {
        this.cache.put(CacheKeysKt.INSTALLATION_META_ID, str);
        this.preferenceManager.saveString(CacheKeysKt.INSTALLATION_META_ID, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.adapty.internal.data.models.InstallationMeta getInstallationMeta() {
        /*
            r7 = this;
            java.lang.Class<com.adapty.internal.data.models.InstallationMeta> r0 = com.adapty.internal.data.models.InstallationMeta.class
            java.util.concurrent.ConcurrentHashMap r1 = r7.cache
            java.util.concurrent.ConcurrentMap r1 = (java.util.concurrent.ConcurrentMap) r1
            java.lang.String r2 = "LAST_SENT_INSTALLATION_META"
            java.lang.Object r3 = r1.get(r2)
            r4 = 0
            if (r3 != 0) goto L_0x0058
            com.adapty.internal.data.cache.PreferenceManager r3 = r7.preferenceManager
            android.content.SharedPreferences r5 = r3.pref
            java.lang.String r5 = r5.getString(r2, r4)
            if (r5 == 0) goto L_0x004a
            java.lang.String r6 = "getString(key, null)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            boolean r6 = r3.isNotEmpty(r5)
            if (r6 == 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r5 = r4
        L_0x002c:
            if (r5 == 0) goto L_0x004a
            com.google.gson.Gson r6 = r3.gson     // Catch:{ Exception -> 0x004a }
            java.lang.Object r0 = r6.fromJson((java.lang.String) r5, r0)     // Catch:{ Exception -> 0x004a }
            if (r0 != 0) goto L_0x004b
            com.google.gson.Gson r0 = r3.gson     // Catch:{ Exception -> 0x004a }
            com.adapty.internal.data.cache.CacheRepository$getInstallationMeta$$inlined$getData$1 r3 = new com.adapty.internal.data.cache.CacheRepository$getInstallationMeta$$inlined$getData$1     // Catch:{ Exception -> 0x004a }
            r3.<init>()     // Catch:{ Exception -> 0x004a }
            java.lang.reflect.Type r3 = r3.getType()     // Catch:{ Exception -> 0x004a }
            java.lang.Object r0 = r0.fromJson((java.lang.String) r5, (java.lang.reflect.Type) r3)     // Catch:{ Exception -> 0x004a }
            goto L_0x004b
        L_0x004a:
            r0 = r4
        L_0x004b:
            if (r0 == 0) goto L_0x0057
            java.lang.Object r1 = r1.putIfAbsent(r2, r0)
            if (r1 != 0) goto L_0x0055
            r3 = r0
            goto L_0x0058
        L_0x0055:
            r3 = r1
            goto L_0x0058
        L_0x0057:
            r3 = r4
        L_0x0058:
            boolean r0 = r3 instanceof com.adapty.internal.data.models.InstallationMeta
            if (r0 != 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r4 = r3
        L_0x005e:
            com.adapty.internal.data.models.InstallationMeta r4 = (com.adapty.internal.data.models.InstallationMeta) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.cache.CacheRepository.getInstallationMeta():com.adapty.internal.data.models.InstallationMeta");
    }

    public final /* synthetic */ void saveLastSentInstallationMeta(InstallationMeta installationMeta) {
        Intrinsics.checkNotNullParameter(installationMeta, "installationMeta");
        saveData(CacheKeysKt.LAST_SENT_INSTALLATION_META, installationMeta);
    }

    public final /* synthetic */ boolean getPurchasesHaveBeenSynced() {
        ConcurrentMap concurrentMap = this.cache;
        Object obj = concurrentMap.get(CacheKeysKt.PURCHASES_HAVE_BEEN_SYNCED);
        Boolean bool = null;
        if (obj == null) {
            obj = this.preferenceManager.getBoolean(CacheKeysKt.PURCHASES_HAVE_BEEN_SYNCED, false);
            if (obj != null) {
                Object putIfAbsent = concurrentMap.putIfAbsent(CacheKeysKt.PURCHASES_HAVE_BEEN_SYNCED, obj);
                if (putIfAbsent != null) {
                    obj = putIfAbsent;
                }
            } else {
                obj = null;
            }
        }
        if (obj instanceof Boolean) {
            bool = obj;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final /* synthetic */ void setPurchasesHaveBeenSynced(boolean z) {
        this.cache.put(CacheKeysKt.PURCHASES_HAVE_BEEN_SYNCED, Boolean.valueOf(z));
        this.preferenceManager.saveBoolean(CacheKeysKt.PURCHASES_HAVE_BEEN_SYNCED, z);
    }

    public final /* synthetic */ Boolean getExternalAnalyticsEnabled() {
        ConcurrentMap concurrentMap = this.cache;
        Object obj = concurrentMap.get(CacheKeysKt.EXTERNAL_ANALYTICS_ENABLED);
        if (obj == null) {
            obj = this.preferenceManager.getBoolean(CacheKeysKt.EXTERNAL_ANALYTICS_ENABLED, (Boolean) null);
            if (obj != null) {
                Object putIfAbsent = concurrentMap.putIfAbsent(CacheKeysKt.EXTERNAL_ANALYTICS_ENABLED, obj);
                if (putIfAbsent != null) {
                    obj = putIfAbsent;
                }
            } else {
                obj = null;
            }
        }
        if (obj instanceof Boolean) {
            return obj;
        }
        return null;
    }

    public final /* synthetic */ void saveExternalAnalyticsEnabled(boolean z) {
        this.cache.put(CacheKeysKt.EXTERNAL_ANALYTICS_ENABLED, Boolean.valueOf(z));
        this.preferenceManager.saveBoolean(CacheKeysKt.EXTERNAL_ANALYTICS_ENABLED, z);
    }

    public final /* synthetic */ long getLastAppOpenedTime() {
        ConcurrentMap concurrentMap = this.cache;
        Object obj = concurrentMap.get(CacheKeysKt.APP_OPENED_TIME);
        Long l = null;
        if (obj == null) {
            obj = this.preferenceManager.getLong(CacheKeysKt.APP_OPENED_TIME, 0L);
            if (obj != null) {
                Object putIfAbsent = concurrentMap.putIfAbsent(CacheKeysKt.APP_OPENED_TIME, obj);
                if (putIfAbsent != null) {
                    obj = putIfAbsent;
                }
            } else {
                obj = null;
            }
        }
        if (obj instanceof Long) {
            l = obj;
        }
        if (l != null) {
            return l.longValue();
        }
        return 0;
    }

    public final /* synthetic */ void saveLastAppOpenedTime(long j) {
        this.cache.put(CacheKeysKt.APP_OPENED_TIME, Long.valueOf(j));
        this.preferenceManager.saveLong(CacheKeysKt.APP_OPENED_TIME, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.adapty.internal.data.models.ProfileDto getProfile() {
        /*
            r7 = this;
            java.lang.Class<com.adapty.internal.data.models.ProfileDto> r0 = com.adapty.internal.data.models.ProfileDto.class
            java.util.concurrent.ConcurrentHashMap r1 = r7.cache
            java.util.concurrent.ConcurrentMap r1 = (java.util.concurrent.ConcurrentMap) r1
            java.lang.String r2 = "PROFILE"
            java.lang.Object r3 = r1.get(r2)
            r4 = 0
            if (r3 != 0) goto L_0x0058
            com.adapty.internal.data.cache.PreferenceManager r3 = r7.preferenceManager
            android.content.SharedPreferences r5 = r3.pref
            java.lang.String r5 = r5.getString(r2, r4)
            if (r5 == 0) goto L_0x004a
            java.lang.String r6 = "getString(key, null)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            boolean r6 = r3.isNotEmpty(r5)
            if (r6 == 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r5 = r4
        L_0x002c:
            if (r5 == 0) goto L_0x004a
            com.google.gson.Gson r6 = r3.gson     // Catch:{ Exception -> 0x004a }
            java.lang.Object r0 = r6.fromJson((java.lang.String) r5, r0)     // Catch:{ Exception -> 0x004a }
            if (r0 != 0) goto L_0x004b
            com.google.gson.Gson r0 = r3.gson     // Catch:{ Exception -> 0x004a }
            com.adapty.internal.data.cache.CacheRepository$getProfile$$inlined$getData$1 r3 = new com.adapty.internal.data.cache.CacheRepository$getProfile$$inlined$getData$1     // Catch:{ Exception -> 0x004a }
            r3.<init>()     // Catch:{ Exception -> 0x004a }
            java.lang.reflect.Type r3 = r3.getType()     // Catch:{ Exception -> 0x004a }
            java.lang.Object r0 = r0.fromJson((java.lang.String) r5, (java.lang.reflect.Type) r3)     // Catch:{ Exception -> 0x004a }
            goto L_0x004b
        L_0x004a:
            r0 = r4
        L_0x004b:
            if (r0 == 0) goto L_0x0057
            java.lang.Object r1 = r1.putIfAbsent(r2, r0)
            if (r1 != 0) goto L_0x0055
            r3 = r0
            goto L_0x0058
        L_0x0055:
            r3 = r1
            goto L_0x0058
        L_0x0057:
            r3 = r4
        L_0x0058:
            boolean r0 = r3 instanceof com.adapty.internal.data.models.ProfileDto
            if (r0 != 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r4 = r3
        L_0x005e:
            com.adapty.internal.data.models.ProfileDto r4 = (com.adapty.internal.data.models.ProfileDto) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.cache.CacheRepository.getProfile():com.adapty.internal.data.models.ProfileDto");
    }

    public final /* synthetic */ FallbackPaywalls getFallbackPaywalls() {
        Object obj = this.cache.get(CacheKeysKt.FALLBACK_PAYWALLS);
        if (obj instanceof FallbackPaywalls) {
            return (FallbackPaywalls) obj;
        }
        return null;
    }

    public final /* synthetic */ void saveSyncedPurchases(Set set) {
        Intrinsics.checkNotNullParameter(set, "data");
        saveData(CacheKeysKt.SYNCED_PURCHASES, set);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.adapty.internal.data.models.AnalyticsData getAnalyticsData(boolean r6) {
        /*
            r5 = this;
            java.lang.String r6 = r5.getAnalyticsKey(r6)
            java.util.concurrent.ConcurrentHashMap r0 = r5.cache
            java.util.concurrent.ConcurrentMap r0 = (java.util.concurrent.ConcurrentMap) r0
            java.lang.Object r1 = r0.get(r6)
            r2 = 0
            if (r1 != 0) goto L_0x004d
            com.adapty.internal.data.cache.PreferenceManager r1 = r5.preferenceManager
            android.content.SharedPreferences r3 = r1.pref
            java.lang.String r3 = r3.getString(r6, r2)
            if (r3 == 0) goto L_0x0040
            java.lang.String r4 = "getString(key, null)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            boolean r4 = r1.isNotEmpty(r3)
            if (r4 == 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r3 = r2
        L_0x002c:
            if (r3 == 0) goto L_0x0040
            com.google.gson.Gson r1 = r1.gson     // Catch:{ Exception -> 0x0040 }
            com.adapty.internal.data.cache.CacheRepository$getAnalyticsData$$inlined$getData$default$1 r4 = new com.adapty.internal.data.cache.CacheRepository$getAnalyticsData$$inlined$getData$default$1     // Catch:{ Exception -> 0x0040 }
            r4.<init>()     // Catch:{ Exception -> 0x0040 }
            java.lang.reflect.Type r4 = r4.getType()     // Catch:{ Exception -> 0x0040 }
            java.lang.Object r1 = r1.fromJson((java.lang.String) r3, (java.lang.reflect.Type) r4)     // Catch:{ Exception -> 0x0040 }
            goto L_0x0041
        L_0x0040:
            r1 = r2
        L_0x0041:
            if (r1 == 0) goto L_0x004c
            java.lang.Object r6 = r0.putIfAbsent(r6, r1)
            if (r6 != 0) goto L_0x004a
            goto L_0x004d
        L_0x004a:
            r1 = r6
            goto L_0x004d
        L_0x004c:
            r1 = r2
        L_0x004d:
            boolean r6 = r1 instanceof com.adapty.internal.data.models.AnalyticsData
            if (r6 != 0) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r2 = r1
        L_0x0053:
            com.adapty.internal.data.models.AnalyticsData r2 = (com.adapty.internal.data.models.AnalyticsData) r2
            if (r2 != 0) goto L_0x005d
            com.adapty.internal.data.models.AnalyticsData$Companion r6 = com.adapty.internal.data.models.AnalyticsData.Companion
            com.adapty.internal.data.models.AnalyticsData r2 = r6.getDEFAULT()
        L_0x005d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.cache.CacheRepository.getAnalyticsData(boolean):com.adapty.internal.data.models.AnalyticsData");
    }

    public final /* synthetic */ void saveAnalyticsData(AnalyticsData analyticsData, boolean z) {
        Intrinsics.checkNotNullParameter(analyticsData, "data");
        saveData(getAnalyticsKey(z), analyticsData);
    }

    public final AnalyticsConfig getAnalyticsConfig() {
        return this.analyticsConfig;
    }

    public final void setAnalyticsConfig(AnalyticsConfig analyticsConfig2) {
        Intrinsics.checkNotNullParameter(analyticsConfig2, "<set-?>");
        this.analyticsConfig = analyticsConfig2;
    }

    public static /* synthetic */ PaywallDto getPaywall$default(CacheRepository cacheRepository, String str, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        return cacheRepository.getPaywall(str, l);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.adapty.internal.data.models.PaywallDto getPaywall(java.lang.String r6, java.lang.Long r7) {
        /*
            r5 = this;
            java.lang.String r0 = "id"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r6 = r5.getPaywallCacheKey(r6)
            java.util.concurrent.ConcurrentHashMap r0 = r5.cache
            java.util.concurrent.ConcurrentMap r0 = (java.util.concurrent.ConcurrentMap) r0
            java.lang.Object r1 = r0.get(r6)
            r2 = 0
            if (r1 != 0) goto L_0x0052
            com.adapty.internal.data.cache.PreferenceManager r1 = r5.preferenceManager
            android.content.SharedPreferences r3 = r1.pref
            java.lang.String r3 = r3.getString(r6, r2)
            if (r3 == 0) goto L_0x0045
            java.lang.String r4 = "getString(key, null)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            boolean r4 = r1.isNotEmpty(r3)
            if (r4 == 0) goto L_0x0030
            goto L_0x0031
        L_0x0030:
            r3 = r2
        L_0x0031:
            if (r3 == 0) goto L_0x0045
            com.google.gson.Gson r1 = r1.gson     // Catch:{ Exception -> 0x0045 }
            com.adapty.internal.data.cache.CacheRepository$getPaywall$$inlined$getData$default$1 r4 = new com.adapty.internal.data.cache.CacheRepository$getPaywall$$inlined$getData$default$1     // Catch:{ Exception -> 0x0045 }
            r4.<init>()     // Catch:{ Exception -> 0x0045 }
            java.lang.reflect.Type r4 = r4.getType()     // Catch:{ Exception -> 0x0045 }
            java.lang.Object r1 = r1.fromJson((java.lang.String) r3, (java.lang.reflect.Type) r4)     // Catch:{ Exception -> 0x0045 }
            goto L_0x0046
        L_0x0045:
            r1 = r2
        L_0x0046:
            if (r1 == 0) goto L_0x0051
            java.lang.Object r6 = r0.putIfAbsent(r6, r1)
            if (r6 != 0) goto L_0x004f
            goto L_0x0052
        L_0x004f:
            r1 = r6
            goto L_0x0052
        L_0x0051:
            r1 = r2
        L_0x0052:
            boolean r6 = r1 instanceof com.adapty.internal.data.cache.CacheEntity
            if (r6 != 0) goto L_0x0057
            r1 = r2
        L_0x0057:
            com.adapty.internal.data.cache.CacheEntity r1 = (com.adapty.internal.data.cache.CacheEntity) r1
            if (r1 == 0) goto L_0x007b
            java.lang.Object r6 = r1.component1()
            com.adapty.internal.data.models.PaywallDto r6 = (com.adapty.internal.data.models.PaywallDto) r6
            long r0 = r1.component2()
            if (r7 == 0) goto L_0x0077
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r0
            long r0 = r7.longValue()
            int r7 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r7 > 0) goto L_0x0075
            goto L_0x0077
        L_0x0075:
            r7 = 0
            goto L_0x0078
        L_0x0077:
            r7 = 1
        L_0x0078:
            if (r7 == 0) goto L_0x007b
            r2 = r6
        L_0x007b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.cache.CacheRepository.getPaywall(java.lang.String, java.lang.Long):com.adapty.internal.data.models.PaywallDto");
    }

    public final void savePaywall(String str, PaywallDto paywallDto) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(paywallDto, "paywallDto");
        saveData(getPaywallCacheKey(str), new CacheEntity(paywallDto, 0, 2, (DefaultConstructorMarker) null));
    }

    private final String getPaywallCacheKey(String str) {
        return CacheKeysKt.PAYWALL_RESPONSE_START_PART + str + CacheKeysKt.PAYWALL_RESPONSE_END_PART;
    }

    public final /* synthetic */ AdaptyError saveFallbackPaywalls(String str) {
        Intrinsics.checkNotNullParameter(str, "paywalls");
        try {
            Map map = this.cache;
            Object fromJson = this.gson.fromJson(str, FallbackPaywalls.class);
            int version = ((FallbackPaywalls) fromJson).getVersion();
            if (version < 4) {
                Logger logger = Logger.INSTANCE;
                AdaptyLogLevel adaptyLogLevel = AdaptyLogLevel.ERROR;
                if (logger.canLog(adaptyLogLevel.value)) {
                    logger.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel, "The fallback paywalls version is not correct. Download a new one from the Adapty Dashboard."));
                }
            } else if (version > 4) {
                Logger logger2 = Logger.INSTANCE;
                AdaptyLogLevel adaptyLogLevel2 = AdaptyLogLevel.ERROR;
                if (logger2.canLog(adaptyLogLevel2.value)) {
                    logger2.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel2, "The fallback paywalls version is not correct. Please update the AdaptySDK."));
                }
            }
            Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(paywalls, …          }\n            }");
            map.put(CacheKeysKt.FALLBACK_PAYWALLS, fromJson);
            return null;
        } catch (Exception e) {
            Logger logger3 = Logger.INSTANCE;
            AdaptyLogLevel adaptyLogLevel3 = AdaptyLogLevel.ERROR;
            if (logger3.canLog(adaptyLogLevel3.value)) {
                logger3.getLogExecutor().execute(new Logger$log$1(adaptyLogLevel3, "Couldn't set fallback paywalls. " + e));
            }
            return new AdaptyError(e, "Couldn't set fallback paywalls. Invalid JSON", AdaptyErrorCode.INVALID_JSON);
        }
    }

    public final /* synthetic */ void clearOnLogout() {
        clearData(SetsKt.setOf(CacheKeysKt.CUSTOMER_USER_ID, CacheKeysKt.PROFILE_ID, CacheKeysKt.PROFILE, CacheKeysKt.SYNCED_PURCHASES, CacheKeysKt.PURCHASES_HAVE_BEEN_SYNCED, CacheKeysKt.APP_OPENED_TIME, CacheKeysKt.PRODUCT_RESPONSE, CacheKeysKt.PRODUCT_RESPONSE_HASH, CacheKeysKt.PROFILE_RESPONSE, CacheKeysKt.PROFILE_RESPONSE_HASH), SetsKt.setOf(CacheKeysKt.PAYWALL_RESPONSE_START_PART));
    }

    public final /* synthetic */ void clearSyncedPurchases() {
        clearData(SetsKt.setOf(CacheKeysKt.SYNCED_PURCHASES, CacheKeysKt.PURCHASES_HAVE_BEEN_SYNCED), SetsKt.emptySet());
    }

    public final /* synthetic */ void clearOnAppKeyChanged() {
        clearData(SetsKt.setOf(CacheKeysKt.CUSTOMER_USER_ID, CacheKeysKt.PROFILE_ID, CacheKeysKt.PROFILE, CacheKeysKt.SYNCED_PURCHASES, CacheKeysKt.PURCHASES_HAVE_BEEN_SYNCED, CacheKeysKt.APP_OPENED_TIME, CacheKeysKt.PRODUCT_RESPONSE, CacheKeysKt.PRODUCT_RESPONSE_HASH, CacheKeysKt.PRODUCT_IDS_RESPONSE, CacheKeysKt.PRODUCT_IDS_RESPONSE_HASH, CacheKeysKt.PROFILE_RESPONSE, CacheKeysKt.PROFILE_RESPONSE_HASH, CacheKeysKt.ANALYTICS_DATA, CacheKeysKt.YET_UNPROCESSED_VALIDATE_PRODUCT_INFO, CacheKeysKt.EXTERNAL_ANALYTICS_ENABLED), SetsKt.setOf(CacheKeysKt.PAYWALL_RESPONSE_START_PART));
    }

    private final void clearData(Set<String> set, Set<String> set2) {
        Set<String> keysToRemove = this.preferenceManager.getKeysToRemove(set, set2);
        ConcurrentHashMap<String, Object> concurrentHashMap = this.cache;
        for (String remove : keysToRemove) {
            concurrentHashMap.remove(remove);
        }
        this.preferenceManager.clearData(keysToRemove);
    }

    public final /* synthetic */ String getString$adapty_release(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        ConcurrentMap concurrentMap = this.cache;
        Object obj = concurrentMap.get(str);
        if (obj == null) {
            obj = this.preferenceManager.getString(str);
            if (obj != null) {
                Object putIfAbsent = concurrentMap.putIfAbsent(str, obj);
                if (putIfAbsent != null) {
                    obj = putIfAbsent;
                }
            } else {
                obj = null;
            }
        }
        if (obj instanceof String) {
            return obj;
        }
        return null;
    }

    public final /* synthetic */ String getSessionId() {
        ConcurrentMap concurrentMap = this.cache;
        Object obj = concurrentMap.get(CacheKeysKt.SESSION_ID);
        if (obj == null) {
            obj = UtilsKt.generateUuid();
            if (obj != null) {
                Object putIfAbsent = concurrentMap.putIfAbsent(CacheKeysKt.SESSION_ID, obj);
                if (putIfAbsent != null) {
                    obj = putIfAbsent;
                }
            } else {
                obj = null;
            }
        }
        if (obj instanceof String) {
            return obj;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        if (r7 == null) goto L_0x0042;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final /* synthetic */ <T> T getData(java.lang.String r6, java.lang.Class<T> r7) {
        /*
            r5 = this;
            java.util.concurrent.ConcurrentHashMap r0 = r5.cache
            java.util.concurrent.ConcurrentMap r0 = (java.util.concurrent.ConcurrentMap) r0
            java.lang.Object r1 = r0.get(r6)
            r2 = 0
            if (r1 != 0) goto L_0x0065
            com.adapty.internal.data.cache.PreferenceManager r1 = r5.preferenceManager
            android.content.SharedPreferences r3 = r1.pref
            java.lang.String r3 = r3.getString(r6, r2)
            if (r3 == 0) goto L_0x0057
            java.lang.String r4 = "getString(key, null)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4
            boolean r4 = r1.isNotEmpty(r3)
            if (r4 == 0) goto L_0x002a
            goto L_0x002b
        L_0x002a:
            r3 = r2
        L_0x002b:
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4
            if (r3 == 0) goto L_0x0057
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4
            if (r7 == 0) goto L_0x0042
            r4 = r7
            java.lang.Class r4 = (java.lang.Class) r4     // Catch:{ Exception -> 0x0057 }
            com.google.gson.Gson r4 = r1.gson     // Catch:{ Exception -> 0x0057 }
            java.lang.Object r7 = r4.fromJson((java.lang.String) r3, r7)     // Catch:{ Exception -> 0x0057 }
            if (r7 != 0) goto L_0x0058
        L_0x0042:
            com.google.gson.Gson r7 = r1.gson     // Catch:{ Exception -> 0x0057 }
            kotlin.jvm.internal.Intrinsics.needClassReification()     // Catch:{ Exception -> 0x0057 }
            com.adapty.internal.data.cache.CacheRepository$getData$lambda$18$$inlined$getData$1 r1 = new com.adapty.internal.data.cache.CacheRepository$getData$lambda$18$$inlined$getData$1     // Catch:{ Exception -> 0x0057 }
            r1.<init>()     // Catch:{ Exception -> 0x0057 }
            java.lang.reflect.Type r1 = r1.getType()     // Catch:{ Exception -> 0x0057 }
            java.lang.Object r7 = r7.fromJson((java.lang.String) r3, (java.lang.reflect.Type) r1)     // Catch:{ Exception -> 0x0057 }
            goto L_0x0058
        L_0x0057:
            r7 = r2
        L_0x0058:
            if (r7 == 0) goto L_0x0064
            java.lang.Object r6 = r0.putIfAbsent(r6, r7)
            if (r6 != 0) goto L_0x0062
            r1 = r7
            goto L_0x0065
        L_0x0062:
            r1 = r6
            goto L_0x0065
        L_0x0064:
            r1 = r2
        L_0x0065:
            r6 = 2
            java.lang.String r7 = "T"
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r6, r7)
            r6 = r1
            java.lang.Object r6 = (java.lang.Object) r6
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.cache.CacheRepository.getData(java.lang.String, java.lang.Class):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0045, code lost:
        if (r5 == null) goto L_0x0047;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object getData$default(com.adapty.internal.data.cache.CacheRepository r3, java.lang.String r4, java.lang.Class r5, int r6, java.lang.Object r7) {
        /*
            r7 = 2
            r6 = r6 & r7
            r0 = 0
            if (r6 == 0) goto L_0x0006
            r5 = r0
        L_0x0006:
            java.util.concurrent.ConcurrentHashMap r6 = r3.cache
            java.util.concurrent.ConcurrentMap r6 = (java.util.concurrent.ConcurrentMap) r6
            java.lang.Object r1 = r6.get(r4)
            if (r1 != 0) goto L_0x0069
            com.adapty.internal.data.cache.PreferenceManager r3 = r3.preferenceManager
            android.content.SharedPreferences r1 = r3.pref
            java.lang.String r1 = r1.getString(r4, r0)
            if (r1 == 0) goto L_0x005c
            java.lang.String r2 = "getString(key, null)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = r3.isNotEmpty(r1)
            if (r2 == 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r1 = r0
        L_0x0030:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2
            if (r1 == 0) goto L_0x005c
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2
            if (r5 == 0) goto L_0x0047
            r2 = r5
            java.lang.Class r2 = (java.lang.Class) r2     // Catch:{ Exception -> 0x005c }
            com.google.gson.Gson r2 = r3.gson     // Catch:{ Exception -> 0x005c }
            java.lang.Object r5 = r2.fromJson((java.lang.String) r1, r5)     // Catch:{ Exception -> 0x005c }
            if (r5 != 0) goto L_0x005d
        L_0x0047:
            com.google.gson.Gson r3 = r3.gson     // Catch:{ Exception -> 0x005c }
            kotlin.jvm.internal.Intrinsics.needClassReification()     // Catch:{ Exception -> 0x005c }
            com.adapty.internal.data.cache.CacheRepository$getData$lambda$18$$inlined$getData$1 r5 = new com.adapty.internal.data.cache.CacheRepository$getData$lambda$18$$inlined$getData$1     // Catch:{ Exception -> 0x005c }
            r5.<init>()     // Catch:{ Exception -> 0x005c }
            java.lang.reflect.Type r5 = r5.getType()     // Catch:{ Exception -> 0x005c }
            java.lang.Object r5 = r3.fromJson((java.lang.String) r1, (java.lang.reflect.Type) r5)     // Catch:{ Exception -> 0x005c }
            goto L_0x005d
        L_0x005c:
            r5 = r0
        L_0x005d:
            if (r5 == 0) goto L_0x006a
            java.lang.Object r3 = r6.putIfAbsent(r4, r5)
            if (r3 != 0) goto L_0x0067
            r0 = r5
            goto L_0x006a
        L_0x0067:
            r0 = r3
            goto L_0x006a
        L_0x0069:
            r0 = r1
        L_0x006a:
            java.lang.String r3 = "T"
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r7, r3)
            r3 = r0
            java.lang.Object r3 = (java.lang.Object) r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.cache.CacheRepository.getData$default(com.adapty.internal.data.cache.CacheRepository, java.lang.String, java.lang.Class, int, java.lang.Object):java.lang.Object");
    }

    private final void saveData(String str, Object obj) {
        ConcurrentHashMap<String, Object> concurrentHashMap = this.cache;
        if (obj != null) {
            concurrentHashMap.put(str, obj);
        } else {
            concurrentHashMap.remove(str);
        }
        this.preferenceManager.saveData(str, obj);
    }

    private final <K, V> V safeGetOrPut(ConcurrentMap<K, V> concurrentMap, K k, Function0<? extends V> function0) {
        V v = concurrentMap.get(k);
        if (v != null) {
            return v;
        }
        V invoke = function0.invoke();
        if (invoke == null) {
            return null;
        }
        V putIfAbsent = concurrentMap.putIfAbsent(k, invoke);
        return putIfAbsent == null ? invoke : putIfAbsent;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/adapty/internal/data/cache/CacheRepository$Companion;", "", "()V", "CURRENT_FALLBACK_PAYWALL_VERSION", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CacheRepository.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.util.Set getSyncedPurchases() {
        /*
            r6 = this;
            java.util.concurrent.ConcurrentHashMap r0 = r6.cache
            java.util.concurrent.ConcurrentMap r0 = (java.util.concurrent.ConcurrentMap) r0
            java.lang.String r1 = "SYNCED_PURCHASES"
            java.lang.Object r2 = r0.get(r1)
            r3 = 0
            if (r2 != 0) goto L_0x004b
            com.adapty.internal.data.cache.PreferenceManager r2 = r6.preferenceManager
            android.content.SharedPreferences r4 = r2.pref
            java.lang.String r4 = r4.getString(r1, r3)
            if (r4 == 0) goto L_0x003e
            java.lang.String r5 = "getString(key, null)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            boolean r5 = r2.isNotEmpty(r4)
            if (r5 == 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r4 = r3
        L_0x002a:
            if (r4 == 0) goto L_0x003e
            com.google.gson.Gson r2 = r2.gson     // Catch:{ Exception -> 0x003e }
            com.adapty.internal.data.cache.CacheRepository$getSyncedPurchases$$inlined$getData$default$1 r5 = new com.adapty.internal.data.cache.CacheRepository$getSyncedPurchases$$inlined$getData$default$1     // Catch:{ Exception -> 0x003e }
            r5.<init>()     // Catch:{ Exception -> 0x003e }
            java.lang.reflect.Type r5 = r5.getType()     // Catch:{ Exception -> 0x003e }
            java.lang.Object r2 = r2.fromJson((java.lang.String) r4, (java.lang.reflect.Type) r5)     // Catch:{ Exception -> 0x003e }
            goto L_0x003f
        L_0x003e:
            r2 = r3
        L_0x003f:
            if (r2 == 0) goto L_0x004a
            java.lang.Object r0 = r0.putIfAbsent(r1, r2)
            if (r0 != 0) goto L_0x0048
            goto L_0x004b
        L_0x0048:
            r2 = r0
            goto L_0x004b
        L_0x004a:
            r2 = r3
        L_0x004b:
            boolean r0 = r2 instanceof java.util.HashSet
            if (r0 != 0) goto L_0x0050
            goto L_0x0051
        L_0x0050:
            r3 = r2
        L_0x0051:
            java.util.HashSet r3 = (java.util.HashSet) r3
            java.util.Set r3 = (java.util.Set) r3
            if (r3 != 0) goto L_0x005b
            java.util.Set r3 = kotlin.collections.SetsKt.emptySet()
        L_0x005b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.cache.CacheRepository.getSyncedPurchases():java.util.Set");
    }

    public final /* synthetic */ void saveRequestOrResponseLatestData$adapty_release(Map map) {
        Intrinsics.checkNotNullParameter(map, AdaptyImmutableMapTypeAdapterFactory.MAP);
        for (Map.Entry entry : map.entrySet()) {
            this.cache.put((String) entry.getKey(), (String) entry.getValue());
        }
        this.preferenceManager.saveStrings(map);
    }
}
