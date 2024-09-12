package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImplKt;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;

/* compiled from: JavaTypeResolver.kt */
public final class JavaTypeResolverKt {
    /* access modifiers changed from: private */
    public static final FqName JAVA_LANG_CLASS_FQ_NAME = new FqName("java.lang.Class");

    public static final TypeProjection makeStarProjection(TypeParameterDescriptor typeParameterDescriptor, JavaTypeAttributes javaTypeAttributes) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        Intrinsics.checkNotNullParameter(javaTypeAttributes, "attr");
        if (javaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) {
            return new TypeProjectionImpl(StarProjectionImplKt.starProjectionType(typeParameterDescriptor));
        }
        return new StarProjectionImpl(typeParameterDescriptor);
    }

    public static /* synthetic */ JavaTypeAttributes toAttributes$default(TypeUsage typeUsage, boolean z, TypeParameterDescriptor typeParameterDescriptor, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            typeParameterDescriptor = null;
        }
        return toAttributes(typeUsage, z, typeParameterDescriptor);
    }

    public static final JavaTypeAttributes toAttributes(TypeUsage typeUsage, boolean z, TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkNotNullParameter(typeUsage, "<this>");
        return new JavaTypeAttributes(typeUsage, (JavaTypeFlexibility) null, z, typeParameterDescriptor != null ? SetsKt.setOf(typeParameterDescriptor) : null, (SimpleType) null, 18, (DefaultConstructorMarker) null);
    }
}
