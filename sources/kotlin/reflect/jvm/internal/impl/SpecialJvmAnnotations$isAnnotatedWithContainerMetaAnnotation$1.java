package kotlin.reflect.jvm.internal.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAbi;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: SpecialJvmAnnotations.kt */
public final class SpecialJvmAnnotations$isAnnotatedWithContainerMetaAnnotation$1 implements KotlinJvmBinaryClass.AnnotationVisitor {
    final /* synthetic */ Ref.BooleanRef $result;

    public void visitEnd() {
    }

    SpecialJvmAnnotations$isAnnotatedWithContainerMetaAnnotation$1(Ref.BooleanRef booleanRef) {
        this.$result = booleanRef;
    }

    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId classId, SourceElement sourceElement) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(sourceElement, "source");
        if (!Intrinsics.areEqual((Object) classId, (Object) JvmAbi.INSTANCE.getREPEATABLE_ANNOTATION_CONTAINER_META_ANNOTATION())) {
            return null;
        }
        this.$result.element = true;
        return null;
    }
}
