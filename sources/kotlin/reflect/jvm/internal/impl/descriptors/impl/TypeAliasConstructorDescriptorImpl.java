package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: TypeAliasConstructorDescriptor.kt */
public final class TypeAliasConstructorDescriptorImpl extends FunctionDescriptorImpl implements TypeAliasConstructorDescriptor {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TypeAliasConstructorDescriptorImpl.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final StorageManager storageManager;
    private final TypeAliasDescriptor typeAliasDescriptor;
    private ClassConstructorDescriptor underlyingConstructorDescriptor;
    private final NullableLazyValue withDispatchReceiver$delegate;

    public /* synthetic */ TypeAliasConstructorDescriptorImpl(StorageManager storageManager2, TypeAliasDescriptor typeAliasDescriptor2, ClassConstructorDescriptor classConstructorDescriptor, TypeAliasConstructorDescriptor typeAliasConstructorDescriptor, Annotations annotations, CallableMemberDescriptor.Kind kind, SourceElement sourceElement, DefaultConstructorMarker defaultConstructorMarker) {
        this(storageManager2, typeAliasDescriptor2, classConstructorDescriptor, typeAliasConstructorDescriptor, annotations, kind, sourceElement);
    }

    public final StorageManager getStorageManager() {
        return this.storageManager;
    }

    public TypeAliasDescriptor getTypeAliasDescriptor() {
        return this.typeAliasDescriptor;
    }

    private TypeAliasConstructorDescriptorImpl(StorageManager storageManager2, TypeAliasDescriptor typeAliasDescriptor2, ClassConstructorDescriptor classConstructorDescriptor, TypeAliasConstructorDescriptor typeAliasConstructorDescriptor, Annotations annotations, CallableMemberDescriptor.Kind kind, SourceElement sourceElement) {
        super(typeAliasDescriptor2, typeAliasConstructorDescriptor, annotations, SpecialNames.INIT, kind, sourceElement);
        this.storageManager = storageManager2;
        this.typeAliasDescriptor = typeAliasDescriptor2;
        setActual(getTypeAliasDescriptor().isActual());
        this.withDispatchReceiver$delegate = storageManager2.createNullableLazyValue(new TypeAliasConstructorDescriptorImpl$withDispatchReceiver$2(this, classConstructorDescriptor));
        this.underlyingConstructorDescriptor = classConstructorDescriptor;
    }

    public ClassConstructorDescriptor getUnderlyingConstructorDescriptor() {
        return this.underlyingConstructorDescriptor;
    }

    public boolean isPrimary() {
        return getUnderlyingConstructorDescriptor().isPrimary();
    }

    public TypeAliasDescriptor getContainingDeclaration() {
        return getTypeAliasDescriptor();
    }

    public ClassDescriptor getConstructedClass() {
        ClassDescriptor constructedClass = getUnderlyingConstructorDescriptor().getConstructedClass();
        Intrinsics.checkNotNullExpressionValue(constructedClass, "underlyingConstructorDescriptor.constructedClass");
        return constructedClass;
    }

    public KotlinType getReturnType() {
        KotlinType returnType = super.getReturnType();
        Intrinsics.checkNotNull(returnType);
        return returnType;
    }

