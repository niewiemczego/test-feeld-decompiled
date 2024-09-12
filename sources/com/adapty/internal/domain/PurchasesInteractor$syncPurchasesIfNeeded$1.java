package com.adapty.internal.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.PurchasesInteractor", f = "PurchasesInteractor.kt", i = {0}, l = {151}, m = "syncPurchasesIfNeeded", n = {"this"}, s = {"L$0"})
/* compiled from: PurchasesInteractor.kt */
final class PurchasesInteractor$syncPurchasesIfNeeded$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PurchasesInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PurchasesInteractor$syncPurchasesIfNeeded$1(PurchasesInteractor purchasesInteractor, Continuation<? super PurchasesInteractor$syncPurchasesIfNeeded$1> continuation) {
        super(continuation);
        this.this$0 = purchasesInteractor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.syncPurchasesIfNeeded(this);
    }
}
