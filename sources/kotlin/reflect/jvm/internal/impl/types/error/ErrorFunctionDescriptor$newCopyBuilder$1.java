package kotlin.reflect.jvm.internal.impl.types.error;

import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;

/* compiled from: ErrorFunctionDescriptor.kt */
public final class ErrorFunctionDescriptor$newCopyBuilder$1 implements FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> {
    final /* synthetic */ ErrorFunctionDescriptor this$0;

    ErrorFunctionDescriptor$newCopyBuilder$1(ErrorFunctionDescriptor errorFunctionDescriptor) {
        this.this$0 = errorFunctionDescriptor;
    }

    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setOwner(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "owner");
        return this;
    }

    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setModality(Modality modality) {
        Intrinsics.checkNotNullParameter(modality, "modality");
        return this;
    }

    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setVisibility(DescriptorVisibility descriptorVisibility) {
        Intrinsics.checkNotNullParameter(descriptorVisibility, "visibility");
        return this;
    }

    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setKind(CallableMemberDescriptor.Kind kind) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        return this;
    }

    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setCopyOverrides(boolean z) {
        return this;
    }

    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this;
    }

    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setSubstitution(TypeSubstitution typeSubstitution) {
        Intrinsics.checkNotNullParameter(typeSubstitution, "substitution");
        return this;
    }

    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setValueParameters(List<? extends ValueParameterDescriptor> list) {
        Intrinsics.checkNotNullParameter(list, DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS);
        return this;
    }

    public <V> FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> putUserData(CallableDescriptor.UserDataKey<V> userDataKey, V v) {
        Intrinsics.checkNotNullParameter(userDataKey, "userDataKey");
        return this;
    }

    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setTypeParameters(List<? extends TypeParameterDescriptor> list) {
        Intrinsics.checkNotNullParameter(list, DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS);
        return this;
    }

    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setReturnType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        return this;
    }

    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setExtensionReceiverParameter(ReceiverParameterDescriptor receiverParameterDescriptor) {
        return this;
    }

    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setDispatchReceiverParameter(ReceiverParameterDescriptor receiverParameterDescriptor) {
        return this;
    }

    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setOriginal(CallableMemberDescriptor callableMemberDescriptor) {
        return this;
    }

    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setSignatureChange() {
        return this;
    }

    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setPreserveSourceElement() {
        return this;
    }

    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setDropOriginalInContainingParts() {
        return this;
    }

    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setHiddenToOvercomeSignatureClash() {
        return this;
    }

    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setHiddenForResolutionEverywhereBesideSupercalls() {
        return this;
    }

    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> setAdditionalAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "additionalAnnotations");
        return this;
    }

    public SimpleFunctionDescriptor build() {
        return this.this$0;
    }
}
