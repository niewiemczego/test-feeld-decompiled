package com.adapty.internal.di;

import com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher;
import com.adapty.internal.data.cloud.AnalyticsManager;
import com.adapty.internal.data.cloud.AnalyticsTracker;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/adapty/internal/data/cloud/AnalyticsManager;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Dependencies.kt */
final class Dependencies$init$12 extends Lambda implements Function0<AnalyticsManager> {
    public static final Dependencies$init$12 INSTANCE = new Dependencies$init$12();

    Dependencies$init$12() {
        super(0);
    }

    public final AnalyticsManager invoke() {
        Object obj = Dependencies.INSTANCE.getMap$adapty_release().get(AnalyticsTracker.class);
        Intrinsics.checkNotNull(obj);
        Object obj2 = ((Map) obj).get("record_only");
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj3 = Dependencies.INSTANCE.getMap$adapty_release().get(AnalyticsEventQueueDispatcher.class);
        Intrinsics.checkNotNull(obj3);
        Object obj4 = ((Map) obj3).get((Object) null);
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        return new AnalyticsManager((AnalyticsTracker) ((DIObject) obj2).provide(), (AnalyticsEventQueueDispatcher) ((DIObject) obj4).provide());
    }
}
