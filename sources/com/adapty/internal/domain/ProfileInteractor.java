package com.adapty.internal.domain;

import com.adapty.internal.data.cache.CacheRepository;
import com.adapty.internal.data.cloud.CloudRepository;
import com.adapty.internal.utils.AttributionHelper;
import com.adapty.internal.utils.CustomAttributeValidator;
import com.adapty.internal.utils.IPv4Retriever;
import com.adapty.internal.utils.ProfileMapper;
import com.adapty.models.AdaptyAttributionSource;
import com.adapty.models.AdaptyProfileParameters;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001:\u0001*B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0015J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0012J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012J&\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00180\u00122\u0006\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#J \u0010$\u001a\b\u0012\u0004\u0012\u00020\u00180\u00122\b\u0010%\u001a\u0004\u0018\u00010&2\b\b\u0002\u0010\u0014\u001a\u00020\u0015J&\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00180\u00122\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010)H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/adapty/internal/domain/ProfileInteractor;", "", "authInteractor", "Lcom/adapty/internal/domain/AuthInteractor;", "cloudRepository", "Lcom/adapty/internal/data/cloud/CloudRepository;", "cacheRepository", "Lcom/adapty/internal/data/cache/CacheRepository;", "profileMapper", "Lcom/adapty/internal/utils/ProfileMapper;", "attributionHelper", "Lcom/adapty/internal/utils/AttributionHelper;", "customAttributeValidator", "Lcom/adapty/internal/utils/CustomAttributeValidator;", "iPv4Retriever", "Lcom/adapty/internal/utils/IPv4Retriever;", "(Lcom/adapty/internal/domain/AuthInteractor;Lcom/adapty/internal/data/cloud/CloudRepository;Lcom/adapty/internal/data/cache/CacheRepository;Lcom/adapty/internal/utils/ProfileMapper;Lcom/adapty/internal/utils/AttributionHelper;Lcom/adapty/internal/utils/CustomAttributeValidator;Lcom/adapty/internal/utils/IPv4Retriever;)V", "getProfile", "Lkotlinx/coroutines/flow/Flow;", "Lcom/adapty/models/AdaptyProfile;", "maxAttemptCount", "", "getProfileOnStart", "sendIpWhenReceived", "", "subscribeOnEventsForStartRequests", "Lkotlin/Pair;", "", "subscribeOnProfileChanges", "syncMetaOnStart", "updateAttribution", "attribution", "source", "Lcom/adapty/models/AdaptyAttributionSource;", "networkUserId", "", "updateProfile", "params", "Lcom/adapty/models/AdaptyProfileParameters;", "validateCustomAttributes", "attrs", "", "NothingToUpdateException", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProfileInteractor.kt */
public final class ProfileInteractor {
    /* access modifiers changed from: private */
    public final AttributionHelper attributionHelper;
    /* access modifiers changed from: private */
    public final AuthInteractor authInteractor;
    /* access modifiers changed from: private */
    public final CacheRepository cacheRepository;
    /* access modifiers changed from: private */
    public final CloudRepository cloudRepository;
    /* access modifiers changed from: private */
    public final CustomAttributeValidator customAttributeValidator;
    /* access modifiers changed from: private */
    public final IPv4Retriever iPv4Retriever;
    /* access modifiers changed from: private */
    public final ProfileMapper profileMapper;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/adapty/internal/domain/ProfileInteractor$NothingToUpdateException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ProfileInteractor.kt */
    private static final class NothingToUpdateException extends Exception {
    }

    public ProfileInteractor(AuthInteractor authInteractor2, CloudRepository cloudRepository2, CacheRepository cacheRepository2, ProfileMapper profileMapper2, AttributionHelper attributionHelper2, CustomAttributeValidator customAttributeValidator2, IPv4Retriever iPv4Retriever2) {
        Intrinsics.checkNotNullParameter(authInteractor2, "authInteractor");
        Intrinsics.checkNotNullParameter(cloudRepository2, "cloudRepository");
        Intrinsics.checkNotNullParameter(cacheRepository2, "cacheRepository");
        Intrinsics.checkNotNullParameter(profileMapper2, "profileMapper");
        Intrinsics.checkNotNullParameter(attributionHelper2, "attributionHelper");
        Intrinsics.checkNotNullParameter(customAttributeValidator2, "customAttributeValidator");
        Intrinsics.checkNotNullParameter(iPv4Retriever2, "iPv4Retriever");
        this.authInteractor = authInteractor2;
        this.cloudRepository = cloudRepository2;
        this.cacheRepository = cacheRepository2;
        this.profileMapper = profileMapper2;
        this.attributionHelper = attributionHelper2;
        this.customAttributeValidator = customAttributeValidator2;
        this.iPv4Retriever = iPv4Retriever2;
    }

