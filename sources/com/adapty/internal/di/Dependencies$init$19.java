package com.adapty.internal.di;

import com.adapty.internal.utils.HashingHelper;
import com.adapty.internal.utils.MetaInfoRetriever;
import com.adapty.internal.utils.PayloadProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/adapty/internal/utils/PayloadProvider;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Dependencies.kt */
final class Dependencies$init$19 extends Lambda implements Function0<PayloadProvider> {
    public static final Dependencies$init$19 INSTANCE = new Dependencies$init$19();

    Dependencies$init$19() {
        super(0);
    }

    public final PayloadProvider invoke() {
        Object obj = Dependencies.INSTANCE.getMap$adapty_release().get(HashingHelper.class);
        Intrinsics.checkNotNull(obj);
        Object obj2 = ((Map) obj).get((Object) null);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        Object obj3 = Dependencies.INSTANCE.getMap$adapty_release().get(MetaInfoRetriever.class);
        Intrinsics.checkNotNull(obj3);
        Object obj4 = ((Map) obj3).get((Object) null);
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        return new PayloadProvider((HashingHelper) ((DIObject) obj2).provide(), (MetaInfoRetriever) ((DIObject) obj4).provide());
    }
}
