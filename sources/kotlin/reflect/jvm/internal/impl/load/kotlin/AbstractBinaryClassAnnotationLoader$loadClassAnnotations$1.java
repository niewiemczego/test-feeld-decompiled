package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: AbstractBinaryClassAnnotationLoader.kt */
public final class AbstractBinaryClassAnnotationLoader$loadClassAnnotations$1 implements KotlinJvmBinaryClass.AnnotationVisitor {
    final /* synthetic */ ArrayList<A> $result;
    final /* synthetic */ AbstractBinaryClassAnnotationLoader<A, S> this$0;

    public void visitEnd() {
    }

    AbstractBinaryClassAnnotationLoader$loadClassAnnotations$1(AbstractBinaryClassAnnotationLoader<A, S> abstractBinaryClassAnnotationLoader, ArrayList<A> arrayList) {
        this.this$0 = abstractBinaryClassAnnotationLoader;
        this.$result = arrayList;
    }

    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId classId, SourceElement sourceElement) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(sourceElement, "source");
        return this.this$0.loadAnnotationIfNotSpecial(classId, sourceElement, this.$result);
    }
}
