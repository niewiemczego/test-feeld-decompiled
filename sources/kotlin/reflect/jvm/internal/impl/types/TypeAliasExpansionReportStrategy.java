package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;

/* compiled from: TypeAliasExpansionReportStrategy.kt */
public interface TypeAliasExpansionReportStrategy {
    void boundsViolationInSubstitution(TypeSubstitutor typeSubstitutor, KotlinType kotlinType, KotlinType kotlinType2, TypeParameterDescriptor typeParameterDescriptor);

    void conflictingProjection(TypeAliasDescriptor typeAliasDescriptor, TypeParameterDescriptor typeParameterDescriptor, KotlinType kotlinType);

    void recursiveTypeAlias(TypeAliasDescriptor typeAliasDescriptor);

    void repeatedAnnotation(AnnotationDescriptor annotationDescriptor);

    /* compiled from: TypeAliasExpansionReportStrategy.kt */
    public static final class DO_NOTHING implements TypeAliasExpansionReportStrategy {
        public static final DO_NOTHING INSTANCE = new DO_NOTHING();

        public void boundsViolationInSubstitution(TypeSubstitutor typeSubstitutor, KotlinType kotlinType, KotlinType kotlinType2, TypeParameterDescriptor typeParameterDescriptor) {
            Intrinsics.checkNotNullParameter(typeSubstitutor, "substitutor");
            Intrinsics.checkNotNullParameter(kotlinType, "unsubstitutedArgument");
            Intrinsics.checkNotNullParameter(kotlinType2, "argument");
            Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        }

        public void conflictingProjection(TypeAliasDescriptor typeAliasDescriptor, TypeParameterDescriptor typeParameterDescriptor, KotlinType kotlinType) {
            Intrinsics.checkNotNullParameter(typeAliasDescriptor, "typeAlias");
            Intrinsics.checkNotNullParameter(kotlinType, "substitutedArgument");
        }

        public void recursiveTypeAlias(TypeAliasDescriptor typeAliasDescriptor) {
            Intrinsics.checkNotNullParameter(typeAliasDescriptor, "typeAlias");
        }

        public void repeatedAnnotation(AnnotationDescriptor annotationDescriptor) {
            Intrinsics.checkNotNullParameter(annotationDescriptor, "annotation");
        }

        private DO_NOTHING() {
        }
    }
}
