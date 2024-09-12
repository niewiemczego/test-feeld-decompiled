package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilterKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureBuildingUtilsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

/* compiled from: JvmBuiltInsCustomizer.kt */
public final class JvmBuiltInsCustomizer implements AdditionalClassPartsProvider, PlatformDependentDeclarationFilter {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final NotNullLazyValue cloneableType$delegate;
    /* access modifiers changed from: private */
    public final JavaToKotlinClassMapper j2kClassMapper = JavaToKotlinClassMapper.INSTANCE;
    private final CacheWithNotNullValues<FqName, ClassDescriptor> javaAnalogueClassesWithCustomSupertypeCache;
    private final KotlinType mockSerializableType;
    /* access modifiers changed from: private */
    public final ModuleDescriptor moduleDescriptor;
    private final NotNullLazyValue notConsideredDeprecation$delegate;
    private final NotNullLazyValue settings$delegate;

    /* compiled from: JvmBuiltInsCustomizer.kt */
    private enum JDKMemberStatus {
        HIDDEN,
        VISIBLE,
        NOT_CONSIDERED,
        DROP
    }

    /* compiled from: JvmBuiltInsCustomizer.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JDKMemberStatus.values().length];
            iArr[JDKMemberStatus.HIDDEN.ordinal()] = 1;
            iArr[JDKMemberStatus.NOT_CONSIDERED.ordinal()] = 2;
            iArr[JDKMemberStatus.DROP.ordinal()] = 3;
            iArr[JDKMemberStatus.VISIBLE.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public JvmBuiltInsCustomizer(ModuleDescriptor moduleDescriptor2, StorageManager storageManager, Function0<JvmBuiltIns.Settings> function0) {
        Intrinsics.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(function0, "settingsComputation");
        this.moduleDescriptor = moduleDescriptor2;
        this.settings$delegate = storageManager.createLazyValue(function0);
        this.mockSerializableType = createMockJavaIoSerializableType(storageManager);
        this.cloneableType$delegate = storageManager.createLazyValue(new JvmBuiltInsCustomizer$cloneableType$2(this, storageManager));
        this.javaAnalogueClassesWithCustomSupertypeCache = storageManager.createCacheWithNotNullValues();
        this.notConsideredDeprecation$delegate = storageManager.createLazyValue(new JvmBuiltInsCustomizer$notConsideredDeprecation$2(this));
    }

    static {
        Class<JvmBuiltInsCustomizer> cls = JvmBuiltInsCustomizer.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};
    }

    /* access modifiers changed from: private */
    public final JvmBuiltIns.Settings getSettings() {
        return (JvmBuiltIns.Settings) StorageKt.getValue(this.settings$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final SimpleType getCloneableType() {
        return (SimpleType) StorageKt.getValue(this.cloneableType$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[1]);
    }

    private final Annotations getNotConsideredDeprecation() {
        return (Annotations) StorageKt.getValue(this.notConsideredDeprecation$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[2]);
    }

    private final KotlinType createMockJavaIoSerializableType(StorageManager storageManager) {
        ClassDescriptorImpl classDescriptorImpl = new ClassDescriptorImpl(new JvmBuiltInsCustomizer$createMockJavaIoSerializableType$mockJavaIoPackageFragment$1(this.moduleDescriptor, new FqName("java.io")), Name.identifier("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, CollectionsKt.listOf(new LazyWrappedType(storageManager, new JvmBuiltInsCustomizer$createMockJavaIoSerializableType$superTypes$1(this))), SourceElement.NO_SOURCE, false, storageManager);
        classDescriptorImpl.initialize(MemberScope.Empty.INSTANCE, SetsKt.emptySet(), (ClassConstructorDescriptor) null);
        SimpleType defaultType = classDescriptorImpl.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "mockSerializableClass.defaultType");
        return defaultType;
    }

    public Collection<KotlinType> getSupertypes(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        FqNameUnsafe fqNameUnsafe = DescriptorUtilsKt.getFqNameUnsafe(classDescriptor);
        if (JvmBuiltInsSignatures.INSTANCE.isArrayOrPrimitiveArray(fqNameUnsafe)) {
            SimpleType cloneableType = getCloneableType();
            Intrinsics.checkNotNullExpressionValue(cloneableType, "cloneableType");
            return CollectionsKt.listOf(cloneableType, this.mockSerializableType);
        } else if (JvmBuiltInsSignatures.INSTANCE.isSerializableInJava(fqNameUnsafe)) {
            return CollectionsKt.listOf(this.mockSerializableType);
        } else {
            return CollectionsKt.emptyList();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0116, code lost:
        if (r2 != 3) goto L_0x012b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c3 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getFunctions(kotlin.reflect.jvm.internal.impl.name.Name r7, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r8) {
        /*
            r6 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "classDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope$Companion r0 = kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope.Companion
            kotlin.reflect.jvm.internal.impl.name.Name r0 = r0.getCLONE_NAME()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)
            r1 = 1
            if (r0 == 0) goto L_0x009a
            boolean r0 = r8 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor
            if (r0 == 0) goto L_0x009a
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isArrayOrPrimitiveArray((kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r8)
            if (r0 == 0) goto L_0x009a
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor r8 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor) r8
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.getClassProto()
            java.util.List r0 = r0.getFunctionList()
            java.lang.String r2 = "classDescriptor.classProto.functionList"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r2 = r0 instanceof java.util.Collection
            r3 = 0
            if (r2 == 0) goto L_0x0042
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0042
        L_0x0040:
            r1 = r3
            goto L_0x006e
        L_0x0042:
            java.util.Iterator r0 = r0.iterator()
        L_0x0046:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0040
            java.lang.Object r2 = r0.next()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r2 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) r2
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext r4 = r8.getC()
            kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r4 = r4.getNameResolver()
            int r2 = r2.getName()
            kotlin.reflect.jvm.internal.impl.name.Name r2 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt.getName(r4, r2)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope$Companion r4 = kotlin.reflect.jvm.internal.impl.builtins.jvm.CloneableClassScope.Companion
            kotlin.reflect.jvm.internal.impl.name.Name r4 = r4.getCLONE_NAME()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)
            if (r2 == 0) goto L_0x0046
        L_0x006e:
            if (r1 == 0) goto L_0x0077
            java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()
            java.util.Collection r7 = (java.util.Collection) r7
            return r7
        L_0x0077:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = r6.getCloneableType()
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r0 = r0.getMemberScope()
            kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation r1 = kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation.FROM_BUILTINS
            kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation r1 = (kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation) r1
            java.util.Collection r7 = r0.getContributedFunctions(r7, r1)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.lang.Object r7 = kotlin.collections.CollectionsKt.single(r7)
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r7 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r7
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r7 = r6.createCloneForArray(r8, r7)
            java.util.List r7 = kotlin.collections.CollectionsKt.listOf(r7)
            java.util.Collection r7 = (java.util.Collection) r7
            return r7
        L_0x009a:
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$Settings r0 = r6.getSettings()
            boolean r0 = r0.isAdditionalBuiltInsFeatureSupported()
            if (r0 != 0) goto L_0x00ab
            java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()
            java.util.Collection r7 = (java.util.Collection) r7
            return r7
        L_0x00ab:
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getFunctions$2 r0 = new kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getFunctions$2
            r0.<init>(r7)
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            java.util.Collection r7 = r6.getAdditionalFunctions(r8, r0)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r7 = r7.iterator()
        L_0x00c3:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L_0x013b
            java.lang.Object r2 = r7.next()
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r2
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = r2.getContainingDeclaration()
            java.lang.String r4 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r4)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r3
            kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution r3 = kotlin.reflect.jvm.internal.impl.builtins.jvm.MappingUtilKt.createMappedTypeParametersSubstitution(r3, r8)
            kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor r3 = r3.buildSubstitutor()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r3 = r2.substitute(r3)
            java.lang.String r4 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r4)
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r3
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder r3 = r3.newCopyBuilder()
            r4 = r8
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r4
            r3.setOwner(r4)
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r4 = r8.getThisAsReceiverParameter()
            r3.setDispatchReceiverParameter(r4)
            r3.setPreserveSourceElement()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r2
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$JDKMemberStatus r2 = r6.getJdkMethodStatus(r2)
            int[] r4 = kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.WhenMappings.$EnumSwitchMapping$0
            int r2 = r2.ordinal()
            r2 = r4[r2]
            r4 = 0
            if (r2 == r1) goto L_0x0121
            r5 = 2
            if (r2 == r5) goto L_0x0119
            r5 = 3
            if (r2 == r5) goto L_0x0135
            goto L_0x012b
        L_0x0119:
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r2 = r6.getNotConsideredDeprecation()
            r3.setAdditionalAnnotations(r2)
            goto L_0x012b
        L_0x0121:
            boolean r2 = kotlin.reflect.jvm.internal.impl.descriptors.ModalityUtilsKt.isFinalClass(r8)
            if (r2 == 0) goto L_0x0128
            goto L_0x0135
        L_0x0128:
            r3.setHiddenForResolutionEverywhereBesideSupercalls()
        L_0x012b:
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r2 = r3.build()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r4 = r2
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r4
        L_0x0135:
            if (r4 == 0) goto L_0x00c3
            r0.add(r4)
            goto L_0x00c3
        L_0x013b:
            java.util.List r0 = (java.util.List) r0
            java.util.Collection r0 = (java.util.Collection) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.getFunctions(kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor):java.util.Collection");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        r2 = (r2 = r2.getUnsubstitutedMemberScope()).getFunctionNames();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name> getFunctionsNames(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r2) {
        /*
            r1 = this;
            java.lang.String r0 = "classDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$Settings r0 = r1.getSettings()
            boolean r0 = r0.isAdditionalBuiltInsFeatureSupported()
            if (r0 != 0) goto L_0x0014
            java.util.Set r2 = kotlin.collections.SetsKt.emptySet()
            return r2
        L_0x0014:
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r2 = r1.getJavaAnalogue(r2)
            if (r2 == 0) goto L_0x0026
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope r2 = r2.getUnsubstitutedMemberScope()
            if (r2 == 0) goto L_0x0026
            java.util.Set r2 = r2.getFunctionNames()
            if (r2 != 0) goto L_0x002a
        L_0x0026:
            java.util.Set r2 = kotlin.collections.SetsKt.emptySet()
        L_0x002a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.getFunctionsNames(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor):java.util.Set");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0108, code lost:
        if (isMutabilityViolation(r3, r10) == false) goto L_0x010a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0104  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.Collection<kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor> getAdditionalFunctions(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r10, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, ? extends java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor>> r11) {
        /*
            r9 = this;
            kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor r0 = r9.getJavaAnalogue(r10)
            if (r0 != 0) goto L_0x000d
            java.util.List r10 = kotlin.collections.CollectionsKt.emptyList()
            java.util.Collection r10 = (java.util.Collection) r10
            return r10
        L_0x000d:
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper r1 = r9.j2kClassMapper
            r2 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r2
            kotlin.reflect.jvm.internal.impl.name.FqName r3 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(r2)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.FallbackBuiltIns$Companion r4 = kotlin.reflect.jvm.internal.impl.builtins.jvm.FallbackBuiltIns.Companion
            kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r4 = r4.getInstance()
            java.util.Collection r1 = r1.mapPlatformClass(r3, r4)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.lang.Object r3 = kotlin.collections.CollectionsKt.lastOrNull(r1)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r3
            if (r3 != 0) goto L_0x0031
            java.util.List r10 = kotlin.collections.CollectionsKt.emptyList()
            java.util.Collection r10 = (java.util.Collection) r10
            return r10
        L_0x0031:
            kotlin.reflect.jvm.internal.impl.utils.SmartSet$Companion r4 = kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion
            java.util.ArrayList r5 = new java.util.ArrayList
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r6)
            r5.<init>(r6)
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r1 = r1.iterator()
        L_0x0044:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x005a
            java.lang.Object r6 = r1.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r6
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r6
            kotlin.reflect.jvm.internal.impl.name.FqName r6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(r6)
            r5.add(r6)
            goto L_0x0044
        L_0x005a:
            java.util.List r5 = (java.util.List) r5
            java.util.Collection r5 = (java.util.Collection) r5
            kotlin.reflect.jvm.internal.impl.utils.SmartSet r1 = r4.create(r5)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper r4 = r9.j2kClassMapper
            boolean r10 = r4.isMutable(r10)
            kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues<kotlin.reflect.jvm.internal.impl.name.FqName, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> r4 = r9.javaAnalogueClassesWithCustomSupertypeCache
            kotlin.reflect.jvm.internal.impl.name.FqName r2 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(r2)
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getAdditionalFunctions$fakeJavaClassDescriptor$1 r5 = new kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer$getAdditionalFunctions$fakeJavaClassDescriptor$1
            r5.<init>(r0, r3)
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            java.lang.Object r0 = r4.computeIfAbsent(r2, r5)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r0 = r0.getUnsubstitutedMemberScope()
            java.lang.String r2 = "fakeJavaClassDescriptor.unsubstitutedMemberScope"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            java.lang.Object r11 = r11.invoke(r0)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r11 = r11.iterator()
        L_0x0095:
            boolean r2 = r11.hasNext()
            if (r2 == 0) goto L_0x0110
            java.lang.Object r2 = r11.next()
            r3 = r2
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor) r3
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r4 = r3.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r5 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION
            r6 = 1
            r7 = 0
            if (r4 == r5) goto L_0x00ae
        L_0x00ac:
            r6 = r7
            goto L_0x010a
        L_0x00ae:
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r4 = r3.getVisibility()
            boolean r4 = r4.isPublicAPI()
            if (r4 != 0) goto L_0x00b9
            goto L_0x00ac
        L_0x00b9:
            r4 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r4
            boolean r4 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isDeprecated(r4)
            if (r4 == 0) goto L_0x00c3
            goto L_0x00ac
        L_0x00c3:
            java.util.Collection r4 = r3.getOverriddenDescriptors()
            java.lang.String r5 = "analogueMember.overriddenDescriptors"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            boolean r5 = r4 instanceof java.util.Collection
            if (r5 == 0) goto L_0x00dd
            r5 = r4
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x00dd
        L_0x00db:
            r4 = r7
            goto L_0x0101
        L_0x00dd:
            java.util.Iterator r4 = r4.iterator()
        L_0x00e1:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00db
            java.lang.Object r5 = r4.next()
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r5
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r5 = r5.getContainingDeclaration()
            java.lang.String r8 = "it.containingDeclaration"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)
            kotlin.reflect.jvm.internal.impl.name.FqName r5 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getFqNameSafe(r5)
            boolean r5 = r1.contains(r5)
            if (r5 == 0) goto L_0x00e1
            r4 = r6
        L_0x0101:
            if (r4 == 0) goto L_0x0104
            goto L_0x00ac
        L_0x0104:
            boolean r3 = r9.isMutabilityViolation(r3, r10)
            if (r3 != 0) goto L_0x00ac
        L_0x010a:
            if (r6 == 0) goto L_0x0095
            r0.add(r2)
            goto L_0x0095
        L_0x0110:
            java.util.List r0 = (java.util.List) r0
            java.util.Collection r0 = (java.util.Collection) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.getAdditionalFunctions(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.jvm.functions.Function1):java.util.Collection");
    }

    private final SimpleFunctionDescriptor createCloneForArray(DeserializedClassDescriptor deserializedClassDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor) {
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder = simpleFunctionDescriptor.newCopyBuilder();
        newCopyBuilder.setOwner(deserializedClassDescriptor);
        newCopyBuilder.setVisibility(DescriptorVisibilities.PUBLIC);
        newCopyBuilder.setReturnType(deserializedClassDescriptor.getDefaultType());
        newCopyBuilder.setDispatchReceiverParameter(deserializedClassDescriptor.getThisAsReceiverParameter());
        Object build = newCopyBuilder.build();
        Intrinsics.checkNotNull(build);
        return (SimpleFunctionDescriptor) build;
    }

    private final boolean isMutabilityViolation(SimpleFunctionDescriptor simpleFunctionDescriptor, boolean z) {
        DeclarationDescriptor containingDeclaration = simpleFunctionDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 3, (Object) null);
        if (z ^ JvmBuiltInsSignatures.INSTANCE.getMUTABLE_METHOD_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, (ClassDescriptor) containingDeclaration, computeJvmDescriptor$default))) {
            return true;
        }
        Boolean ifAny = DFS.ifAny(CollectionsKt.listOf(simpleFunctionDescriptor), JvmBuiltInsCustomizer$isMutabilityViolation$1.INSTANCE, new JvmBuiltInsCustomizer$isMutabilityViolation$2(this));
        Intrinsics.checkNotNullExpressionValue(ifAny, "private fun SimpleFuncti…scriptor)\n        }\n    }");
        return ifAny.booleanValue();
    }

    private final JDKMemberStatus getJdkMethodStatus(FunctionDescriptor functionDescriptor) {
        DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        Object dfs = DFS.dfs(CollectionsKt.listOf((ClassDescriptor) containingDeclaration), new JvmBuiltInsCustomizer$getJdkMethodStatus$1(this), new JvmBuiltInsCustomizer$getJdkMethodStatus$2(MethodSignatureMappingKt.computeJvmDescriptor$default(functionDescriptor, false, false, 3, (Object) null), new Ref.ObjectRef()));
        Intrinsics.checkNotNullExpressionValue(dfs, "private fun FunctionDesc…ERED\n            })\n    }");
        return (JDKMemberStatus) dfs;
    }

    /* access modifiers changed from: private */
    public final LazyJavaClassDescriptor getJavaAnalogue(ClassDescriptor classDescriptor) {
        ClassId mapKotlinToJava;
        FqName asSingleFqName;
        if (KotlinBuiltIns.isAny(classDescriptor)) {
            return null;
        }
        DeclarationDescriptor declarationDescriptor = classDescriptor;
        if (!KotlinBuiltIns.isUnderKotlinPackage(declarationDescriptor)) {
            return null;
        }
        FqNameUnsafe fqNameUnsafe = DescriptorUtilsKt.getFqNameUnsafe(declarationDescriptor);
        if (!fqNameUnsafe.isSafe() || (mapKotlinToJava = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(fqNameUnsafe)) == null || (asSingleFqName = mapKotlinToJava.asSingleFqName()) == null) {
            return null;
        }
        ClassDescriptor resolveClassByFqName = DescriptorUtilKt.resolveClassByFqName(getSettings().getOwnerModuleDescriptor(), asSingleFqName, NoLookupLocation.FROM_BUILTINS);
        if (resolveClassByFqName instanceof LazyJavaClassDescriptor) {
            return (LazyJavaClassDescriptor) resolveClassByFqName;
        }
        return null;
    }

    public Collection<ClassConstructorDescriptor> getConstructors(ClassDescriptor classDescriptor) {
        boolean z;
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        if (classDescriptor.getKind() != ClassKind.CLASS || !getSettings().isAdditionalBuiltInsFeatureSupported()) {
            return CollectionsKt.emptyList();
        }
        LazyJavaClassDescriptor javaAnalogue = getJavaAnalogue(classDescriptor);
        if (javaAnalogue == null) {
            return CollectionsKt.emptyList();
        }
        ClassDescriptor mapJavaToKotlin$default = JavaToKotlinClassMapper.mapJavaToKotlin$default(this.j2kClassMapper, DescriptorUtilsKt.getFqNameSafe(javaAnalogue), FallbackBuiltIns.Companion.getInstance(), (Integer) null, 4, (Object) null);
        if (mapJavaToKotlin$default == null) {
            return CollectionsKt.emptyList();
        }
        ClassDescriptor classDescriptor2 = javaAnalogue;
        TypeSubstitutor buildSubstitutor = MappingUtilKt.createMappedTypeParametersSubstitution(mapJavaToKotlin$default, classDescriptor2).buildSubstitutor();
        Collection arrayList = new ArrayList();
        Iterator it = javaAnalogue.getConstructors().iterator();
        while (true) {
            boolean z2 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ClassConstructorDescriptor classConstructorDescriptor = (ClassConstructorDescriptor) next;
            if (classConstructorDescriptor.getVisibility().isPublicAPI()) {
                Collection<ClassConstructorDescriptor> constructors = mapJavaToKotlin$default.getConstructors();
                Intrinsics.checkNotNullExpressionValue(constructors, "defaultKotlinVersion.constructors");
                Iterable iterable = constructors;
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    Iterator it2 = iterable.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        ClassConstructorDescriptor classConstructorDescriptor2 = (ClassConstructorDescriptor) it2.next();
                        Intrinsics.checkNotNullExpressionValue(classConstructorDescriptor2, "it");
                        if (getConstructors$isEffectivelyTheSameAs(classConstructorDescriptor2, buildSubstitutor, classConstructorDescriptor)) {
                            z = false;
                            break;
                        }
                    }
                }
                z = true;
                if (z && !isTrivialCopyConstructorFor(classConstructorDescriptor, classDescriptor) && !KotlinBuiltIns.isDeprecated(classConstructorDescriptor) && !JvmBuiltInsSignatures.INSTANCE.getHIDDEN_CONSTRUCTOR_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, classDescriptor2, MethodSignatureMappingKt.computeJvmDescriptor$default(classConstructorDescriptor, false, false, 3, (Object) null)))) {
                    z2 = true;
                }
            }
            if (z2) {
                arrayList.add(next);
            }
        }
        Iterable<ClassConstructorDescriptor> iterable2 = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        for (ClassConstructorDescriptor classConstructorDescriptor3 : iterable2) {
            FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder = classConstructorDescriptor3.newCopyBuilder();
            newCopyBuilder.setOwner(classDescriptor);
            newCopyBuilder.setReturnType(classDescriptor.getDefaultType());
            newCopyBuilder.setPreserveSourceElement();
            newCopyBuilder.setSubstitution(buildSubstitutor.getSubstitution());
            if (!JvmBuiltInsSignatures.INSTANCE.getVISIBLE_CONSTRUCTOR_SIGNATURES().contains(MethodSignatureBuildingUtilsKt.signature(SignatureBuildingComponents.INSTANCE, classDescriptor2, MethodSignatureMappingKt.computeJvmDescriptor$default(classConstructorDescriptor3, false, false, 3, (Object) null)))) {
                newCopyBuilder.setAdditionalAnnotations(getNotConsideredDeprecation());
            }
            Object build = newCopyBuilder.build();
            Intrinsics.checkNotNull(build, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
            arrayList2.add((ClassConstructorDescriptor) build);
        }
        return (List) arrayList2;
    }

    private static final boolean getConstructors$isEffectivelyTheSameAs(ConstructorDescriptor constructorDescriptor, TypeSubstitutor typeSubstitutor, ConstructorDescriptor constructorDescriptor2) {
        return OverridingUtil.getBothWaysOverridability(constructorDescriptor, constructorDescriptor2.substitute(typeSubstitutor)) == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
    }

    public boolean isFunctionAvailable(ClassDescriptor classDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        Intrinsics.checkNotNullParameter(simpleFunctionDescriptor, "functionDescriptor");
        LazyJavaClassDescriptor javaAnalogue = getJavaAnalogue(classDescriptor);
        if (javaAnalogue == null || !simpleFunctionDescriptor.getAnnotations().hasAnnotation(PlatformDependentDeclarationFilterKt.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME())) {
            return true;
        }
        if (!getSettings().isAdditionalBuiltInsFeatureSupported()) {
            return false;
        }
        String computeJvmDescriptor$default = MethodSignatureMappingKt.computeJvmDescriptor$default(simpleFunctionDescriptor, false, false, 3, (Object) null);
        LazyJavaClassMemberScope unsubstitutedMemberScope = javaAnalogue.getUnsubstitutedMemberScope();
        Name name = simpleFunctionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "functionDescriptor.name");
        Iterable<SimpleFunctionDescriptor> contributedFunctions = unsubstitutedMemberScope.getContributedFunctions(name, NoLookupLocation.FROM_BUILTINS);
        if (!(contributedFunctions instanceof Collection) || !((Collection) contributedFunctions).isEmpty()) {
            for (SimpleFunctionDescriptor computeJvmDescriptor$default2 : contributedFunctions) {
                if (Intrinsics.areEqual((Object) MethodSignatureMappingKt.computeJvmDescriptor$default(computeJvmDescriptor$default2, false, false, 3, (Object) null), (Object) computeJvmDescriptor$default)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean isTrivialCopyConstructorFor(ConstructorDescriptor constructorDescriptor, ClassDescriptor classDescriptor) {
        if (constructorDescriptor.getValueParameters().size() == 1) {
            List<ValueParameterDescriptor> valueParameters = constructorDescriptor.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "valueParameters");
            ClassifierDescriptor declarationDescriptor = ((ValueParameterDescriptor) CollectionsKt.single(valueParameters)).getType().getConstructor().getDeclarationDescriptor();
            if (Intrinsics.areEqual((Object) declarationDescriptor != null ? DescriptorUtilsKt.getFqNameUnsafe(declarationDescriptor) : null, (Object) DescriptorUtilsKt.getFqNameUnsafe(classDescriptor))) {
                return true;
            }
        }
        return false;
    }
}
