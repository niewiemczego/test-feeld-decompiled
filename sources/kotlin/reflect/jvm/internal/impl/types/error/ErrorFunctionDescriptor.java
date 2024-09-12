package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ErrorFunctionDescriptor.kt */
public final class ErrorFunctionDescriptor extends SimpleFunctionDescriptorImpl {
    public <V> V getUserData(CallableDescriptor.UserDataKey<V> userDataKey) {
        Intrinsics.checkNotNullParameter(userDataKey, "key");
        return null;
    }

    public boolean isSuspend() {
        return false;
    }

    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> collection) {
        Intrinsics.checkNotNullParameter(collection, "overriddenDescriptors");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ErrorFunctionDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r19) {
        /*
            r18 = this;
            r0 = r19
            java.lang.String r1 = "containingDeclaration"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r3 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r3
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r0 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r5 = r0.getEMPTY()
            kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity r0 = kotlin.reflect.jvm.internal.impl.types.error.ErrorEntity.ERROR_FUNCTION
            java.lang.String r0 = r0.getDebugText()
            kotlin.reflect.jvm.internal.impl.name.Name r6 = kotlin.reflect.jvm.internal.impl.name.Name.special(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r7 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r8 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            r4 = 0
            r2 = r18
            r2.<init>(r3, r4, r5, r6, r7, r8)
            java.util.List r12 = kotlin.collections.CollectionsKt.emptyList()
            java.util.List r13 = kotlin.collections.CollectionsKt.emptyList()
            java.util.List r14 = kotlin.collections.CollectionsKt.emptyList()
            kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind r0 = kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.RETURN_TYPE_FOR_FUNCTION
            r1 = 0
            java.lang.String[] r1 = new java.lang.String[r1]
            kotlin.reflect.jvm.internal.impl.types.error.ErrorType r0 = kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorType(r0, r1)
            r15 = r0
            kotlin.reflect.jvm.internal.impl.types.KotlinType r15 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r15
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r16 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r17 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.PUBLIC
            r10 = 0
            r11 = 0
            r9 = r18
            r9.initialize((kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor) r10, (kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor) r11, (java.util.List) r12, (java.util.List) r13, (java.util.List) r14, (kotlin.reflect.jvm.internal.impl.types.KotlinType) r15, (kotlin.reflect.jvm.internal.impl.descriptors.Modality) r16, (kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility) r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.error.ErrorFunctionDescriptor.<init>(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor):void");
    }

    /* access modifiers changed from: protected */
    public FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(sourceElement, "source");
        return this;
    }

    public SimpleFunctionDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility descriptorVisibility, CallableMemberDescriptor.Kind kind, boolean z) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics.checkNotNullParameter(modality, "modality");
        Intrinsics.checkNotNullParameter(descriptorVisibility, "visibility");
        Intrinsics.checkNotNullParameter(kind, "kind");
        return this;
    }

    public FunctionDescriptor.CopyBuilder<SimpleFunctionDescriptor> newCopyBuilder() {
        return new ErrorFunctionDescriptor$newCopyBuilder$1(this);
    }
}
