package kotlin.reflect.jvm.internal.impl;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: SpecialJvmAnnotations.kt */
public final class SpecialJvmAnnotations {
    public static final SpecialJvmAnnotations INSTANCE = new SpecialJvmAnnotations();
    private static final ClassId JAVA_LANG_ANNOTATION_REPEATABLE;
    private static final Set<ClassId> SPECIAL_ANNOTATIONS;

    private SpecialJvmAnnotations() {
    }

    public final Set<ClassId> getSPECIAL_ANNOTATIONS() {
        return SPECIAL_ANNOTATIONS;
    }

    static {
        FqName[] fqNameArr = {JvmAnnotationNames.METADATA_FQ_NAME, JvmAnnotationNames.JETBRAINS_NOT_NULL_ANNOTATION, JvmAnnotationNames.JETBRAINS_NULLABLE_ANNOTATION, JvmAnnotationNames.TARGET_ANNOTATION, JvmAnnotationNames.RETENTION_ANNOTATION, JvmAnnotationNames.DOCUMENTED_ANNOTATION};
        Collection linkedHashSet = new LinkedHashSet();
        for (FqName fqName : CollectionsKt.listOf(fqNameArr)) {
            linkedHashSet.add(ClassId.topLevel(fqName));
        }
        SPECIAL_ANNOTATIONS = (Set) linkedHashSet;
        ClassId classId = ClassId.topLevel(JvmAnnotationNames.REPEATABLE_ANNOTATION);
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(JvmAnnotationNames.REPEATABLE_ANNOTATION)");
        JAVA_LANG_ANNOTATION_REPEATABLE = classId;
    }

    public final ClassId getJAVA_LANG_ANNOTATION_REPEATABLE() {
        return JAVA_LANG_ANNOTATION_REPEATABLE;
    }

    public final boolean isAnnotatedWithContainerMetaAnnotation(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "klass");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        kotlinJvmBinaryClass.loadClassAnnotations(new SpecialJvmAnnotations$isAnnotatedWithContainerMetaAnnotation$1(booleanRef), (byte[]) null);
        return booleanRef.element;
    }
}
