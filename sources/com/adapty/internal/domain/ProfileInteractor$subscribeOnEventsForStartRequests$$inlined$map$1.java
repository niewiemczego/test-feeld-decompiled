package com.adapty.internal.domain;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class ProfileInteractor$subscribeOnEventsForStartRequests$$inlined$map$1 implements Flow<Pair<? extends Boolean, ? extends Boolean>> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;

    public ProfileInteractor$subscribeOnEventsForStartRequests$$inlined$map$1(Flow flow) {
        this.$this_unsafeTransform$inlined = flow;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Object collect = this.$this_unsafeTransform$inlined.collect(new Object() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r9, kotlin.coroutines.Continuation r10) {
                /*
                    r8 = this;
                    boolean r0 = r10 instanceof com.adapty.internal.domain.ProfileInteractor$subscribeOnEventsForStartRequests$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0014
                    r0 = r10
                    com.adapty.internal.domain.ProfileInteractor$subscribeOnEventsForStartRequests$$inlined$map$1$2$1 r0 = (com.adapty.internal.domain.ProfileInteractor$subscribeOnEventsForStartRequests$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r10 = r0.label
                    int r10 = r10 - r2
                    r0.label = r10
                    goto L_0x0019
                L_0x0014:
                    com.adapty.internal.domain.ProfileInteractor$subscribeOnEventsForStartRequests$$inlined$map$1$2$1 r0 = new com.adapty.internal.domain.ProfileInteractor$subscribeOnEventsForStartRequests$$inlined$map$1$2$1
                    r0.<init>(r8, r10)
                L_0x0019:
                    java.lang.Object r10 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0033
                    if (r2 != r3) goto L_0x002b
                    kotlin.ResultKt.throwOnFailure(r10)
                    goto L_0x0096
                L_0x002b:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r10)
                    throw r9
                L_0x0033:
                    kotlin.ResultKt.throwOnFailure(r10)
                    kotlinx.coroutines.flow.FlowCollector r10 = r3
                    r2 = r0
                    kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                    kotlin.Pair r9 = (kotlin.Pair) r9
                    java.lang.Object r2 = r9.component1()
                    com.adapty.internal.data.models.ProfileDto r2 = (com.adapty.internal.data.models.ProfileDto) r2
                    java.lang.Object r9 = r9.component2()
                    com.adapty.internal.data.models.ProfileDto r9 = (com.adapty.internal.data.models.ProfileDto) r9
                    r4 = 0
                    if (r2 == 0) goto L_0x0051
                    java.lang.String r5 = r2.getProfileId()
                    goto L_0x0052
                L_0x0051:
                    r5 = r4
                L_0x0052:
                    java.lang.String r6 = ""
                    if (r5 != 0) goto L_0x0057
                    r5 = r6
                L_0x0057:
                    if (r9 == 0) goto L_0x005e
                    java.lang.String r7 = r9.getProfileId()
                    goto L_0x005f
                L_0x005e:
                    r7 = r4
                L_0x005f:
                    if (r7 != 0) goto L_0x0062
                    r7 = r6
                L_0x0062:
                    boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r7)
                    r5 = r5 ^ r3
                    if (r2 == 0) goto L_0x006e
                    java.lang.String r2 = r2.getCustomerUserId()
                    goto L_0x006f
                L_0x006e:
                    r2 = r4
                L_0x006f:
                    if (r2 != 0) goto L_0x0072
                    r2 = r6
                L_0x0072:
                    if (r9 == 0) goto L_0x0078
                    java.lang.String r4 = r9.getCustomerUserId()
                L_0x0078:
                    if (r4 != 0) goto L_0x007b
                    goto L_0x007c
                L_0x007b:
                    r6 = r4
                L_0x007c:
                    boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r6)
                    r9 = r9 ^ r3
                    java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                    java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
                    kotlin.Pair r9 = kotlin.TuplesKt.to(r2, r9)
                    r0.label = r3
                    java.lang.Object r9 = r10.emit(r9, r0)
                    if (r9 != r1) goto L_0x0096
                    return r1
                L_0x0096:
                    kotlin.Unit r9 = kotlin.Unit.INSTANCE
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.domain.ProfileInteractor$subscribeOnEventsForStartRequests$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
