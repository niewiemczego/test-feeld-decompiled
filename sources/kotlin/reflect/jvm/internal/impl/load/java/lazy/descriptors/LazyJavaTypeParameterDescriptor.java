package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: LazyJavaTypeParameterDescriptor.kt */
public final class LazyJavaTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {
    private final LazyJavaResolverContext c;
    private final JavaTypeParameter javaTypeParameter;

    /* access modifiers changed from: protected */
    public void reportSupertypeLoopError(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LazyJavaTypeParameterDescriptor(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r12, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter r13, int r14, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r15) {
        /*
            r11 = this;
            java.lang.String r0 = "c"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "javaTypeParameter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "containingDeclaration"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            kotlin.reflect.jvm.internal.impl.storage.StorageManager r2 = r12.getStorageManager()
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations r0 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations
            r5 = r13
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner r5 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner) r5
            r6 = 0
            r7 = 4
            r8 = 0
            r3 = r0
            r4 = r12
            r3.<init>(r4, r5, r6, r7, r8)
            r4 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations) r4
            kotlin.reflect.jvm.internal.impl.name.Name r5 = r13.getName()
            kotlin.reflect.jvm.internal.impl.types.Variance r6 = kotlin.reflect.jvm.internal.impl.types.Variance.INVARIANT
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r9 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents r0 = r12.getComponents()
            kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker r10 = r0.getSupertypeLoopChecker()
            r7 = 0
            r1 = r11
            r3 = r15
            r8 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r11.c = r12
            r11.javaTypeParameter = r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaTypeParameterDescriptor.<init>(kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter, int, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor):void");
    }

    /* access modifiers changed from: protected */
    public List<KotlinType> resolveUpperBounds() {
        return computeNotEnhancedBounds();
    }

    private final List<KotlinType> computeNotEnhancedBounds() {
        Collection<JavaClassifierType> upperBounds = this.javaTypeParameter.getUpperBounds();
        if (upperBounds.isEmpty()) {
            SimpleType anyType = this.c.getModule().getBuiltIns().getAnyType();
            Intrinsics.checkNotNullExpressionValue(anyType, "c.module.builtIns.anyType");
            SimpleType nullableAnyType = this.c.getModule().getBuiltIns().getNullableAnyType();
            Intrinsics.checkNotNullExpressionValue(nullableAnyType, "c.module.builtIns.nullableAnyType");
            return CollectionsKt.listOf(KotlinTypeFactory.flexibleType(anyType, nullableAnyType));
        }
        Iterable<JavaClassifierType> iterable = upperBounds;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (JavaClassifierType transformJavaType : iterable) {
            arrayList.add(this.c.getTypeResolver().transformJavaType(transformJavaType, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, this, 1, (Object) null)));
        }
        return (List) arrayList;
    }

    /* access modifiers changed from: protected */
    public List<KotlinType> processBoundsWithoutCycles(List<? extends KotlinType> list) {
        Intrinsics.checkNotNullParameter(list, "bounds");
        return this.c.getComponents().getSignatureEnhancement().enhanceTypeParameterBounds(this, list, this.c);
    }
}
