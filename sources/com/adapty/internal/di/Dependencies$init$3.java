package com.adapty.internal.di;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/text/DecimalFormat;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Dependencies.kt */
final class Dependencies$init$3 extends Lambda implements Function0<DecimalFormat> {
    public static final Dependencies$init$3 INSTANCE = new Dependencies$init$3();

    Dependencies$init$3() {
        super(0);
    }

    public final DecimalFormat invoke() {
        return new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.US));
    }
}
