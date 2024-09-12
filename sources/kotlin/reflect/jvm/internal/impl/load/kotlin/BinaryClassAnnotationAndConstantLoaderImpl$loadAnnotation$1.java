package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
public final class BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1 extends BinaryClassAnnotationAndConstantLoaderImpl.AbstractAnnotationArgumentVisitor {
    final /* synthetic */ ClassDescriptor $annotationClass;
    final /* synthetic */ ClassId $annotationClassId;
    final /* synthetic */ List<AnnotationDescriptor> $result;
    final /* synthetic */ SourceElement $source;
    private final HashMap<Name, ConstantValue<?>> arguments = new HashMap<>();
    final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1(BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl, ClassDescriptor classDescriptor, ClassId classId, List<AnnotationDescriptor> list, SourceElement sourceElement) {
        super();
        this.this$0 = binaryClassAnnotationAndConstantLoaderImpl;
        this.$annotationClass = classDescriptor;
        this.$annotationClassId = classId;
        this.$result = list;
        this.$source = sourceElement;
    }

    public void visitConstantValue(Name name, ConstantValue<?> constantValue) {
        Intrinsics.checkNotNullParameter(constantValue, "value");
        if (name != null) {
            this.arguments.put(name, constantValue);
        }
    }

    public void visitArrayValue(Name name, ArrayList<ConstantValue<?>> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "elements");
        if (name != null) {
            ValueParameterDescriptor annotationParameterByName = DescriptorResolverUtils.getAnnotationParameterByName(name, this.$annotationClass);
            if (annotationParameterByName != null) {
                ConstantValueFactory constantValueFactory = ConstantValueFactory.INSTANCE;
                List<T> compact = CollectionsKt.compact(arrayList);
                KotlinType type = annotationParameterByName.getType();
                Intrinsics.checkNotNullExpressionValue(type, "parameter.type");
                this.arguments.put(name, constantValueFactory.createArrayValue((List<? extends ConstantValue<?>>) compact, type));
            } else if (this.this$0.isImplicitRepeatableContainer(this.$annotationClassId) && Intrinsics.areEqual((Object) name.asString(), (Object) "value")) {
                Collection arrayList2 = new ArrayList();
                for (Object next : arrayList) {
                    if (next instanceof AnnotationValue) {
                        arrayList2.add(next);
                    }
                }
                Collection collection = this.$result;
                for (AnnotationValue value : (List) arrayList2) {
                    collection.add((AnnotationDescriptor) value.getValue());
                }
            }
        }
    }

    public void visitEnd() {
        if (!this.this$0.isRepeatableWithImplicitContainer(this.$annotationClassId, this.arguments) && !this.this$0.isImplicitRepeatableContainer(this.$annotationClassId)) {
            this.$result.add(new AnnotationDescriptorImpl(this.$annotationClass.getDefaultType(), this.arguments, this.$source));
        }
    }
}
