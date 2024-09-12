package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;

/* compiled from: typeEnhancementUtils.kt */
public final class TypeEnhancementUtilsKt {
    private static final <T> T select(Set<? extends T> set, T t, T t2, T t3, boolean z) {
        Set<? extends T> set2;
        if (z) {
            T t4 = set.contains(t) ? t : set.contains(t2) ? t2 : null;
            if (!Intrinsics.areEqual((Object) t4, (Object) t) || !Intrinsics.areEqual((Object) t3, (Object) t2)) {
                return t3 == null ? t4 : t3;
            }
            return null;
        }
        if (!(t3 == null || (set2 = CollectionsKt.toSet(SetsKt.plus(set, t3))) == null)) {
            set = set2;
        }
        return CollectionsKt.singleOrNull(set);
    }

    private static final NullabilityQualifier select(Set<? extends NullabilityQualifier> set, NullabilityQualifier nullabilityQualifier, boolean z) {
        if (nullabilityQualifier == NullabilityQualifier.FORCE_FLEXIBILITY) {
            return NullabilityQualifier.FORCE_FLEXIBILITY;
        }
        return (NullabilityQualifier) select(set, NullabilityQualifier.NOT_NULL, NullabilityQualifier.NULLABLE, nullabilityQualifier, z);
    }

    private static final NullabilityQualifier getNullabilityForErrors(JavaTypeQualifiers javaTypeQualifiers) {
        if (javaTypeQualifiers.isNullabilityQualifierForWarning()) {
            return null;
        }
        return javaTypeQualifiers.getNullability();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e9, code lost:
        if (r6 != false) goto L_0x00eb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers computeQualifiersForOverride(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r6, java.util.Collection<kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> r7, boolean r8, boolean r9, boolean r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "superQualifiers"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r1 = r7.iterator()
        L_0x0017:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x002d
            java.lang.Object r2 = r1.next()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r2 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) r2
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r2 = getNullabilityForErrors(r2)
            if (r2 == 0) goto L_0x0017
            r0.add(r2)
            goto L_0x0017
        L_0x002d:
            java.util.List r0 = (java.util.List) r0
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Set r0 = kotlin.collections.CollectionsKt.toSet(r0)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r1 = getNullabilityForErrors(r6)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r0 = select(r0, r1, r8)
            if (r0 != 0) goto L_0x0071
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r2 = r7.iterator()
        L_0x004a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0060
            java.lang.Object r3 = r2.next()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r3 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) r3
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r3 = r3.getNullability()
            if (r3 == 0) goto L_0x004a
            r1.add(r3)
            goto L_0x004a
        L_0x0060:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Set r1 = kotlin.collections.CollectionsKt.toSet(r1)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r2 = r6.getNullability()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r1 = select(r1, r2, r8)
            goto L_0x0072
        L_0x0071:
            r1 = r0
        L_0x0072:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r3 = r7.iterator()
        L_0x007d:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0093
            java.lang.Object r4 = r3.next()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r4 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) r4
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r4 = r4.getMutability()
            if (r4 == 0) goto L_0x007d
            r2.add(r4)
            goto L_0x007d
        L_0x0093:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Set r2 = kotlin.collections.CollectionsKt.toSet(r2)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r3 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.MUTABLE
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r4 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.READ_ONLY
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r5 = r6.getMutability()
            java.lang.Object r8 = select(r2, r3, r4, r5, r8)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r8 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier) r8
            r2 = 0
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x00bd
            if (r10 != 0) goto L_0x00b9
            if (r9 == 0) goto L_0x00b7
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r9 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            if (r1 != r9) goto L_0x00b7
            goto L_0x00b9
        L_0x00b7:
            r9 = r4
            goto L_0x00ba
        L_0x00b9:
            r9 = r3
        L_0x00ba:
            if (r9 != 0) goto L_0x00bd
            r2 = r1
        L_0x00bd:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r9 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
            if (r2 != r9) goto L_0x00ed
            boolean r6 = r6.getDefinitelyNotNull()
            if (r6 != 0) goto L_0x00eb
            r6 = r7
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x00d2
        L_0x00d0:
            r6 = r4
            goto L_0x00e9
        L_0x00d2:
            java.util.Iterator r6 = r7.iterator()
        L_0x00d6:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00d0
            java.lang.Object r7 = r6.next()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r7 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers) r7
            boolean r7 = r7.getDefinitelyNotNull()
            if (r7 == 0) goto L_0x00d6
            r6 = r3
        L_0x00e9:
            if (r6 == 0) goto L_0x00ed
        L_0x00eb:
            r6 = r3
            goto L_0x00ee
        L_0x00ed:
            r6 = r4
        L_0x00ee:
            if (r2 == 0) goto L_0x00f3
            if (r0 == r1) goto L_0x00f3
            goto L_0x00f4
        L_0x00f3:
            r3 = r4
        L_0x00f4:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers r7 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers
            r7.<init>(r2, r8, r6, r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementUtilsKt.computeQualifiersForOverride(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers, java.util.Collection, boolean, boolean, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers");
    }

    public static final boolean hasEnhancedNullability(TypeSystemCommonBackendContext typeSystemCommonBackendContext, KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(typeSystemCommonBackendContext, "<this>");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
        FqName fqName = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(fqName, "ENHANCED_NULLABILITY_ANNOTATION");
        return typeSystemCommonBackendContext.hasAnnotation(kotlinTypeMarker, fqName);
    }
}
