package com.adapty.internal.domain;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class ProfileInteractor$updateAttribution$$inlined$map$1 implements Flow<Unit> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ ProfileInteractor this$0;

    public ProfileInteractor$updateAttribution$$inlined$map$1(Flow flow, ProfileInteractor profileInteractor) {
        this.$this_unsafeTransform$inlined = flow;
        this.this$0 = profileInteractor;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Flow flow = this.$this_unsafeTransform$inlined;
        final ProfileInteractor profileInteractor = this.this$0;
        Object collect = flow.collect(new Object() {
            /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
            /* JADX WARNING: Removed duplicated region for block: B:24:0x007a A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof com.adapty.internal.domain.ProfileInteractor$updateAttribution$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0014
                    r0 = r9
                    com.adapty.internal.domain.ProfileInteractor$updateAttribution$$inlined$map$1$2$1 r0 = (com.adapty.internal.domain.ProfileInteractor$updateAttribution$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r9 = r0.label
                    int r9 = r9 - r2
                    r0.label = r9
                    goto L_0x0019
                L_0x0014:
                    com.adapty.internal.domain.ProfileInteractor$updateAttribution$$inlined$map$1$2$1 r0 = new com.adapty.internal.domain.ProfileInteractor$updateAttribution$$inlined$map$1$2$1
                    r0.<init>(r7, r9)
                L_0x0019:
                    java.lang.Object r9 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 0
                    r4 = 2
                    r5 = 1
                    if (r2 == 0) goto L_0x003e
                    if (r2 == r5) goto L_0x0036
                    if (r2 != r4) goto L_0x002e
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L_0x007b
                L_0x002e:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L_0x0036:
                    java.lang.Object r8 = r0.L$0
                    kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L_0x006e
                L_0x003e:
                    kotlin.ResultKt.throwOnFailure(r9)
                    kotlinx.coroutines.flow.FlowCollector r9 = r4
                    r2 = r0
                    kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                    kotlin.Pair r8 = (kotlin.Pair) r8
                    java.lang.Object r2 = r8.component1()
                    com.adapty.internal.data.models.ProfileDto r2 = (com.adapty.internal.data.models.ProfileDto) r2
                    java.lang.Object r8 = r8.component2()
                    com.adapty.internal.data.cloud.Request$CurrentDataWhenSent r8 = (com.adapty.internal.data.cloud.Request.CurrentDataWhenSent) r8
                    com.adapty.internal.domain.ProfileInteractor r6 = r2
                    com.adapty.internal.data.cache.CacheRepository r6 = r6.cacheRepository
                    if (r8 == 0) goto L_0x0061
                    java.lang.String r8 = r8.getProfileId()
                    goto L_0x0062
                L_0x0061:
                    r8 = r3
                L_0x0062:
                    r0.L$0 = r9
                    r0.label = r5
                    java.lang.Object r8 = r6.updateOnProfileReceived(r2, r8, r0)
                    if (r8 != r1) goto L_0x006d
                    return r1
                L_0x006d:
                    r8 = r9
                L_0x006e:
                    kotlin.Unit r9 = kotlin.Unit.INSTANCE
                    r0.L$0 = r3
                    r0.label = r4
                    java.lang.Object r8 = r8.emit(r9, r0)
                    if (r8 != r1) goto L_0x007b
                    return r1
                L_0x007b:
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.domain.ProfileInteractor$updateAttribution$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
