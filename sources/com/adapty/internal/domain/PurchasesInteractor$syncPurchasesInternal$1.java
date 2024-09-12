package com.adapty.internal.domain;

import com.adapty.internal.data.models.PurchaseRecordModel;
import com.adapty.internal.data.models.SyncedPurchase;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H@"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lcom/adapty/internal/data/models/PurchaseRecordModel;", "", "Lcom/adapty/internal/data/models/SyncedPurchase;", "historyData", "syncedPurchases"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.PurchasesInteractor$syncPurchasesInternal$1", f = "PurchasesInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PurchasesInteractor.kt */
final class PurchasesInteractor$syncPurchasesInternal$1 extends SuspendLambda implements Function3<List<? extends PurchaseRecordModel>, Set<? extends SyncedPurchase>, Continuation<? super Pair<? extends List<? extends PurchaseRecordModel>, ? extends Set<? extends SyncedPurchase>>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    PurchasesInteractor$syncPurchasesInternal$1(Continuation<? super PurchasesInteractor$syncPurchasesInternal$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(List<PurchaseRecordModel> list, Set<SyncedPurchase> set, Continuation<? super Pair<? extends List<PurchaseRecordModel>, ? extends Set<SyncedPurchase>>> continuation) {
        PurchasesInteractor$syncPurchasesInternal$1 purchasesInteractor$syncPurchasesInternal$1 = new PurchasesInteractor$syncPurchasesInternal$1(continuation);
        purchasesInteractor$syncPurchasesInternal$1.L$0 = list;
        purchasesInteractor$syncPurchasesInternal$1.L$1 = set;
        return purchasesInteractor$syncPurchasesInternal$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return TuplesKt.to((List) this.L$0, (Set) this.L$1);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
