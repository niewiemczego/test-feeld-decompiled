package com.adapty.internal.data.cloud;

import com.adapty.internal.data.models.PurchaseRecordModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/adapty/internal/data/models/PurchaseRecordModel;", "subsHistoryList"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.data.cloud.StoreManager$getPurchaseHistoryDataToRestore$1", f = "StoreManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StoreManager.kt */
final class StoreManager$getPurchaseHistoryDataToRestore$1 extends SuspendLambda implements Function2<List<? extends PurchaseRecordModel>, Continuation<? super Flow<? extends List<? extends PurchaseRecordModel>>>, Object> {
    final /* synthetic */ long $maxAttemptCount;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StoreManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StoreManager$getPurchaseHistoryDataToRestore$1(StoreManager storeManager, long j, Continuation<? super StoreManager$getPurchaseHistoryDataToRestore$1> continuation) {
        super(2, continuation);
        this.this$0 = storeManager;
        this.$maxAttemptCount = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StoreManager$getPurchaseHistoryDataToRestore$1 storeManager$getPurchaseHistoryDataToRestore$1 = new StoreManager$getPurchaseHistoryDataToRestore$1(this.this$0, this.$maxAttemptCount, continuation);
        storeManager$getPurchaseHistoryDataToRestore$1.L$0 = obj;
        return storeManager$getPurchaseHistoryDataToRestore$1;
    }

    public final Object invoke(List<PurchaseRecordModel> list, Continuation<? super Flow<? extends List<PurchaseRecordModel>>> continuation) {
        return ((StoreManager$getPurchaseHistoryDataToRestore$1) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return new StoreManager$getPurchaseHistoryDataToRestore$1$invokeSuspend$$inlined$map$1(this.this$0.getPurchaseHistoryDataToRestoreForType("inapp", this.$maxAttemptCount), this.this$0, (List) this.L$0);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
