package com.adapty.internal.domain;

import com.adapty.errors.AdaptyError;
import com.adapty.errors.AdaptyErrorCode;
import com.adapty.internal.data.cache.CacheRepository;
import com.adapty.internal.data.models.FallbackPaywalls;
import com.adapty.internal.data.models.PaywallDto;
import com.adapty.internal.data.models.ProductDto;
import com.adapty.internal.utils.ProductMapper;
import com.adapty.internal.utils.ProductPicker;
import com.adapty.internal.utils.UtilsKt;
import com.adapty.models.AdaptyPaywall;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/adapty/models/AdaptyPaywall;", "error", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.domain.ProductsInteractor$getPaywallFromCloud$3", f = "ProductsInteractor.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProductsInteractor.kt */
final class ProductsInteractor$getPaywallFromCloud$3 extends SuspendLambda implements Function3<FlowCollector<? super AdaptyPaywall>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    final /* synthetic */ String $locale;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ ProductsInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductsInteractor$getPaywallFromCloud$3(ProductsInteractor productsInteractor, String str, String str2, Continuation<? super ProductsInteractor$getPaywallFromCloud$3> continuation) {
        super(3, continuation);
        this.this$0 = productsInteractor;
        this.$id = str;
        this.$locale = str2;
    }

    public final Object invoke(FlowCollector<? super AdaptyPaywall> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        ProductsInteractor$getPaywallFromCloud$3 productsInteractor$getPaywallFromCloud$3 = new ProductsInteractor$getPaywallFromCloud$3(this.this$0, this.$id, this.$locale, continuation);
        productsInteractor$getPaywallFromCloud$3.L$0 = flowCollector;
        productsInteractor$getPaywallFromCloud$3.L$1 = th;
        return productsInteractor$getPaywallFromCloud$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        PaywallDto paywallDto;
        ArrayList<PaywallDto> paywalls;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Throwable th = (Throwable) this.L$1;
            if (th instanceof AdaptyError) {
                AdaptyError adaptyError = (AdaptyError) th;
                if (adaptyError.getAdaptyErrorCode() == AdaptyErrorCode.SERVER_ERROR || (adaptyError.getOriginalError() instanceof IOException)) {
                    PaywallDto paywall$default = CacheRepository.getPaywall$default(this.this$0.cacheRepository, this.$id, (Long) null, 2, (Object) null);
                    FallbackPaywalls fallbackPaywalls = this.this$0.cacheRepository.getFallbackPaywalls();
                    if (fallbackPaywalls == null || (paywalls = fallbackPaywalls.getPaywalls()) == null) {
                        paywallDto = null;
                    } else {
                        String str = this.$id;
                        Iterator it = paywalls.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it.next();
                            if (Intrinsics.areEqual((Object) ((PaywallDto) obj2).getDeveloperId(), (Object) str)) {
                                break;
                            }
                        }
                        paywallDto = (PaywallDto) obj2;
                    }
                    PaywallDto pick = this.this$0.paywallPicker.pick(paywall$default, paywallDto, SetsKt.setOf(this.$locale, UtilsKt.DEFAULT_PAYWALL_LOCALE));
                    if (pick != null) {
                        ProductMapper access$getProductMapper$p = this.this$0.productMapper;
                        List products = paywall$default != null ? paywall$default.getProducts() : null;
                        if (products == null) {
                            products = CollectionsKt.emptyList();
                        }
                        List map = access$getProductMapper$p.map(products);
                        ProductMapper access$getProductMapper$p2 = this.this$0.productMapper;
                        List products2 = paywallDto != null ? paywallDto.getProducts() : null;
                        if (products2 == null) {
                            products2 = CollectionsKt.emptyList();
                        }
                        List map2 = access$getProductMapper$p2.map(products2);
                        ProductPicker access$getProductPicker$p = this.this$0.productPicker;
                        Collection linkedHashSet = new LinkedHashSet();
                        for (ProductDto vendorProductId : pick.getProducts()) {
                            String vendorProductId2 = vendorProductId.getVendorProductId();
                            if (vendorProductId2 != null) {
                                linkedHashSet.add(vendorProductId2);
                            }
                        }
                        List pick2 = access$getProductPicker$p.pick(map, map2, (Set) linkedHashSet);
                        this.L$0 = null;
                        this.label = 1;
                        if (flowCollector.emit(this.this$0.paywallMapper.map(pick, pick2), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        throw th;
                    }
                }
            }
            throw th;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
