package com.adapty.internal.di;

import com.adapty.internal.utils.CrossplatformMetaRetriever;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/adapty/internal/utils/CrossplatformMetaRetriever;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Dependencies.kt */
final class Dependencies$init$23 extends Lambda implements Function0<CrossplatformMetaRetriever> {
    public static final Dependencies$init$23 INSTANCE = new Dependencies$init$23();

    Dependencies$init$23() {
        super(0);
    }

    public final CrossplatformMetaRetriever invoke() {
        return new CrossplatformMetaRetriever();
    }
}