    public static /* synthetic */ Flow getProfile$default(ProfileInteractor profileInteractor, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 3;
        }
        return profileInteractor.getProfile(j);
    }

    public final /* synthetic */ Flow getProfile(long j) {
        return Intrinsics.checkNotNullParameter(FlowKt.m2547catch(new ProfileInteractor$getProfile$$inlined$map$1(AuthInteractor.runWhenAuthDataSynced$default(this.authInteractor, j, (Function0) null, new ProfileInteractor$getProfile$1(this, (Continuation<? super ProfileInteractor$getProfile$1>) null), 2, (Object) null), this), new ProfileInteractor$getProfile$3(this, (Continuation<? super ProfileInteractor$getProfile$3>) null)), "<this>");
    }

    public static /* synthetic */ Flow updateProfile$default(ProfileInteractor profileInteractor, AdaptyProfileParameters adaptyProfileParameters, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 3;
        }
        return profileInteractor.updateProfile(adaptyProfileParameters, j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r9.getCustomAttributes();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ kotlinx.coroutines.flow.Flow updateProfile(com.adapty.models.AdaptyProfileParameters r9, long r10) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x000e
            com.adapty.utils.ImmutableMap r1 = r9.getCustomAttributes()
            if (r1 == 0) goto L_0x000e
            java.util.Map r1 = r1.getMap$adapty_release()
            goto L_0x000f
        L_0x000e:
            r1 = r0
        L_0x000f:
            kotlinx.coroutines.flow.Flow r1 = r8.validateCustomAttributes(r1)
            com.adapty.internal.domain.ProfileInteractor$updateProfile$1 r2 = new com.adapty.internal.domain.ProfileInteractor$updateProfile$1
            r2.<init>(r8, r0)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            kotlinx.coroutines.flow.Flow r0 = kotlinx.coroutines.flow.FlowKt.flatMapConcat(r1, r2)
            com.adapty.internal.domain.ProfileInteractor$updateProfile$2 r7 = new com.adapty.internal.domain.ProfileInteractor$updateProfile$2
            r6 = 0
            r1 = r7
            r2 = r8
            r3 = r10
            r5 = r9
            r1.<init>(r2, r3, r5, r6)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            kotlinx.coroutines.flow.Flow r10 = kotlinx.coroutines.flow.FlowKt.flatMapConcat(r0, r7)
            kotlinx.coroutines.flow.Flow r10 = kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, "<this>")
            if (r9 == 0) goto L_0x0045
            java.lang.Boolean r9 = r9.getAnalyticsDisabled()
            if (r9 == 0) goto L_0x0045
            boolean r9 = r9.booleanValue()
            r9 = r9 ^ 1
            com.adapty.internal.data.cache.CacheRepository r11 = r8.cacheRepository
            r11.saveExternalAnalyticsEnabled(r9)
        L_0x0045:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.domain.ProfileInteractor.updateProfile(com.adapty.models.AdaptyProfileParameters, long):kotlinx.coroutines.flow.Flow");
    }

    private final Flow<Unit> validateCustomAttributes(Map<String, ? extends Object> map) {
        return FlowKt.flow(new ProfileInteractor$validateCustomAttributes$1(map, this, (Continuation<? super ProfileInteractor$validateCustomAttributes$1>) null));
    }

    public final /* synthetic */ Flow getProfileOnStart() {
        return getProfile(-1);
    }

    public final /* synthetic */ Flow syncMetaOnStart() {
        return updateProfile((AdaptyProfileParameters) null, -1);
    }

    public final /* synthetic */ Flow updateAttribution(Object obj, AdaptyAttributionSource adaptyAttributionSource, String str) {
        Intrinsics.checkNotNullParameter(obj, "attribution");
        Intrinsics.checkNotNullParameter(adaptyAttributionSource, "source");
        return Intrinsics.checkNotNullParameter(new ProfileInteractor$updateAttribution$$inlined$map$1(AuthInteractor.runWhenAuthDataSynced$default(this.authInteractor, 0, (Function0) null, new ProfileInteractor$updateAttribution$1(this, obj, adaptyAttributionSource, str, (Continuation<? super ProfileInteractor$updateAttribution$1>) null), 3, (Object) null), this), "<this>");
    }

    public final /* synthetic */ Flow subscribeOnProfileChanges() {
        return new ProfileInteractor$subscribeOnProfileChanges$$inlined$map$1(this.cacheRepository.subscribeOnProfileChanges(), this.profileMapper);
    }

    public final /* synthetic */ Flow subscribeOnEventsForStartRequests() {
        return Intrinsics.checkNotNullParameter(new ProfileInteractor$subscribeOnEventsForStartRequests$$inlined$filter$1(new ProfileInteractor$subscribeOnEventsForStartRequests$$inlined$map$1(FlowKt.scan(FlowKt.onStart(this.cacheRepository.subscribeOnProfileChanges(), new ProfileInteractor$subscribeOnEventsForStartRequests$1(this, (Continuation<? super ProfileInteractor$subscribeOnEventsForStartRequests$1>) null)), new Pair(null, null), new ProfileInteractor$subscribeOnEventsForStartRequests$2((Continuation<? super ProfileInteractor$subscribeOnEventsForStartRequests$2>) null)))), "<this>");
    }

    /* access modifiers changed from: private */
    public final void sendIpWhenReceived() {
        this.iPv4Retriever.setOnValueReceived(new ProfileInteractor$sendIpWhenReceived$1(this));
    }
}
