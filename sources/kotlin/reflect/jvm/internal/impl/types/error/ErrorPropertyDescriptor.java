package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* compiled from: ErrorPropertyDescriptor.kt */
public final class ErrorPropertyDescriptor implements PropertyDescriptor {
    private final /* synthetic */ PropertyDescriptorImpl $$delegate_0;

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return this.$$delegate_0.accept(declarationDescriptorVisitor, d);
    }

    public CallableMemberDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility descriptorVisibility, CallableMemberDescriptor.Kind kind, boolean z) {
        return this.$$delegate_0.copy(declarationDescriptor, modality, descriptorVisibility, kind, z);
    }

    public List<PropertyAccessorDescriptor> getAccessors() {
        return this.$$delegate_0.getAccessors();
    }

    public Annotations getAnnotations() {
        Annotations annotations = this.$$delegate_0.getAnnotations();
        Intrinsics.checkNotNullExpressionValue(annotations, "<get-annotations>(...)");
        return annotations;
    }

    public FieldDescriptor getBackingField() {
        return this.$$delegate_0.getBackingField();
    }

    public ConstantValue<?> getCompileTimeInitializer() {
        return this.$$delegate_0.getCompileTimeInitializer();
    }

    public DeclarationDescriptor getContainingDeclaration() {
        return this.$$delegate_0.getContainingDeclaration();
    }

    public List<ReceiverParameterDescriptor> getContextReceiverParameters() {
        return this.$$delegate_0.getContextReceiverParameters();
    }

    public FieldDescriptor getDelegateField() {
        return this.$$delegate_0.getDelegateField();
    }

    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.$$delegate_0.getDispatchReceiverParameter();
    }

    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.$$delegate_0.getExtensionReceiverParameter();
    }

    public PropertyGetterDescriptor getGetter() {
        return this.$$delegate_0.getGetter();
    }

    public CallableMemberDescriptor.Kind getKind() {
        return this.$$delegate_0.getKind();
    }

    public Modality getModality() {
        return this.$$delegate_0.getModality();
    }

    public Name getName() {
        return this.$$delegate_0.getName();
    }

    public PropertyDescriptor getOriginal() {
        return this.$$delegate_0.getOriginal();
    }

    public Collection<? extends PropertyDescriptor> getOverriddenDescriptors() {
        return this.$$delegate_0.getOverriddenDescriptors();
    }

    public KotlinType getReturnType() {
        return this.$$delegate_0.getReturnType();
    }

    public PropertySetterDescriptor getSetter() {
        return this.$$delegate_0.getSetter();
    }

    public SourceElement getSource() {
        return this.$$delegate_0.getSource();
    }

    public KotlinType getType() {
        return this.$$delegate_0.getType();
    }

    public List<TypeParameterDescriptor> getTypeParameters() {
        return this.$$delegate_0.getTypeParameters();
    }

    public <V> V getUserData(CallableDescriptor.UserDataKey<V> userDataKey) {
        return this.$$delegate_0.getUserData(userDataKey);
    }

    public List<ValueParameterDescriptor> getValueParameters() {
        return this.$$delegate_0.getValueParameters();
    }

    public DescriptorVisibility getVisibility() {
        return this.$$delegate_0.getVisibility();
    }

    public boolean hasSynthesizedParameterNames() {
        return this.$$delegate_0.hasSynthesizedParameterNames();
    }

    public boolean isActual() {
        return this.$$delegate_0.isActual();
    }

    public boolean isConst() {
        return this.$$delegate_0.isConst();
    }

    public boolean isDelegated() {
        return this.$$delegate_0.isDelegated();
    }

    public boolean isExpect() {
        return this.$$delegate_0.isExpect();
    }

    public boolean isExternal() {
        return this.$$delegate_0.isExternal();
    }

    public boolean isLateInit() {
        return this.$$delegate_0.isLateInit();
    }

    public boolean isVar() {
        return this.$$delegate_0.isVar();
    }

    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> collection) {
        Intrinsics.checkNotNullParameter(collection, "overriddenDescriptors");
        this.$$delegate_0.setOverriddenDescriptors(collection);
    }

    public PropertyDescriptor substitute(TypeSubstitutor typeSubstitutor) {
        Intrinsics.checkNotNullParameter(typeSubstitutor, "substitutor");
        return this.$$delegate_0.substitute(typeSubstitutor);
    }

    public ErrorPropertyDescriptor() {
        PropertyDescriptorImpl create = PropertyDescriptorImpl.create(ErrorUtils.INSTANCE.getErrorClass(), Annotations.Companion.getEMPTY(), Modality.OPEN, DescriptorVisibilities.PUBLIC, true, Name.special(ErrorEntity.ERROR_PROPERTY.getDebugText()), CallableMemberDescriptor.Kind.DECLARATION, SourceElement.NO_SOURCE, false, false, false, false, false, false);
        create.setType(ErrorUtils.INSTANCE.getErrorPropertyType(), CollectionsKt.emptyList(), (ReceiverParameterDescriptor) null, (ReceiverParameterDescriptor) null, CollectionsKt.emptyList());
        this.$$delegate_0 = create;
    }
}
