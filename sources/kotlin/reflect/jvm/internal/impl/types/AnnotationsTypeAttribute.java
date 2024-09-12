package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;

/* compiled from: AnnotationsTypeAttribute.kt */
public final class AnnotationsTypeAttribute extends TypeAttribute<AnnotationsTypeAttribute> {
    private final Annotations annotations;

    public KClass<? extends AnnotationsTypeAttribute> getKey() {
        return Reflection.getOrCreateKotlinClass(AnnotationsTypeAttribute.class);
    }

    public AnnotationsTypeAttribute(Annotations annotations2) {
        Intrinsics.checkNotNullParameter(annotations2, "annotations");
        this.annotations = annotations2;
    }

    public final Annotations getAnnotations() {
        return this.annotations;
    }

    public AnnotationsTypeAttribute intersect(AnnotationsTypeAttribute annotationsTypeAttribute) {
        if (Intrinsics.areEqual((Object) annotationsTypeAttribute, (Object) this)) {
            return this;
        }
        return null;
    }

    public AnnotationsTypeAttribute add(AnnotationsTypeAttribute annotationsTypeAttribute) {
        return annotationsTypeAttribute == null ? this : new AnnotationsTypeAttribute(AnnotationsKt.composeAnnotations(this.annotations, annotationsTypeAttribute.annotations));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AnnotationsTypeAttribute)) {
            return false;
        }
        return Intrinsics.areEqual((Object) ((AnnotationsTypeAttribute) obj).annotations, (Object) this.annotations);
    }

    public int hashCode() {
        return this.annotations.hashCode();
    }
}
