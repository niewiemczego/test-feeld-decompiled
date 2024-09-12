package com.adapty.internal.domain;

import com.adapty.internal.data.models.PaywallDto;
import com.adapty.internal.domain.models.BackendProduct;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00020\u0001H@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Pair;", "Lcom/adapty/internal/data/models/PaywallDto;", "", "Lcom/adapty/internal/domain/models/BackendProduct;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.ProductsInteractor$getPaywallFromCloud$baseFlow$2", f = "ProductsInteractor.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProductsInteractor.kt */
final class ProductsInteractor$getPaywallFromCloud$baseFlow$2 extends SuspendLambda implements Function1<Continuation<? super Flow<? extends Pair<? extends PaywallDto, ? extends List<? extends BackendProduct>>>>, Object> {
    final /* synthetic */ String $id;
    final /* synthetic */ String $locale;
    int label;
    final /* synthetic */ ProductsInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductsInteractor$getPaywallFromCloud$baseFlow$2(ProductsInteractor productsInteractor, String str, String str2, Continuation<? super ProductsInteractor$getPaywallFromCloud$baseFlow$2> continuation) {
        super(1, continuation);
        this.this$0 = productsInteractor;
        this.$id = str;
        this.$locale = str2;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ProductsInteractor$getPaywallFromCloud$baseFlow$2(this.this$0, this.$id, this.$locale, continuation);
    }

    public final Object invoke(Continuation<? super Flow<? extends Pair<PaywallDto, ? extends List<BackendProduct>>>> continuation) {
        return ((ProductsInteractor$getPaywallFromCloud$baseFlow$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.syncPurchasesIfNeeded(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return new ProductsInteractor$getPaywallFromCloud$baseFlow$2$invokeSuspend$$inlined$map$1((Flow) obj, this.this$0, this.$id, this.$locale);
    }
}
