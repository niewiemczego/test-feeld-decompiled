package com.adapty.internal.utils;

import io.sentry.protocol.Mechanism;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J5\u0010\u0011\u001a\u0004\u0018\u0001H\u0012\"\u0004\b\u0000\u0010\u00122\f\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010\u0016R!\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR!\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/adapty/internal/utils/CrossplatformMetaRetriever;", "", "()V", "crossplatformClass", "Ljava/lang/Class;", "getCrossplatformClass", "()Ljava/lang/Class;", "crossplatformClass$delegate", "Lkotlin/Lazy;", "crossplatformNameAndVersion", "Lkotlin/Pair;", "", "getCrossplatformNameAndVersion", "()Lkotlin/Pair;", "metaClass", "getMetaClass", "metaClass$delegate", "getDeclaredFieldOrNull", "T", "sourceClass", "name", "obj", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CrossplatformMetaRetriever.kt */
public final class CrossplatformMetaRetriever {
    private final Lazy crossplatformClass$delegate = LazyKt.lazy(CrossplatformMetaRetriever$crossplatformClass$2.INSTANCE);
    private final Lazy metaClass$delegate = LazyKt.lazy(CrossplatformMetaRetriever$metaClass$2.INSTANCE);

    private final Class<?> getCrossplatformClass() {
        return (Class) this.crossplatformClass$delegate.getValue();
    }

    private final Class<?> getMetaClass() {
        return (Class) this.metaClass$delegate.getValue();
    }

    public final /* synthetic */ Pair getCrossplatformNameAndVersion() {
        String str;
        String str2;
        Object declaredFieldOrNull = getDeclaredFieldOrNull(getCrossplatformClass(), Mechanism.JsonKeys.META, getCrossplatformClass());
        if (declaredFieldOrNull == null || (str = (String) getDeclaredFieldOrNull(getMetaClass(), "name", declaredFieldOrNull)) == null || (str2 = (String) getDeclaredFieldOrNull(getMetaClass(), "version", declaredFieldOrNull)) == null) {
            return null;
        }
        return TuplesKt.to(str, str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <T> T getDeclaredFieldOrNull(java.lang.Class<?> r2, java.lang.String r3, java.lang.Object r4) {
        /*
            r1 = this;
            r0 = 0
            if (r2 == 0) goto L_0x0012
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0017 }
            if (r2 == 0) goto L_0x0012
            r3 = 1
            r2.setAccessible(r3)     // Catch:{ Exception -> 0x0017 }
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Exception -> 0x0017 }
            goto L_0x0013
        L_0x0012:
            r2 = r0
        L_0x0013:
            if (r2 != 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r0 = r2
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.utils.CrossplatformMetaRetriever.getDeclaredFieldOrNull(java.lang.Class, java.lang.String, java.lang.Object):java.lang.Object");
    }
}
