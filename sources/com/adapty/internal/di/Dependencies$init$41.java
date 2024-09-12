package com.adapty.internal.di;

import android.content.Context;
import com.adapty.internal.data.cloud.AnalyticsTracker;
import com.adapty.internal.data.cloud.StoreManager;
import com.adapty.internal.utils.ReplacementModeMapper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/adapty/internal/data/cloud/StoreManager;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Dependencies.kt */
final class Dependencies$init$41 extends Lambda implements Function0<StoreManager> {
    final /* synthetic */ Context $appContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Dependencies$init$41(Context context) {
        super(0);
        this.$appContext = context;
    }

    public final StoreManager invoke() {
        Context context = this.$appContext;
        Object obj = Dependencies.INSTANCE.getMap$adapty_release().get(ReplacementModeMapper.class);
        Intrinsics.checkNotNull(obj);
        Object obj2 = ((Map) obj).get((Object) null);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj3 = Dependencies.INSTANCE.getMap$adapty_release().get(AnalyticsTracker.class);
        Intrinsics.checkNotNull(obj3);
        Object obj4 = ((Map) obj3).get("base");
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        return new StoreManager(context, (ReplacementModeMapper) ((DIObject) obj2).provide(), (AnalyticsTracker) ((DIObject) obj4).provide());
    }
}
