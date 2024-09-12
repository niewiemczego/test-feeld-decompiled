package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameterListOwner;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: resolvers.kt */
public final class LazyJavaTypeParameterResolver implements TypeParameterResolver {
    /* access modifiers changed from: private */
    public final LazyJavaResolverContext c;
    /* access modifiers changed from: private */
    public final DeclarationDescriptor containingDeclaration;
    private final MemoizedFunctionToNullable<JavaTypeParameter, LazyJavaTypeParameterDescriptor> resolve;
    /* access modifiers changed from: private */
    public final Map<JavaTypeParameter, Integer> typeParameters;
    /* access modifiers changed from: private */
    public final int typeParametersIndexOffset;

    public LazyJavaTypeParameterResolver(LazyJavaResolverContext lazyJavaResolverContext, DeclarationDescriptor declarationDescriptor, JavaTypeParameterListOwner javaTypeParameterListOwner, int i) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        Intrinsics.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Intrinsics.checkNotNullParameter(javaTypeParameterListOwner, "typeParameterOwner");
        this.c = lazyJavaResolverContext;
        this.containingDeclaration = declarationDescriptor;
        this.typeParametersIndexOffset = i;
        this.typeParameters = CollectionsKt.mapToIndex(javaTypeParameterListOwner.getTypeParameters());
        this.resolve = lazyJavaResolverContext.getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaTypeParameterResolver$resolve$1(this));
    }

    public TypeParameterDescriptor resolveTypeParameter(JavaTypeParameter javaTypeParameter) {
        Intrinsics.checkNotNullParameter(javaTypeParameter, "javaTypeParameter");
        LazyJavaTypeParameterDescriptor invoke = this.resolve.invoke(javaTypeParameter);
        return invoke != null ? invoke : this.c.getTypeParameterResolver().resolveTypeParameter(javaTypeParameter);
    }
}
