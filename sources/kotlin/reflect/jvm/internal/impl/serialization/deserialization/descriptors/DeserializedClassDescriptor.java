package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.sentry.protocol.SentryStackFrame;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DeserializedDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.MultiFieldValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ReceiverParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.CliSealedClassInheritorsProvider;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ContextClassReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlagsUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: DeserializedClassDescriptor.kt */
public final class DeserializedClassDescriptor extends AbstractClassDescriptor implements DeserializedDescriptor {
    private final Annotations annotations;
    private final DeserializationContext c;
    /* access modifiers changed from: private */
    public final ClassId classId;
    private final ProtoBuf.Class classProto;
    private final NullableLazyValue<ClassDescriptor> companionObjectDescriptor;
    private final NotNullLazyValue<Collection<ClassConstructorDescriptor>> constructors;
    private final DeclarationDescriptor containingDeclaration;
    /* access modifiers changed from: private */
    public final EnumEntryClassDescriptors enumEntries;
    private final ClassKind kind;
    private final ScopesHolderForClass<DeserializedClassMemberScope> memberScopeHolder;
    private final BinaryVersion metadataVersion;
    private final Modality modality;
    private final NullableLazyValue<ClassConstructorDescriptor> primaryConstructor;
    private final NotNullLazyValue<Collection<ClassDescriptor>> sealedSubclasses;
    private final SourceElement sourceElement;
    private final MemberScopeImpl staticScope;
    private final ProtoContainer.Class thisAsProtoContainer;
    /* access modifiers changed from: private */
    public final DeserializedClassTypeConstructor typeConstructor;
    private final NullableLazyValue<ValueClassRepresentation<SimpleType>> valueClassRepresentation;
    private final DescriptorVisibility visibility;

    public boolean isActual() {
        return false;
    }

    public final ProtoBuf.Class getClassProto() {
        return this.classProto;
    }

