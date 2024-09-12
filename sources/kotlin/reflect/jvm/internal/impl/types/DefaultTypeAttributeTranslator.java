package kotlin.reflect.jvm.internal.impl.types;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* compiled from: TypeAttributeTranslator.kt */
public final class DefaultTypeAttributeTranslator implements TypeAttributeTranslator {
    public static final DefaultTypeAttributeTranslator INSTANCE = new DefaultTypeAttributeTranslator();

    private DefaultTypeAttributeTranslator() {
    }

    public TypeAttributes toAttributes(Annotations annotations, TypeConstructor typeConstructor, DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        if (annotations.isEmpty()) {
            return TypeAttributes.Companion.getEmpty();
        }
        return TypeAttributes.Companion.create(CollectionsKt.listOf(new AnnotationsTypeAttribute(annotations)));
    }
}