    public TypeAliasConstructorDescriptor getOriginal() {
        FunctionDescriptor original = super.getOriginal();
        Intrinsics.checkNotNull(original, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (TypeAliasConstructorDescriptor) original;
    }

    public TypeAliasConstructorDescriptor substitute(TypeSubstitutor typeSubstitutor) {
        Intrinsics.checkNotNullParameter(typeSubstitutor, "substitutor");
        FunctionDescriptor substitute = super.substitute(typeSubstitutor);
        Intrinsics.checkNotNull(substitute, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl = (TypeAliasConstructorDescriptorImpl) substitute;
        TypeSubstitutor create = TypeSubstitutor.create(typeAliasConstructorDescriptorImpl.getReturnType());
        Intrinsics.checkNotNullExpressionValue(create, "create(substitutedTypeAliasConstructor.returnType)");
        ClassConstructorDescriptor substitute2 = getUnderlyingConstructorDescriptor().getOriginal().substitute(create);
        if (substitute2 == null) {
            return null;
        }
        typeAliasConstructorDescriptorImpl.underlyingConstructorDescriptor = substitute2;
        return typeAliasConstructorDescriptorImpl;
    }

    public TypeAliasConstructorDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility descriptorVisibility, CallableMemberDescriptor.Kind kind, boolean z) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics.checkNotNullParameter(modality, "modality");
        Intrinsics.checkNotNullParameter(descriptorVisibility, "visibility");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Object build = newCopyBuilder().setOwner(declarationDescriptor).setModality(modality).setVisibility(descriptorVisibility).setKind(kind).setCopyOverrides(z).build();
        Intrinsics.checkNotNull(build, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (TypeAliasConstructorDescriptor) build;
    }

    /* access modifiers changed from: protected */
    public TypeAliasConstructorDescriptorImpl createSubstitutedCopy(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(sourceElement, "source");
        if (kind != CallableMemberDescriptor.Kind.DECLARATION) {
            CallableMemberDescriptor.Kind kind2 = CallableMemberDescriptor.Kind.SYNTHESIZED;
        }
        return new TypeAliasConstructorDescriptorImpl(this.storageManager, getTypeAliasDescriptor(), getUnderlyingConstructorDescriptor(), this, annotations, CallableMemberDescriptor.Kind.DECLARATION, sourceElement);
    }

    /* compiled from: TypeAliasConstructorDescriptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final TypeSubstitutor getTypeSubstitutorForUnderlyingClass(TypeAliasDescriptor typeAliasDescriptor) {
            if (typeAliasDescriptor.getClassDescriptor() == null) {
                return null;
            }
            return TypeSubstitutor.create((KotlinType) typeAliasDescriptor.getExpandedType());
        }

        public final TypeAliasConstructorDescriptor createIfAvailable(StorageManager storageManager, TypeAliasDescriptor typeAliasDescriptor, ClassConstructorDescriptor classConstructorDescriptor) {
            ClassConstructorDescriptor substitute;
            List list;
            TypeAliasDescriptor typeAliasDescriptor2 = typeAliasDescriptor;
            ClassConstructorDescriptor classConstructorDescriptor2 = classConstructorDescriptor;
            Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            Intrinsics.checkNotNullParameter(typeAliasDescriptor2, "typeAliasDescriptor");
            Intrinsics.checkNotNullParameter(classConstructorDescriptor2, "constructor");
            TypeSubstitutor typeSubstitutorForUnderlyingClass = getTypeSubstitutorForUnderlyingClass(typeAliasDescriptor2);
            ReceiverParameterDescriptor receiverParameterDescriptor = null;
            if (typeSubstitutorForUnderlyingClass == null || (substitute = classConstructorDescriptor2.substitute(typeSubstitutorForUnderlyingClass)) == null) {
                return null;
            }
            Annotations annotations = classConstructorDescriptor.getAnnotations();
            CallableMemberDescriptor.Kind kind = classConstructorDescriptor.getKind();
            Intrinsics.checkNotNullExpressionValue(kind, "constructor.kind");
            SourceElement source = typeAliasDescriptor.getSource();
            Intrinsics.checkNotNullExpressionValue(source, "typeAliasDescriptor.source");
            TypeAliasConstructorDescriptorImpl typeAliasConstructorDescriptorImpl = new TypeAliasConstructorDescriptorImpl(storageManager, typeAliasDescriptor, substitute, (TypeAliasConstructorDescriptor) null, annotations, kind, source, (DefaultConstructorMarker) null);
            List<ValueParameterDescriptor> substitutedValueParameters = FunctionDescriptorImpl.getSubstitutedValueParameters(typeAliasConstructorDescriptorImpl, classConstructorDescriptor.getValueParameters(), typeSubstitutorForUnderlyingClass);
            if (substitutedValueParameters == null) {
                return null;
            }
            SimpleType lowerIfFlexible = FlexibleTypesKt.lowerIfFlexible(substitute.getReturnType().unwrap());
            SimpleType defaultType = typeAliasDescriptor.getDefaultType();
            Intrinsics.checkNotNullExpressionValue(defaultType, "typeAliasDescriptor.defaultType");
            SimpleType withAbbreviation = SpecialTypesKt.withAbbreviation(lowerIfFlexible, defaultType);
            ReceiverParameterDescriptor dispatchReceiverParameter = classConstructorDescriptor.getDispatchReceiverParameter();
            if (dispatchReceiverParameter != null) {
                receiverParameterDescriptor = DescriptorFactory.createExtensionReceiverParameterForCallable(typeAliasConstructorDescriptorImpl, typeSubstitutorForUnderlyingClass.safeSubstitute(dispatchReceiverParameter.getType(), Variance.INVARIANT), Annotations.Companion.getEMPTY());
            }
            ReceiverParameterDescriptor receiverParameterDescriptor2 = receiverParameterDescriptor;
            ClassDescriptor classDescriptor = typeAliasDescriptor.getClassDescriptor();
            if (classDescriptor != null) {
                List<ReceiverParameterDescriptor> contextReceiverParameters = classConstructorDescriptor.getContextReceiverParameters();
                Intrinsics.checkNotNullExpressionValue(contextReceiverParameters, "constructor.contextReceiverParameters");
                Iterable<ReceiverParameterDescriptor> iterable = contextReceiverParameters;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (ReceiverParameterDescriptor type : iterable) {
                    arrayList.add(DescriptorFactory.createContextReceiverParameterForClass(classDescriptor, typeSubstitutorForUnderlyingClass.safeSubstitute(type.getType(), Variance.INVARIANT), Annotations.Companion.getEMPTY()));
                }
                list = (List) arrayList;
            } else {
                list = CollectionsKt.emptyList();
            }
            typeAliasConstructorDescriptorImpl.initialize(receiverParameterDescriptor2, (ReceiverParameterDescriptor) null, list, typeAliasDescriptor.getDeclaredTypeParameters(), substitutedValueParameters, withAbbreviation, Modality.FINAL, typeAliasDescriptor.getVisibility());
            return typeAliasConstructorDescriptorImpl;
        }
    }
}
