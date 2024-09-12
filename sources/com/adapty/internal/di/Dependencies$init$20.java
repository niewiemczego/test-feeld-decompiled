package com.adapty.internal.di;

import com.adapty.internal.data.cache.CacheRepository;
import com.adapty.internal.data.cache.ResponseCacheKeyProvider;
import com.adapty.internal.data.cloud.RequestFactory;
import com.adapty.internal.utils.MetaInfoRetriever;
import com.adapty.internal.utils.PayloadProvider;
import com.google.gson.Gson;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/adapty/internal/data/cloud/RequestFactory;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Dependencies.kt */
final class Dependencies$init$20 extends Lambda implements Function0<RequestFactory> {
    final /* synthetic */ String $apiKey;
    final /* synthetic */ boolean $observerMode;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Dependencies$init$20(String str, boolean z) {
        super(0);
        this.$apiKey = str;
        this.$observerMode = z;
    }

    public final RequestFactory invoke() {
        Object obj = Dependencies.INSTANCE.getMap$adapty_release().get(CacheRepository.class);
        Intrinsics.checkNotNull(obj);
        Object obj2 = ((Map) obj).get((Object) null);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj3 = Dependencies.INSTANCE.getMap$adapty_release().get(ResponseCacheKeyProvider.class);
        Intrinsics.checkNotNull(obj3);
        Object obj4 = ((Map) obj3).get((Object) null);
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj5 = Dependencies.INSTANCE.getMap$adapty_release().get(MetaInfoRetriever.class);
        Intrinsics.checkNotNull(obj5);
        Object obj6 = ((Map) obj5).get((Object) null);
        Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj7 = Dependencies.INSTANCE.getMap$adapty_release().get(PayloadProvider.class);
        Intrinsics.checkNotNull(obj7);
        Object obj8 = ((Map) obj7).get((Object) null);
        Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj9 = Dependencies.INSTANCE.getMap$adapty_release().get(Gson.class);
        Intrinsics.checkNotNull(obj9);
        Object obj10 = ((Map) obj9).get("base");
        Intrinsics.checkNotNull(obj10, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        return new RequestFactory((CacheRepository) ((DIObject) obj2).provide(), (ResponseCacheKeyProvider) ((DIObject) obj4).provide(), (MetaInfoRetriever) ((DIObject) obj6).provide(), (PayloadProvider) ((DIObject) obj8).provide(), (Gson) ((DIObject) obj10).provide(), this.$apiKey, this.$observerMode);
    }
}
