package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: JavaTypeResolver.kt */
public final class JavaTypeAttributes {
    private final SimpleType defaultType;
    private final JavaTypeFlexibility flexibility;
    private final TypeUsage howThisTypeIsUsed;
    private final boolean isForAnnotationParameter;
    private final Set<TypeParameterDescriptor> visitedTypeParameters;

    public static /* synthetic */ JavaTypeAttributes copy$default(JavaTypeAttributes javaTypeAttributes, TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, Set<TypeParameterDescriptor> set, SimpleType simpleType, int i, Object obj) {
        if ((i & 1) != 0) {
            typeUsage = javaTypeAttributes.howThisTypeIsUsed;
        }
        if ((i & 2) != 0) {
            javaTypeFlexibility = javaTypeAttributes.flexibility;
        }
        JavaTypeFlexibility javaTypeFlexibility2 = javaTypeFlexibility;
        if ((i & 4) != 0) {
            z = javaTypeAttributes.isForAnnotationParameter;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            set = javaTypeAttributes.visitedTypeParameters;
        }
        Set<TypeParameterDescriptor> set2 = set;
        if ((i & 16) != 0) {
            simpleType = javaTypeAttributes.defaultType;
        }
        return javaTypeAttributes.copy(typeUsage, javaTypeFlexibility2, z2, set2, simpleType);
    }

    public final JavaTypeAttributes copy(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, Set<? extends TypeParameterDescriptor> set, SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(typeUsage, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(javaTypeFlexibility, "flexibility");
        return new JavaTypeAttributes(typeUsage, javaTypeFlexibility, z, set, simpleType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JavaTypeAttributes)) {
            return false;
        }
        JavaTypeAttributes javaTypeAttributes = (JavaTypeAttributes) obj;
        return this.howThisTypeIsUsed == javaTypeAttributes.howThisTypeIsUsed && this.flexibility == javaTypeAttributes.flexibility && this.isForAnnotationParameter == javaTypeAttributes.isForAnnotationParameter && Intrinsics.areEqual((Object) this.visitedTypeParameters, (Object) javaTypeAttributes.visitedTypeParameters) && Intrinsics.areEqual((Object) this.defaultType, (Object) javaTypeAttributes.defaultType);
    }

    public int hashCode() {
        int hashCode = ((this.howThisTypeIsUsed.hashCode() * 31) + this.flexibility.hashCode()) * 31;
        boolean z = this.isForAnnotationParameter;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        Set<TypeParameterDescriptor> set = this.visitedTypeParameters;
        int i2 = 0;
        int hashCode2 = (i + (set == null ? 0 : set.hashCode())) * 31;
        SimpleType simpleType = this.defaultType;
        if (simpleType != null) {
            i2 = simpleType.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.howThisTypeIsUsed + ", flexibility=" + this.flexibility + ", isForAnnotationParameter=" + this.isForAnnotationParameter + ", visitedTypeParameters=" + this.visitedTypeParameters + ", defaultType=" + this.defaultType + ')';
    }

    public JavaTypeAttributes(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, Set<? extends TypeParameterDescriptor> set, SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(typeUsage, "howThisTypeIsUsed");
        Intrinsics.checkNotNullParameter(javaTypeFlexibility, "flexibility");
        this.howThisTypeIsUsed = typeUsage;
        this.flexibility = javaTypeFlexibility;
        this.isForAnnotationParameter = z;
        this.visitedTypeParameters = set;
        this.defaultType = simpleType;
    }

    public final TypeUsage getHowThisTypeIsUsed() {
        return this.howThisTypeIsUsed;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JavaTypeAttributes(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, Set set, SimpleType simpleType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeUsage, (i & 2) != 0 ? JavaTypeFlexibility.INFLEXIBLE : javaTypeFlexibility, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : set, (i & 16) != 0 ? null : simpleType);
    }

    public final JavaTypeFlexibility getFlexibility() {
        return this.flexibility;
    }

    public final boolean isForAnnotationParameter() {
        return this.isForAnnotationParameter;
    }

    public final Set<TypeParameterDescriptor> getVisitedTypeParameters() {
        return this.visitedTypeParameters;
    }

    public final SimpleType getDefaultType() {
        return this.defaultType;
    }

    public final JavaTypeAttributes withFlexibility(JavaTypeFlexibility javaTypeFlexibility) {
        Intrinsics.checkNotNullParameter(javaTypeFlexibility, "flexibility");
        return copy$default(this, (TypeUsage) null, javaTypeFlexibility, false, (Set) null, (SimpleType) null, 29, (Object) null);
    }

    public final JavaTypeAttributes withDefaultType(SimpleType simpleType) {
        return copy$default(this, (TypeUsage) null, (JavaTypeFlexibility) null, false, (Set) null, simpleType, 15, (Object) null);
    }

    public final JavaTypeAttributes withNewVisitedTypeParameter(TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        Set<TypeParameterDescriptor> set = this.visitedTypeParameters;
        return copy$default(this, (TypeUsage) null, (JavaTypeFlexibility) null, false, set != null ? SetsKt.plus(set, typeParameterDescriptor) : SetsKt.setOf(typeParameterDescriptor), (SimpleType) null, 23, (Object) null);
    }
}
