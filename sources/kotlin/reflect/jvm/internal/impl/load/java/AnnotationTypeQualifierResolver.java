package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: AnnotationTypeQualifierResolver.kt */
public final class AnnotationTypeQualifierResolver extends AbstractAnnotationTypeQualifierResolver<AnnotationDescriptor> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnnotationTypeQualifierResolver(JavaTypeEnhancementState javaTypeEnhancementState) {
        super(javaTypeEnhancementState);
        Intrinsics.checkNotNullParameter(javaTypeEnhancementState, "javaTypeEnhancementState");
    }

    /* access modifiers changed from: protected */
    public Iterable<AnnotationDescriptor> getMetaAnnotations(AnnotationDescriptor annotationDescriptor) {
        Iterable<AnnotationDescriptor> iterable;
        Intrinsics.checkNotNullParameter(annotationDescriptor, "<this>");
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        if (annotationClass == null || (iterable = annotationClass.getAnnotations()) == null) {
            iterable = CollectionsKt.emptyList();
        }
        return iterable;
    }

    /* access modifiers changed from: protected */
    public Object getKey(AnnotationDescriptor annotationDescriptor) {
        Intrinsics.checkNotNullParameter(annotationDescriptor, "<this>");
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        Intrinsics.checkNotNull(annotationClass);
        return annotationClass;
    }

    /* access modifiers changed from: protected */
    public FqName getFqName(AnnotationDescriptor annotationDescriptor) {
        Intrinsics.checkNotNullParameter(annotationDescriptor, "<this>");
        return annotationDescriptor.getFqName();
    }

    /* access modifiers changed from: protected */
    public Iterable<String> enumArguments(AnnotationDescriptor annotationDescriptor, boolean z) {
        List<String> list;
        Intrinsics.checkNotNullParameter(annotationDescriptor, "<this>");
        Map<Name, ConstantValue<?>> allValueArguments = annotationDescriptor.getAllValueArguments();
        Collection arrayList = new ArrayList();
        for (Map.Entry next : allValueArguments.entrySet()) {
            Name name = (Name) next.getKey();
            ConstantValue constantValue = (ConstantValue) next.getValue();
            if (!z || Intrinsics.areEqual((Object) name, (Object) JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME)) {
                list = toEnumNames(constantValue);
            } else {
                list = CollectionsKt.emptyList();
            }
            CollectionsKt.addAll(arrayList, list);
        }
        return (List) arrayList;
    }

    private final List<String> toEnumNames(ConstantValue<?> constantValue) {
        if (constantValue instanceof ArrayValue) {
            Collection arrayList = new ArrayList();
            for (ConstantValue enumNames : (Iterable) ((ArrayValue) constantValue).getValue()) {
                CollectionsKt.addAll(arrayList, toEnumNames(enumNames));
            }
            return (List) arrayList;
        } else if (constantValue instanceof EnumValue) {
            return CollectionsKt.listOf(((EnumValue) constantValue).getEnumEntryName().getIdentifier());
        } else {
            return CollectionsKt.emptyList();
        }
    }
}
