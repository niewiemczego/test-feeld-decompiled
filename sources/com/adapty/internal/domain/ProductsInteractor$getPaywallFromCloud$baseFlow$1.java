package com.adapty.internal.domain;

import com.adapty.internal.data.models.FallbackPaywalls;
import com.adapty.internal.data.models.PaywallDto;
import com.adapty.internal.domain.models.BackendProduct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Pair;", "Lcom/adapty/internal/data/models/PaywallDto;", "", "Lcom/adapty/internal/domain/models/BackendProduct;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProductsInteractor.kt */
final class ProductsInteractor$getPaywallFromCloud$baseFlow$1 extends Lambda implements Function0<Flow<? extends Pair<? extends PaywallDto, ? extends List<? extends BackendProduct>>>> {
    final /* synthetic */ String $id;
    final /* synthetic */ ProductsInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductsInteractor$getPaywallFromCloud$baseFlow$1(ProductsInteractor productsInteractor, String str) {
        super(0);
        this.this$0 = productsInteractor;
        this.$id = str;
    }

    public final Flow<Pair<PaywallDto, List<BackendProduct>>> invoke() {
        ArrayList<PaywallDto> paywalls;
        Object obj;
        FallbackPaywalls fallbackPaywalls = this.this$0.cacheRepository.getFallbackPaywalls();
        if (fallbackPaywalls == null || (paywalls = fallbackPaywalls.getPaywalls()) == null) {
            return null;
        }
        String str = this.$id;
        Iterator it = paywalls.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((PaywallDto) obj).getDeveloperId(), (Object) str)) {
                break;
            }
        }
        PaywallDto paywallDto = (PaywallDto) obj;
        if (paywallDto != null) {
            return FlowKt.flowOf(TuplesKt.to(paywallDto, this.this$0.productMapper.map((List) paywallDto.getProducts())));
        }
        return null;
    }
}
