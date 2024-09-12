package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: typeEnhancement.kt */
final class EnhancedTypeAnnotations implements Annotations {
    private final FqName fqNameToMatch;

    public boolean isEmpty() {
        return false;
    }

    public EnhancedTypeAnnotations(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqNameToMatch");
        this.fqNameToMatch = fqName;
    }

    public boolean hasAnnotation(FqName fqName) {
        return Annotations.DefaultImpls.hasAnnotation(this, fqName);
    }

    public EnhancedTypeAnnotationDescriptor findAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (Intrinsics.areEqual((Object) fqName, (Object) this.fqNameToMatch)) {
            return EnhancedTypeAnnotationDescriptor.INSTANCE;
        }
        return null;
    }

    public Iterator<AnnotationDescriptor> iterator() {
        return CollectionsKt.emptyList().iterator();
    }
}
