package com.adapty.internal.utils;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/lang/Class;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CrossplatformMetaRetriever.kt */
final class CrossplatformMetaRetriever$metaClass$2 extends Lambda implements Function0<Class<?>> {
    public static final CrossplatformMetaRetriever$metaClass$2 INSTANCE = new CrossplatformMetaRetriever$metaClass$2();

    CrossplatformMetaRetriever$metaClass$2() {
        super(0);
    }

    public final Class<?> invoke() {
        return UtilsKt.getClassForNameOrNull("com.adapty.internal.crossplatform.MetaInfo");
    }
}
