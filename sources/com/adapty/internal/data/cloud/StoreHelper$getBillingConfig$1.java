package com.adapty.internal.data.cloud;

import com.android.billingclient.api.BillingConfig;
import com.android.billingclient.api.GetBillingConfigParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/android/billingclient/api/BillingConfig;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.data.cloud.StoreHelper$getBillingConfig$1", f = "StoreManager.kt", i = {0}, l = {537, 539}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* compiled from: StoreManager.kt */
final class StoreHelper$getBillingConfig$1 extends SuspendLambda implements Function2<FlowCollector<? super BillingConfig>, Continuation<? super Unit>, Object> {
    final /* synthetic */ GetBillingConfigParams $params;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StoreHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StoreHelper$getBillingConfig$1(StoreHelper storeHelper, GetBillingConfigParams getBillingConfigParams, Continuation<? super StoreHelper$getBillingConfig$1> continuation) {
        super(2, continuation);
        this.this$0 = storeHelper;
        this.$params = getBillingConfigParams;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StoreHelper$getBillingConfig$1 storeHelper$getBillingConfig$1 = new StoreHelper$getBillingConfig$1(this.this$0, this.$params, continuation);
        storeHelper$getBillingConfig$1.L$0 = obj;
        return storeHelper$getBillingConfig$1;
    }

    public final Object invoke(FlowCollector<? super BillingConfig> flowCollector, Continuation<? super Unit> continuation) {
        return ((StoreHelper$getBillingConfig$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005f
        L_0x0012:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001a:
            java.lang.Object r1 = r6.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x003c
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            r1 = r7
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            com.adapty.internal.data.cloud.StoreHelper r7 = r6.this$0
            com.android.billingclient.api.GetBillingConfigParams r4 = r6.$params
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r7.getBillingConfigSync(r4, r5)
            if (r7 != r0) goto L_0x003c
            return r0
        L_0x003c:
            kotlin.Pair r7 = (kotlin.Pair) r7
            java.lang.Object r3 = r7.component1()
            com.android.billingclient.api.BillingResult r3 = (com.android.billingclient.api.BillingResult) r3
            java.lang.Object r7 = r7.component2()
            com.android.billingclient.api.BillingConfig r7 = (com.android.billingclient.api.BillingConfig) r7
            int r4 = r3.getResponseCode()
            if (r4 != 0) goto L_0x0062
            r3 = r6
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4 = 0
            r6.L$0 = r4
            r6.label = r2
            java.lang.Object r7 = r1.emit(r7, r3)
            if (r7 != r0) goto L_0x005f
            return r0
        L_0x005f:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x0062:
            com.adapty.internal.data.cloud.StoreHelper r7 = r6.this$0
            java.lang.String r0 = "on get billing config"
            com.adapty.errors.AdaptyError r7 = r7.createException(r3, r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.cloud.StoreHelper$getBillingConfig$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
