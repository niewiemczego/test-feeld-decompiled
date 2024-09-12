package kotlin.reflect.jvm;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001c\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\"\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00058FX\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0003\u0010\b¨\u0006\t"}, d2 = {"jvmErasure", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClassifier;", "getJvmErasure", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "getJvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: KTypesJvm.kt */
public final class KTypesJvm {
    public static /* synthetic */ void getJvmErasure$annotations(KType kType) {
    }

    public static final KClass<?> getJvmErasure(KType kType) {
        KClass<?> jvmErasure;
        Intrinsics.checkNotNullParameter(kType, "<this>");
        KClassifier classifier = kType.getClassifier();
        if (classifier != null && (jvmErasure = getJvmErasure(classifier)) != null) {
            return jvmErasure;
        }
        throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + kType);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: kotlin.reflect.KType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: kotlin.reflect.KType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor} */
    /* JADX WARNING: type inference failed for: r3v5, types: [kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor] */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006a, code lost:
        r5 = getJvmErasure(r2);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.KClass<?> getJvmErasure(kotlin.reflect.KClassifier r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            boolean r0 = r5 instanceof kotlin.reflect.KClass
            if (r0 == 0) goto L_0x000c
            kotlin.reflect.KClass r5 = (kotlin.reflect.KClass) r5
            goto L_0x0076
        L_0x000c:
            boolean r0 = r5 instanceof kotlin.reflect.KTypeParameter
            if (r0 == 0) goto L_0x0077
            kotlin.reflect.KTypeParameter r5 = (kotlin.reflect.KTypeParameter) r5
            java.util.List r5 = r5.getUpperBounds()
            r0 = r5
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x001d:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x005d
            java.lang.Object r1 = r0.next()
            r3 = r1
            kotlin.reflect.KType r3 = (kotlin.reflect.KType) r3
            java.lang.String r4 = "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r4)
            kotlin.reflect.jvm.internal.KTypeImpl r3 = (kotlin.reflect.jvm.internal.KTypeImpl) r3
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = r3.getType()
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r3 = r3.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r3 = r3.getDeclarationDescriptor()
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r4 == 0) goto L_0x0045
            r2 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r2
        L_0x0045:
            if (r2 == 0) goto L_0x0059
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r3 = r2.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r4 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE
            if (r3 == r4) goto L_0x0059
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r2 = r2.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r3 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ANNOTATION_CLASS
            if (r2 == r3) goto L_0x0059
            r2 = 1
            goto L_0x005a
        L_0x0059:
            r2 = 0
        L_0x005a:
            if (r2 == 0) goto L_0x001d
            r2 = r1
        L_0x005d:
            kotlin.reflect.KType r2 = (kotlin.reflect.KType) r2
            if (r2 != 0) goto L_0x0068
            java.lang.Object r5 = kotlin.collections.CollectionsKt.firstOrNull(r5)
            r2 = r5
            kotlin.reflect.KType r2 = (kotlin.reflect.KType) r2
        L_0x0068:
            if (r2 == 0) goto L_0x0070
            kotlin.reflect.KClass r5 = getJvmErasure((kotlin.reflect.KType) r2)
            if (r5 != 0) goto L_0x0076
        L_0x0070:
            java.lang.Class<java.lang.Object> r5 = java.lang.Object.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
        L_0x0076:
            return r5
        L_0x0077:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r0 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot calculate JVM erasure for type: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r5 = r1.append(r5)
            java.lang.String r5 = r5.toString()
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.KTypesJvm.getJvmErasure(kotlin.reflect.KClassifier):kotlin.reflect.KClass");
    }
}
