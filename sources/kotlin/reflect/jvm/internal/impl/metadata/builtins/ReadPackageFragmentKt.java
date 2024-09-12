package kotlin.reflect.jvm.internal.impl.metadata.builtins;

/* compiled from: readPackageFragment.kt */
public final class ReadPackageFragmentKt {
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.Pair<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment, kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion> readBuiltinsPackageFragment(java.io.InputStream r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.io.Closeable r4 = (java.io.Closeable) r4
            r0 = r4
            java.io.InputStream r0 = (java.io.InputStream) r0     // Catch:{ all -> 0x002c }
            kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion$Companion r1 = kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion.Companion     // Catch:{ all -> 0x002c }
            kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion r1 = r1.readFrom(r0)     // Catch:{ all -> 0x002c }
            boolean r2 = r1.isCompatible()     // Catch:{ all -> 0x002c }
            r3 = 0
            if (r2 == 0) goto L_0x0023
            kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r2 = kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite.newInstance()     // Catch:{ all -> 0x002c }
            kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsProtoBuf.registerAllExtensions(r2)     // Catch:{ all -> 0x002c }
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment r0 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment.parseFrom(r0, r2)     // Catch:{ all -> 0x002c }
            goto L_0x0024
        L_0x0023:
            r0 = r3
        L_0x0024:
            kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r1)     // Catch:{ all -> 0x002c }
            kotlin.io.CloseableKt.closeFinally(r4, r3)
            return r0
        L_0x002c:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x002e }
        L_0x002e:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.builtins.ReadPackageFragmentKt.readBuiltinsPackageFragment(java.io.InputStream):kotlin.Pair");
    }
}
