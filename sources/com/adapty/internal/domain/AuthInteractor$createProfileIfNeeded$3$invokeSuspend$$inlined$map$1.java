package com.adapty.internal.domain;

import com.adapty.internal.data.models.InstallationMeta;
import com.adapty.internal.domain.models.ProfileRequestResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class AuthInteractor$createProfileIfNeeded$3$invokeSuspend$$inlined$map$1 implements Flow<ProfileRequestResult> {
    final /* synthetic */ InstallationMeta $installationMeta$inlined;
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ AuthInteractor this$0;

    public AuthInteractor$createProfileIfNeeded$3$invokeSuspend$$inlined$map$1(Flow flow, AuthInteractor authInteractor, InstallationMeta installationMeta) {
        this.$this_unsafeTransform$inlined = flow;
        this.this$0 = authInteractor;
        this.$installationMeta$inlined = installationMeta;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Flow flow = this.$this_unsafeTransform$inlined;
        final AuthInteractor authInteractor = this.this$0;
        final InstallationMeta installationMeta = this.$installationMeta$inlined;
        Object collect = flow.collect(new Object() {
            /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0065  */
            /* JADX WARNING: Removed duplicated region for block: B:21:0x0068  */
            /* JADX WARNING: Removed duplicated region for block: B:24:0x0077 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof com.adapty.internal.domain.AuthInteractor$createProfileIfNeeded$3$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0014
                    r0 = r9
                    com.adapty.internal.domain.AuthInteractor$createProfileIfNeeded$3$invokeSuspend$$inlined$map$1$2$1 r0 = (com.adapty.internal.domain.AuthInteractor$createProfileIfNeeded$3$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r9 = r0.label
                    int r9 = r9 - r2
                    r0.label = r9
                    goto L_0x0019
                L_0x0014:
                    com.adapty.internal.domain.AuthInteractor$createProfileIfNeeded$3$invokeSuspend$$inlined$map$1$2$1 r0 = new com.adapty.internal.domain.AuthInteractor$createProfileIfNeeded$3$invokeSuspend$$inlined$map$1$2$1
                    r0.<init>(r7, r9)
                L_0x0019:
                    java.lang.Object r9 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L_0x003d
                    if (r2 == r4) goto L_0x0035
                    if (r2 != r3) goto L_0x002d
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L_0x0078
                L_0x002d:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L_0x0035:
                    java.lang.Object r8 = r0.L$0
                    kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L_0x005d
                L_0x003d:
                    kotlin.ResultKt.throwOnFailure(r9)
                    kotlinx.coroutines.flow.FlowCollector r9 = r5
                    r2 = r0
                    kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                    com.adapty.internal.data.models.ProfileDto r8 = (com.adapty.internal.data.models.ProfileDto) r8
                    com.adapty.internal.domain.AuthInteractor r2 = r2
                    com.adapty.internal.data.cache.CacheRepository r2 = r2.cacheRepository
                    com.adapty.internal.data.models.InstallationMeta r5 = r3
                    r0.L$0 = r9
                    r0.label = r4
                    java.lang.Object r8 = r2.updateDataOnCreateProfile(r8, r5, r0)
                    if (r8 != r1) goto L_0x005a
                    return r1
                L_0x005a:
                    r6 = r9
                    r9 = r8
                    r8 = r6
                L_0x005d:
                    java.lang.Boolean r9 = (java.lang.Boolean) r9
                    boolean r9 = r9.booleanValue()
                    if (r9 == 0) goto L_0x0068
                    com.adapty.internal.domain.models.ProfileRequestResult$ProfileIdChanged r9 = com.adapty.internal.domain.models.ProfileRequestResult.ProfileIdChanged.INSTANCE
                    goto L_0x006a
                L_0x0068:
                    com.adapty.internal.domain.models.ProfileRequestResult$ProfileIdSame r9 = com.adapty.internal.domain.models.ProfileRequestResult.ProfileIdSame.INSTANCE
                L_0x006a:
                    com.adapty.internal.domain.models.ProfileRequestResult r9 = (com.adapty.internal.domain.models.ProfileRequestResult) r9
                    r2 = 0
                    r0.L$0 = r2
                    r0.label = r3
                    java.lang.Object r8 = r8.emit(r9, r0)
                    if (r8 != r1) goto L_0x0078
                    return r1
                L_0x0078:
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.domain.AuthInteractor$createProfileIfNeeded$3$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
