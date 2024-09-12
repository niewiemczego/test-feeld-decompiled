package com.adapty.internal.di;

import com.adapty.internal.data.cache.CacheRepository;
import com.adapty.internal.data.cloud.AnalyticsEventRecorder;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.Gson;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.sync.Semaphore;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/adapty/internal/data/cloud/AnalyticsEventRecorder;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Dependencies.kt */
final class Dependencies$init$13 extends Lambda implements Function0<AnalyticsEventRecorder> {
    public static final Dependencies$init$13 INSTANCE = new Dependencies$init$13();

    Dependencies$init$13() {
        super(0);
    }

    public final AnalyticsEventRecorder invoke() {
        Object obj = Dependencies.INSTANCE.getMap$adapty_release().get(CacheRepository.class);
        Intrinsics.checkNotNull(obj);
        Object obj2 = ((Map) obj).get((Object) null);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj3 = Dependencies.INSTANCE.getMap$adapty_release().get(Gson.class);
        Intrinsics.checkNotNull(obj3);
        Object obj4 = ((Map) obj3).get("analytics");
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj5 = Dependencies.INSTANCE.getMap$adapty_release().get(Semaphore.class);
        Intrinsics.checkNotNull(obj5);
        Object obj6 = ((Map) obj5).get(ImagesContract.LOCAL);
        Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        return new AnalyticsEventRecorder((CacheRepository) ((DIObject) obj2).provide(), (Gson) ((DIObject) obj4).provide(), (Semaphore) ((DIObject) obj6).provide());
    }
}
