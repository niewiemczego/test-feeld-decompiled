package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;

/* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
public final class BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1$visitAnnotation$1 implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
    private final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor $$delegate_0;
    final /* synthetic */ ArrayList<AnnotationDescriptor> $list;
    final /* synthetic */ KotlinJvmBinaryClass.AnnotationArgumentVisitor $visitor;
    final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1 this$0;

    public void visit(Name name, Object obj) {
        this.$$delegate_0.visit(name, obj);
    }

    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(Name name, ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        return this.$$delegate_0.visitAnnotation(name, classId);
    }

    public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(Name name) {
        return this.$$delegate_0.visitArray(name);
    }

    public void visitClassLiteral(Name name, ClassLiteralValue classLiteralValue) {
        Intrinsics.checkNotNullParameter(classLiteralValue, "value");
        this.$$delegate_0.visitClassLiteral(name, classLiteralValue);
    }

    public void visitEnum(Name name, ClassId classId, Name name2) {
        Intrinsics.checkNotNullParameter(classId, "enumClassId");
        Intrinsics.checkNotNullParameter(name2, "enumEntryName");
        this.$$delegate_0.visitEnum(name, classId, name2);
    }

    BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1$visitAnnotation$1(KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1 binaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1, ArrayList<AnnotationDescriptor> arrayList) {
        this.$visitor = annotationArgumentVisitor;
        this.this$0 = binaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1;
        this.$list = arrayList;
        this.$$delegate_0 = annotationArgumentVisitor;
    }

    public void visitEnd() {
        this.$visitor.visitEnd();
        this.this$0.elements.add(new AnnotationValue((AnnotationDescriptor) CollectionsKt.single(this.$list)));
    }
}