    public final BinaryVersion getMetadataVersion() {
        return this.metadataVersion;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor(DeserializationContext deserializationContext, ProtoBuf.Class classR, NameResolver nameResolver, BinaryVersion binaryVersion, SourceElement sourceElement2) {
        super(deserializationContext.getStorageManager(), NameResolverUtilKt.getClassId(nameResolver, classR.getFqName()).getShortClassName());
        Annotations annotations2;
        Intrinsics.checkNotNullParameter(deserializationContext, "outerContext");
        Intrinsics.checkNotNullParameter(classR, "classProto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(binaryVersion, "metadataVersion");
        Intrinsics.checkNotNullParameter(sourceElement2, "sourceElement");
        this.classProto = classR;
        this.metadataVersion = binaryVersion;
        this.sourceElement = sourceElement2;
        this.classId = NameResolverUtilKt.getClassId(nameResolver, classR.getFqName());
        this.modality = ProtoEnumFlags.INSTANCE.modality(Flags.MODALITY.get(classR.getFlags()));
        this.visibility = ProtoEnumFlagsUtilsKt.descriptorVisibility(ProtoEnumFlags.INSTANCE, Flags.VISIBILITY.get(classR.getFlags()));
        ClassKind classKind = ProtoEnumFlags.INSTANCE.classKind(Flags.CLASS_KIND.get(classR.getFlags()));
        this.kind = classKind;
        List<ProtoBuf.TypeParameter> typeParameterList = classR.getTypeParameterList();
        Intrinsics.checkNotNullExpressionValue(typeParameterList, "classProto.typeParameterList");
        ProtoBuf.TypeTable typeTable = classR.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(typeTable, "classProto.typeTable");
        TypeTable typeTable2 = new TypeTable(typeTable);
        VersionRequirementTable.Companion companion = VersionRequirementTable.Companion;
        ProtoBuf.VersionRequirementTable versionRequirementTable = classR.getVersionRequirementTable();
        Intrinsics.checkNotNullExpressionValue(versionRequirementTable, "classProto.versionRequirementTable");
        DeserializationContext childContext = deserializationContext.childContext(this, typeParameterList, nameResolver, typeTable2, companion.create(versionRequirementTable), binaryVersion);
        this.c = childContext;
        this.staticScope = classKind == ClassKind.ENUM_CLASS ? new StaticScopeForKotlinEnum(childContext.getStorageManager(), this) : MemberScope.Empty.INSTANCE;
        this.typeConstructor = new DeserializedClassTypeConstructor();
        this.memberScopeHolder = ScopesHolderForClass.Companion.create(this, childContext.getStorageManager(), childContext.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner(), new DeserializedClassDescriptor$memberScopeHolder$1(this));
        ProtoContainer.Class classR2 = null;
        this.enumEntries = classKind == ClassKind.ENUM_CLASS ? new EnumEntryClassDescriptors() : null;
        DeclarationDescriptor containingDeclaration2 = deserializationContext.getContainingDeclaration();
        this.containingDeclaration = containingDeclaration2;
        this.primaryConstructor = childContext.getStorageManager().createNullableLazyValue(new DeserializedClassDescriptor$primaryConstructor$1(this));
        this.constructors = childContext.getStorageManager().createLazyValue(new DeserializedClassDescriptor$constructors$1(this));
        this.companionObjectDescriptor = childContext.getStorageManager().createNullableLazyValue(new DeserializedClassDescriptor$companionObjectDescriptor$1(this));
        this.sealedSubclasses = childContext.getStorageManager().createLazyValue(new DeserializedClassDescriptor$sealedSubclasses$1(this));
        this.valueClassRepresentation = childContext.getStorageManager().createNullableLazyValue(new DeserializedClassDescriptor$valueClassRepresentation$1(this));
        NameResolver nameResolver2 = childContext.getNameResolver();
        TypeTable typeTable3 = childContext.getTypeTable();
        DeserializedClassDescriptor deserializedClassDescriptor = containingDeclaration2 instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) containingDeclaration2 : null;
        this.thisAsProtoContainer = new ProtoContainer.Class(classR, nameResolver2, typeTable3, sourceElement2, deserializedClassDescriptor != null ? deserializedClassDescriptor.thisAsProtoContainer : classR2);
        if (!Flags.HAS_ANNOTATIONS.get(classR.getFlags()).booleanValue()) {
            annotations2 = Annotations.Companion.getEMPTY();
        } else {
            annotations2 = new NonEmptyDeserializedAnnotations(childContext.getStorageManager(), new DeserializedClassDescriptor$annotations$1(this));
        }
        this.annotations = annotations2;
    }

    public final DeserializationContext getC() {
        return this.c;
    }

    private final DeserializedClassMemberScope getMemberScope() {
        return this.memberScopeHolder.getScope(this.c.getComponents().getKotlinTypeChecker().getKotlinTypeRefiner());
    }

    public final ProtoContainer.Class getThisAsProtoContainer$deserialization() {
        return this.thisAsProtoContainer;
    }

    public Annotations getAnnotations() {
        return this.annotations;
    }

    public DeclarationDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    public ClassKind getKind() {
        return this.kind;
    }

    public Modality getModality() {
        return this.modality;
    }

    public DescriptorVisibility getVisibility() {
        return this.visibility;
    }

    public boolean isInner() {
        Boolean bool = Flags.IS_INNER.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_INNER.get(classProto.flags)");
        return bool.booleanValue();
    }

    public boolean isData() {
        Boolean bool = Flags.IS_DATA.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_DATA.get(classProto.flags)");
        return bool.booleanValue();
    }

    public boolean isInline() {
        Boolean bool = Flags.IS_VALUE_CLASS.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_VALUE_CLASS.get(classProto.flags)");
        return bool.booleanValue() && this.metadataVersion.isAtMost(1, 4, 1);
    }

    public boolean isExpect() {
        Boolean bool = Flags.IS_EXPECT_CLASS.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_EXPECT_CLASS.get(classProto.flags)");
        return bool.booleanValue();
    }

    public boolean isExternal() {
        Boolean bool = Flags.IS_EXTERNAL_CLASS.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_EXTERNAL_CLASS.get(classProto.flags)");
        return bool.booleanValue();
    }

    public boolean isFun() {
        Boolean bool = Flags.IS_FUN_INTERFACE.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_FUN_INTERFACE.get(classProto.flags)");
        return bool.booleanValue();
    }

    public boolean isValue() {
        Boolean bool = Flags.IS_VALUE_CLASS.get(this.classProto.getFlags());
        Intrinsics.checkNotNullExpressionValue(bool, "IS_VALUE_CLASS.get(classProto.flags)");
        return bool.booleanValue() && this.metadataVersion.isAtLeast(1, 4, 2);
    }

    /* access modifiers changed from: protected */
    public MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.memberScopeHolder.getScope(kotlinTypeRefiner);
    }

    public MemberScopeImpl getStaticScope() {
        return this.staticScope;
    }

    public boolean isCompanionObject() {
        return Flags.CLASS_KIND.get(this.classProto.getFlags()) == ProtoBuf.Class.Kind.COMPANION_OBJECT;
    }

