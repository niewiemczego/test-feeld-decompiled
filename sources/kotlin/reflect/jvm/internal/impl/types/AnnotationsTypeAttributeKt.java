package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.util.NullableArrayMapAccessor;

/* compiled from: AnnotationsTypeAttribute.kt */
public final class AnnotationsTypeAttributeKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinPackage(AnnotationsTypeAttributeKt.class, "descriptors"), "annotationsAttribute", "getAnnotationsAttribute(Lorg/jetbrains/kotlin/types/TypeAttributes;)Lorg/jetbrains/kotlin/types/AnnotationsTypeAttribute;"))};
    private static final ReadOnlyProperty annotationsAttribute$delegate;

    static {
        NullableArrayMapAccessor generateNullableAccessor = TypeAttributes.Companion.generateNullableAccessor(Reflection.getOrCreateKotlinClass(AnnotationsTypeAttribute.class));
        Intrinsics.checkNotNull(generateNullableAccessor, "null cannot be cast to non-null type kotlin.properties.ReadOnlyProperty<org.jetbrains.kotlin.types.TypeAttributes, T of org.jetbrains.kotlin.types.TypeAttributes.Companion.attributeAccessor?>");
        annotationsAttribute$delegate = generateNullableAccessor;
    }

    public static final AnnotationsTypeAttribute getAnnotationsAttribute(TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeAttributes, "<this>");
        return (AnnotationsTypeAttribute) annotationsAttribute$delegate.getValue(typeAttributes, $$delegatedProperties[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r1 = r1.getAnnotations();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations getAnnotations(kotlin.reflect.jvm.internal.impl.types.TypeAttributes r1) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttribute r1 = getAnnotationsAttribute(r1)
            if (r1 == 0) goto L_0x0011
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r1 = r1.getAnnotations()
            if (r1 != 0) goto L_0x0017
        L_0x0011:
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r1 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r1 = r1.getEMPTY()
        L_0x0017:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.AnnotationsTypeAttributeKt.getAnnotations(kotlin.reflect.jvm.internal.impl.types.TypeAttributes):kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations");
    }
}
