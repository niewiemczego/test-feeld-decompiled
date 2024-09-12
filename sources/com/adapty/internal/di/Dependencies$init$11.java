package com.adapty.internal.di;

import com.adapty.internal.data.cache.CacheRepository;
import com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher;
import com.adapty.internal.data.cloud.HttpClient;
import com.adapty.internal.data.cloud.RequestFactory;
import com.adapty.internal.utils.LifecycleManager;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.sync.Semaphore;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/adapty/internal/data/cloud/AnalyticsEventQueueDispatcher;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Dependencies.kt */
final class Dependencies$init$11 extends Lambda implements Function0<AnalyticsEventQueueDispatcher> {
    public static final Dependencies$init$11 INSTANCE = new Dependencies$init$11();

    Dependencies$init$11() {
        super(0);
    }

    public final AnalyticsEventQueueDispatcher invoke() {
        Object obj = Dependencies.INSTANCE.getMap$adapty_release().get(CacheRepository.class);
        Intrinsics.checkNotNull(obj);
        Object obj2 = ((Map) obj).get((Object) null);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj3 = Dependencies.INSTANCE.getMap$adapty_release().get(HttpClient.class);
        Intrinsics.checkNotNull(obj3);
        Object obj4 = ((Map) obj3).get("analytics");
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj5 = Dependencies.INSTANCE.getMap$adapty_release().get(RequestFactory.class);
        Intrinsics.checkNotNull(obj5);
        Object obj6 = ((Map) obj5).get((Object) null);
        Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj7 = Dependencies.INSTANCE.getMap$adapty_release().get(LifecycleManager.class);
        Intrinsics.checkNotNull(obj7);
        Object obj8 = ((Map) obj7).get((Object) null);
        Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj9 = Dependencies.INSTANCE.getMap$adapty_release().get(Semaphore.class);
        Intrinsics.checkNotNull(obj9);
        Object obj10 = ((Map) obj9).get(ImagesContract.LOCAL);
        Intrinsics.checkNotNull(obj10, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj11 = Dependencies.INSTANCE.getMap$adapty_release().get(Semaphore.class);
        Intrinsics.checkNotNull(obj11);
        Object obj12 = ((Map) obj11).get("remote");
        Intrinsics.checkNotNull(obj12, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        return new AnalyticsEventQueueDispatcher((CacheRepository) ((DIObject) obj2).provide(), (HttpClient) ((DIObject) obj4).provide(), (RequestFactory) ((DIObject) obj6).provide(), (LifecycleManager) ((DIObject) obj8).provide(), (Semaphore) ((DIObject) obj10).provide(), (Semaphore) ((DIObject) obj12).provide());
    }
}
