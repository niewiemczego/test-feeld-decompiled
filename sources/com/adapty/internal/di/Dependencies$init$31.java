package com.adapty.internal.di;

import com.adapty.internal.utils.PaywallPicker;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/adapty/internal/utils/PaywallPicker;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Dependencies.kt */
final class Dependencies$init$31 extends Lambda implements Function0<PaywallPicker> {
    public static final Dependencies$init$31 INSTANCE = new Dependencies$init$31();

    Dependencies$init$31() {
        super(0);
    }

    public final PaywallPicker invoke() {
        return new PaywallPicker();
    }
}