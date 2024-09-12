package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.sequences.SequencesKt;

/* compiled from: LazyJavaAnnotations.kt */
public final class LazyJavaAnnotations implements Annotations {
    private final MemoizedFunctionToNullable<JavaAnnotation, AnnotationDescriptor> annotationDescriptors;
    private final JavaAnnotationOwner annotationOwner;
    /* access modifiers changed from: private */
    public final boolean areAnnotationsFreshlySupported;
    /* access modifiers changed from: private */
    public final LazyJavaResolverContext c;

    public LazyJavaAnnotations(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotationOwner javaAnnotationOwner, boolean z) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        Intrinsics.checkNotNullParameter(javaAnnotationOwner, "annotationOwner");
        this.c = lazyJavaResolverContext;
        this.annotationOwner = javaAnnotationOwner;
        this.areAnnotationsFreshlySupported = z;
        this.annotationDescriptors = lazyJavaResolverContext.getComponents().getStorageManager().createMemoizedFunctionWithNullableValues(new LazyJavaAnnotations$annotationDescriptors$1(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyJavaAnnotations(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotationOwner javaAnnotationOwner, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyJavaResolverContext, javaAnnotationOwner, (i & 4) != 0 ? false : z);
    }

    public boolean hasAnnotation(FqName fqName) {
        return Annotations.DefaultImpls.hasAnnotation(this, fqName);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r0 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor) r3.annotationDescriptors.invoke(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor findAnnotation(kotlin.reflect.jvm.internal.impl.name.FqName r4) {
        /*
            r3 = this;
            java.lang.String r0 = "fqName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner r0 = r3.annotationOwner
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation r0 = r0.findAnnotation(r4)
            if (r0 == 0) goto L_0x0019
            kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable<kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor> r1 = r3.annotationDescriptors
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            java.lang.Object r0 = r1.invoke(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor) r0
            if (r0 != 0) goto L_0x0023
        L_0x0019:
            kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper r0 = kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper.INSTANCE
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner r1 = r3.annotationOwner
            kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext r2 = r3.c
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r0 = r0.findMappedJavaAnnotation(r4, r1, r2)
        L_0x0023:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations.findAnnotation(kotlin.reflect.jvm.internal.impl.name.FqName):kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor");
    }

    public Iterator<AnnotationDescriptor> iterator() {
        return SequencesKt.filterNotNull(SequencesKt.plus(SequencesKt.map(CollectionsKt.asSequence(this.annotationOwner.getAnnotations()), this.annotationDescriptors), JavaAnnotationMapper.INSTANCE.findMappedJavaAnnotation(StandardNames.FqNames.deprecated, this.annotationOwner, this.c))).iterator();
    }

    public boolean isEmpty() {
        return this.annotationOwner.getAnnotations().isEmpty() && !this.annotationOwner.isDeprecatedInJavaDoc();
    }
}