    /* access modifiers changed from: private */
    public final ClassConstructorDescriptor computePrimaryConstructor() {
        Object obj;
        if (this.kind.isSingleton()) {
            ClassConstructorDescriptorImpl createPrimaryConstructorForObject = DescriptorFactory.createPrimaryConstructorForObject(this, SourceElement.NO_SOURCE);
            createPrimaryConstructorForObject.setReturnType(getDefaultType());
            return createPrimaryConstructorForObject;
        }
        List<ProtoBuf.Constructor> constructorList = this.classProto.getConstructorList();
        Intrinsics.checkNotNullExpressionValue(constructorList, "classProto.constructorList");
        Iterator it = constructorList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!Flags.IS_SECONDARY.get(((ProtoBuf.Constructor) obj).getFlags()).booleanValue()) {
                break;
            }
        }
        ProtoBuf.Constructor constructor = (ProtoBuf.Constructor) obj;
        if (constructor != null) {
            return this.c.getMemberDeserializer().loadConstructor(constructor, true);
        }
        return null;
    }

    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return (ClassConstructorDescriptor) this.primaryConstructor.invoke();
    }

    /* access modifiers changed from: private */
    public final Collection<ClassConstructorDescriptor> computeConstructors() {
        return CollectionsKt.plus(CollectionsKt.plus(computeSecondaryConstructors(), CollectionsKt.listOfNotNull(getUnsubstitutedPrimaryConstructor())), this.c.getComponents().getAdditionalClassPartsProvider().getConstructors(this));
    }

    private final List<ClassConstructorDescriptor> computeSecondaryConstructors() {
        List<ProtoBuf.Constructor> constructorList = this.classProto.getConstructorList();
        Intrinsics.checkNotNullExpressionValue(constructorList, "classProto.constructorList");
        Collection arrayList = new ArrayList();
        for (Object next : constructorList) {
            Boolean bool = Flags.IS_SECONDARY.get(((ProtoBuf.Constructor) next).getFlags());
            Intrinsics.checkNotNullExpressionValue(bool, "IS_SECONDARY.get(it.flags)");
            if (bool.booleanValue()) {
                arrayList.add(next);
            }
        }
        Iterable<ProtoBuf.Constructor> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Constructor constructor : iterable) {
            MemberDeserializer memberDeserializer = this.c.getMemberDeserializer();
            Intrinsics.checkNotNullExpressionValue(constructor, "it");
            arrayList2.add(memberDeserializer.loadConstructor(constructor, false));
        }
        return (List) arrayList2;
    }

    public Collection<ClassConstructorDescriptor> getConstructors() {
        return (Collection) this.constructors.invoke();
    }

    public List<ReceiverParameterDescriptor> getContextReceivers() {
        List<ProtoBuf.Type> contextReceiverTypeList = this.classProto.getContextReceiverTypeList();
        Intrinsics.checkNotNullExpressionValue(contextReceiverTypeList, "classProto.contextReceiverTypeList");
        Iterable<ProtoBuf.Type> iterable = contextReceiverTypeList;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Type type : iterable) {
            TypeDeserializer typeDeserializer = this.c.getTypeDeserializer();
            Intrinsics.checkNotNullExpressionValue(type, "it");
            arrayList.add(new ReceiverParameterDescriptorImpl(getThisAsReceiverParameter(), new ContextClassReceiver(this, typeDeserializer.type(type), (ReceiverValue) null), Annotations.Companion.getEMPTY()));
        }
        return (List) arrayList;
    }

    /* access modifiers changed from: private */
    public final ClassDescriptor computeCompanionObjectDescriptor() {
        if (!this.classProto.hasCompanionObjectName()) {
            return null;
        }
        ClassifierDescriptor contributedClassifier = getMemberScope().getContributedClassifier(NameResolverUtilKt.getName(this.c.getNameResolver(), this.classProto.getCompanionObjectName()), NoLookupLocation.FROM_DESERIALIZATION);
        if (contributedClassifier instanceof ClassDescriptor) {
            return (ClassDescriptor) contributedClassifier;
        }
        return null;
    }

    public ClassDescriptor getCompanionObjectDescriptor() {
        return (ClassDescriptor) this.companionObjectDescriptor.invoke();
    }

    public final boolean hasNestedClass$deserialization(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getMemberScope().getClassNames$deserialization().contains(name);
    }

    /* access modifiers changed from: private */
    public final Collection<ClassDescriptor> computeSubclassesForSealedClass() {
        if (this.modality != Modality.SEALED) {
            return CollectionsKt.emptyList();
        }
        List<Integer> sealedSubclassFqNameList = this.classProto.getSealedSubclassFqNameList();
        Intrinsics.checkNotNullExpressionValue(sealedSubclassFqNameList, "fqNames");
        if (!(!sealedSubclassFqNameList.isEmpty())) {
            return CliSealedClassInheritorsProvider.INSTANCE.computeSealedSubclasses(this, false);
        }
        Collection arrayList = new ArrayList();
        for (Integer num : sealedSubclassFqNameList) {
            DeserializationComponents components = this.c.getComponents();
            NameResolver nameResolver = this.c.getNameResolver();
            Intrinsics.checkNotNullExpressionValue(num, FirebaseAnalytics.Param.INDEX);
            ClassDescriptor deserializeClass = components.deserializeClass(NameResolverUtilKt.getClassId(nameResolver, num.intValue()));
            if (deserializeClass != null) {
                arrayList.add(deserializeClass);
            }
        }
        return (List) arrayList;
    }

    public Collection<ClassDescriptor> getSealedSubclasses() {
        return (Collection) this.sealedSubclasses.invoke();
    }

    public ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
        return (ValueClassRepresentation) this.valueClassRepresentation.invoke();
    }

    /* access modifiers changed from: private */
    public final ValueClassRepresentation<SimpleType> computeValueClassRepresentation() {
        InlineClassRepresentation<SimpleType> computeInlineClassRepresentation = computeInlineClassRepresentation();
        MultiFieldValueClassRepresentation<SimpleType> computeMultiFieldValueClassRepresentation = computeMultiFieldValueClassRepresentation();
        if (computeInlineClassRepresentation != null && computeMultiFieldValueClassRepresentation != null) {
            throw new IllegalArgumentException("Class cannot have both inline class representation and multi field class representation: " + this);
        } else if ((!isValue() && !isInline()) || computeInlineClassRepresentation != null || computeMultiFieldValueClassRepresentation != null) {
            return computeInlineClassRepresentation != null ? computeInlineClassRepresentation : computeMultiFieldValueClassRepresentation;
        } else {
            throw new IllegalArgumentException("Value class has no value class representation: " + this);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor} */
    /* JADX WARNING: type inference failed for: r1v10, types: [kotlin.reflect.jvm.internal.impl.types.KotlinType, java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation<kotlin.reflect.jvm.internal.impl.types.SimpleType> computeInlineClassRepresentation() {
        /*
            r9 = this;
            boolean r0 = r9.isInline()
            r1 = 0
            if (r0 != 0) goto L_0x000e
            boolean r0 = r9.isValue()
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            boolean r0 = r9.isValue()
            if (r0 == 0) goto L_0x0035
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r9.classProto
            boolean r0 = r0.hasInlineClassUnderlyingPropertyName()
            if (r0 != 0) goto L_0x0035
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r9.classProto
            boolean r0 = r0.hasInlineClassUnderlyingType()
            if (r0 != 0) goto L_0x0035
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r9.classProto
            boolean r0 = r0.hasInlineClassUnderlyingTypeId()
            if (r0 != 0) goto L_0x0035
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r9.classProto
            int r0 = r0.getMultiFieldValueClassUnderlyingNameCount()
            if (r0 <= 0) goto L_0x0035
            return r1
        L_0x0035:
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r9.classProto
            boolean r0 = r0.hasInlineClassUnderlyingPropertyName()
            r2 = 1
            if (r0 == 0) goto L_0x004f
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r0 = r9.c
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r0 = r0.getNameResolver()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r3 = r9.classProto
            int r3 = r3.getInlineClassUnderlyingPropertyName()
            kotlin.reflect.jvm.internal.impl.name.Name r0 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(r0, r3)
            goto L_0x0077
        L_0x004f:
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion r0 = r9.metadataVersion
            r3 = 5
            boolean r0 = r0.isAtLeast(r2, r3, r2)
            if (r0 != 0) goto L_0x011e
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor r0 = r9.getUnsubstitutedPrimaryConstructor()
            if (r0 == 0) goto L_0x0101
            java.util.List r0 = r0.getValueParameters()
            java.lang.String r3 = "constructor.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            java.lang.Object r0 = kotlin.collections.CollectionsKt.first(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r0
            kotlin.reflect.jvm.internal.impl.name.Name r0 = r0.getName()
            java.lang.String r3 = "{\n                // Bef…irst().name\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
        L_0x0077:
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r3 = r9.classProto
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r4 = r9.c
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r4 = r4.getTypeTable()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r3 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt.inlineClassUnderlyingType(r3, r4)
            r4 = 0
            if (r3 == 0) goto L_0x0093
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r5 = r9.c
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer r5 = r5.getTypeDeserializer()
            r6 = 2
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer.simpleType$default(r5, r3, r4, r6, r1)
            if (r3 != 0) goto L_0x00dc
        L_0x0093:
            r3 = r9
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r3 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor) r3
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope r3 = r9.getMemberScope()
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r5 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_DESERIALIZATION
            kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation r5 = (kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation) r5
            java.util.Collection r3 = r3.getContributedVariables(r0, r5)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
            r6 = r1
            r5 = r4
        L_0x00aa:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x00c8
            java.lang.Object r7 = r3.next()
            r8 = r7
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r8 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) r8
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r8 = r8.getExtensionReceiverParameter()
            if (r8 != 0) goto L_0x00bf
            r8 = r2
            goto L_0x00c0
        L_0x00bf:
            r8 = r4
        L_0x00c0:
            if (r8 == 0) goto L_0x00aa
            if (r5 == 0) goto L_0x00c5
            goto L_0x00cc
        L_0x00c5:
            r5 = r2
            r6 = r7
            goto L_0x00aa
        L_0x00c8:
            if (r5 != 0) goto L_0x00cb
            goto L_0x00cc
        L_0x00cb:
            r1 = r6
        L_0x00cc:
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor) r1
            if (r1 == 0) goto L_0x00e4
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r1.getType()
            java.lang.String r2 = "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            r3 = r1
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r3
        L_0x00dc:
            kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation r1 = new kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r3 = (kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r3
            r1.<init>(r0, r3)
            return r1
        L_0x00e4:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Value class has no underlying property: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0101:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Inline class has no primary constructor: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x011e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Inline class has no underlying property name in metadata: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.computeInlineClassRepresentation():kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation");
    }

    private final MultiFieldValueClassRepresentation<SimpleType> computeMultiFieldValueClassRepresentation() {
        List<ProtoBuf.Type> list;
        List<Integer> multiFieldValueClassUnderlyingNameList = this.classProto.getMultiFieldValueClassUnderlyingNameList();
        Intrinsics.checkNotNullExpressionValue(multiFieldValueClassUnderlyingNameList, "classProto.multiFieldValueClassUnderlyingNameList");
        Iterable<Integer> iterable = multiFieldValueClassUnderlyingNameList;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Integer num : iterable) {
            NameResolver nameResolver = this.c.getNameResolver();
            Intrinsics.checkNotNullExpressionValue(num, "it");
            arrayList.add(NameResolverUtilKt.getName(nameResolver, num.intValue()));
        }
        List list2 = (List) arrayList;
        if (!(!list2.isEmpty())) {
            list2 = null;
        }
        if (list2 == null) {
            return null;
        }
        if (isValue()) {
            Pair pair = TuplesKt.to(Integer.valueOf(this.classProto.getMultiFieldValueClassUnderlyingTypeIdCount()), Integer.valueOf(this.classProto.getMultiFieldValueClassUnderlyingTypeCount()));
            if (Intrinsics.areEqual((Object) pair, (Object) TuplesKt.to(Integer.valueOf(list2.size()), 0))) {
                List<Integer> multiFieldValueClassUnderlyingTypeIdList = this.classProto.getMultiFieldValueClassUnderlyingTypeIdList();
                Intrinsics.checkNotNullExpressionValue(multiFieldValueClassUnderlyingTypeIdList, "classProto.multiFieldVal…ClassUnderlyingTypeIdList");
                Iterable<Integer> iterable2 = multiFieldValueClassUnderlyingTypeIdList;
                Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
                for (Integer num2 : iterable2) {
                    TypeTable typeTable = this.c.getTypeTable();
                    Intrinsics.checkNotNullExpressionValue(num2, "it");
                    arrayList2.add(typeTable.get(num2.intValue()));
                }
                list = (List) arrayList2;
            } else if (Intrinsics.areEqual((Object) pair, (Object) TuplesKt.to(0, Integer.valueOf(list2.size())))) {
                list = this.classProto.getMultiFieldValueClassUnderlyingTypeList();
            } else {
                throw new IllegalStateException(("Illegal multi-field value class representation: " + this).toString());
            }
            Intrinsics.checkNotNullExpressionValue(list, "when (typeIdCount to typ…tation: $this\")\n        }");
            Iterable<ProtoBuf.Type> iterable3 = list;
            Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable3, 10));
            for (ProtoBuf.Type type : iterable3) {
                TypeDeserializer typeDeserializer = this.c.getTypeDeserializer();
                Intrinsics.checkNotNullExpressionValue(type, "it");
                arrayList3.add(TypeDeserializer.simpleType$default(typeDeserializer, type, false, 2, (Object) null));
            }
            return new MultiFieldValueClassRepresentation<>(CollectionsKt.zip(list2, (List) arrayList3));
        }
        throw new IllegalArgumentException(("Not a value class: " + this).toString());
    }

    public String toString() {
        return "deserialized " + (isExpect() ? "expect " : "") + "class " + getName();
    }

    public SourceElement getSource() {
        return this.sourceElement;
    }

    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.c.getTypeDeserializer().getOwnTypeParameters();
    }

    /* compiled from: DeserializedClassDescriptor.kt */
    private final class DeserializedClassTypeConstructor extends AbstractClassTypeConstructor {
        private final NotNullLazyValue<List<TypeParameterDescriptor>> parameters;

        public boolean isDenotable() {
            return true;
        }

        public DeserializedClassTypeConstructor() {
            super(DeserializedClassDescriptor.this.getC().getStorageManager());
            this.parameters = DeserializedClassDescriptor.this.getC().getStorageManager().createLazyValue(new DeserializedClassDescriptor$DeserializedClassTypeConstructor$parameters$1(DeserializedClassDescriptor.this));
        }

        /* access modifiers changed from: protected */
        public Collection<KotlinType> computeSupertypes() {
            String str;
            FqName asSingleFqName;
            Iterable<ProtoBuf.Type> supertypes = ProtoTypeTableUtilKt.supertypes(DeserializedClassDescriptor.this.getClassProto(), DeserializedClassDescriptor.this.getC().getTypeTable());
            DeserializedClassDescriptor deserializedClassDescriptor = DeserializedClassDescriptor.this;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(supertypes, 10));
            for (ProtoBuf.Type type : supertypes) {
                arrayList.add(deserializedClassDescriptor.getC().getTypeDeserializer().type(type));
            }
            Iterable<KotlinType> plus = CollectionsKt.plus((List) arrayList, DeserializedClassDescriptor.this.getC().getComponents().getAdditionalClassPartsProvider().getSupertypes(DeserializedClassDescriptor.this));
            Collection arrayList2 = new ArrayList();
            for (KotlinType constructor : plus) {
                ClassifierDescriptor declarationDescriptor = constructor.getConstructor().getDeclarationDescriptor();
                NotFoundClasses.MockClassDescriptor mockClassDescriptor = declarationDescriptor instanceof NotFoundClasses.MockClassDescriptor ? (NotFoundClasses.MockClassDescriptor) declarationDescriptor : null;
                if (mockClassDescriptor != null) {
                    arrayList2.add(mockClassDescriptor);
                }
            }
            List list = (List) arrayList2;
            if (!list.isEmpty()) {
                ErrorReporter errorReporter = DeserializedClassDescriptor.this.getC().getComponents().getErrorReporter();
                ClassDescriptor classDescriptor = DeserializedClassDescriptor.this;
                Iterable<NotFoundClasses.MockClassDescriptor> iterable = list;
                Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (NotFoundClasses.MockClassDescriptor mockClassDescriptor2 : iterable) {
                    ClassId classId = DescriptorUtilsKt.getClassId(mockClassDescriptor2);
                    if (classId == null || (asSingleFqName = classId.asSingleFqName()) == null || (str = asSingleFqName.asString()) == null) {
                        str = mockClassDescriptor2.getName().asString();
                    }
                    arrayList3.add(str);
                }
                errorReporter.reportIncompleteHierarchy(classDescriptor, (List) arrayList3);
            }
            return CollectionsKt.toList(plus);
        }

        public List<TypeParameterDescriptor> getParameters() {
            return (List) this.parameters.invoke();
        }

        public DeserializedClassDescriptor getDeclarationDescriptor() {
            return DeserializedClassDescriptor.this;
        }

        public String toString() {
            String name = DeserializedClassDescriptor.this.getName().toString();
            Intrinsics.checkNotNullExpressionValue(name, "name.toString()");
            return name;
        }

        /* access modifiers changed from: protected */
        public SupertypeLoopChecker getSupertypeLoopChecker() {
            return SupertypeLoopChecker.EMPTY.INSTANCE;
        }
    }

    /* compiled from: DeserializedClassDescriptor.kt */
    private final class DeserializedClassMemberScope extends DeserializedMemberScope {
        private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;
        /* access modifiers changed from: private */
        public final KotlinTypeRefiner kotlinTypeRefiner;
        private final NotNullLazyValue<Collection<KotlinType>> refinedSupertypes;
        final /* synthetic */ DeserializedClassDescriptor this$0;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public DeserializedClassMemberScope(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r8, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner r9) {
            /*
                r7 = this;
                java.lang.String r0 = "kotlinTypeRefiner"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                r7.this$0 = r8
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r2 = r8.getC()
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.getClassProto()
                java.util.List r3 = r0.getFunctionList()
                java.lang.String r0 = "classProto.functionList"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.getClassProto()
                java.util.List r4 = r0.getPropertyList()
                java.lang.String r0 = "classProto.propertyList"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.getClassProto()
                java.util.List r5 = r0.getTypeAliasList()
                java.lang.String r0 = "classProto.typeAliasList"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.getClassProto()
                java.util.List r0 = r0.getNestedClassNameList()
                java.lang.String r1 = "classProto.nestedClassNameList"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r8 = r8.getC()
                kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r8 = r8.getNameResolver()
                java.util.ArrayList r1 = new java.util.ArrayList
                r6 = 10
                int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r6)
                r1.<init>(r6)
                java.util.Collection r1 = (java.util.Collection) r1
                java.util.Iterator r0 = r0.iterator()
            L_0x005a:
                boolean r6 = r0.hasNext()
                if (r6 == 0) goto L_0x0072
                java.lang.Object r6 = r0.next()
                java.lang.Number r6 = (java.lang.Number) r6
                int r6 = r6.intValue()
                kotlin.reflect.jvm.internal.impl.name.Name r6 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(r8, r6)
                r1.add(r6)
                goto L_0x005a
            L_0x0072:
                java.util.List r1 = (java.util.List) r1
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$2$1 r8 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$2$1
                r8.<init>(r1)
                r6 = r8
                kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
                r1 = r7
                r1.<init>(r2, r3, r4, r5, r6)
                r7.kotlinTypeRefiner = r9
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r8 = r7.getC()
                kotlin.reflect.jvm.internal.impl.storage.StorageManager r8 = r8.getStorageManager()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1 r9 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$allDescriptors$1
                r9.<init>(r7)
                kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
                kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r8 = r8.createLazyValue(r9)
                r7.allDescriptors = r8
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r8 = r7.getC()
                kotlin.reflect.jvm.internal.impl.storage.StorageManager r8 = r8.getStorageManager()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1 r9 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor$DeserializedClassMemberScope$refinedSupertypes$1
                r9.<init>(r7)
                kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
                kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue r8 = r8.createLazyValue(r9)
                r7.refinedSupertypes = r8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.DeserializedClassMemberScope.<init>(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor, kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner):void");
        }

        /* access modifiers changed from: private */
        public final DeserializedClassDescriptor getClassDescriptor() {
            return this.this$0;
        }

        public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
            Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
            Intrinsics.checkNotNullParameter(function1, "nameFilter");
            return (Collection) this.allDescriptors.invoke();
        }

        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
            recordLookup(name, lookupLocation);
            return super.getContributedFunctions(name, lookupLocation);
        }

        public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
            recordLookup(name, lookupLocation);
            return super.getContributedVariables(name, lookupLocation);
        }

        /* access modifiers changed from: protected */
        public boolean isDeclaredFunctionAvailable(SimpleFunctionDescriptor simpleFunctionDescriptor) {
            Intrinsics.checkNotNullParameter(simpleFunctionDescriptor, SentryStackFrame.JsonKeys.FUNCTION);
            return getC().getComponents().getPlatformDependentDeclarationFilter().isFunctionAvailable(this.this$0, simpleFunctionDescriptor);
        }

        /* access modifiers changed from: protected */
        public void computeNonDeclaredFunctions(Name name, List<SimpleFunctionDescriptor> list) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(list, "functions");
            ArrayList arrayList = new ArrayList();
            for (KotlinType memberScope : (Collection) this.refinedSupertypes.invoke()) {
                arrayList.addAll(memberScope.getMemberScope().getContributedFunctions(name, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            list.addAll(getC().getComponents().getAdditionalClassPartsProvider().getFunctions(name, this.this$0));
            generateFakeOverrides(name, arrayList, list);
        }

        /* access modifiers changed from: protected */
        public void computeNonDeclaredProperties(Name name, List<PropertyDescriptor> list) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(list, "descriptors");
            ArrayList arrayList = new ArrayList();
            for (KotlinType memberScope : (Collection) this.refinedSupertypes.invoke()) {
                arrayList.addAll(memberScope.getMemberScope().getContributedVariables(name, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            generateFakeOverrides(name, arrayList, list);
        }

        private final <D extends CallableMemberDescriptor> void generateFakeOverrides(Name name, Collection<? extends D> collection, List<D> list) {
            Name name2 = name;
            Collection<? extends D> collection2 = collection;
            getC().getComponents().getKotlinTypeChecker().getOverridingUtil().generateOverridesInFunctionGroup(name2, collection2, new ArrayList(list), getClassDescriptor(), new DeserializedClassDescriptor$DeserializedClassMemberScope$generateFakeOverrides$1(list));
        }

        /* access modifiers changed from: protected */
        public Set<Name> getNonDeclaredFunctionNames() {
            Collection linkedHashSet = new LinkedHashSet();
            for (KotlinType memberScope : getClassDescriptor().typeConstructor.getSupertypes()) {
                CollectionsKt.addAll(linkedHashSet, memberScope.getMemberScope().getFunctionNames());
            }
            ((LinkedHashSet) linkedHashSet).addAll(getC().getComponents().getAdditionalClassPartsProvider().getFunctionsNames(this.this$0));
            return (Set) linkedHashSet;
        }

        /* access modifiers changed from: protected */
        public Set<Name> getNonDeclaredVariableNames() {
            Collection linkedHashSet = new LinkedHashSet();
            for (KotlinType memberScope : getClassDescriptor().typeConstructor.getSupertypes()) {
                CollectionsKt.addAll(linkedHashSet, memberScope.getMemberScope().getVariableNames());
            }
            return (Set) linkedHashSet;
        }

        /* access modifiers changed from: protected */
        public Set<Name> getNonDeclaredClassifierNames() {
            Collection linkedHashSet = new LinkedHashSet();
            Iterator it = getClassDescriptor().typeConstructor.getSupertypes().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Iterable classifierNames = ((KotlinType) it.next()).getMemberScope().getClassifierNames();
                if (classifierNames == null) {
                    linkedHashSet = null;
                    break;
                }
                CollectionsKt.addAll(linkedHashSet, classifierNames);
            }
            return (Set) linkedHashSet;
        }

        public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
            ClassDescriptor findEnumEntry;
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
            recordLookup(name, lookupLocation);
            EnumEntryClassDescriptors access$getEnumEntries$p = getClassDescriptor().enumEntries;
            if (access$getEnumEntries$p == null || (findEnumEntry = access$getEnumEntries$p.findEnumEntry(name)) == null) {
                return super.getContributedClassifier(name, lookupLocation);
            }
            return findEnumEntry;
        }

        /* access modifiers changed from: protected */
        public ClassId createClassId(Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            ClassId createNestedClassId = this.this$0.classId.createNestedClassId(name);
            Intrinsics.checkNotNullExpressionValue(createNestedClassId, "classId.createNestedClassId(name)");
            return createNestedClassId;
        }

        /* access modifiers changed from: protected */
        public void addEnumEntryDescriptors(Collection<DeclarationDescriptor> collection, Function1<? super Name, Boolean> function1) {
            Intrinsics.checkNotNullParameter(collection, "result");
            Intrinsics.checkNotNullParameter(function1, "nameFilter");
            EnumEntryClassDescriptors access$getEnumEntries$p = getClassDescriptor().enumEntries;
            Collection<ClassDescriptor> all = access$getEnumEntries$p != null ? access$getEnumEntries$p.all() : null;
            if (all == null) {
                all = CollectionsKt.emptyList();
            }
            collection.addAll(all);
        }

        public void recordLookup(Name name, LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
            UtilsKt.record(getC().getComponents().getLookupTracker(), lookupLocation, (ClassDescriptor) getClassDescriptor(), name);
        }
    }

    /* compiled from: DeserializedClassDescriptor.kt */
    private final class EnumEntryClassDescriptors {
        private final MemoizedFunctionToNullable<Name, ClassDescriptor> enumEntryByName;
        /* access modifiers changed from: private */
        public final Map<Name, ProtoBuf.EnumEntry> enumEntryProtos;
        /* access modifiers changed from: private */
        public final NotNullLazyValue<Set<Name>> enumMemberNames;

        public EnumEntryClassDescriptors() {
            List<ProtoBuf.EnumEntry> enumEntryList = DeserializedClassDescriptor.this.getClassProto().getEnumEntryList();
            Intrinsics.checkNotNullExpressionValue(enumEntryList, "classProto.enumEntryList");
            Iterable iterable = enumEntryList;
            Map<Name, ProtoBuf.EnumEntry> linkedHashMap = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
            for (Object next : iterable) {
                linkedHashMap.put(NameResolverUtilKt.getName(DeserializedClassDescriptor.this.getC().getNameResolver(), ((ProtoBuf.EnumEntry) next).getName()), next);
            }
            this.enumEntryProtos = linkedHashMap;
            this.enumEntryByName = DeserializedClassDescriptor.this.getC().getStorageManager().createMemoizedFunctionWithNullableValues(new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumEntryByName$1(this, DeserializedClassDescriptor.this));
            this.enumMemberNames = DeserializedClassDescriptor.this.getC().getStorageManager().createLazyValue(new DeserializedClassDescriptor$EnumEntryClassDescriptors$enumMemberNames$1(this));
        }

        public final ClassDescriptor findEnumEntry(Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return this.enumEntryByName.invoke(name);
        }

        /* access modifiers changed from: private */
        public final Set<Name> computeEnumMemberNames() {
            HashSet hashSet = new HashSet();
            for (KotlinType memberScope : DeserializedClassDescriptor.this.getTypeConstructor().getSupertypes()) {
                for (DeclarationDescriptor declarationDescriptor : ResolutionScope.DefaultImpls.getContributedDescriptors$default(memberScope.getMemberScope(), (DescriptorKindFilter) null, (Function1) null, 3, (Object) null)) {
                    if ((declarationDescriptor instanceof SimpleFunctionDescriptor) || (declarationDescriptor instanceof PropertyDescriptor)) {
                        hashSet.add(declarationDescriptor.getName());
                    }
                }
            }
            List<ProtoBuf.Function> functionList = DeserializedClassDescriptor.this.getClassProto().getFunctionList();
            Intrinsics.checkNotNullExpressionValue(functionList, "classProto.functionList");
            DeserializedClassDescriptor deserializedClassDescriptor = DeserializedClassDescriptor.this;
            for (ProtoBuf.Function name : functionList) {
                hashSet.add(NameResolverUtilKt.getName(deserializedClassDescriptor.getC().getNameResolver(), name.getName()));
            }
            Collection collection = hashSet;
            Set set = (Set) collection;
            List<ProtoBuf.Property> propertyList = DeserializedClassDescriptor.this.getClassProto().getPropertyList();
            Intrinsics.checkNotNullExpressionValue(propertyList, "classProto.propertyList");
            DeserializedClassDescriptor deserializedClassDescriptor2 = DeserializedClassDescriptor.this;
            for (ProtoBuf.Property name2 : propertyList) {
                collection.add(NameResolverUtilKt.getName(deserializedClassDescriptor2.getC().getNameResolver(), name2.getName()));
            }
            return SetsKt.plus(set, collection);
        }

        public final Collection<ClassDescriptor> all() {
            Collection arrayList = new ArrayList();
            for (Name findEnumEntry : this.enumEntryProtos.keySet()) {
                ClassDescriptor findEnumEntry2 = findEnumEntry(findEnumEntry);
                if (findEnumEntry2 != null) {
                    arrayList.add(findEnumEntry2);
                }
            }
            return (List) arrayList;
        }
    }
}
