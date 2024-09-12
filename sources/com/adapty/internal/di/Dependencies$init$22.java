package com.adapty.internal.di;

import android.content.Context;
import com.adapty.internal.data.cache.CacheRepository;
import com.adapty.internal.utils.AdaptyUiMetaRetriever;
import com.adapty.internal.utils.CrossplatformMetaRetriever;
import com.adapty.internal.utils.MetaInfoRetriever;
import com.adapty.internal.utils.UserAgentRetriever;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/adapty/internal/utils/MetaInfoRetriever;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Dependencies.kt */
final class Dependencies$init$22 extends Lambda implements Function0<MetaInfoRetriever> {
    final /* synthetic */ Context $appContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Dependencies$init$22(Context context) {
        super(0);
        this.$appContext = context;
    }

    public final MetaInfoRetriever invoke() {
        Context context = this.$appContext;
        Object obj = Dependencies.INSTANCE.getMap$adapty_release().get(CrossplatformMetaRetriever.class);
        Intrinsics.checkNotNull(obj);
        Object obj2 = ((Map) obj).get((Object) null);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj3 = Dependencies.INSTANCE.getMap$adapty_release().get(AdaptyUiMetaRetriever.class);
        Intrinsics.checkNotNull(obj3);
        Object obj4 = ((Map) obj3).get((Object) null);
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj5 = Dependencies.INSTANCE.getMap$adapty_release().get(UserAgentRetriever.class);
        Intrinsics.checkNotNull(obj5);
        Object obj6 = ((Map) obj5).get((Object) null);
        Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj7 = Dependencies.INSTANCE.getMap$adapty_release().get(CacheRepository.class);
        Intrinsics.checkNotNull(obj7);
        Object obj8 = ((Map) obj7).get((Object) null);
        Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        return new MetaInfoRetriever(context, (CrossplatformMetaRetriever) ((DIObject) obj2).provide(), (AdaptyUiMetaRetriever) ((DIObject) obj4).provide(), (UserAgentRetriever) ((DIObject) obj6).provide(), (CacheRepository) ((DIObject) obj8).provide());
    }
}
