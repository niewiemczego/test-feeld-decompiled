package com.adapty.internal.di;

import com.adapty.internal.data.cache.CacheRepository;
import com.adapty.internal.data.cloud.AnalyticsTracker;
import com.adapty.internal.domain.ProfileInteractor;
import com.adapty.internal.utils.LifecycleAwareRequestRunner;
import com.adapty.internal.utils.LifecycleManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/adapty/internal/utils/LifecycleAwareRequestRunner;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Dependencies.kt */
final class Dependencies$init$42 extends Lambda implements Function0<LifecycleAwareRequestRunner> {
    public static final Dependencies$init$42 INSTANCE = new Dependencies$init$42();

    Dependencies$init$42() {
        super(0);
    }

    public final LifecycleAwareRequestRunner invoke() {
        Object obj = Dependencies.INSTANCE.getMap$adapty_release().get(LifecycleManager.class);
        Intrinsics.checkNotNull(obj);
        Object obj2 = ((Map) obj).get((Object) null);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj3 = Dependencies.INSTANCE.getMap$adapty_release().get(ProfileInteractor.class);
        Intrinsics.checkNotNull(obj3);
        Object obj4 = ((Map) obj3).get((Object) null);
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj5 = Dependencies.INSTANCE.getMap$adapty_release().get(AnalyticsTracker.class);
        Intrinsics.checkNotNull(obj5);
        Object obj6 = ((Map) obj5).get("base");
        Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj7 = Dependencies.INSTANCE.getMap$adapty_release().get(CacheRepository.class);
        Intrinsics.checkNotNull(obj7);
        Object obj8 = ((Map) obj7).get((Object) null);
        Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        return new LifecycleAwareRequestRunner((LifecycleManager) ((DIObject) obj2).provide(), (ProfileInteractor) ((DIObject) obj4).provide(), (AnalyticsTracker) ((DIObject) obj6).provide(), (CacheRepository) ((DIObject) obj8).provide());
    }
}
