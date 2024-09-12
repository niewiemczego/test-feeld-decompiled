package com.adapty.internal.data.cloud;

import com.android.billingclient.api.BillingClient;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.data.cloud.StoreManager", f = "StoreManager.kt", i = {0, 0, 1, 1}, l = {348, 594}, m = "startConnectionSync", n = {"this", "$this$startConnectionSync", "this", "$this$startConnectionSync"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* compiled from: StoreManager.kt */
final class StoreManager$startConnectionSync$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StoreManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StoreManager$startConnectionSync$1(StoreManager storeManager, Continuation<? super StoreManager$startConnectionSync$1> continuation) {
        super(continuation);
        this.this$0 = storeManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.startConnectionSync((BillingClient) null, this);
    }
}
