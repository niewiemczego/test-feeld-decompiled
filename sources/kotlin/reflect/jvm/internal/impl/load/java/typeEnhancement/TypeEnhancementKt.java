package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;

/* compiled from: typeEnhancement.kt */
public final class TypeEnhancementKt {
    /* access modifiers changed from: private */
    public static final EnhancedTypeAnnotations ENHANCED_MUTABILITY_ANNOTATIONS;
    /* access modifiers changed from: private */
    public static final EnhancedTypeAnnotations ENHANCED_NULLABILITY_ANNOTATIONS;

    /* compiled from: typeEnhancement.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NullabilityQualifier.values().length];
            iArr[NullabilityQualifier.NULLABLE.ordinal()] = 1;
            iArr[NullabilityQualifier.NOT_NULL.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean hasEnhancedNullability(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return TypeEnhancementUtilsKt.hasEnhancedNullability(SimpleClassicTypeSystemContext.INSTANCE, kotlinType);
    }

    /* access modifiers changed from: private */
    public static final Annotations compositeAnnotationsOrSingle(List<? extends Annotations> list) {
        int size = list.size();
        if (size == 0) {
            throw new IllegalStateException("At least one Annotations object expected".toString());
        } else if (size != 1) {
            return new CompositeAnnotations((List<? extends Annotations>) CollectionsKt.toList(list));
        } else {
            return (Annotations) CollectionsKt.single(list);
        }
    }

    /* access modifiers changed from: private */
    public static final ClassifierDescriptor enhanceMutability(ClassifierDescriptor classifierDescriptor, JavaTypeQualifiers javaTypeQualifiers, TypeComponentPosition typeComponentPosition) {
        JavaToKotlinClassMapper javaToKotlinClassMapper = JavaToKotlinClassMapper.INSTANCE;
        if (!TypeComponentPositionKt.shouldEnhance(typeComponentPosition) || !(classifierDescriptor instanceof ClassDescriptor)) {
            return null;
        }
        if (javaTypeQualifiers.getMutability() == MutabilityQualifier.READ_ONLY && typeComponentPosition == TypeComponentPosition.FLEXIBLE_LOWER) {
            ClassDescriptor classDescriptor = (ClassDescriptor) classifierDescriptor;
            if (javaToKotlinClassMapper.isMutable(classDescriptor)) {
                return javaToKotlinClassMapper.convertMutableToReadOnly(classDescriptor);
            }
        }
        if (javaTypeQualifiers.getMutability() != MutabilityQualifier.MUTABLE || typeComponentPosition != TypeComponentPosition.FLEXIBLE_UPPER) {
            return null;
        }
        ClassDescriptor classDescriptor2 = (ClassDescriptor) classifierDescriptor;
        if (javaToKotlinClassMapper.isReadOnly(classDescriptor2)) {
            return javaToKotlinClassMapper.convertReadOnlyToMutable(classDescriptor2);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final Boolean getEnhancedNullability(JavaTypeQualifiers javaTypeQualifiers, TypeComponentPosition typeComponentPosition) {
        if (!TypeComponentPositionKt.shouldEnhance(typeComponentPosition)) {
            return null;
        }
        NullabilityQualifier nullability = javaTypeQualifiers.getNullability();
        int i = nullability == null ? -1 : WhenMappings.$EnumSwitchMapping$0[nullability.ordinal()];
        if (i == 1) {
            return true;
        }
        if (i != 2) {
            return null;
        }
        return false;
    }

    static {
        FqName fqName = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(fqName, "ENHANCED_NULLABILITY_ANNOTATION");
        ENHANCED_NULLABILITY_ANNOTATIONS = new EnhancedTypeAnnotations(fqName);
        FqName fqName2 = JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(fqName2, "ENHANCED_MUTABILITY_ANNOTATION");
        ENHANCED_MUTABILITY_ANNOTATIONS = new EnhancedTypeAnnotations(fqName2);
    }
}
