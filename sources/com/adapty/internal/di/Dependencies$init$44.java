package com.adapty.internal.di;

import com.adapty.internal.data.cache.CacheRepository;
import com.adapty.internal.data.cloud.CloudRepository;
import com.adapty.internal.data.cloud.StoreManager;
import com.adapty.internal.domain.AuthInteractor;
import com.adapty.internal.domain.ProductsInteractor;
import com.adapty.internal.domain.PurchasesInteractor;
import com.adapty.internal.utils.LifecycleManager;
import com.adapty.internal.utils.PaywallMapper;
import com.adapty.internal.utils.PaywallPicker;
import com.adapty.internal.utils.ProductMapper;
import com.adapty.internal.utils.ProductPicker;
import com.adapty.internal.utils.ViewConfigurationMapper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/adapty/internal/domain/ProductsInteractor;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Dependencies.kt */
final class Dependencies$init$44 extends Lambda implements Function0<ProductsInteractor> {
    public static final Dependencies$init$44 INSTANCE = new Dependencies$init$44();

    Dependencies$init$44() {
        super(0);
    }

    public final ProductsInteractor invoke() {
        Object obj = Dependencies.INSTANCE.getMap$adapty_release().get(AuthInteractor.class);
        Intrinsics.checkNotNull(obj);
        Object obj2 = ((Map) obj).get((Object) null);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj3 = Dependencies.INSTANCE.getMap$adapty_release().get(PurchasesInteractor.class);
        Intrinsics.checkNotNull(obj3);
        Object obj4 = ((Map) obj3).get((Object) null);
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj5 = Dependencies.INSTANCE.getMap$adapty_release().get(CloudRepository.class);
        Intrinsics.checkNotNull(obj5);
        Object obj6 = ((Map) obj5).get((Object) null);
        Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj7 = Dependencies.INSTANCE.getMap$adapty_release().get(CacheRepository.class);
        Intrinsics.checkNotNull(obj7);
        Object obj8 = ((Map) obj7).get((Object) null);
        Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj9 = Dependencies.INSTANCE.getMap$adapty_release().get(LifecycleManager.class);
        Intrinsics.checkNotNull(obj9);
        Object obj10 = ((Map) obj9).get((Object) null);
        Intrinsics.checkNotNull(obj10, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj11 = Dependencies.INSTANCE.getMap$adapty_release().get(StoreManager.class);
        Intrinsics.checkNotNull(obj11);
        Object obj12 = ((Map) obj11).get((Object) null);
        Intrinsics.checkNotNull(obj12, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj13 = Dependencies.INSTANCE.getMap$adapty_release().get(PaywallMapper.class);
        Intrinsics.checkNotNull(obj13);
        Object obj14 = ((Map) obj13).get((Object) null);
        Intrinsics.checkNotNull(obj14, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj15 = Dependencies.INSTANCE.getMap$adapty_release().get(ViewConfigurationMapper.class);
        Intrinsics.checkNotNull(obj15);
        Object obj16 = ((Map) obj15).get((Object) null);
        Intrinsics.checkNotNull(obj16, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj17 = Dependencies.INSTANCE.getMap$adapty_release().get(ProductMapper.class);
        Intrinsics.checkNotNull(obj17);
        Object obj18 = ((Map) obj17).get((Object) null);
        Intrinsics.checkNotNull(obj18, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj19 = Dependencies.INSTANCE.getMap$adapty_release().get(PaywallPicker.class);
        Intrinsics.checkNotNull(obj19);
        Object obj20 = ((Map) obj19).get((Object) null);
        Intrinsics.checkNotNull(obj20, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj21 = Dependencies.INSTANCE.getMap$adapty_release().get(ProductPicker.class);
        Intrinsics.checkNotNull(obj21);
        Object obj22 = ((Map) obj21).get((Object) null);
        Intrinsics.checkNotNull(obj22, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        return new ProductsInteractor((AuthInteractor) ((DIObject) obj2).provide(), (PurchasesInteractor) ((DIObject) obj4).provide(), (CloudRepository) ((DIObject) obj6).provide(), (CacheRepository) ((DIObject) obj8).provide(), (LifecycleManager) ((DIObject) obj10).provide(), (StoreManager) ((DIObject) obj12).provide(), (PaywallMapper) ((DIObject) obj14).provide(), (ViewConfigurationMapper) ((DIObject) obj16).provide(), (ProductMapper) ((DIObject) obj18).provide(), (PaywallPicker) ((DIObject) obj20).provide(), (ProductPicker) ((DIObject) obj22).provide());
    }
}
