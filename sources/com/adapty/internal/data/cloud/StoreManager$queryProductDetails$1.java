package com.adapty.internal.data.cloud;

import com.android.billingclient.api.ProductDetails;
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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/android/billingclient/api/ProductDetails;", "subsList"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.data.cloud.StoreManager$queryProductDetails$1", f = "StoreManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StoreManager.kt */
final class StoreManager$queryProductDetails$1 extends SuspendLambda implements Function2<List<? extends ProductDetails>, Continuation<? super Flow<? extends List<? extends ProductDetails>>>, Object> {
    final /* synthetic */ long $maxAttemptCount;
    final /* synthetic */ List<String> $productList;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StoreManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StoreManager$queryProductDetails$1(StoreManager storeManager, List<String> list, long j, Continuation<? super StoreManager$queryProductDetails$1> continuation) {
        super(2, continuation);
        this.this$0 = storeManager;
        this.$productList = list;
        this.$maxAttemptCount = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StoreManager$queryProductDetails$1 storeManager$queryProductDetails$1 = new StoreManager$queryProductDetails$1(this.this$0, this.$productList, this.$maxAttemptCount, continuation);
        storeManager$queryProductDetails$1.L$0 = obj;
        return storeManager$queryProductDetails$1;
    }

    public final Object invoke(List<ProductDetails> list, Continuation<? super Flow<? extends List<ProductDetails>>> continuation) {
        return ((StoreManager$queryProductDetails$1) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return new StoreManager$queryProductDetails$1$invokeSuspend$$inlined$map$1(this.this$0.queryProductDetailsForType(this.$productList, "inapp", this.$maxAttemptCount), this.this$0, (List) this.L$0);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
