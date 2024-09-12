package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* compiled from: TypeAliasConstructorDescriptor.kt */
final class TypeAliasConstructorDescriptorImpl$withDispatchReceiver$2 extends Lambda implements Function0<TypeAliasConstructorDescriptorImpl> {
    final /* synthetic */ ClassConstructorDescriptor $underlyingConstructorDescriptor;
    final /* synthetic */ TypeAliasConstructorDescriptorImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TypeAliasConstructorDescriptorImpl$withDispatchReceiver$2(TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl, ClassConstructorDescriptor classConstructorDescriptor) {
        super(0);
        this.this$0 = typeAliasConstructorDescriptorImpl;
        this.$underlyingConstructorDescriptor = classConstructorDescriptor;
    }

    public final TypeAliasConstructorDescriptorImpl invoke() {
        StorageManager storageManager = this.this$0.getStorageManager();
        TypeAliasDescriptor typeAliasDescriptor = this.this$0.getTypeAliasDescriptor();
        ClassConstructorDescriptor classConstructorDescriptor = this.$underlyingConstructorDescriptor;
        Annotations annotations = classConstructorDescriptor.getAnnotations();
        CallableMemberDescriptor.Kind kind = this.$underlyingConstructorDescriptor.getKind();
        Intrinsics.checkNotNullExpressionValue(kind, "underlyingConstructorDescriptor.kind");
        SourceElement source = this.this$0.getTypeAliasDescriptor().getSource();
        Intrinsics.checkNotNullExpressionValue(source, "typeAliasDescriptor.source");
        TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl = new TypeAliasConstructorDescriptorImpl(storageManager, typeAliasDescriptor, classConstructorDescriptor, this.this$0, annotations, kind, source, (DefaultConstructorMarker) null);
        TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl2 = this.this$0;
        ClassConstructorDescriptor classConstructorDescriptor2 = this.$underlyingConstructorDescriptor;
        TypeSubstitutor access$getTypeSubstitutorForUnderlyingClass = TypeAliasConstructorDescriptorImpl.Companion.getTypeSubstitutorForUnderlyingClass(typeAliasConstructorDescriptorImpl2.getTypeAliasDescriptor());
        ReceiverParameterDescriptor receiverParameterDescriptor = null;
        if (access$getTypeSubstitutorForUnderlyingClass == null) {
            return null;
        }
        ReceiverParameterDescriptor dispatchReceiverParameter = classConstructorDescriptor2.getDispatchReceiverParameter();
        if (dispatchReceiverParameter != null) {
            receiverParameterDescriptor = dispatchReceiverParameter.substitute(access$getTypeSubstitutorForUnderlyingClass);
        }
        List<ReceiverParameterDescriptor> contextReceiverParameters = classConstructorDescriptor2.getContextReceiverParameters();
        Intrinsics.checkNotNullExpressionValue(contextReceiverParameters, "underlyingConstructorDes…contextReceiverParameters");
        Iterable<ReceiverParameterDescriptor> iterable = contextReceiverParameters;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ReceiverParameterDescriptor substitute : iterable) {
            arrayList.add(substitute.substitute(access$getTypeSubstitutorForUnderlyingClass));
        }
        typeAliasConstructorDescriptorImpl.initialize((ReceiverParameterDescriptor) null, receiverParameterDescriptor, (List) arrayList, typeAliasConstructorDescriptorImpl2.getTypeAliasDescriptor().getDeclaredTypeParameters(), typeAliasConstructorDescriptorImpl2.getValueParameters(), typeAliasConstructorDescriptorImpl2.getReturnType(), Modality.FINAL, typeAliasConstructorDescriptorImpl2.getTypeAliasDescriptor().getVisibility());
        return typeAliasConstructorDescriptorImpl;
    }
}
