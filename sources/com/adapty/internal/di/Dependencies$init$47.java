package com.adapty.internal.di;

import com.adapty.internal.data.cache.CacheRepository;
import com.adapty.internal.data.cloud.CloudRepository;
import com.adapty.internal.domain.AuthInteractor;
import com.adapty.internal.utils.AdIdRetriever;
import com.adapty.internal.utils.AppSetIdRetriever;
import com.adapty.internal.utils.HashingHelper;
import com.adapty.internal.utils.InstallationMetaCreator;
import com.adapty.internal.utils.LifecycleManager;
import com.adapty.internal.utils.StoreCountryRetriever;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/adapty/internal/domain/AuthInteractor;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Dependencies.kt */
final class Dependencies$init$47 extends Lambda implements Function0<AuthInteractor> {
    public static final Dependencies$init$47 INSTANCE = new Dependencies$init$47();

    Dependencies$init$47() {
        super(0);
    }

    public final AuthInteractor invoke() {
        Object obj = Dependencies.INSTANCE.getMap$adapty_release().get(CloudRepository.class);
        Intrinsics.checkNotNull(obj);
        Object obj2 = ((Map) obj).get((Object) null);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj3 = Dependencies.INSTANCE.getMap$adapty_release().get(CacheRepository.class);
        Intrinsics.checkNotNull(obj3);
        Object obj4 = ((Map) obj3).get((Object) null);
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj5 = Dependencies.INSTANCE.getMap$adapty_release().get(LifecycleManager.class);
        Intrinsics.checkNotNull(obj5);
        Object obj6 = ((Map) obj5).get((Object) null);
        Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj7 = Dependencies.INSTANCE.getMap$adapty_release().get(InstallationMetaCreator.class);
        Intrinsics.checkNotNull(obj7);
        Object obj8 = ((Map) obj7).get((Object) null);
        Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj9 = Dependencies.INSTANCE.getMap$adapty_release().get(AdIdRetriever.class);
        Intrinsics.checkNotNull(obj9);
        Object obj10 = ((Map) obj9).get((Object) null);
        Intrinsics.checkNotNull(obj10, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj11 = Dependencies.INSTANCE.getMap$adapty_release().get(AppSetIdRetriever.class);
        Intrinsics.checkNotNull(obj11);
        Object obj12 = ((Map) obj11).get((Object) null);
        Intrinsics.checkNotNull(obj12, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj13 = Dependencies.INSTANCE.getMap$adapty_release().get(StoreCountryRetriever.class);
        Intrinsics.checkNotNull(obj13);
        Object obj14 = ((Map) obj13).get((Object) null);
        Intrinsics.checkNotNull(obj14, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj15 = Dependencies.INSTANCE.getMap$adapty_release().get(HashingHelper.class);
        Intrinsics.checkNotNull(obj15);
        Object obj16 = ((Map) obj15).get((Object) null);
        Intrinsics.checkNotNull(obj16, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        return new AuthInteractor((CloudRepository) ((DIObject) obj2).provide(), (CacheRepository) ((DIObject) obj4).provide(), (LifecycleManager) ((DIObject) obj6).provide(), (InstallationMetaCreator) ((DIObject) obj8).provide(), (AdIdRetriever) ((DIObject) obj10).provide(), (AppSetIdRetriever) ((DIObject) obj12).provide(), (StoreCountryRetriever) ((DIObject) obj14).provide(), (HashingHelper) ((DIObject) obj16).provide());
    }
}
