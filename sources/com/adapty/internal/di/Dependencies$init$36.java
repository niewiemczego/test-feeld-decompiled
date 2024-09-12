package com.adapty.internal.di;

import com.adapty.internal.utils.PaywallMapper;
import com.google.gson.Gson;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/adapty/internal/utils/PaywallMapper;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Dependencies.kt */
final class Dependencies$init$36 extends Lambda implements Function0<PaywallMapper> {
    public static final Dependencies$init$36 INSTANCE = new Dependencies$init$36();

    Dependencies$init$36() {
        super(0);
    }

    public final PaywallMapper invoke() {
        Object obj = Dependencies.INSTANCE.getMap$adapty_release().get(Gson.class);
        Intrinsics.checkNotNull(obj);
        Object obj2 = ((Map) obj).get("base");
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        return new PaywallMapper((Gson) ((DIObject) obj2).provide());
    }
}
