package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: LazyJavaClassDescriptor.kt */
final class LazyJavaClassDescriptor$moduleAnnotations$2 extends Lambda implements Function0<List<? extends JavaAnnotation>> {
    final /* synthetic */ LazyJavaClassDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaClassDescriptor$moduleAnnotations$2(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        super(0);
        this.this$0 = lazyJavaClassDescriptor;
    }

    public final List<JavaAnnotation> invoke() {
        ClassId classId = DescriptorUtilsKt.getClassId(this.this$0);
        if (classId != null) {
            return this.this$0.getOuterContext().getComponents().getJavaModuleResolver().getAnnotationsForModuleOwnerOfClass(classId);
        }
        return null;
    }
}
