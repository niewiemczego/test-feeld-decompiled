package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* compiled from: JavaTypeResolver.kt */
final class JavaTypeResolver$computeRawTypeArguments$1$erasedUpperBound$1 extends Lambda implements Function0<KotlinType> {
    final /* synthetic */ JavaTypeAttributes $attr;
    final /* synthetic */ TypeConstructor $constructor;
    final /* synthetic */ JavaClassifierType $javaType;
    final /* synthetic */ TypeParameterDescriptor $parameter;
    final /* synthetic */ JavaTypeResolver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JavaTypeResolver$computeRawTypeArguments$1$erasedUpperBound$1(JavaTypeResolver javaTypeResolver, TypeParameterDescriptor typeParameterDescriptor, JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes, TypeConstructor typeConstructor) {
        super(0);
        this.this$0 = javaTypeResolver;
        this.$parameter = typeParameterDescriptor;
        this.$javaType = javaClassifierType;
        this.$attr = javaTypeAttributes;
        this.$constructor = typeConstructor;
    }

    public final KotlinType invoke() {
        TypeParameterUpperBoundEraser access$getTypeParameterUpperBoundEraser$p = this.this$0.typeParameterUpperBoundEraser;
        TypeParameterDescriptor typeParameterDescriptor = this.$parameter;
        boolean isRaw = this.$javaType.isRaw();
        JavaTypeAttributes javaTypeAttributes = this.$attr;
        ClassifierDescriptor declarationDescriptor = this.$constructor.getDeclarationDescriptor();
        KotlinType erasedUpperBound$descriptors_jvm = access$getTypeParameterUpperBoundEraser$p.getErasedUpperBound$descriptors_jvm(typeParameterDescriptor, isRaw, javaTypeAttributes.withDefaultType(declarationDescriptor != null ? declarationDescriptor.getDefaultType() : null));
        Intrinsics.checkNotNullExpressionValue(erasedUpperBound$descriptors_jvm, "typeParameterUpperBoundE…efaultType)\n            )");
        return erasedUpperBound$descriptors_jvm;
    }
}
