package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;

/* compiled from: JvmBuiltInsCustomizer.kt */
final class JvmBuiltInsCustomizer$getAdditionalFunctions$fakeJavaClassDescriptor$1 extends Lambda implements Function0<ClassDescriptor> {
    final /* synthetic */ LazyJavaClassDescriptor $javaAnalogueDescriptor;
    final /* synthetic */ ClassDescriptor $kotlinMutableClassIfContainer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JvmBuiltInsCustomizer$getAdditionalFunctions$fakeJavaClassDescriptor$1(LazyJavaClassDescriptor lazyJavaClassDescriptor, ClassDescriptor classDescriptor) {
        super(0);
        this.$javaAnalogueDescriptor = lazyJavaClassDescriptor;
        this.$kotlinMutableClassIfContainer = classDescriptor;
    }

    public final ClassDescriptor invoke() {
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.$javaAnalogueDescriptor;
        JavaResolverCache javaResolverCache = JavaResolverCache.EMPTY;
        Intrinsics.checkNotNullExpressionValue(javaResolverCache, "EMPTY");
        return lazyJavaClassDescriptor.copy$descriptors_jvm(javaResolverCache, this.$kotlinMutableClassIfContainer);
    }
}
