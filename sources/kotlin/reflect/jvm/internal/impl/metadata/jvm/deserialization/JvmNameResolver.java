package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;

/* compiled from: JvmNameResolver.kt */
public final class JvmNameResolver extends JvmNameResolverBase {
    private final JvmProtoBuf.StringTableTypes types;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JvmNameResolver(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes r4, java.lang.String[] r5) {
        /*
            r3 = this;
            java.lang.String r0 = "types"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "strings"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.List r0 = r4.getLocalNameList()
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x001a
            java.util.Set r0 = kotlin.collections.SetsKt.emptySet()
            goto L_0x0025
        L_0x001a:
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Set r0 = kotlin.collections.CollectionsKt.toSet(r0)
        L_0x0025:
            java.util.List r1 = r4.getRecordList()
            java.lang.String r2 = "types.recordList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.util.List r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolverKt.toExpandedRecordsList(r1)
            r3.<init>(r5, r0, r1)
            r3.types = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver.<init>(kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes, java.lang.String[]):void");
    }
}
