package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: DeserializedMemberDescriptor.kt */
public final class DeserializedSimpleFunctionDescriptor extends SimpleFunctionDescriptorImpl implements DeserializedCallableMemberDescriptor {
    private final DeserializedContainerSource containerSource;
    private final NameResolver nameResolver;
    private final ProtoBuf.Function proto;
    private final TypeTable typeTable;
    private final VersionRequirementTable versionRequirementTable;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeserializedSimpleFunctionDescriptor(DeclarationDescriptor declarationDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor, Annotations annotations, Name name, CallableMemberDescriptor.Kind kind, ProtoBuf.Function function, NameResolver nameResolver2, TypeTable typeTable2, VersionRequirementTable versionRequirementTable2, DeserializedContainerSource deserializedContainerSource, SourceElement sourceElement, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(declarationDescriptor, simpleFunctionDescriptor, annotations, name, kind, function, nameResolver2, typeTable2, versionRequirementTable2, deserializedContainerSource, (i & 1024) != 0 ? null : sourceElement);
    }

    public ProtoBuf.Function getProto() {
        return this.proto;
    }

    public NameResolver getNameResolver() {
        return this.nameResolver;
    }

    public TypeTable getTypeTable() {
        return this.typeTable;
    }

    public VersionRequirementTable getVersionRequirementTable() {
        return this.versionRequirementTable;
    }

    public DeserializedContainerSource getContainerSource() {
        return this.containerSource;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedSimpleFunctionDescriptor(DeclarationDescriptor declarationDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor, Annotations annotations, Name name, CallableMemberDescriptor.Kind kind, ProtoBuf.Function function, NameResolver nameResolver2, TypeTable typeTable2, VersionRequirementTable versionRequirementTable2, DeserializedContainerSource deserializedContainerSource, SourceElement sourceElement) {
        super(declarationDescriptor, simpleFunctionDescriptor, annotations, name, kind, sourceElement == null ? SourceElement.NO_SOURCE : sourceElement);
        ProtoBuf.Function function2 = function;
        NameResolver nameResolver3 = nameResolver2;
        TypeTable typeTable3 = typeTable2;
        VersionRequirementTable versionRequirementTable3 = versionRequirementTable2;
        DeclarationDescriptor declarationDescriptor2 = declarationDescriptor;
        Intrinsics.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Annotations annotations2 = annotations;
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(function2, "proto");
        Intrinsics.checkNotNullParameter(nameResolver3, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable3, "typeTable");
        Intrinsics.checkNotNullParameter(versionRequirementTable3, "versionRequirementTable");
        this.proto = function2;
        this.nameResolver = nameResolver3;
        this.typeTable = typeTable3;
        this.versionRequirementTable = versionRequirementTable3;
        this.containerSource = deserializedContainerSource;
    }

    /* access modifiers changed from: protected */
    public FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        Name name2;
        DeclarationDescriptor declarationDescriptor2 = declarationDescriptor;
        Intrinsics.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(sourceElement, "source");
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) functionDescriptor;
        if (name == null) {
            Name name3 = getName();
            Intrinsics.checkNotNullExpressionValue(name3, "name");
            name2 = name3;
        } else {
            name2 = name;
        }
        DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor = new DeserializedSimpleFunctionDescriptor(declarationDescriptor, simpleFunctionDescriptor, annotations, name2, kind, getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource(), sourceElement);
        deserializedSimpleFunctionDescriptor.setHasStableParameterNames(hasStableParameterNames());
        return deserializedSimpleFunctionDescriptor;
    }
}
