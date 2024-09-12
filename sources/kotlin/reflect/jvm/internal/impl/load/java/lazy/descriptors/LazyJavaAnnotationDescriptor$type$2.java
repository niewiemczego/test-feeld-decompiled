package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* compiled from: LazyJavaAnnotationDescriptor.kt */
final class LazyJavaAnnotationDescriptor$type$2 extends Lambda implements Function0<SimpleType> {
    final /* synthetic */ LazyJavaAnnotationDescriptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyJavaAnnotationDescriptor$type$2(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        super(0);
        this.this$0 = lazyJavaAnnotationDescriptor;
    }

    public final SimpleType invoke() {
        FqName fqName = this.this$0.getFqName();
        if (fqName == null) {
            return ErrorUtils.createErrorType(ErrorTypeKind.NOT_FOUND_FQNAME_FOR_JAVA_ANNOTATION, this.this$0.javaAnnotation.toString());
        }
        ClassDescriptor mapJavaToKotlin$default = JavaToKotlinClassMapper.mapJavaToKotlin$default(JavaToKotlinClassMapper.INSTANCE, fqName, this.this$0.c.getModule().getBuiltIns(), (Integer) null, 4, (Object) null);
        if (mapJavaToKotlin$default == null) {
            JavaClass resolve = this.this$0.javaAnnotation.resolve();
            mapJavaToKotlin$default = resolve != null ? this.this$0.c.getComponents().getModuleClassResolver().resolveClass(resolve) : null;
            if (mapJavaToKotlin$default == null) {
                mapJavaToKotlin$default = this.this$0.createTypeForMissingDependencies(fqName);
            }
        }
        return mapJavaToKotlin$default.getDefaultType();
    }
}
