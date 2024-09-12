package com.adapty.internal.data.cloud;

import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchaseHistoryRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00030\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Pair;", "", "Lcom/android/billingclient/api/PurchaseHistoryRecord;", "Lcom/android/billingclient/api/Purchase;", "historyRecords"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.data.cloud.StoreHelper$queryAllPurchasesForType$1", f = "StoreManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StoreManager.kt */
final class StoreHelper$queryAllPurchasesForType$1 extends SuspendLambda implements Function2<List<? extends PurchaseHistoryRecord>, Continuation<? super Flow<? extends Pair<? extends List<? extends PurchaseHistoryRecord>, ? extends List<? extends Purchase>>>>, Object> {
    final /* synthetic */ String $type;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StoreHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StoreHelper$queryAllPurchasesForType$1(StoreHelper storeHelper, String str, Continuation<? super StoreHelper$queryAllPurchasesForType$1> continuation) {
        super(2, continuation);
        this.this$0 = storeHelper;
        this.$type = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StoreHelper$queryAllPurchasesForType$1 storeHelper$queryAllPurchasesForType$1 = new StoreHelper$queryAllPurchasesForType$1(this.this$0, this.$type, continuation);
        storeHelper$queryAllPurchasesForType$1.L$0 = obj;
        return storeHelper$queryAllPurchasesForType$1;
    }

    public final Object invoke(List<? extends PurchaseHistoryRecord> list, Continuation<? super Flow<? extends Pair<? extends List<? extends PurchaseHistoryRecord>, ? extends List<? extends Purchase>>>> continuation) {
        return ((StoreHelper$queryAllPurchasesForType$1) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return new StoreHelper$queryAllPurchasesForType$1$invokeSuspend$$inlined$map$1(this.this$0.queryActivePurchasesForType(this.$type), (List) this.L$0);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
