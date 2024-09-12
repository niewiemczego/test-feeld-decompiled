package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: Annotations.kt */
public final class FilteredAnnotations implements Annotations {
    private final Annotations delegate;
    private final Function1<FqName, Boolean> fqNameFilter;
    private final boolean isDefinitelyNewInference;

    public FilteredAnnotations(Annotations annotations, boolean z, Function1<? super FqName, Boolean> function1) {
        Intrinsics.checkNotNullParameter(annotations, "delegate");
        Intrinsics.checkNotNullParameter(function1, "fqNameFilter");
        this.delegate = annotations;
        this.isDefinitelyNewInference = z;
        this.fqNameFilter = function1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FilteredAnnotations(Annotations annotations, Function1<? super FqName, Boolean> function1) {
        this(annotations, false, function1);
        Intrinsics.checkNotNullParameter(annotations, "delegate");
        Intrinsics.checkNotNullParameter(function1, "fqNameFilter");
    }

    public boolean hasAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (this.fqNameFilter.invoke(fqName).booleanValue()) {
            return this.delegate.hasAnnotation(fqName);
        }
        return false;
    }

    public AnnotationDescriptor findAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (this.fqNameFilter.invoke(fqName).booleanValue()) {
            return this.delegate.findAnnotation(fqName);
        }
        return null;
    }

    public Iterator<AnnotationDescriptor> iterator() {
        Collection arrayList = new ArrayList();
        for (Object next : this.delegate) {
            if (shouldBeReturned((AnnotationDescriptor) next)) {
                arrayList.add(next);
            }
        }
        return ((List) arrayList).iterator();
    }

    public boolean isEmpty() {
        boolean z;
        Iterable iterable = this.delegate;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (shouldBeReturned((AnnotationDescriptor) it.next())) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = false;
        if (!this.isDefinitelyNewInference) {
            return z;
        }
        if (!z) {
            return true;
        }
        return false;
    }

    private final boolean shouldBeReturned(AnnotationDescriptor annotationDescriptor) {
        FqName fqName = annotationDescriptor.getFqName();
        return fqName != null && this.fqNameFilter.invoke(fqName).booleanValue();
    }
}
