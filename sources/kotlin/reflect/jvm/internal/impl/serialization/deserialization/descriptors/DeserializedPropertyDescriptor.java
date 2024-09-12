package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: DeserializedMemberDescriptor.kt */
public final class DeserializedPropertyDescriptor extends PropertyDescriptorImpl implements DeserializedCallableMemberDescriptor {
    private final DeserializedContainerSource containerSource;
    private final NameResolver nameResolver;
    private final ProtoBuf.Property proto;
    private final TypeTable typeTable;
    private final VersionRequirementTable versionRequirementTable;

    public ProtoBuf.Property getProto() {
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

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeserializedPropertyDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r18, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r19, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r20, kotlin.reflect.jvm.internal.impl.descriptors.Modality r21, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r22, boolean r23, kotlin.reflect.jvm.internal.impl.name.Name r24, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind r25, boolean r26, boolean r27, boolean r28, boolean r29, boolean r30, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property r31, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r32, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r33, kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable r34, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource r35) {
        /*
            r17 = this;
            r15 = r17
            r14 = r31
            r13 = r32
            r12 = r33
            r11 = r34
            java.lang.String r0 = "containingDeclaration"
            r1 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "annotations"
            r3 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "modality"
            r4 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "visibility"
            r5 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "name"
            r7 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "kind"
            r8 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "proto"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "nameResolver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "typeTable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "versionRequirementTable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r9 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            r16 = 0
            r0 = r17
            r2 = r19
            r6 = r23
            r10 = r26
            r11 = r27
            r12 = r30
            r13 = r16
            r14 = r28
            r15 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r1 = r31
            r0.proto = r1
            r1 = r32
            r0.nameResolver = r1
            r1 = r33
            r0.typeTable = r1
            r1 = r34
            r0.versionRequirementTable = r1
            r1 = r35
            r0.containerSource = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor.<init>(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations, kotlin.reflect.jvm.internal.impl.descriptors.Modality, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility, boolean, kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, boolean, boolean, boolean, boolean, boolean, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable, kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource):void");
    }

    /* access modifiers changed from: protected */
    public PropertyDescriptorImpl createSubstitutedCopy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility descriptorVisibility, PropertyDescriptor propertyDescriptor, CallableMemberDescriptor.Kind kind, Name name, SourceElement sourceElement) {
        PropertyDescriptor propertyDescriptor2 = propertyDescriptor;
        Name name2 = name;
        Intrinsics.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics.checkNotNullParameter(modality, "newModality");
        Intrinsics.checkNotNullParameter(descriptorVisibility, "newVisibility");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(name, "newName");
        Intrinsics.checkNotNullParameter(sourceElement, "source");
        return new DeserializedPropertyDescriptor(declarationDescriptor, propertyDescriptor2, getAnnotations(), modality, descriptorVisibility, isVar(), name2, kind, isLateInit(), isConst(), isExternal(), isDelegated(), isExpect(), getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource());
    }

    public boolean isExternal() {
        Boolean bool = Flags.IS_EXTERNAL_PROPERTY.get(getProto().getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_EXTERNAL_PROPERTY.get(proto.flags)");
        return bool.booleanValue();
    }
}
