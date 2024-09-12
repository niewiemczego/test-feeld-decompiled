package com.adapty.internal.di;

import com.adapty.internal.data.cloud.AnalyticsTracker;
import com.adapty.internal.data.cloud.BaseHttpClient;
import com.adapty.internal.data.cloud.HttpResponseManager;
import com.adapty.internal.data.cloud.NetworkConnectionCreator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/adapty/internal/data/cloud/BaseHttpClient;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Dependencies.kt */
final class Dependencies$init$8 extends Lambda implements Function0<BaseHttpClient> {
    public static final Dependencies$init$8 INSTANCE = new Dependencies$init$8();

    Dependencies$init$8() {
        super(0);
    }

    public final BaseHttpClient invoke() {
        Object obj = Dependencies.INSTANCE.getMap$adapty_release().get(NetworkConnectionCreator.class);
        Intrinsics.checkNotNull(obj);
        Object obj2 = ((Map) obj).get((Object) null);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj3 = Dependencies.INSTANCE.getMap$adapty_release().get(HttpResponseManager.class);
        Intrinsics.checkNotNull(obj3);
        Object obj4 = ((Map) obj3).get("analytics");
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj5 = Dependencies.INSTANCE.getMap$adapty_release().get(AnalyticsTracker.class);
        Intrinsics.checkNotNull(obj5);
        Object obj6 = ((Map) obj5).get("record_only");
        Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        return new BaseHttpClient((NetworkConnectionCreator) ((DIObject) obj2).provide(), (HttpResponseManager) ((DIObject) obj4).provide(), (AnalyticsTracker) ((DIObject) obj6).provide());
    }
}
