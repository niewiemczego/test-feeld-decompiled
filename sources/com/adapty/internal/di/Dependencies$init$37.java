package com.adapty.internal.di;

import android.content.Context;
import com.adapty.internal.utils.CurrencyHelper;
import com.adapty.internal.utils.ProductMapper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/adapty/internal/utils/ProductMapper;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Dependencies.kt */
final class Dependencies$init$37 extends Lambda implements Function0<ProductMapper> {
    final /* synthetic */ Context $appContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Dependencies$init$37(Context context) {
        super(0);
        this.$appContext = context;
    }

    public final ProductMapper invoke() {
        Context context = this.$appContext;
        Object obj = Dependencies.INSTANCE.getMap$adapty_release().get(CurrencyHelper.class);
        Intrinsics.checkNotNull(obj);
        Object obj2 = ((Map) obj).get((Object) null);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        return new ProductMapper(context, (CurrencyHelper) ((DIObject) obj2).provide());
    }
}
