package com.adapty.internal.utils;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: MetaInfoRetriever.kt */
final class MetaInfoRetriever$adaptyUiAndBuilderVersion$2 extends Lambda implements Function0<Pair<? extends String, ? extends String>> {
    final /* synthetic */ MetaInfoRetriever this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MetaInfoRetriever$adaptyUiAndBuilderVersion$2(MetaInfoRetriever metaInfoRetriever) {
        super(0);
        this.this$0 = metaInfoRetriever;
    }

    public final Pair<String, String> invoke() {
        return this.this$0.adaptyUiMetaRetriever.getAdaptyUiAndBuilderVersion();
    }
}
