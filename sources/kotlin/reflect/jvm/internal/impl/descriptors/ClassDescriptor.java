package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;

public interface ClassDescriptor extends ClassOrPackageFragmentDescriptor, ClassifierDescriptorWithTypeParameters {
    ClassDescriptor getCompanionObjectDescriptor();

    Collection<ClassConstructorDescriptor> getConstructors();

    DeclarationDescriptor getContainingDeclaration();

    List<ReceiverParameterDescriptor> getContextReceivers();

    List<TypeParameterDescriptor> getDeclaredTypeParameters();

    SimpleType getDefaultType();

    ClassKind getKind();

    MemberScope getMemberScope(TypeSubstitution typeSubstitution);

    Modality getModality();

    ClassDescriptor getOriginal();

    Collection<ClassDescriptor> getSealedSubclasses();

    MemberScope getStaticScope();

    ReceiverParameterDescriptor getThisAsReceiverParameter();

    MemberScope getUnsubstitutedInnerClassesScope();

    MemberScope getUnsubstitutedMemberScope();

    ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor();

    ValueClassRepresentation<SimpleType> getValueClassRepresentation();

    DescriptorVisibility getVisibility();

    boolean isCompanionObject();

    boolean isData();

    boolean isFun();

    boolean isInline();

    boolean isValue();
}
